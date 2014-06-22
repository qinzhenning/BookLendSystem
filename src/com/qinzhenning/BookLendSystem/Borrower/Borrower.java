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
 * 时间：2012-7-15下午5:42:15
 * 文件：Borrower.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Borrower
 * 类  ：Borrower
 */

/**
 * 借阅者
 */
public  abstract class Borrower implements Serializable {

	  protected String 					username;											//用户名
	  protected String 					password;											//密码
	  protected String					borrowername;										//姓名
	  protected String 					sex;													//性别
	  protected String 					borrowerNumber;									//借阅人编号			
	  protected int  		 		    	reborrowCount;										//续借次数
	   ArrayList<Book>					haveBorrowBook = new ArrayList<Book>();		  	//已借图书
	   Library 							search;					
	  protected int 					maxBorrow ;  										//最大借阅本数
	  protected int 					maxReborrow ;										//最大续借次数	
		

	 //续借图书 - 重构
	 public  void reBorrowBook(Book book){
				Date nowdate = Time.getnowTimeDate();
				String nowstring = Time.getTimeString(nowdate);
				Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
			    String returnstring = Time.getTimeString(returndate);
			    
			    
			    if(book.getReborrowTime() > 1)
			    		JOptionPane.showMessageDialog(null, "您的续借次数已经达到最大次数");
			    else if(book.getisAsk())
			    		JOptionPane.showMessageDialog(null, "该书已被教师请求，您无法续借");
			    else if(judgeIsOverTime())
			    		JOptionPane.showMessageDialog(null, "该您有超期未还书情况，无法续借");
			    else
			    {
			    		
			    		book.setborrowTime(nowdate);
			    		book.setshouldReturnTime(returndate);
			    		book.reborrowTime++;
			    		JOptionPane.showMessageDialog(null, "续借成功～");
			    }				
		}
	 
	 
	 //归还图书 - 重构
	 public  void returnBook(Book book){
		 if(book != null)
		 {			
					haveBorrowBook.remove(book);
					book.setborrowTime(null);
					book.setshouldReturnTime(null);
					book.setreaderNumber(null);
					book.setReborrowTime(0);
					JOptionPane.showMessageDialog(null, "归还成功～");
		 }	
			
	 }
	 
	 //查看图书到期信息
	 public  String seeMessage_BookToDate(){
			String output = "一、超期图书消息：";
			
			if(judgeIsOverTime())
			{
				output += "\n" + "您有超期图书未归还！";
				int j = 1;
				for(int i = 0;i < haveBorrowBook.size(); i++)
				{
					int date1 = haveBorrowBook.get(i).getshouldReturnTime().getDate();
					int date2 = haveBorrowBook.get(i).getborrowTime().getDate();
					if((date1 - date2) <= 0)	
					{
						output += "\n" + j + "您的  编号为" + haveBorrowBook.get(i).getISBN() + "  书名为  " 
					              + haveBorrowBook.get(i).getbookName() + " 已超过了规定的时间归还。请您立即归还 ";
						j++;
					}
				}
			}
			else{
				output += "\n无。\n";
					}
			output += "二、归还图书消息:";
			if(haveBorrowBook.size() != 0)
			{	
				int j = 1;
				for(int i = 0; i < haveBorrowBook.size();i ++)
				{	
					Date date1 = haveBorrowBook.get(i).getshouldReturnTime();
					Date date2 = haveBorrowBook.get(i).getborrowTime();
					
					if((date1.getDate() - date2.getDate()) <= 7 && (date1.getMonth() == date2.getMonth()) && (date1.getYear() == date2.getYear()) )	
						output +="\n" + j + ".您的 编号为 " + haveBorrowBook.get(i).getISBN() + "  书名为"
								+ haveBorrowBook.get(i).getbookName() + " 需要在 " + (date1.getDate() - date2.getDate()) + " 天内归还。";
				}
			}
			else
			{
				output += "\n无。";
			}
			return output;
	 }

