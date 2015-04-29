package com.xu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	// 获取当年开始时间
	public static String getFirstDay() {
		SimpleDateFormat start = new SimpleDateFormat("yyyy-01-01");
		Date startDate = new Date(System.currentTimeMillis());
		String str = start.format(startDate).toString();
		return str;
	}
	
	// 获取距离当前时间间隔为2年的时间
	public static String getLast2Years(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(d); 
		calendar.add(Calendar.YEAR,-2); 
		calendar.add(Calendar.MONTH, 0); 
		String afterDate = dateFormat.format(calendar.getTime()); 
		return afterDate;
	}

	// 获取当前准确时间
	public static String getCurrentDate() {
		SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = new Date(System.currentTimeMillis());
		String en = end.format(endDate).toString();
		return en;
	}

	// 获取当前时间
	public static String getDate(String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date date = new Date(System.currentTimeMillis());
		String dateStr = sdf.format(date).toString();
		return dateStr;
	}

	// 获取格式化时间
	public static String getDate(String datString, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date date = new Date(datString);
		return sdf.format(date).toString();
	}
	
	// 根据毫秒数格式化时间
	public static String getDateByMillisecond(long millisecond ,String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date date = new Date(millisecond);
		return sdf.format(date).toString();
	}
}
