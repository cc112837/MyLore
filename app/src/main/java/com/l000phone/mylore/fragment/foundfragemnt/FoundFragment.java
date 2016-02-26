package com.l000phone.mylore.fragment.foundfragemnt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.l000phone.mylore.R;
import com.l000phone.mylore.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundFragment extends Fragment {


    private RadioGroup found_radiogroup;
    private ImageView jump2Search;

    public FoundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_found_fragemnt, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        jump2Search = ((ImageView) view.findViewById(R.id.jump2Search));
        abnoutJump();
        found_radiogroup = ((RadioGroup) view.findViewById(R.id.found_radiogroup));
        initFragment();
        found_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getFragmentManager();
                Fragment fragment = null;
                switch (checkedId) {
                    case R.id.found_radiobutton_1:
                        fragment = new FoundRecommendFragment();
                        break;
                    case R.id.found_radiobutton_2:
                        fragment = new FoundRankFragment();
                        break;
                    case R.id.found_radiobutton_3:
                        fragment = new FoundFriendsFragment();
                        break;
                }
                manager.beginTransaction().replace(R.id.found_ll_container, fragment).commit();

            }
        });

    }

    private void abnoutJump() {
        jump2Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }



    private void initFragment() {
        FoundRecommendFragment foundRecommendFragment = new FoundRecommendFragment();
        getFragmentManager().beginTransaction().replace(R.id.found_ll_container,foundRecommendFragment).commit();
    }
}
