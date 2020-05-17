package com.hazem.wazaker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlideFortypagerAdapter;
import com.hazem.wazaker.Fragments.FortyyFragment;
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

        Button copybtn =findViewById(R.id.copybtn);
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = (ClipData) ClipData.newPlainText("Text",fortyItems [viewPager.getCurrentItem()] );
                clipboard.setPrimaryClip(clip);


                Toast.makeText(FortyActivity.this, "تم النسخ", Toast.LENGTH_SHORT).show();
            }
        });










    }


}
