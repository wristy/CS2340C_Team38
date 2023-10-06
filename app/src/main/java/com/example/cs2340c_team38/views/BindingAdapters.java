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

    @BindingAdapter("checkedButtonAttrChanged")
    public static void setListeners(RadioGroup radioGroup, final InverseBindingListener listener) {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (listener != null) {
                listener.onChange();
            }
        });
    }

    @InverseBindingAdapter(attribute = "checkedButtonAttrChanged", event = "checkedButtonAttrChanged")
    public static int getCheckedRadioButtonId(RadioGroup radioGroup) {
        return radioGroup.getCheckedRadioButtonId();
    }

    @BindingAdapter("android:checkedButton")
    public static void setCheckedRadioButtonId(RadioGroup group, int id) {
        if (id != -1 && id != group.getCheckedRadioButtonId()) {
            group.check(id);
        }
    }

}
