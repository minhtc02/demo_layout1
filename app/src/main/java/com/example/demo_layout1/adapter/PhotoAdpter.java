package com.example.demo_layout1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo_layout1.databinding.ItemGalleryBinding;
import com.example.demo_layout1.interfaces.PhotoGalleryClick;

import java.util.List;

public class PhotoAdpter extends RecyclerView.Adapter<PhotoAdpter.ViewHolder> {
    private List<String> list;
    private final Context context;
    private final PhotoGalleryClick photoGalleryClick;

    public PhotoAdpter(List<String> list, Context context, PhotoGalleryClick photoGalleryClick) {
        this.list = list;
        this.context = context;
        this.photoGalleryClick = photoGalleryClick;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGalleryBinding binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        ItemGalleryBinding binding;

        public ViewHolder(ItemGalleryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String s) {
            Glide.with(context).asBitmap()
                    .load(s)
                    .into(binding.imgGallery);
        }
    }
}
