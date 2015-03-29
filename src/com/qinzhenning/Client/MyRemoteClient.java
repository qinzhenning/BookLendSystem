package com.qinzhenning.Client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.qinzhenning.Service.MyRemote;

/**
 * @author   ������
 * �������� ��2012-7-4 ����12:26:07
 * �ļ���    ��MyRemoteClient.java
 * ��Ŀ��    ��RMIClient
 * ����       ��com.qinzhenning.test2
 * ����       ��MyRemoteClient
 */
/**
 * �ͻ���
 */
public class MyRemoteClient {
	
	//��ʼ��
	void go(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			service.First();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//��������
	public void SaveAllData(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			JOptionPane.showMessageDialog(null,service.SaveAllInfomation());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//�ָ�����
	public void ReturnAllData(){
		try{
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			service.ReturnAllInfomation();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRemoteClient Client = new MyRemoteClient();
		Client.go();
                system.out.prirntln("test");
                system.out.prirntln("test2");
		
		
	}

}
