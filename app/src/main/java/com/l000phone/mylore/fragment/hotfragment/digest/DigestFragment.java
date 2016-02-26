package com.l000phone.mylore.fragment.hotfragment.digest;

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
import com.l000phone.mylore.adapter.BookAdapter;
import com.l000phone.mylore.base.BaseFragment;
import com.l000phone.mylore.comment.CommentUri;
import com.l000phone.mylore.entitys.BookSelect;
import com.l000phone.mylore.myinterface.OnContantsButtonLisenter;
import com.l000phone.mylore.xutil.HttpUtil2;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * 书摘界面
 */
public class DigestFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView>, OnContantsButtonLisenter {

    private BookSelect bookSelect;
    private PullToRefreshListView listview;
    private List<BookSelect.DataEntity> datas;
    private BookAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.digest_fragment, container, false);
        /*初始化界面*/
        initView(ret);
         /*注册*/
        EventBus.getDefault().register(this);
        bookSelect = new BookSelect(this.getClass().getName());
        HttpUtil2.getData(CommentUri.BookUri, page, bookSelect, null);
        return ret;
    }

    private void initView(View ret) {
        listview = ((PullToRefreshListView) ret.findViewById(R.id.book_listview));
        listview.setMode(PullToRefreshBase.Mode.BOTH);//设置刷新方式
    }

    @Subscribe
    public void onMainThread(BookSelect data) {
        if (data != null) {
           /*给ListView绑定数据*/
            addDataToListView(data);
        }
    }

    private void addDataToListView(final BookSelect data) {
        if (page == 1) {
            datas = data.getData();
            if (datas != null) {
                 /*构建适配器*/
                adapter = new BookAdapter(datas, activity, this);
                //绑定适配器
                listview.setAdapter(adapter);
            }
        } else {
            datas.addAll(data.getData());
            adapter.notifyDataSetChanged();
        }
            /*数据加载完后关闭加载*/
        listview.onRefreshComplete();
        isRefreshing = false;
            /*给PullToRefreshListView添加监听器*/
        listview.setOnRefreshListener(this);
        /*给ListView添加监听事件*/
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, SildeActivity.class);
                String id1 = data.getData().get(position-1).getId();
                String name = data.getData().get(position-1).getUser().getName();
                String icon = data.getData().get(position-1).getUser().getIcon();

                intent.putExtra("id", id1);
                intent.putExtra("Tag", 2);
                intent.putExtra("name", name);
                intent.putExtra("icon", icon);
                startActivity(intent);
            }
        });
    }

    /*ListView控件监听*/
    @Override
    public void OnFriendsButtonClick(View view, int posiation) {
        switch (view.getId()) {
            case R.id.select_talk:
                startActivity(new Intent(getActivity(), CommentActivity.class));
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        if (!isRefreshing) {
            page = 1;
            HttpUtil2.getData(CommentUri.SelectUri, page, bookSelect, null);
            isRefreshing = true;
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        if (!isRefreshing) {
            page++;
            HttpUtil2.getData(CommentUri.SelectUri, page, bookSelect, null);
            isRefreshing = true;
        }
    }
}
