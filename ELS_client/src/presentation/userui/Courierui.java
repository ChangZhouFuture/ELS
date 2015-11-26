package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

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
		
		UserName.setBounds(2,96,172,24);
		UserName.setText("���Ա��"+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,18);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		OrderManage.setBounds(0,120,176,30);
		OrderManage.setText("������Ϣ����");
		OrderManage.setFont(font2);
		OrderManage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		OrderManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(OrderManage,new Integer(10), 0);
	}
}
