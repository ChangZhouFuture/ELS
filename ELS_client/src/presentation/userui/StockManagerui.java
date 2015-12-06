package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class StockManagerui extends MainFrame{
	public JButton outBoundManage;
	public JButton storageManage;
	public JButton stockCheck;
	public JButton stockCount;
	public JLabel userName;
	
	public static void main(String[] args){
		StockManagerui ui=new StockManagerui();
	}
	public StockManagerui(){
		storageManage=new JButton();
		userName=new JLabel();
		outBoundManage=new JButton();
		stockCheck=new JButton();
		stockCount=new JButton();
		
		userName.setBounds(6,106,176,24);
		userName.setText("��������Ա��"+"***");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		storageManage.setBounds(4,130,180,30);
		storageManage.setText("������");
		storageManage.setFont(font3);
		storageManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		storageManage.setBackground(Color.WHITE);
		
		outBoundManage.setBounds(4,160,180,30);
		outBoundManage.setText("�������");
		outBoundManage.setFont(font3);
		outBoundManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		outBoundManage.setBackground(Color.WHITE);
		
		stockCheck.setBounds(4,190,180,30);
		stockCheck.setText("���鿴");
		stockCheck.setFont(font3);
		stockCheck.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		stockCheck.setBackground(Color.WHITE);
		
		stockCount.setBounds(4,220,180,30);
		stockCount.setText("����̵�");
		stockCount.setFont(font3);
		stockCount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		stockCount.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(storageManage);
		this.left.add(outBoundManage);
		this.left.add(stockCheck);
		this.left.add(stockCount);
	}
}
