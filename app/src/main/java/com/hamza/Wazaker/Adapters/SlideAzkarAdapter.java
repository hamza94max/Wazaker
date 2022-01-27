package com.hamza.Wazaker.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.hamza.Wazaker.Models.ZekerModel;

import java.util.List;

public class SlideAzkarAdapter extends PagerAdapter {

    private final Context context;
    public List<ZekerModel> mor;


    public SlideAzkarAdapter(Context context, List<ZekerModel> mor) {
        this.context = context;
        this.mor = mor;}

    @Override
    public int getCount() {
        return mor.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) { return view == object; }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView textView = new TextView(context);
        textView.setText( mor.get(position).getZeker());
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