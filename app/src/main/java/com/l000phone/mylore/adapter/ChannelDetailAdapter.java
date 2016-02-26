package com.l000phone.mylore.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.ChannelDetail;
import com.l000phone.mylore.myinterface.MyRecyItemClickListener;
import com.l000phone.mylore.utils.PicUtil;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19.
 */
public class ChannelDetailAdapter extends RecyclerView.Adapter<ChannelDetailAdapter.MyViewHolder> {
    private List<ChannelDetail.DataEntity> detaillist;
    private MyRecyItemClickListener mlistener;
    private static final int TYPE_BIG = 0;//大图类型
    private static final int TYPE_SMALL = 1;//小图类型
    private Context context;
    private List<String> listzan = new ArrayList<>();
    private LayoutInflater inflater;

    public void setDetaillist(List<ChannelDetail.DataEntity> detaillist) {
        this.detaillist = detaillist;
    }
    public void addDetaillist(List<ChannelDetail.DataEntity> detailist) {
       detaillist.addAll(detailist);
    }
    public void clear() {
        detaillist.clear();
    }

    @Override
    public int getItemViewType(int position) {
        if (detaillist.get(position).getThumbnail() != null) {
            int i = detaillist.get(position).getThumbnail().getHeight() - detaillist.get(position).getThumbnail().getWidth();
            if (Math.abs(i) > 300) {
                return TYPE_SMALL;
            } else
                return TYPE_BIG;
        } else
            return TYPE_SMALL;
    }

    public void setOnItemClickListener(MyRecyItemClickListener listener) {
        this.mlistener = listener;
    }

    public ChannelDetailAdapter(List<ChannelDetail.DataEntity> detaillist, Context context) {
        this.detaillist = detaillist;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BIG) {
            View inflate = inflater.inflate(R.layout.list_channeldetail_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);
            return myViewHolder;
        } else if (viewType == TYPE_SMALL) {
            View inflate = inflater.inflate(R.layout.list_channeldetail_small_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);
            return myViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(holder.iv_chandeid, detaillist.get(position).getUser().getIcon(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                Bitmap bm = PicUtil.getRoundedCornerBitmap(bitmap, 2);
                container.setImageBitmap(bm);
            }

            @Override
            public void onLoadFailed(ImageView container, String uri, Drawable drawable) {

            }
        });

        holder.tv_chandetid.setText(detaillist.get(position).getUser().getName());
        long current = System.currentTimeMillis();
        long c = detaillist.get(position).getCt();
        long i = (current - c) / 1000;
        if ((i / 60) < 60) {
            long b = i / 60;
            holder.tv_chadettimeid.setText(b + "分钟前");
        } else if ((i / 60 / 60) < 24) {
            long b = i / 60 / 60;
            holder.tv_chadettimeid.setText(b + "小时前");
        } else {
            long b = i / 60 / 60 / 24;
            holder.tv_chadettimeid.setText(b + "天前");
        }
        if (detaillist.get(position).getThumbnail() != null) {
            bitmapUtils.display(holder.iv_chadecontenid, detaillist.get(position).getThumbnail().getUrl(), new BitmapLoadCallBack<ImageView>() {
                @Override
                public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
                    int w = container.getWidth();
                    int h = container.getHeight();
                    Bitmap bm = PicUtil.zoomBitmap(bitmap, w, h);
                    container.setImageBitmap(bm);
                }

                @Override
                public void onLoadFailed(ImageView container, String uri, Drawable drawable) {

                }
            });
        }
        holder.chandettitleid.setText(detaillist.get(position).getTitle() + "");
        holder.tv_chandetcontid.setText(detaillist.get(position).getDesc() + "");
        holder.tv_chanprasnumid.setText(detaillist.get(position).getPraise() + "");
        holder.tv_chancomnumid.setText(detaillist.get(position).getPv() + "");
        holder.cb_chanpraseid.setTag(R.id.cb_chanpraseid, position);
        holder.cb_chanpraseid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = (int) buttonView.getTag(R.id.cb_chanpraseid);
                if (isChecked) {
                    listzan.add(position + "");
                } else {
                    listzan.remove(position + "");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (detaillist != null)
            return detaillist.size();
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv_chandeid;
        private TextView tv_chandetid;
        private TextView tv_chadettimeid;
        private ImageView iv_chadecontenid;
        private TextView chandettitleid;
        private TextView tv_chandetcontid;//内容
        private CheckBox cb_chanpraseid;
        private TextView tv_chanprasnumid;
        private TextView tv_chancomnumid;

        public MyViewHolder(View itemView) {
            super(itemView);
            cb_chanpraseid = ((CheckBox) itemView.findViewById(R.id.cb_chanpraseid));
            iv_chandeid = (ImageView) itemView.findViewById(R.id.iv_chandeid);
            tv_chandetid = (TextView) itemView.findViewById(R.id.tv_chandetid);
            tv_chadettimeid = (TextView) itemView.findViewById(R.id.tv_chadettimeid);
            iv_chadecontenid = (ImageView) itemView.findViewById(R.id.iv_chadecontenid);
            chandettitleid = (TextView) itemView.findViewById(R.id.chandettitleid);
            tv_chandetcontid = (TextView) itemView.findViewById(R.id.tv_chandetcontid);
            tv_chanprasnumid = (TextView) itemView.findViewById(R.id.tv_chanprasnumid);
            tv_chancomnumid = (TextView) itemView.findViewById(R.id.tv_chancomnumid);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mlistener != null) {
                mlistener.onItemClick(v, getLayoutPosition());
            }
        }
    }
}
