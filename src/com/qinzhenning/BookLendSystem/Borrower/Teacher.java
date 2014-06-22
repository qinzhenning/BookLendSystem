package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
import com.qinzhenning.BookLendSystem.info.Time;
/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:42:41
 * �ļ���Teacher.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Borrower
 * ��  ��Teacher
 */

/**
 * ��ʦ
 */
public class Teacher extends Borrower implements Serializable{
	public ArrayList<Book> haveAskBook = new ArrayList();
	
	/**
	 * ���췽��-�����û��������롢���֡��Ա𡢱�š������ı���
	 */
	public Teacher(String username,String password,String name,String sex, String number ){
		setUsername(username);
		setPassword(password);
		setBorrowerName(name);
		setSex(sex);
		setBorrowerNumber(number);
		maxBorrow = 20;
		maxReborrow = 2;
	}
	
	//���ظ������ͼ�鷽��
	public  void borrowBook(Book borrowbook){
		Date nowdate = Time.getnowTimeDate();
		String nowstring = Time.getTimeString(nowdate);
		Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
	    String returnstring = Time.getTimeString(returndate);
	   
	    
		if(haveBorrowBook.size() > maxBorrow)
			JOptionPane.showMessageDialog(null,"�Ѵ������������޷����ģ�");
		else
		{
			
			if(borrowbook !=null)
			{
			
				if(borrowbook.getborrowTime() != null)
				{   
					askBook(borrowbook);
				}
				else
				{
				    haveBorrowBook.add(borrowbook);
				    borrowbook.setborrowTime(nowdate);
				    borrowbook.setshouldReturnTime(returndate);
				    borrowbook.setreaderNumber(borrowerNumber);
//				    JOptionPane.showMessageDialog(null,"���ĳɹ�"); 
				}
			}
		}
 }
	
	
	//����ͼ��-�����ع�
	public void askBook(Book book){
				if(BorrowerList.findBorrower(book.getreaderNumber()) instanceof Teacher)
					JOptionPane.showMessageDialog(null,"��ͼ��Ľ�����ҲΪ��ʦ������������");
				else{
					book.setisAsk(true, book.getshouldReturnTime());
					haveAskBook.add(book);
					JOptionPane.showMessageDialog(null,"��ͼ���ѱ����ģ�ϵͳ�Ѱ����Զ�����ͼ�飬��7����ע���鿴��Ϣ����");
				}
			}
		
	//�鿴��Ϣ
	public  String seeMessage_askBookCome(){
		String output = "�����ͼ��黹��Ϣ��";
		int j = 1;

			if(haveAskBook != null)
			{
			
				for(int i = 0; i < haveAskBook.size();i ++ )
				{
					if(haveAskBook.get(i).getshouldReturnTime() == null)
						output += "\n" + j + "���� ���Ϊ" + haveAskBook.get(i).getISBN() + "    ����Ϊ "
									+ haveAskBook.get(i).getbookName() + "�ѹ黹�����Խ����ˡ�";
					j++;
				}
			}
			return output;
		}
	}

	

	


