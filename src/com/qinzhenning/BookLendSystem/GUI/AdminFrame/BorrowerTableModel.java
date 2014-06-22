package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;

/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午5:01:13
 * 文件：BorrowerTableModel.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：BorrowerTableModel
 */
/**
 * 借阅人数据模版
 */
public class BorrowerTableModel  extends AbstractTableModel{
	 final String [] columnNames= {"编号","姓名","性别","身份","用户名","密码"};
	static Object[][] data = {{"","","","","",""},{"","","","","",""}} ;

	/**
	  * 构造方法-传入一个ArrarList
	  */
	public BorrowerTableModel(ArrayList<Borrower> newList) {
		
		data = new Object[30][6];
		
		for(int i = 0; i < 30;i ++)
		{
			data[i][0] = "";
			data[i][1] = "";
			data[i][2] = "";
			data[i][3] = "";
			data[i][4] = "";
			data[i][5] = "";
		}
		if(newList != null)
		{
		if(newList.size() < 30)
		{
		for(int i =0;i < newList.size(); i ++)
		{
			data[i][0] = newList.get(i).getBorrowerNumber();
			data[i][1] = newList.get(i).getBorrowerName();
			data[i][2] = newList.get(i).getSex();
			data[i][3] = newList.get(i).getIdentity();
			data[i][4] = newList.get(i).getUserName();
			data[i][5] = newList.get(i).getPassword();
		}
		}
		else
		{
			data = new String [newList.size()][6];
			for(int i =0;i < BorrowerList.getBorrowerList().size(); i ++)
			{
				data[i][0] = newList.get(i).getBorrowerNumber();
				data[i][1] = newList.get(i).getBorrowerName();
				data[i][2] = newList.get(i).getSex();
				data[i][3] = newList.get(i).getIdentity();
				data[i][4] = newList.get(i).getUserName();
				data[i][5] = newList.get(i).getPassword();
			}
		}
		}
	}

	/**
	  * 构造方法- 传入一个对象
	  */
	public BorrowerTableModel(Borrower borrower) {
		
		if(borrower != null )
		{
			data = new Object[1][6];
	
			data[0][0] = borrower.getBorrowerNumber();
			data[0][1] = borrower.getBorrowerName();
			data[0][2] = borrower.getSex();
			data[0][3] = borrower.getIdentity();
			data[0][4] = borrower.getUserName();
			data[0][5] = borrower.getPassword();
 		
		}
		else
		{
			
			new BorrowerTableModel(BorrowerList.getBorrowerList());
		}
		
	}

	/**
	  * 设置数据-传入ArrayList
	  */
	public   void setData(ArrayList<Borrower>  list) {
		data = new Object[list.size()][6];
		for(int i = 0; i < list.size();i ++) {
			data[i][0] = list.get(i).getBorrowerNumber();
			data[i][1] = list.get(i).getBorrowerName();
			data[i][2] = list.get(i).getSex();
			data[i][3] = list.get(i).getIdentity();
			data[i][4] = list.get(i).getUserName();
			data[i][5] = list.get(i).getPassword();
		}
		
	}
	
	/**
	  * 设置某行是否可编辑
	  */
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
	
	/**
	  * 设置某行某列数据
	  */
	public void setValueAt(Object value,int row,int col) {
		data[row][col] = value;
	}

	/**
	  * 标记 列
	  */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	/**
	  * 标记 行
	  */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	/**
	  *获取某行某列数据 
	  */
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}
	
	/**
	  * 获取列名
	  */
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	/**
	  * 获取所有数据
	  */
	public static Object[][] getData() {
		return data;
	}
	

}
