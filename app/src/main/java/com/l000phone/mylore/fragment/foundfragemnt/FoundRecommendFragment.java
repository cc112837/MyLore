package com.l000phone.mylore.fragment.foundfragemnt;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.l000phone.mylore.BookDetailActivity;
import com.l000phone.mylore.FoundGallery;
import com.l000phone.mylore.R;
import com.l000phone.mylore.adapter.FoundPullToAdapter;
import com.l000phone.mylore.adapter.FoundSelectGridViewAdapter;
import com.l000phone.mylore.adapter.FoundSelectGussGirdViewAdapter;
import com.l000phone.mylore.entitys.FoundSelect;
import com.l000phone.mylore.entitys.FoundSelectGood;
import com.l000phone.mylore.myinterface.FoundCommon;
import com.l000phone.mylore.utils.PicUtil;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.l000phone.mylore.xutil.MyHttpUtil;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.Random;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundRecommendFragment extends Fragment {


    private GridView select_gridview;
    private FoundSelect.DataEntity dataEntities;
    private FoundSelectGridViewAdapter adapter_select;
    private FoundSelect.DataEntity.SectionsEntity dataSource_select;
    private Random random;
    private PullToRefreshListView pullto;
    private LinearLayout select_author;
    private FoundSelect.DataEntity.SectionsEntity dataSource_author;
    private BitmapUtils bitmapUtils;
    private GridView select_guss_gridview;
    private FoundSelectGussGirdViewAdapter adapter_guess;
    private int rand;
    private FoundSelect.DataEntity.SectionsEntity dataSource_good;
    private FoundPullToAdapter adapter_pullto;
    private  int currentPage;
    private LinearLayout view_meiri;
    private LinearLayout view_luanfanshu;
    private FoundSelect.DataEntity.SectionsEntity dataSource_self;

    public FoundRecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.found_select_headview, container, false);
        View view = inflater.inflate(R.layout.fragment_found_recommend, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        random = new Random();
        rand = random.nextInt(1000);
        MyHttpUtil.getData(FoundCommon.Url_Found + "recommend?&rand=" + rand, 0, new FoundSelect(this.getClass().getName()), null, getContext(), "found_recommend");

        pullto = ((PullToRefreshListView) view.findViewById(R.id.found_recommend_pulltorefreshlistview));

        //添加头视图
        ListView listView = pullto.getRefreshableView();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.found_select_headview, null);
        listView.addHeaderView(inflate);
        aboutHeadView(inflate);

        aboutPullto();
        EventBus.getDefault().register(this);
        bitmapUtils = new BitmapUtils(getContext());


    }

    //pulltorefreshlistview  的操作;
    private void aboutPullto() {
        pullto.setMode(PullToRefreshBase.Mode.BOTH);
        adapter_pullto = new FoundPullToAdapter(getContext());
        pullto.setAdapter(adapter_pullto);

        pullto.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新
                rand = random.nextInt(1000);
                MyHttpUtil.getData(FoundCommon.Url_Found + "recommend?&rand=" + rand, 0, new FoundSelect(this.getClass().getName()), null, getContext(), "found_recommend");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载
                currentPage++;
                MyHttpUtil.getData(FoundCommon.Url_Found_LoadMore + dataSource_good.getId() + "?&book=&page=" + currentPage + "&rand=" + rand + "&size=20", 0, new FoundSelectGood(this.getClass().getName()), null, getContext(), null);
            }
        });

    }

    //关于 headview的操作;
    private void aboutHeadView(View inflate) {
        select_gridview = ((GridView) inflate.findViewById(R.id.found_recommend_select_gridview));
        aboutSelectGridView();

        select_author = ((LinearLayout) inflate.findViewById(R.id.found_author_llcontainer));

        select_guss_gridview = ((GridView) inflate.findViewById(R.id.found_recommend_guess_gridview));
        aboutGuessGridView();

        view_luanfanshu = ((LinearLayout) inflate.findViewById(R.id.found_recommend_luanfanshu));
        //点击事件;
        view_luanfanshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FoundGallery.class);
                startActivity(intent);
                Toast.makeText(getContext(),dataSource_self.getData().getSections().get(0).getId()+"",Toast.LENGTH_SHORT).show();
            }
        });
        view_meiri = ((LinearLayout) inflate.findViewById(R.id.found_recommend_meiri));
        //点击事件;
        view_meiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),dataSource_self.getData().getSections().get(1).getId()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aboutGuessGridView() {
        adapter_guess = new FoundSelectGussGirdViewAdapter(getContext());
        select_guss_gridview.setAdapter(adapter_guess);
        select_guss_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aboutAuthor() {
        dataSource_author = dataEntities.getSections().get(2);
        for(int i =0 ;i <dataSource_author.getNum();i++){
            LogUtils.log("guess","执行了------"+i);
            View view_author_item = LayoutInflater.from(getContext()).inflate(R.layout.found_recommend_author_item, null);
            TextView author_name = ((TextView) view_author_item.findViewById(R.id.anthor_name));
            TextView author_desc = ((TextView) view_author_item.findViewById(R.id.author_desc));
            ImageView author_img = ((ImageView) view_author_item.findViewById(R.id.author_img));

            //设置点击事件:
            final int finalI = i;
            view_author_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), dataSource_author.getData().getAuthors().get(finalI).getId()+"", Toast.LENGTH_SHORT).show();
                }
            });

            author_name.setText(dataSource_author.getData().getAuthors().get(i).getName());
            author_desc.setText(dataSource_author.getData().getAuthors().get(i).getDesc());
            bitmapUtils.display(author_img, dataSource_author.getData().getAuthors().get(i).getImg(), new BitmapLoadCallBack<ImageView>() {
                @Override
                public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                   //设置图片为圆形图
                    Bitmap bmp = PicUtil.getRoundedCornerBitmap(bitmap,2);
                    container.setImageBitmap(bmp);
                }

                @Override
                public void onLoadFailed(ImageView container, String uri, Drawable drawable) {

                }
            });
            select_author.addView(view_author_item);
        }

    }

    private void aboutSelectGridView() {
        adapter_select = new FoundSelectGridViewAdapter(getContext());
        select_gridview.setAdapter(adapter_select);
        select_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), BookDetailActivity.class);
                intent.putExtra("uid",dataSource_select.getData().getBooks().get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onEventMainThread(FoundSelect data) {
        LogUtils.log("rand","====="+rand);
        pullto.onRefreshComplete();
        dataEntities = data.getData();
        dataSource_select = dataEntities.getSections().get(0);
        adapter_select.setData(dataSource_select);
        adapter_select.notifyDataSetChanged();

        dataSource_self = dataEntities.getSections().get(1);


        aboutAuthor();

        adapter_guess.setDataSource(dataEntities.getSections().get(3).getData().getTags());
        adapter_guess.notifyDataSetChanged();

        dataSource_good = dataEntities.getSections().get(4);
        adapter_pullto.setDataSource(dataSource_good.getData().getBooks());
        adapter_pullto.notifyDataSetChanged();
    }

    @Subscribe
    public void onEventMainThread(FoundSelectGood data){
        adapter_pullto.addDataToDataSource(data.getData());
        adapter_pullto.notifyDataSetChanged();
        pullto.onRefreshComplete();
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
