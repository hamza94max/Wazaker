package com.example.wazkar.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SlidePagerAdapter extends PagerAdapter {

    private Context context;
    private String[] mor;



    public SlidePagerAdapter(Context context, String[] mor) {
        this.context = context;
        this.mor = mor;

    }

    @Override
    public int getCount() {
        return mor.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView textView=new TextView(context);
        textView.setText(mor[position]);
        textView.setTextSize(19);
        textView.setTextColor(Color.WHITE);
        container.addView(textView,0);


        return textView;

    }
    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((View)object);
    }

}
