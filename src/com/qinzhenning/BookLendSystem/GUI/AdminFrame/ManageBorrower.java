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
/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午4:57:36
 * 文件：ManageBorrower.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：ManageBorrower
 */
/**
 * 管理借阅人面板
 */
 public class ManageBorrower  {
	private JPanel panel1;
	private JPanel panel2;
	JDialog dialog;
	private JButton button_addBorrower,button_deleteBorrower,button_searchBorrower,button_changeBorrower,button_seeAllBorrower;
	private JTextField  search;
	private static JTable table1;
	private static JTable table2; 
	private Object[][] tableData;
	private Object[][] tableData1;
	static BorrowerTableModel model ;
	static ListSelectionModel selection;
	 JScrollPane scrollPane,scrollPane1;
	 ArrayList<Borrower> list = BorrowerList.getBorrowerList();
	 
	 /**
	  * 构造方法-创建面板
	  */
	public ManageBorrower(){
	panel1 = new JPanel();
	panel1.setBounds(380, 100, 600, 560);
	panel1.setLayout(null);
	panel1.setBackground(Color.orange);
	
//	addBorrowerToTable(list);
	model = new BorrowerTableModel(list);
	table1 = new JTable(model);
	
//	table1.getSelectionModel().addListSelectionListener(new selectTableListener());
	table1.addMouseListener(new selectTable_Listener());
	JScrollPane scrollPane=new JScrollPane(table1); 
	scrollPane.setBounds(0, 35, 600, 480);
    panel1.add(scrollPane);
	
	panel2 = new JPanel();
	panel2.setLayout(null);
	TitledBorder title = new TitledBorder("已借图书列表");
	title.setTitleColor(Color.blue);
	title.setTitleJustification(4);
	title.setTitleFont(new Font("宋体",Font.BOLD,16));
	panel2.setBorder(title);
	panel2.setBounds(10, 135, 350, 520);
	
	
	button_addBorrower = new JButton("添加用户");
	button_deleteBorrower = new JButton("删除用户");
	button_changeBorrower = new JButton("修改用户");
	button_addBorrower.addActionListener(new button_addBorrower_ActionListener());
	button_deleteBorrower.addActionListener(new button_deleteBorrower_ActionListener());
	button_changeBorrower.addActionListener(new button_changeBorrower_ActionListener());
	button_addBorrower.setBounds(110, 520, 90, 30);
	button_deleteBorrower.setBounds(250, 520, 90, 30);
	button_changeBorrower.setBounds(390, 520, 90, 30);
	panel1.add(button_addBorrower);
	panel1.add(button_deleteBorrower);
	panel1.add(button_changeBorrower);
	
	
	search = new JTextField("请输入要查找用户的编号",50);
	search.addMouseListener(new searchText_MouseListener());
	search.addKeyListener(new searchText_MouseListener());
	button_searchBorrower = new JButton("查找");
	button_searchBorrower.addActionListener(new button_searchBorrower_Listener());
	button_seeAllBorrower = new JButton("列举借阅人");
	button_seeAllBorrower.addActionListener(new button_seeAllBorrower_ActionListener());
	search.setBounds(200,3,300,28);
	button_searchBorrower.setBounds(520, 3, 73, 28);
	button_seeAllBorrower.setBounds(0,0,120,28);
	panel1.add(button_searchBorrower);
	panel1.add(button_seeAllBorrower);
	panel1.add(search);
	
	
	}
	
	/**
	  * 返回面板
	  */
	public JPanel getPanel(int i ){
		if(i == 1)
			return panel1;
		else 
			return panel2;
			
	}

	/**
	 *添加用户按钮的监听
	 */
	public class button_addBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			AddNewUserDialog addUserDialog = new AddNewUserDialog("添加借阅者");
			addUserDialog.go();
			addUserDialog.setVisible(true);
		}
		
	}
	
	/**
	 * 删除用户按钮的监听
	 */
	public class button_deleteBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		tableData = BorrowerTableModel.getData();
		int[] rows=table1.getSelectedRows();
		if(rows != null)
		{
			try {
				Borrower deleteBorrower = BorrowerList.findBorrower(tableData[rows[0]][0]);			
				if(deleteBorrower == null)
					JOptionPane.showMessageDialog(null, "Sorry,No information!");
				else
				{
					if((deleteBorrower.getHBB() == null) || (deleteBorrower.getHBB().size() == 0))
					{
						BorrowerList.deletBorrower(deleteBorrower);
						JOptionPane.showMessageDialog(null, "Delete Seccessfully!");
					}
					else
						JOptionPane.showMessageDialog(null, "该借阅者有书未归还，不能删除，请归还后再删除!");
				}
				ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(BorrowerList.getBorrowerList()));
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "请选择一个表格!");
			}
		}
		}
		
	}
	
	/**
	 *查找文本域的监听
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
				search.setText("请输入要查找用户的编号");
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
				/*以编程方式执行“单击”
				 * 此方法的效果等同于用户按下并随后释放按钮。 
				 */
				button_searchBorrower.doClick();
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
	 *修改按钮的监听
	 */
	public class button_changeBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tableData = BorrowerTableModel.getData();
			int[] rows=table1.getSelectedRows();
			if(rows != null)
			{
				
			try {
			Borrower changeBorrower = BorrowerList.findBorrower(tableData[rows[0]][0]);
			if(changeBorrower != null)
			{
			ChangeBorrowerDialog dialog = new ChangeBorrowerDialog(AdminFrame.getFrame(),changeBorrower,"修改借阅者");
			dialog.go();
			dialog.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry,No information!");
			}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "请选择一个表格!");
			}
			}
		}
		
	}
	
	/**
	 * 鼠标选择表格的监听事件	
	 */
	public class selectTable_Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int[] rows=table1.getSelectedRows();
	   	  	int[] columns=table1.getSelectedColumns();
	   	  	tableData = BorrowerTableModel.getData();
	 
	   	  	if((rows != null )&& (tableData != null)) {
	   	  	for(int i  = 0; i < BorrowerList.getBorrowerList().size(); i ++)
	   	  	{
	   	  		if(tableData[rows[0]][0].equals((BorrowerList.getBorrowerList()).get(i).getBorrowerNumber()))
	   	  			if(BorrowerList.getBorrowerList().get(i).getHBB().size() !=0)
	   	  			{
	   	  			ArrayList<Book> a = BorrowerList.getBorrowerList().get(i).getHBB();
	   	  			tableData1 = new String[a.size()][4];
	   	  		
	   	  			for(int j = 0 ;j < a.size(); j ++)
	   	  			{
	   	  				tableData1[j][0] = a.get(j).getbookName();
	   	  				tableData1[j][1] = a.get(j).getISBN();
	   	  				tableData1[j][2] = a.get(j).getpublicHome();
	   	  			}
	   	  		
	   	  			}
	   	  			
	   	  	}
	   
	   	  	
	   	  	if(tableData1 != null)
	   	  	{
	   	  		
	   		String[] columnTitle1 =new String[]{"书名","编号","出版社"};
	   		table2 = new JTable(tableData1,columnTitle1);
	   		scrollPane1=new JScrollPane(table2); 
	   		scrollPane1.setBounds(1,17,349,503);
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
	 * 查找按钮的监听	
	 */
	public class button_searchBorrower_Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			new SearchReader(AdminFrame.getFrame());
				Borrower searchOne = BorrowerList.findBorrower(search.getText());
				if(searchOne != null)
					ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(searchOne));
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry,No information!");
					ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(BorrowerList.getBorrowerList()));
				}
		}

		
	}

	/**
	 *列举借阅人的监听 
	 */
	class button_seeAllBorrower_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(BorrowerList.getBorrowerList()));
		}
		
	}

	/**
	 * 获取借阅人数据模版
	 */
	public static BorrowerTableModel getModel() {
		return model;
	}
	
	/**
	 * 获取借阅人表格
	 */
	public static JTable getTabel(int i) {
		if(i == 1)
			return table1;
		else 
			return table2;
	}
}
