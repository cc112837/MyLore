package com.l000phone.mylore.activity.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.l000phone.mylore.R;
import com.l000phone.mylore.utils.packageUtil;


/**
 * 欢迎界面前的判断版本号是否相同界面
 */
public class splashActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        SharedPreferences preferences = getSharedPreferences("version", MODE_PRIVATE);

        //获得参数偏好设置存储的版本
        final String oldVersion = preferences.getString("version", "");

        //获得当前版本的版本号

        final String newVersion = packageUtil.getPageVerson(this);


        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //判断当前版本好是否一致
                if (oldVersion.equals(newVersion)) {

                    //进入主界面
                    Intent intent = new Intent(splashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    //把当前页关闭
                    finish();
                } else {
                    Intent intent = new Intent(splashActivity.this, GuideActivity.class);

                    startActivity(intent);
                    //把当前页关闭
                    finish();
                }
                super.run();
            }
        }.start();

    }
}
