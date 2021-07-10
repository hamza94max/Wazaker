package com.hazem.wazaker.Activites;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hazem.wazkar.R;

import java.util.Random;

public class Counter extends AppCompatActivity {

    int counter = 0;
    int zekercounts = 0;
    int totalCounts;

    TextView totalcountstext;
    TextView countstext;


    public static final String MY_PREFS_NAME = "MyPrefsFile";
    SharedPreferences prefs;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        countstext = findViewById(R.id.countertext);
        totalcountstext = findViewById(R.id.totaltext);

        setSharedPreferences();
        zekercounts = sharedPreferences.getInt("zekercounts",zekercounts);

       }

    @SuppressLint("SetTextI18n")
    public void setSharedPreferences(){
        sharedPreferences = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        totalCounts = sharedPreferences.getInt("zekercounts",zekercounts);
        String s = String.valueOf(totalCounts);
        totalcountstext.setText( "المجموع الكلي : " + s);
    }

    @SuppressLint("SetTextI18n")
    public void setTotalscreen(View view) {
        counter++;
        zekercounts++;
        countstext.setText(Integer.toString(counter));
        String Total_counts = String.valueOf(zekercounts);
        totalcountstext.setText( "المجموع الكلي : " + Total_counts);

        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("zekercounts", zekercounts);
        editor.apply();

        int currentColor = Color.WHITE;   //this is activity level variable
        if(counter % 33 == 0){
            currentColor = getRandomColor();//implement getRandomColor() method
            countstext.setTextColor(currentColor);
        }
    }

    @SuppressLint("SetTextI18n")
    public void resetbutton(View view) {
        counter = 0;
        countstext.setText(Integer.toString(counter));
        countstext.setTextColor(Color.WHITE);
        totalcountstext.setText("المجموع الكلي : " +zekercounts);
    }

    private int getRandomColor() {
        Random randomcolor = new Random();
        int[] colors = {Color.WHITE,Color.BLACK,Color.YELLOW};
        int color = randomcolor.nextInt(colors.length);

        return colors[color];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counter_menu, menu);
        return true;
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.delete:
                zekercounts = 0;
                totalCounts = 0;
                String s = String.valueOf(zekercounts);
                totalcountstext.setText("المجموع الكلي : " +s);
                Toast.makeText(this, "تم مسح المجموع الكلي", Toast.LENGTH_SHORT).show();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}
