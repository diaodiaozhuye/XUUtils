package com.xu.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author 296389471@qq.com
 * @discription IP工具类 可判断用户是否网络正常
 * @created 2015/4/22 22:13
 */
public class IPUtils {
    /**
     * 获取用户当前IP
     */
    private static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            DebugLog.e(ex.toString());
        }
        return null;
    }

    /**
     * 判断用户是否连接网络
     * 判断机制为如果获取到IP着网络正常如果IP为NULL则网络不通
     * @return
     */
    public Boolean OnNetwork(){
        if(getLocalIpAddress()!=null) return true;
        return false;
    }

    /**
     * 获取当前IP
     * @return
     */
    public String getIP(){
       return getLocalIpAddress();
    }

}
