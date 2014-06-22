package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午5:42:52
 * 文件：Undergraduate.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Borrower
 * 类  ：Undergraduate
 */
//本科生
public class Undergraduate extends Borrower implements Serializable{
	private int reborrowcount = 0;										//续借计数
	private Book borrowbook;											//已借图书
	
	/**
	 * 构造方法-设置用户名、密码、名字、性别、编号、最大借阅本书
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
