package com.itsdf07.singlepixapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(ScreenManager.TAG, "[MyService] onStartCommand:flags = " + flags + ",startId = " + startId);
        //这个listener是运行在不同的进程中，意味着生命周期不同，广播的生命周期和Application已经不同了
        // 在
//        ScreenBroadCastListener listener = new ScreenBroadCastListener(this);
//        listener.registerBroadCast();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(ScreenManager.TAG, "[MyService] onDestroy:...");
        super.onDestroy();
    }
}
