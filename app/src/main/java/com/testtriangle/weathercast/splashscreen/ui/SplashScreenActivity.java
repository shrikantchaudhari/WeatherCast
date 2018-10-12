package com.testtriangle.weathercast.splashscreen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.testtriangle.weathercast.R;
import com.testtriangle.weathercast.homescreen.ui.HomeScreenActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int SPLASH_DISPLAY_LENGTH = 2000;
        new Handler().postDelayed(() -> {
            Intent homeScreenIntent = new Intent(SplashScreenActivity.this, HomeScreenActivity.class);
            startActivity(homeScreenIntent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
