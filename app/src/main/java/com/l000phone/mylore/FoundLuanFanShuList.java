package com.l000phone.mylore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.l000phone.mylore.adapter.LuanFanShuListAdapter;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitle;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitleList;
import com.l000phone.mylore.utils.logutils.LogUtils;

import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class FoundLuanFanShuList extends SwipeBackActivity {

    private ListView luanfanshu_list_listview;
    private ImageView luanfanshu_goback;
    private List<FoundLuanFanShuTitle> dataSource;
    private LuanFanShuListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_luan_fan_shu_list);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initWidget();
    }

    private void initWidget() {

        luanfanshu_list_listview = ((ListView) findViewById(R.id.luanfanshu_list_listview));
        aboutListView();
        luanfanshu_goback = ((ImageView) findViewById(R.id.luanfanshu_goback));
        luanfanshu_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void aboutListView() {
        adapter = new LuanFanShuListAdapter(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!= null){
            dataSource = ((FoundLuanFanShuTitleList) extras.getSerializable("dataSource")).getTitle();
            adapter.setDataSource(dataSource);
//            adapter.notifyDataSetChanged();
            LogUtils.log("zoulee","==============");
            luanfanshu_list_listview.setAdapter(adapter);
        }
        luanfanshu_list_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoundLuanFanShuList.this,LuanFanShuList2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dataSource2",dataSource.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
