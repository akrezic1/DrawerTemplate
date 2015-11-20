package andro.heklaton.rsc.model.login;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("post_categories")
    @Expose
    private List<PostCategory> postCategories = new ArrayList<PostCategory>();

    /**
     *
     * @return
     * The postCategories
     */
    public List<PostCategory> getPostCategories() {
        return postCategories;
    }

    /**
     *
     * @param postCategories
     * The post_categories
     */
    public void setPostCategories(List<PostCategory> postCategories) {
        this.postCategories = postCategories;
    }

}