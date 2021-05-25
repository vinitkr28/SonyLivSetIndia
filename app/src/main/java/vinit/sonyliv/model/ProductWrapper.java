package vinit.sonyliv.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ProductWrapper {
    @SerializedName("products")
    @Expose
    private List<ProductBaseInfo> products = null;

    public List<ProductBaseInfo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBaseInfo> products) {
        this.products = products;
    }
}
