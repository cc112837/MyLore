package com.l000phone.mylore.fragment.myfragemnt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.l000phone.mylore.BookDetailActivity;
import com.l000phone.mylore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener {


    private ImageView iv_my_settingid;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_my_fragemnt, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        ImageView  iv_my_settingid = ((ImageView) inflate.findViewById(R.id.iv_my_settingid));//设置
        ImageView iv_my_headid = (ImageView) inflate.findViewById(R.id.iv_my_headid);//头像
        RadioButton rb_my_autoid = (RadioButton) inflate.findViewById(R.id.rb_my_autoid);//动态
        RadioButton rb_my_friendid = (RadioButton) inflate.findViewById(R.id.rb_my_friendid);//朋友
        RadioButton rb_my_megid = (RadioButton) inflate.findViewById(R.id.rb_my_megid);//消息.
        LinearLayout ll_my_channalid = (LinearLayout) inflate.findViewById(R.id.ll_my_channalid);//我的频道
        LinearLayout ll_my_shelfid = (LinearLayout) inflate.findViewById(R.id.ll_my_shelfid);//我的书架
        LinearLayout ll_my_collectid = (LinearLayout) inflate.findViewById(R.id.ll_my_collectid);//我的收藏
        LinearLayout ll_my_cardid = (LinearLayout) inflate.findViewById(R.id.ll_my_cardid);//我的帖子
        LinearLayout ll_my_factoryid = (LinearLayout) inflate.findViewById(R.id.ll_my_factoryid);//奶酪工坊
        iv_my_settingid.setOnClickListener(this);
        iv_my_headid.setOnClickListener(this);
        rb_my_autoid.setOnClickListener(this);
        rb_my_friendid.setOnClickListener(this);
        rb_my_megid.setOnClickListener(this);
        ll_my_channalid.setOnClickListener(this);
        ll_my_shelfid.setOnClickListener(this);
        ll_my_collectid.setOnClickListener(this);
        ll_my_cardid.setOnClickListener(this);
        ll_my_factoryid.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.iv_my_settingid:
             Toast.makeText(getContext(),"你点击了设置",Toast.LENGTH_LONG).show();
             Intent intent= new Intent(getContext(),BookDetailActivity.class);
             startActivity(intent);
             break;
         case R.id.iv_my_headid:
             Toast.makeText(getContext(),"你点击了头像",Toast.LENGTH_LONG).show();
             break;
         case R.id.rb_my_autoid:
             Toast.makeText(getContext(),"你点击了动态",Toast.LENGTH_LONG).show();
             break;
         case R.id.rb_my_friendid:
             Toast.makeText(getContext(),"你点击了朋友",Toast.LENGTH_LONG).show();
             break;
         case R.id.rb_my_megid:
             Toast.makeText(getContext(),"你点击了消息",Toast.LENGTH_LONG).show();
             break;
         case R.id.ll_my_channalid:
             Toast.makeText(getContext(),"你点击了我的频道",Toast.LENGTH_LONG).show();
             break;
         case R.id.ll_my_shelfid:
             Toast.makeText(getContext(),"你点击了我的书架",Toast.LENGTH_LONG).show();
             break;
         case R.id.ll_my_collectid:
             Toast.makeText(getContext(),"你点击了我的收藏",Toast.LENGTH_LONG).show();
             break;
         case R.id.ll_my_cardid:
             Toast.makeText(getContext(),"你点击了我的帖子",Toast.LENGTH_LONG).show();
             break;
         case R.id.ll_my_factoryid:
             Toast.makeText(getContext(),"你点击了奶酪工厂",Toast.LENGTH_LONG).show();
             break;

     }
    }
}
