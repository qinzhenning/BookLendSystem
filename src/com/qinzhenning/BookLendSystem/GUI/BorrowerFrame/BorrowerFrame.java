/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.GUI.LoginFrame.LoginFrame;
import com.qinzhenning.Client.MyRemoteClient;

/**
 * @author qinzhenning
 * ʱ�䣺2012-6-28����3:22:51
 * �ļ���BorrowerFrame.java
 * ��Ŀ��BookLendSystem 
 * ��  ��com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * ��  ��BorrowerFrame
 */

/**
 * ������ ����
 */
public class BorrowerFrame {
	private JLabel label_BorrowBook,label_SeeBorrowBook,label_SeeMessage,label_Exit;	//ͼ�����
	private static JLabel label5;
	private static JFrame frame;
	private Container contentpane;
	private URL url;
	private File file;
	private AudioClip c;
	private static int x;
	private static int y;
	private int count = 0;
	private static boolean isStop = false;
	private static  MoveLabel a;
	private BorrowBook borrowBook;
	private ArrayList<Borrower> list = BorrowerList.getBorrowerList();
	private static Borrower borrower;
	private SeeBorrowBook seeBook;
	private SeeMessage seeMessage;
	
	/**
	  * ��ȡ�����˶���
	  */
	public static  Borrower getBorrower(){
		return borrower;
	}
	
	/**
	  * ���췽��-������
	  */
	public BorrowerFrame(Borrower borrower) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException, InterruptedException {
		super();
		seeBook = new SeeBorrowBook(borrower);
		this.borrower = borrower;
		borrowBook = new BorrowBook();
		seeMessage = new SeeMessage();
		seeMessage.go(borrower);
		x = 1000;
		y = 15;
		a = new MoveLabel();
//		Test.isOut = true;
		
		
		frame = new JFrame("ͼ�����ϵͳ");
		//����
		try{
			file = new File("./move.wav");
			url = file.toURL();
			c = Applet.newAudioClip(url);
		}catch(Exception ex){
			try{
				c = Applet.newAudioClip(LoginFrame.class.getResource("/move.wav"));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�������뷢�����ϣ�");
			}
		}
		
	
		
		
		contentpane = frame.getContentPane();
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		

		label_BorrowBook = new JLabel("����ͼ��    |");
		label_BorrowBook.addMouseListener(new Label_BorrowBook_ActionListener());
		label_BorrowBook.setBounds(20, 60, 80, 30);
		label_SeeBorrowBook = new JLabel("�鿴�ѽ�ͼ��  |");	
		label_SeeBorrowBook.addMouseListener(new Label_SeeBorrowBook_ActionListener());
		label_SeeBorrowBook.setBounds(102, 60, 100, 30);
		label_SeeMessage = new JLabel("�鿴��Ϣ   |");
		label_SeeMessage.addMouseListener(new Label_SeeMessage_ActionListener());
		label_SeeMessage.setBounds(204, 60, 100, 30);
		label_Exit = new JLabel("�˳�   |");
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
			d = "һ";
			break;
		case 2:
			d = "��";
			break;
		case 3:
			d= "��";
			break;
		case 4:
			d = "��";
			break;
		case 5:
			d = "��";
			break;
		case 6:
			d = "��";
			break;
		case 0:
			d = "��";
			break;
		default:
				break;
			
			
		}
		
		label5 = new JLabel(borrower.getBorrowerName() +" "+ borrower.getIdentity() +" ���ã� "+ "��ӭ����ͼ�����ϵͳ �����ǹ�Ԫ "+(year +1900)+ " �� "+ (month +1)+" �� " + date + "�� " + " ����" + d
														+" �������Ҫ������·��ı�ǩ");
		label5.setFont(new Font("����",Font.BOLD,15));
		label5.setBounds(x, y, 920, 30);
		label5.addMouseListener(new MoveLabel_MouseListener());
		contentpane.add(label_BorrowBook);
		contentpane.add(label_SeeBorrowBook);
		contentpane.add(label_SeeMessage);
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
		//�ƶ�ͼ��ʵ��
		while(true)
		{
			a.go();
			label5.setBounds(x, y, 920, 30);
			label5.repaint();
			frame.repaint();
			Thread.sleep(12);
		}
		
		
		
	}
	
	/**
	  * ����ͼ�� ��ǩ�¼�
	  */
	class Label_BorrowBook_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			label_BorrowBook.setFont(new Font("",Font.BOLD,12));
			label_SeeBorrowBook.setFont(new Font("",Font.PLAIN,12));
			label_SeeMessage.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			
			if(seeBook.getPanel() != null )
				contentpane.remove(seeBook.getPanel());
			if(seeMessage.getPanel() !=null)
				contentpane.remove(seeMessage.getPanel());
			
//			borrowBook.go();
			contentpane.add(borrowBook.getPanel());
			
			
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
			label_BorrowBook.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	  * �鿴�ѽ�ͼ�� ��ǩ�¼�
	  */
	class Label_SeeBorrowBook_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			label_SeeBorrowBook.setFont(new Font("",Font.BOLD,12));
			label_BorrowBook.setFont(new Font("",Font.PLAIN,12));
			label_SeeMessage.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			if(borrowBook.getPanel() != null)
				contentpane.remove(borrowBook.getPanel());
			if(seeMessage.getPanel() !=null)
				contentpane.remove(seeMessage.getPanel());
//			seeBook.go();
			contentpane.add(seeBook.getPanel());
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
			label_SeeBorrowBook.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	  * �鿴��Ϣ ��ǩ�¼�
	  */
	class Label_SeeMessage_ActionListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			label_SeeMessage.setFont(new Font("",Font.BOLD,12));
			label_BorrowBook.setFont(new Font("",Font.PLAIN,12));
			label_SeeBorrowBook.setFont(new Font("",Font.PLAIN,12));
			label_Exit.setFont(new Font("",Font.PLAIN,12));
			
			if(seeBook.getPanel() != null )
				contentpane.remove(seeBook.getPanel());
			if(borrowBook.getPanel() != null)
				contentpane.remove(borrowBook.getPanel());
			contentpane.add(seeMessage.getPanel());
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
			label_SeeMessage.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
	}

	/**
	  * �˳� ��ǩ�¼�
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
	  * �ƶ� ��ǩ�¼�
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
	
	
	//�ƶ�ͼ����ڲ���
	
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

}
