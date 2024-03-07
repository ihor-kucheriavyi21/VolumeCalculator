package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devexpert.volumecalculator.R;

import java.util.Objects;

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
        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredRadius = sphereRadius.getText().toString();
            double radius = Double.parseDouble(enteredRadius);
            double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
            result.setText(String.valueOf(volume));
        });
    }
}