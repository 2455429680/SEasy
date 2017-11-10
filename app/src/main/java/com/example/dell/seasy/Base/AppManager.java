package com.example.dell.seasy.Base;

/**
 * Created by DELL on 2017/10/28.
 */

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * activity堆栈式管理
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager appManager;

    private AppManager(){

    }
    public static AppManager getAppManager(){
        if (appManager==null)
           appManager=new AppManager();
        return appManager;
    }
    /**
     * 添加activity‘
     *
     */
    public void addActivity(Activity activity){
        if (activityStack==null)
            activityStack=new Stack<Activity>();
        activityStack.add(activity);
    }

    /**
     * 获取当前activity
     * @return
     */
    public Activity getActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }
    /**
     * 结束当前activity
     */
    public void finishActivity(){
        Activity activity=activityStack.lastElement();
        finishActivity(activity);
    }
    public void finishActivity(Activity activity){
        if (activity!=null&&!activity.isFinishing()){
            activityStack.remove(activity);
            activity.finish();;
            activity=null;
        }

    }
    public void finishActivity(Class<?> cls){
        for (Activity activity:activityStack){
            if (activity.equals(cls))
            {
                finishActivity(activity);
            }
        }
    }
    public void finishAllActivity(){
        for (int i=0;i<activityStack.size();i++){
            if (activityStack.get(i)!=null){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();;
    }
    public Activity getActivity(Class<?> cls){
        if (activityStack!=null){
            for (Activity activity:activityStack){
                if (activity.getClass().equals(cls))
                    return activity;
            }
        }
        return null;
    }
    public void AppExit(Context context){
        try {
            finishActivity();
            android.os.Process.killProcess(android.os.Process.myPid());;
            System.exit(0);
        }catch (Exception e){

        }
    }
}
