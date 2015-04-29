package com.xu.utils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.xu.interfaces.HttpInterface;
import com.xu.utils.Constant.Constant;


import java.io.File;

/**
 * @author 296389471@qq.com
 * @discription 统一调用http请求 该类只管请求http
 * @created 2015/4/22 21:26
 */
public class UsHttpUtils {

    private static HttpInterface ob;   //回调的类

    /**
     *
     * @param data 请求数据
     * @param name 如果在一个页面有多个http请求 标识是那个请求
     * @param object 回调的类
     */
    public static void Post(String data, final String name,Object object){
        //实例化回调的类
        ob=(HttpInterface)object;

        RequestParams params = new RequestParams();
        params.addBodyParameter("data", new File(data));
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.POST,
                Constant.URL,
                params,
                new RequestCallBack<String>() {

                    @Override
                    public void onStart() {
                        DebugLog.i("开始请求接口成功");
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        if (isUploading) {
                            DebugLog.d("upload: " + current + "/" + total);
                        } else {
                            DebugLog.d("reply: " + current + "/" + total);
                        }
                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        DebugLog.i("请求接口成功");
                        ob.onSuccess(responseInfo.toString(),name);
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        DebugLog.e(error.getExceptionCode() + ":" + msg);
                        ob.onFailure(name);
                    }
                });
    }
}
