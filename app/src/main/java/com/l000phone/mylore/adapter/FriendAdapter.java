package com.l000phone.mylore.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.DetailBook;
import com.l000phone.mylore.utils.PicUtil;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by Administrator on 2015/11/20.
 */
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyFriViewHolder> {
    private Context context;
    private List<DetailBook.DataEntity.FriendsEntity> frilist;
    private LayoutInflater inflater;

    public void setFrilist(List<DetailBook.DataEntity.FriendsEntity> frilist) {
        this.frilist = frilist;
    }

    public FriendAdapter(Context context, List<DetailBook.DataEntity.FriendsEntity> frilist) {
        this.context = context;
        this.frilist = frilist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyFriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyFriViewHolder holder = new MyFriViewHolder(LayoutInflater.from(
                context).inflate(R.layout.list_friend_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyFriViewHolder holder, int position) {
        BitmapUtils bitmapUtils=new BitmapUtils(context);
        bitmapUtils.display(holder.iv_friendid, frilist.get(position).getIcon(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                Bitmap bm = PicUtil.getRoundedCornerBitmap(bitmap, 2);
                container.setImageBitmap(bm);
            }

            @Override
            public void onLoadFailed(ImageView container, String uri, Drawable drawable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if(frilist!=null)
        return frilist.size();
        return 0;
    }

    class MyFriViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_friendid;

        public MyFriViewHolder(View itemView) {
            super(itemView);
            iv_friendid= ((ImageView) itemView.findViewById(R.id.iv_friendid));
        }
    }
}


