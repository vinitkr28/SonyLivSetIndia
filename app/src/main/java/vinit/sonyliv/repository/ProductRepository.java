package vinit.sonyliv.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinit.sonyliv.model.ProductBaseInfo;
import vinit.sonyliv.model.ProductWrapper;
import vinit.sonyliv.network.RestApiService;
import vinit.sonyliv.network.RetrofitInstance;

public class ProductRepository {
    private static final String TAG = "ProductRepository";
    private ArrayList<ProductBaseInfo> products = new ArrayList<>();
    private MutableLiveData<List<ProductBaseInfo>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    public ProductRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<ProductBaseInfo>> getMutableLiveData(String searchKey) {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<ProductWrapper> call = apiService.getProducts(searchKey);

        call.enqueue(new Callback<ProductWrapper>() {
            @Override
            public void onResponse(Call<ProductWrapper> call, Response<ProductWrapper> response) {
                Log.d(TAG, "onResponse::response.body().toString: " + response.body().toString());

                ProductWrapper productWrapper = response.body();
                if (productWrapper != null && productWrapper.getProducts() != null && productWrapper.getProducts().size() > 0) {
                    products = (ArrayList<ProductBaseInfo>) productWrapper.getProducts();
                    //set value to mutable data
                    mutableLiveData.setValue(products);
                }
            }
            @Override
            public void onFailure(Call<ProductWrapper> call, Throwable t) {

                // Handle error scenario
                Log.d("ListSize"," - > Error    "+ t.getMessage());
            }
        });

        return mutableLiveData;

    }

}
