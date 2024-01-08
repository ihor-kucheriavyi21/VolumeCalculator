package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.devexpert.volumecalculator.R;

public class Sphere extends AppCompatActivity {

    EditText sphereRadius;
    TextView title, result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphereRadius = findViewById(R.id.editRadiusSphere);
        title = findViewById(R.id.pageHeader);
        result = findViewById(R.id.sphereVolumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredRadius = sphereRadius.getText().toString();
            double radius = Double.parseDouble(enteredRadius);
            double volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
            result.setText(String.valueOf(volume));
        });
    }
}