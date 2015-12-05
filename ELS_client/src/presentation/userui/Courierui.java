package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class Courierui extends MainFrame{
	JPanel mainPanel = new JPanel();
	JButton OrderManage;
	JLabel UserName;
//	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
	}
	public Courierui(){
		OrderManage=new JButton();
		UserName=new JLabel();
//		layeredPane=getLayeredPane();
		
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setBounds(6,80,176,24);
		UserName.setText("快递员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		OrderManage.setBounds(0,110,180,30);
		OrderManage.setText("订单信息管理");
		OrderManage.setFont(font3);
		OrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OrderManage.setBackground(Color.WHITE);
		
//		layeredPane.add(UserName,new Integer(10), JLayeredPane.PALETTE_LAYER);
//		layeredPane.add(OrderManage,new Integer(10), JLayeredPane.PALETTE_LAYER);
		this.mainPanel.add(UserName);
		this.mainPanel.add(OrderManage);
//		System.out.println(layeredPane.getSize());
	}
}
