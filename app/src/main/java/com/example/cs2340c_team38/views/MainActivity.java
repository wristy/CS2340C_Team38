package com.example.cs2340c_team38.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityMainBinding;
import com.example.cs2340c_team38.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main
        );
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getStartEvent().observe(this, message -> startActivity(
                new Intent(MainActivity.this, ConfigActivity.class)
        ));
        viewModel.getEndEvent().observe(this, message -> this.finishAffinity());
    }
}