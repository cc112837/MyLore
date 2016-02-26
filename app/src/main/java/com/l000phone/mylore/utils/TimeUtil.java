package com.l000phone.mylore.utils;


import java.util.Date;

/**
 * 时间工具类
 */
public class TimeUtil {

    private static String times;

    public static String getTime(Long time) {

        Date date = new Date();
        long time1 = date.getTime();

        long l = time1 - time;
        if (l > 86400000) {
            long days = l / (1000 * 60 * 60 * 24);
            times = days + "天前";
        } else if (l < 86400000 && l > 3600000) {
            long days = l / (1000 * 60 * 60);
            times = days + "小时前";
        } else {
            long days = l / (1000 * 60);
            times = days + "分前";
        }
        return times;
    }
}
