package com.hazem.wazaker.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hazem.wazkar.R;

import java.util.Random;


public class CounterFragment extends Fragment {
    TextView textView;
    Button reset;
    private int counter = 0;

    public CounterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_counter, container, false);




        textView=v.findViewById(R.id.countertext);
        reset=v.findViewById(R.id.reset);
        RelativeLayout relativeLayout=v.findViewById(R.id.reltivee);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText(Integer.toString(counter));

                int currentColor = Color.WHITE;//this is activity level variable


                if(counter%33 == 0){
                    currentColor = getRandomColor();//implement getRandomColor() method
                    textView.setTextColor(currentColor);
                }




            }
        });






        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter = 0;
                textView.setText(Integer.toString(counter));
                textView.setTextColor(Color.WHITE);



            }
        });


        return v;
    }



private int getRandomColor(){

    Random randomcolor = new Random(); // creating Random object
    int[] colors ={Color.WHITE,R.color.green,Color.BLACK};
    int color = randomcolor.nextInt(colors.length);

    return colors[color];

}


}






