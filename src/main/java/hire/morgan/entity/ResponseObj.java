package hire.morgan.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by morgan.shepherd
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "postsDetails"

})
public class ResponseObj {



    @JsonProperty("postsDetails")
    private List<PostDetails> postsDetails;

    public ResponseObj(List<PostDetails> postsDetails){
        this.postsDetails = postsDetails;
    }

    @JsonProperty("postsDetails")
    public List<PostDetails> getPostsDetails() {
        return postsDetails;
    }
    @JsonProperty("postsDetails")
    public void setPostsDetails(List<PostDetails> postsDetails) {
        this.postsDetails = postsDetails;
    }
}
