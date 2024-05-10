package com.example.volumecalculator;

//Model Class for different Shapes
// We would create the attributes of the model class from the list_layout template.

import android.widget.ImageView;
import android.widget.TextView;

public class Shape
{
    public int getImage_of_shape() {
        return image_of_shape;
    }

    public void setImage_of_shape(int image_of_shape) {
        this.image_of_shape = image_of_shape;
    }

    public String getShape_name() {
        return shape_name;
    }

    public void setShape_name(String shape_name) {
        this.shape_name = shape_name;
    }

    private int image_of_shape;//Since when we pass the R.drawable, integer value will be passed.
   private String shape_name;

   public Shape(String shape_name,int image_of_shape)
   {

       this.image_of_shape=image_of_shape;
       this.shape_name=shape_name;
   }
}
