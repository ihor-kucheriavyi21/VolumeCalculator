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

public class Prism extends AppCompatActivity {

    EditText prismArea, prismHeight;
    TextView result;
    Button calculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        prismArea = findViewById(R.id.enterShapeArea);
        prismHeight = findViewById(R.id.enterShapeHeight);
        prismHeight.addTextChangedListener(textWatcher);
        prismArea.addTextChangedListener(textWatcher);

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

        EditText prismArea = findViewById(R.id.enterShapeArea);
        EditText prismHeight = findViewById(R.id.enterShapeHeight);
        submitButton.setEnabled(!prismArea.getText().toString().isEmpty() && !prismHeight.getText().toString().isEmpty());
    }
}