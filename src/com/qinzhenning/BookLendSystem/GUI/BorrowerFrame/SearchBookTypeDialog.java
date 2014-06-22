/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;


import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;


/**
 * @author administrator
 * ʱ�䣺2012-7-3����12:09:02
 * �ļ���SeachBookTypeDialog.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * ��  ��SeachBookTypeDialog
 */
/**
 * ����ͼ������ �Ի���
 */
public class SearchBookTypeDialog extends JDialog {
	private JLabel label_ISBN,label_bookName,label_bookAuthor,label_publicHome,label_bookYear,label_isSpecial;
	private JTextField field_ISBN,field_bookName,field_bookAuthor,field_publicHome,field_bookYear;
	private JRadioButton Rbutton1,Rbutton2;
	private ButtonGroup buttonGroup;
	private JButton button1,button2;
	private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
	private Insets inset;
	private JPanel panel;
	private JTable table;
	
	/**
	 * ���캯��-���ñ���ʹ��������
	 */
	public SearchBookTypeDialog(String title,JTable table) {
		setTitle(title);
		this.table = table;
	}
	
	/**
	 * ������
	 */
	public void go() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridBag = new GridBagLayout();
		Container dialogPane = getContentPane();
		dialogPane.setLayout(gridBag);
		
		
		label_ISBN = new JLabel("��� :");
		   /**
		    * ��һ�е�һ��
		    */
		gridx=0;
	   	gridy=0;
	   	     
	   	    gridwidth=1; //  ռһ���������   
	   	    gridheight=1;	//ռһ������߶�
	   	    /**
	   	     * �����ڱ仯ʱ������仯����
	   	     */
	   	    weightx=1;
	   	    weighty=1;
	   	    anchor=GridBagConstraints.CENTER;
	   	    fill=GridBagConstraints.HORIZONTAL;
	   	    inset=new Insets(0,0,0,0);
	   	    /**
	   	     * ��Ĭ�ϳ��ȵĻ����ϼ���0������
	   	     */
	   	    ipadx=0;
	   	    /**
	   	     * ��Ĭ�ϸ߶ȵĻ����ϼ���0������
	   	     */
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_ISBN,c);
	   	    dialogPane.add(label_ISBN);
	   	    
	   	    label_bookName= new JLabel("���� :");
	   	    gridx=0;
	   	    gridy=1;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookName,c);
	   	    dialogPane.add(label_bookName);
	   	    
	   	    label_bookAuthor= new JLabel("���� :");
	   	    gridx=0;
	   	    gridy=2;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookAuthor,c);
	   	    dialogPane.add(label_bookAuthor);
	   	    
	   	    label_publicHome= new JLabel("������:");
	   	    gridx=0;
	   	    gridy=3;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_publicHome,c);
	   	    dialogPane.add(label_publicHome);
	   	    
	   	    label_bookYear= new JLabel("���:");
	   	    gridx=0;
	   	    gridy=4;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookYear,c);
	   	    dialogPane.add(label_bookYear);
	   	    
	   	    
	   	    field_ISBN= new JTextField();         //ͼ����
	   	    gridx=1;
	   	    gridy=0;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=260;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(field_ISBN,c);
	   	    dialogPane.add(field_ISBN);
	   	    
	   	    field_bookName= new JTextField();        //ͼ����
	   	    gridx=1;
	   	    gridy=1;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(field_bookName,c);
	   	    dialogPane.add(field_bookName);
	   	    
	   	    field_bookAuthor= new JTextField();     //ͼ������
	   	    gridx=1;
	   	    gridy=2;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(field_bookAuthor,c);
	   	    dialogPane.add(field_bookAuthor);
	   	    
	   	    field_publicHome= new JTextField();         //������
	   	    gridx=1;
	   	    gridy=3;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(field_publicHome,c);
	   	    dialogPane.add(field_publicHome);
	   	    
	   	    field_bookYear= new JTextField("0");        //ͼ��������
	   	    gridx=1;
	   	    gridy=4;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(field_bookYear,c);
	   	    dialogPane.add(field_bookYear);
	   	    
	   	   
	   	    
	   	    panel = new JPanel();
	   	    button1 = new JButton("ȷ��"); 
	   	    button2 = new JButton("ȡ��"); 
	   	    panel.setLayout(null);
	   	    button1.setBounds(80,0, 80, 25);
	   	    button1.addActionListener(new button1_ActionListener());
	   	    button2.setBounds(190,0, 80, 25);
	   	    button2.addActionListener(new button2_ActionListener());
	   	    panel.add(button1);
	   	    panel.add(button2);
	   	    gridx=0;
	   	    gridy=6;
	   	    gridwidth=4;
	   	    gridheight=2;
	   	    ipadx=0;
	   	    ipady=24;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(panel,c);
	   	    dialogPane.add(panel);
	   	    
	   	    setBounds(500, 350,350, 250);
	}
	
	/**
	 * ȷ�� ��ť���¼�
	 */
	public class button1_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try{
			ArrayList<Book> searchList = Library.searchBook(field_ISBN.getText(), field_bookName.getText(), 
					field_bookAuthor.getText(), field_publicHome.getText(),Integer.parseInt(field_bookYear.getText()));
			dispose();
			table.setModel(new BookTableModel1(searchList));
			if(searchList.size() == 0)
				JOptionPane.showMessageDialog(null, "�޸�����ͼ����Ϣ��");
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "��ݸ�ʽ�����������ȷ������Ĭ��д0");
			}
			
			
		}
		
	}

	/**
	 * ȡ�� ��ť���¼�
	 */
	public class button2_ActionListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}
