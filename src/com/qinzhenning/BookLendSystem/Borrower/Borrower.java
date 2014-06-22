package com.qinzhenning.BookLendSystem.Borrower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
import com.qinzhenning.BookLendSystem.info.Time;

/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:42:15
 * �ļ���Borrower.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Borrower
 * ��  ��Borrower
 */

/**
 * ������
 */
public  abstract class Borrower implements Serializable {

	  protected String 					username;											//�û���
	  protected String 					password;											//����
	  protected String					borrowername;										//����
	  protected String 					sex;													//�Ա�
	  protected String 					borrowerNumber;									//�����˱��			
	  protected int  		 		    	reborrowCount;										//�������
	   ArrayList<Book>					haveBorrowBook = new ArrayList<Book>();		  	//�ѽ�ͼ��
	   Library 							search;					
	  protected int 					maxBorrow ;  										//�����ı���
	  protected int 					maxReborrow ;										//����������	
		

	 //����ͼ�� - �ع�
	 public  void reBorrowBook(Book book){
				Date nowdate = Time.getnowTimeDate();
				String nowstring = Time.getTimeString(nowdate);
				Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
			    String returnstring = Time.getTimeString(returndate);
			    
			    
			    if(book.getReborrowTime() > 1)
			    		JOptionPane.showMessageDialog(null, "������������Ѿ��ﵽ������");
			    else if(book.getisAsk())
			    		JOptionPane.showMessageDialog(null, "�����ѱ���ʦ�������޷�����");
			    else if(judgeIsOverTime())
			    		JOptionPane.showMessageDialog(null, "�����г���δ����������޷�����");
			    else
			    {
			    		
			    		book.setborrowTime(nowdate);
			    		book.setshouldReturnTime(returndate);
			    		book.reborrowTime++;
			    		JOptionPane.showMessageDialog(null, "����ɹ���");
			    }				
		}
	 
	 
	 //�黹ͼ�� - �ع�
	 public  void returnBook(Book book){
		 if(book != null)
		 {			
					haveBorrowBook.remove(book);
					book.setborrowTime(null);
					book.setshouldReturnTime(null);
					book.setreaderNumber(null);
					book.setReborrowTime(0);
					JOptionPane.showMessageDialog(null, "�黹�ɹ���");
		 }	
			
	 }
	 
	 //�鿴ͼ�鵽����Ϣ
	 public  String seeMessage_BookToDate(){
			String output = "һ������ͼ����Ϣ��";
			
			if(judgeIsOverTime())
			{
				output += "\n" + "���г���ͼ��δ�黹��";
				int j = 1;
				for(int i = 0;i < haveBorrowBook.size(); i++)
				{
					int date1 = haveBorrowBook.get(i).getshouldReturnTime().getDate();
					int date2 = haveBorrowBook.get(i).getborrowTime().getDate();
					if((date1 - date2) <= 0)	
					{
						output += "\n" + j + "����  ���Ϊ" + haveBorrowBook.get(i).getISBN() + "  ����Ϊ  " 
					              + haveBorrowBook.get(i).getbookName() + " �ѳ����˹涨��ʱ��黹�����������黹 ";
						j++;
					}
				}
			}
			else{
				output += "\n�ޡ�\n";
					}
			output += "�����黹ͼ����Ϣ:";
			if(haveBorrowBook.size() != 0)
			{	
				int j = 1;
				for(int i = 0; i < haveBorrowBook.size();i ++)
				{	
					Date date1 = haveBorrowBook.get(i).getshouldReturnTime();
					Date date2 = haveBorrowBook.get(i).getborrowTime();
					
					if((date1.getDate() - date2.getDate()) <= 7 && (date1.getMonth() == date2.getMonth()) && (date1.getYear() == date2.getYear()) )	
						output +="\n" + j + ".���� ���Ϊ " + haveBorrowBook.get(i).getISBN() + "  ����Ϊ"
								+ haveBorrowBook.get(i).getbookName() + " ��Ҫ�� " + (date1.getDate() - date2.getDate()) + " ���ڹ黹��";
				}
			}
			else
			{
				output += "\n�ޡ�";
			}
			return output;
	 }

