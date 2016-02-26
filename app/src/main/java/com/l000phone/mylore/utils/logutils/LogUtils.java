package com.l000phone.mylore.utils.logutils;

import android.util.Log;

/**
 * Created by Administrator on 2015/11/11.
 */
public class LogUtils {
    private static boolean isLog = true;

    public static void log(String tag, String message) {
        if (isLog && message != null) {
            Log.e(tag, message);
        }
    }
}
