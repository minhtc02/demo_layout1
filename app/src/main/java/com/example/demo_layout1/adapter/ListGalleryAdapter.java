package com.example.demo_layout1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo_layout1.databinding.ItemGalleryBinding;
import com.example.demo_layout1.databinding.ItemRecGalleryBinding;
import com.example.demo_layout1.interfaces.PhotoGalleryClick;

import java.util.List;

public class ListGalleryAdapter extends RecyclerView.Adapter<ListGalleryAdapter.ViewHolder> {
    private List<String> list;
    private final Context context;
    private final PhotoGalleryClick photoGalleryClick;

    public ListGalleryAdapter(List<String> list, Context context, PhotoGalleryClick photoGalleryClick) {
        this.list = list;
        this.context = context;
        this.photoGalleryClick = photoGalleryClick;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecGalleryBinding binding = ItemRecGalleryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        ItemRecGalleryBinding binding;

        public ViewHolder(ItemRecGalleryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String s) {
            binding.tvName.setText(s);
            binding.tvName.setOnClickListener(v -> photoGalleryClick.loadImageAlbum(s));
        }
    }
}
