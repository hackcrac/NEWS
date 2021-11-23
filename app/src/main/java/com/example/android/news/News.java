package com.example.android.news;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class News {
    private final String title;
    private final String imageToUrl;

    public News(String title, String imageToUrl) {
        this.title = title;
        this.imageToUrl = imageToUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageToUrl() {
        return imageToUrl;
    }

    @BindingAdapter("android:loadImage")
    public static void getImage(ImageView imageView , String imageToUrl){
        Glide.with(imageView).load(imageToUrl).centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground).into(imageView);
    }
}
