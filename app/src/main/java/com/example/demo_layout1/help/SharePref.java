package com.example.demo_layout1.help;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demo_layout1.R;

public class SharePref {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String IS_CONFIRM = "isConFirm";

    public SharePref(Context context) {
        this.preferences = context.getSharedPreferences(IS_CONFIRM, Context.MODE_PRIVATE);
        this.editor = this.preferences.edit();
    }

    public void setIsConfirm(boolean isConfirm) {
        editor.putBoolean(IS_CONFIRM, isConfirm);
        editor.apply();
    }

    public boolean getIsConfirm() {
        Log.d("AAA", "pref "+ preferences);
        return preferences.getBoolean(IS_CONFIRM, false);
    }
}
