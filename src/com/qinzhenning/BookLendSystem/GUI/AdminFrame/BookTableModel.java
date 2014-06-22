package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
import com.qinzhenning.BookLendSystem.info.Time;
/**
 * 
 * @author Administrator
 * ʱ�䣺2012-7-15����4:43:22
 * �ļ���BookTableModel.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��BookTableModel
 */
public class BookTableModel extends AbstractTableModel{
	 final String [] columnNames= {"���","����","����","������","���",
			 "״̬","����ʱ��","Ԥ�ƹ黹ʱ��","�Ƿ��䱾","�Ƿ�����"};
		static Object[][] data = {{"","","","","","","","","",""},{"","","","","","","","","",""}} ;

		/**
		 * ���캯��-����һ��ArryaList
		 */
		public BookTableModel(ArrayList<Book> newList) {
			
			data = new Object[30][10];
			
			for(int i = 0; i < 30;i ++)
			{
				data[i][0] = "";
				data[i][1] = "";
				data[i][2] = "";
				data[i][3] = "";
				data[i][4] = "";
				data[i][5] = "";
				data[i][6] = "";
				data[i][7] = "";
				data[i][8] = "";
				data[i][9] = "";
			}
			if(newList != null)
			{
			if(newList.size() < 30)
			{
			for(int i =0;i < newList.size(); i ++)
			{
				data[i][0] = newList.get(i).getISBN();
				data[i][1] = newList.get(i).getbookName();
				data[i][2] = newList.get(i).getbookAuthor();
				data[i][3] = newList.get(i).getpublicHome();
				data[i][4] = newList.get(i).getbookYear();
				if(newList.get(i).getborrowTime() != null )
					data[i][5] = "�ѽ�";
				else
					data[i][5] = "δ��";
				if(newList.get(i).getborrowTime() != null)
					data[i][6] = Time.getTimeString(newList.get(i).getborrowTime());
				else
					data[i][6] = "";
				if(newList.get(i).getshouldReturnTime() != null)
					data[i][7] = Time.getTimeString(newList.get(i).getshouldReturnTime());
				else
					data[i][7] = "";
				if(newList.get(i).getisSpecialBook())
					data[i][8] = "��";
				else
					data[i][8] = "��";
				if(newList.get(i).getisAsk())
					data[i][9] = "��";
				else
					data[i][9] = "��";
					}
			}
			else
			{
				data = new String [newList.size()][6];
				for(int i =0;i < BorrowerList.getBorrowerList().size(); i ++)
				{
					data[i][0] = newList.get(i).getISBN();
					data[i][1] = newList.get(i).getbookName();
					data[i][2] = newList.get(i).getbookAuthor();
					data[i][3] = newList.get(i).getpublicHome();
					if(newList.get(i).getborrowTime() != null )
						data[i][5] = "�ѽ�";
					else
						data[i][5] = "δ��";
					if(newList.get(i).getborrowTime() != null)
						data[i][6] = Time.getTimeString(newList.get(i).getborrowTime());
					else
						data[i][6] = "";
					if(newList.get(i).getshouldReturnTime() != null)
						data[i][7] = Time.getTimeString(newList.get(i).getshouldReturnTime());
					else
						data[i][7] = "";
					if(newList.get(i).getisSpecialBook())
						data[i][8] = "��";
					else
						data[i][8] = "��";
					if(newList.get(i).getisAsk())
						data[i][9] = "��";
					else
						data[i][9] = "��";
				}
			}
			}
		}

		/**
		 * ���캯��-����һ������
		 */
		public BookTableModel(Book book) {
			
			if(book != null )
			{
				data = new Object[1][10];
		
				data[0][0] =book.getISBN();
				data[0][1] = book.getbookName();
				data[0][2] = book.getbookAuthor();
				data[0][3] = book.getpublicHome();
				data[0][4] = book.getbookYear();
				if(book.getborrowTime() != null )
					data[0][5] = "�ѽ�";
				else
					data[0][5] = "δ��";
				if(book.getborrowTime() != null)
					data[0][6] = Time.getTimeString(book.getborrowTime());
				else
					data[0][6] = "";
				if(book.getshouldReturnTime() != null)
					data[0][7] = Time.getTimeString(book.getshouldReturnTime());
				else
					data[0][7] = "";
				if(book.getisSpecialBook())
					data[0][8] = "��";
				else
					data[0][8] = "��";
				if(book.getisAsk())
					data[0][9] = "��";
				else
					data[0][9] = "��";
	 		
			}
			else
			{
				new BookTableModel(Library.getBookList());
			}
			
		}

		/**
		 * ����ĳ���Ƿ�ɱ༭
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
		 * ����ĳ��ĳ������
		 */
		public void setValueAt(Object value,int row,int col) {
			data[row][col] = value;
		}

		/**
		 * ��� ��
		 */
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}
		
		/**
		 * ��� ��
		 */
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		/**
		 * ��ȡĳ��ĳ������
		 */
		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			return data[row][col];
		}
		
		/**
		 * ��ȡĳ������
		 */
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
		/**
		 * ��ȡ��������
		 */
		public static Object[][] getData() {
			return data;
		}
		
}
