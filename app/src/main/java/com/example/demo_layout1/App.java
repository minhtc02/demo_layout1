package com.example.demo_layout1;

import android.app.Activity;
import android.app.Application;

import com.example.demo_layout1.help.SharePref;

public class App extends Activity {
    public static SharePref sharePref;

    @Override
    public void onCreate() {
        super.onCreate();
        sharePref = new SharePref(getApplicationContext());
    }
}
