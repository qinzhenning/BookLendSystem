package com.qinzhenning.BookLendSystem.Administrator;

import java.io.*;
import java.util.ArrayList;
/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午5:41:18
 * 文件：AdministratorList.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.Administrator
 * 类  ：AdministratorList
 */

/**
 *管理员列表 
 */
public class AdministratorList implements Serializable{
		private static ArrayList<Administrator> adminlist = new ArrayList();
		
		//修改管理员-重构
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
		
		//添加管理员- 重构
		public static void addAdmin(String username,String password,String name,String sex,String adnumber){
			
			adminlist.add(new Administrator(username,password,name, sex, adnumber));
			
		}
		
		//根据编号搜索管理员-重构
		public static Administrator findAdministrator(Object adNumber){
			Administrator ad = null ;
			for(int i = 0;i < adminlist.size();i ++)
			{
				if(adNumber.equals(adminlist.get(i).getAdminNumber()))
					ad = adminlist.get(i);
			}
			return ad;
				
		}
		
		//删除管理员-重构
		public static void  deleteAdmin(Administrator o){
			if(o != null)
			adminlist.remove(o);
		}
		
		//返回管理员列表-重构
		public static ArrayList<Administrator> getAdminList(){
			return adminlist;
		}
		
		//保存管理员信息
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
					System.out.println("管理员信息已成功储存");
				}
				else
				{
					System.out.println("管理员信息为空");
				}
				os.close();
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		
		//还原管理员信息
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
			System.out.println("管理员信息成功恢复!");
			os.close();
			}catch(Exception ex){
//				ex.printStackTrace();
				System.out.println("管理员信息导入错误～");
			}
			
			
		}
		
		//核对管理员用户名和密码-重构
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

		//核对添加的用户名是否重复
		public static boolean checkUsernameAgain(String username) {
			boolean isAgain = false;
			for(int i = 0; i < adminlist.size(); i ++)
			{
				if(username.equals(adminlist.get(i).getUsername()))
					isAgain = true;
			}
			return isAgain;
		}

		//核对添加的编号是否重复
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