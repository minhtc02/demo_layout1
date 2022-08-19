package com.example.demo_layout1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_layout1.databinding.ItemSelectPhotoBinding;
import com.example.demo_layout1.model.PhotoGallery;

import java.util.List;

public class PhotoSelectAdapter extends RecyclerView.Adapter<PhotoSelectAdapter.ViewHolder> {
    private List<PhotoGallery> list;
    private Context context;


    public PhotoSelectAdapter(List<PhotoGallery> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSelectPhotoBinding binding = ItemSelectPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemSelectPhotoBinding binding;

        public ViewHolder(ItemSelectPhotoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(PhotoGallery photoGallery) {

            int drawableId = context.getResources().getIdentifier(photoGallery.getName(), "drawable", context.getPackageName());
            binding.imgSelectPhoto.setImageResource(drawableId);
            binding.imgSelectPhoto.setOnClickListener(v -> {
            });
            binding.btnDelete.setOnClickListener(v -> {

            });
        }
    }
}
