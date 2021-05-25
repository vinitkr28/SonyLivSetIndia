package vinit.sonyliv.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("productId")
    private String productId;
    @SerializedName("title")
    private String title;
    @SerializedName("productDescription")
    private String productDescription;
    @SerializedName("imageUrls")
    private ImageUrl imageUrls;
    @SerializedName("productUrl")
    private String productUrl;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ImageUrl getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ImageUrl imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
