package com.qinzhenning.BookLendSystem.Administrator;

import java.io.*;
import java.util.ArrayList;
/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:41:18
 * �ļ���AdministratorList.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.Administrator
 * ��  ��AdministratorList
 */

/**
 *����Ա�б� 
 */
public class AdministratorList implements Serializable{
		private static ArrayList<Administrator> adminlist = new ArrayList();
		
		//�޸Ĺ���Ա-�ع�
		public static void changeAdmin(Administrator a,String username,String password,String name,String sex,String number){
			if(!username.equals(""))
				a.setUsername(username);
			if(!password.equals(""))
				a.setPassword(password);
			if(!name.equals(""))
				a.setName(name);
			if(!sex.equals(""))
				a.setSex(sex);
			if(!number.equals(""))
				a.setAdminNumber(number);	
		}
		
		//��ӹ���Ա- �ع�
		public static void addAdmin(String username,String password,String name,String sex,String adnumber){
			
			adminlist.add(new Administrator(username,password,name, sex, adnumber));
			
		}
		
		//���ݱ����������Ա-�ع�
		public static Administrator findAdministrator(Object adNumber){
			Administrator ad = null ;
			for(int i = 0;i < adminlist.size();i ++)
			{
				if(adNumber.equals(adminlist.get(i).getAdminNumber()))
					ad = adminlist.get(i);
			}
			return ad;
				
		}
		
		//ɾ������Ա-�ع�
		public static void  deleteAdmin(Administrator o){
			if(o != null)
			adminlist.remove(o);
		}
		
		//���ع���Ա�б�-�ع�
		public static ArrayList<Administrator> getAdminList(){
			return adminlist;
		}
		
		//�������Ա��Ϣ
		public static void saveAdmin(){
			try{
				FileOutputStream fs = new FileOutputStream("admin.ser");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				if(adminlist != null)
				{
					os.writeInt(adminlist.size());
					for(int i = 0; i < adminlist.size(); i ++)
					{
					os.writeObject(adminlist.get(i));
					}
					System.out.println("����Ա��Ϣ�ѳɹ�����");
				}
				else
				{
					System.out.println("����Ա��ϢΪ��");
				}
				os.close();
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		
		//��ԭ����Ա��Ϣ
		public static void returnAdmin(){
			try{
			FileInputStream fileStream = new FileInputStream("admin.ser");
			
			ObjectInputStream os = new ObjectInputStream(fileStream);
			ArrayList<Administrator> admin = new ArrayList();
			int adminlistnumber = os.readInt();
			for(int i = 0; i < adminlistnumber; i ++ )
			{
				admin.add((Administrator) os.readObject());  
			}
			for(int i = 0;i < admin.size(); i ++)
			{
				adminlist.add(admin.get(i));
			}
			System.out.println("����Ա��Ϣ�ɹ��ָ�!");
			os.close();
			}catch(Exception ex){
//				ex.printStackTrace();
				System.out.println("����Ա��Ϣ�������");
			}
			
			
		}
		
		//�˶Թ���Ա�û���������-�ع�
		public static Administrator checkIsAdmin(String username,String password){
			Administrator back = null;
			if(adminlist != null)
			{
			for(int i = 0;i < adminlist.size();i ++)
			{
				if(username.equals(adminlist.get(i).getUsername()) && password.equals(adminlist.get(i).getPassword()))
					back = adminlist.get(i);
			}
			}
			return back;
		}

		//�˶���ӵ��û����Ƿ��ظ�
		public static boolean checkUsernameAgain(String username) {
			boolean isAgain = false;
			for(int i = 0; i < adminlist.size(); i ++)
			{
				if(username.equals(adminlist.get(i).getUsername()))
					isAgain = true;
			}
			return isAgain;
		}

		//�˶���ӵı���Ƿ��ظ�
		public static boolean checkAdnumberAgain(String number) {
			boolean isAgain = false;
			for(int i = 0; i < adminlist.size(); i ++)
			{
				if(number.equals(adminlist.get(i).getAdminNumber()))
					isAgain = true;
			}
			return isAgain;
		}
}