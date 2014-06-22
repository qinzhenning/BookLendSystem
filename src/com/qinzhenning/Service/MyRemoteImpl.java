package com.qinzhenning.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Administrator.AdministratorList;
import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.Borrower.Postgraduate;
import com.qinzhenning.BookLendSystem.Borrower.Teacher;
import com.qinzhenning.BookLendSystem.Borrower.Undergraduate;
import com.qinzhenning.BookLendSystem.GUI.BorrowerFrame.BorrowerFrame;
import com.qinzhenning.BookLendSystem.GUI.LoginFrame.LoginFrame;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;


/**
 * @author   覃臻宁
 * 创建日期 ：2012-7-4 上午12:18:34
 * 文件名    ：MyRemoteImpl.java
 * 项目名    ：RMITest
 * 包名       ：com.qinzhenning.test1
 * 类名       ：MyRemoteImpl
 */
/**
 * 服务器端-实现接口
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	//添加抛出声明
	protected MyRemoteImpl() throws RemoteException { }

	//主方法
	public static void main(String[] args){
		try{
			LocateRegistry.createRegistry(1099);
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
			JOptionPane.showMessageDialog(null, "服务器已经准备好");
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * 初始化
	 */
	@Override
	public void First() {
		// TODO Auto-generated method stub
		Book a = new Book("IS1213", "Love", "覃臻宁", "China", 1992,false);
		Book b = new Book("111", "Love", "Qin", "China", 1993,true);
		Borrower teacher = new Teacher("borrower1","12345", "覃臻宁", "男","011521006");
		AdministratorList.addAdmin("admin", "12345", "覃臻宁", "男", "111250140");
		BorrowerList.addBorrower(teacher);
		BorrowerList.addBorrower(new Undergraduate("borrower2","12345", "罗聪聪", "男","011521003"));
		Library.addBookObject(a);
		
		
		
		Library.addBookObject(b);

//		try {
//			ReturnAllInfomation();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		new LoginFrame();
	}

	/**
	 * 保存所有信息
	 */
	@Override
	public String SaveAllInfomation() throws RemoteException {
		// TODO Auto-generated method stub
		String output = "";
		try{
			FileOutputStream fs = new FileOutputStream("./AllInformation.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			//管理员信息
			if(AdministratorList.getAdminList() != null)
			{
				os.writeInt(AdministratorList.getAdminList().size());
				for(int i = 0; i < AdministratorList.getAdminList().size(); i ++)
				{
					os.writeObject(AdministratorList.getAdminList().get(i));
				}
				output += "管理员信息已成功储存\n";
			}
			else
			{
				output += "管理员信息为空\n";
			}
			
			//借阅者信息
			ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
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
				output += "借阅人信息已成功储存\n";
			}
			
			//图书信息
			ArrayList<Book> bookList = Library.getBookList();
			if(bookList != null)
			{
				os.writeInt(bookList.size());
				for(int i = 0; i < bookList.size(); i ++)
				{
				os.writeObject(bookList.get(i));
				}
				output += "图书信息已成功储存\n";
			}
			else
			{
				output += "图书信息为空\n";
			}
			os.close();
			return output;
		}catch(Exception ex){
			try{
				FileOutputStream fs = new FileOutputStream("./AllInformation.ser");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				//管理员信息
				if(AdministratorList.getAdminList() != null)
				{
					os.writeInt(AdministratorList.getAdminList().size());
					for(int i = 0; i < AdministratorList.getAdminList().size(); i ++)
					{
						os.writeObject(AdministratorList.getAdminList().get(i));
					}
					output += "管理员信息已成功储存";
				}
				else
				{
					output += "管理员信息为空";
				}
				
				//借阅者信息
				ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
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
				}
				
				//图书信息
				ArrayList<Book> bookList = Library.getBookList();
				if(bookList != null)
				{
					os.writeInt(bookList.size());
					for(int i = 0; i < bookList.size(); i ++)
					{
					os.writeObject(bookList.get(i));
					}
					output += "图书信息已成功储存\n";
				}
				else
				{
					output += "图书信息为空\n";
				}
				os.close();
				return output;
			}catch(Exception e){
				output += "信息存储错误～\n";
				JOptionPane.showMessageDialog(null, output);
			}
		}
		return output;

	}

	/**
	 * 恢复所有信息
	 */
	@Override
	public void ReturnAllInfomation() throws RemoteException {
		// TODO Auto-generated method stub
		String output = "";
		try{
			FileInputStream fileStream = new FileInputStream("./AllInformation.ser");
			
			ObjectInputStream os = new ObjectInputStream(fileStream);
			//管理员信息恢复
			ArrayList<Administrator> admin = new ArrayList();
			int adminlistnumber = os.readInt();
			for(int i = 0; i < adminlistnumber; i ++ )
			{
				admin.add((Administrator) os.readObject());  
			}
			for(int i = 0;i < admin.size(); i ++)
			{
				AdministratorList.getAdminList().add(admin.get(i));
			}
			output += "aa管理员信息成功恢复!\n";
			
			
			//借阅者信息恢复
			ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
			int number1 = os.readInt();
			for(int i = 0; i < number1; i ++ )
			{
				borrowerList.add((Undergraduate) os.readObject());  
			}
			output += "本科生信息成功恢复\n";
			
			int number2 = os.readInt();
			for(int i = 0; i < number2; i ++ )
			{
				borrowerList.add((Postgraduate) os.readObject());  
			}
			output += "研究生信息成功恢复\n";
			
			int number3 = os.readInt();
			for(int i = 0; i < number3; i ++ )
			{
				borrowerList.add((Teacher) os.readObject());  
			}
			output += "老师信息成功恢复\n";
			
			//图书信息恢复
			ArrayList<Book> book = new ArrayList<Book>();
			int booklistnumber = os.readInt();
			for(int i = 0; i < booklistnumber; i ++ )
			{
				book.add((Book) os.readObject());  
			}
			for(int i = 0;i < book.size(); i ++)
			{
				Library.getBookList().add(book.get(i));
			}
			output += "图书信息成功恢复!\n";
			JOptionPane.showMessageDialog(null,output);
			
			os.close();
			}catch(Exception ex){

			try{
				FileInputStream fileStream = new FileInputStream("./AllInformation.ser");
				
				ObjectInputStream os = new ObjectInputStream(fileStream);
				
				//管理员信息恢复
				ArrayList<Administrator> admin = new ArrayList();
				int adminlistnumber = os.readInt();
				for(int i = 0; i < adminlistnumber; i ++ )
				{
					admin.add((Administrator) os.readObject());  
				}
				for(int i = 0;i < admin.size(); i ++)
				{
					AdministratorList.getAdminList().add(admin.get(i));
				}
				output += "管理员信息成功恢复!\n";
				
				
				//借阅者信息恢复
				ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
				int number1 = os.readInt();
				for(int i = 0; i < number1; i ++ )
				{
					borrowerList.add((Undergraduate) os.readObject());  
				}
				output += "本科生信息成功恢复\n";
				
				int number2 = os.readInt();
				for(int i = 0; i < number2; i ++ )
				{
					borrowerList.add((Postgraduate) os.readObject());  
				}
				output += "研究生信息成功恢复\n";
				
				int number3 = os.readInt();
				for(int i = 0; i < number3; i ++ )
				{
					borrowerList.add((Teacher) os.readObject());  
				}
				output += "老师信息成功恢复\n";
				
				//图书信息恢复
				ArrayList<Book> book = new ArrayList<Book>();
				int booklistnumber = os.readInt();
				for(int i = 0; i < booklistnumber; i ++ )
				{
					book.add((Book) os.readObject());  
				}
				for(int i = 0;i < book.size(); i ++)
				{
					Library.getBookList().add(book.get(i));
				}
				output += "图书信息成功恢复!\n";
				JOptionPane.showMessageDialog(null,output);
				
				os.close();
			}catch(Exception e){
				output += "信息导入错误～";
				JOptionPane.showMessageDialog(null,output);
			}
			}
	}

	
}
