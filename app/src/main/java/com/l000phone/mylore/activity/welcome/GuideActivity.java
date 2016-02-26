package com.l000phone.mylore.activity.welcome;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;

import com.l000phone.mylore.R;
import com.l000phone.mylore.adapter.GuideAdapter;
import com.l000phone.mylore.fragment.welocme.GuideFragment;
import com.l000phone.mylore.utils.packageUtil;

import java.util.LinkedList;

/**
 * 欢迎界面
 */
public class GuideActivity extends FragmentActivity {

    private ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        //获得参数偏好设置里的版本号
        SharedPreferences version = getSharedPreferences("version", MODE_PRIVATE);

        //获得参数偏好设置编辑
        SharedPreferences.Editor edit = version.edit();

        //获得版本号
        String pageVerson = packageUtil.getPageVerson(this);
        //把获得版本号写入设置里
        edit.putString("version", pageVerson);
        //提交
        edit.commit();

        //初始化界面控件
        initView();
    }

    private void initView() {
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        //获得单选按钮
        final RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        //默认第一个被选中
        radiogroup.check(R.id.radione);
        //把按钮设置为无效
        radiogroup.setClickable(false);

        //存放Fragment的集合
        LinkedList<Fragment> fragments = new LinkedList<>();
        //构建Fragment添加到集合中
        for (int i = 0; i < 4; i++) {
            GuideFragment guideFragment = new GuideFragment();
            //把值传过去
            Bundle bundle = new Bundle();
            bundle.putInt("id", i);
            guideFragment.setArguments(bundle);
            //把Fragment添加到集合中
            fragments.add(guideFragment);
        }
        //构建适配器
        GuideAdapter adapter = new GuideAdapter(getSupportFragmentManager(), fragments);
        //绑定适配器
        viewpager.setAdapter(adapter);

        //给ViewPager设置监听器
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当滑动时,给RadioButoon设值
            @Override
            public void onPageSelected(int position) {
                int checkedId = R.id.radione;
                switch (position) {
                    case 0:
                        checkedId= R.id.radione;
                        break;
                    case 1:
                        checkedId= R.id.raditwo;
                        break;
                    case 2:
                        checkedId= R.id.radithree;
                        break;
                    case 3:
                        checkedId= R.id.radifour;
                        break;
                }
                radiogroup.check(checkedId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
