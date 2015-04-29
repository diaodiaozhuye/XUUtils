package com.xu.interfaces;

import com.xu.fragment.basefragment.XuBaseFragment;

/**
 * @author 296389471@qq.com
 * @discription 用户操作fragment所用的回调
 * @created 2015/4/26 21:10
 */
public interface BackHandledInterface {
    /**
     * 显示回调
     * @param selectedFragment
     */
    public void setSelectedFragment(XuBaseFragment selectedFragment);

    /**
     * 销毁回调
    * @param destroyFragment
    */
    public void destroyFragment(XuBaseFragment destroyFragment);
}
