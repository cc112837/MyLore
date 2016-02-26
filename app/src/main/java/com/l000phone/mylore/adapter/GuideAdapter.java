package com.l000phone.mylore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by Administrator on 2015/10/21.
 */
public class GuideAdapter extends FragmentPagerAdapter {

    //获得传过来的Fragment集合
    private LinkedList<Fragment> fragments;

    public GuideAdapter(FragmentManager fm, LinkedList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
