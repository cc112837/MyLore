package com.l000phone.mylore.fragment.foundfragemnt;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l000phone.mylore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthorDetailHotFragment extends Fragment {


    public AuthorDetailHotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_author_detail_hot, container, false);
    }


}
