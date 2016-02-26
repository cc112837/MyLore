package com.l000phone.mylore;

import android.os.Bundle;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.l000phone.mylore.adapter.FoundPullToAdapter;

import de.greenrobot.event.EventBus;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class BookCommonActivity extends SwipeBackActivity {

    private TextView common_title;
    private PullToRefreshListView common_pullto;
    private FoundPullToAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_common);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initWidget();
    }

    private void initWidget() {
        EventBus.getDefault().register(this);
        common_title = ((TextView) findViewById(R.id.common_title));
        common_pullto = ((PullToRefreshListView) findViewById(R.id.common_pullto));
        aboutPullto();
    }

    private void aboutPullto() {
        adapter = new FoundPullToAdapter(this);
        common_pullto.setAdapter(adapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
