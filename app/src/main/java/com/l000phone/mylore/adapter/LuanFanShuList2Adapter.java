package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.LuanFanShuClassifications;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21.
 */
public class LuanFanShuList2Adapter extends BaseAdapter{
    private Context context;
    private List<LuanFanShuClassifications> dataSource;

    public LuanFanShuList2Adapter(Context context) {
        this.context = context;
    }

    public void setDataSource(List<LuanFanShuClassifications> dataSource) {
        this.dataSource = dataSource;
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
        View v = null;
        ViewHolder vh = null;
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.luanfanshu_list_2_item,null);
            vh = new ViewHolder();
            vh.list_2_item_lable = ((TextView) v.findViewById(R.id.list_2_item_lable));
            v.setTag(vh);
        }else{
            v = convertView;
            vh = (ViewHolder) v.getTag();
        }
        vh.list_2_item_lable.setText(dataSource.get(position).getLabel() +"("+dataSource.get(position).getNums()+")");

        return v;
    }
    class ViewHolder{
        private TextView list_2_item_lable;
    }
}
