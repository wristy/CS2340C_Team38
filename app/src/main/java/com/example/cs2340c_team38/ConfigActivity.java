package com.example.cs2340c_team38;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {
    private EditText editPlayerName;
    private Spinner spinnerDifficulty;
    private RadioGroup radioGroupCharacterSprite;
    private Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        editPlayerName = findViewById(R.id.editPlayerName);
        spinnerDifficulty = findViewById(R.id.spinnerDifficulty);
        radioGroupCharacterSprite = findViewById(R.id.radioGroupCharacterSprite);
        buttonContinue = findViewById(R.id.buttonContinue);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidConfig()) {
                    Intent intent = new Intent(ConfigActivity.this,
                            GameDisplayActivity.class);
                    intent.putExtra("PLAYER_NAME", editPlayerName.getText().toString());
                    intent.putExtra("DIFFICULTY",
                            spinnerDifficulty.getSelectedItem().toString());
                    intent.putExtra("CHARACTER_SPRITE",
                            radioGroupCharacterSprite.getCheckedRadioButtonId());
                    startActivity(intent);
                } else {
                    Toast.makeText(ConfigActivity.this, "Please fill in all details",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidConfig() {
        if (TextUtils.isEmpty(editPlayerName.getText().toString().trim())) {
            return false;
        }

        if (spinnerDifficulty.getSelectedItem() == null) {
            return false;
        }

        if (radioGroupCharacterSprite.getCheckedRadioButtonId() == -1) {
            return false;
        }

        return true;
    }
}

