package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.ChanelHot;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class HotChaAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<ChanelHot.DataEntity> hotchanlist;

    public HotChaAdapter(Context context, List<ChanelHot.DataEntity> chanlist) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.hotchanlist = chanlist;
    }

    @Override
    public int getCount() {
        if (hotchanlist != null) {
            return hotchanlist.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return hotchanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        final ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            view = inflater.inflate(R.layout.channel_hot_item, null);
            vh.tv_hotchannelid= ((TextView) view.findViewById(R.id.tv_hotchannelid));
            view.setTag(vh);
        } else {
            view = convertView;
            vh = (ViewHolder) view.getTag();
        }
        BitmapUtils bitmapUtils=new BitmapUtils(context);
        bitmapUtils.display(vh.tv_hotchannelid,hotchanlist.get(position).getImg().getUrl());
        vh.tv_hotchannelid.setText(hotchanlist.get(position).getTitle());
        return  view;
    }


    private final class ViewHolder {
        private TextView tv_hotchannelid;
    }
}
