package com.devexpert.volumecalculator.shape;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devexpert.volumecalculator.R;

import java.util.Objects;

public class Cube extends AppCompatActivity {

    EditText edgeSize;
    TextView result;
    Button calculateVolume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        edgeSize = findViewById(R.id.editEdgeSize);
        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredEdge = edgeSize.getText().toString();
            double edge = Double.parseDouble(enteredEdge);
            double volume = Math.pow(edge, 3);
            result.setText(String.valueOf(volume));
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // This method is called when the up button is pressed. Just finish the current activity.
        return true;
    }
}