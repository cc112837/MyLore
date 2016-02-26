package com.l000phone.mylore;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import cn.sharesdk.framework.ShareSDK;

/**
 * 缓存只需要创建一次,所以在节点添加name
 */
public class MyApp extends Application {

    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
        ShareSDK.initSDK(this, "c0be093b5146");
        initLoader();
    }

    /*对外提供一个获得imageLoader的方法,从缓存中提取图片*/
    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private void initLoader() {
        /*创建系统自带的缓存,缓存最大值为内存最大值的1/8*/
        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>((int)
                (Runtime.getRuntime().totalMemory() / 8)) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    /*创建 imageloader 第一个参数是请求队列,第二个是缓存,在缓存内部我们调用了另外一个缓存*/
        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                /*获取缓存图片,以地址作为获得缓存的key*/
                Bitmap bitmap = lruCache.get(url);
                return bitmap;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                /*将图片放入缓存中*/
                lruCache.put(url, bitmap);
            }
        });
    }


}
