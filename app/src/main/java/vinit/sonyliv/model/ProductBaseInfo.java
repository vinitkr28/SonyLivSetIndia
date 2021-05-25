package vinit.sonyliv.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductBaseInfo {
    @SerializedName("productBaseInfoV1")
    @Expose
    private vinit.setindia.model.Product product;

    public vinit.setindia.model.Product getProduct() {
        return product;
    }

    public void setProduct(vinit.setindia.model.Product product) {
        this.product = product;
    }
}
