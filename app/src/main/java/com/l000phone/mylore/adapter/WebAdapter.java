package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.MyApp;
import com.l000phone.mylore.R;
import com.l000phone.mylore.base.MyBaseAdapter;
import com.l000phone.mylore.entitys.SelectComment;
import com.l000phone.mylore.myinterface.OnContantsButtonLisenter;
import com.l000phone.mylore.volley.MyImageListener;

import java.util.List;

/**
 * WebView的适配器
 */
public class WebAdapter extends MyBaseAdapter {
    private List<SelectComment.DataEntity> list;
    private Context context;
    private OnContantsButtonLisenter itemButton;

    public WebAdapter(List<SelectComment.DataEntity> list, Context context, OnContantsButtonLisenter itemButton) {
        super(list);
        this.list = list;
        this.context = context;
        this.itemButton = itemButton;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.web_fragment_item, null);
            viewholder.photo = ((ImageView) convertView.findViewById(R.id.web_photo));
            viewholder.photos = ((ImageView) convertView.findViewById(R.id.web_photos));
            viewholder.tob = ((ImageView) convertView.findViewById(R.id.web_tob));
            viewholder.name = ((TextView) convertView.findViewById(R.id.web_thername));
            viewholder.coatant = ((TextView) convertView.findViewById(R.id.web_othercontants));
            //添加标记
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.name.setText(list.get(position).getUser().getName());

        viewholder.coatant.setText(list.get(position).getDesc());
        viewholder.photos.setImageBitmap(null);
        viewholder.photos.setTag(list.get(position).getUser().getIcon() + 1);
        MyApp.getImageLoader().get(list.get(position).getUser().getIcon(),
                new MyImageListener(viewholder.photos, R.mipmap.ic_launcher));
        if (list.get(position).getThumbnail() != null) {
            viewholder.photo.setVisibility(View.VISIBLE);
            viewholder.photo.setImageBitmap(null);
            viewholder.photo.setTag(list.get(position).getThumbnail().getUrl());
            MyApp.getImageLoader().get(list.get(position).getThumbnail().getUrl(),
                    new MyImageListener(viewholder.photo, R.mipmap.ic_launcher));
        } else {
            viewholder.photo.setVisibility(View.GONE);
        }


        /*********创建一个监听器,实现ListView内部控件监听************/
        class ContactsLisenter implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                if (itemButton != null) {
                    WebAdapter.this.itemButton.OnFriendsButtonClick(v, position);
                }
            }
        }
        //绑定监听器
        if (itemButton != null) {
            ContactsLisenter liseter = new ContactsLisenter();
            viewholder.photo.setOnClickListener(liseter);
            viewholder.name.setOnClickListener(liseter);
            viewholder.tob.setOnClickListener(liseter);
        }


        return convertView;
    }

    final static class ViewHolder {
        ImageView tob;
        ImageView photos;
        ImageView photo;
        TextView name;
        TextView coatant;

    }
}
