package com.l000phone.mylore.activity.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.l000phone.mylore.MainActivity;
import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.User;

import java.util.HashMap;

import cn.bmob.v3.listener.SaveListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;


/**
 * 登录和注册主界面
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener, Handler.Callback, PlatformActionListener {

    private ImageView back, wb, wx;
    private EditText phone, pwd;
    private Button login, regist, look;
    private static final int MSG_AUTH_CANCEL = 2;
    private static final int MSG_AUTH_ERROR = 3;
    private static final int MSG_AUTH_COMPLETE = 4;
    private Handler handler;
    private int my = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        handler = new Handler(this);
        /*初始化界面*/
        initView();
    }

    private void initView() {
        back = ((ImageView) findViewById(R.id.login_back));
        wb = ((ImageView) findViewById(R.id.login_wb));
        wx = ((ImageView) findViewById(R.id.login_wx));
        phone = ((EditText) findViewById(R.id.login_phone));
        pwd = ((EditText) findViewById(R.id.login_pwd));
        login = ((Button) findViewById(R.id.user_login));
        regist = ((Button) findViewById(R.id.user_regist));
        look = ((Button) findViewById(R.id.login_look));

        back.setOnClickListener(this);
        regist.setOnClickListener(this);
        look.setOnClickListener(this);
        wb.setOnClickListener(this);
        wx.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                if (my == 1) {
                    finish();
                } else {

                }
                break;
            case R.id.login_look:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.login_wb:
                //新浪微博
                Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
                authorize(sina);
                break;
            case R.id.login_wx:
                //打包签名apk,然后才能产生微信的登录
                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
                authorize(wechat);
                break;
            case R.id.user_login:
                userLogin();
                break;
            case R.id.user_regist:
                startActivity(new Intent(this, RegistActivity.class));
                break;

        }
    }

    /*用户登陆*/
    private void userLogin() {
        String phone = this.phone.getText().toString();
        String pwd = this.pwd.getText().toString();
        User user = new User();
        user.setUsername(phone);
        user.setPassword(pwd);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void authorize(Platform plat) {

        plat.setPlatformActionListener(this);
        //关闭SSO授权
        plat.SSOSetting(true);
        plat.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
        if (action == Platform.ACTION_USER_INFOR) {
            Message msg = new Message();
            msg.what = MSG_AUTH_COMPLETE;
            msg.obj = new Object[]{platform.getName(), res};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int action, Throwable throwable) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
        throwable.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int action) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_AUTH_CANCEL: {
                //取消授权
                Toast.makeText(this, R.string.auth_cancel, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_ERROR: {
                //授权失败
                Toast.makeText(this, R.string.auth_error, Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_COMPLETE: {
                //授权成功
                Toast.makeText(this, R.string.auth_complete, Toast.LENGTH_SHORT).show();

            }
            break;

        }
        return false;
    }
}
