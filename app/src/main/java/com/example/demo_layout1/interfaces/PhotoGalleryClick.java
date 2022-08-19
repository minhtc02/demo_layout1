package com.example.demo_layout1.interfaces;

import com.example.demo_layout1.model.PhotoGallery;

import java.util.List;

public interface PhotoGalleryClick {

    void deletePhotoGallery(PhotoGallery photoGallery);
    void selectPhotoGallery(PhotoGallery photoGallery);
    void openCameraPhotoGallery();
}
