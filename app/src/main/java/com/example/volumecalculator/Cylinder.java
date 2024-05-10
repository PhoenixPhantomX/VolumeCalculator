package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cylinder extends AppCompatActivity
{

    Button b1;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        b1=findViewById(R.id.btnCalculateCylinder);
        e1=findViewById(R.id.edtradius);
        t1=findViewById(R.id.res_cylinder);
        e2=findViewById(R.id.edtheight);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String radius;
                String height;
                radius=e1.getText().toString();
                height=e2.getText().toString();


            checkForRadius(radius,height);
            }
        });





    }

    public void checkForRadius(String r, String h)
    {
            //use try catch to check if radius entered is of type double

        double r1,v,h1;

        try{
            r1=Double.parseDouble(r);
            h1=Double.parseDouble(h);
            v=calculateVolume(r1,h1);

            t1.setText("Volume of Cylinder is:" + v);

        }
        catch (NumberFormatException e)
        {

            t1.setText("There is some error "+e.getMessage().toString());


        }


    }



    public double calculateVolume(double r, double h)
    {
        double v;

        v= ((1.0)/3)*(Math.PI)*r*r*h;

        return Double.parseDouble(String.format("%.2f",v));



    }







}