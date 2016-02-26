package com.l000phone.mylore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.l000phone.mylore.R;
import com.l000phone.mylore.fragment.ChangeFragmentHelper;
import com.l000phone.mylore.fragment.ChangeSildeFragment;
import com.l000phone.mylore.fragment.hotfragment.WebFragment;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 滑动销毁界面
 */
public class SildeActivity extends SwipeBackActivity {
    private int Tag;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silde);
        swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        Intent intent = getIntent();
        int tag = intent.getExtras().getInt("Tag");
        ChangeFragmentHelper helper = new ChangeFragmentHelper();
        switch (tag) {
            case 1:
               //// TODO: 2015/11/22  

                break;
            case 2:
                String id = intent.getStringExtra("id");
                String name = intent.getStringExtra("name");
                String icon = intent.getStringExtra("icon");
                WebFragment webFragment = new WebFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString("name", name);
                bundle.putString("icon", icon);
                helper.setBundle(bundle);
                helper.setFragment(webFragment);

                break;
        }
        ChangeSildeFragment.changeFragment(helper,
                getSupportFragmentManager());
        Log.i("tag", tag + "");
    }
}
