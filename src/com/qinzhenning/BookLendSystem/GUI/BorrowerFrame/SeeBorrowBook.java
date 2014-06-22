/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * @author qinzhenning
 * 时间：2012-7-1下午1:49:03
 * 文件：SeeBorrowBook.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * 类  ：SeeBorrowBook
 */
/**
 * 查看已借图书 的界面
 */
public class SeeBorrowBook {
	private JPanel panel;
	private JButton button_returnBook,button_reborrowBook;
	private JLabel label;
	private static JTable table1;
	private JScrollPane scrollPane;
	private Object[][] tableData;
	private HaveBorrowBookTableModel model1;
	private Borrower borrower;
	private ArrayList<Book> borrowList;
	
	/**
	 * 构造函数-创建好面板
	 */
	public SeeBorrowBook(Borrower a){
		
		borrower = a;
		if(borrower != null)
		{
			borrowList = borrower.getHBB();
		}
//	}
//	
//	public void go(){
		panel = new JPanel();
		panel.setBounds(60, 105, 920, 560);
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		model1 = new HaveBorrowBookTableModel(borrowList);
		table1 = new JTable(model1);
		JScrollPane scrollPane=new JScrollPane(table1); 
		scrollPane.setBounds(0, 45, 800, 450);
		panel.add(scrollPane);
		
		
		label = new JLabel("已借图书表格");
		label.setFont(new Font("宋体",Font.BOLD,18));
		label.setBounds(320, 10, 200, 40);
		panel.add(label);
		
		button_returnBook = new JButton("归还图书");
		button_returnBook.addActionListener(new button_returnBook_ActionListener());
		button_reborrowBook = new JButton("续借图书");
		button_reborrowBook.addActionListener(new button_reborrowBook_ActionListener());
		button_returnBook.setBounds(240, 520, 90, 30);
		button_reborrowBook.setBounds(460, 520, 90, 30);
		panel.add(button_returnBook);
		panel.add(button_reborrowBook);
		
		
		
		
	}

	/**
	 * 获取面板
	 */
	public JPanel getPanel(){
		return panel;
	}
	
	/**
	 * 获取借阅书籍的表格
	 */
	public static JTable getTable(){
		return table1;
	}
	
	/**
	 * 归还图书 按钮的事件
	 */
	public class button_returnBook_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tableData = HaveBorrowBookTableModel.getData();
			int[] rows = table1.getSelectedRows();
			
			if(rows != null)
			{
				try{
					Book returnOne = Library.searchBook(tableData[rows[0]][0]);
					
					if(returnOne == null)
						JOptionPane.showMessageDialog(null, "对不起，没有对应的信息");
					else
					{
						BorrowerFrame.getBorrower().returnBook(returnOne);
						table1.setModel(new HaveBorrowBookTableModel(borrowList));
						BorrowBook.getTable().setModel(new BookTableModel1(Library.getBookList()));
					}
					
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 续借图书 按钮的事件
	 */
	public class button_reborrowBook_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tableData = HaveBorrowBookTableModel.getData();
			int[] rows = table1.getSelectedRows();
			
			if(rows != null)
			{
				try{
					Book reborrowOne = Library.searchBook(tableData[rows[0]][0]);
					
					BorrowerFrame.getBorrower().reBorrowBook(reborrowOne);
					
					table1.setModel(new HaveBorrowBookTableModel(borrowList));
					BorrowBook.getTable().setModel(new BookTableModel1(Library.getBookList()));
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "请选择一个表格");
				}
			}
		}
		
	}
}
