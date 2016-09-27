package com.stablekernel.example.movetasktoback;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.stablekernel.example.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private RadioGroup behaviorOptionsGroup;
    private CheckBox parameterCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        behaviorOptionsGroup = (RadioGroup) findViewById(R.id.radioGroup);
        parameterCheckBox = (CheckBox) findViewById(R.id.parameter);
        CheckBox startupChoice = (CheckBox) findViewById(R.id.startupChoice);
        startupChoice.setChecked(PreferencesUtil.getInstance(this).getStartAlternateActivity());
        startupChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferencesUtil.getInstance(buttonView.getContext()).setStartAlternateActivity(isChecked);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed()");
        switch (behaviorOptionsGroup.getCheckedRadioButtonId()) {
            case R.id.finish:
                Log.d(TAG, "calling finish()");
                finish();
                return;
            case R.id.moveTaskToBack:
                Log.d(TAG, "calling moveTaskToBack(" + parameterCheckBox.isChecked() + ")");
                moveTaskToBack(parameterCheckBox.isChecked());
                return;
            default:
                Log.d(TAG, "calling super.onBackPressed()");
                super.onBackPressed();
        }
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
