package com.l000phone.mylore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.l000phone.mylore.adapter.FriendAdapter;
import com.l000phone.mylore.entitys.DetailBook;
import com.l000phone.mylore.xutil.HttpUtil;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_bookdetail_backid;
    private ImageView iv_bookdetail_shareid;
    private  ImageView iv_bookdetail_coverid;
    private TextView tv_bookdetail_nameid;
    private TextView tv_bookdetail_authorid;
    private TextView tv_bookdetail_gradeid;
    private TextView tv_bookdetail_xid;
    private RadioButton rb_bookdetail_wantid;
    private RadioButton rb_bookdetail_readid;
    private TextView tv_bookdetail_simpleid;
    private LinearLayout ll_bookdetail_commentid;
    private LinearLayout ll_bookdetail_longcomid;
    private LinearLayout ll_bookdetail_likeid;
    private Button btn_bookdetail_writeid;
    private Button btn_bookdetail_tryid;
    private Button btn_bookdetail_buyid;
    private RecyclerView rv_bookid;
    private FriendAdapter friendAdapter;
    private List<DetailBook.DataEntity.FriendsEntity> friends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        EventBus.getDefault().register(this);
        init();//界面初始化
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        HttpUtil.handData(uid, new DetailBook(this.getClass().getName()));
    }
    @Subscribe
    public void onEventMainThread(DetailBook detailBook){
        DetailBook.DataEntity data = detailBook.getData();
        friends = data.getFriends();
        friendAdapter.setFrilist(friends);
        friendAdapter.notifyDataSetChanged();
        tv_bookdetail_nameid.setText(data.getName());
        tv_bookdetail_authorid.setText( data.getAuthor());
        tv_bookdetail_simpleid.setText(data.getDesc());
        tv_bookdetail_gradeid.setText((int)data.getRating()+"");
        BitmapUtils bitmapUtils=new BitmapUtils(getApplicationContext());
        bitmapUtils.display(iv_bookdetail_coverid,data.getImg());
        tv_bookdetail_xid.setText(data.getPubDateStr()+"");
    }

    /**
     * 界面初始化
     */
    private void init() {
        rv_bookid=(RecyclerView) findViewById(R.id.rv_bookid);
        iv_bookdetail_backid= ((ImageView) findViewById(R.id.iv_bookdetail_backid));
        iv_bookdetail_shareid= ((ImageView) findViewById(R.id.iv_bookdetail_shareid));
        iv_bookdetail_coverid= ((ImageView) findViewById(R.id.iv_bookdetail_coverid));
        tv_bookdetail_nameid=(TextView) findViewById(R.id.tv_bookdetail_nameid);
        tv_bookdetail_authorid=(TextView) findViewById(R.id.tv_bookdetail_authorid);
        tv_bookdetail_gradeid=(TextView) findViewById(R.id.tv_bookdetail_gradeid);
        tv_bookdetail_xid=(TextView) findViewById(R.id.tv_bookdetail_xid);
        rb_bookdetail_wantid=(RadioButton) findViewById(R.id.rb_bookdetail_wantid);
        rb_bookdetail_readid=(RadioButton)findViewById(R.id.rb_bookdetail_readid);
        tv_bookdetail_simpleid=(TextView) findViewById(R.id.tv_bookdetail_simpleid);
        ll_bookdetail_commentid=(LinearLayout) findViewById(R.id.ll_bookdetail_commentid);
        ll_bookdetail_longcomid=(LinearLayout) findViewById(R.id.ll_bookdetail_longcomid);
        btn_bookdetail_writeid=(Button) findViewById(R.id.btn_bookdetail_writeid);
        btn_bookdetail_tryid=(Button) findViewById(R.id.btn_bookdetail_tryid);
        btn_bookdetail_buyid=(Button) findViewById(R.id.btn_bookdetail_buyid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_bookid.setLayoutManager(linearLayoutManager);
        friendAdapter = new FriendAdapter(getApplicationContext(), friends);
        rv_bookid.setAdapter(friendAdapter);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.iv_bookdetail_backid:
               BookDetailActivity.this.finish();
               break;
           case R.id.iv_bookdetail_shareid:
               break;
           case R.id.rb_bookdetail_wantid:
               rb_bookdetail_wantid.setButtonDrawable(R.mipmap.fgm_other_user_attentioned);
               break;
           case R.id.rb_bookdetail_readid:
               break;
           case R.id.btn_bookdetail_writeid:
               break;
           case R.id.btn_bookdetail_tryid:
               break;
           case R.id.btn_bookdetail_buyid:
               break;

       }

    }
}
