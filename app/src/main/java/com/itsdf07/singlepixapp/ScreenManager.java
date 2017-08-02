package com.itsdf07.singlepixapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by itsdf07 on 2017/7/22.
 */

public class ScreenManager {
    private Context mContext;
    public static final String TAG = "dfsu";
    private static ScreenManager mInstance;
    public static final String BROADCAST_ACTION_FINISH = "BROADCAST_ACTION_FINISH";

    public static ScreenManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ScreenManager.class) {
                mInstance = new ScreenManager(context);
            }
        }
        return mInstance;
    }

    private ScreenManager(Context context) {
        Log.d(ScreenManager.TAG, "ScreenManager : ...");
        mContext = context;
    }

    public void startActivity() {
        Log.d(ScreenManager.TAG, "ScreenManager : startActivity ...");
        Intent intent = new Intent(mContext, SinglePixActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public void finishActivity() {
        Log.d(ScreenManager.TAG, "ScreenManager : finishActivity ...");
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION_FINISH);
        mContext.sendBroadcast(intent);

    }
}
