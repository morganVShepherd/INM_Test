package hire.morgan.controllers;

import facebook4j.Facebook;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import hire.morgan.constants.Constants;
import hire.morgan.entity.PostDetails;
import hire.morgan.entity.ResponseObj;
import hire.morgan.jdbcodbc.DbConnection;
import hire.morgan.jdbcodbc.PostSqlService;
import hire.morgan.main.Helper;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by morgan.shepherd
 */
public class FBFeedController {
    private PostSqlService postSqlService;
    private Facebook facebook;
    private String pageId;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FBFeedController.class);

    public void facebookRun() {

        try {
            postSqlService = new PostSqlService(DbConnection.getConnection());

            Date lastUpdateDate = Helper.convertDateFromString(postSqlService.queryAppData(Constants.UPDATED_DATE));
            //need to set the date we are working from so that we don't accidently miss any changes that happen while the code is running
            Date yesterday = Helper.getYesterday();
            this.setUpFb();
            List<PostDetails> postDetailsList = this.getPostDetails(lastUpdateDate, yesterday);

            //I decided to use a jdbc/odbc bridge because its more SQL query reliant
            for (PostDetails postDetails : postDetailsList) {
                try {
                    postDetails.setUpdatedDate(yesterday);
                    if(postSqlService.updatePost(postDetails)==0){
                        postSqlService.createPost(postDetails);
                    }
                } catch (Exception e) {
                   log.error(e.getMessage(), e);
                }
            }
            postSqlService.updateAppData(Constants.UPDATED_DATE, Helper.convertStringFromDate(yesterday));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    private ResponseList<Post> getFeed(Date lastDate) throws Exception{
        Reading reading = new Reading();
        reading.since(lastDate);
        ResponseList<Post> posts = facebook.getFeed(pageId, reading);
        return posts;
    }

    private void setUpFb() throws Exception{
        String appId = postSqlService.queryAppData(Constants.APP_ID);
        String appSecret =postSqlService.queryAppData(Constants.APP_SECRET);
        String accessToken = postSqlService.queryAppData(Constants.ACCESS_TOKEN);
        pageId = postSqlService.queryAppData(Constants.PAGE_ID);

        FBConnectController fbConnectController = new FBConnectController(appId,appSecret,accessToken);
        facebook = fbConnectController.getFacebook();
    }

    private int getReach() throws Exception{
        int pageViewiers= facebook.getPage(pageId).getLikes();
        return pageViewiers;
    }

    public List<PostDetails> getPostDetails(Date lastDate, Date now ) throws Exception{
        ResponseList<Post> posts = this.getFeed(lastDate);
        int reach = this.getReach();
        List<PostDetails> postDetails = new ArrayList<>();
        for(Post post : posts){
            postDetails.add(convertInfo(post, now,reach));
        }

        return postDetails;
    }

    private PostDetails convertInfo(Post post, Date now, int reach){
        PostDetails postDetails = new PostDetails();
        postDetails.setId(Long.parseLong(post.getId().substring(post.getId().indexOf("_")+1,post.getId().length())));
        postDetails.setParentId(Long.parseLong(post.getId().substring(0,post.getId().indexOf("_"))));
        postDetails.setCreatedDate(post.getCreatedTime());
        postDetails.setUpdatedDate(now);
        postDetails.setTypeFbPost(post.getType());
        postDetails.setContent(post.getMessage());
        postDetails.setHtml((post.getLink()==null)? null : post.getLink().toString());
        postDetails.setLikes(post.getLikes().size());
        postDetails.setShares((post.getSharesCount()==null)? 0:post.getSharesCount());
        postDetails.setComments(post.getComments().size());
        //postDetails.setImpressions(post.getProperties());
        postDetails.setReach(reach);
        postDetails.setEngagement(postDetails.getLikes()+postDetails.getShares()+postDetails.getComments());
        //postDetails.setEngagers(post.getEgagers);
        return postDetails;
    }
    public ResponseObj getJasonData(){
        try {
            PostSqlService postSqlService = new PostSqlService(DbConnection.getConnection());
            List<PostDetails> data = postSqlService.getPostData();
            ResponseObj responseObj = new ResponseObj(data);
            return responseObj;
        }
        catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
    }


/*
        protected HttpEntity getHttpEntity() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "OAuth" + postSqlService.queryAppData(Constants.ACCESS_TOKEN));
        headers.add("content-type", "application/json");
        return new HttpEntity(headers);
    }


    private ResponseObject getDetails(Object o) throws JsonProcessingException {
        ResponseObject responseObject = new ResponseObject();
        HttpEntity httpEntity = getHttpEntity();
        String url = getFbRequestUrl(pageId).toString();
        try {
            responseObject = restTemplate.postForObject(url, httpEntity, Object.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseObject;
    }


    private StringBuilder getFbRequestUrl(String pageId) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("graph.facebook.com/pageId/photos");
        urlBuilder.append("/");
        return urlBuilder;
    }

 */




}
