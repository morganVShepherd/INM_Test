package hire.morgan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

/**
 * Created by morgan.shepherd
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "parentid",
        "createdDate",
        "updatedDate",
        "typeFbPost",
        "content",
        "html",
        "likes",
        "shares",
        "comments",
        "impressions",
        "reach",
        "engagement",
        "engagers"
})

public class PostDetails {

    @JsonProperty("id")
    private long id;
    @JsonProperty("parentId")
    private long parentId;
    @JsonProperty("createdDate")
    private Date createdDate;
    @JsonProperty("updatedDate")
    private Date updatedDate;
    @JsonProperty("typeFbPost")
    private String typeFbPost;
    @JsonProperty("content")
    private String content;
    @JsonProperty("html")
    private String html;
    @JsonProperty("likes")
    private int likes;
    @JsonProperty("shares")
    private int shares;
    @JsonProperty("comments")
    private int comments;
    @JsonProperty("impressions")
    private int impressions;
    @JsonProperty("reach")
    private int reach;
    @JsonProperty("engagement")
    private int engagement;
    @JsonProperty("engagers")
    private int engagers;


    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("parentId")
    public long getParentId() {
        return parentId;
    }

    @JsonProperty("parentId")
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("typeFbPost")
    public String getTypeFbPost() {
        return typeFbPost;
    }

    @JsonProperty("typeFbPost")
    public void setTypeFbPost(String typeFbPost) {
        this.typeFbPost = typeFbPost;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("likes")
    public int getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(int likes) {
        this.likes = likes;
    }

    @JsonProperty("shares")
    public int getShares() {
        return shares;
    }

    @JsonProperty("shares")
    public void setShares(int shares) {
        this.shares = shares;
    }

    @JsonProperty("comments")
    public int getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(int comments) {
        this.comments = comments;
    }

    @JsonProperty("impressions")
    public int getImpressions() {
        return impressions;
    }

    @JsonProperty("impressions")
    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    @JsonProperty("reach")
    public int getReach() {
        return reach;
    }

    @JsonProperty("reach")
    public void setReach(int reach) {
        this.reach = reach;
    }

    @JsonProperty("engagement")
    public int getEngagement() {
        return engagement;
    }

    @JsonProperty("engagement")
    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }

    @JsonProperty("engagers")
    public int getEngagers() {
        return engagers;
    }

    @JsonProperty("engagers")
    public void setEngagers(int engagers) {
        this.engagers = engagers;
    }

    @JsonProperty("createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("updatedDate")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updatedDate")
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDetails{");
        sb.append("id=").append(id);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", typeFbPost='").append(typeFbPost).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", html='").append(html).append('\'');
        sb.append(", likes=").append(likes);
        sb.append(", shares=").append(shares);
        sb.append(", comments=").append(comments);
        sb.append(", impressions=").append(impressions);
        sb.append(", reach=").append(reach);
        sb.append(", engagement=").append(engagement);
        sb.append(", engagers=").append(engagers);
        sb.append('}');
        return sb.toString();
    }
}
