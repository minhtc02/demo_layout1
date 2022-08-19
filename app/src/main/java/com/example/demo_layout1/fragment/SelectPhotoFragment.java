package com.example.demo_layout1.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo_layout1.R;
import com.example.demo_layout1.databinding.FragmentSelectPhotoBinding;

public class SelectPhotoFragment extends Fragment {
    FragmentSelectPhotoBinding binding;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSelectPhotoBinding.inflate(inflater);
        View view = binding.getRoot();
        return view;
    }
}