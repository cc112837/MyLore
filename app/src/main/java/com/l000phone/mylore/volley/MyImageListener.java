package com.l000phone.mylore.volley;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.l000phone.mylore.utils.PicUtil;

/**
 * 给图片控件设置图片
 */
public class MyImageListener implements ImageLoader.ImageListener {
    private ImageView imageView;
    private int defaultimageres;

    public MyImageListener(ImageView imageView, int defaultimageres) {
        this.imageView = imageView;
        this.defaultimageres = defaultimageres;
    }

    @Override
    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
        //获取标记,用于判断我现在想要的图片是什么
        String tag = (String) imageView.getTag();
        //获取当前请求的地址是什么
        String requestUrl = response.getRequestUrl();

        Bitmap bitmap = response.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            //如果想要的和请求的是同一个地址,设置图片
            if (tag != null && tag.equals(requestUrl)) {

                imageView.setImageBitmap(bitmap);

            } else if (tag != null && tag.equals(requestUrl + 1)) {
                //裁剪圆形图片
                Bitmap roundBitmap = PicUtil.toRoundBitmap(bitmap);
                //设置图片
                imageView.setImageBitmap(roundBitmap);
            }
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (defaultimageres != 0) {
            imageView.setImageResource(defaultimageres);//失败了设置默认图片
        }
    }
}
