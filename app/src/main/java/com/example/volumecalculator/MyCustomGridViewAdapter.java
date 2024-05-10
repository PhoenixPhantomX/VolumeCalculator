package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//Adapter is used to show the data to the GridView.

public class MyCustomGridViewAdapter extends ArrayAdapter<Shape>
{


//1. to Create a ArrayList variable and  Context type variable, globally.

    private ArrayList<Shape> shapesArrayList;
    Context context;


//2. Create the constructor, and call the super and pass the context, layout file, and the data source.
    public MyCustomGridViewAdapter(@NonNull Context context, ArrayList<Shape> shapesarrayList) {
        super(context,R.layout.grid_item_layout,shapesarrayList);

        this.shapesArrayList=shapesarrayList;
        this.context=context;
    }



    //4. Override the method getView()
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //4.1
        //Create the references or variables to the MyViewHolder
        MyViewHolder viewHolder;


        //4.2
        // To get the items at the particular position from the model class.

        Shape shape=getItem(position);


        // 4.3
        //to check if the list is scrolled or not and views are recycled or not.

        if(convertView==null)  //means method is called for the first time or view is not recycle yet.
        {
            //4.4 Intialize the viewHolder, by creating object of it.
          viewHolder=new MyViewHolder();
          //4.5 to initialize the convertView, and infalte the grid_item_layout on the screen.
          convertView=LayoutInflater.from(context).inflate(R.layout.grid_item_layout,parent,false);


          //4.6 To initialize the widgets.

            viewHolder.textView=(TextView) convertView.findViewById(R.id.textView);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.imageView);

            //4.7 which is to set the tag to the convertView.

            convertView.setTag(viewHolder);//setting the current state of the widgets/

        }

        //4.8 Creating else, means the list is scrolled or method is called at least once.

        else
        {
        //4.9 getting the state of the screen or widgets and storing it into viewHolder

            viewHolder=(MyViewHolder) convertView.getTag();

        }


        //4.10
        // We need to set the data of our views or widgets and get the data from the model class.
        viewHolder.textView.setText(shape.getShape_name());
        viewHolder.imageView.setImageResource(shape.getImage_of_shape());

        return convertView;
    }

    //3. Create the MyViewHolder class for improving the scrollable performance.
    //It will contain the references to the widgets.
    private static class MyViewHolder
    {
        ImageView imageView;
        TextView textView;
    }



}
