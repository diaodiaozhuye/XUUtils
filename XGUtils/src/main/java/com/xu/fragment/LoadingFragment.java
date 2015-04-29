package com.xu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.xu.fragment.basefragment.XuBaseFragment;
import com.xu.framework.R;
import com.xu.utils.DebugLog;

/**
 * @author xuguang
 * @version 2015-1-16 下午1:29:09 加载页面
 */
public class LoadingFragment extends XuBaseFragment {
	@ViewInject(R.id.textViewMessage)
	TextView textView;

	public static LoadingFragment newInstance(Bundle bundle) {
		LoadingFragment fragment = new LoadingFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_loading, null);
        ViewUtils.inject(this, view);
        DebugLog.i(getArguments().getString("text"));
		textView.setText(getArguments().getString("text"));
		return view;
	}

}
