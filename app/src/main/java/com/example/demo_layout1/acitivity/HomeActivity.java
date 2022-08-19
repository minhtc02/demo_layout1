package com.example.demo_layout1.acitivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.demo_layout1.ListPhoto;
import com.example.demo_layout1.adapter.TopTemplateAdpater;
import com.example.demo_layout1.databinding.ActivityHomeBinding;
import com.example.demo_layout1.model.PhotoGallery;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    TopTemplateAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initlizeView();
        setClick();
    }

    @Override
    public void onBackPressed() {
        // alertdialog for exit the app
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set the title of the Alert Dialog
        alertDialogBuilder.setTitle("THOÁT");

        // set dialog message
        alertDialogBuilder.setMessage("Bạn có chắc muốn thoát?").setCancelable(false).setPositiveButton("YES", (dialog, which) -> {
            finishAffinity();
            System.exit(0);
        }).setNegativeButton("CANCEL",
                (dialog, id) -> {
                    // code to do on CANCEL tapped
                    dialog.cancel();
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void initlizeView() {
        for (int i = 0; i < 100; i++) {
            ListPhoto.listPhotoTemplate.add(new PhotoGallery(String.valueOf(i), "img_template1", false));
        }
        adpater = new TopTemplateAdpater(ListPhoto.listPhotoTemplate, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        binding.rcv.setAdapter(adpater);
        binding.rcv.setLayoutManager(gridLayoutManager);
    }

    private void setClick() {
        binding.imgGrids.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PhotoGalleryActivity.class);
            startActivity(intent);
        });
        binding.grid1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Grid1Activity.class);
            startActivity(intent);
        });
    }

}