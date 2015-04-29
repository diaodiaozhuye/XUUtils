package com.xu.utils;

/**
 * @author 296389471@qq.com
 * @discription 一些杂类的方法写在这个类,但请做好注释
 * 如果功能方法大于3个请封装成一个类
 * @created 2015/4/22 22:27
 */
public class Other {

   //例如 密码
    /**
     *  如果pwd的长度小于len这不符合
     * @param pwd 密码字符串
     * @param len 规定长度
     * @return
     */
    public static boolean ispwdlength(String pwd,int len){
        if(pwd.length()<len)return false;
        return true;
    }
}
