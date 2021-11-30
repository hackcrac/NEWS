package com.example.android.news;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class News {
    private final String title;
    private final String urlToImage;

    public News(String title, String urlToImage) {
        this.title = title;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    @BindingAdapter("android:loadImage")
    public static void getImage(ImageView imageView , String imageToUrl){
        Glide.with(imageView).load(imageToUrl).centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground).into(imageView);
    }
}
