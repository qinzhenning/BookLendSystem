/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBook.selectTable_Listener;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * @author qinzhenning
 * 时间：2012-6-29上午1:06:42
 * 文件：BorrowBook.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * 类  ：BorrowBook
 */
/**
 * 借阅图书 界面
 */
public class BorrowBook {
	private JButton button_seeAllBook,button_searchBookType,button_searchISBN,button_borrowBook;
	private JTextField field_searchISBN;
	private static JTable table;
	private JScrollPane scrollPane;
	private Object[][] tableData;
	private BookTableModel1 model;
	private ArrayList<Book> list =  Library.getBookList();
	private JPanel panel;
	

	/**
	 * 构造方法-主方法
	 */
	public  BorrowBook(){
		panel = new JPanel();
		panel.setBounds(60, 105, 920, 560);
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		model = new BookTableModel1(list);
		table = new JTable(model);
//		table.addMouseListener(new selectTable_Listener());
		JScrollPane scrollPane=new JScrollPane(table); 
		scrollPane.setBounds(0, 55, 800, 450);
		panel.add(scrollPane);
		
		field_searchISBN = new JTextField("请输入图书的编号");
		field_searchISBN.addMouseListener(new field_searchISBN_Listener());
		field_searchISBN.addKeyListener(new field_searchISBN_Listener());
		field_searchISBN.setBounds(500, 22, 200, 30);
		panel.add(field_searchISBN);
		
		button_seeAllBook = new JButton("所有图书");
		button_seeAllBook.addActionListener(new button_seeAllBook_ActionListener());
		button_searchBookType = new JButton("查找图书种类");
		button_searchBookType.addActionListener(new button_searchBookType_ActionListener());
		button_searchISBN = new JButton("便捷搜索");
		button_searchISBN.addActionListener(new button_searchISBN_ActionListener());
		button_borrowBook = new JButton("借阅图书");
		button_borrowBook.addActionListener(new button_borrowBook_ActionListener());
		button_searchISBN.setBounds(710, 22, 90, 30);
		button_seeAllBook.setBounds(0, 0, 90, 30);
		button_borrowBook.setBounds(820, 280, 90, 30);
		button_searchBookType.setBounds(320, 520, 140, 30);
		panel.add(button_seeAllBook);
		panel.add(button_searchISBN);
		panel.add(button_borrowBook);
		panel.add(button_searchBookType);
		
	}
	
	/**
	 * 获取表格
	 */
	public static JTable getTable(){
		return table;
	}

	/**
	 * 获取面板
	 */
	public JPanel getPanel(){
		return panel;
	}

	/**
	 * 列举图书 按钮事件
	 */
	public class button_seeAllBook_ActionListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			table.setModel(new BookTableModel1(list));
		}
		
	}

	/**
	 * 搜索图书种类 按钮事件
	 */
	public class button_searchBookType_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SearchBookTypeDialog dialog = new SearchBookTypeDialog("查询图书种类",table);
			dialog.go();
			dialog.setVisible(true);
		}
		
	}

	/**
	 * 快捷搜索 按钮事件
	 */
	public class button_searchISBN_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Book searchBook = Library.searchBook(field_searchISBN.getText());
			if(searchBook != null)
			{
				table.setModel(new BookTableModel1(searchBook));
			}
			else{
				JOptionPane.showMessageDialog(null, "对不起，没有信息!");
				table.setModel(new BookTableModel1(list));
			}
		}
		
	}
	
	/**
	 * 借阅图书 按钮事件
	 */
	public class button_borrowBook_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tableData = BookTableModel1.getData();
			int[] rows = table.getSelectedRows();
			
			if(rows != null)
			{
				try{
					Book borrowOne = Library.searchBook(tableData[rows[0]][0]);
					
					if(borrowOne == null)
						JOptionPane.showMessageDialog(null, "对不起，没有信息!");
					else
					{
						BorrowerFrame.getBorrower().borrowBook(borrowOne);
						table.setModel(new BookTableModel1(list));
						SeeBorrowBook.getTable().setModel(new HaveBorrowBookTableModel(BorrowerFrame.getBorrower().getHBB()));
					}
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "请选择一个表格!");
			}
			}
		}	
	}

	/**
	 * 查找图书文本域 事件
	 */
	public class field_searchISBN_Listener implements MouseListener,KeyListener{


		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == 10)
				/*以编程方式执行“单击”
				 * 此方法的效果等同于用户按下并随后释放按钮。 
				 */
				button_searchISBN.doClick();
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			field_searchISBN.setText("");
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(field_searchISBN.getText().equals(""))
				field_searchISBN.setText("请输入要查找图书的编号");
		}

	
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	

		
	}
}
