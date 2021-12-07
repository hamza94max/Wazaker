package com.hazem.wazaker.Activites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hazem.wazaker.FuncationClasses.RandomColor;
import com.hazem.wazkar.R;
import com.hazem.wazkar.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    int totalCounts, counter = 0, zekercounts = 0;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    SharedPreferences prefs;
    SharedPreferences sharedPreferences;

    ActivityCounterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter);

        setSharedPreferences();
        zekercounts = sharedPreferences.getInt("zekercounts",zekercounts);

    }

    @Override
    public void onBackPressed() {
        sendTotalzekerCountstoMainActivity();
    }

    public void sendTotalzekerCountstoMainActivity(){
        Intent intent = new Intent();
        intent.putExtra("totalzekercount", zekercounts);
        setResult(RESULT_OK, intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    public void setTotalzekerCountstext(int Totalzekercounts){
        binding.totalCountstextview.setText(getString(R.string.totalzeker) + " " +Totalzekercounts);
    }

    @SuppressLint("SetTextI18n")
    public void setSharedPreferences(){
        sharedPreferences = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
        totalCounts = sharedPreferences.getInt("zekercounts",zekercounts);
        setTotalzekerCountstext(totalCounts);
    }

    @SuppressLint("SetTextI18n")
    public void setTotalscreen(View view) {
        counter++;
        zekercounts++;
        binding.countertextview.setText(Integer.toString(counter));
        setTotalzekerCountstext(zekercounts);

        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("zekercounts", zekercounts);
        editor.apply();

        int currentColor;
            if(counter % 33 == 0){
            currentColor = getRandomColor();
            binding.countertextview.setTextColor(currentColor);
        }
    }

    @SuppressLint("SetTextI18n")
    public void resetbutton(View view) {
        counter = 0;
        binding.countertextview.setText(Integer.toString(counter));
        binding.countertextview.setTextColor(Color.WHITE);
    }

    private static int getRandomColor() {
        int[] colors = {Color.WHITE,Color.BLACK,Color.YELLOW};
        return RandomColor.getRandomColor(colors);
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
            if (id == R.id.delete) {
            zekercounts = 0; totalCounts = 0;
            setTotalzekerCountstext(zekercounts);
            Toast.makeText(this, getString(R.string.TotalDeleted), Toast.LENGTH_SHORT).show();
            return true;
        }
        return (super.onOptionsItemSelected(item));
    }

}