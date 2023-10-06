package com.example.cs2340c_team38.views;

import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class BindingAdapters {
    @BindingAdapter("drawableImage")
    public static void setDrawableImage(ImageView imageView, int drawableResourceId) {
        imageView.setImageResource(drawableResourceId);

    }
}
