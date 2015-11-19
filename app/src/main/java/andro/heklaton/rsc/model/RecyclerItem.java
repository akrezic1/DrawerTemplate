package andro.heklaton.rsc.model;

/**
 * Created by Andro on 11/18/2015.
 */
public class RecyclerItem {

    private String imageUrl;
    private String title;

    public RecyclerItem(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public RecyclerItem() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
