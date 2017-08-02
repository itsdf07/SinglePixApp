package com.itsdf07.singlepixapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by itsdf07 on 2017/7/22.
 */

public class SinglePixActivity extends AppCompatActivity {
    private final String TAG = "dfsu";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ScreenManager.TAG, "SinglePixActivity : onCreate ...");
        Window window = getWindow();
        window.setGravity(Gravity.START | Gravity.TOP);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = 1;
        layoutParams.height = 1;
        layoutParams.x = 0;
        layoutParams.y = 0;
        window.setAttributes(layoutParams);
        registerBroadCast();
    }

    @Override
    protected void onDestroy() {
        Log.d(ScreenManager.TAG, "SinglePixActivity : onDestroy ...");
        unRegisterBroadCast();
        super.onDestroy();
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(ScreenManager.TAG, "SinglePixActivity : onReceive action = " + intent.getAction());
            finish();
        }
    };

    private void registerBroadCast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ScreenManager.BROADCAST_ACTION_FINISH);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    private void unRegisterBroadCast() {
        unregisterReceiver(mBroadcastReceiver);
    }
}
