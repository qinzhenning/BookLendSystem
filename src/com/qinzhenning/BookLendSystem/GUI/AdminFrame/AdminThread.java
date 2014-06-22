package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.net.MalformedURLException;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;

/**
 * ����Ա���� ���߳�.
 */
public class AdminThread  extends Thread{
	private Administrator admin;
	
	/**
	 * ���췽��-�������Ա����
	 */
	public AdminThread(Administrator admin){
		this.admin = admin;
	}
	
	/**
	 * �߳�����
	 */
	public void run() {
		
			new AdminFrame(admin);
		
	}

}
