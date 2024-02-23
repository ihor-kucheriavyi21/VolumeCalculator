package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devexpert.volumecalculator.R;

import java.util.Objects;

public class Cylinder extends AppCompatActivity {
    EditText cylinderRadius, cylinderHeight;
    TextView result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        cylinderRadius = findViewById(R.id.enterShapeRadius);
        cylinderHeight = findViewById(R.id.enterShapeHeight);

        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredRadius = cylinderRadius.getText().toString();
            String enteredHeight = cylinderHeight.getText().toString();
            double radius = Double.parseDouble(enteredRadius);
            double height = Double.parseDouble(enteredHeight);
            double volume = Math.PI * Math.pow(radius, 2) * height;
            result.setText(String.valueOf(volume));
        });
    }
}