package com.l000phone.mylore.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.l000phone.mylore.R;
import com.l000phone.mylore.wxapi.ShareTravel;

/**
 * 上边的弹出菜单
 */
public class PopUpWindowActivity extends Activity implements CompoundButton.OnCheckedChangeListener {


    private CheckBox store;
    private CheckBox share;
    private CheckBox sort;
    private CheckBox copy;
    private CheckBox report;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        //获得界面控件
        store = ((CheckBox) findViewById(R.id.popup_store));
        share = ((CheckBox) findViewById(R.id.popup_share));
        sort = ((CheckBox) findViewById(R.id.popup_sort));
        copy = ((CheckBox) findViewById(R.id.popup_copy));
        report = ((CheckBox) findViewById(R.id.popup_report));

        store.setOnCheckedChangeListener(this);
        share.setOnCheckedChangeListener(this);
        report.setOnCheckedChangeListener(this);
        copy.setOnCheckedChangeListener(this);
        sort.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.popup_store:
                if (store.isChecked()) {
                    store.setChecked(true);
                    store.setText("已收藏");
                    Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();
                } else {
                    store.setChecked(false);
                    store.setText("收藏");
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.popup_share:
                ShareTravel.showShare(this);
                break;
            case R.id.popup_sort:
                if (sort.isChecked()) {
                    sort.setChecked(true);
                    store.setText("倒序");
                } else {
                    sort.setChecked(false);
                    store.setText("正序");
                }
                break;
            case R.id.popup_copy:
                Toast.makeText(this, "已复制", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_report:
                Toast.makeText(this, "已举报", Toast.LENGTH_SHORT).show();
                break;
        }
        finish();
    }

}
