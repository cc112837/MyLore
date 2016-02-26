package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundLuanFanShuTitle;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21.
 */
public class LuanFanShuListAdapter extends BaseAdapter {

    private Context context;
    private List<FoundLuanFanShuTitle> dataSource;
    private BitmapUtils bitmapUtils;

    public LuanFanShuListAdapter(Context context) {
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }


    public void setDataSource(List<FoundLuanFanShuTitle> dataSource) {
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
            v = LayoutInflater.from(context).inflate(R.layout.luanfanshu_list_item, null);
            vh = new ViewHolder();
            vh.list_item_img = ((ImageView) v.findViewById(R.id.list_item_img));
            vh.list_item_tag = ((TextView) v.findViewById(R.id.list_item_tag));
            vh.list_item_text = ((TextView) v.findViewById(R.id.list_item_text));
            v.setTag(vh);
        } else {
            v = convertView;
            vh = (ViewHolder) v.getTag();
        }
        vh.list_item_tag.setText(dataSource.get(position).getLabel());
        bitmapUtils.display(vh.list_item_img, dataSource.get(position).getImg());
        if(position != 0){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < dataSource.get(position).getClassifications().size(); i++) {
                sb.append(dataSource.get(position).getClassifications().get(i).getLabel() +"、");
            }
            vh.list_item_text.setText(sb.toString());
        }
        return v;
    }

    private class ViewHolder {
        private ImageView list_item_img;
        private TextView list_item_tag;
        private TextView list_item_text;
    }
}
