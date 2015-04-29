package com.xu.interfaces;

/**
 * @author 296389471@qq.com
 * @discription 专门用于http实现接口回调
 * @created 2015/4/22 21:47
 */
public interface HttpInterface {

    /**
     * http请求成功的时候回调函数
     * @param date 返回数据
     * @param name 返回标识
     */
    void onSuccess(String date, String name);

    /**
     * http请求失败的时候回调的函数
     * @param name 返回数据
     */
    void onFailure(String name);
}
