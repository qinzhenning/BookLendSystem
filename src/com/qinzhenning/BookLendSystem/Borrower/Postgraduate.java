package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午5:42:34
 * 文件：Postgraduate.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Borrower
 * 类  ：Postgraduate
 */
//研究生
public class Postgraduate extends Borrower implements Serializable{

	
	/**
	 * 构造方法-设置用户名、密码、名字、性别、编号、最大借阅本书
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
