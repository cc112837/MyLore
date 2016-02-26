package com.l000phone.mylore.base;


import android.widget.BaseAdapter;

import java.util.List;

/**
 * BaseAdapter 公用的适配器
 */
public abstract class MyBaseAdapter extends BaseAdapter {
    private List list;

    public MyBaseAdapter(List list) {
        this.list = list;
    }


    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
