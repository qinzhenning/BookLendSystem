package com.qinzhenning.BookLendSystem.info;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Time implements Serializable{

	//获取当前时间
	public static Date getnowTimeDate(){
		Date now = new Date();
		return now;
	}
	
	//将时间转化为yyyy-mm--nn的字符串对象
	public static String getTimeString(Date date){
		DateFormat df = DateFormat.getDateInstance();
		String str = df.format(date);
		return str;
	}
	
	//修改旧时间
	public void setTime(Date olddate,int year,int month,int date){
		olddate.setDate(date);
		olddate.setMonth(month);
		olddate.setYear(year);
	}
	
	//人为设置目前时间
	public static Date setTime(int year,int month,int date){
		Date time = new Date(year,month,date);
		return time;
	}
	
	//比较时间先后
	public static boolean before(Date date1,Date date2){
		return (date1.before(date2));
	}
}
