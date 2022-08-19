package com.example.demo_layout1.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_layout1.App;
import com.example.demo_layout1.R;
import com.example.demo_layout1.help.SharePref;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            if (App.sharePref.getIsConfirm()) {
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Intent intent = new Intent(SplashActivity.this, PermissionActivity.class);
                startActivity(intent);
            }
            finish();
        }, 1500);
    }
}