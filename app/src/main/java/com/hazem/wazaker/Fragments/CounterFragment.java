package com.hazem.wazaker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hazem.wazkar.R;


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
            }
        });






        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter = 0;
                textView.setText(Integer.toString(counter));



            }
        });


        return v;
    }






}






