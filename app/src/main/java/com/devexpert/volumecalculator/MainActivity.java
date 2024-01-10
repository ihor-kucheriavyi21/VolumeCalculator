package com.devexpert.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.devexpert.volumecalculator.adapter.CustomAdapter;
import com.devexpert.volumecalculator.model.Shape;
import com.devexpert.volumecalculator.shape.Cube;
import com.devexpert.volumecalculator.shape.Cylinder;
import com.devexpert.volumecalculator.shape.Prism;
import com.devexpert.volumecalculator.shape.Sphere;

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
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // Sphere
                        intent = new Intent(getApplicationContext(), Sphere.class);
                        break;
                    case 1: // Cylinder
                        intent = new Intent(getApplicationContext(), Cylinder.class);
                        break;
                    case 2: // Cube
                        intent = new Intent(getApplicationContext(), Cube.class);
                        break;
                    case 3: // Prism
                        intent = new Intent(getApplicationContext(), Prism.class);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
                startActivity(intent);
            }
        });

    }
}