package com.xu.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.xu.fragment.DataFragment;
import com.xu.fragment.LoadingFragment;
import com.xu.fragment.basefragment.XuBaseFragment;

import com.xu.interfaces.BackHandledInterface;
import com.xu.utils.DebugLog;
import com.xu.framework.R;

public class MainActivity extends FragmentActivity implements BackHandledInterface{

    /**
     * 记录当前显示在用户的fragment
     */
    private static XuBaseFragment baseFragment;


    @OnClick(R.id.login)
    void onLogin(Button btn){
        DebugLog.i("点击了登录按钮");

        Bundle  bundle = new Bundle();
        bundle.putString("text","注册中...");
        LoadingFragment loadingFragment = LoadingFragment.newInstance(bundle);
        replaceFragmentNoanima(R.id.content_frame,loadingFragment,true,null);

    }

    @OnClick(R.id.qury)
    void onQury(Button btn){
        DataFragment dataFragment = new DataFragment();
        replaceFragment(R.id.content_frame,dataFragment,true,null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        DebugLog.v("测试");
    }

    @Override
    public void onBackPressed() {
        DebugLog.d("回退");
        super.onBackPressed();
    }

    /**
     * replace 替换 Fragment 默认动画右进左出
     * @param viewId latout id
     * @param fragment XuBaseFragment
     * @param Name 加入退回栈事务标识 addToBackStatck(Name)
     * @param flag  事务是否加入退回站
     */
    public void replaceFragment(int viewId, XuBaseFragment fragment ,Boolean flag,String Name) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.in_right_left,
                R.anim.out_right_left, R.anim.in_left_right,
                R.anim.out_left_right);
        fragmentTransaction.replace(viewId, fragment);
        if(flag)fragmentTransaction.addToBackStack(Name);
        fragmentTransaction.commit();
    }

    /**
     * replace 替换 Fragment 无动画
     * @param viewId
     * @param fragment
     * @param Name
     * @param flag  事务是否加入退回栈
     */
    public void replaceFragmentNoanima(int viewId, XuBaseFragment fragment ,Boolean flag,String Name){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(viewId, fragment);
        if(flag)fragmentTransaction.addToBackStack(Name);
        fragmentTransaction.commit();
    }



    //实现接口回调方法-------------------------------------------------------------

    @Override
    public void setSelectedFragment(XuBaseFragment selectedFragment) {
        this.baseFragment = selectedFragment;
    }

    @Override
    public void destroyFragment(XuBaseFragment destroyFragment) {
        this.baseFragment = null;
    }
}
