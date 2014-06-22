package com.qinzhenning.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   覃臻宁
 * 创建日期 ：2012-7-4 上午12:15:36
 * 文件名    ：MyRemote.java
 * 项目名    ：RMITest
 * 包名       ：com.qinzhenning.test1
 * 类名       ：MyRemote
 */
/**
 * 服务器端-接口类
 */
public interface MyRemote extends Remote{
	//初始化接口
	public void First() throws RemoteException;
	//保存信息接口
	public String SaveAllInfomation() throws RemoteException;
	//恢复信息接口
	public void ReturnAllInfomation() throws RemoteException;
	
}


