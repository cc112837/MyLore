package com.l000phone.mylore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.l000phone.mylore.adapter.ChannelDetailAdapter;
import com.l000phone.mylore.entitys.ChannelDetail;
import com.l000phone.mylore.entitys.ChannelDetailHead;
import com.l000phone.mylore.myinterface.BooKDeInter;
import com.l000phone.mylore.myinterface.MyRecyItemClickListener;
import com.l000phone.mylore.utils.PicUtil;
import com.l000phone.mylore.utils.ScreenL;
import com.l000phone.mylore.xutil.HttpUtil;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class ChannelDetailActivity extends AppCompatActivity {
    private RecyclerView rv_channeldetailid;
    private TextView tv_head_lookid;
    private TextView tv_head_comid;
    private RadioButton rb_chanattentionid;
    private TextView tv_chadetailid;
    private ImageView iv_headback;
    private TextView tv_chanthemeid;
    private LinearLayout ll_channeltotalid;
    private List<ChannelDetail.DataEntity> dataList;
    private SwipeRefreshLayout srl_flushid;
    private boolean isLoadingMore;
    private boolean isrefreshing;
    private LinearLayoutManager linearLayoutManager;
    private ChannelDetailAdapter channelDetailAdapter;
    private int lastVisibleItem;
    private String uid;
    private int pager = 1;
    private boolean canRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_channel_detail);
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        HttpUtil.getData(BooKDeInter.channeldetailuri + uid + "/detail ", 0, new ChannelDetailHead(this.getClass().getName()), null);
        HttpUtil.getData(BooKDeInter.channeldetailuri + uid + BooKDeInter.channeladddetailuri, 0, new ChannelDetail(this.getClass().getName()), null);
        init();
    }

    /**
     * 界面初始化
     */

    private void init() {
        srl_flushid = (SwipeRefreshLayout) findViewById(R.id.srl_flushid);
        srl_flushid.setColorSchemeResources(R.color.colorAccent, R.color.black, R.color.colorPrimaryDark);
        srl_flushid.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        srl_flushid.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            }
        });

        ll_channeltotalid = (LinearLayout) findViewById(R.id.ll_channeltotalid);
        iv_headback = (ImageView) findViewById(R.id.iv_headback);
        tv_chadetailid = ((TextView) findViewById(R.id.tv_chadetailid));
        rv_channeldetailid = ((RecyclerView) findViewById(R.id.rv_channeldetailid));
        ImageView iv_chan_backid = (ImageView) findViewById(R.id.iv_chan_backid);
        iv_chan_backid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RecyclerViewHeader headchandet = RecyclerViewHeader.fromXml(getApplicationContext(), R.layout.head_channel_detail);
        tv_head_lookid = ((TextView) headchandet.findViewById(R.id.tv_head_lookid));
        tv_head_comid = ((TextView) headchandet.findViewById(R.id.tv_head_comid));
        rb_chanattentionid = (RadioButton) headchandet.findViewById(R.id.rb_chanattentionid);
        tv_chanthemeid = (TextView) headchandet.findViewById(R.id.tv_chanthemeid);
        linearLayoutManager = new LinearLayoutManager(this);
        rv_channeldetailid.setLayoutManager(linearLayoutManager);
        headchandet.attachTo(rv_channeldetailid);
        channelDetailAdapter = new ChannelDetailAdapter(dataList, this);
        rv_channeldetailid.setAdapter(channelDetailAdapter);
        rv_channeldetailid.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == channelDetailAdapter.getItemCount()) {
                    srl_flushid.setRefreshing(true);
                    pager++;
                    HttpUtil.getData(BooKDeInter.channeldetailuri + uid + "/card/list?&page=" + pager + "&size=20", 0, new ChannelDetail(this.getClass().getName()), null);
                }
                if(newState == RecyclerView.SCROLL_STATE_IDLE && canRefresh){
                    srl_flushid.setRefreshing(true);
                    HttpUtil.getData(BooKDeInter.channeldetailuri + uid + BooKDeInter.channeladddetailuri, 0, new ChannelDetail(this.getClass().getName()), null);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                View topview = linearLayoutManager.findViewByPosition(1);
                if(topview!= null && topview.getTop() >= 180){
                    canRefresh = true;
                }
                if(topview!= null && topview.getTop() < 180){
                    canRefresh = false;
                }
            }
        });
        rv_channeldetailid.setHasFixedSize(true);
        rv_channeldetailid.setItemAnimator(new DefaultItemAnimator());
        channelDetailAdapter.setOnItemClickListener(new MyRecyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                //// TODO: 2015/11/20
                Toast.makeText(getApplicationContext(), "点击了" + postion + "位置", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Subscribe
    public void onEventMainThread(ChannelDetail channelDetail) {
        dataList = channelDetail.getData();
        srl_flushid.setRefreshing(false);
        if (pager > 1) {
            channelDetailAdapter.addDetaillist(dataList);
        } else {
            channelDetailAdapter.setDetaillist(dataList);
        }
        channelDetailAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onEventMainThread(ChannelDetailHead channelDetailHead) {
        ChannelDetailHead.DataEntity data = channelDetailHead.getData();
        tv_head_lookid.setText(data.getPv() + "");
        tv_head_comid.setText(data.getCard() + "");
        tv_chadetailid.setText(data.getTitle());
        tv_chanthemeid.setText(data.getDesc());
        BitmapUtils bitmapUtils = new BitmapUtils(this);
        bitmapUtils.display(iv_headback, data.getImg().getUrl(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                int w = ScreenL.getScreenWidth(getApplicationContext());
                int h = ScreenL.Dp2Px(getApplicationContext(), 200);
                Bitmap bm = PicUtil.zoomBitmap(bitmap, w, h);
                container.setImageBitmap(bm);
            }

            @Override
            public void onLoadFailed(ImageView container, String uri, Drawable drawable) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
