package com.example.wazkar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.wazkar.Fragments.CounterFragment;
import com.example.wazkar.Fragments.FortyyFragment;
import com.example.wazkar.Fragments.AzkarFragment;
import com.example.wazkar.data_layer.NotificationDataset;
import com.example.wazkar.recevier.NotificationReceiver;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    NotificationDataset notificationDataset ;


    //Fragments
    AzkarFragment homeFragment;
    CounterFragment counterFragment;
    FortyyFragment fortyyFragment;
    MenuItem prevMenuItem;
    String CHANNEL_ID="Channel_1";
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing viewPager
        viewPager = findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        final BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.forty:
                                viewPager.setCurrentItem(0);
                                break;

                            case R.id.navigation_home:
                                viewPager.setCurrentItem(2);
                                break;

                            default:
                                viewPager.setCurrentItem(1);
                        }
                        return false;
                    }
                });


        // Counter in viewpager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "" + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);


            // TODO notification

            notificationManager=NotificationManagerCompat.from(this);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            builder.setSmallIcon(R.drawable.splash)
                    .setContentTitle("Wazkar وذكر").setAutoCancel(true);
        Intent intent =new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent =PendingIntent.getBroadcast(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);









        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            Calendar calendar =Calendar.getInstance();
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_HALF_DAY,   pendingIntent);
        }


        }




    // viewpager with bottom navigation
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new AzkarFragment();
        counterFragment = new CounterFragment();
        fortyyFragment = new FortyyFragment();

        adapter.addFragment(fortyyFragment);
        adapter.addFragment(counterFragment);
        adapter.addFragment(homeFragment);

        viewPager.setAdapter(adapter);
    }

    /*
    // // TODO: 4/18/20  make it as separate file
     */
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }


    }


}