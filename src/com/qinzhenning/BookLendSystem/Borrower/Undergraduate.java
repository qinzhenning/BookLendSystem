package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:42:52
 * �ļ���Undergraduate.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Borrower
 * ��  ��Undergraduate
 */
//������
public class Undergraduate extends Borrower implements Serializable{
	private int reborrowcount = 0;										//�������
	private Book borrowbook;											//�ѽ�ͼ��
	
	/**
	 * ���췽��-�����û��������롢���֡��Ա𡢱�š������ı���
	 */
	public Undergraduate(String username,String password,String name,String sex, String number ){
		setUsername(username);
		setPassword(password);
		setBorrowerName(name);
		setSex(sex);
		setBorrowerNumber(number);
		maxBorrow = 5;
		maxReborrow = 1;
	}
	

}
