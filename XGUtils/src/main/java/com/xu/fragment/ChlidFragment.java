package com.xu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;
import com.xu.fragment.basefragment.XuBaseFragment;
import com.xu.framework.R;

/**
 * @author 296389471@qq.com
 * @discription 子fragment
 * @created 2015/4/26 18:04
 */
public class ChlidFragment extends XuBaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chlidfragment, null);
        ViewUtils.inject(this, view);
        return view;
    }
}
