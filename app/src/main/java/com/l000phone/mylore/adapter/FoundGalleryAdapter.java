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
import com.l000phone.mylore.entitys.FoundLuanFanShu;
import com.l000phone.mylore.utils.PicUtil;
import com.l000phone.mylore.utils.ScreenL;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadCallBack;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;

import java.util.List;

/**
 * Created by Administrator on 2015/11/20.
 */
public class FoundGalleryAdapter extends RecyclerView.Adapter<FoundGalleryAdapter.MyViewHolder> {
    private Context context;
    private List<FoundLuanFanShu> dataSource;
    private BitmapUtils bitmapUtils ;

    public FoundGalleryAdapter(Context context) {
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }

    public void setDataSource(List<FoundLuanFanShu> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.found_gallery_item, null);
        MyViewHolder myViewHolder =new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.gallery_item_bookname.setText(dataSource.get(position).getName());
        holder.gallety_item_author.setText(dataSource.get(position).getAuthor());
        holder.gallery_item_star.setText(dataSource.get(position).getRating()+"");
        final int screenWidth = ScreenL.getScreenWidth(context);
        final int screenHeight = ScreenL.getScreenHeight(context);
        bitmapUtils.display(holder.gallery_item_img, dataSource.get(position).getImg(), new BitmapLoadCallBack<ImageView>() {
            @Override
            public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {

                Bitmap bm = PicUtil.zoomBitmap(bitmap, screenWidth,screenHeight);
                container.setImageBitmap(bm);
            }

            @Override
            public void onLoadFailed(ImageView container, String uri, Drawable drawable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (dataSource != null) {
            return dataSource.size();
        }
        return ret;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView gallery_item_img;
        private TextView gallery_item_bookname;
        private TextView gallety_item_author;
        private TextView gallery_item_star;
        private TextView gallety_item_tag;


        public MyViewHolder(View itemView) {
            super(itemView);
            gallery_item_bookname = ((TextView) itemView.findViewById(R.id.gallery_item_bookname));
            gallety_item_author = ((TextView) itemView.findViewById(R.id.gallety_item_author));
            gallery_item_star = ((TextView) itemView.findViewById(R.id.gallery_item_star));
            gallety_item_tag = ((TextView) itemView.findViewById(R.id.gallety_item_tag));
            gallery_item_img = ((ImageView) itemView.findViewById(R.id.gallery_item_img));
        }
    }
}
