package presentation.userui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.MainFrame;
import presentation.orderui.Orderui;

public class Courierui extends MainFrame{
	JButton OrderManage;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
	}
	public Courierui(){
		OrderManage=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(6,106,176,24);
		UserName.setText("快递员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		OrderManage.setBounds(4,130,180,30);
		OrderManage.setText("订单信息管理");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		OrderManage.setFont(font3);
		OrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OrderManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(OrderManage,new Integer(10), 0);
		
	}
}
