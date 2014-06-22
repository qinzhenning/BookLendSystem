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
 * 时间：2012-7-15下午5:42:41
 * 文件：Teacher.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Borrower
 * 类  ：Teacher
 */

/**
 * 教师
 */
public class Teacher extends Borrower implements Serializable{
	public ArrayList<Book> haveAskBook = new ArrayList();
	
	/**
	 * 构造方法-设置用户名、密码、名字、性别、编号、最大借阅本书
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
	
	//重载父类借阅图书方法
	public  void borrowBook(Book borrowbook){
		Date nowdate = Time.getnowTimeDate();
		String nowstring = Time.getTimeString(nowdate);
		Date returndate = Time.setTime(nowdate.getYear(), nowdate.getMonth(), nowdate.getDate()+30);
	    String returnstring = Time.getTimeString(returndate);
	   
	    
		if(haveBorrowBook.size() > maxBorrow)
			JOptionPane.showMessageDialog(null,"已达借阅最大本数，无法借阅！");
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
//				    JOptionPane.showMessageDialog(null,"借阅成功"); 
				}
			}
		}
 }
	
	
	//请求图书-部分重构
	public void askBook(Book book){
				if(BorrowerList.findBorrower(book.getreaderNumber()) instanceof Teacher)
					JOptionPane.showMessageDialog(null,"该图书的借阅者也为老师，您不能请求");
				else{
					book.setisAsk(true, book.getshouldReturnTime());
					haveAskBook.add(book);
					JOptionPane.showMessageDialog(null,"该图书已被借阅，系统已帮您自动请求图书，请7天后关注‘查看消息’栏");
				}
			}
		
	//查看消息
	public  String seeMessage_askBookCome(){
		String output = "请求的图书归还信息：";
		int j = 1;

			if(haveAskBook != null)
			{
			
				for(int i = 0; i < haveAskBook.size();i ++ )
				{
					if(haveAskBook.get(i).getshouldReturnTime() == null)
						output += "\n" + j + "您的 编号为" + haveAskBook.get(i).getISBN() + "    书名为 "
									+ haveAskBook.get(i).getbookName() + "已归还，可以借阅了。";
					j++;
				}
			}
			return output;
		}
	}

	

	


