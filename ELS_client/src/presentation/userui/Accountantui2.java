package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class Accountantui2 extends MainFrame{
	public JButton receival;
	public JButton payment;
	public JButton statisAnaly;
	public JButton operalog;
	public JLabel userName;
	
	public static void main(String[] args){
		Accountantui2 ui=new Accountantui2();
	}
	public Accountantui2(){
		receival=new JButton();
		payment=new JButton();
		statisAnaly=new JButton();
		operalog=new JButton();
		userName=new JLabel();
		
		userName.setBounds(2,76,176,24);
		userName.setText("财务人员："+"***");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		receival.setBounds(0,100,180,30);
		receival.setText("结算管理");
		receival.setFont(font3);
		receival.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receival.setBackground(Color.WHITE);
		
		payment.setBounds(0,130,180,30);
		payment.setText("成本管理");
		payment.setFont(font3);
		payment.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		payment.setBackground(Color.WHITE);
		
		statisAnaly.setBounds(0,160,180,30);
		statisAnaly.setText("统计报表");
		statisAnaly.setFont(font3);
		statisAnaly.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		statisAnaly.setBackground(Color.WHITE);
		
		operalog.setBounds(0,190,180,30);
		operalog.setText("查询操作日志");
		operalog.setFont(font3);
		operalog.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		operalog.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(receival);
		this.left.add(payment);
		this.left.add(statisAnaly);
		this.left.add(operalog);
	}
}
