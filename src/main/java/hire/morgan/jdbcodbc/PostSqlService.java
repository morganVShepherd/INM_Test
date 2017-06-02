package hire.morgan.jdbcodbc;



import hire.morgan.entity.PostDetails;
import hire.morgan.main.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by morgan.shepherd
 */
public class PostSqlService {

    private Connection conn;
    //SQL queries
    private final String appDataQuery = "Select value from app_data where name = ?";
    private final String updateAppData = "update app_data set value = ? where name = ?";
    private final String inserDetailsQuery = "insert into post_details(post_detail_id ," +
            "created_date,\n" +
            "updated_date,\n" +
            "type_fb_post,\n" +
            "content,\n" +
            "html,\n" +
            "likes,\n" +
            "shares,\n" +
            "comments,\n" +
            "impressions,\n" +
            "reach,\n" +
            "engagement,\n" +
            "engagers, " +
            "parent_id " +
            ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String updatePostDetailsQuery= "update post_details set\n" +
            "updated_date =?,\n" +
            "likes = ?,\n" +
            "shares = ?,\n" +
            "comments = ?,\n" +
            "impressions = ?,\n" +
            "reach = ?,\n" +
            "engagement =?,\n" +
            "engagers =?\n" +
            "where post_detail_id  = ?";

    private final String selectAllDataQuery = "select post_detail_id ,\n" +
            "created_date,\n" +
            "updated_date,\n" +
            "type_fb_post,\n" +
            "content,\n" +
            "html,\n" +
            "likes,\n" +
            "shares,\n" +
            "comments,\n" +
            "impressions,\n" +
            "reach,\n" +
            "engagement,\n" +
            "engagers " +
            "parent_id " +
            "from post_details";



    public PostSqlService(Connection conn){
        this.conn=conn;
    }

    public String queryAppData(String name) throws Exception{
        PreparedStatement preps = conn.prepareStatement(appDataQuery);
        preps.setString(1,name);
        ResultSet rs = preps.executeQuery();
        while(rs.next()){
            return rs.getString("value");
        }
        return null;

    }

    public void updateAppData(String name, String value) throws Exception{
        PreparedStatement preps = conn.prepareStatement(updateAppData);
        preps.setString(1,value);
        preps.setString(2,name);
        preps.executeUpdate();
    }

    public int updatePost(PostDetails postDetails) throws Exception{
        PreparedStatement preps = conn.prepareStatement(updatePostDetailsQuery);
        preps.setTimestamp(1,new java.sql.Timestamp(postDetails.getUpdatedDate().getTime()));
        preps.setInt(2,postDetails.getLikes());
        preps.setInt(3,postDetails.getShares());
        preps.setInt(4,postDetails.getComments());
        preps.setInt(5,postDetails.getImpressions());
        preps.setInt(6,postDetails.getReach());
        preps.setInt(7,postDetails.getEngagement());
        preps.setInt(8,postDetails.getEngagers());
        preps.setLong(9,postDetails.getId());
        return preps.executeUpdate();
    }

    public void createPost(PostDetails postDetails) throws Exception{
        PreparedStatement preps = conn.prepareStatement(inserDetailsQuery);
        preps.setLong(1,postDetails.getId());
        preps.setTimestamp(2,new java.sql.Timestamp(postDetails.getCreatedDate().getTime()));
        preps.setTimestamp(3,new java.sql.Timestamp(postDetails.getUpdatedDate().getTime()));
        preps.setString(4,postDetails.getTypeFbPost());
        preps.setString(5,postDetails.getContent());
        preps.setString(6,postDetails.getHtml());
        preps.setInt(7,postDetails.getLikes());
        preps.setInt(8,postDetails.getShares());
        preps.setInt(9,postDetails.getComments());
        preps.setInt(10,postDetails.getImpressions());
        preps.setInt(11,postDetails.getReach());
        preps.setInt(12,postDetails.getEngagement());
        preps.setInt(13,postDetails.getEngagers());
        preps.setLong(14,postDetails.getParentId());
        preps.executeUpdate();
    }

    public List<PostDetails> getPostData() throws Exception{
        PreparedStatement preps = conn.prepareStatement(selectAllDataQuery);
        ResultSet rs = preps.executeQuery();
        List<PostDetails> postDetailsList = new ArrayList<>();
        while(rs.next()){
            PostDetails postDetails = new PostDetails();
            postDetails.setId(rs.getLong("id"));
            postDetails.setCreatedDate(Helper.convertDateFromString(rs.getString("created_date")));
            postDetails.setUpdatedDate(Helper.convertDateFromString(rs.getString("updated_date")));
            postDetails.setTypeFbPost(rs.getString("type_fb_post"));
            postDetails.setContent(rs.getString("content"));
            postDetails.setHtml(rs.getString("html"));
            postDetails.setLikes(rs.getInt("likes"));
            postDetails.setShares(rs.getInt("shares"));
            postDetails.setComments(rs.getInt("comments"));
            postDetails.setImpressions(rs.getInt("impressions"));
            postDetails.setReach(rs.getInt("reach"));
            postDetails.setEngagement(rs.getInt("engagement"));
            postDetails.setEngagers(rs.getInt("engagers"));
            postDetails.setParentId(rs.getInt("parent_id"));
            postDetailsList.add(postDetails);

        }
        return postDetailsList;
    }
}
