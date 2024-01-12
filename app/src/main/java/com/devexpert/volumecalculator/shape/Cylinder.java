package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.devexpert.volumecalculator.R;

public class Cylinder extends AppCompatActivity {
    EditText cylinderRadius;
    TextView title, result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cylinderRadius = findViewById(R.id.enterShapeRadius);
        title = findViewById(R.id.pageHeader);
        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredRadius = cylinderRadius.getText().toString();
            double radius = Double.parseDouble(enteredRadius);
            double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
            result.setText(String.valueOf(volume));
        });
    }
}