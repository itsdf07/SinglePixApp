package com.itsdf07.singlepixapp;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

/**
 * Created by itsdf07 on 2017/8/2.
 */

public class MyApplication extends Application {
    ScreenBroadCastListener screenBroadCastListener;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(ScreenManager.TAG, "[MyApplication] onCreate:...");
        screenBroadCastListener = new ScreenBroadCastListener(this);
        screenBroadCastListener.registerBroadCast();
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(ScreenManager.TAG, "[MyApplication] onTerminate:...");
        screenBroadCastListener.unRegisterBroadCast();
    }
}
