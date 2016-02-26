package com.l000phone.mylore.xutil;


import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.l000phone.mylore.entitys.FoundLuanFanShu;
import com.l000phone.mylore.entitys.FoundLuanFanShuList;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitle;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitleList;
import com.l000phone.mylore.entitys.MessengeString;
import com.l000phone.mylore.utils.fileutils.FileUtils;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.lang.reflect.Type;
import java.util.List;

import de.greenrobot.event.EventBus;


/**
 * MyRequest类
 */
public class MyCallBack extends RequestCallBack<String> {


    private MessengeString datasource;
    private String tag;
    private Context context;
    private String fileName;

    public MyCallBack(MessengeString datasource, Context context, String fileName) {
        this.datasource = datasource;
        this.context = context;
        this.fileName = fileName;
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
            if (datasource instanceof FoundLuanFanShu ) {
                LogUtils.log("解析","===================FoundLuanFanShu");
                Type type = new TypeToken<List<FoundLuanFanShu>>() {
                }.getType();
                FoundLuanFanShuList list = new FoundLuanFanShuList();
                list.setLuanfanshu((List<FoundLuanFanShu>) new Gson().fromJson(responseInfo.result, type));
                EventBus.getDefault().post(list);
            } else if( datasource instanceof FoundLuanFanShuTitle) {
                LogUtils.log("解析","------FoundLuanFanShuTitle");
                Type type = new TypeToken<List<FoundLuanFanShuTitle>>() {
                }.getType();
                FoundLuanFanShuTitleList list = new FoundLuanFanShuTitleList();
                list.setTitle((List<FoundLuanFanShuTitle>) new Gson().fromJson(responseInfo.result, type));
                EventBus.getDefault().post(list);
            }else {
                datasource = new Gson().fromJson(responseInfo.result,
                        datasource.getClass());
                datasource.setStr(tag);//解析后的对象
                EventBus.getDefault().post(datasource);
            }
            if (fileName != null) {
                FileUtils.writeDataToFile(responseInfo.result, fileName, context);
            }
        }
    }

    /*失败时调用的方法*/
    @Override
    public void onFailure(HttpException error, String msg) {
        Toast.makeText(context, "网络连接异常", Toast.LENGTH_LONG).show();

        String s = FileUtils.readDataFromFile(fileName, context);

        if (datasource.getStr() != null) {
            tag = datasource.getStr();
        }
        if (s != null) {
        /*解析数据*/
            if (fileName.equals("found_luanfanshu") ) {
                Type type = new TypeToken<List<FoundLuanFanShu>>() {
                }.getType();
                EventBus.getDefault().post(new Gson().fromJson(s, type));
            }else if( fileName.equals("found_luanfanshu_title")) {
                Type type = new TypeToken<List<FoundLuanFanShuTitle>>() {
                }.getType();
                EventBus.getDefault().post(new Gson().fromJson(s, type));
            }else {
                datasource = new Gson().fromJson(s,
                        datasource.getClass());
                datasource.setStr(tag);//解析后的对象
                EventBus.getDefault().post(datasource);
            }
        }


    }
}
