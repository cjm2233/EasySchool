package com.example.easyschool.utils;

import android.app.Activity;
import android.os.Process;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjm
 * @class describe
 * @time 2020-01-08 10:14
 */
public class ActivityUtil {
    private List<Activity> activityList = new ArrayList<Activity>();
    private static ActivityUtil instance;

    public static synchronized ActivityUtil getInstance() {
        if (null == instance) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    public void exitSystem() {
        for (Activity activity : activityList) {
            if (activity != null) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
