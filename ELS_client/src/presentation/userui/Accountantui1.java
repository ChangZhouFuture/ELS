package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class Accountantui1 extends MainFrame{
	JButton Receival;
	JButton Payment;
	JButton StatisAnaly;
	JButton BankAccount;
	JButton Operalog;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Accountantui1 ui=new Accountantui1();
	}
	public Accountantui1(){
		Receival=new JButton();
		Payment=new JButton();
		StatisAnaly=new JButton();
		BankAccount=new JButton();
		Operalog=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(6,106,176,24);
		UserName.setText("财务人员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		Receival.setBounds(4,130,180,30);
		Receival.setText("结算管理");
		Receival.setFont(font3);
		Receival.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Receival.setBackground(Color.WHITE);
		
		Payment.setBounds(4,160,180,30);
		Payment.setText("成本管理");
		Payment.setFont(font3);
		Payment.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Payment.setBackground(Color.WHITE);
		
		StatisAnaly.setBounds(4,190,180,30);
		StatisAnaly.setText("统计报表");
		StatisAnaly.setFont(font3);
		StatisAnaly.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StatisAnaly.setBackground(Color.WHITE);
		
		Operalog.setBounds(4,220,180,30);
		Operalog.setText("查询操作日志");
		Operalog.setFont(font3);
		Operalog.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Operalog.setBackground(Color.WHITE);
		
		BankAccount.setBounds(4,250,180,30);
		BankAccount.setText("银行账户管理");
		BankAccount.setFont(font3);
		BankAccount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		BankAccount.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(Receival,new Integer(10), 0);
		layeredPane.add(Payment,new Integer(10), 0);
		layeredPane.add(StatisAnaly,new Integer(10), 0);
		layeredPane.add(Operalog,new Integer(10), 0);
		layeredPane.add(BankAccount,new Integer(10), 0);
	}
}
