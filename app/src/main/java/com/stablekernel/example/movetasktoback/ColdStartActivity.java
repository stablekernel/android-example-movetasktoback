package com.stablekernel.example.movetasktoback;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ColdStartActivity extends AppCompatActivity {

    public static final String TAG = ColdStartActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // start the next activity after a minor delay to be sure this activity is visible
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Class startupClass = PreferencesUtil.getInstance(ColdStartActivity.this).getStartAlternateActivity()
                        ? InterimActivity.class : MainActivity.class;
                startActivity(new Intent(ColdStartActivity.this, startupClass));
                finish();
            }
        }, 1000);
    }

    @Override
    public void onBackPressed() {
        // NO OP, don't allow user to foil our plans
    }
}
