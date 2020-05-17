package com.hazem.wazaker.activities;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.badoualy.stepperindicator.StepperIndicator;
import com.hazem.wazaker.Adapters.SlidePagerAdapter;
import com.hazem.wazaker.Models.ZekeritemModel;
import com.hazem.wazkar.R;
import com.hazem.wazaker.data_layer.ZekerDataSet;
import java.util.List;
import at.markushi.ui.CircleButton;

import static android.media.CamcorderProfile.get;


//// TODO: 4/18/20 Also naming rule use class, file name to indicate its rule, function
public class AzkarActivity extends AppCompatActivity {

    CircleButton buttonplus;
    TextView textViewplus;
    List<ZekeritemModel> zekerItems;
    int[] zekerCounts;



    private void loadData(int index) {
        zekerItems =  ZekerDataSet.getZekerList(index);
        zekerCounts = new int[zekerItems.size()];
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



        // Copy button
        Button copybtn =findViewById(R.id.copybtn);
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip =  ClipData.newPlainText("Text", zekerItems.get(viewPager.getCurrentItem()));
                clipboard.setPrimaryClip(clip);


                Toast.makeText(AzkarActivity.this, "تم النسخ", Toast.LENGTH_SHORT).show();
            }
        });


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
                        autoswap(viewPager,viewPager.getCurrentItem());


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
                autoswap(viewPager,viewPager.getCurrentItem());


            }
        });
    }

    private void updateScreen(ViewPager viewPager) {
        zekerCounts[viewPager.getCurrentItem()]++;
        String s = String.valueOf((zekerCounts[viewPager.getCurrentItem()]));
        textViewplus.setText(s);
    }



public void autoswap (ViewPager viewPager,int index ){

        // number of counter now
        int x =zekerCounts[viewPager.getCurrentItem()];

        // counter of zeker
        int y =zekerItems.get(index).getCounter();


        if (x==y ){


            Toast.makeText(this, "Allah with you"+"", Toast.LENGTH_SHORT).show();
        }



}}















