package com.l000phone.mylore.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 获得app的版本号
 */
public class packageUtil {


    public static String getPageVerson(Context context) {

        //定义版本号,把获得版本号赋值给它
        String version = "1.0";

        //获得版本号的事务管理器
        PackageManager manager = context.getPackageManager();

        try {
            //获得packageInfo
            PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_ACTIVITIES);
            //获得版本号
            version = packageInfo.versionName;



        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }
}
