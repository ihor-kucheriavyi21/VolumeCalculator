package com.devexpert.volumecalculator;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.devexpert.volumecalculator.adapter.CustomAdapter;
import com.devexpert.volumecalculator.model.Shape;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    ArrayList<Shape> shapeArrayList;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape sphere = new Shape(R.drawable.sphere, "Sphere");
        Shape cylinder = new Shape(R.drawable.cylinder, "Cylinder");
        Shape cube = new Shape(R.drawable.cube, "Cube");
        Shape prism = new Shape(R.drawable.prism, "Prism");

        shapeArrayList.add(sphere);
        shapeArrayList.add(cylinder);
        shapeArrayList.add(cube);
        shapeArrayList.add(prism);

        customAdapter = new CustomAdapter(shapeArrayList, getApplicationContext());

        gridView.setAdapter(customAdapter);


    }
}