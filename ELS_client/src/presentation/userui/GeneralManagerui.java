package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class GeneralManagerui extends MainFrame{
	JButton AgencyManage;
	JButton StuffManage;
	JButton StatisAnaly;
	JButton Approdocm;
	JButton Operalog;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		GeneralManagerui ui=new GeneralManagerui();
	}
	public GeneralManagerui(){
		AgencyManage=new JButton();
		StuffManage=new JButton();
		StatisAnaly=new JButton();
		Approdocm=new JButton();
		Operalog=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(6,106,176,24);
		UserName.setText("总经理："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		AgencyManage.setBounds(4,130,180,30);
		AgencyManage.setText("机构管理");
		AgencyManage.setFont(font3);
		AgencyManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		AgencyManage.setBackground(Color.WHITE);
		
		StuffManage.setBounds(4,160,180,30);
		StuffManage.setText("人员管理");
		StuffManage.setFont(font3);
		StuffManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StuffManage.setBackground(Color.WHITE);
		
		StatisAnaly.setBounds(4,190,180,30);
		StatisAnaly.setText("统计报表");
		StatisAnaly.setFont(font3);
		StatisAnaly.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StatisAnaly.setBackground(Color.WHITE);
		
		Approdocm.setBounds(4,220,180,30);
		Approdocm.setText("审批单据");
		Approdocm.setFont(font3);
		Approdocm.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Approdocm.setBackground(Color.WHITE);
		
		Operalog.setBounds(4,250,180,30);
		Operalog.setText("查询操作日志");
		Operalog.setFont(font3);
		Operalog.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Operalog.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(AgencyManage,new Integer(10), 0);
		layeredPane.add(StuffManage,new Integer(10), 0);
		layeredPane.add(StatisAnaly,new Integer(10), 0);
		layeredPane.add(Approdocm,new Integer(10), 0);
		layeredPane.add(Operalog,new Integer(10), 0);
	}
}
