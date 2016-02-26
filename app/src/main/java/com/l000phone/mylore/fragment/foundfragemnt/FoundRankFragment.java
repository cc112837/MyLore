package com.l000phone.mylore.fragment.foundfragemnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundRank;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.l000phone.mylore.xutil.MyHttpUtil;
import com.lidroid.xutils.BitmapUtils;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundRankFragment extends Fragment {


    private LinearLayout rank_net;
    private LinearLayout rank_publish;
    private FoundRank.DataEntity.SectionsEntity dataSource_net;
    private FoundRank.DataEntity.SectionsEntity dataSource_publish;

    public FoundRankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_found_rank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        EventBus.getDefault().register(this);
        MyHttpUtil.getData(FoundCommon.Url_Found_Rank, 0, new FoundRank(this.getClass().getName()), null, getContext(), "found_rank");
        rank_net = ((LinearLayout) view.findViewById(R.id.rank_netrank_llcontainer));
        rank_publish = ((LinearLayout) view.findViewById(R.id.rank_publishrank_llcontainer));

    }

    @Subscribe
    public void onEventMainThread(FoundRank data) {
        dataSource_net = data.getData().getSections().get(0);
        LogUtils.log("返回数据", "net ==" + dataSource_net);
        aboutRanks(dataSource_net, rank_net);
        dataSource_publish = data.getData().getSections().get(1);
        LogUtils.log("返回数据", "publish==" + dataSource_publish.getData().getRanks());
        aboutRanks(dataSource_publish, rank_publish);
    }

    private void aboutRanks(final FoundRank.DataEntity.SectionsEntity dataSource, LinearLayout llcontainer) {
        BitmapUtils bitmapUtils = new BitmapUtils(getContext());
        for (int i = 0; i < dataSource.getData().getRanks().size(); i++) {
            LogUtils.log("guess", "执行了------" + i);
            View view_author_item = LayoutInflater.from(getContext()).inflate(R.layout.found_recommend_author_item, null);
            TextView author_name = ((TextView) view_author_item.findViewById(R.id.anthor_name));
            TextView author_desc = ((TextView) view_author_item.findViewById(R.id.author_desc));
            ImageView author_img = ((ImageView) view_author_item.findViewById(R.id.author_img));

            //设置点击事件;
            final int finalI = i;
            view_author_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "" + dataSource.getData().getRanks().get(finalI).getId(), Toast.LENGTH_SHORT).show();
                }
            });

            author_name.setText(dataSource.getData().getRanks().get(i).getName());
            author_desc.setText(dataSource.getData().getRanks().get(i).getDesc());
            bitmapUtils.display(author_img, dataSource.getData().getRanks().get(i).getImg());
            llcontainer.addView(view_author_item);
        }

    }
}
