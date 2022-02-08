package com.hamza.Wazaker.Activites;

import android.annotation.SuppressLint;
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

import com.hamza.Wazaker.Utills.RandomColor;
import com.hamza.wazkar.R;
import com.hamza.wazkar.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    int counter = 0, totalCounts = 0;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    SharedPreferences sharedPreferences;

    ActivityCounterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter);

        getDatafromSharedPreferences();

    }

    @SuppressLint("SetTextI18n")
    public void getDatafromSharedPreferences() {
        sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        totalCounts = sharedPreferences.getInt("zekertotalcounts", totalCounts);
        setTotalzekerCountstext(totalCounts);
    }

    @SuppressLint("SetTextI18n")
    public void setTotalscreen(View view) {
        counter++;
        totalCounts++;

        checkcounts(counter);
        binding.countertextview.setText(Integer.toString(counter));
        setTotalzekerCountstext(totalCounts);

        saveTotalcountsInSharedPreference();
    }

    @SuppressLint("SetTextI18n")
    public void setTotalzekerCountstext(int Totalzekercounts) {
        binding.totalCountstextview.setText(getString(R.string.totalzeker) + "  " + Totalzekercounts);
    }

    private void checkcounts(int counts) {
        if (counts % 33 == 0) getRandomcolor();
    }

    private void getRandomcolor() {
        int currentColor;
        if (counter % 33 == 0) {
            currentColor = RandomColor.getRandomColor();
            binding.countertextview.setTextColor(currentColor);
        }
    }

    @SuppressLint("SetTextI18n")
    public void resetbutton(View view) {
        counter = 0;
        binding.countertextview.setText(Integer.toString(counter));
        binding.countertextview.setTextColor(Color.WHITE);
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
            totalCounts = 0;
            setTotalzekerCountstext(totalCounts);
            saveTotalcountsInSharedPreference();
            Toast.makeText(this, getString(R.string.TotalDeleted), Toast.LENGTH_SHORT).show();
            return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    private void saveTotalcountsInSharedPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("zekertotalcounts", totalCounts);
        editor.apply();
    }

}