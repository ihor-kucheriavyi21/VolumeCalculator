package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.devexpert.volumecalculator.R;

import java.util.Objects;

public class Prism extends AppCompatActivity {

    EditText prismArea, prismHeight;
    TextView result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        prismArea = findViewById(R.id.enterShapeArea);
        prismHeight = findViewById(R.id.enterShapeHeight);

        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredArea = prismArea.getText().toString();
            String enteredHeight = prismHeight.getText().toString();
            double area = Double.parseDouble(enteredArea);
            double height = Double.parseDouble(enteredHeight);
            double volume = area * height;
            result.setText(String.valueOf(volume));
        });
    }
}