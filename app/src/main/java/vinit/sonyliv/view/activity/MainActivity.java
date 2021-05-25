package vinit.sonyliv.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.List;

import vinit.sonyliv.R;
import vinit.sonyliv.model.ProductBaseInfo;
import vinit.sonyliv.view.adapter.ProductAdapter;
import vinit.sonyliv.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

//        getUserList();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        MenuItem mSearchmenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) mSearchmenuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Enter Text");
        searchView.setOnQueryTextListener(this  );
        Log.d(TAG, "onCreateOptionsMenu: mSearchmenuItem->" + mSearchmenuItem.getActionView());
        return true;
    }

    public void getUserList(String searchKey) {
        mainViewModel.getSearchedProduct(searchKey).observe(this, new Observer<List<ProductBaseInfo>>() {
            @Override
            public void onChanged(@Nullable List<ProductBaseInfo> productList) {
                setRecyclerView(productList);
            }
        });

    }
    private void setRecyclerView(List<ProductBaseInfo> productList) {
        productAdapter = new ProductAdapter(productList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        //search only when the interned characters > 3
        Log.d(TAG, "onQueryTextSubmit: " + query);
        if (query.length() > 3)
            getUserList(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}