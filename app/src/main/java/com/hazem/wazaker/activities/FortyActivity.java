package com.hazem.wazaker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button copybtn =findViewById(R.id.copybtn);
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = fortyItems[viewPager.getCurrentItem()];
              /*  ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = (ClipData) ClipData.newPlainText("Text",fortyItems [viewPager.getCurrentItem()] );
                clipboard.setPrimaryClip(clip);
*/
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, item);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);


                //  Toast.makeText(FortyActivity.this, "تم النسخ", Toast.LENGTH_SHORT).show();
            }
        });











    }


}
