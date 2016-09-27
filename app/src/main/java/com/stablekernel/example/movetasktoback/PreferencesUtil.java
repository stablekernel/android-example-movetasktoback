package com.stablekernel.example.movetasktoback;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtil {

    public static final String KEY_STARTUP_ALTERNATE = "startup";
    public static final String PREFS_NAME = "prefs";

    private static PreferencesUtil instance;

    private SharedPreferences sharedPreferences;

    public static PreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new PreferencesUtil(context);
        }

        return instance;
    }

    private PreferencesUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setStartAlternateActivity(boolean choice) {
        sharedPreferences.edit()
                .putBoolean(KEY_STARTUP_ALTERNATE, choice)
                .apply();
    }

    public boolean getStartAlternateActivity() {
        return sharedPreferences.getBoolean(KEY_STARTUP_ALTERNATE, false);
    }
}
