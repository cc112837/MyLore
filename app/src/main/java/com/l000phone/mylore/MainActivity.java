package com.l000phone.mylore;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.l000phone.mylore.fragment.channelfragment.ChannelFragment;
import com.l000phone.mylore.fragment.foundfragemnt.FoundFragment;
import com.l000phone.mylore.fragment.hotfragment.HotFragment;
import com.l000phone.mylore.fragment.myfragemnt.MyFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radiogroup;
    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    private void initWidget() {

        radiogroup = ((RadioGroup) findViewById(R.id.radiogroup));

        iniitFragment();

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                Fragment fragment = null;
                switch (checkedId) {
                    case R.id.radio_activity:
                        fragment = new HotFragment();
                        break;
                    case R.id.radio_travelbook:
                        fragment = new FoundFragment();
                        break;
                    case R.id.radio_route:
                        fragment = new ChannelFragment();
                        break;
                    case R.id.radio_my:
                        fragment = new MyFragment();
                        break;
                }
                manager.beginTransaction().replace(R.id.ll_container, fragment).commit();
            }
        });
    }

    private void iniitFragment() {
        HotFragment hotFragment = new HotFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.ll_container,hotFragment).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&& event.getAction() == KeyEvent.ACTION_DOWN  ){
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void exit() {
        if(!isExit){
            isExit = true;
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
            handler.sendEmptyMessageDelayed(0,2000);
        }else{
            finish();
            System.exit(0);
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    isExit = false;
                    break;
            }
        }
    };

}
