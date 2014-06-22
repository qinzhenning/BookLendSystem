package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;

/**
 * �����ͼ��ĶԻ���
 */
public class AddNewBookDialog extends JDialog {
	private JLabel label_ISBN,label_bookName,label_bookAuthor,label_publicHome,label_bookYear,label_isSpecial;
	private JTextField field_ISBN,field_bookName,field_bookAuthor,field_publicHome,field_bookYear;
	private JRadioButton Rbutton1,Rbutton2;
	private ButtonGroup buttonGroup;
	private JButton button1,button2;
	private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
	private Insets inset;
	private JPanel panel;
	
	//���췽��-���ñ���
	public AddNewBookDialog(String title) {
		setTitle(title);
	}
	
	//������
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
	   	    
	   	    label_isSpecial= new JLabel("�Ƿ��䱾:");
	   	    gridx=0;
	   	    gridy=5;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_isSpecial,c);
	   	    dialogPane.add(label_isSpecial);
	   	    
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
	   	    
	   	    field_bookYear= new JTextField();        //ͼ��������
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
	   	    
	   	    Rbutton1 = new JRadioButton("��");
	   	    gridx=1;
	   	    gridy=5;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(Rbutton1,c);
	   	    dialogPane.add(Rbutton1);
	   	    
	   	    Rbutton2 = new JRadioButton("��");
	   	    Rbutton2.setSelected(true);
	   	    gridx=2;
	   	    gridy=5;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(Rbutton2,c);
	   	    dialogPane.add(Rbutton2);
	   	    buttonGroup = new ButtonGroup();
	   	    buttonGroup.add(Rbutton1);
	   	    buttonGroup.add(Rbutton2);
	   	    
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

	//ȷ�� ��ť �¼�
	class button1_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean isAdd = true;
			int year = 0;
			
//			try {
			for(int i =0;i < Library.getBookList().size(); i ++)
			{
				if(Library.getBookList().get(i).getISBN().equals(field_ISBN.getText()))
					isAdd = false;
			}
			
			if((field_ISBN.getText().equals("")) || (field_bookName.getText().equals("")) || (field_bookAuthor.getText().equals("")) 
					|| (field_publicHome.getText().equals("")) || (field_bookYear.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null, "���������Ϣ��������");
			}
			else
			{
				try {
				year = Integer.parseInt(field_bookYear.getText());
				
				if(isAdd)
				{	
					if(Rbutton1.isSelected())
					Library.addBookObject(new Book(field_ISBN.getText(), field_bookName.getText(), field_bookAuthor.getText(), 
							field_publicHome.getText(),year, true));
					else
						Library.addBookObject(new Book(field_ISBN.getText(), field_bookName.getText(), field_bookAuthor.getText(), 
								field_publicHome.getText(),year, false));
					
					dispose();
					ManageBook.getTabel(1).setModel(new BookTableModel(Library.getBookList()));
				}
				else
					JOptionPane.showMessageDialog(null, "��ͼ�����Ѵ��ڣ�����������!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "�����ʽ��������������!");
				}
			}
		}
		
	}

	//ȡ�� ��ť�¼�
	class button2_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}


