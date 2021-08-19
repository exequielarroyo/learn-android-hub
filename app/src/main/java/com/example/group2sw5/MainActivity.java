package com.example.group2sw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;
    boolean isHide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        broadcastReceiver = new NetworkReceiver();
        registerNetworkReceiver();

        LottieAnimationView lottieAnimationView = findViewById(R.id.showHideLottieView);
        lottieAnimationView.setProgress(0.5f);
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isHide) {
                    lottieAnimationView.setMinAndMaxProgress(0.5f,1f);
                    lottieAnimationView.playAnimation();
                    bottomNavigationView.setTranslationY(200);
                    isHide = true;
                } else {
                    lottieAnimationView.setMinAndMaxProgress(0,0.5f);
                    lottieAnimationView.playAnimation();
                    bottomNavigationView.setTranslationY(0);
                    isHide = false;
                }
            }
        });
    }

    protected void registerNetworkReceiver() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetwork() {
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetwork();
    }

    public void clickMember(View view) {
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        String name = nameTextView.getText().toString();
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}