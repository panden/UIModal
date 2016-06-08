package com.i370.ui.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siwei.zhao on 2016/6/8.
 * Activity管理器
 */
public class MyActivityManager {

    private List<Activity> mActivities;
    private List<OnAppExitListener> mExitListeners;

    private MyActivityManager(){
        mActivities=new ArrayList<Activity>();
        mExitListeners=new ArrayList<OnAppExitListener>();
    };

    private static MyActivityManager sManager;

    public static MyActivityManager getManager(){
        if(sManager==null)sManager=new MyActivityManager();
        return sManager;
    }

    public void addActivity(Activity pActivity){
        if(pActivity==null)return;
        if(!mActivities.contains(pActivity))mActivities.add(pActivity);
    }

    public void moveActivity(Activity pActivity){
        if(mActivities.contains(pActivity))mActivities.remove(pActivity);
    }

    public Activity getLastActivity(){
        if(mActivities.size()>0)return mActivities.get(mActivities.size()-1);
        return null;
    }

    public Activity getFirstActivity(){
        if(mActivities.size()>0)return mActivities.get(0);
        return null;
    }

    public Activity getActivity(String clzName){
        if(mActivities.size()>0){
            for(Activity act:mActivities){
                if(act.getClass().getName().equals(clzName)){
                    return act;
                }
            }
        }
        return null;
    }

    public void bindAppExitListener(OnAppExitListener listener){
        if(listener==null)return;
        if(!mExitListeners.contains(listener))mExitListeners.add(listener);
    }

    /**退出APP*/
    public void ExitApp(){
        for(OnAppExitListener listener:mExitListeners)listener.onAppStartExit();
        for(Activity act: mActivities){
            for(OnAppExitListener listener:mExitListeners)listener.onActivityStartExit(act);
        }
    }

    public interface OnAppExitListener{

        /**当每个Activity准备退出的时候*/
        void onActivityStartExit(Activity act);

        /**APP准备退出的时候*/
        void onAppStartExit();

    }

}
