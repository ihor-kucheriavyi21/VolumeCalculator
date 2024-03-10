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
        edgeSize.addTextChangedListener(textWatcher);
        result = findViewById(R.id.volumeResult);
        calculateVolume = findViewById(R.id.calculateVolume);
        calculateVolume.setOnClickListener(view -> {
            String enteredEdge = edgeSize.getText().toString();
            double edge = Double.parseDouble(enteredEdge);
            double volume = Math.pow(edge, 3);
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

        EditText editEdgeSize = findViewById(R.id.editEdgeSize);

        submitButton.setEnabled(!editEdgeSize.getText().toString().isEmpty());
    }


}