package com.l000phone.mylore.xutil;



import android.content.Context;

import com.l000phone.mylore.entitys.MessengeString;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * 下载网络请求类
 */
public class MyHttpUtil {

    //定义HttpUtils全局变量,可以复用
    private static HttpUtils http = new HttpUtils();

    //发送网络请求的方法
    /*params:post请求的参数*/
    public static void sendData(HttpRequest.HttpMethod method, String url,
                                RequestParams params, RequestCallBack callBack) {
        try {
            URL url1 = new URL(url);
            //判断请求方式
            if (method == HttpRequest.HttpMethod.GET) {
                http.send(method, String.valueOf(url1), params, callBack);
            } else {
                LogUtils.log("请求数据","--------------post请求");
                http.send(method, String.valueOf(url1), params, callBack);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /*HttpUtils调用send方法下载数据*/
    public static void getData(String uri, int page, MessengeString str,RequestParams params,Context context,String fileName) {
        if (page!=0) {
            sendData(HttpRequest.HttpMethod.GET,uri + page, params,
                    new MyCallBack(str,context,fileName));
        } else {
            LogUtils.log("请求数据","-------------------");
            sendData(HttpRequest.HttpMethod.GET, uri, params,
                    new MyCallBack(str,context,fileName));
        }

    }

}
