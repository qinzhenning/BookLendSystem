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
 * 时间：2012-6-26下午2:59:30
 * 文件：AddAdminDialog.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：AddAdminDialog
 */
/**
 * 添加管理员对话框
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
	
	//构造函数-设置标题
	public AddAdminDialog(String title){
		setTitle(title);
	}
	
	//主函数
	public void go(){
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridBag = new GridBagLayout();
		Container dialogPane = getContentPane();
		dialogPane.setLayout(gridBag);
		
		label_username = new JLabel("用户名");
		gridx=0;
	   	gridy=0;
	   	     
	   	gridwidth=1; //  占一个组件长度   
	   	gridheight=1;	//占一个组件高度
	    /**
   	     * 当窗口变化时该组件变化比例
   	     */
	   	weightx=1;
	   	weighty=1;
	       anchor=GridBagConstraints.CENTER;
	       fill=GridBagConstraints.HORIZONTAL;
	       inset=new Insets(0,0,0,0);
	    /**
	     * 在默认长度的基础上加上0个像素
   	     */
	   	 ipadx=0;
	   	/**
	     * 在默认高度的基础上加上0个像素
   	     */
	   	 ipady=0;
	      c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	    gridBag.setConstraints(label_username,c);
	    dialogPane.add(label_username);
	    
	    
	    label_password = new JLabel("密码");
	    gridx=0;
	    gridy=1;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	    gridBag.setConstraints(label_password,c);
	    dialogPane.add(label_password);
	    
	   label_name = new JLabel("姓名");
	   gridx = 0;
	   gridy = 2;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_name,c);
	   dialogPane.add(label_name);
	  
	   label_sex = new JLabel("性别");
	   gridx = 0;
	   gridy = 3;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_sex,c);
	   dialogPane.add(label_sex); 
	   
	   label_adNumber = new JLabel("编号");
	   gridx = 0;
	   gridy = 4;
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(label_adNumber,c);
	   dialogPane.add(label_adNumber);  
	   
	   field_username = new JTextField("");		//用户名
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
  	    
  	    field_password = new JTextField("");		//密码
  	    gridx=1;
	    gridy=1; 
	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(field_password,c);
	   dialogPane.add(field_password);
	   
	   field_name = new JTextField("");			//姓名
 	   gridx=1;
	   gridy=2; 
	   c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   gridBag.setConstraints(field_name,c);
	   dialogPane.add(field_name);
	   
	   button_male = new JRadioButton("男");
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
	   
	   button_female = new JRadioButton("女");
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
 	    button1 = new JButton("确认"); 
 	    button2 = new JButton("取消"); 
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
	 *添加管理员_确定按钮 
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
				JOptionPane.showMessageDialog(null, "有遗漏信息哦^_^  请把信息补充完整");
			else
			{
				if(isAdd)
				{
					String sex = "";
					if(button_male.isSelected())
						sex = "男";
					else
						sex = "女";
					
;					AdministratorList.addAdmin(field_username.getText(), field_password.getText(),
							field_name.getText(), sex, field_adNumber.getText());
					dispose();		
					ManageAdmin.getTabel().setModel(new AdminTableModel(list));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "用户名或编号有重复哦^_^  请把核对后重新输入");
				}
			}
		}
		
	}
	
	/**
	 *添加管理员_取消按钮 
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
