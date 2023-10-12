package com.example.cs2340c_team38.views;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
    @BindingAdapter("drawableImage")
    public static void setDrawableImage(ImageView imageView, int drawableResourceId) {
        imageView.setImageResource(drawableResourceId);

    }
}
