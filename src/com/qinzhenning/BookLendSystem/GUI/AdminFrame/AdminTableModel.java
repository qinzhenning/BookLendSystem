/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Administrator.AdministratorList;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;

/**
 * @author qinzhenning
 * 时间：2012-6-13下午6:59:06
 * 文件：AdminTableModel.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：AdminTableModel
 */
/**
 * 管理员 表格数据模版
 */
public class AdminTableModel extends AbstractTableModel{
	 final String [] columnNames= {"编号","姓名","性别","用户名","密码"};
	 static Object[][] data = {{"","","","",""},{"","","","",""}} ;
		
	 //构造函数-传入一个ArrayList
	 	public  AdminTableModel(ArrayList<Administrator> admin) {
		 data = new Object[30][5];
		 
		 for(int i = 0; i < 30;i ++)
			{
				data[i][0] = "";
				data[i][1] = "";
				data[i][2] = "";
				data[i][3] = "";
				data[i][4] = "";
			}
			if(admin != null)
			{
			if(admin.size() < 30)
			{
			for(int i =0;i < admin.size(); i ++)
			{
				data[i][0] = admin.get(i).getAdminNumber();
				data[i][1] = admin.get(i).getName();
				data[i][2] = admin.get(i).getSex();
				data[i][3] = admin.get(i).getUsername();
				data[i][4] = admin.get(i).getPassword();
			}
			}
			else
			{
				data = new String [admin.size()][5];
				for(int i =0;i < BorrowerList.getBorrowerList().size(); i ++)
				{
					data[i][0] = admin.get(i).getAdminNumber();
					data[i][1] = admin.get(i).getName();
					data[i][2] = admin.get(i).getSex();
					data[i][3] = admin.get(i).getUsername();
					data[i][4] = admin.get(i).getPassword();
				}
			}
			}
	 }
	
	 //构造函数-传入一个对象
	 //构造函数-传入一个duixi
	 	public  AdminTableModel(Administrator admin) {
		 if(admin != null)
		 {
			 data = new Object[1][5];
			 
				data[0][0] = admin.getAdminNumber();
				data[0][1] = admin.getName();
				data[0][2] = admin.getSex();
				data[0][3] = admin.getUsername();
				data[0][4] = admin.getPassword();
		 }
		 else
			 new AdminTableModel(AdministratorList.getAdminList());
	 }
	
	 	//设置某行是否可编辑
		public boolean isCellEditable(int row,int col) {
			if(col < 2) 
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	
	//设置某行某列数据
		//设置某行某列数据
		public void setValueAt(Object value,int row,int col) {
			data[row][col] = value;
		}
	
	//标识 列
		//标识 列
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
	
	//标识 行
		//标识 行
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

	//获取某行某列数据
		//获取某行某列数据
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			return data[row][col];
		}
	
	//标识 列
		//标识 行
		public String getColumnName(int col) {
			return columnNames[col];
		}
	
	//获取所有数据
		//获取所有数据
		public static Object[][] getData() {
			return data;
		}
}
