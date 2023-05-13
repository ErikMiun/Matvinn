package com.example.matvinn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleVievAdapter extends RecyclerView.Adapter<RecycleVievAdapter.MyViewHolder> {

    List<Product> productList;
    Context context;

    public RecycleVievAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_productName.setText(productList.get(position).getName());
        holder.tv_expiryDate.setText(String.valueOf(productList.get(position).getExpiryDate()));
        Glide.with(this.context).load(productList.get(position).getImgURL()).into(holder.iv_productImage);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_productImage;
        TextView tv_productName;
        TextView tv_expiryDate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_productImage = itemView.findViewById(R.id.iv_productImage);
            tv_productName = itemView.findViewById(R.id.tv_productName);
            tv_expiryDate = itemView.findViewById(R.id.tv_expiryDate);

        }
    }
}
