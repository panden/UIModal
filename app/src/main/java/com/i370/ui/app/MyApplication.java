package com.i370.ui.app;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.List;

/**
 * Created by siwei.zhao on 2016/6/2.
 */
public class MyApplication extends Application {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate() {
        super.onCreate();
        ActivityManager manager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info: infos){
            Log.e("AppProgress", "=================AppProgress processName="+info.processName);
        }
    }
}
