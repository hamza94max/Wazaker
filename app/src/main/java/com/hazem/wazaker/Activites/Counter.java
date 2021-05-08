package com.hazem.wazaker.Activites;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.hazem.wazkar.R;
import java.util.Random;

public class Counter extends AppCompatActivity {

    int counter = 0;
    int zekercounts = 0;
    int TotalCounts ;
    TextView totalcounts_text;
    RelativeLayout relativeLayout;

    //Shared preference
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    SharedPreferences prefs;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);






        TextView textView = findViewById(R.id.countertext);
        totalcounts_text = findViewById(R.id.total);
        Button reset = findViewById(R.id.reset);
        relativeLayout = findViewById(R.id.reltivee);

        load();
        zekercounts = sharedPreferences.getInt("zekercounts",zekercounts);






        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                counter++;
                zekercounts++;
                textView.setText(Integer.toString(counter));
                String Total_counts = String.valueOf(zekercounts);
                totalcounts_text.setText( "المجموع الكلي : " + Total_counts);


                prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("zekercounts", zekercounts);
                editor.apply();


                int currentColor = Color.WHITE;   //this is activity level variable
                if(counter%33 == 0){
                    currentColor = getRandomColor();//implement getRandomColor() method
                    textView.setTextColor(currentColor);
                }
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                counter = 0;
                textView.setText(Integer.toString(counter));
                textView.setTextColor(Color.WHITE);
                totalcounts_text.setText("المجموع الكلي : " +zekercounts);

            }
        });





       }

    private int getRandomColor() {
        Random randomcolor = new Random(); // creating Random object
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

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.delete:
                zekercounts = 0;
                TotalCounts = 0;
                String s = String.valueOf(zekercounts);
                totalcounts_text.setText("المجموع الكلي : " +s);
                Toast.makeText(this, "تم مسح المجموع الكلي", Toast.LENGTH_SHORT).show();
                return true;

        }
        return (super.onOptionsItemSelected(item));
    }

    @SuppressLint("SetTextI18n")
    public  void load(){

        sharedPreferences = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        TotalCounts = sharedPreferences.getInt("zekercounts",zekercounts);
        String s = String.valueOf(TotalCounts);
        totalcounts_text.setText( "المجموع الكلي : " + s);

    }



}
