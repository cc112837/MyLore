package com.l000phone.mylore.fragment.hotfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.activity.MipcaActivityCapture;
import com.l000phone.mylore.activity.SildeActivity;
import com.l000phone.mylore.adapter.HotAdapter;
import com.l000phone.mylore.base.BaseFragment;
import com.l000phone.mylore.fragment.hotfragment.digest.DigestFragment;
import com.l000phone.mylore.fragment.hotfragment.select.SelectFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *精选界面
 */
public class HotFragment extends BaseFragment implements View.OnClickListener {

    private final static int SCANNIN_GREQUEST_CODE = 1;
    private ImageView qr;
    private ImageView search;
    private Button choice;
    private Button digest;
    private ViewPager viewPager;
    private List<Fragment> fragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_hot, container, false);
        //初始化界面控件
        initView(ret);
        return ret;
    }

    private void initView(View ret) {
        qr = ((ImageView) ret.findViewById(R.id.hot_qr));
        search = ((ImageView) ret.findViewById(R.id.hot_search));
        choice = ((Button) ret.findViewById(R.id.hot_choice));
        digest = ((Button) ret.findViewById(R.id.hot_digest));
        viewPager = ((ViewPager) ret.findViewById(R.id.hot_viewpager));
        choice.setOnClickListener(this);
        digest.setOnClickListener(this);
        qr.setOnClickListener(this);
        search.setOnClickListener(this);
        /*给Viewpager添加数据*/
        addViewpager();

    }

    private void addViewpager() {
        fragments = new ArrayList<>();
        SelectFragment selectFragment = new SelectFragment();
        fragments.add(selectFragment);
        DigestFragment digestFragment = new DigestFragment();
        fragments.add(digestFragment);
        HotAdapter adapter = new HotAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        /*添加监听器*/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    buttonSet(choice, digest);
                } else {
                    buttonSet(digest, choice);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.hot_choice:
                buttonSet(choice, digest);
                viewPager.setCurrentItem(0);
                break;

            case R.id.hot_digest:
                buttonSet(digest,choice);
                viewPager.setCurrentItem(1);
                break;

            case R.id.hot_search:
                Intent intent = new Intent(activity, SildeActivity.class);
                intent.putExtra("Tag", 1);
                startActivity(intent);
                activity.overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                break;

            case R.id.hot_qr:
                Intent intent1 = new Intent();
                intent1.setClass(activity, MipcaActivityCapture.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent1, SCANNIN_GREQUEST_CODE);
                break;
        }
    }
    /*按钮的设置*/
    private void buttonSet(Button b1,Button b2 )
    {
        b1.setBackgroundResource(R.drawable.shape_self_true);
        b1.setTextColor(getResources().getColor(R.color.white));
        b2.setBackgroundResource(R.drawable.shape_self_false);
        b2.setTextColor(getResources().getColor(R.color.black));
    }
}
