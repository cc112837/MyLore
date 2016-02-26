package com.l000phone.mylore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.entitys.FoundFriend;
import com.lidroid.xutils.BitmapUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19.
 */
public class FoundFriendRecyclerAdapter extends RecyclerView.Adapter<FoundFriendRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<FoundFriend.DataEntity> dataSource;
    private BitmapUtils bitmapUtils;
//    private List<FoundFriend.DataEntity.CardsEntity> dataCard;


    public FoundFriendRecyclerAdapter(Context context) {
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
    }

    public void setDataSource(List<FoundFriend.DataEntity> dataSource) {
        this.dataSource = dataSource;
    }


    //创建 viewhoder, 返回值是我们自己的内部类MyViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.found_friend_item, null);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /////////////////////////////???????????????????????????????????????????
        ///////////////////////////???????????????????????????????????????????????
        ////////////////////////////????????????????????????????????????????????
        holder.setIsRecyclable(false);
        holder.user_signature.setText(dataSource.get(position).getUser().getSignature());
        holder.user_name.setText(dataSource.get(position).getUser().getName());
        bitmapUtils.display(holder.user_icon, dataSource.get(position).getUser().getIcon());
        for(int i = 0;i <dataSource.get(position).getCards().size();i++){
            holder.imageviews.get(i).setVisibility(View.VISIBLE);
            holder.textviews.get(i).setVisibility(View.VISIBLE);
            holder.textviews.get(i).setText(dataSource.get(position).getCards().get(i).getTitle());
            if(dataSource.get(position).getCards().get(i).getId() !=null){
                bitmapUtils.display(holder.imageviews.get(i),dataSource.get(position).getCards().get(i).getImg());
            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (dataSource != null) {
            return dataSource.size();
        }
        return ret;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView user_icon;
        private TextView user_name;
        private TextView user_signature;
        private ImageView card_img_1;
        private ImageView card_img_2;
        private ImageView card_img_3;
        private TextView card_title_1;
        private TextView card_title_2;
        private TextView card_title_3;
        private List<ImageView> imageviews = new LinkedList<>();
        private List<TextView> textviews = new LinkedList<>();

        public MyViewHolder(View itemView) {
            super(itemView);
            user_icon = ((ImageView) itemView.findViewById(R.id.user_icon));
            user_name = ((TextView) itemView.findViewById(R.id.user_name));
            user_signature = ((TextView) itemView.findViewById(R.id.user_signature));
            card_img_1 = ((ImageView) itemView.findViewById(R.id.card_img_1));
            card_img_2 = ((ImageView) itemView.findViewById(R.id.card_img_2));
            card_img_3 = ((ImageView) itemView.findViewById(R.id.card_img_3));
            Collections.addAll(imageviews,card_img_1,card_img_2,card_img_3);
            card_title_1 = ((TextView) itemView.findViewById(R.id.card_title_1));
            card_title_2 = ((TextView) itemView.findViewById(R.id.card_title_2));
            card_title_3 = ((TextView) itemView.findViewById(R.id.card_title_3));
            Collections.addAll(textviews,card_title_1,card_title_2,card_title_3);
        }
    }
}
