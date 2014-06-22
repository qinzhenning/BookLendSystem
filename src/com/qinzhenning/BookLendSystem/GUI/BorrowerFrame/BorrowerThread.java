/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import javax.swing.JOptionPane;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;

/**
 * @author qinzhenning
 * 时间：2012-6-28下午3:50:55
 * 文件：BorrowerThread.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * 类  ：BorrowerThread
 */
/**
 * 借阅人 界面 新线程
 */
public class BorrowerThread extends Thread{
	private Borrower borrower;
	
	/**
	  * 构造方法-传入 借阅人对象
	  */
	public BorrowerThread(Borrower borrower){
		this.borrower = borrower;
	}
	
	/**
	  * 线程内容
	  */
	public void run(){
		try{
			new BorrowerFrame(borrower);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "出错了哦～～");
		}
	}
}
