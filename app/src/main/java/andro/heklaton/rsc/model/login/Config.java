package andro.heklaton.rsc.model.login;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "UserConfig")
public class Config extends Model {

    @Column(name = "PostCategories")
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