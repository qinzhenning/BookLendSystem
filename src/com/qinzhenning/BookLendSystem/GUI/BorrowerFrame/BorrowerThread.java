/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import javax.swing.JOptionPane;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;

/**
 * @author qinzhenning
 * ʱ�䣺2012-6-28����3:50:55
 * �ļ���BorrowerThread.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * ��  ��BorrowerThread
 */
/**
 * ������ ���� ���߳�
 */
public class BorrowerThread extends Thread{
	private Borrower borrower;
	
	/**
	  * ���췽��-���� �����˶���
	  */
	public BorrowerThread(Borrower borrower){
		this.borrower = borrower;
	}
	
	/**
	  * �߳�����
	  */
	public void run(){
		try{
			new BorrowerFrame(borrower);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "������Ŷ����");
		}
	}
}
