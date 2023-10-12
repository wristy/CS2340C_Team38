package com.example.cs2340c_team38.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.cs2340c_team38.R;
import com.example.cs2340c_team38.databinding.ActivityConfigBinding;
import com.example.cs2340c_team38.viewmodels.ConfigViewModel;

public class ConfigActivity extends AppCompatActivity {
    private ConfigViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityConfigBinding binding;
        viewModel = new ViewModelProvider(this).get(ConfigViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);
        binding.setViewModel(viewModel);

        viewModel.getIsValidConfig().observe(this, isValid -> {
            if (isValid) {
                Intent intent = new Intent(ConfigActivity.this, GameDisplayActivity.class);
                intent.putExtra("PLAYER_NAME", viewModel.getPlayerName().getValue());
                intent.putExtra("DIFFICULTY", viewModel.getDifficulty().getValue());

                int character;
                int a = binding.radioGroupCharacterSprite.getCheckedRadioButtonId();
                if (a == binding.radioCharacter1.getId()) {
                    character = R.drawable.character1;
                } else if (a == binding.radioCharacter2.getId()) {
                    character = R.drawable.character2;
                } else {
                    character = R.drawable.character3;
                }

                intent.putExtra("CHARACTER_SPRITE", character);
                startActivity(intent);
            } else {
                Toast.makeText(ConfigActivity.this, "Please fill in all details",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
