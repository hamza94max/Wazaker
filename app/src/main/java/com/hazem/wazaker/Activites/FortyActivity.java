package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlideHadithAdapter;
import com.hazem.wazaker.Data_sets.FortyDataSet;
import com.hazem.wazkar.R;

public class FortyActivity extends AppCompatActivity {
     String[] Hadith;
     int[] Hadith_counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forty);

            int index = getIntent().getIntExtra("index", 0);
                loaddData(index);

            final ViewPager viewPager = findViewById(R.id.vpager);
            SlideHadithAdapter fortyAdapter = new SlideHadithAdapter(this, Hadith );
            viewPager.setAdapter(fortyAdapter);

            StepperIndicator indicator = findViewById(R.id.STEPP);
            indicator.setViewPager(viewPager);

            Button copybtn = findViewById(R.id.copybtn);
            copybtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String item = Hadith[viewPager.getCurrentItem()];

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, item);
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
            });
            }


        private void loaddData( int index) {
            Hadith = FortyDataSet.getFortyList(index);
            Hadith_counts = new int[Hadith.length];
        }
    }

