/**
 * 
 */
package com.qinzhenning.BookLendSystem.GUI.BorrowerFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.qinzhenning.BookLendSystem.Borrower.*;

/**
 * @author qinzhenning
 * 时间：2012-7-6下午1:30:02
 * 文件：SeeMessage.java
 * 项目：BookLendSystem 
 * 包  ：com.qinzhenning.BookLendSystem.GUI.BorrowerFrame
 * 类  ：SeeMessage
 */
public class SeeMessage {
	private JLabel label_seeBookToDate,label_askBook,label_askBookCome;
	private JPanel panel;
	private JTextArea text_seeBookToDate,text_askBook,text_askBookCome;
	private JScrollPane scrollOne,scrollTwo,scrollThree;
	
//创建界面
	public void go(Borrower borrower){
		panel = new JPanel();
		panel.setBounds(150, 105, 800, 560);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		
		text_seeBookToDate = new JTextArea(borrower.seeMessage_BookToDate());
		text_seeBookToDate.setEditable(false);
		scrollOne = new JScrollPane(text_seeBookToDate);
		scrollOne.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollOne.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		scrollOne.setBounds(60, 60, 600, 200);
		label_seeBookToDate = new JLabel("图 书 到 期 消 息");
		label_seeBookToDate.setFont(new Font("黑体",Font.BOLD,15));
		label_seeBookToDate.setBounds(280, 22, 230, 30);
		panel.add(label_seeBookToDate);
		if(borrower instanceof Teacher)
		{
			text_askBookCome = new JTextArea(((Teacher) borrower).seeMessage_askBookCome());
			text_askBookCome.setEditable(false);
			label_askBookCome = new JLabel("图 书 到 馆 通 知");
			label_askBookCome.setFont(new Font("黑体",Font.BOLD,15));
			label_askBookCome.setBounds(280, 282, 230, 30);
			panel.add(label_askBookCome);
			scrollTwo = new JScrollPane(text_askBookCome);
			scrollTwo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollTwo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			scrollTwo.setBounds(60, 320, 600, 200);
			panel.add(scrollTwo);
		}
		else
		{
			text_askBook = new JTextArea(borrower.seeMessage_AskBook());
			text_askBook.setEditable(false);
			label_askBook = new JLabel("图 书 被 请 求 通 知");
			label_askBook.setFont(new Font("黑体",Font.BOLD,15));
			label_askBook.setBounds(280, 282, 230, 30);
			panel.add(label_askBook);
			scrollThree = new JScrollPane(text_askBook);
			scrollThree.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollThree.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			scrollThree.setBounds(60, 320, 600, 200);
			panel.add(scrollThree);
		}
		panel.add(scrollOne);
		
	}
//获取面板	
	public JPanel getPanel(){
		return panel;
	}
	
}
