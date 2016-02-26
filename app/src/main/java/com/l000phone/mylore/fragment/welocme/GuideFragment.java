package com.l000phone.mylore.fragment.welocme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.l000phone.mylore.R;
import com.l000phone.mylore.activity.welcome.LoginActivity;

import java.util.LinkedList;

/**
 * 欢迎界面的图片替换Fragment
 */
public class GuideFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.fragment_guide, container, false);

        //初始化界面
        initView(ret);
        return ret;
    }

    private void initView(View ret) {
        //获得界面的控件
        ImageView viewById = (ImageView) ret.findViewById(R.id.iv_picture);
        TextView tv_enter = (TextView) ret.findViewById(R.id.tv_enter);
        //获得传过来的值
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        //准备数据源
        LinkedList<Integer> pictures = new LinkedList<>();
        pictures.add(R.mipmap.p1);
        pictures.add(R.mipmap.p2);
        pictures.add(R.mipmap.p3);
        pictures.add(R.mipmap.p4);

        switch (id) {
            case 0:

            case 1:

            case 2:
                viewById.setImageResource(pictures.get(id));
                break;

            case 3:
                viewById.setImageResource(pictures.get(id));
                tv_enter.setVisibility(View.VISIBLE);
                //给textView添加监听器
                tv_enter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getActivity(), LoginActivity.class);

                        startActivity(intent);

                        //清除当前界面
                        getActivity().finish();
                    }
                });

                break;
        }


    }
}
