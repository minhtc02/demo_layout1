package com.example.demo_layout1;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.demo_layout1.help.SharePref;

public class App extends Application {
    public static SharePref sharePref;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AAA", "app: " + getApplicationContext());
        context = getApplicationContext();
        sharePref = new SharePref(context);

    }
}
