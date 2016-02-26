package com.l000phone.mylore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.MyApp;
import com.l000phone.mylore.R;
import com.l000phone.mylore.base.MyBaseAdapter;
import com.l000phone.mylore.entitys.BookSelect;
import com.l000phone.mylore.myinterface.OnContantsButtonLisenter;
import com.l000phone.mylore.utils.TimeUtil;
import com.l000phone.mylore.volley.MyImageListener;

import java.util.List;

/**
 *书摘适配器
 */
public class BookAdapter extends MyBaseAdapter {

    private List<BookSelect.DataEntity> list;
    private Context context;
    private OnContantsButtonLisenter itemButton;
    public BookAdapter(List list,Context context,
                       OnContantsButtonLisenter itemButton) {
        super(list);
        this.list=list;
        this.context=context;
        this.itemButton=itemButton;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.select_item, null);
            viewholder.userphoto = ((ImageView) convertView.findViewById(R.id.select_userphoto));
            viewholder.talk = ((ImageView) convertView.findViewById(R.id.select_talk));
            viewholder.photo = ((ImageView) convertView.findViewById(R.id.select_photo));
            viewholder.username = ((TextView) convertView.findViewById(R.id.select_username));
            viewholder.sorce = ((TextView) convertView.findViewById(R.id.select_sorce));
            viewholder.time = ((TextView) convertView.findViewById(R.id.select_time));
            viewholder.title = ((TextView) convertView.findViewById(R.id.select_title));
            viewholder.nums = ((TextView) convertView.findViewById(R.id.select_nums));
            viewholder.zannums = ((TextView) convertView.findViewById(R.id.select_zannums));
            viewholder.contant2 = ((TextView) convertView.findViewById(R.id.select_contant2));
            viewholder.zan = ((CheckBox) convertView.findViewById(R.id.select_zan));
            //添加标记
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        viewholder.title.setText(list.get(position).getTitle());
        viewholder.username.setText(list.get(position).getUser().getName());
        viewholder.sorce.setText(list.get(position).getChannelName());
        viewholder.userphoto.setImageBitmap(null);
        viewholder.userphoto.setTag(list.get(position).getUser().getIcon() + 1);
        MyApp.getImageLoader().get(list.get(position).getUser().getIcon(), new MyImageListener(viewholder.userphoto,
                R.mipmap.ic_launcher));
        viewholder.zannums.setText(list.get(position).getPraise() + "");
        viewholder.nums.setText(list.get(position).getCmt() + "");
        String time = TimeUtil.getTime(list.get(position).getCt());
        viewholder.time.setText(time);

        String desc = list.get(position).getDesc();
        if (desc.contains("。")) {
            viewholder.contant2.setText(desc.substring(0, desc.indexOf("。")) + "...");
        }else
        {
            viewholder.contant2.setText(desc);
        }
        viewholder.photo.setImageBitmap(null);
        viewholder.photo.setTag(list.get(position).getThumbnail().getUrl());
        MyApp.getImageLoader().get(list.get(position).getThumbnail().getUrl(),
                new MyImageListener(viewholder.photo, R.mipmap.ic_launcher));

        /*********创建一个监听器,实现ListView内部控件监听************/
        class ContactsLisenter implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                if (itemButton != null) {
                    BookAdapter.this.itemButton.OnFriendsButtonClick(v, position);
                }
            }
        }
        //绑定监听器
        if (itemButton != null) {
            ContactsLisenter liseter = new ContactsLisenter();
            viewholder.talk.setOnClickListener(liseter);
            viewholder.nums.setOnClickListener(liseter);
        }

        return convertView;
    }

    final static class ViewHolder {
        ImageView userphoto;
        ImageView talk;
        ImageView photo;
        TextView username;
        TextView sorce;
        TextView time;
        TextView title;
        TextView contant2;
        TextView nums;
        TextView zannums;
        CheckBox zan;
    }
}
