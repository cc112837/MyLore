package com.l000phone.mylore.fragment;

/**
 * Created by Administrator on 2015/10/19 20:47.
 * fengkunlu@163.com
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 用于帮助跳转携带一些信息
 */
public class ChangeFragmentHelper {

    //目标跳转Fragment
    private Fragment setFragment;

    //是否清空回退栈
    private boolean isClearStackBack;

    //是否加入到回退栈
    private String targetFragmentTag;

    //给目标Fragment传递Bundle值
    private Bundle bundle;

    /**
     * setter and getter
     */
    public Fragment setFragment() {
        return setFragment;
    }
    public void setFragment(Fragment setFragment) {
        this.setFragment = setFragment;
    }

    public boolean isClearStackBack() {
        return isClearStackBack;
    }

    public void setIsClearStackBack(boolean isClearStackBack) {
        this.isClearStackBack = isClearStackBack;
    }

    public String getTargetFragmentTag() {
        return targetFragmentTag;
    }

    public void setTargetFragmentTag(String targetFragmentTag) {
        this.targetFragmentTag = targetFragmentTag;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
