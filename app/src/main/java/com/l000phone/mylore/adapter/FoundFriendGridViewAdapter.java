package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundFriend;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/19.
 */
public class FoundFriendGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<FoundFriend.DataEntity.CardsEntity> dataSource;
    private BitmapUtils bitmapUtils;

    public FoundFriendGridViewAdapter(Context context) {
        this.context = context;
    }

    public void setDataSource(List<FoundFriend.DataEntity.CardsEntity> dataSource,int position,GridView gridView) {
        if(position == (int)gridView.getTag()){
            this.dataSource = dataSource;
            this.bitmapUtils = new BitmapUtils(context);
            notifyDataSetChanged();
        }
    }

    public void clear(){
        if(dataSource != null){

            dataSource.clear();
        }
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (dataSource != null) {
            return  dataSource.size();
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
            v = LayoutInflater.from(context).inflate(R.layout.found_friend_gridview_item,null);
            vh =  new ViewHolder();
            vh.friend_item_title = ((TextView) v.findViewById(R.id.friend_item_title));
            vh.friends_item_img = ((ImageView) v.findViewById(R.id.friends_item_img));
            v.setTag(vh);
        }else{
            v = convertView;
            vh = (ViewHolder) v.getTag();
        }
        vh.friends_item_img.setImageBitmap(null);
        vh.friend_item_title.setText(dataSource.get(position).getTitle());
        bitmapUtils.display(vh.friends_item_img,dataSource.get(position).getImg());
        return v;
    }
    private class ViewHolder{
        private ImageView friends_item_img;
        private TextView friend_item_title;
    }
}
