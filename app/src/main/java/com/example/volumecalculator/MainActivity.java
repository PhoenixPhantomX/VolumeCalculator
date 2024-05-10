package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
  GridView gridView;
  ArrayList<Shape> arrayList;
  MyCustomGridViewAdapter gridViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);


       Shape shape1=new Shape("Cube",R.drawable.cube);
       Shape shape2 =new Shape("Cylinder",R.drawable.cylinder);
       Shape shape3=new Shape("Prism",R.drawable.prism);
       Shape shape4=new Shape("Sphere",R.drawable.sphere);

       arrayList=new ArrayList<>();

        arrayList.add(shape1);
        arrayList.add(shape2);
        arrayList.add(shape3);
        arrayList.add(shape4);

        gridViewAdapter=new MyCustomGridViewAdapter(getApplicationContext(),arrayList);

        gridView.setAdapter(gridViewAdapter);
        gridView.setNumColumns(2);



    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if(gridViewAdapter.getItem(position).getImage_of_shape()==R.drawable.cube){

                Intent i= new Intent(getApplicationContext(),Cube.class);
                startActivity(i);

            }
        }
    });


 gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if(gridViewAdapter.getItem(position).getImage_of_shape()==R.drawable.cylinder){

                Intent i1=new Intent(getApplicationContext(),Cylinder.class);
                startActivity(i1);

            }


        }
    });





    }






}