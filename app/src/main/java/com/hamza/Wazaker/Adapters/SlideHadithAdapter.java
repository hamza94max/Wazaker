package com.hamza.Wazaker.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;

public class SlideHadithAdapter extends PagerAdapter {

    private final Context context;
    public String[] Hadiths;

    public SlideHadithAdapter(Context context, String[] ff) {
        this.context = context;
        this.Hadiths = ff;
    }

    @Override
    public int getCount() {
        return Hadiths.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView textView = new TextView(context);
        textView.setText(Hadiths[position]);
        textView.setTextSize(21);
        textView.setTextColor(Color.WHITE);

        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView,
                20, 22, 1,
                TypedValue.COMPLEX_UNIT_SP);

        container.addView(textView,0);

        return textView;
    }
    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((View)object);
    }
}
