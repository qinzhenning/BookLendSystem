package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Administrator.AdministratorList;
import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.button_addBorrower_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.button_changeBorrower_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.button_deleteBorrower_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.button_searchBorrower_Listener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.button_seeAllBorrower_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.searchText_MouseListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageBorrower.selectTable_Listener;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:09:45
 * �ļ���ManageAdmin.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��ManageAdmin
 */
/**
 * �������Ա ����
 */
public class ManageAdmin {
	private JButton button_addAdmin,button_changeAdmin,button_deleteAdmin,button_searchAdmin,button_seeAllAdmin;
	private  JPanel panel;
	private JTextField  field_search;
	private static JTable table1;
	private Object[][] tableData1;
	private Object[][] tableData2;
	private static AdminTableModel model ;
	private JScrollPane scrollPane;
	private ArrayList<Administrator> list = AdministratorList.getAdminList();
	
	
	/**
	 *���췽�� 
	 */
	public ManageAdmin() {

	
		panel = new JPanel();
		panel.setBounds(150, 105, 600, 560);
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		

		model = new AdminTableModel(list);
		table1 = new JTable(model);
		scrollPane=new JScrollPane(table1); 
		scrollPane.setBounds(0, 35, 600, 480);
		panel.add(scrollPane);
		
		
		
		
		button_addAdmin = new JButton("��ӹ���Ա");
		button_changeAdmin = new JButton("�޸Ĺ���Ա");
		button_deleteAdmin = new JButton("ɾ������Ա");
		button_addAdmin.addActionListener(new button_addAdmin_ActionListener());
		button_deleteAdmin.addActionListener(new button_deleteAdmin_ActionListener());
	    	button_changeAdmin.addActionListener(new button_changeAdmin_ActionListener());
		button_addAdmin.setBounds(110, 520, 120, 30);
		button_deleteAdmin.setBounds(250, 520, 120, 30);
		button_changeAdmin.setBounds(390, 520, 120, 30);
		panel.add(button_changeAdmin);
		panel.add(button_addAdmin);
		panel.add(button_deleteAdmin);
		
		
		field_search = new JTextField("������Ҫ���ҹ���Ա�ı��",50);
		field_search.addMouseListener(new searchText_MouseListener());
		field_search.addKeyListener(new searchText_MouseListener());
		button_searchAdmin = new JButton("����");
		button_searchAdmin.addActionListener(new button_searchAdmin_ActionListener());
		button_seeAllAdmin = new JButton("�оٹ���Ա");
		button_seeAllAdmin.addActionListener(new button_seeAllAdmin_ActionListener());
		field_search.setBounds(200,3,300,28);
		button_searchAdmin.setBounds(520, 3, 73, 28);
		button_seeAllAdmin.setBounds(0,0,120,28);
		panel.add(button_searchAdmin);
		panel.add(button_seeAllAdmin);
		panel.add(field_search);
	}
	
	/**
	  * ��ȡ���
	  */
	public  JPanel getPanel() {
		return panel;
	}
	
	/**
	  * ��ȡ���
	  */
	public static JTable getTabel(){
		return table1;
	}
	
	/**
	 *��ӹ���Ա��ť�¼� 
	 */
	public class button_addAdmin_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			AddAdminDialog adAdmin = new AddAdminDialog("��ӹ���Ա");
			adAdmin.go();
			adAdmin.setVisible(true);
		}
		
	}
	
	/**
	 *�оٹ���Ա��ť�¼� 
	 */
	public class button_seeAllAdmin_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			table1.setModel(new AdminTableModel(list));
		}
		
	}
	
	/**
	 * ɾ������Ա��ť�¼�
	 */
	public class button_deleteAdmin_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tableData1 = AdminTableModel.getData();
			int rows[] = table1.getSelectedRows();
			
			if(rows != null)
			{
				try{
					Administrator deleteAdmin = AdministratorList.findAdministrator(tableData1[rows[0]][0]);
					if(deleteAdmin == null)
						JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
					else
					{
						if(deleteAdmin == AdminFrame.getAdmin())
							JOptionPane.showMessageDialog(null, "�Բ��������ܰ��Լ�ɾ����Ŷ!");
						else
						{	
							AdministratorList.deleteAdmin(deleteAdmin);
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���Ŷ!");
						}
					}
					table1.setModel(new AdminTableModel(list));
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "��ѡ��һ�����!");
				}
			}
			
		}
		
	}
	
	/**
	  * �޸Ĺ���Ա��ť�¼�
	  */
	public class button_changeAdmin_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			tableData1 = AdminTableModel.getData();
			int rows[] = table1.getSelectedRows();
			
			if(rows != null)
			{
				try{
					Administrator changeAdmin = AdministratorList.findAdministrator(tableData1[rows[0]][0]);
					
					if(changeAdmin == null)
						JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
					else 
					{
						ChangeAdminDialog dialog = new ChangeAdminDialog("�޸Ĺ���Ա",changeAdmin);
						dialog.go();
						dialog.setVisible(true);
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "��ѡ��һ�����!");
				}
			}
		
		}
	}
	
	/**
	  * ��������Ա ��ť�¼�
	  */
	public class button_searchAdmin_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Administrator searchone = AdministratorList.findAdministrator(field_search.getText());
			if(searchone != null)
				table1.setModel(new AdminTableModel(searchone));
			else
			{
				JOptionPane.showMessageDialog(null, "�Բ���û����Ϣ!");
				table1.setModel(new AdminTableModel(list));
			}
			
		}
		
	}
	
	/**
	 *�����ı���ļ���
	 */
	public class searchText_MouseListener implements MouseListener,KeyListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
				field_search.setText("");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			if(field_search.getText().equals(""))
				field_search.setText("������Ҫ����ͼ��ı��");
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
				button_searchAdmin.doClick();
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
	
	

	
}
