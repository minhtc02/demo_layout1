package com.example.demo_layout1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo_layout1.databinding.ItemTemplateBinding;
import com.example.demo_layout1.model.PhotoGallery;

import java.util.List;

public class TopTemplateAdpater extends RecyclerView.Adapter<TopTemplateAdpater.ViewHolder> {
    private List<PhotoGallery> list;
    private Context context;

    public TopTemplateAdpater(List<PhotoGallery> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTemplateBinding binding = ItemTemplateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        ItemTemplateBinding binding;

        public ViewHolder(ItemTemplateBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(PhotoGallery photoGallery) {
            int drawableId = context.getResources().getIdentifier(photoGallery.getName(), "drawable", context.getPackageName());
            binding.imgTemplate.setImageResource(drawableId);
        }
    }
}
