package com.l000phone.mylore.volley;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.l000phone.mylore.utils.fileutils.FileUtils;
import com.l000phone.mylore.utils.logutils.LogUtils;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2015/11/17.
 */
public class MyErrorListener implements Response.ErrorListener {
    private Object object;
    private Context context;
    private String fileName;

    /**
     *
     * @param object 要解析的 实体类
     * @param context 上下文
     * @param fileName 缓存存放的文件名
     */
    public MyErrorListener(Object object, Context context, String fileName) {
        this.object = object;
        this.context = context;
        this.fileName = fileName;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //无法判断 fileName文件夹 是否存在 bug...
        String s = FileUtils.readDataFromFile(fileName, context);
        Object obj = new Gson().fromJson(s, object.getClass());
        EventBus.getDefault().post(obj);
        if(!FileUtils.isNetConnect(context)){
            LogUtils.log("判断", "无连接...");
            Toast.makeText(context, "当前无网络连接!!!", Toast.LENGTH_LONG).show();

        }else {
            LogUtils.log("itravel", error.getMessage());
            Toast.makeText(context, "网络下载失败!!!", Toast.LENGTH_LONG).show();
        }
    }
}
