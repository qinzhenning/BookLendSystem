package com.qinzhenning.BookLendSystem.GUI.AdminFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AdminFrame.Label_Book_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AdminFrame.Label_Borrower_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AdminFrame.Label_Admin_ActionListener;

import com.qinzhenning.BookLendSystem.GUI.LoginFrame.LoginFrame;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����4:59:29
 * �ļ���ManageBook.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��ManageBook
 */
/**
 * ����ͼ��  ����
 */
 public class ManageBook  {
	
	private JPanel panel1;	//ͼ�������
	private JPanel panel2;	//ͼ���������Ϣ���
	private JButton button_addBook,button_deleteBook,button_searchBook,button_changeBook,button_seeAllBook;
	private JTextField  search;
	private static JTable table1;
	private static JTable table2 = null; 
	private Object[][] tableData;
	private Object[][] tableData1;
	static BookTableModel model ;
	static ListSelectionModel selection;
	 JScrollPane scrollPane,scrollPane1 = null;
	 ArrayList<Book> list = Library.getBookList();

	 /**
	  * ���췽��-�������
	  */
	public ManageBook(){
	panel1 = new JPanel();
	panel1.setBounds(290, 100, 700, 560);
	panel1.setLayout(null);
	panel1.setBackground(Color.ORANGE);
	

	model = new BookTableModel(list);
	table1 = new JTable(model);
	table1.addMouseListener(new selectTable_Listener());
	JScrollPane scrollPane=new JScrollPane(table1); 
	scrollPane.setBounds(0, 35, 700, 480);
	panel1.add(scrollPane);
	
	panel2 = new JPanel();
	panel2.setLayout(null);
	TitledBorder title = new TitledBorder("ͼ���������Ϣ�б�");
	title.setTitleColor(Color.blue);
	title.setTitleJustification(4);
	title.setTitleFont(new Font("����",Font.BOLD,16));
	panel2.setBorder(title);
	panel2.setBounds(10, 135, 250, 520);
	
	
	button_addBook = new JButton("���ͼ��");
	button_deleteBook = new JButton("ɾ��ͼ��");
	button_changeBook = new JButton("�޸�ͼ��");
	button_addBook.addActionListener(new button_addBorrower_ActionListener());
	button_deleteBook.addActionListener(new button_deleteBorrower_ActionListener());
	button_changeBook.addActionListener(new button_changeBorrower_ActionListener());
	button_addBook.setBounds(130, 520, 90, 30);
	button_deleteBook.setBounds(270, 520, 90, 30);
	button_changeBook.setBounds(410, 520, 90, 30);
	panel1.add(button_addBook);
	panel1.add(button_deleteBook);
	panel1.add(button_changeBook);
	
	
	search = new JTextField("������Ҫ����ͼ��ı��",50);
	search.addMouseListener(new searchText_MouseListener());
	search.addKeyListener(new searchText_MouseListener());
	button_searchBook = new JButton("����");
	button_seeAllBook = new JButton("�о�ͼ��");
	button_seeAllBook.addActionListener(new button_seeAllBook_ActionListener());
	button_searchBook.addActionListener(new button_searchBorrower_Listener());
	search.setBounds(300,3,300,28);
	button_searchBook.setBounds(620, 3, 73, 28);
	button_seeAllBook.setBounds(0,0,100,28);
	panel1.add(button_searchBook);
	panel1.add(search);
	panel1.add(button_seeAllBook);
	
	
	}
	
	/**
	 * ��ȡ���
	 */
	public JPanel getPanel(int i ){
		if(i == 1)
			return panel1;
		else 
			return panel2;
			
	}

	/**
	 *���ͼ�鰴ť�ļ���
	 */
	public class button_addBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AddNewBookDialog addUserDialog = new AddNewBookDialog("���ͼ��");
			addUserDialog.go();
			addUserDialog.setVisible(true);
		}
		
	}
	
	/**
	 * ɾ��ͼ�鰴ť�ļ���
	 */
	public class button_deleteBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		tableData = BookTableModel.getData();
		int[] rows=table1.getSelectedRows();
		if(rows != null)
		{
			try {
				Book deleteBook = Library.searchBook(tableData[rows[0]][0]);
		
				if(deleteBook == null)
					JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
				else
				{
					if(deleteBook.getborrowTime() == null)
					{
						Library.deleteBookObject(deleteBook);
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�Ŷ^_^!");
					}
					else
						JOptionPane.showMessageDialog(null, "�����ѱ����ģ��޷�ɾ������黹����ɾ��!");
				}
				ManageBook.getTabel(1).setModel(new BookTableModel(Library.getBookList()));
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "��ѡ��һ�����!");
			}
		}
		}
		
	}
	
	/**
	 *�����ı���ļ���
	 */
	public class searchText_MouseListener implements MouseListener,KeyListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
				search.setText("");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if(search.getText().equals(""))
				search.setText("������Ҫ����ͼ��ı��");
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == 10)
				/*�Ա�̷�ʽִ�С�������
				 * �˷�����Ч����ͬ���û����²�����ͷŰ�ť�� 
				 */
				button_searchBook.doClick();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
	/**
	 *�޸İ�ť�ļ���
	 */
	public class button_changeBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tableData = BookTableModel.getData();
			int[] rows=table1.getSelectedRows();
			if(rows != null)
			{
				try {
					Book changeBook = Library.searchBook(tableData[rows[0]][0]);
					if(changeBook != null)
					{
						ChangeBookDialog dialog = new ChangeBookDialog("�޸Ľ�����",changeBook);
						dialog.go();
						dialog.setVisible(true);
					}
					else { 
						JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
					}
				}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "��ѡ��һ�����!");
				}
			}
		}
		
	}
	
	/**
	 * ���ѡ����ļ����¼�	
	 */
	public class selectTable_Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int[] rows=table1.getSelectedRows();
	   	  	int[] columns=table1.getSelectedColumns();
	   	  	tableData = BookTableModel.getData();
	 
	   	  	if((rows != null )&& (tableData != null)) {
	   	  	for(int i  = 0; i < Library.getBookList().size(); i ++)
	   	  	{
	   	  		if(tableData[rows[0]][0].equals(Library.getBookList().get(i).getISBN()))
	   	  		{
	   	  			if((Library.getBookList().get(i).getreaderNumber() != null))
	   	  			{
	   	  				Borrower a = BorrowerList.findBorrower(Library.getBookList().get(i).getreaderNumber());
	  					tableData1 = new String[1][4];
 	  					tableData1[0][0] = a.getBorrowerName();
 	  					tableData1[0][1] = a.getBorrowerNumber();
	   	  				tableData1[0][2] = a.getIdentity();
	   	  			}
	   	  			}
	   	  			
	   	  	}
	   
	   	  	
	   	  	if(tableData1 != null)
	   	  	{
	   	  		
	   		String[] columnTitle1 =new String[]{"������","���","���"};
	   		table2 = new JTable(tableData1,columnTitle1);
	   		scrollPane1=new JScrollPane(table2); 
	   		scrollPane1.setBounds(3,17,246,503);
	   		panel2.add(scrollPane1);
	   		panel2.repaint(); 
	   		tableData1 = null;
	   		
	   		
	   	  	}
	   	  	else
	   	  	{
	   	  		
	   	  		if(scrollPane1 != null)
	   	  		{
	   	  		panel2.removeAll();
	   	  		}
	   	  		panel2.repaint();
	   	  		tableData1 = null;
	   	  		
	   	  	}
	   	  	}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		
	}
	
	/**
	 * ���Ұ�ť�ļ���	
	 */
	public class button_searchBorrower_Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			new SearchReader(AdminFrame.getFrame());
				Book searchOne = Library.searchBook(search.getText());
				if(searchOne != null)
					ManageBook.getTabel(1).setModel(new BookTableModel(searchOne));
				else
				{
					JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
					ManageBook.getTabel(1).setModel(new BookTableModel(Library.getBookList()));
				}
		}

		
	}

	/**
	 *�о�ͼ�鰴ť���¼� 
	 */
	class button_seeAllBook_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ManageBook.getTabel(1).setModel(new BookTableModel(Library.getBookList()));
		}
		
	}

	/**
	 * ��ȡģ��
	 */
	public static BookTableModel getModel() {
		return model;
	}
	
	/**
	 *��ȡ��� 
	 */
	public static JTable getTabel(int i) {
		if(i == 1)
			return table1;
		else 
			return table2;
	}
}
