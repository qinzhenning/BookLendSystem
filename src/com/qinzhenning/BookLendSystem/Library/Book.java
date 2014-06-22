package com.qinzhenning.BookLendSystem.Library;

import java.io.Serializable;
import java.util.Date;


import com.qinzhenning.BookLendSystem.info.Time;
/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午3:09:32
 * 文件：Book.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Library
 * 类  ：Book
 */
/**
 * 图书类
 */
public class Book implements Serializable{
	private String         ISBN;
	private String 		  bookName;
    private String		  bookAuthor;
    private String  	  	  publicHome;
    private int     		  bookYear;
    private String         borrowerNumber;
    private Date  	      borrowTime;
    private Date    		  shouldReturnTime;
    private boolean	  	  isAsk;
    private boolean 	  isSpecialBook;
    public int 			  reborrowTime;
 
    /**
     * 构造方法- 编号、书名、作者、出版社、年份、是否珍本
     */
    public Book(String number,String name,String author,
			 String publichome,int year,boolean isSpecial){
    	ISBN = number;
    	bookName = name;
    	bookAuthor = author;
    	publicHome = publichome;
    	bookYear = year;
    	isSpecialBook = isSpecial;
    	isAsk = false;
    }
   
    /**
	 * 设置图书编号
	 */
    public void setISBN(String ISBN){
    		this.ISBN = ISBN;
    }
    public String getISBN(){
    	return this.ISBN;
    }
  
    /**
	 * 设置图书书名
	 */
    public void setbookName(String bookName){
    	this.bookName = bookName;
    }
    public String getbookName(){
    	return this.bookName;
    }
        
    /**
	 * 设置图书作者
	 */
    public void setbookAuthor(String bookAuthor){
    	this.bookAuthor = bookAuthor;
    }
    public String getbookAuthor(){
    	return this.bookAuthor;
    }
    
    
    /**
	 * 设置图书出版社
	 */
    public void setpublicHome(String publicHome){
    	this.publicHome = publicHome;
    }
    public String getpublicHome(){
    	return this.publicHome;
    }

    /**
	 * 设置图书年份
	 */
    public void setbookYear(int bookYear){
    	this.bookYear= bookYear;
    }
    public int getbookYear(){
	 return this.bookYear;
    }
  

    /**
	 * 设置图书借阅者编号
	 */
    public void setreaderNumber(String readerNumber){	
    	this.borrowerNumber = readerNumber;
    }
    public String getreaderNumber(){
    	return this.borrowerNumber;
    }
    
    /**
	 * 设置借阅时间
	 */
    public void setborrowTime(Date borrowTime ){
    	
    	this.borrowTime = borrowTime;
    }
    public Date getborrowTime(){
    	return this.borrowTime;
    }
      
    /**
	 * 设置归还时间
	 */
    public void setshouldReturnTime( Date returndate ){
    	this.shouldReturnTime = returndate;
    }   
    public Date getshouldReturnTime(){
    	return this.shouldReturnTime;
    }
    
    /**
     * 设置是否被请求
     */
    public void setisAsk(boolean judge,Date returndate){
    	if(judge)
    	{	
    			returndate = Time.getnowTimeDate();
    			returndate.setDate(Time.getnowTimeDate().getDate() + 7);
    		this.setshouldReturnTime(returndate);
    	}
    	this.isAsk = judge;
    }
    public boolean getisAsk(){
    	return this.isAsk;
    }
    
    /**
	 * 设置是否珍本
	 */
    public void setisSpecialBook(boolean sp){
    	this.isSpecialBook = sp;	
    }
    public boolean getisSpecialBook(){
		return isSpecialBook;
	}
	
    /**
     * 
     * 设置续借次数
     */
    public void setReborrowTime(int a){
    	reborrowTime = a;
    }
    public int getReborrowTime(){
    	return reborrowTime;
    }
	
}
