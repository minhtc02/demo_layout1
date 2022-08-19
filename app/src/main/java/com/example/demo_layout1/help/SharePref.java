package com.example.demo_layout1.help;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String IS_CONFIRM = "isConFirm";

    public SharePref(Context context) {
        preferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    public void setIsConfirm(boolean isConfirm) {
        editor.putBoolean(IS_CONFIRM, isConfirm);
        editor.apply();
    }

    public boolean getIsConfirm() {
        return preferences.getBoolean(IS_CONFIRM, false);
    }
}
