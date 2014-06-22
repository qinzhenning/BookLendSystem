package com.qinzhenning.BookLendSystem.Borrower;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
/**
 * 
 * @author Administrator
 * 时间：2012-7-15下午4:35:29
 * 文件：BorrowerList.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Borrower
 * 类  ：BorrowerList
 */
/**
 * 借阅者列表类
 */
public abstract class BorrowerList implements Serializable {
	private static ArrayList<Borrower> borrowerList  = new ArrayList();
	
	//添加借阅者
	public static void addBorrower(Borrower borrower) {
		borrowerList.add(borrower);
	}
	
	//删除借阅者 - 重构
	public static void deletBorrower(Borrower borrower){
		borrowerList.remove(borrower);
	}
	
	//修改借阅者信息-重构
	public static void changeBorrower(Borrower borrower,String username,
			 					String password,String name,String sex,String number){
		if(borrower != null)
		{
			if(!username.equals(""))
				borrower.setUsername(username);
			
			if(!password.equals(""))
				borrower.setPassword(password);
			
			if(!name.equals(""))
				borrower.setBorrowerName(name);
			
			if(!sex.equals(""))
				borrower.setSex(sex);
			
			if(!number.equals(""))
				borrower.setBorrowerNumber(number);
		}
		
	}
	
	//根据编号返回借阅者对象 -重构
	public static Borrower findBorrower(Object number){

		Borrower find = null;
		if(borrowerList != null)
		{
			for(int i = 0;i < borrowerList.size(); i ++)
			{
				if(number.equals(borrowerList.get(i).getBorrowerNumber()))
					find = borrowerList.get(i);
			}
		}
		return find;
	}
	
	/**
	 * 获取借阅者成员列表
	 */
	public static ArrayList<Borrower> getBorrowerList(){
		return borrowerList;
	}
	
	//保存借阅者信息
	public static void saveBorrower(){
			try{
					FileOutputStream fs = new FileOutputStream("borrower.ser");
					ObjectOutputStream os = new ObjectOutputStream(fs);
					if(borrowerList != null)
					{
						int number1=0 , number2 = 0,number3 = 0;
						//储存本科生
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Undergraduate)
							number1++;
						}
						//本科生人数
						os.writeInt(number1);
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Undergraduate )
							os.writeObject(borrowerList.get(i));
						}
						
						//储存研究生
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Postgraduate)
							number2++;
						}
						//研究生人数
						os.writeInt(number2);
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Postgraduate)
							os.writeObject(borrowerList.get(i));
						}
						
						//储存老师
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Teacher)
							number3++;
						}
						//老师人数
						os.writeInt(number3);
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Teacher)
							os.writeObject(borrowerList.get(i));
						}
						
					
						
					os.close();
					
					fs = new FileOutputStream("borrowerHBB.ser");
					os = new ObjectOutputStream(fs);
					for(int i = 0; i < borrowerList.size(); i ++)
					{
						os.writeObject(borrowerList.get(i).getHBB());
					}
					
					System.out.println("借阅者信息已成功储存");
					
				}
			}catch(Exception ex){
					ex.printStackTrace();
				}
			
		}

	//恢复借阅者信息
	public static void returnBorrower(){
	try{
		FileInputStream fileStream = new FileInputStream("borrower.ser");
		
		ObjectInputStream os = new ObjectInputStream(fileStream);
		int number1 = os.readInt();
		for(int i = 0; i < number1; i ++ )
		{
			borrowerList.add((Undergraduate) os.readObject());  
		}
		System.out.println("本科生信息成功恢复");
		
		int number2 = os.readInt();
		for(int i = 0; i < number2; i ++ )
		{
			borrowerList.add((Postgraduate) os.readObject());  
		}
		System.out.println("研究生信息成功恢复");
		
		int number3 = os.readInt();
		for(int i = 0; i < number3; i ++ )
		{
			borrowerList.add((Teacher) os.readObject());  
		}
		System.out.println("老师信息成功恢复");
		
		fileStream = new FileInputStream("borrowerHBB.ser");
		os = new ObjectInputStream(fileStream);
		ArrayList<Book> hbbList = new ArrayList<Book>();
		for(int i = 0; i < borrowerList.size(); i ++)
		{
			for(int j = 0;j < borrowerList.get(i).getHBB().size();j ++ )
			{
				hbbList.add(Library.searchBook(borrowerList.get(i).getHBB().get(j).getISBN()));
			}
				borrowerList.get(i).setHbb(hbbList);
		}
		System.out.println(borrowerList.get(0).getHBB().size());
		os.close();
		}catch(Exception ex){
//			ex.printStackTrace();
			System.out.println("借阅人信息导入错误～");
		}
}

	//核对是否为借阅者 - 重构
	public static Borrower checkIsBorrower(String username,String password){
		Borrower back = null;
		if(borrowerList != null)
		{
		for(int i = 0;i < borrowerList.size();i ++)
		{
			if(username.equals(borrowerList.get(i).getUserName()) && password.equals(borrowerList.get(i).getPassword()))
				back = borrowerList.get(i);
		}
		}
		return back;
	}
}