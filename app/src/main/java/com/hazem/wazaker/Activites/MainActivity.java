package com.hazem.wazaker.Activites;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.badoualy.stepperindicator.BuildConfig;
import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;
import com.hazem.wazaker.recevier.NotificationReceiver;
import com.hazem.wazkar.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {

    TextView totalzekertext;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalzekertext = findViewById(R.id.Totalzekertext);

        addNotification();

        getDatafromSharedpreference();

    }

    private void getDatafromSharedpreference() {
        SharedPreferences prefs = getSharedPreferences("prefName", MODE_PRIVATE);
        int totalzekerCounts = prefs.getInt("totalCounts", 0);
        setTotalzekertext(totalzekerCounts);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int Totalzekercounts = data.getIntExtra("totalzekercount",0);
                setSharedperference(Totalzekercounts);
                setTotalzekertext(Totalzekercounts);
            }
        }
    }

    private void setSharedperference(int totalzekercounts) {
        SharedPreferences.Editor editor = getSharedPreferences("prefName", MODE_PRIVATE).edit();
        editor.putInt("totalCounts", totalzekercounts);
        editor.apply();
    }

    @SuppressLint("SetTextI18n")
    public void setTotalzekertext(int Totalzekercounts){
        totalzekertext.setText(getString(R.string.totalzeker) + " " +Totalzekercounts);
    }

    public void openCounterActivity(View view) {
        Intent intent = new Intent(this, CounterActivity.class);
        //noinspection deprecation
        startActivityForResult(intent, 1);
    }

    public void eveningAzkar(View view) {
       openActivity(EveningAzkar.class);
    }

    public void morningAzkar(View view) {
      openActivity(MorningAzkar.class);
    }

    public void openFortyHadithActivity(View view) {
       openActivity(FortyHadithListActivity.class);
    }

    public void openAzkarActivity(View view) { openActivity(AzkarListActivity.class); }

    public void openActivity (Class activity){
        Intent intent = new Intent(getBaseContext(), activity);
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

    public void shareApp(View view) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            String shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            Toast.makeText(getBaseContext(), "خلل في مشاركة التطبيق، المرجو الإعادة", Toast.LENGTH_SHORT).show();
        }
    }

    private void addNotification(){
        Intent intent = new Intent(this, NotificationReceiver.class);
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        setbuilder(alarmManager,pendingIntent,calendar);
    }

    private void setbuilder(AlarmManager alarmManager ,PendingIntent pendingIntent, Calendar calendar){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

}
