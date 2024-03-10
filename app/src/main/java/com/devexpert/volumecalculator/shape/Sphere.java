package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devexpert.volumecalculator.R;

public class Sphere extends AppCompatActivity {

    EditText sphereRadius;
    TextView result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        sphereRadius = findViewById(R.id.editRadiusSphere);
        sphereRadius.addTextChangedListener(textWatcher);
        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredRadius = sphereRadius.getText().toString();
            double radius = Double.parseDouble(enteredRadius);
            double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
            result.setText(String.valueOf(volume));
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFieldsForEmptyValues();
        }
    };

    private void checkFieldsForEmptyValues() {
        Button submitButton = findViewById(R.id.calculateVolume);

        EditText sphereRadius = findViewById(R.id.editRadiusSphere);
        submitButton.setEnabled(!sphereRadius.getText().toString().isEmpty());
    }
}