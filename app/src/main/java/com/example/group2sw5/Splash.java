package com.example.group2sw5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.seatwork).setScaleX(1.2f);
        findViewById(R.id.seatwork).setScaleY(1.2f);
        findViewById(R.id.seatwork).setAlpha(0);
        findViewById(R.id.seatwork).animate().scaleX(1f).scaleY(1f).alpha(1).setDuration(800).setStartDelay(400).start();

        findViewById(R.id.activity).setScaleX(1.2f);
        findViewById(R.id.activity).setScaleY(1.2f);
        findViewById(R.id.activity).setAlpha(0);
        findViewById(R.id.activity).animate().scaleX(1f).scaleY(1f).alpha(1).setDuration(800).setStartDelay(400).start();

        findViewById(R.id.instructor).setScaleX(1.2f);
        findViewById(R.id.instructor).setScaleY(1.2f);
        findViewById(R.id.instructor).setAlpha(0);
        findViewById(R.id.instructor).animate().scaleX(1f).scaleY(1f).alpha(1).setStartDelay(600).setDuration(800).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Signup.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}