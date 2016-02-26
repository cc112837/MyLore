package com.l000phone.mylore.fragment.foundfragemnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l000phone.mylore.R;
import com.l000phone.mylore.adapter.FoundFriendRecyclerAdapter;
import com.l000phone.mylore.entitys.FoundFriend;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.xutil.MyHttpUtil;

import java.util.Random;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundFriendsFragment extends Fragment {

    private RecyclerView recyclerview;
    private Random random;
    private int rand;
    private int currentPage = 1;
    private  FoundFriendRecyclerAdapter adapter;

    public FoundFriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_found_friends, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        EventBus.getDefault().register(this);
        random = new Random();
        rand = random.nextInt(1000);
        MyHttpUtil.getData(FoundCommon.Url_Found_Friend + "&page=1&rand=" + rand, 0, new FoundFriend(this.getClass().getName()), null, getContext(), "found_friend");
        recyclerview = ((RecyclerView) view.findViewById(R.id.friends_recyclerview));
        aboutRecyclerView();
    }

    private void aboutRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);

        adapter  = new FoundFriendRecyclerAdapter(getContext());
        recyclerview.setAdapter(adapter);
    }


    @Subscribe
    public void onEventMainThread(FoundFriend data){
        adapter.setDataSource(data.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
