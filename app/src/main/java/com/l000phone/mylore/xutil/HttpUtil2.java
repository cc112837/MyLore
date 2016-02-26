package com.l000phone.mylore.xutil;



import com.l000phone.mylore.entitys.MessengeString2;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * 下载网络请求类
 */
public class HttpUtil2 {

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
                http.send(method, String.valueOf(url1), params, callBack);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /*HttpUtils调用send方法下载数据*/
    public static void getData(String uri, int page, MessengeString2 str,RequestParams params) {
        if (page!=0) {
            sendData(HttpRequest.HttpMethod.GET,uri + page, params,
                    new MyRequest2(str));
        } else {
            sendData(HttpRequest.HttpMethod.GET, uri, params,
                    new MyRequest2(str));
        }

    }

}
