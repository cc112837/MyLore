package com.l000phone.mylore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.l000phone.mylore.adapter.LuanFanShuList2Adapter;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitle;
import com.l000phone.mylore.utils.logutils.LogUtils;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class LuanFanShuList2 extends SwipeBackActivity {

    private FoundLuanFanShuTitle dataSource;
    private ListView luanfanshu_2_listview;
    private TextView luanfanshu_2_title;
    private ImageView luanfanshu_2_goback;
    private LuanFanShuList2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luan_fan_shu_list2);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initWidget();
    }

    private void initWidget() {

        luanfanshu_2_goback = ((ImageView) findViewById(R.id.luanfanshu_2_goback));
        luanfanshu_2_title = ((TextView) findViewById(R.id.luanfanshu_2_title));

        luanfanshu_2_listview = ((ListView) findViewById(R.id.luanfanshu_2_listview));
        aboutListview();
        luanfanshu_2_goback = ((ImageView) findViewById(R.id.luanfanshu_2_goback));
        luanfanshu_2_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void aboutListview() {
        adapter = new LuanFanShuList2Adapter(this);

        luanfanshu_2_listview.setAdapter(adapter);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {

            dataSource = (FoundLuanFanShuTitle) bundle.getSerializable("dataSource2");
            if(dataSource.getClassifications()!=null){
                LogUtils.log("zouleme 000","-------------------");
                adapter.setDataSource(dataSource.getClassifications());
                luanfanshu_2_listview.setAdapter(adapter);
                luanfanshu_2_title.setText(dataSource.getLabel());
            }
        }
        TextView empty = new TextView(this);
        empty.setText("暂无内容");
        luanfanshu_2_listview.setEmptyView(empty);
    }
}
