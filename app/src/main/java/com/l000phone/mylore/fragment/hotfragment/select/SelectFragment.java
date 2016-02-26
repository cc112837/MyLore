package com.l000phone.mylore.fragment.hotfragment.select;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.l000phone.mylore.R;
import com.l000phone.mylore.activity.CommentActivity;
import com.l000phone.mylore.activity.SildeActivity;
import com.l000phone.mylore.adapter.SelectAdapter;
import com.l000phone.mylore.base.BaseFragment;
import com.l000phone.mylore.comment.CommentUri;
import com.l000phone.mylore.entitys.MySelect;
import com.l000phone.mylore.myinterface.OnContantsButtonLisenter;
import com.l000phone.mylore.xutil.HttpUtil2;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * 精选界面
 */
public class SelectFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView>, OnContantsButtonLisenter {

    private PullToRefreshListView listView;
    private MySelect select;
    private SelectAdapter adapter;
    private List<MySelect.DataEntity> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.select_frgment, container, false);
        /*初始化界面*/
        initView(ret);
        /*注册*/
        EventBus.getDefault().register(this);
        select = new MySelect(this.getClass().getName());
        HttpUtil2.getData(CommentUri.SelectUri, page, select, null);
        return ret;
    }

    private void initView(View ret) {
        listView = ((PullToRefreshListView) ret.findViewById(R.id.select_listview));
        listView.setMode(PullToRefreshBase.Mode.BOTH);//设置刷新方式
    }

    @Subscribe
    public void onMainThread(MySelect data) {
        if (data != null) {
           /*给ListView绑定数据*/
            addDataToListView(data);
        }
    }

    /*添加数据*/
    private void addDataToListView(final MySelect data) {
        if (page == 1) {
            datas = data.getData();
            if (datas != null) {
                 /*构建适配器*/
                adapter = new SelectAdapter(datas, activity, this);
                //绑定适配器
                listView.setAdapter(adapter);
            }
        } else {
            datas.addAll(data.getData());
            adapter.notifyDataSetChanged();
        }
            /*数据加载完后关闭加载*/
        listView.onRefreshComplete();
        isRefreshing = false;
            /*给PullToRefreshListView添加监听器*/
        listView.setOnRefreshListener(this);
        /*给ListView添加监听事件*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, SildeActivity.class);
                String id1 = data.getData().get(position).getId();
                String name = data.getData().get(position).getUser().getName();
                String icon = data.getData().get(position).getUser().getIcon();

                intent.putExtra("id",id1);
                intent.putExtra("Tag", 2);
                intent.putExtra("name",name);
                intent.putExtra("icon",icon);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

        if (!isRefreshing) {
            page = 1;
            HttpUtil2.getData(CommentUri.SelectUri, page, select, null);
            isRefreshing = true;
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        if (!isRefreshing) {
            page++;
            HttpUtil2.getData(CommentUri.SelectUri, page, select, null);
            isRefreshing = true;
        }
    }

    /*条目中事件监听*/
    @Override
    public void OnFriendsButtonClick(View view, int posiation) {
        switch (view.getId()) {
            case R.id.select_talk:
                startActivity(new Intent(getActivity(), CommentActivity.class));
                break;
        }
    }
}
