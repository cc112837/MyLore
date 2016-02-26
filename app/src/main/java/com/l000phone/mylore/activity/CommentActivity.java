package com.l000phone.mylore.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.l000phone.mylore.R;

/**
 * 评论界面
 */
public class CommentActivity extends Activity implements View.OnClickListener {

    private ImageView back;
    private TextView send;
    private EditText contants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_activity);
        /*获得界面控件*/
        initView();
    }

    private void initView() {
        back = ((ImageView) findViewById(R.id.comment_back));
        send = ((TextView) findViewById(R.id.comment_send));
        contants = ((EditText) findViewById(R.id.comment_contants));
        back.setOnClickListener(this);
        send.setOnClickListener(this);
        contants.setFocusable(true);
        contants.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comment_back:
                finish();
                break;
            case R.id.comment_send:
                Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
