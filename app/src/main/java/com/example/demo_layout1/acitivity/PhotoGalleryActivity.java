package com.example.demo_layout1.acitivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.demo_layout1.ListPhoto;
import com.example.demo_layout1.R;
import com.example.demo_layout1.adapter.PhotoAdpter;
import com.example.demo_layout1.adapter.PhotoGalleryAdapter;
import com.example.demo_layout1.databinding.ActivityPhotoGalleryBinding;
import com.example.demo_layout1.help.Constant;
import com.example.demo_layout1.interfaces.PhotoGalleryClick;
import com.example.demo_layout1.model.PhotoGallery;

import java.util.ArrayList;

public class PhotoGalleryActivity extends AppCompatActivity implements PhotoGalleryClick {
    ActivityPhotoGalleryBinding binding;
    PhotoGalleryAdapter photoGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotoGalleryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //updateView();
        initializeView();
        setClick();

    }

    public void deleteAll(View view) {
        for (int i = 0; i < ListPhoto.listPhotoGallery.size(); i++) {
            ListPhoto.listPhotoGallery.get(i).setSelected(false);
        }
        ListPhoto.listPhotoGallery.removeAll(ListPhoto.listPhotoGallerySelect);
        ListPhoto.listPhotoGallerySelect.clear();
        updateView();
        photoGalleryAdapter.notifyDataSetChanged();
    }

    @Override
    public void selectPhotoGallery(PhotoGallery photoGallery) {
        if (photoGallery.isSelected()) {
            photoGallery.setSelected(false);
            ListPhoto.listPhotoGallerySelect.remove(photoGallery);
        } else {
            photoGallery.setSelected(true);
            ListPhoto.listPhotoGallerySelect.add(photoGallery);
        }
        updateView();
        photoGalleryAdapter.notifyDataSetChanged();

    }

    @Override
    public void openCameraPhotoGallery() {
        if (haveCameraPermission()) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, Constant.CAMERA_REQUEST_CODE);
        } else {
            requestPermissions(Constant.PERMISSION, Constant.CAMERA_REQUEST_CODE);
        }
    }

    private void initializeView() {
        if (haveStoragePermission()) {
            String[] projection = {
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATA,
            };
            Cursor cur = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
            ArrayList<String> pathNameList = new ArrayList<>();
            if (cur.getCount() > 0) {
                cur.moveToFirst();
                while (!cur.isAfterLast()) {
                    @SuppressLint("Range")
                    String data = cur.getString(cur.getColumnIndex(MediaStore.Images.Media.DATA));
                    pathNameList.add(data);
                    cur.moveToNext();
                }
                cur.close();
            }
            PhotoAdpter photoAdpter = new PhotoAdpter(pathNameList, this, this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            binding.recPhotoGallery.setAdapter(photoAdpter);
            binding.recPhotoGallery.setLayoutManager(gridLayoutManager);
            Log.d("AAA", "size: " + pathNameList.size());
        } else {
            requestPermissions(Constant.PERMISSION, Constant.STORAGE_REQUEST_CODE);
        }
    }

    private boolean haveCameraPermission() {
        int result = ContextCompat.checkSelfPermission(this, Constant.CAMERA_PERMISSTION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private boolean haveStoragePermission() {
        int result = ContextCompat.checkSelfPermission(this, Constant.STRORAGE_PERMISSTION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.CAMERA_REQUEST_CODE) {
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    //result = false;
                    Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (requestCode == Constant.STORAGE_REQUEST_CODE) {
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    //result = false;
                    Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void deletePhotoGallery(PhotoGallery photoGallery) {
        photoGallery.setSelected(false);
        ListPhoto.listPhotoGallerySelect.remove(photoGallery);
        ListPhoto.listPhotoGallery.remove(photoGallery);
        updateView();
        photoGalleryAdapter.notifyDataSetChanged();

    }

    private void updateView() {
        if (ListPhoto.listPhotoGallerySelect.size() == 0) {
            binding.btnNext.setBackground(getDrawable(R.drawable.border_text_next_off));
            binding.btnNext.setTextColor(getColor(R.color.color_AAADA7));
        } else {
            binding.btnNext.setBackground(getDrawable(R.drawable.border_text_next_on));
            binding.btnNext.setTextColor(getColor(R.color.color_A65C0A));
        }
    }

    private void setClick() {
        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(PhotoGalleryActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}