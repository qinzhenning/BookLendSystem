package com.qinzhenning.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   ������
 * �������� ��2012-7-4 ����12:15:36
 * �ļ���    ��MyRemote.java
 * ��Ŀ��    ��RMITest
 * ����       ��com.qinzhenning.test1
 * ����       ��MyRemote
 */
/**
 * ��������-�ӿ���
 */
public interface MyRemote extends Remote{
	//��ʼ���ӿ�
	public void First() throws RemoteException;
	//������Ϣ�ӿ�
	public String SaveAllInfomation() throws RemoteException;
	//�ָ���Ϣ�ӿ�
	public void ReturnAllInfomation() throws RemoteException;
	
}


