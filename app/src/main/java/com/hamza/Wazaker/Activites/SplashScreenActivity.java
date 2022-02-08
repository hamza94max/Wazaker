package com.hamza.Wazaker.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hamza.wazkar.R;
import com.hamza.wazkar.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
        binding.img.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, 500);

    }
}




