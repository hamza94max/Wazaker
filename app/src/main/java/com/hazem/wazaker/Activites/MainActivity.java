package com.hazem.wazaker.Activites;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.badoualy.stepperindicator.BuildConfig;
import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;
import com.hazem.wazaker.recevier.NotificationReceiver;
import com.hazem.wazkar.R;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNotification();

    }

    public void eveningAzkar(View view) {
        Intent intent = new Intent(getBaseContext(), EveningAzkar.class);
        startActivity(intent);
    }

    public void morningAzkar(View view) {
        Intent intent = new Intent(getBaseContext(), MorningAzkar.class);
        startActivity(intent);
    }

    public void fortyHadith(View view) {
        Intent intent = new Intent(getBaseContext(), FortyListActivity.class);
        startActivity(intent);
    }

    public void azkarandDoaa(View view) {
        Intent intent = new Intent(getBaseContext(), AzkarListActivity.class);
        startActivity(intent);

    }

    public void qibla(View view) {
        Intent intent = new Intent(MainActivity.this, CompassActivity.class);
        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#FFFFFF");		// Toolbar Background color
        intent.putExtra(Constants.COMPASS_BG_COLOR, "#FFFFFF");		// Compass background color
        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000");		// Angle Text color
        intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial);	// Your dial drawable resource
        intent.putExtra(Constants.DRAWABLE_QIBLA, R.drawable.qibla); 	// Your qibla indicator drawable resource
        intent.putExtra(Constants.FOOTER_IMAGE_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE);	// Footer World Image visibility
        intent.putExtra(Constants.LOCATION_TEXT_VISIBLE, View.VISIBLE|View.INVISIBLE|View.GONE); // Location Text visibility
        startActivity(intent);
    }

    public void goCounter(View view) {
        Intent intent =new Intent(getBaseContext(), Counter.class);
        startActivity(intent);
    }

    public void share(View view) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            String shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            Toast.makeText(getBaseContext(), "خلل في مشاركة التطبيق، المرجو الإعادة", Toast.LENGTH_SHORT);
        }
    }

    private void addNotification(){

        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        builder(alarmManager,pendingIntent,calendar);
    }

    private void builder(AlarmManager alarmManager ,PendingIntent pendingIntent, Calendar calendar){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

}
