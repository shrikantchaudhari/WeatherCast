package com.testtriangle.weathercast.splashscreen.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.testtriangle.weathercast.R;
import com.testtriangle.weathercast.homescreen.ui.HomeScreenActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent homeScreenIntent = new Intent(SplashScreenActivity.this,HomeScreenActivity.class);
                startActivity(homeScreenIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
