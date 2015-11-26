package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class Accountantui2 extends MainFrame{
	JButton Receival;
	JButton Payment;
	JButton StatisAnaly;
	JButton Operalog;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Accountantui2 ui=new Accountantui2();
	}
	public Accountantui2(){
		Receival=new JButton();
		Payment=new JButton();
		StatisAnaly=new JButton();
		Operalog=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("财务人员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		Receival.setBounds(2,120,180,30);
		Receival.setText("结算管理");
		Receival.setFont(font3);
		Receival.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Receival.setBackground(Color.WHITE);
		
		Payment.setBounds(2,150,180,30);
		Payment.setText("成本管理");
		Payment.setFont(font3);
		Payment.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Payment.setBackground(Color.WHITE);
		
		StatisAnaly.setBounds(2,180,180,30);
		StatisAnaly.setText("统计报表");
		StatisAnaly.setFont(font3);
		StatisAnaly.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StatisAnaly.setBackground(Color.WHITE);
		
		Operalog.setBounds(2,210,180,30);
		Operalog.setText("查询操作日志");
		Operalog.setFont(font3);
		Operalog.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Operalog.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(Receival,new Integer(10), 0);
		layeredPane.add(Payment,new Integer(10), 0);
		layeredPane.add(StatisAnaly,new Integer(10), 0);
		layeredPane.add(Operalog,new Integer(10), 0);
	}
}
