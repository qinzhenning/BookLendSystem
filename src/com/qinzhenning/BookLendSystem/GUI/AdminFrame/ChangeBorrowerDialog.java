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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.Borrower.Postgraduate;
import com.qinzhenning.BookLendSystem.Borrower.Teacher;
import com.qinzhenning.BookLendSystem.Borrower.Undergraduate;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewUserDialog.button6ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewUserDialog.button7ActionListener;
/**
 * 
 * @author qinzhenning
 * ʱ�䣺2012-7-15����5:21:43
 * �ļ���ChangeBorrowerDialog.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * ��  ��ChangeBorrowerDialog
 */
/**
 * �޸Ľ�������Ϣ �Ի���
 */
public class ChangeBorrowerDialog extends JDialog {
	private JLabel label1,label2,label3,label4,label5,label6;
	private JTextField text1,text2,text3,text4;//�û��������룬���������
	private ButtonGroup buttonGroup1,buttonGroup2;
	private JRadioButton button1,button2,button3,button4,button5;
	private JButton button6,button7;
	private JPanel panel;
	private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
	private Insets inset;
	private ArrayList<Borrower> list = BorrowerList.getBorrowerList();
	private Borrower changeBorrower;
	private JFrame frame;

	/**
	 * ���췽��-���봰�ڶ��󡢽����ߡ����ñ���
	 */
	public  ChangeBorrowerDialog(JFrame f,Borrower borrower,String title){
		frame = f;
		changeBorrower = borrower;	
		setTitle(title);
	}
	
	/**
	 * ������
	 */
	public void go() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridBag = new GridBagLayout();
		Container dialogPane = getContentPane();
		dialogPane.setLayout(gridBag);
	
