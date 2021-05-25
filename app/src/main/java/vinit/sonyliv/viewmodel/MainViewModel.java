package vinit.sonyliv.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vinit.sonyliv.model.ProductBaseInfo;
import vinit.sonyliv.repository.ProductRepository;

public class MainViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
    }
    public LiveData<List<ProductBaseInfo>> getSearchedProduct(String searchKey) {
        return productRepository.getMutableLiveData(searchKey);
    }
}
