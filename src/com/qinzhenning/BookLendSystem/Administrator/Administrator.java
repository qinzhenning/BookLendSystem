package com.qinzhenning.BookLendSystem.Administrator;

import java.io.Serializable;
import java.util.ArrayList;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.Borrower.Postgraduate;
import com.qinzhenning.BookLendSystem.Borrower.Teacher;
import com.qinzhenning.BookLendSystem.Borrower.Undergraduate;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * 
 * @author Administrator
 * 时间：2012-7-15下午1:54:57
 * 文件：Administrator.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Administrator
 * 类  ：Administrator
 */

/**
 * 管理员
 */	
public class Administrator implements Serializable {
	
	private String 	username = "admin";	  				//用户名
	private String 	password = "123456";	 				//密码
	private String  	sex;										//性别
	private String 	name;									//姓名
    private String 	adNumber;								//图书管理员编号


     /**
      * 管理员的构造方法
      */
     public  Administrator(String username,String password,String name,String sex,String adnumber){
    	
    	setUsername(username);
    	setPassword(password);
    	setSex(sex);
    	setName(name);
    	setAdminNumber(adnumber);
    	
    	
    }
     
     /**
      * 添加借阅者
      */
    public void addBorrower(Borrower borrower){
    	BorrowerList.addBorrower(borrower);
    }
    
    /**
     * 修改借阅者
     */
    public void changeBorrower(Borrower borrower,String username,
				String password,String name,String sex,String number){
  
    	BorrowerList.changeBorrower(borrower, username, password, name, sex, number);
    }
    
    /**
     * 删除借阅者
     */
    public void deletBorrower(Borrower borrower){
    	BorrowerList.deletBorrower(borrower);
    }
    
    
    /**
     * 搜索图书馆图书
     */
    public void searchLibraryBook(){
    
		
    }

    
    /**
     * 设置管理员名字
     */
    public void setUsername(String name){
    	this.username = name;
    }
    public String getUsername(){
    	return this.username;
    }
    
   /**
    * 设置密码
    */
    public void setPassword(String mima){
    	this.password = mima;
    }

    public String getPassword(){
    	return this.password;
    }
    

    /**
     * 设置性别
     */
    public void setSex(String sex){
    	this.sex = sex;
    }

    public String getSex(){
    	return this.sex;
    }
    
    /**
     * 设置名字
     */
    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return this.name;
    }
    
    /**
     * 设置编号
     */
    public void setAdminNumber(String number){
    	this.adNumber = number;
    }

    public String getAdminNumber(){
    	return this.adNumber;
    }
    
    
    
    
}