		   label1 = new JLabel("�û��� :");
		   gridx=0;
	   	    gridy=0;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    weightx=1;
	   	    weighty=1;
	   	    anchor=GridBagConstraints.CENTER;
	   	    fill=GridBagConstraints.HORIZONTAL;
	   	    inset=new Insets(0,0,0,0);
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label1,c);
	   	    dialogPane.add(label1);
	   	    
	   		 label2= new JLabel("����:");
	   	    gridx=0;
	   	    gridy=1;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label2,c);
	   	    dialogPane.add(label2);
	   	    
	   	    label3= new JLabel("����:");
	   	    gridx=0;
	   	    gridy=2;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label3,c);
	   	    dialogPane.add(label3);
	   	    
	   	    label4= new JLabel("���:");
	   	    gridx=0;
	   	    gridy=3;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label4,c);
	   	    dialogPane.add(label4);
	   	    
	   	    label5= new JLabel("�Ա�:");
	   	    gridx=0;
	   	    gridy=4;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label5,c);
	   	    dialogPane.add(label5);
	   	    
	   	 label6= new JLabel("���:");
	   	    gridx=0;
	   	    gridy=5;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label6,c);
	   	    dialogPane.add(label6);
	   	    
	   	    text1= new JTextField(changeBorrower.getUserName());         //�û���
	   	    gridx=1;
	   	    gridy=0;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(text1,c);
	   	    dialogPane.add(text1);
	   	    
	   	    text2= new JTextField(changeBorrower.getPassword());        //����
	   	    gridx=1;
	   	    gridy=1;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(text2,c);
	   	    dialogPane.add(text2);
	   	    
	   	    text3= new JTextField(changeBorrower.getBorrowerName());     //����
	   	    gridx=1;
	   	    gridy=2;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(text3,c);
	   	    dialogPane.add(text3);
	   	    
	   	 text4= new JTextField(changeBorrower.getBorrowerNumber());         //���
	   	    gridx=1;
	   	    gridy=5;
	   	    gridwidth=3;
	   	    gridheight=1;
	   	    ipadx=200;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(text4,c);
	   	    dialogPane.add(text4);
	   	    
	   	   
	   	    button1 = new JRadioButton("��ʦ");
	   	    if(changeBorrower instanceof Teacher)
	   	    	button1.setSelected(true);
	   	    gridx=1;
	   	    gridy=3;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button1,c);
	   	    dialogPane.add(button1);
	   	    
	    	button2 = new JRadioButton("������");
	    	if(changeBorrower instanceof Undergraduate)
		   	    button2.setSelected(true);
	   	    gridx=2;
	   	    gridy=3;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button2,c);
	   	    dialogPane.add(button2);
	  
	   		 button3 = new JRadioButton("�о���");
	   		 if(changeBorrower instanceof Postgraduate)
	   	    	button3.setSelected(true);
	   	    gridx=3;
	   	    gridy=3;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button3,c);
	   	    dialogPane.add(button3);
	   	    button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			buttonGroup1 = new ButtonGroup();
	   	    buttonGroup1.add(button1);
		   	buttonGroup1.add(button2);
		   	buttonGroup1.add(button3);
		   	
	   	 
		    button4 = new JRadioButton("��");
		    if(changeBorrower.getSex().equals("��"))
		    	button4.setSelected(true);
	   	    gridx=1;
	   	    gridy=4;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button4,c);
	   	    dialogPane.add(button4);
	   	    
	   	 	button5 = new JRadioButton("Ů");
	   	 	if(changeBorrower.getSex().equals("Ů"))
	   	 		button5.setSelected(true);
	   	    gridx=2;
	   	    gridy=4;
	   	    gridwidth=1;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button5,c);
	   	    dialogPane.add(button5);
	   	    buttonGroup2 = new ButtonGroup();
	   	    buttonGroup2.add(button4);
	   	    buttonGroup2.add(button5);
	   	    
	   	    button6= new JButton("ȷ��");
	   	    button6.addActionListener(new button6_ActionListener());
	   	    gridx=0;
	   	    gridy=6;
	   	    gridwidth=2;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button6,c);
	   	    dialogPane.add(button6);
	   	    
	   	    button7 = new JButton("ȡ��");
	   	    button7.addActionListener(new button7_ActionListener());
	   	    gridx=2;
	   	    gridy=6;
	   	    gridwidth=2;
	   	    gridheight=1;
	   	    ipadx=0;
	   	    ipady=0;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(button7,c);
	   	    dialogPane.add(button7);
	   	    
       
//		dialog.setBounds(500, 350,350, 250);
	   	 setBounds(500, 350,350, 250);
		
	}

	/**
	 * ȷ�ϰ�ť���¼�
	 */
	public class button6_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(!(text1.getText().equals("")) && (!text2.getText().equals("")) && (!text3.getText().equals("")) && (!(text4.getText().equals(""))) )
			{
				boolean isChange = true;
				for(int i =0;i < list.size(); i ++)
				{
					if( text1.getText().equals((list.get(i).getUserName())) || text4.getText().equals(list.get(i).getBorrowerNumber()))
						isChange = false;		
					if(text4.getText().equals(changeBorrower.getBorrowerNumber()))
						isChange =true;
				}
					if(isChange)
					{
						changeBorrower.setUsername(text1.getText());
						changeBorrower.setPassword(text2.getText());
						changeBorrower.setBorrowerName(text3.getText());
						changeBorrower.setBorrowerNumber(text4.getText());
				
						if(button4.isSelected())
							changeBorrower.setSex("��");
						else
							changeBorrower.setSex("Ů");
				
						dispose();
						JOptionPane.showMessageDialog(null, "�޸���Ϣ�ɹ����޸Ľ������");
						ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(changeBorrower));
					}
					else
						JOptionPane.showMessageDialog(null, "�Բ��𣬸��û��������Ѵ��ڣ�����������!");
				}
			else
				JOptionPane.showMessageDialog(null, "�Բ�����Ϣ���������벹�䣡");
			
			
		}
		
	}
	
	/**
	 * ȡ����ť���¼�
	 */
	public class button7_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}
