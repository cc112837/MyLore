package com.l000phone.mylore;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.l000phone.mylore.entitys.FoundLuanFanShuTitle;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitleList;
import com.l000phone.mylore.fragment.foundfragemnt.FoundLuanFanShuFragment;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.l000phone.mylore.xutil.MyHttpUtil;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class FoundGallery extends SwipeBackActivity {

    private TabLayout luanfanshu_tablayout;
    private List<FoundLuanFanShuTitle> dataSource;
    private FoundLuanFanShuTitleList total;
    private ImageView luanfanshu_goback;
    private ImageView luanfanshu_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_gallery);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initView();

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.luanfanshu_llcontainer, new FoundLuanFanShuFragment()).commit();
    }

    private void initView() {
        luanfanshu_list = ((ImageView) findViewById(R.id.luanfanshu_list));
        luanfanshu_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoundGallery.this, FoundLuanFanShuList.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dataSource", total);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        luanfanshu_goback = ((ImageView) findViewById(R.id.luanfanshu_goback));
        luanfanshu_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EventBus.getDefault().register(this);
        luanfanshu_tablayout = ((TabLayout) findViewById(R.id.luanfanshu_tablayout));
        luanfanshu_tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FoundLuanFanShuFragment fragment = new FoundLuanFanShuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", dataSource.get(tab.getPosition()).getId());
                fragment.setArguments(bundle);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.luanfanshu_llcontainer, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        MyHttpUtil.getData(FoundCommon.Url_LuanFanShuTitle, 0, new FoundLuanFanShuTitle(this.getClass().getName()), null, FoundGallery.this, "found_luanfanshu_title");
    }

    @Subscribe
    public void onEventMainThread(FoundLuanFanShuTitleList data) {
        LogUtils.log("返回数据", "------------------------" + data);
        total = data;
        dataSource = data.getTitle();
        aboutTabLayout();
    }

    private void aboutTabLayout() {
        for (int i = 0; i < dataSource.size(); i++) {
            TabLayout.Tab tab = luanfanshu_tablayout.newTab();
            luanfanshu_tablayout.addTab(tab.setText(dataSource.get(i).getLabel()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
