package vinit.sonyliv.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductBaseInfo {
    @SerializedName("productBaseInfoV1")
    @Expose
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