	 //�鿴����ͼ����Ϣ-�ǽ�ʦ
	 public String seeMessage_AskBook(){
		 String output = "������Ϣ��";
		 int j = 1;
		 for(int i = 0;i < haveBorrowBook.size(); i++)
			{
				if(haveBorrowBook.get(i).getisAsk())
				{
					output += "\n" + j + "����  ���Ϊ " + haveBorrowBook.get(i).getISBN() + "   ����Ϊ "
							   + haveBorrowBook.get(i).getbookName() + " ����ʦ����";
					j++;
				}
			}
		 return output;
			}
			
	 
	 //����ͼ�� - -�����ع� 
	 public  void borrowBook(Book borrowbook){
		 	Date nowdate = Time.getnowTimeDate();
			String nowstring = Time.getTimeString(nowdate);
			Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
		    String returnstring = Time.getTimeString(returndate);
		    
			if(haveBorrowBook.size() >= maxBorrow)
			{
				JOptionPane.showMessageDialog(null, "�Ѵ������������޷����ģ�");
				
			}
			else
			{
				if(borrowbook !=null)
				{
				if(borrowbook.getisSpecialBook()&& (this instanceof Undergraduate))
					JOptionPane.showMessageDialog(null,"��ͼ��Ϊ�䱾����������Ȩ����!");
				else
				{
					if(borrowbook.getborrowTime() != null)
					{   
						if(!(this instanceof Teacher))
							JOptionPane.showMessageDialog(null,"���鱻��գ��޷�����");
					}
					else
					{
					    haveBorrowBook.add(borrowbook);
					    borrowbook.setborrowTime(nowdate);
					    borrowbook.setshouldReturnTime(returndate);
					    borrowbook.setreaderNumber(borrowerNumber);
					    JOptionPane.showMessageDialog(null,"���ĳɹ�");
					    
					}
				}
			}
				
			}
	 }
	 
	 //�����ѽ�ͼ���б� - �ع�
	 public ArrayList<Book> getHBB(){
		 return haveBorrowBook;
	 }
	 
	 
	 //����ѽ�ͼ�����-�ع�
	 public void addHbb(Book book){
		 haveBorrowBook.add(book);
	 }
	
	 //�����ѽ�ͼ���б����
	 public void setHbb(ArrayList<Book> hbbList){
		 haveBorrowBook = hbbList;
	 }
	 
		 
	//�����Ƿ���ͼ�鳬��δ��-�ع�
	public boolean judgeIsOverTime(){
		boolean isOverTime = false;
		for(int i=0; i < haveBorrowBook.size();i++)
		{
		if(Time.before(haveBorrowBook.get(i).getshouldReturnTime(), new Date()))
			isOverTime = true;
		}
		
		return isOverTime;
	}
	
	//�����Ƿ��Ѵ������ı���-�ع�
	public boolean judgIsOverBorrow() {
		if(haveBorrowBook.size() >= maxBorrow)
			return true;
		else
			return false;
	}
	
	//�����Ƿ��Ѵ�����������-�ع�
	public boolean judgeIsOverReborrow(){
		if(reborrowCount >= maxReborrow)
			return true;
		else
			return false;
	}
	
	/*
	 * ��ȡ���޸Ĳ��ֳ�Ա����
	 */
	public void setUsername(String name){
		this.username = name;
	}
	public String getUserName(){
		return this.username;
	}
	
	/**
	 * ��������
	 */
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	
	
	//���úͷ��ؽ����߱��
	public void setBorrowerNumber(String i){
		this.borrowerNumber = i;
	}
	public String getBorrowerNumber(){
		return this.borrowerNumber;
	}
	
	//���úͷ��ؽ���������
	public void setBorrowerName(String name){
		this.borrowername = name;
	}
	public String getBorrowerName(){
		return this.borrowername;	
	}
	
	//���úͷ����Ա�
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	
	//��ȡ����ַ���
	public String getIdentity() {
		if(this instanceof Teacher)
			return "��ʦ";
		else if(this instanceof Undergraduate)
			return "������";
		else
			return "�о���";
		
	}
	
	
 }
	 

