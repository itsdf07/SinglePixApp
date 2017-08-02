package com.itsdf07.singlepixapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Created by itsdf07 on 2017/7/22.
 */

public class ScreenBroadCastListener {
    private final String TAG = "dfsu";

    private Context mContext;
    private ScreenBroadCastReceiver mScreenBroadCastReceiver;

    public ScreenBroadCastListener(Context context) {
        Log.d(ScreenManager.TAG, "[ScreenBroadCastListener] ScreenBroadCastListener:...");
        mContext = context;
        mScreenBroadCastReceiver = new ScreenBroadCastReceiver();
    }

    private class ScreenBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(ScreenManager.TAG, "ScreenBroadCastListener : onReceive action = " + action);
            if (Intent.ACTION_SCREEN_ON.equals(action)) {
                ScreenManager.getInstance(mContext).finishActivity();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                ScreenManager.getInstance(mContext).startActivity();
            } else {

            }
        }
    }

    public void registerBroadCast() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mContext.registerReceiver(mScreenBroadCastReceiver, filter);
    }

    public void unRegisterBroadCast() {
        mContext.unregisterReceiver(mScreenBroadCastReceiver);
    }
}
