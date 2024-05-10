package com.example.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.spec.ECField;

public class Cube extends AppCompatActivity
{

    Button b1;
    EditText editText;
    TextView textView;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        editText = findViewById(R.id.edtCube);
        textView = findViewById(R.id.res_cube);
        b1=findViewById(R.id.btn);





        //Check if the radius is integer

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               String radius;
               radius = editText.getText().toString();

               checkForRadius(radius);



           }
       });



    }

    public void checkForRadius(String radius)
    {

        int r1;
        double r2;

        // Check if the radius is an integer
        try {
            r1 = Integer.parseInt(radius);
            // Call the method for integer radius
            int volume = CalculateVolumeIfIntRadius(r1);
            textView.setText(String.valueOf(volume));
        } catch (NumberFormatException e) {
            // If parsing as an integer fails, it might be a double
            try {
                r2 = Double.parseDouble(radius);
                // Call the method for double radius
                double volume = CalculateVolumeIfDoubleRadius(r2);
                textView.setText(String.valueOf(volume));
            } catch (NumberFormatException ex) {
                // If neither integer nor double, handle the error
                textView.setText("Invalid input "+e.getMessage().toString());
            }
        }



    }





    public double CalculateVolumeIfDoubleRadius(double radius){

        double volume;
        volume=(1.0/3)*Math.PI*radius*radius;
        return Double.parseDouble(String.format("%.2f",volume));
    }

    public int CalculateVolumeIfIntRadius(int radius){

        return (int) ((1.0/3)*Math.PI*radius*radius);



    }





}