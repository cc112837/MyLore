package com.l000phone.mylore.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.l000phone.mylore.R;


/**
 * 下弹出菜单
 */
public class PopWindowActivity extends Activity implements View.OnClickListener {

    private LinearLayout pop;
    private Button cancel;
    private Button report;
    private Button comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_popmenu_activity);

        cancel = ((Button) findViewById(R.id.pop_cancel));
        comment = ((Button) findViewById(R.id.pop_comment));
        report = ((Button) findViewById(R.id.pop_report));

        pop = ((LinearLayout) findViewById(R.id.poprelative));
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击屏幕任意地方取消",
                        Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(this);
        comment.setOnClickListener(this);
        report.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop_cancel:
                finish();
                break;
            case R.id.pop_report:
                Toast.makeText(this, "已举报", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_comment:
                startActivity(new Intent(this, CommentActivity.class));
                break;
        }
        finish();
    }
}
