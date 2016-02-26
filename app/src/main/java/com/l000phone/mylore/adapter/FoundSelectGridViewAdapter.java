package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundSelect;
import com.l000phone.mylore.entitys.FoundSelectBook;
import com.l000phone.mylore.utils.logutils.LogUtils;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundSelectGridViewAdapter extends BaseAdapter {
    private Context context;
    private FoundSelect.DataEntity.SectionsEntity data;
    private List<FoundSelectBook> dataSource;
    private final BitmapUtils bitmapUtils;

    public FoundSelectGridViewAdapter(Context context) {
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }

    public void setData(FoundSelect.DataEntity.SectionsEntity data) {
        this.data = data;
        this.dataSource = data.getData().getBooks();
        LogUtils.log("数据源","数据源长度 ===="+dataSource.size());
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (dataSource != null) {
            return 6;
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
        LogUtils.log("适配器","-----getView");
        View v = null;
        ViewHolder vh = null;
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.found_recommend_select_item, null);
            vh = new ViewHolder();
            vh.select_item_author = ((TextView) v.findViewById(R.id.select_item_author));
            vh.select_item_bookname = ((TextView) v.findViewById(R.id.select_item_bookname));
            vh.select_item_bookimg = ((ImageView) v.findViewById(R.id.select_item_bookimg));
            v.setTag(vh);

        } else {
            v = convertView;
            vh = (ViewHolder) v.getTag();
        }

        vh.select_item_author.setText(dataSource.get(position).getAuthor());
        vh.select_item_bookname.setText(dataSource.get(position).getName());
        bitmapUtils.display(vh.select_item_bookimg,dataSource.get(position).getImg());

        return v;
    }

    private class ViewHolder {
        private ImageView select_item_bookimg;
        private TextView select_item_bookname;
        private TextView select_item_author;
    }
}
