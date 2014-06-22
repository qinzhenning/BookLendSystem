package com.qinzhenning.BookLendSystem.GUI.AdminFrame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.GUI.LoginFrame.LoginFrame;
import com.qinzhenning.Client.MyRemoteClient;


/**
 * 
 * @author qinzhenning
 * 时间：2012-6-30下午11:45:57
 * 文件：AdminFrame.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.AdminFrame
 * 类  ：AdminFrame
 */

/**
 * 管理员界面
 * 有四个标签可供选择：图书管理、借阅人管理、管理员管理、退出
 */
public class AdminFrame extends JFrame{
	private JLabel label_Book,label_Borrower,label_Admin,label_Exit;	//图书管理
	private static JLabel label5;
	private static JFrame frame;
	private Container contentpane;
	private ManageBorrower  borrower;
	private ManageBook book;
	private ManageAdmin manageAdmin;
	private URL url;
	private File file;
	private AudioClip c;
	private static int x;
	private static int y;
	private int count = 0;
	private static boolean isStop = false;
	private static  MoveLabel a;
	private static  Administrator admin;
	
	//构造函数
	public AdminFrame(Administrator admin)  {
		super();
		borrower = new ManageBorrower();
		book = new ManageBook();
		manageAdmin = new ManageAdmin();
		this.admin = admin;
		x = 1000;
		y = 15;
		a = new MoveLabel();
//		Test.isOut = true;
		
		
		frame = new JFrame("图书管理系统");
		//音乐
		try{
			file = new File("./move.wav");
			url = file.toURL();
			c = Applet.newAudioClip(url);
		}catch(Exception ex){
			try{
				c = Applet.newAudioClip(AdminFrame.class.getResource("/move.wav"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "音乐载入发生故障！");
			}
		}
		
	
		
		
		contentpane = frame.getContentPane();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		

		label_Book = new JLabel("图书管理    |");
		label_Book.addMouseListener(new Label_Book_ActionListener());
		label_Book.setBounds(20, 60, 80, 30);
		label_Borrower = new JLabel("借阅员管理   |");	
		label_Borrower.addMouseListener(new Label_Borrower_ActionListener());
		label_Borrower.setBounds(102, 60, 100, 30);
		label_Admin = new JLabel("管理员管理   |");
		label_Admin.addMouseListener(new Label_Admin_ActionListener());
		label_Admin.setBounds(204, 60, 100, 30);
		label_Exit = new JLabel("退出   |");
		label_Exit.addMouseListener(new Label_Exit_ActionListener());
		label_Exit.setBounds(300, 60, 80, 30);
		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		String str = df.format(now);
		int year = now.getYear();
		int month = now.getMonth();
		int date = now.getDate();
		int day = now.getDay();
		String d = "";
		
		switch(day) {
		case 1:
			d = "一";
			break;
		case 2:
			d = "二";
			break;
		case 3:
			d= "三";
			break;
		case 4:
			d = "四";
			break;
		case 5:
			d = "五";
			break;
		case 6:
			d = "六";
			break;
		case 0:
			d = "天";
			break;
		default:
				break;
			
			
		}
		
		label5 = new JLabel( admin.getName()+ " 管理员,您好！"+"欢迎来到图书管理系统 今天是公元 "+(year +1900)+ " 年 "+ (month +1)+" 月 " + date + "日 " + " 星期" + d
														+" 请根据需要点击左下方的标签");
		label5.setFont(new Font("宋体",Font.BOLD,15));
		label5.setBounds(x, y, 920, 30);
		label5.addMouseListener(new MoveLabel_MouseListener());
		contentpane.add(label_Book);
		contentpane.add(label_Borrower);
		contentpane.add(label_Admin);
		contentpane.add(label_Exit);
		contentpane.add(label5);
		Thread go = new Thread();
		go.start();
		
		JSeparator line = new JSeparator();
		line.setBounds(0, 94, 1000, 1);
		line.setBackground(Color.blue);
		contentpane.add(line);
		
		
		
		frame.setBounds(220,40,1000,700);
		frame.setResizable(false);
		contentpane.setBackground(Color.orange);
		frame.setVisible(true);	
		c.loop();
		//移动图标实现
		while(true)
		{
			try {
				a.go();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			label5.setBounds(x, y, 920, 30);
			label5.repaint();
			frame.repaint();
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	/**
	 * 管理图书 标签事件
	 */
	class Label_Book_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			label_Book.setFont(new Font("",Font.BOLD,12));
			label_Borrower.setFont(new Font("",Font.PLAIN,12));
			label_Admin.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			if((borrower.getPanel(1) != null) && (borrower.getPanel(2) != null))
			{
			contentpane.remove(borrower.getPanel(1));
			contentpane.remove(borrower.getPanel(2));
			contentpane.remove(manageAdmin.getPanel());
			}
			contentpane.add(book.getPanel(1));
			contentpane.add(book.getPanel(2));
			
			contentpane.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label_Book.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	 * 管理借阅者 标签事件
	 */
	class Label_Borrower_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			label_Borrower.setFont(new Font("",Font.BOLD,12));
			label_Book.setFont(new Font("",Font.PLAIN,12));
			label_Admin.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			if((book.getPanel(1)!= null) && (book.getPanel(2) != null))
			{
			contentpane.remove(book.getPanel(1));
			contentpane.remove(book.getPanel(2));
			contentpane.remove(manageAdmin.getPanel());
			}
			contentpane.add(borrower.getPanel(1));
			contentpane.add(borrower.getPanel(2));
			contentpane.repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label_Borrower.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	 * 管理管理员 标签事件
	 */
	class Label_Admin_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			label_Admin.setFont(new Font("",Font.BOLD,12));
			label_Book.setFont(new Font("",Font.PLAIN,12));
			label_Borrower.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			if((borrower.getPanel(1) != null) && (borrower.getPanel(2) != null) && (book.getPanel(1)!= null)
					&& (book.getPanel(2) != null))
			{
			contentpane.remove(borrower.getPanel(1));
			contentpane.remove(borrower.getPanel(2));
			contentpane.remove(book.getPanel(1));
			contentpane.remove(book.getPanel(2));
			}
			contentpane.add(manageAdmin.getPanel());
			contentpane.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label_Admin.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	 * 退出 标签事件
	 */
	class Label_Exit_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			MyRemoteClient Client = new MyRemoteClient();
//			Client.SaveAdminData();
//			Client.SaveBorrowerData();
//			Client.SaveBookData();
			Client.SaveAllData();
			System.exit(0);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label_Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}
	
	/**
	 * 移动标签事件
	 */
	class MoveLabel_MouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			isStop = true;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			isStop = false;
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
		
	//移动图标的内部类
	
	class MoveLabel {
		
		void go() throws InterruptedException { 

			
			if(!isStop)
			{
			if(x >  -920)
				x --;
			if(x == -920)
				x =1000;
			
			}
		}
		
	}

	//获取窗口对象
	public static JFrame getFrame(){
		return frame;
	}


	//返回管理员对象
	public static Administrator getAdmin(){
		return admin;
	}
		
	
	

}
