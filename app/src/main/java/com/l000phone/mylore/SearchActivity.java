package com.l000phone.mylore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.l000phone.mylore.fragment.SearchEmptyFragemnt;
import com.l000phone.mylore.fragment.SearchSearchFragemnt;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SearchActivity extends SwipeBackActivity {
//<item name="android:windowBackground">@android:color/transparent</item>

    private SearchView search_searchview;
    private TextView search_text;
    private ImageView search_goback;
    private String currentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        initWidget();
    }

    private void initWidget() {
        MyListener listener = new MyListener();
        search_goback = ((ImageView) findViewById(R.id.search_goback));
        search_goback.setOnClickListener(listener);
        search_text = ((TextView) findViewById(R.id.search_text));
        search_text.setOnClickListener(listener);
        search_searchview = ((SearchView) findViewById(R.id.search_searchview));
        replace(new SearchEmptyFragemnt(),null);
        aboutSearchVeiw();
    }

    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.search_text:
                    Bundle bundle = new Bundle();
                    bundle.putString("name", currentName);
                    replace(new SearchSearchFragemnt(), bundle);
                    break;
                case R.id.search_goback:
                    finish();
                    break;
            }
        }
    }
    public void setQuery(String str){
        search_searchview.setQuery(str,false);
    }
    private void aboutSearchVeiw() {
        search_searchview.setFocusable(false);
        search_searchview.clearFocus();
        search_searchview.onActionViewExpanded();
        search_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Bundle bundle = new Bundle();
                bundle.putString("name", query);
                replace(new SearchSearchFragemnt(),bundle);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                currentName = newText;
                if ("".equals(currentName)) {
                   replace(new SearchEmptyFragemnt(),null);
                }
                return false;
            }
        });
    }
    public  void replace(Fragment fragment,Bundle bundle){
        FragmentManager manager = getSupportFragmentManager();
        if(bundle != null){
            fragment.setArguments(bundle);
        }
        manager.beginTransaction().replace(R.id.search_llcontainer,fragment).commit();
    }
}
