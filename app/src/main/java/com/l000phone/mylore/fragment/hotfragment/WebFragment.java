package com.l000phone.mylore.fragment.hotfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.l000phone.mylore.MyApp;
import com.l000phone.mylore.R;
import com.l000phone.mylore.activity.CommentActivity;
import com.l000phone.mylore.activity.PopUpWindowActivity;
import com.l000phone.mylore.activity.PopWindowActivity;
import com.l000phone.mylore.adapter.WebAdapter;
import com.l000phone.mylore.entitys.SelectComment;
import com.l000phone.mylore.entitys.WebString;
import com.l000phone.mylore.myinterface.OnContantsButtonLisenter;
import com.l000phone.mylore.volley.MyImageListener;
import com.l000phone.mylore.xutil.HttpUtil2;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * 点击条目后详情界面
 */
public class WebFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2<ListView>, OnContantsButtonLisenter, View.OnClickListener {

    private int page = 1;
    private SelectComment selectComment;
    private boolean isRefreshing;
    private ImageView back;
    private ImageView comment;
    private ImageView top;
    private TextView comments;
    private TextView gentie;
    private PullToRefreshListView listView;
    private StringBuilder contantUri;
    private StringBuilder webUri;
    private ListView refreshableView;
    private List<SelectComment.DataEntity> datas;
    private WebAdapter adapter;
    private ImageView photo;
    private TextView name;
    private Button guanzhu;
    private String name1;
    private String icon;
    private WebString webString;
    private WebView webView;
    private View inflate;
    private boolean hasLoding = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = inflater.inflate(R.layout.web_fragment, container, false);
        /*获得传过来的数据*/
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        name1 = bundle.getString("name");
        icon = bundle.getString("icon");
        webUri = new StringBuilder("http://api.zsreader.com/v2/pub/card/");
        webUri.append(id).append("/detail");
        contantUri = new StringBuilder("http://api.zsreader.com/v2/pub/card/");
        contantUri.append(id).append("/card/list?&sort=0&tp=0&size=20&page=");

        /*初始化界面*/
        initView(ret);
        /*注册*/
        EventBus.getDefault().register(this);
        selectComment = new SelectComment(this.getClass().getName());
        webString = new WebString(this.getClass().getName());

        HttpUtil2.getData(webUri.toString(), 0, webString, null);

        HttpUtil2.getData(contantUri.toString(), page, selectComment, null);

        return ret;
    }

    private void initView(View ret) {
        back = ((ImageView) ret.findViewById(R.id.web_back));
        top = ((ImageView) ret.findViewById(R.id.web_top));
        comment = ((ImageView) ret.findViewById(R.id.wen_comment));
        comments = (TextView) ret.findViewById(R.id.web_comments);
        gentie = ((TextView) ret.findViewById(R.id.web_gentie));
        listView = ((PullToRefreshListView) ret.findViewById(R.id.web_listview));
        listView.setMode(PullToRefreshBase.Mode.BOTH);//设置刷新方式

        gentie.setOnClickListener(this);
        back.setOnClickListener(this);
        comment.setOnClickListener(this);
        top.setOnClickListener(this);
        comments.setOnClickListener(this);
        /*给ListView添加头部*/
        addHeadToListView();
    }

    @Subscribe
    public void onMainThread(Object data) {
        if (data != null) {
            if (data instanceof SelectComment) {
                SelectComment datas = (SelectComment) data;
                if (datas.getData() != null || hasLoding) {
                     /*给ListView绑定数据*/
                    addDataToListView(datas);
                } else {
                    Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }

            } else if (data instanceof WebString) {
                WebString weString = (WebString) data;
                comments.setText(weString.getData().getCmt() + "");
                String html = weString.getData().getExtra().getHtml();
                addWebView(html);
            }
        }
    }

    /*给ListView添加头部*/
    private void addHeadToListView() {
        inflate = LayoutInflater.from(getActivity()).
                inflate(R.layout.web_item, null);
        photo = ((ImageView) inflate.findViewById(R.id.head_photo));
        name = ((TextView) inflate.findViewById(R.id.head_name));
        guanzhu = (Button) inflate.findViewById(R.id.head_guanzhu);

        photo.setImageBitmap(null);
        photo.setTag(icon + 1);
        MyApp.getImageLoader().get(icon, new MyImageListener(photo,
                R.mipmap.ic_launcher));

        name.setText(name1);
        photo.setOnClickListener(this);
        guanzhu.setOnClickListener(this);

        webView = (WebView) inflate.findViewById(R.id.webview);

    }
    /*给WebView添加数据*/
    private void addWebView(final String html) {

        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
                return true;
            }
        });
        refreshableView = listView.getRefreshableView();
        refreshableView.addHeaderView(inflate);
    }



    /*给ListView绑定数据*/
    private void addDataToListView(SelectComment data) {
        datas = data.getData();
        if (datas != null) {
            if (page == 1) {
                 /*构建适配器*/
                adapter = new WebAdapter(datas, getActivity(), this);
                //绑定适配器
                listView.setAdapter(adapter);
            } else {
                datas.addAll(data.getData());
                adapter.notifyDataSetChanged();
            }
        } else {
            Toast.makeText(getActivity(), "暂无更多数据>_<", Toast.LENGTH_SHORT).show();
        }
        isRefreshing = false;
         /*数据加载完后关闭加载*/
        listView.onRefreshComplete();
         /*给PullToRefreshListView添加监听器*/
        listView.setOnRefreshListener(this);
    }

    /*ListView中控件监听*/
    @Override
    public void OnFriendsButtonClick(View view, int posiation) {
        switch (view.getId()) {
            case R.id.web_tob:
                startActivity(new Intent(getActivity(), PopWindowActivity.class));
                break;
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        if (!isRefreshing) {
            page = 1;
            HttpUtil2.getData(contantUri.toString(), page, selectComment, null);
            isRefreshing = true;
        }
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        if (!isRefreshing) {
            page++;
            HttpUtil2.getData(contantUri.toString(), page, selectComment, null);
            isRefreshing = true;
            hasLoding = true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.web_back:
                getActivity().finish();
                break;
            case R.id.wen_comment:
                refreshableView.setSelection(2);
                break;
            case R.id.web_top:
                startActivity(new Intent(getActivity(), PopUpWindowActivity.class));
                break;
            case R.id.head_guanzhu:
                String s = guanzhu.getText().toString();
                if (s.equals("已关注")) {
                    guanzhu.setText("关注");
                } else {
                    guanzhu.setText("已关注");
                }
                break;
            case R.id.web_gentie:
                startActivity(new Intent(getActivity(),
                        CommentActivity.class));
                break;
        }
    }
}
