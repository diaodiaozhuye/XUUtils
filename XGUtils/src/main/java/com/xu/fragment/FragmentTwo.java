package com.xu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xu.fragment.basefragment.XuBaseFragment;
import com.xu.framework.R;

/**
 * @author 296389471@qq.com
 * @discription ${在此输入一句话描述此文件的作用}
 * @created 2015/4/26 20:25
 */
public class FragmentTwo extends XuBaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,null);
        return view;
    }
}
