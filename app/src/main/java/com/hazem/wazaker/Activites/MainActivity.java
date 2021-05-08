package com.hazem.wazaker.Activites;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.badoualy.stepperindicator.BuildConfig;
import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;
import com.hazem.wazaker.recevier.NotificationReceiver;
import com.hazem.wazkar.R;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity /*implements LocationListener*/ {

    RelativeLayout relativeLayout;
    // TODO prayers times
    /*
    LocationManager locationManager;
    String locationText = "";
    String locationLatitude = "";
    String locationLongitude = "";
    private int mInterval = 3000;
    private Handler mHandler;
    TextView isha,magrib,asrr,dohr,fajr ;

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        // Salat
        isha=findViewById(R.id.isha);
        magrib=findViewById(R.id.maghrib);
        asrr=findViewById(R.id.asr);
        dohr=findViewById(R.id.duhur);
        fajr=findViewById(R.id.fajr);
*/
/*
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                mHandler = new Handler();
                startRepeatingTask();
            }
        }, 2000);
*/

        if (ContextCompat.checkSelfPermission(getApplicationContext()
                , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }



        relativeLayout =findViewById(R.id.relativeLayout);

            // TODO Main Cards
            CardView moring_azkar = findViewById(R.id.morazkar);
            CardView night_azkar = findViewById(R.id.eveazkar);
            CardView Hadith = findViewById(R.id.forty);
            CardView azkar = findViewById(R.id.azkar);
            CardView qibla = findViewById(R.id.qbla);
            CardView counter = findViewById(R.id.counter);
            CardView share = findViewById(R.id.setting);


        moring_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), Morning_Azkar.class);
                startActivity(intent);
            }
        });
        night_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(),NightAzkar.class);
                startActivity(intent);
            }
        });
        Hadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), FortyListActivity.class);
                startActivity(intent);
            }
        });
        azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), AzkarListActivity.class);
                startActivity(intent);

            }
        });
        qibla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), Counter.class);
                startActivity(intent);

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    String shareMessage = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    Toast.makeText(getBaseContext(), "خلل في مشاركة التطبيق، المرجو الإعادة", Toast.LENGTH_SHORT);
                    //e.toString();
                }
            }
        });


        // TODO Notification
        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }

/*
// prayers times
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }
    Runnable mStatusChecker = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            try {
                getLocation(); //this function can change value of mInterval.

                if (locationText.toString() == "") {
                    Toast.makeText(getApplicationContext(), "Trying to retrieve Location", Toast.LENGTH_LONG).show();
                }
                else {

                    double latitude= Double.parseDouble(locationLatitude);
                    double longitude=Double.parseDouble(locationLongitude);
                    Coordinates coordinates = new Coordinates(latitude, longitude);
                    DateComponents date = DateComponents.from(new Date());
                    CalculationParameters params = CalculationMethod.EGYPTIAN.getParameters();
                    params.madhab = Madhab.SHAFI;
                    params.adjustments.dhuhr = 2;
                    PrayerTimes prayerTimes = new PrayerTimes(coordinates,date, params);
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
                    formatter.setTimeZone(TimeZone.getTimeZone("Egypt"));
                    dohr.setText(  formatter.format(prayerTimes.dhuhr).toString());
                    asrr.setText( formatter.format(prayerTimes.asr).toString());
                    fajr.setText(  formatter.format(prayerTimes.fajr).toString());
                    magrib.setText(  formatter.format(prayerTimes.maghrib).toString());
                    isha.setText(  formatter.format(prayerTimes.isha).toString());


                }
            } finally {

                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }
    };
    void startRepeatingTask() {
        mStatusChecker.run();
    }
    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }
    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, (LocationListener) this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MainActivity.this, "يرجى تشغيل الموقع", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLocationChanged(Location location) {
        locationText = location.getLatitude() + "," + location.getLongitude();
        locationLatitude = location.getLatitude() + "";
        locationLongitude = location.getLongitude() + "";
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }
*/
        /*
        // Dark Mode
    public void sw(View view) {
        if (se.isChecked()) {
            relativeLayout.setBackgroundColor(R.drawable.back1);

        }
        else{
            relativeLayout.setBackgroundColor(Color.WHITE);


    }*/ }
