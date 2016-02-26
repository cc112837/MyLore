package com.l000phone.mylore.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.l000phone.mylore.R;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundSelectGussGirdViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> dataSource;
    private Random random;
    private int color;

    public FoundSelectGussGirdViewAdapter(Context context) {
        this.context = context;
    }

    public void setDataSource(List<String> dataSource) {
        this.dataSource = dataSource;
        random = new Random();
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
        convertView = LayoutInflater.from(context).inflate(R.layout.found_recommend_guess_item,null);
        TextView guess_item_tag = ((TextView) convertView.findViewById(R.id.guess_item_tag));
        color = Color.rgb(random.nextInt(256)+50, random.nextInt(256)+50, random.nextInt(256)+50);
        guess_item_tag.setBackgroundColor(color);
        guess_item_tag.setText(dataSource.get(position));
        return convertView;
    }

}