	 //查看请求图书信息-非教师
	 public String seeMessage_AskBook(){
		 String output = "请求信息：";
		 int j = 1;
		 for(int i = 0;i < haveBorrowBook.size(); i++)
			{
				if(haveBorrowBook.get(i).getisAsk())
				{
					output += "\n" + j + "您的  编号为 " + haveBorrowBook.get(i).getISBN() + "   书名为 "
							   + haveBorrowBook.get(i).getbookName() + " 被教师请求";
					j++;
				}
			}
		 return output;
			}
			
	 
	 //借阅图书 - -部分重构 
	 public  void borrowBook(Book borrowbook){
		 	Date nowdate = Time.getnowTimeDate();
			String nowstring = Time.getTimeString(nowdate);
			Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
		    String returnstring = Time.getTimeString(returndate);
		    
			if(haveBorrowBook.size() >= maxBorrow)
			{
				JOptionPane.showMessageDialog(null, "已达借阅最大本数，无法借阅！");
				
			}
			else
			{
				if(borrowbook !=null)
				{
				if(borrowbook.getisSpecialBook()&& (this instanceof Undergraduate))
					JOptionPane.showMessageDialog(null,"该图书为珍本，本科生无权借阅!");
				else
				{
					if(borrowbook.getborrowTime() != null)
					{   
						if(!(this instanceof Teacher))
							JOptionPane.showMessageDialog(null,"该书被借空，无法借阅");
					}
					else
					{
					    haveBorrowBook.add(borrowbook);
					    borrowbook.setborrowTime(nowdate);
					    borrowbook.setshouldReturnTime(returndate);
					    borrowbook.setreaderNumber(borrowerNumber);
					    JOptionPane.showMessageDialog(null,"借阅成功");
					    
					}
				}
			}
				
			}
	 }
	 
	 //返回已借图书列表 - 重构
	 public ArrayList<Book> getHBB(){
		 return haveBorrowBook;
	 }
	 
	 
	 //添加已借图书对象-重构
	 public void addHbb(Book book){
		 haveBorrowBook.add(book);
	 }
	
	 //设置已借图书列表对象
	 public void setHbb(ArrayList<Book> hbbList){
		 haveBorrowBook = hbbList;
	 }
	 
		 
	//返回是否有图书超期未还-重构
	public boolean judgeIsOverTime(){
		boolean isOverTime = false;
		for(int i=0; i < haveBorrowBook.size();i++)
		{
		if(Time.before(haveBorrowBook.get(i).getshouldReturnTime(), new Date()))
			isOverTime = true;
		}
		
		return isOverTime;
	}
	
	//返回是否已达最大借阅本数-重构
	public boolean judgIsOverBorrow() {
		if(haveBorrowBook.size() >= maxBorrow)
			return true;
		else
			return false;
	}
	
	//返回是否已达最大续借次数-重构
	public boolean judgeIsOverReborrow(){
		if(reborrowCount >= maxReborrow)
			return true;
		else
			return false;
	}
	
	/*
	 * 获取和修改部分成员变量
	 */
	public void setUsername(String name){
		this.username = name;
	}
	public String getUserName(){
		return this.username;
	}
	
	/**
	 * 设置密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	
	
	//设置和返回借阅者编号
	public void setBorrowerNumber(String i){
		this.borrowerNumber = i;
	}
	public String getBorrowerNumber(){
		return this.borrowerNumber;
	}
	
	//设置和返回借阅者姓名
	public void setBorrowerName(String name){
		this.borrowername = name;
	}
	public String getBorrowerName(){
		return this.borrowername;	
	}
	
	//设置和返回性别
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	
	//获取身份字符串
	public String getIdentity() {
		if(this instanceof Teacher)
			return "老师";
		else if(this instanceof Undergraduate)
			return "本科生";
		else
			return "研究生";
		
	}
	
	
 }
	 

