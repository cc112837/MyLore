package com.l000phone.mylore.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.l000phone.mylore.R;
import com.l000phone.mylore.adapter.FoundPullToAdapter;
import com.l000phone.mylore.entitys.FoundSelectBook;
import com.l000phone.mylore.entitys.SearchSearch;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.l000phone.mylore.xutil.MyHttpUtil;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchSearchFragemnt extends Fragment {


    private PullToRefreshListView search_pullto;
    private List<FoundSelectBook> dataSource;
    private int currentPage=1;
    private FoundPullToAdapter adapter;
    private String name;
    public SearchSearchFragemnt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_search_fragemnt, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        Bundle bundle = getArguments();
        if(bundle!= null){
            name = bundle.getString("name");
            LogUtils.log("数据","---"+name);
        }
        EventBus.getDefault().register(this);
        MyHttpUtil.getData(FoundCommon.Url_Search_Search + name + "&page=1", 0, new SearchSearch(this.getClass().getName()), null, getContext(), "search_search");
        search_pullto = ((PullToRefreshListView) view.findViewById(R.id.search_pullto));
        search_pullto.setMode(PullToRefreshBase.Mode.BOTH);
        adapter = new FoundPullToAdapter(getContext());
        search_pullto.setAdapter(adapter);

        search_pullto.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新;
                MyHttpUtil.getData(FoundCommon.Url_Search_Search + name + "&page=1", 0, new SearchSearch(this.getClass().getName()), null, getContext(), "search_search");

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上啦加载
                currentPage++;
                MyHttpUtil.getData(FoundCommon.Url_Search_Search + name + "&page=" + currentPage, 0, new SearchSearch(this.getClass().getName()), null, getContext(), "search_search");

            }
        });
    }

    @Subscribe
    public void onEventMainThread(SearchSearch data) {
        LogUtils.log("-----------------",data.toString());
        dataSource = data.getData();
        if(currentPage ==1){
            adapter.setDataSource(dataSource);
        }else if(currentPage>1){
            adapter.addDataToDataSource(dataSource);
        }
        adapter.notifyDataSetChanged();
        search_pullto.onRefreshComplete();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
