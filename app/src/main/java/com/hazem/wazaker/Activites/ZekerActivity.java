package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlideAzkarAdapter;
import com.hazem.wazaker.Data_sets.ZekerDataSet;
import com.hazem.wazaker.Models.ZekerModel;
import com.hazem.wazkar.R;

import java.util.List;

import at.markushi.ui.CircleButton;


public class ZekerActivity extends AppCompatActivity {

    CircleButton plusbutton;
    TextView plustextview;
    List<ZekerModel> zekerItems;
    int[] zekerCounts;

    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeker);

        int index = getIntent().getIntExtra("index", 0);
        loadData(index);


        viewPager = findViewById(R.id.pager);
        SlideAzkarAdapter azkardapter = new SlideAzkarAdapter(this, zekerItems);
        viewPager.setAdapter(azkardapter);


        StepperIndicator indicator = findViewById(R.id.STEPP);
        indicator.setViewPager(viewPager);




        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {

                String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
                plustextview.setText(s);
                plusbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateScreen(viewPager);
                        autoswap(viewPager,viewPager.getCurrentItem());
                    }
                });
            }
        });

        plusbutton = findViewById(R.id.btnp);
        plustextview = findViewById(R.id.textViewplus);
        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(viewPager);
                autoswap(viewPager,viewPager.getCurrentItem());
            }
        });
    }

    private void loadData(int index) {
        zekerItems =  ZekerDataSet.getZekerList(index);
        zekerCounts = new int[zekerItems.size()];
    }

    private void updateScreen(ViewPager viewPager) {
        zekerCounts[viewPager.getCurrentItem()]++;
        String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
        plustextview.setText(s);
    }

    public void autoswap (ViewPager viewPager,int index ){


        int Currentcounts = zekerCounts[viewPager.getCurrentItem()];
        int Zekercounts = zekerItems.get(index).getCounter();

        if (Currentcounts == Zekercounts ){
            int next_page = viewPager.getCurrentItem() + 1;
            viewPager.setCurrentItem( next_page , true);
        }
    }

    public void copyZekerbtn(View view) {
        String zeker = zekerItems.get(viewPager.getCurrentItem()).getZeker();

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, zeker);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}






