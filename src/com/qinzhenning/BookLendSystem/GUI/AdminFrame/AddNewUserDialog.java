package com.qinzhenning.BookLendSystem.GUI.AdminFrame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

/**
 * 添加新借阅者对话框
 */
public class AddNewUserDialog extends JDialog {
//		private JDialog dialog;
		private JLabel label1,label2,label3,label4,label5,label6;
		private JTextField text1,text2,text3,text4;//用户名、密码，姓名，编号
		private ButtonGroup buttonGroup1 ,buttonGroup2;
		private JRadioButton button1,button2,button3,button4,button5;
		private JButton button6,button7;
		private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
		private Insets inset;
		private ArrayList<Borrower> list = BorrowerList.getBorrowerList();
		
		public AddNewUserDialog(String title){
//			dialog = new JDialog(f,"添加借阅者",true);
			setTitle(title);

		

//		      JLabel label = new JLabel("用户名 : ");
//		      gridx=0;               //第0列
//		      gridy=0;               //第0行
//		      gridwidth = 1;         //占一单位宽度
//		      gridheight = 1;        //占一单位高度
//		      weightx = 0;           //窗口增大时组件宽度增大比率0
//		      weighty = 0;           //窗口增大时组件高度增大比率0
//		      anchor = GridBagConstraints.CENTER; //容器大于组件size时将组件置于容器中央
//		      fill = GridBagConstraints.BOTH;     //窗口拉大时会填满水平与垂直空间
//		      inset = new Insets(0,0,0,0);        //组件间间距
//		      ipadx = 0;                          //组件内水平宽度
//		      ipady = 0;                          //组件内垂直高度
		      
				
		}
		
		//主方法
		public void go() {
			GridBagConstraints c = new GridBagConstraints();
			GridBagLayout gridBag = new GridBagLayout();
//			Container dialogPane = dialog.getContentPane();
			Container dialogPane = getContentPane();
			
			
			
			dialogPane.setLayout(gridBag);
		
			   label1 = new JLabel("用户名 :");
			   /**
			    * 第一行第一列
			    */
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
		   	    gridBag.setConstraints(label1,c);
		   	    dialogPane.add(label1);
		   	    
		   		 label2= new JLabel("密码:");
		   	    gridx=0;
		   	    gridy=1;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    gridBag.setConstraints(label2,c);
		   	    dialogPane.add(label2);
		   	    
		   	    label3= new JLabel("姓名:");
		   	    gridx=0;
		   	    gridy=2;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    gridBag.setConstraints(label3,c);
		   	    dialogPane.add(label3);
		   	    
		   	    label4= new JLabel("身份:");
		   	    gridx=0;
		   	    gridy=3;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    gridBag.setConstraints(label4,c);
		   	    dialogPane.add(label4);
		   	    
		   	    label5= new JLabel("性别:");
		   	    gridx=0;
		   	    gridy=4;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    gridBag.setConstraints(label5,c);
		   	    dialogPane.add(label5);
		   	    
		   	 label6= new JLabel("编号:");
		   	    gridx=0;
		   	    gridy=5;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    gridBag.setConstraints(label6,c);
		   	    dialogPane.add(label6);
		   	    
		   	    text1= new JTextField();         //用户名
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
		   	    
		   	    text2= new JTextField();        //密码
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
		   	    
		   	    text3= new JTextField();     //姓名
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
		   	    
		   	 text4= new JTextField();         //编号
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
		   	    
		   	   
		   	    button1 = new JRadioButton("老师");
		   	    gridx=1;
		   	    gridy=3;
		   	    gridwidth=1;
		   	    gridheight=1;
		   	    ipadx=0;
		   	    ipady=0;
		   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
		   	       fill,inset,ipadx,ipady);
		   	    button1.setSelected(true);
		   	    gridBag.setConstraints(button1,c);
		   	    dialogPane.add(button1);
		   	    
		    	button2 = new JRadioButton("本科生");
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
		  
		   		 button3 = new JRadioButton("研究生");
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
		   	    buttonGroup1 = new ButtonGroup();
		   	    buttonGroup1.add(button1);
			   	buttonGroup1.add(button2);
			   	buttonGroup1.add(button3);
		   	 
			    button4 = new JRadioButton("男");
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
		   	    
		   	 	button5 = new JRadioButton("女");
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
		   	    
		   	    button6= new JButton("确定");
		   	    button6.addActionListener(new button6ActionListener());
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
		   	    
		   	    button7 = new JButton("取消");
		   	    button7.addActionListener(new button7ActionListener());
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
		   	    
	       
//			dialog.setBounds(500, 350,350, 250);
		   	 setBounds(500, 350,350, 250);
			
			
		}
		/**
		 * 确定按钮的事件
		 */
		public class button6ActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String [] data = new String[6];
				if(!(text1.getText().equals("")) && (!text2.getText().equals("")) && (!text3.getText().equals("")) && (!(text4.getText().equals(""))) )
				{
					boolean isAdd = true;
					for(int i =0;i < list.size(); i ++)
					{
						if( text1.getText().equals((list.get(i).getUserName())) || text4.getText().equals(list.get(i).getBorrowerNumber()))
						{
								isAdd = false;		
						}
					}
					
					
					
					
					if(isAdd)
					{
					if(button1.isSelected())
					{
						if(button4.isSelected())
							BorrowerList.addBorrower(new Teacher(text1.getText(), text2.getText(), text3.getText(), "男",text4.getText()));
						else 
							BorrowerList.addBorrower(new Teacher(text1.getText(), text2.getText(), text3.getText(), "女",text4.getText()));
					}
					
					else if(button2.isSelected())
					{
						if(button4.isSelected())
							BorrowerList.addBorrower(new Undergraduate(text1.getText(), text2.getText(), text3.getText(), "男",text4.getText()));
						else 
							BorrowerList.addBorrower(new Undergraduate(text1.getText(), text2.getText(), text3.getText(), "女",text4.getText()));
					}
					
					else
					{	
						if(button4.isSelected())
							BorrowerList.addBorrower(new Postgraduate(text1.getText(), text2.getText(), text3.getText(), "男",text4.getText()));
						else 
							BorrowerList.addBorrower(new Postgraduate(text1.getText(), text2.getText(), text3.getText(), "女",text4.getText()));
					}
					dispose();
					ManageBorrower.getTabel(1).setModel(new BorrowerTableModel(BorrowerList.getBorrowerList()));
					}
					/*
					 * 检查是否存在相同账号和编号
					 */
//					text4.getText().equals(list.get(i).getBorrowerNumber())
					
					
					else
					{
						
						JOptionPane.showMessageDialog(null, "该用户名或编号已存在，请重新输入!");
					}
				}
					
					
				/**
				 * 若信息不全，请补充
				 */
				else
				{
					JOptionPane.showMessageDialog(null, "错误！请把信息补充完整");
				}
			}
		}
		/**
		 *取消按钮的事件 
		 */
		public class button7ActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();	
			}
		}

}
