package com.qinzhenning.BookLendSystem.GUI.LoginFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import com.qinzhenning.BookLendSystem.Administrator.Administrator;
import com.qinzhenning.BookLendSystem.Administrator.AdministratorList;
import com.qinzhenning.BookLendSystem.Borrower.Borrower;
import com.qinzhenning.BookLendSystem.Borrower.BorrowerList;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AdminFrame;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.ManageAdmin;
import com.qinzhenning.BookLendSystem.GUI.AdminFrame.AdminThread;
import com.qinzhenning.BookLendSystem.GUI.BorrowerFrame.BorrowerFrame;
import com.qinzhenning.BookLendSystem.GUI.BorrowerFrame.BorrowerThread;



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



/**
 * ��������
 */

public class LoginFrame extends JFrame implements Serializable{
	private JFrame frame;
	private JPanel panel,panel_1,panel_2;
	private JButton login,cancel;
	private JTextField username;
	private JRadioButton checkborrower,checkadmin;
	private ButtonGroup  check = new ButtonGroup();
	private JPasswordField password;
	private JLabel label,label1;
	private ImageIcon img;
	private boolean isborrower = true,isadmin = false;
	private int width, height;
    private BufferedImage bgImage;
    private int a = 0,b = 0;
    
    
//����������������������
	public LoginFrame(){
		
		this.setTitle("登录");
        width = 400;
        height = 269;
        this.setSize(width, height);
        this.setBounds(420,260,400,269);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        //��������
        bgImage = null;
        try {
            bgImage = ImageIO.read((LoginFrame.class.getResource("/duxia.jpg")));
        } catch (Exception e) {
//            e.printStackTrace();
        	 try {
				bgImage = ImageIO.read(new File("./picture/duxia.jpg"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        this.setLayout(null);

        login = new JButton("登录");
        cancel = new JButton("取消");
        username = new JTextField("请输入用户名",20);
        username.setBackground(Color.orange);
        
        label = new JLabel("������");
        password = new JPasswordField("请输入密码",20);
        password.setEchoChar((char)0);
        password.setBackground(Color.orange);
        label1 = new JLabel("��    ��");
        checkborrower = new JRadioButton("学生");
        checkborrower.setBackground(Color.orange);
        checkadmin = new JRadioButton("管理员");
        checkadmin.setBackground(Color.orange);
      
        
        
        

        login.setBounds(100, 200, 70, 30);
        cancel.setBounds(250, 200, 70, 30);
        username.setBounds(180,100,120,27);
        password.setBounds(180,130,120,27);
        checkborrower.setBounds(120, 170, 70, 20);
        checkborrower.setSelected(true);//������������
        checkadmin.setBounds(210,170 , 100, 20);
        checkadmin.setSelected(false);//��������������
        
        //����
        checkborrower.addItemListener(new isborrowerListener());
        checkadmin.addItemListener(new isadminListener());
        login.addActionListener(new loginListener());
        cancel.addActionListener(new cancelListener());
        username.addKeyListener(new usernameListener());
        username.addMouseListener(new usernameListener());
        password.addKeyListener(new passwordListener());
        password.addMouseListener(new passwordListener());
        
        label.setBounds(100,100,60,27);
        label.setOpaque(true);
        label1.setBounds(100,130,60,27);
       try{
    	   label.setIcon(new ImageIcon(LoginFrame.class.getResource("/login1.jpg")));
       }catch(Exception e){
    	   label.setIcon(new ImageIcon("./picture/login1.jpg"));
       }
       try{
    	   label1.setIcon(new ImageIcon(LoginFrame.class.getResource("/login2.jpg")));
       }catch(Exception ex){
    	   label1.setIcon(new ImageIcon("./picture/login2.jpg"));
       }
       
       check.add(checkborrower);
       check.add(checkadmin);
        add(login);
        add(cancel);
        add(username);
        add(password);
        add(label);
        add(label1);
        add(checkborrower);
        add(checkadmin);

        setVisible(true);
        
    }

	//��������������������������������
	public void paint(Graphics g) {
    g.drawImage(bgImage, 0, 0, this);
    super.paint(g);
    getContentPane().getGraphics().drawImage(bgImage, 0, 0, this);
    login.repaint();
    cancel.repaint();
    username.repaint();
    password.repaint();
    label1.repaint();
    label.repaint();
    checkborrower.repaint();
    checkadmin.repaint();
    checkborrower.repaint();
    checkadmin.repaint();
}

	//��������������������������������
@Override
	public void paintComponents(Graphics g) {
//    g.drawImage(bgImage, 0, 0, this); 
//    super.paintComponents(g);
}

//��������������������������������
	class Jpanetemp extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bgImage, -3, -3, this);
        }
	}
	
	//������������������
	class isborrowerListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(checkborrower.isSelected())
			{
				isborrower = true;
			}
			else
			{
				isborrower = false;
			}
		}
	}
	
	//������������������
	class isadminListener implements ItemListener{
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(checkadmin.isSelected())
			{
				isadmin = true;
			}
			else
			{
				isadmin = false;
			}
		}
	}
		
	//������������������
	class loginListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isadmin)
				{  
					Administrator check = AdministratorList.checkIsAdmin(username.getText(), password.getText());
					if(check != null)
					{
						dispose();
						try {		
							AdminThread go = new AdminThread(check);
							new Thread(go).start();
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "验证正确，服务器发生错误");
						}

					}
					else
					{
						JOptionPane.showMessageDialog(null,"用户名密码错误！");
						username.setText("");
						password.setText("");
					}
				}
				else if(isborrower)
				{
					Borrower check = BorrowerList.checkIsBorrower(username.getText(), password.getText());
					if(check != null)
					{
						dispose();
						BorrowerThread go = new BorrowerThread(check);
						new Thread(go).start();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "用户名密码错误！");
						username.setText("");
						password.setText("");
					}
				}
			}
	}
		
		
	 //������������������
	 class cancelListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		}
	 
	 //����������������������
	 class usernameListener implements MouseListener,KeyListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			username.setText("");
			a++;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(a == 0)
			username.setText("");
			a++;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
	 }

	 //����������������������
	 class passwordListener implements MouseListener,KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(b == 0)
				password.setText("");
			password.setEchoChar('*');
			b++;
			if (e.getKeyCode() == 10)
				/*����������������������
				 * ������������������������������������������ 
				 */
				login.doClick();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			password.setText("");
			password.setEchoChar('*');
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
	 }

}



		
	