package com.xu;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.xu.utils.DebugLog;

/**
 * @author 296389471@qq.com
 * @discription 自定义Application 多用于全局获取 context
 * @created 2015/4/22 16:40
 */
public class App extends Application{

    private static Context mcontext;    //全局context

    public void onCreate() {
        super.onCreate();
        DebugLog.i("获取应用Context");
        mcontext = this;
    }
    public static Context getAppContext() {
        return mcontext;
    }

    public static Resources getAppResources() {
        return getAppResources();
    }
}
