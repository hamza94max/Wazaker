package com.example.wazkar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.badoualy.stepperindicator.StepperIndicator;
import com.example.wazkar.Adapters.SlidePagerAdapter;
import com.example.wazkar.data_layer.ZekerDataSet;

import at.markushi.ui.CircleButton;

import static com.example.wazkar.Adapters.AzkarAdapter.btnid;


//// TODO: 4/18/20 Also naming rule use class, file name to indicate its rule, function
public class AzkarActivity extends AppCompatActivity {

    CircleButton buttonplus;
    TextView textViewplus;
    String[] zekerItems;
    int[] zekerCounts;

    private void loadData(int index) {
        zekerItems = ZekerDataSet.getZekerList(index);
        zekerCounts = new int[zekerItems.length];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        int index = getIntent().getIntExtra("index", 0);
        loadData(index);

        // view pager inside recycleview
        final ViewPager viewPager = findViewById(R.id.pager);
        SlidePagerAdapter azadapter = new SlidePagerAdapter(this, zekerItems);
        viewPager.setAdapter(azadapter);


        // Ui
        StepperIndicator indicator = findViewById(R.id.STEPP);
        indicator.setViewPager(viewPager);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
                textViewplus.setText(s);
                buttonplus.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        updateScreen(viewPager);
                    }
                });
            }
        });

        // counter
        buttonplus = findViewById(R.id.btnp);
        textViewplus = findViewById(R.id.textViewplus);
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                updateScreen(viewPager);
            }
        });
    }

    private void updateScreen(ViewPager viewPager) {
        zekerCounts[viewPager.getCurrentItem()]++;
        String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
        textViewplus.setText(s);
    }
}













