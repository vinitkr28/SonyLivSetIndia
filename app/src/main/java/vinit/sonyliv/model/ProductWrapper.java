package vinit.sonyliv.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ProductWrapper {
    @SerializedName("products")
    @Expose
    private List<vinit.setindia.model.ProductBaseInfo> products = null;

    public List<vinit.setindia.model.ProductBaseInfo> getProducts() {
        return products;
    }

    public void setProducts(List<vinit.setindia.model.ProductBaseInfo> products) {
        this.products = products;
    }
}
