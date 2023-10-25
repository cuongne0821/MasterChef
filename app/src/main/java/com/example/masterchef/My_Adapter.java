package com.example.masterchef;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class My_Adapter extends  RecyclerView.Adapter<My_Adapter.ViewHolder>{
    private List<Mydata> dataList;

    public My_Adapter(List<Mydata> dataList) {
        this.dataList = dataList;
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }



    @NonNull
    @Override
    public My_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Adapter.ViewHolder holder, int position) {
        Mydata data = dataList.get(position);
        holder.nameTextView.setText(data.getTen());
        // Sử dụng Glide để tải và hiển thị hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(data.getImage())
                .into(holder.imageView);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_ten);
            imageView = itemView.findViewById(R.id.imgview);
        }
    }



}
