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
 * ʱ�䣺2012-7-15����4:35:29
 * �ļ���BorrowerList.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Borrower
 * ��  ��BorrowerList
 */
/**
 * �������б���
 */
public abstract class BorrowerList implements Serializable {
	private static ArrayList<Borrower> borrowerList  = new ArrayList();
	
	//��ӽ�����
	public static void addBorrower(Borrower borrower) {
		borrowerList.add(borrower);
	}
	
	//ɾ�������� - �ع�
	public static void deletBorrower(Borrower borrower){
		borrowerList.remove(borrower);
	}
	
	//�޸Ľ�������Ϣ-�ع�
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
	
	//���ݱ�ŷ��ؽ����߶��� -�ع�
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
	 * ��ȡ�����߳�Ա�б�
	 */
	public static ArrayList<Borrower> getBorrowerList(){
		return borrowerList;
	}
	
	//�����������Ϣ
	public static void saveBorrower(){
			try{
					FileOutputStream fs = new FileOutputStream("borrower.ser");
					ObjectOutputStream os = new ObjectOutputStream(fs);
					if(borrowerList != null)
					{
						int number1=0 , number2 = 0,number3 = 0;
						//���汾����
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Undergraduate)
							number1++;
						}
						//����������
						os.writeInt(number1);
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Undergraduate )
							os.writeObject(borrowerList.get(i));
						}
						
						//�����о���
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Postgraduate)
							number2++;
						}
						//�о�������
						os.writeInt(number2);
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Postgraduate)
							os.writeObject(borrowerList.get(i));
						}
						
						//������ʦ
						for(int i = 0; i < borrowerList.size(); i ++)
						{if(borrowerList.get(i) instanceof  Teacher)
							number3++;
						}
						//��ʦ����
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
					
					System.out.println("��������Ϣ�ѳɹ�����");
					
				}
			}catch(Exception ex){
					ex.printStackTrace();
				}
			
		}

	//�ָ���������Ϣ
	public static void returnBorrower(){
	try{
		FileInputStream fileStream = new FileInputStream("borrower.ser");
		
		ObjectInputStream os = new ObjectInputStream(fileStream);
		int number1 = os.readInt();
		for(int i = 0; i < number1; i ++ )
		{
			borrowerList.add((Undergraduate) os.readObject());  
		}
		System.out.println("��������Ϣ�ɹ��ָ�");
		
		int number2 = os.readInt();
		for(int i = 0; i < number2; i ++ )
		{
			borrowerList.add((Postgraduate) os.readObject());  
		}
		System.out.println("�о�����Ϣ�ɹ��ָ�");
		
		int number3 = os.readInt();
		for(int i = 0; i < number3; i ++ )
		{
			borrowerList.add((Teacher) os.readObject());  
		}
		System.out.println("��ʦ��Ϣ�ɹ��ָ�");
		
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
			System.out.println("��������Ϣ�������");
		}
}

	//�˶��Ƿ�Ϊ������ - �ع�
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