package com.upgrad.nativebroadcast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "my_prefs";
    public static final String PREFS_STATUS = "charge_status";
    static TextView mChargeStatus;
    static ImageView mChargeStatusImageView;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        boolean isCharging = prefs.getBoolean(PREFS_STATUS, false);

        mChargeStatus = (TextView) findViewById(R.id.charge_status);
        mChargeStatusImageView = (ImageView) findViewById(R.id.charge_status_image_view);

        if (isCharging) {
            mChargeStatus.setText(R.string.charging);
            mChargeStatusImageView.setImageResource(R.drawable.charging);
        }
    }
}