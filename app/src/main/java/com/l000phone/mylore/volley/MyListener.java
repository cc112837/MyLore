package com.l000phone.mylore.volley;

import android.content.Context;
import android.os.Handler;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.l000phone.mylore.utils.fileutils.FileUtils;

import de.greenrobot.event.EventBus;

/**
 * 下载的数据,传出去到接收页面
 */
public class MyListener implements Response.Listener<String> {
    private Object object;
    private Handler handler;
    private int what;
    private Context context;
    private String fileName;

    public MyListener(Object object, Handler handler, int what) {
        this.object = object;
        this.handler = handler;
        this.what = what;
    }

    public MyListener(Object object, Handler handler, int what, Context context, String fileName) {
        this.object = object;
        this.handler = handler;
        this.what = what;
        this.context = context;
        this.fileName = fileName;
    }

    public MyListener(Object object, Context context, String fileName) {
        this.object = object;
        this.context = context;
        this.fileName = fileName;
    }

    public MyListener(Object object) {
        this.object = object;
    }

    @Override
    public void onResponse(String response) {

        if (response != null) {
           Object obj = new Gson().fromJson(response, object.getClass());
             /*Eventbus传值*/
            EventBus.getDefault().post(obj);
            FileUtils.writeDataToFile(response, fileName, context);
        }
//        /*handler传值*/
//        Message message = handler.obtainMessage();
//        message.obj = str;
//        message.what = what;
//        handler.sendMessage(message);


    }
}
