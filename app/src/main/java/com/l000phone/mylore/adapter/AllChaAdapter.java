package com.l000phone.mylore.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.ChannelAll;
import com.l000phone.mylore.myinterface.MyRecyItemClickListener;
import com.l000phone.mylore.utils.PicUtil;
import com.l000phone.mylore.utils.ScreenL;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class AllChaAdapter extends RecyclerView.Adapter<AllChaAdapter.MyViewHolder> {
    private Context context;
    private List<ChannelAll.DataEntity> alllist;
    private MyRecyItemClickListener listener;
    private int a;
    private int b;
    public void setOnItemClickListener(MyRecyItemClickListener listener){
        this.listener = listener;
    }
    public AllChaAdapter(Context context, List<ChannelAll.DataEntity> alllist) {
        this.context = context;
        this.alllist = alllist;
    }

    @Override
    public AllChaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.channel_all_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final AllChaAdapter.MyViewHolder holder, int position) {

        BitmapUtils bitmapUtils = new BitmapUtils(context);
        int screenWidth = ScreenL.getScreenWidth(context);
        final int h = ScreenL.Dp2Px(context, 180);
        int ww=ScreenL.Px2Dp(context,screenWidth)-20;
        final int w= ScreenL.Dp2Px(context, ww);
        bitmapUtils.display(holder.iv_allid, alllist.get(position).getImg().getUrl(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                    Bitmap bm = PicUtil.zoomBitmap(bitmap,w ,h);
                    holder.iv_allid.setImageBitmap(bm);
            }

            @Override
            public void onLoadFailed(ImageView container, String uri, Drawable drawable) {
            }
        });
        holder.tv_allchannelid.setText(alllist.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return alllist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView iv_allid;
        private TextView tv_allchannelid;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv_allid = ((ImageView) itemView.findViewById(R.id.iv_allid));
            itemView.setOnClickListener(this);
            tv_allchannelid = (TextView) itemView.findViewById(R.id.tv_allchannelid);
        }

        @Override
        public void onClick(View v) {
            if(listener != null){
                listener.onItemClick(v,getLayoutPosition());
            }
        }
    }
}
