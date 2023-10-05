package com.example.cs2340c_team38;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cs2340c_team38.databinding.ActivityMainBinding;
import com.example.cs2340c_team38.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      ActivityMainBinding binding;
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
      viewModel = new ViewModelProvider(this).get(MainViewModel.class);
      binding.setViewModel(viewModel);

      viewModel.getStartEvent().observe(this, message -> {
            Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(intent);
      });
    }
}

//public class MainActivity extends AppCompatActivity { // welcome screen
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button buttonStart = (Button) findViewById(R.id.buttonStart);
//
//
//        buttonStart.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        Button buttonExit = (Button) findViewById(R.id.buttonExit);
//        buttonExit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
//
//
//}