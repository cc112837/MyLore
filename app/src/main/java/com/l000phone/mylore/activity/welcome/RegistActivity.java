package com.l000phone.mylore.activity.welcome;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.l000phone.mylore.MainActivity;
import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.User;

import java.io.File;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;


/**
 * 注册界面
 */
public class RegistActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView back, photo;
    private EditText phone, pwd, againPwd;
    private Button regist;
    private int REQUEST_CODE_PICK_IMAGE = 100;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        Bmob.initialize(this, "8315ecb0a230e8b31a3092227ee8f96f");
        /*获得界面的控件*/
        initView();
    }

    private void initView() {

        back = ((ImageView) findViewById(R.id.regist_back));
        photo = ((ImageView) findViewById(R.id.regist_photo));
        phone = ((EditText) findViewById(R.id.regist_phone));
        pwd = ((EditText) findViewById(R.id.regist_pwd));
        againPwd = ((EditText) findViewById(R.id.regist_againpwd));
        regist = ((Button) findViewById(R.id.regist));
        back.setOnClickListener(this);
        regist.setOnClickListener(this);
        photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_back:
                finish();
                break;
            case R.id.regist:
                userLogin();
                break;
            case R.id.regist_photo:
                Intent intent2 = new Intent(//固定写法
                        Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent2, REQUEST_CODE_PICK_IMAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri photoData = data.getData();
        if (photoData != null) {
            //查询 uri,返回数据只要图片的实际地址MediaStore.Images.Media.DATA
            Cursor query = getContentResolver().query(photoData, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            while (query.moveToNext()) {
                //获取图片实际地址所在列的索引
                int index = query.getColumnIndex(MediaStore.Images.Media.DATA);
                //获取到图片的实际地址
                string = query.getString(index);
                Bitmap bitmap = BitmapFactory.decodeFile(string);
                photo.setImageBitmap(bitmap);
            }
        }
    }

    private void userLogin() {

        final String phone = this.phone.getText().toString();
        final String pwd = this.pwd.getText().toString();
        String againPwd = this.againPwd.getText().toString();
        /*判断两次输入的密码是否一致*/
        if (pwd.equals(againPwd) && pwd != null && phone != null) {
            final User user = new User();
            if (string != null) {
           /*用户注册上传*/
                final BmobFile file = new BmobFile(new File(string));
                file.upload(this, new UploadFileListener() {
                    @Override
                    public void onSuccess() {
                        userSet(user, phone, pwd);
                        user.setIcon(file);
                        LoginLisenter(user);
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
            } else {
                userSet(user, phone, pwd);
                LoginLisenter(user);
            }

        } else if (phone == null) {
            Toast.makeText(this, "号码不能为空", Toast.LENGTH_SHORT).show();
        } else if (pwd == null) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoginLisenter(final User user) {
        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(RegistActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*设置用户信息*/
    private void userSet(User user, String phone, String pwd) {

        user.setUsername(phone);
        user.setMobilePhoneNumber(phone);
        user.setPassword(pwd);
    }
}
