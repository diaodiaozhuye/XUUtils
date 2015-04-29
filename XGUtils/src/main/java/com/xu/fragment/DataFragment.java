package com.xu.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.xu.fragment.basefragment.XuBaseFragment;
import com.xu.framework.R;


/**
 * @author 296389471@qq.com
 * @discription 数据更新fragment
 * @created 2015/4/26 17:10
 */
public class DataFragment extends XuBaseFragment {

    private String str;

    @ViewInject(R.id.date_pbLoading)
    ProgressBar progressBar;
    @ViewInject(R.id.textview)
    TextView textview;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            onfinsh();
        }
    };

    @OnClick(R.id.fragment2)
    void Onbtn(Button bt) {
        FragmentTwo fragmentTwo = new FragmentTwo();
        replaceFragment(R.id.content_frame, fragmentTwo, true, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date, null);
        ViewUtils.inject(this, view);
        init();
        return view;
    }

    private void init() {
        //连接上子fragment
        ChlidFragment chlidFragment = new ChlidFragment();
        replaceFragmentNoanima(R.id.childfragment, chlidFragment, false, null);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendMessage(new Message());
            }
        }).start();
    }

    private void onfinsh() {
        progressBar.setVisibility(View.GONE);
        textview.setText("数据已经更新");
    }
}
