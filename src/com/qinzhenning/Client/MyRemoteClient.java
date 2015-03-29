package com.qinzhenning.Client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.qinzhenning.Service.MyRemote;

/**
 * @author   覃臻宁
 * 创建日期 ：2012-7-4 上午12:26:07
 * 文件名    ：MyRemoteClient.java
 * 项目名    ：RMIClient
 * 包名       ：com.qinzhenning.test2
 * 类名       ：MyRemoteClient
 */
/**
 * 客户端
 */
public class MyRemoteClient {
	
	//初始化
	void go(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			service.First();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//保存数据
	public void SaveAllData(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			JOptionPane.showMessageDialog(null,service.SaveAllInfomation());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//恢复数据
	public void ReturnAllData(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			service.ReturnAllInfomation();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//主方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRemoteClient Client = new MyRemoteClient();
		Client.go();
                system.out.prirntln("test");
                system.out.prirntln("test2");
		
		
	}

}
