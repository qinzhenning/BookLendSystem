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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewBookDialog.button1_ActionListener;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AddNewBookDialog.button2_ActionListener;
import com.qinzhenning.BookLendSystem.Library.Book;
import com.qinzhenning.BookLendSystem.Library.Library;
/**
 * 
 * @author qinzhenning
 * 时间：2012-7-15下午5:08:28
 * 文件：ChangeBookDialog.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：ChangeBookDialog
 */
/**
 * 修改图书信息 对话框
 */
public class ChangeBookDialog extends JDialog {
	private JLabel label_ISBN,label_bookName,label_bookAuthor,label_publicHome,label_bookYear,label_isSpecial;
	private JTextField field_ISBN,field_bookName,field_bookAuthor,field_publicHome,field_bookYear;
	private JRadioButton Rbutton1,Rbutton2;
	private ButtonGroup buttonGroup;
	private JButton button1,button2;
	private int gridx,gridy,weightx,weighty,gridwidth,gridheight,anchor,fill,ipadx,ipady;
	private Insets inset;
	private JPanel panel;
	private Book changeBook;
	private ArrayList<Book> list = Library.getBookList();
	
	/**
	  * 构造方法- 设置标题 和 传入图书对象
	  */
	public ChangeBookDialog(String title,Book book) {
		setTitle(title);
		changeBook = book;
	}
	
	
	/**
	  * 主方法
	  */
	public void go() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout gridBag = new GridBagLayout();
		Container dialogPane = getContentPane();
		dialogPane.setLayout(gridBag);
		
		
		label_ISBN = new JLabel("编号 :");
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
	   	    gridBag.setConstraints(label_ISBN,c);
	   	    dialogPane.add(label_ISBN);
	   	    
	   	    label_bookName= new JLabel("书名 :");
	   	    gridx=0;
	   	    gridy=1;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookName,c);
	   	    dialogPane.add(label_bookName);
	   	    
	   	    label_bookAuthor= new JLabel("作者 :");
	   	    gridx=0;
	   	    gridy=2;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookAuthor,c);
	   	    dialogPane.add(label_bookAuthor);
	   	    
	   	    label_publicHome= new JLabel("出版社:");
	   	    gridx=0;
	   	    gridy=3;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_publicHome,c);
	   	    dialogPane.add(label_publicHome);
	   	    
	   	    label_bookYear= new JLabel("年份:");
	   	    gridx=0;
	   	    gridy=4;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_bookYear,c);
	   	    dialogPane.add(label_bookYear);
	   	    
	   	    label_isSpecial= new JLabel("是否珍本:");
	   	    gridx=0;
	   	    gridy=5;
	   	    c=new GridBagConstraints(gridx,gridy,gridwidth,gridheight,weightx,weighty,anchor,
	   	       fill,inset,ipadx,ipady);
	   	    gridBag.setConstraints(label_isSpecial,c);
	   	    dialogPane.add(label_isSpecial);
	   	    
	   	    field_ISBN= new JTextField(changeBook.getISBN());         //图书编号
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
	   	    
	   	    field_bookName= new JTextField(changeBook.getbookName());        //图书名
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
	   	    
	   	    field_bookAuthor= new JTextField(changeBook.getbookAuthor());     //图书作者
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
	   	    
	   	    field_publicHome= new JTextField(changeBook.getpublicHome());         //出版社
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
	   	    
	   	    String year = String.valueOf(changeBook.getbookYear());
	   	    field_bookYear= new JTextField(year);        //图书出版年份
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
	   	    
	   	    Rbutton1 = new JRadioButton("是");
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
	   	    
	   	    Rbutton2 = new JRadioButton("否");
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
	   	    if(changeBook.getisSpecialBook())
	   	    	Rbutton1.setSelected(true);
	   	    else
	   	    	Rbutton2.setSelected(true);
	   	    buttonGroup = new ButtonGroup();
	   	    buttonGroup.add(Rbutton1);
	   	    buttonGroup.add(Rbutton2);
	   	    
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
	  * 确认 按钮事件
	  */
	class button1_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if((field_ISBN.getText().equals("")) || (field_bookName.getText().equals("")) || (field_bookAuthor.getText().equals("")) 
					|| (field_publicHome.getText().equals("")) || (field_bookYear.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null, "错误！请把信息补充完整");
			}
			else
			{
				int year = 0;
				try {
					year = Integer.parseInt(field_bookYear.getText()); 
				
				boolean isChange = true;
				for(int i = 0; i < list.size();i ++)
				{
					if(field_ISBN.getText().equals(list.get(i).getISBN()))
						isChange = false;
				}
				if(changeBook.getISBN().equals(field_ISBN.getText()))
						isChange = true;
				if(isChange)
				{
				Library.changeBookObject(changeBook, field_ISBN.getText(), field_bookName.getText(), field_bookAuthor.getText(),
						field_publicHome.getText(), year, Rbutton1.isSelected());
				dispose();
				JOptionPane.showMessageDialog(null, "修改信息成功！修改结果如下");
				ManageBook.getTabel(1).setModel(new BookTableModel(changeBook));
				}
				else
					JOptionPane.showMessageDialog(null, "对不起，该图书编号已存在！请重新输入.");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "年份输入格式有误，请重新输入!");
				}
				
			}
		}
	}
	
	/**
	  * 取消 按钮事件
	  */
	class button2_ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}
