package com.l000phone.mylore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.l000phone.mylore.R;


/**
 * 替换Fragment帮助类
 */
public class ChangeFragment {

    public static void changeFragment(ChangeFragmentHelper helper,FragmentManager manager) {

        //获取需要跳转的Fragment
        Fragment targetFragment = helper.setFragment();

        //获取是否清空回退栈
        boolean clearStackBack = helper.isClearStackBack();

        //获取是否加入回退栈
        String targetFragmentTag = helper.getTargetFragmentTag();

        //获取Bundle
        Bundle bundle = helper.getBundle();
        //是否给Fragment传值
        if (bundle != null) {
            targetFragment.setArguments(bundle);
        }

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        if (targetFragment != null) {
            fragmentTransaction.replace(R.id.ll_container,targetFragment);
        }

        //是否添加到回退栈
        if (targetFragmentTag != null) {
            fragmentTransaction.addToBackStack(targetFragmentTag);
        }

        //是否清空回退栈
        if(clearStackBack){
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        fragmentTransaction.commit();
    }

}
