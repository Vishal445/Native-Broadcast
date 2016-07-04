package com.upgrad.nativebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Broadcast Receiver to receive the charging state of the device.
 * Created by rachitgoyal on 7/4/16.
 */
public class ChargingReceiver extends BroadcastReceiver {

    SharedPreferences prefs;
    SharedPreferences.Editor edit;

    @Override
    public void onReceive(Context context, Intent intent) {
        prefs = context.getSharedPreferences(MainActivity.SHARED_PREFS, Context.MODE_PRIVATE);
        edit = prefs.edit();

        String action = intent.getAction();

        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, R.string.charging, Toast.LENGTH_SHORT).show();
            MainActivity.mChargeStatus.setText(R.string.charging);
            MainActivity.mChargeStatusImageView.setImageResource(R.drawable.charging);
            edit.putBoolean(MainActivity.PREFS_STATUS, true);
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, R.string.not_charging, Toast.LENGTH_SHORT).show();
            MainActivity.mChargeStatus.setText(R.string.not_charging);
            MainActivity.mChargeStatusImageView.setImageResource(R.drawable.not_charging);
            edit.putBoolean(MainActivity.PREFS_STATUS, false);
        }
        edit.apply();
    }
}