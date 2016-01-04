package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class GeneralManagerui extends MainFrame{
	public JButton agencyManage;
	public JButton stuffManage;
	public JButton statisAnaly;
	public JButton approdocm;
	public JButton operalog;
	public JButton wageStrategy;
	public JLabel userName;

	public GeneralManagerui(){
		agencyManage=new JButton();
		stuffManage=new JButton();
		statisAnaly=new JButton();
		approdocm=new JButton();
		operalog=new JButton();
		wageStrategy = new JButton();
		userName=new JLabel();
		
		userName.setBounds(2,76,176,24);
		userName.setText("总经理："+Loginui.name);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		agencyManage.setBounds(0,190,180,30);
		agencyManage.setText("机构管理");
		agencyManage.setFont(font3);
		agencyManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		agencyManage.setBackground(Color.WHITE);
		
		stuffManage.setBounds(0,160,180,30);
		stuffManage.setText("人员管理");
		stuffManage.setFont(font3);
		stuffManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		stuffManage.setBackground(Color.WHITE);
		
		statisAnaly.setBounds(0,130,180,30);
		statisAnaly.setText("统计报表");
		statisAnaly.setFont(font3);
		statisAnaly.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		statisAnaly.setBackground(Color.WHITE);
		
		approdocm.setBounds(0,100,180,30);
		approdocm.setText("审批单据");
		approdocm.setFont(font3);
		approdocm.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		approdocm.setBackground(Color.WHITE);
		
		operalog.setBounds(0,250,180,30);
		operalog.setText("查询操作日志");
		operalog.setFont(font3);
		operalog.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		operalog.setBackground(Color.WHITE);
		
		wageStrategy.setBounds(0,220,180,30);
		wageStrategy.setText("工资策略管理");
		wageStrategy.setFont(font3);
		wageStrategy.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		wageStrategy.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(agencyManage);
		this.left.add(stuffManage);
		this.left.add(statisAnaly);
		this.left.add(approdocm);
		this.left.add(operalog);
		this.left.add(wageStrategy);
	}
}
