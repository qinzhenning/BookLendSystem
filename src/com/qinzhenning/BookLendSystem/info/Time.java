package com.qinzhenning.BookLendSystem.info;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Time implements Serializable{

	//��ȡ��ǰʱ��
	public static Date getnowTimeDate(){
		Date now = new Date();
		return now;
	}
	
	//��ʱ��ת��Ϊyyyy-mm--nn���ַ�������
	public static String getTimeString(Date date){
		DateFormat df = DateFormat.getDateInstance();
		String str = df.format(date);
		return str;
	}
	
	//�޸ľ�ʱ��
	public void setTime(Date olddate,int year,int month,int date){
		olddate.setDate(date);
		olddate.setMonth(month);
		olddate.setYear(year);
	}
	
	//��Ϊ����Ŀǰʱ��
	public static Date setTime(int year,int month,int date){
		Date time = new Date(year,month,date);
		return time;
	}
	
	//�Ƚ�ʱ���Ⱥ�
	public static boolean before(Date date1,Date date2){
		return (date1.before(date2));
	}
}
