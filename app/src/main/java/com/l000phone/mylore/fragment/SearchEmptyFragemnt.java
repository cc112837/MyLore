package com.l000phone.mylore.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.SearchActivity;
import com.l000phone.mylore.entitys.Search;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.xutil.MyHttpUtil;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchEmptyFragemnt extends Fragment {


    private ListView search_listview;
    private List<String> dataSource;
    private ArrayAdapter<String> adapter;
    private SearchActivity activity;
    public SearchEmptyFragemnt() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (SearchActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_empty_fragemnt, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        EventBus.getDefault().register(this);
        MyHttpUtil.getData(FoundCommon.Url_Search, 0, new Search(this.getClass().getName()), null, getContext(), "common_serch");
        search_listview = ((ListView) view.findViewById(R.id.search_listview));
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1);
        search_listview.setAdapter(adapter);
        search_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("name",dataSource.get(position));
                activity.setQuery(dataSource.get(position));
                activity.replace(new SearchSearchFragemnt(),bundle);
            }
        });
    }

    @Subscribe
    public void onEventMainThread(Search data){
        dataSource =data.getData();
        adapter.addAll(dataSource);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
