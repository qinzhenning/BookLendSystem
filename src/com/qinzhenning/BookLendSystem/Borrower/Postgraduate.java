package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:42:34
 * �ļ���Postgraduate.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Borrower
 * ��  ��Postgraduate
 */
//�о���
public class Postgraduate extends Borrower implements Serializable{

	
	/**
	 * ���췽��-�����û��������롢���֡��Ա𡢱�š������ı���
	 */
	public Postgraduate(String username,String password,String name,String sex, String number){
		setUsername(username);
		setPassword(password);
		setBorrowerName(name);
		setSex(sex);
		setBorrowerNumber(number);
		maxBorrow = 10;
		maxReborrow = 1;
	}

	
}
