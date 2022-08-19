package com.example.demo_layout1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_layout1.databinding.ItemGalleryBinding;
import com.example.demo_layout1.interfaces.PhotoGalleryClick;
import com.example.demo_layout1.model.PhotoGallery;

import java.util.List;

public class PhotoGalleryAdapter extends RecyclerView.Adapter<PhotoGalleryAdapter.ViewHolder> {
    private List<PhotoGallery> list;
    private final Context context;
    private PhotoGalleryClick photoGalleryClick;

    public PhotoGalleryAdapter(List<PhotoGallery> list, Context context, PhotoGalleryClick photoGalleryClick) {
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
        holder.bindData(list.get(position), position);

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

        public void bindData(PhotoGallery photoGallery, int position) {
            int drawableId = context.getResources().getIdentifier(photoGallery.getName(), "drawable", context.getPackageName());
            binding.imgGallery.setImageResource(drawableId);
            if (!photoGallery.isSelected()) {
                binding.btnDelete.setVisibility(View.INVISIBLE);
                binding.imgGallery.setImageAlpha(255);
            } else {
                binding.imgGallery.setImageAlpha(80);
                binding.btnDelete.setVisibility(View.VISIBLE);
            }
            binding.imgGallery.setOnClickListener(v -> {
                if (position == 0) {
                    photoGalleryClick.openCameraPhotoGallery();
                } else {
                    photoGalleryClick.selectPhotoGallery(photoGallery);

                }
            });
            binding.btnDelete.setOnClickListener(v -> photoGalleryClick.deletePhotoGallery(photoGallery));
        }
    }
}
