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
 * ʱ�䣺2012-6-13����6:59:06
 * �ļ���AdminTableModel.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��AdminTableModel
 */
/**
 * ����Ա �������ģ��
 */
public class AdminTableModel extends AbstractTableModel{
	 final String [] columnNames= {"���","����","�Ա�","�û���","����"};
	 static Object[][] data = {{"","","","",""},{"","","","",""}} ;
		
	 //���캯��-����һ��ArrayList
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
	
	 //���캯��-����һ������
	 //���캯��-����һ��duixi
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
	
	 	//����ĳ���Ƿ�ɱ༭
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
	
	//����ĳ��ĳ������
		//����ĳ��ĳ������
		public void setValueAt(Object value,int row,int col) {
			data[row][col] = value;
		}
	
	//��ʶ ��
		//��ʶ ��
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
	
	//��ʶ ��
		//��ʶ ��
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

	//��ȡĳ��ĳ������
		//��ȡĳ��ĳ������
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			return data[row][col];
		}
	
	//��ʶ ��
		//��ʶ ��
		public String getColumnName(int col) {
			return columnNames[col];
		}
	
	//��ȡ��������
		//��ȡ��������
		public static Object[][] getData() {
			return data;
		}
}
