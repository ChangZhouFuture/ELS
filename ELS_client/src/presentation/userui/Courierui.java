package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class Courierui extends MainFrame{
	public JPanel mainPanel = new JPanel();
	public JButton orderManage;
	public JLabel userName;
	
	public Courierui(){
		orderManage=new JButton();
		userName=new JLabel();
		
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setBounds(2,80,176,24);
		userName.setText("快递员："+Loginui.name);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		orderManage.setBounds(0,110,180,30);
		orderManage.setText("订单信息管理");
		orderManage.setFont(font3);
		orderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderManage.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(orderManage);
	}
}
