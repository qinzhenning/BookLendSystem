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
 * @author   ������
 * �������� ��2012-7-4 ����12:18:34
 * �ļ���    ��MyRemoteImpl.java
 * ��Ŀ��    ��RMITest
 * ����       ��com.qinzhenning.test1
 * ����       ��MyRemoteImpl
 */
/**
 * ��������-ʵ�ֽӿ�
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	//����׳�����
	protected MyRemoteImpl() throws RemoteException { }

	//������
	public static void main(String[] args){
		try{
			LocateRegistry.createRegistry(1099);
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
			JOptionPane.showMessageDialog(null, "�������Ѿ�׼����");
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * ��ʼ��
	 */
	@Override
	public void First() {
		// TODO Auto-generated method stub
		Book a = new Book("IS1213", "Love", "������", "China", 1992,false);
		Book b = new Book("111", "Love", "Qin", "China", 1993,true);
		Borrower teacher = new Teacher("borrower1","12345", "������", "��","011521006");
		AdministratorList.addAdmin("admin", "12345", "������", "��", "111250140");
		BorrowerList.addBorrower(teacher);
		BorrowerList.addBorrower(new Undergraduate("borrower2","12345", "�޴ϴ�", "��","011521003"));
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
	 * ����������Ϣ
	 */
	@Override
	public String SaveAllInfomation() throws RemoteException {
		// TODO Auto-generated method stub
		String output = "";
		try{
			FileOutputStream fs = new FileOutputStream("./AllInformation.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			//����Ա��Ϣ
			if(AdministratorList.getAdminList() != null)
			{
				os.writeInt(AdministratorList.getAdminList().size());
				for(int i = 0; i < AdministratorList.getAdminList().size(); i ++)
				{
					os.writeObject(AdministratorList.getAdminList().get(i));
				}
				output += "����Ա��Ϣ�ѳɹ�����\n";
			}
			else
			{
				output += "����Ա��ϢΪ��\n";
			}
			
			//��������Ϣ
			ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
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
				output += "��������Ϣ�ѳɹ�����\n";
			}
			
			//ͼ����Ϣ
			ArrayList<Book> bookList = Library.getBookList();
			if(bookList != null)
			{
				os.writeInt(bookList.size());
				for(int i = 0; i < bookList.size(); i ++)
				{
				os.writeObject(bookList.get(i));
				}
				output += "ͼ����Ϣ�ѳɹ�����\n";
			}
			else
			{
				output += "ͼ����ϢΪ��\n";
			}
			os.close();
			return output;
		}catch(Exception ex){
			try{
				FileOutputStream fs = new FileOutputStream("./AllInformation.ser");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				//����Ա��Ϣ
				if(AdministratorList.getAdminList() != null)
				{
					os.writeInt(AdministratorList.getAdminList().size());
					for(int i = 0; i < AdministratorList.getAdminList().size(); i ++)
					{
						os.writeObject(AdministratorList.getAdminList().get(i));
					}
					output += "����Ա��Ϣ�ѳɹ�����";
				}
				else
				{
					output += "����Ա��ϢΪ��";
				}
				
				//��������Ϣ
				ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
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
				}
				
				//ͼ����Ϣ
				ArrayList<Book> bookList = Library.getBookList();
				if(bookList != null)
				{
					os.writeInt(bookList.size());
					for(int i = 0; i < bookList.size(); i ++)
					{
					os.writeObject(bookList.get(i));
					}
					output += "ͼ����Ϣ�ѳɹ�����\n";
				}
				else
				{
					output += "ͼ����ϢΪ��\n";
				}
				os.close();
				return output;
			}catch(Exception e){
				output += "��Ϣ�洢����\n";
				JOptionPane.showMessageDialog(null, output);
			}
		}
		return output;

	}

	/**
	 * �ָ�������Ϣ
	 */
	@Override
	public void ReturnAllInfomation() throws RemoteException {
		// TODO Auto-generated method stub
		String output = "";
		try{
			FileInputStream fileStream = new FileInputStream("./AllInformation.ser");
			
			ObjectInputStream os = new ObjectInputStream(fileStream);
			//����Ա��Ϣ�ָ�
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
			output += "aa����Ա��Ϣ�ɹ��ָ�!\n";
			
			
			//��������Ϣ�ָ�
			ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
			int number1 = os.readInt();
			for(int i = 0; i < number1; i ++ )
			{
				borrowerList.add((Undergraduate) os.readObject());  
			}
			output += "��������Ϣ�ɹ��ָ�\n";
			
			int number2 = os.readInt();
			for(int i = 0; i < number2; i ++ )
			{
				borrowerList.add((Postgraduate) os.readObject());  
			}
			output += "�о�����Ϣ�ɹ��ָ�\n";
			
			int number3 = os.readInt();
			for(int i = 0; i < number3; i ++ )
			{
				borrowerList.add((Teacher) os.readObject());  
			}
			output += "��ʦ��Ϣ�ɹ��ָ�\n";
			
			//ͼ����Ϣ�ָ�
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
			output += "ͼ����Ϣ�ɹ��ָ�!\n";
			JOptionPane.showMessageDialog(null,output);
			
			os.close();
			}catch(Exception ex){

			try{
				FileInputStream fileStream = new FileInputStream("./AllInformation.ser");
				
				ObjectInputStream os = new ObjectInputStream(fileStream);
				
				//����Ա��Ϣ�ָ�
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
				output += "����Ա��Ϣ�ɹ��ָ�!\n";
				
				
				//��������Ϣ�ָ�
				ArrayList<Borrower> borrowerList = BorrowerList.getBorrowerList();
				int number1 = os.readInt();
				for(int i = 0; i < number1; i ++ )
				{
					borrowerList.add((Undergraduate) os.readObject());  
				}
				output += "��������Ϣ�ɹ��ָ�\n";
				
				int number2 = os.readInt();
				for(int i = 0; i < number2; i ++ )
				{
					borrowerList.add((Postgraduate) os.readObject());  
				}
				output += "�о�����Ϣ�ɹ��ָ�\n";
				
				int number3 = os.readInt();
				for(int i = 0; i < number3; i ++ )
				{
					borrowerList.add((Teacher) os.readObject());  
				}
				output += "��ʦ��Ϣ�ɹ��ָ�\n";
				
				//ͼ����Ϣ�ָ�
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
				output += "ͼ����Ϣ�ɹ��ָ�!\n";
				JOptionPane.showMessageDialog(null,output);
				
				os.close();
			}catch(Exception e){
				output += "��Ϣ�������";
				JOptionPane.showMessageDialog(null,output);
			}
			}
	}

	
}
