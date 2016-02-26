package com.l000phone.mylore.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.l000phone.mylore.MyApp;
import com.l000phone.mylore.entitys.MessengeString;

import java.util.Map;

/**
 * Volley的传值
 */
public class MyStringRequest extends StringRequest {
    private Map<String, String> map;

//    /*通过Handler传值*/
//    public MyStringRequest(String url, MessengeString str, Handler handler, int what) {
//        super(url, new MyListener(str, handler, what), new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        /*把StringRequest添加到requestQueue(缓存)中*/
//        MyApp.getRequestQueue().add(this);
//    }

    /*通过EventBus传值
     *object:要下载的数据对象
     *  */
//    public MyStringRequest(String url, MessengeString str) {
//        super(url, new MyListener(str), new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        /*把StringRequest添加到requestQueue(缓存)中*/
//        MyApp.getRequestQueue().add(this);
//    }
    public MyStringRequest(int method, String url, Object object, RequestQueue requestQueue, Map map, Context context,String fileName) {
        super(method, url, new MyListener(object, context,fileName), new MyErrorListener(object,context,fileName));
        this.map = map;
        requestQueue.add(this);
    }

    public MyStringRequest(String url, Object object, RequestQueue requestQueue, Context context,String fileName) {
        super(url, new MyListener(object, context,fileName), new MyErrorListener(object,context,fileName));

        requestQueue.add(this);

    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
