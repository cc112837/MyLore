package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundSelectBook;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundPullToAdapter extends BaseAdapter {
    private Context context;
    private List<FoundSelectBook> dataSource;
    private final BitmapUtils bitmapUtils;

    public FoundPullToAdapter(Context context) {
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }

    public void setDataSource(List<FoundSelectBook> dataSource) {
        LogUtils.log("数据源===","----"+dataSource.size());
        this.dataSource = dataSource;
    }

    public void addDataToDataSource(List<FoundSelectBook> dataSource){
        this.dataSource.addAll(dataSource);
    }


    @Override
    public int getCount() {
        int ret = 0;
        if (dataSource != null) {
            return dataSource.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LogUtils.log("适配器","----------getView"+position);
        View v = null;
        ViewHolder vh = null;
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.found_recommend_book_item,null);
            vh = new ViewHolder();
            vh.good_item_author = ((TextView) v.findViewById(R.id.good_item_author));
            vh.good_item_bookname = ((TextView) v.findViewById(R.id.good_item_bookname));
            vh.good_item_recommend = ((TextView)v.findViewById(R.id.good_item_recommend));
            vh.good_item_bookimg = ((ImageView) v.findViewById(R.id.good_item_bookimg));

            v.setTag(vh);
        }else{
            v = convertView;
            vh = (ViewHolder) v.getTag();
        }


        vh.good_item_author.setText(dataSource.get(position).getAuthor());
        vh.good_item_recommend.setText(dataSource.get(position).getRecommend());
        vh.good_item_bookname.setText(dataSource.get(position).getName());
        bitmapUtils.display(vh.good_item_bookimg,dataSource.get(position).getImg());
        return v;
    }
    private class ViewHolder{
        private TextView good_item_recommend;
        private TextView good_item_author;
        private TextView good_item_bookname;
        private ImageView good_item_bookimg;
    }
}
