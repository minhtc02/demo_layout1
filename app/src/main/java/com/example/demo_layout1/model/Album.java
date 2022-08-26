package com.example.demo_layout1.model;

public class Album {
    private String imgName;
    private String imgAlbum;
    private  boolean isSelected;

    public Album(String imgName, String imgAlbum, boolean isSelected) {
        this.imgName = imgName;
        this.imgAlbum = imgAlbum;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgAlbum() {
        return imgAlbum;
    }

    public void setImgAlbum(String imgAlbum) {
        this.imgAlbum = imgAlbum;
    }
}
