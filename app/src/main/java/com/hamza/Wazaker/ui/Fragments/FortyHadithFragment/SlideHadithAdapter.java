package com.hamza.Wazaker.ui.Fragments.FortyHadithFragment;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;

public class SlideHadithAdapter extends PagerAdapter {

    private final Context context;
    public String[] Hadiths;

    public SlideHadithAdapter(Context context, String[] hadiths) {
        this.context = context;
        this.Hadiths = hadiths;
    }

    @Override
    public int getCount() {
        return Hadiths.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView textView = new TextView(context);
        textView.setText(Hadiths[position]);
        textView.setTextSize(21);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(7, 7, 7, 7);

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
