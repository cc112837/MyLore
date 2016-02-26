package com.l000phone.mylore.fragment.foundfragemnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l000phone.mylore.R;
import com.l000phone.mylore.adapter.FoundGalleryAdapter;
import com.l000phone.mylore.entitys.FoundLuanFanShu;
import com.l000phone.mylore.entitys.FoundLuanFanShuList;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.xutil.MyCallBack;
import com.l000phone.mylore.xutil.MyHttpUtil;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundLuanFanShuFragment extends Fragment {
    private RecyclerView recyclerView;
    private  FoundGalleryAdapter adapter;

    public FoundLuanFanShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_found_luan_fan_shu, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        Bundle bundle = getArguments();
        if(bundle != null){
            String id = bundle.getString("id");
            EventBus.getDefault().register(this);
            RequestParams params = new RequestParams();
            params.addBodyParameter("classification",id);
            MyHttpUtil.sendData(HttpRequest.HttpMethod.POST, FoundCommon.Url_LuanFanShu, params, new MyCallBack(new FoundLuanFanShu(this.getClass().getName()), getContext(), "found_luanfanshu"));
            recyclerView = ((RecyclerView) view.findViewById(R.id.found_recyclerview));
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(manager);
            adapter = new FoundGalleryAdapter(getContext());
            recyclerView.setAdapter(adapter);
        }
    }
    @Subscribe
    public void onEventMainThread(FoundLuanFanShuList data){
        adapter.setDataSource(data.getLuanfanshu());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
