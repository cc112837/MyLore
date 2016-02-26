package com.l000phone.mylore.xutil;


import com.google.gson.Gson;

import com.l000phone.mylore.entitys.MessengeString;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import de.greenrobot.event.EventBus;


/**
 * MyRequest类
 */
public class MyRequest extends RequestCallBack<String> {


    private MessengeString datasource;
    private String tag;

    public MyRequest(MessengeString data) {
        this.datasource = data;
    }

    /*下载成功时掉用的方法*/
    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        /*把下载后的数据发送过去*/
        if (datasource.getStr() != null) {
            tag = datasource.getStr();
        }
        if (responseInfo.result != null) {
        /*解析数据*/
            datasource = new Gson().fromJson(responseInfo.result,
                    datasource.getClass());
            datasource.setStr( tag);//解析后的对象
            EventBus.getDefault().post(datasource);
        }
    }

    /*失败时调用的方法*/
    @Override
    public void onFailure(HttpException error, String msg) {

    }
}
