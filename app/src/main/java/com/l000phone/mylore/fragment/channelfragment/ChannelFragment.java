package com.l000phone.mylore.fragment.channelfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.l000phone.mylore.ChannelDetailActivity;
import com.l000phone.mylore.R;
import com.l000phone.mylore.SearchActivity;
import com.l000phone.mylore.adapter.AllChaAdapter;
import com.l000phone.mylore.adapter.HotChaAdapter;
import com.l000phone.mylore.entitys.ChanelHot;
import com.l000phone.mylore.entitys.ChannelAll;
import com.l000phone.mylore.myinterface.BooKDeInter;
import com.l000phone.mylore.myinterface.MyRecyItemClickListener;
import com.l000phone.mylore.xutil.HttpUtil;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment {
    private RecyclerView rv_allchannelid;
    private GridView gv_hotchannelid;

    public ChannelFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_fragemnt, container, false);
        EventBus.getDefault().register(this);
        init(view);
        return view;
    }

    private void init(View view) {
        HttpUtil.getData(BooKDeInter.channelhoturi, 0, new ChanelHot(this.getClass().getName()), null);
        HttpUtil.getData(BooKDeInter.allchanneluri, 0, new ChannelAll(this.getClass().getName()), null);
        ImageView iv_my_settingid = ((ImageView) view.findViewById(R.id.iv_my_settingid));
        iv_my_settingid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        rv_allchannelid = ((RecyclerView) view.findViewById(R.id.rv_allchannelid));
        RecyclerViewHeader headhot = RecyclerViewHeader.fromXml(getContext(), R.layout.channel_head);
        gv_hotchannelid = ((GridView) headhot.findViewById(R.id.gv_hotchannelid));
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        rv_allchannelid.setLayoutManager(manager);
        headhot.attachTo(rv_allchannelid);

    }

    @Subscribe
    public void onMainEventThread(ChanelHot chanelHot) {
        final List<ChanelHot.DataEntity> data = chanelHot.getData();
        HotChaAdapter hotChaAdapter = new HotChaAdapter(getContext(), data);
        gv_hotchannelid.setAdapter(hotChaAdapter);
        gv_hotchannelid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ChannelDetailActivity.class);
                intent.putExtra("uid", data.get(position).getId() + "");
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onMainEventThread(ChannelAll channelAll) {
        final List<ChannelAll.DataEntity> data = channelAll.getData();
        AllChaAdapter allChaAdapter = new AllChaAdapter(getContext(), data);
        rv_allchannelid.setAdapter(allChaAdapter);
        allChaAdapter.setOnItemClickListener(new MyRecyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ChannelDetailActivity.class);
                intent.putExtra("uid", data.get(position).getId() + "");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
