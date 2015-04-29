package com.xu.fragment.basefragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.xu.framework.R;
import com.xu.interfaces.BackHandledInterface;
import com.xu.utils.DebugLog;


/**
 * @author 296389471@qq.com
 * @discription 用户自定义fragment并实现一些fragment相关方法，凡是fragment全部继承改类
 * @created 2015/4/13 12:43
 */
public class XuBaseFragment extends Fragment {

    //回调页面接口
    private BackHandledInterface mBackHandledInterface;

    //生命周期
    @Override

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBackHandledInterface=(BackHandledInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBackHandledInterface.setSelectedFragment(this);
    }

    @Override
    public void onResume() {
        DebugLog.d("当先显示在用户面前的fragment:" + this.getClass().getName());
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBackHandledInterface.destroyFragment(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //切换方法集成

    /**
     * replace 替换 Fragment 默认动画右进左出
     *
     * @param viewId   latout id
     * @param fragment XuBaseFragment
     * @param Name     加入退回栈事务标识 addToBackStatck(Name)
     * @param flag     事务是否加入退回站
     */
    public void replaceFragment(int viewId, XuBaseFragment fragment, Boolean flag, String Name) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.in_right_left,
                R.anim.out_right_left, R.anim.in_left_right,
                R.anim.out_left_right);
        fragmentTransaction.replace(viewId, fragment);
        if (flag) fragmentTransaction.addToBackStack(Name);
        fragmentTransaction.commit();
    }

    /**
     * replace 替换 Fragment 用户自定动画
     *
     * @param viewId   latout id
     * @param fragment XuBaseFragment
     * @param Name     加入退回栈事务标识 addToBackStatck(Name)
     * @param enter
     * @param exit
     * @param popEnter
     * @param popExit
     * @param flag     事务是否加入退回站
     */
    public void replaceFragment(int viewId, XuBaseFragment fragment, int enter, int exit, int popEnter, int popExit, Boolean flag, String Name) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(enter,
                exit, popEnter,
                popExit);
        fragmentTransaction.replace(viewId, fragment);
        if (flag) fragmentTransaction.addToBackStack(Name);
        fragmentTransaction.commit();
    }

    /**
     * replace 替换 Fragment 无动画
     *
     * @param viewId
     * @param fragment
     * @param Name
     * @param flag     事务是否加入退回栈
     */
    public void replaceFragmentNoanima(int viewId, XuBaseFragment fragment, Boolean flag, String Name) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(viewId, fragment);
        if (flag) fragmentTransaction.addToBackStack(Name);
        fragmentTransaction.commit();
    }

    /**
     * add
     *
     * @param viewId
     * @param fragment
     * @param flag     事务是否加入退回栈
     */
    public void addFragment(int viewId, XuBaseFragment fragment, Boolean flag) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(viewId, fragment);
        if (flag) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * pop当前最上层fragment
     */
    public void popBackStackFragment() {
        getFragmentManager().popBackStack();
    }

    /**
     * pop返回到指定的fragment 前面的fragmeng会清空
     *
     * @param name 如果为null 则会清除所有fragment
     */
    public void popBackStackFragment(String name) {
        getFragmentManager().popBackStack(name, 0);
    }


    /**
     * 如果键盘存在隐藏键盘
     *
     * @param view //键盘当前页面view
     */
    public void KeyWorod(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}
