package com.stablekernel.example.movetasktoback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stablekernel.example.R;

public class InterimActivity extends AppCompatActivity {

    public static final String TAG = InterimActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interim);
        // Nothing to see here, start up MainActivity so that it isn't the root activity
        startActivity(new Intent(this, MainActivity.class));
    }
}
