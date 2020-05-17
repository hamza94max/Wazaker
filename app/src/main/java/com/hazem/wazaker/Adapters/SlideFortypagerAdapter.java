package com.hazem.wazaker.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideFortypagerAdapter extends PagerAdapter {
    private Context context;
    public String[] ff;

    public SlideFortypagerAdapter(Context context, String[] ff) {
        this.context = context;
        this.ff = ff;
    }

    @Override
    public int getCount() {
        return ff.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView textView=new TextView(context);
        textView.setText(ff[position]);
        textView.setTextSize(21);
        textView.setTextColor(Color.WHITE);
        container.addView(textView,0);


        return textView;

    }
    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((View)object);
    }
}
