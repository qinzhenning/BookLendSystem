package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.net.MalformedURLException;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;

/**
 * 管理员界面 新线程.
 */
public class AdminThread  extends Thread{
	private Administrator admin;
	
	/**
	 * 构造方法-传入管理员对象
	 */
	public AdminThread(Administrator admin){
		this.admin = admin;
	}
	
	/**
	 * 线程内容
	 */
	public void run() {
		
			new AdminFrame(admin);
		
	}

}
