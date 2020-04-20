package com.hazem.wazaker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlideFortypagerAdapter;
import com.hazem.wazkar.R;
import com.hazem.wazaker.data_layer.FortyDataSet;

public class FortyActivity extends AppCompatActivity {
    String[] fortyItems;
    int[] fortyCounts;


    private void loaddData(int index) {
        fortyItems = FortyDataSet.getFortyList(index);
        fortyCounts = new int[fortyItems.length];
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forty);


        int index = getIntent().getIntExtra("index", 0);
        loaddData(index);

        final ViewPager viewPager = findViewById(R.id.vpager);
        SlideFortypagerAdapter fortyAdapter = new SlideFortypagerAdapter(this,fortyItems );
        viewPager.setAdapter(fortyAdapter);


        // Ui
        StepperIndicator indicator = findViewById(R.id.STEPP);
        indicator.setViewPager(viewPager);


    }


}
