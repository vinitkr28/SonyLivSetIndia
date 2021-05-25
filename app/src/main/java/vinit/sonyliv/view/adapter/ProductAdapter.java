/**
 * Created by Vinit on 25/05/2021.
 */

package vinit.sonyliv.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vinit.sonyliv.R;
import vinit.sonyliv.model.ProductBaseInfo;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.BaseViewHolder> {
    private static final String TAG = "ProductAdapter";
    private List<ProductBaseInfo> productList;
    public ProductAdapter(List<ProductBaseInfo> productList) {
        this.productList = productList;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, parent.getContext());

        /*view.setOnClickListener(v -> {
            Log.d(TAG, "onCreateViewHolder: " + productList.get(po));
        });*/


        // On clicking RecyclerView row item
        viewHolder.itemView.setOnClickListener(v -> {
            int pos = viewHolder.getAdapterPosition();
            if(pos >= 0 && productList.size() > pos){
            Log.d(TAG, "onCreateViewHolder: " + pos);
            Log.d(TAG, "onCreateViewHolder: " + productList.get(pos));

            // redirect to the browser or Flipkart app
                // add code to check intent.resolveActivity
            Uri uri = Uri.parse(productList.get(pos).getProduct().getProductUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            parent.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }
    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        if (productList != null && productList.size() > 0) {
            return productList.size();
        } else {
            return 0;
        }
    }
    public class ViewHolder extends BaseViewHolder {
        Context context;

        TextView txtName;
        TextView txtDesc;
        ImageView imageView;

        public ViewHolder(View itemView, Context context) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtDesc = itemView.findViewById(R.id.txt_desc);
            imageView = itemView.findViewById(R.id.imageView);

            this.context = context;
        }
        protected void clear() {
            txtName.setText("");
            txtDesc.setText("");
        }
        public void onBind(int position) {
            super.onBind(position);
            final ProductBaseInfo product = productList.get(position);

            if (product.getProduct().getTitle() != null) {
                txtName.setText(product.getProduct().getTitle());
            }
            if (product.getProduct().getProductDescription() != null) {
                txtDesc.setText(product.getProduct().getProductDescription());
            }
            if (product.getProduct().getImageUrls() != null) {
                //used glide to populate image
                Glide.with(context)
                        .load(product.getProduct().getImageUrls().getUrl400()).centerInside()
//                        .override(500, 758)
                        .into(imageView);

                Log.d(TAG, "onBind: " + context + ", ImageUrls: " + product.getProduct().getImageUrls().getUrl800());
//                Glide.with(context)
//                        .load(product.getProduct().getImageUrls().getUrl800())
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .thumbnail(0.1f)
//                        .into(imageView);

//                imageView.setText(product.getProduct().getProductId());
            }

        }
    }

    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        private int mCurrentPosition;
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
        protected abstract void clear();
        public void onBind(int position) {
            mCurrentPosition = position;
            clear();
        }
        public int getCurrentPosition() {
            return mCurrentPosition;
        }
    }
}