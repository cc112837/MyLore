package com.l000phone.mylore.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.l000phone.mylore.MainActivity;


/**
 * 集成共性的数据
 */
public abstract class BaseFragment extends Fragment {
    public  int page=1;
    public MainActivity activity;
    public boolean isRefreshing ;
    public Object obj;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.activity = ((MainActivity) activity);
    }

}
