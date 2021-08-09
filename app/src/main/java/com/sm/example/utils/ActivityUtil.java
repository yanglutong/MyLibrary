package com.sm.example.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
/**Activity 管理类
 * @description 
 * @param
 * @return 
 * @author lutong
 * @time 2021/8/4 17:27
 */
public class ActivityUtil {
    private List<Activity> activityList = new ArrayList<>();
    private static ActivityUtil instance;

    // 单例模式中获取唯一的ExitApplication实例
    public static synchronized ActivityUtil getInstance() {
        if (null == instance) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    /**
     * @description
     * @param activity  Activity
     * @return
     * @author lutong
     * @time 2021/8/4 17:31
     */

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activityList == null)
            activityList = new ArrayList<>();
        activityList.add(activity);
    }

    // 移除Activity
    public void removeActivity(Activity activity) {
        if (activityList != null)
            activityList.remove(activity);
    }

    // 遍历所有Activity并finish
    public void exitSystem() {
        for (Activity activity : activityList) {
            if (activity != null)
                activity.finish();
        }
        // 退出进程
        ActivityUtil.getInstance().exitSystem();
        System.exit(0);
    }

}
