package com.hazem.wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlidePagerAdapter;
import com.hazem.wazaker.Data_sets.ZekerDataSet;
import com.hazem.wazaker.Models.ZekeritemModel;
import com.hazem.wazkar.R;
import java.util.List;
import at.markushi.ui.CircleButton;


public class ZekerActivity extends AppCompatActivity {

    CircleButton plusbutton;
    TextView plus_text;
    List<ZekeritemModel> zekerItems;
    int[] zekerCounts;



    private void loadData(int index) {
        zekerItems =  ZekerDataSet.getZekerList(index);
        zekerCounts = new int[zekerItems.size()];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeker);
        
        int index = getIntent().getIntExtra("index", 0);
        loadData(index);


        final ViewPager viewPager = findViewById(R.id.pager);
        SlidePagerAdapter azkardapter = new SlidePagerAdapter(this, zekerItems);
        viewPager.setAdapter(azkardapter);


        StepperIndicator indicator = findViewById(R.id.STEPP);
        indicator.setViewPager(viewPager);

        Button copybtn = findViewById(R.id.copybtn);
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zeker = zekerItems.get(viewPager.getCurrentItem()).getZeker();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, zeker);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {

                String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
                plus_text.setText(s);
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
        plus_text = findViewById(R.id.textViewplus);
        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScreen(viewPager);
                autoswap(viewPager,viewPager.getCurrentItem());
            }
        });
    }

    private void updateScreen(ViewPager viewPager) {
        zekerCounts[viewPager.getCurrentItem()]++;
        String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
        plus_text.setText(s);
    }



    public void autoswap (ViewPager viewPager,int index ){


        int Current_counts = zekerCounts[viewPager.getCurrentItem()];
        int Zeker_counts = zekerItems.get(index).getCounter();


        if (Current_counts == Zeker_counts ){

            int next_page = viewPager.getCurrentItem() + 1;
            viewPager.setCurrentItem( next_page , true);
        }
    }}






