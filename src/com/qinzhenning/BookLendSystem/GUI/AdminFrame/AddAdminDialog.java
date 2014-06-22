/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Administrator.AdministratorList;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewBookDialog.button1_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewBookDialog.button2_ActionListener;

/**
 * @author qinzhenning
 * ʱ�䣺2012-6-26����2:59:30
 * �ļ���AddAdminDialog.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��AddAdminDialog
 */
/**
 * ��ӹ���Ա�Ի���
 */
public class AddAdminDialog extends JDialog{
	private JLabel label_username,label_password,label_sex,label_name,label_adNumber;
	private JTextField field_username,field_sex,field_name,field_adNumber,field_password;
	private ButtonGroup buttonGroup;
	private JRadioButton button_female,button_male;
	private JButton button1,button2;
	private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
	private Insets inset;
	private JPanel panel;
	private ArrayList<Administrator> list =  AdministratorList.getAdminList();
	
	//���캯��-���ñ���
	public AddAdminDialog(String title){
		setTitle(title);
	}
	
	//������
	public void go(){
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridBag = new GridBagLayout();
		Container dialogPane = getContentPane();
		dialogPane.setLayout(gridBag);
		
		label_username = new JLabel("�û���");
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
	    gridBag.setConstraints(label_username,c);
	    dialogPane.add(label_username);
	    
	    
	    label_password = new JLabel("����");
	    gridx=0;
	    gridy=1;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	    gridBag.setConstraints(label_password,c);
	    dialogPane.add(label_password);
	    
	   label_name = new JLabel("����");
	   gridx = 0;
	   gridy = 2;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_name,c);
	   dialogPane.add(label_name);
	  
	   label_sex = new JLabel("�Ա�");
	   gridx = 0;
	   gridy = 3;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_sex,c);
	   dialogPane.add(label_sex); 
	   
	   label_adNumber = new JLabel("���");
	   gridx = 0;
	   gridy = 4;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_adNumber,c);
	   dialogPane.add(label_adNumber);  
	   
	   field_username = new JTextField("");		//�û���
	   gridx=1;
  	    gridy=0;
  	    gridwidth=3;
  	    gridheight=1;
  	    ipadx=240;
  	    ipady=0;
  	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
  	       fill,inset,ipadx,ipady);
  	    gridBag.setConstraints(field_username,c);
  	    dialogPane.add(field_username);
  	    
  	    field_password = new JTextField("");		//����
  	    gridx=1;
	    gridy=1; 
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(field_password,c);
	   dialogPane.add(field_password);
	   
	   field_name = new JTextField("");			//����
 	   gridx=1;
	   gridy=2; 
	   c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(field_name,c);
	   dialogPane.add(field_name);
	   
	   button_male = new JRadioButton("��");
	   button_male.setSelected(true);
	   gridx=1;
	   gridy=3; 
	   gridwidth=1;
  	   gridheight=1;
  	   ipadx=0;
  	   ipady=0;
	   c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(button_male,c);
	   dialogPane.add(button_male);
	   
	   button_female = new JRadioButton("Ů");
	   gridx=2;
	   gridy=3; 
	   gridwidth=1;
  	   gridheight=1;
  	   ipadx=0;
  	   ipady=0;
	   c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(button_female,c);
	   dialogPane.add(button_female);
	   buttonGroup = new ButtonGroup();
	   buttonGroup.add(button_male);
	   buttonGroup.add(button_female);
	   
	   field_adNumber = new JTextField();
	   gridx=1;
	   gridy=4; 
	   gridwidth=3;
 	   gridheight=1;
 	   ipadx=240;
 	   ipady=0;
 	   c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
 	       fill,inset,ipadx,ipady);
 	   gridBag.setConstraints(field_adNumber,c);
 	   dialogPane.add(field_adNumber);
	   
 	   
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
	 *��ӹ���Ա_ȷ����ť 
	 */
	public class button1_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			boolean isAdd = true;
			
			for(int i = 0; i < list.size();i ++)
			{
				if(list.get(i).getUsername().equals(field_username.getText()) 
					|| list.get(i).getAdminNumber().equals(field_adNumber.getText()))
					isAdd = false;
			}
			
			if(field_username.getText().equals("") || field_password.getText().equals("")
					||  field_name.getText().equals("") || field_adNumber.getText().equals(""))
				JOptionPane.showMessageDialog(null, "����©��ϢŶ^_^  �����Ϣ��������");
			else
			{
				if(isAdd)
				{
					String sex = "";
					if(button_male.isSelected())
						sex = "��";
					else
						sex = "Ů";
					
;					AdministratorList.addAdmin(field_username.getText(), field_password.getText(),
							field_name.getText(), sex, field_adNumber.getText());
					dispose();		
					ManageAdmin.getTabel().setModel(new AdminTableModel(list));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�û����������ظ�Ŷ^_^  ��Ѻ˶Ժ���������");
				}
			}
		}
		
	}
	
	/**
	 *��ӹ���Ա_ȡ����ť 
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
