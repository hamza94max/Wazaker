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
        setContentView(R.layout.activity_zeker);



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
                String zeker = zekerItems.get(viewPager.getCurrentItem()).getZeker();
               /*
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip =  ClipData.newPlainText("Text", zekerItems.get(viewPager.getCurrentItem()));
                clipboard.setPrimaryClip(clip);
               */


                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, zeker);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                //  Toast.makeText(AzkarActivity.this, "تم النسخ", Toast.LENGTH_SHORT).show();
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
            // get current viewpager, then increament it
            int next = viewPager.getCurrentItem() + 1;
            // set it to next one
            viewPager.setCurrentItem(next, true);        }



    }}






