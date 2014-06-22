package com.qinzhenning.BookLendSystem.Library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;

/*  图书馆类
 * 	使用者：系统管理员，借阅�
 *  说明�
 *�类的成员变量包括图书类对象的列表�?
 *�类的成员方法包括图书类对象的增加、删除�、修改�
 */

//注意：此类不能用继承，因为图书类和图书馆类不�是 IS-A    关系�

public class Library implements Serializable{
	
	/*
	 * 类的成员变量
	 */

	//创建图书类对象列表bookList
	private  static ArrayList<Book> bookList = new ArrayList<Book>();
	
	/*
	 * 类的成员方法
	 * 为了后面图形界面的实现，尽量少改动第二阶段源文件
     * 接口做好，易于迭代三
	 */
	
	//图书类对象的的增加 - 重构
	public static void addBookObject(Book book){
		
		bookList.add(book);
		
	}
	
	//图书类对象的修改(目标对象，修改项）-重构
	public static void changeBookObject(Book book,String ISBN,
			String bookName,String bookAuthor,String publicHome,
			int bookYear,boolean isSpecialBook){
		if(!ISBN.equals(""))
			book.setISBN(ISBN);
		
		if(!bookName.equals(""))
			book.setbookName(bookName);
		
		if(!bookAuthor.equals(""))
			book.setbookAuthor(bookAuthor);
		
		if(!publicHome.equals(""))
			book.setpublicHome(publicHome);
		
		if(bookYear > 0)
			book.setbookYear(bookYear);
		
		
		 book.setisSpecialBook(isSpecialBook);
	}
	
	//图书类对象的删除-重构
	public static void deleteBookObject(Book book){
		if(book != null)
		bookList.remove(book);
	}
	
	//获取图书列表-重构
	public static ArrayList<Book> getBookList(){
		return bookList;
	}

	//根据各种信息搜索图书-重构
	public static ArrayList<Book> searchBook(String ISBN,String bookName,
								String bookAuthor,String publicHome,int year){
		ArrayList<Book> searchList = new ArrayList<Book>();
		for(int i = 0; i < bookList.size(); i++) {
			if(((ISBN.equals("")) || bookList.get(i).getISBN().equals(ISBN))
				&& ((bookName.equals("")) || bookList.get(i).getbookName().equals(bookName))
				&& ((bookAuthor.equals("")) || bookList.get(i).getbookAuthor().equals(bookAuthor))
				&& ((publicHome.equals("")) || bookList.get(i).getpublicHome().equals(publicHome))
				&& ((year == 0 ) || (bookList.get(i).getbookYear() == year)))
					searchList.add(bookList.get(i));
				
		}
		return searchList;
		
		
	}

	//重载搜索图书-根据编号搜索-重构
	public static Book searchBook(Object tableData) {
		Book book = null;
		for(int i = 0;i < bookList.size();i ++) {
			if(bookList.get(i).getISBN().equals(tableData))
				book = bookList.get(i);
			}
		return book;
	}
	
	//保存图书信息
	public static void saveBookData(){
		try{
			FileOutputStream fs = new FileOutputStream("book.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			if(bookList != null)
			{
				os.writeInt(bookList.size());
				for(int i = 0; i < bookList.size(); i ++)
				{
				os.writeObject(bookList.get(i));
				}
				System.out.println("图书信息已成功储存");
			}
			else
			{
				System.out.println("图书信息为空");
			}
			os.close();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//恢复图书信息
	public static void returnBookData(){
		try{
			FileInputStream fileStream = new FileInputStream("book.ser");
			
			ObjectInputStream os = new ObjectInputStream(fileStream);
			ArrayList<Book> book = new ArrayList<Book>();
			int booklistnumber = os.readInt();
			for(int i = 0; i < booklistnumber; i ++ )
			{
				book.add((Book) os.readObject());  
			}
			for(int i = 0;i < book.size(); i ++)
			{
				bookList.add(book.get(i));
			}
			System.out.println("图书信息成功恢复!");
			os.close();
			}catch(Exception ex){
//				ex.printStackTrace();
				System.out.println("图书信息导入错误～");
			}
	}
	
}

