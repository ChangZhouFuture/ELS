package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class BusiHallClerkui extends MainFrame{
	JButton BusiLoad;
	JButton DriverManage;
	JButton ReceOrderManage;
	JButton BusiHallArrivalOrderManage;
	JButton DeliveryManage;
	JButton VehicleManage;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
	}
	public BusiHallClerkui(){
		BusiLoad=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		DriverManage=new JButton();
		ReceOrderManage=new JButton();
		BusiHallArrivalOrderManage=new JButton();
		DeliveryManage=new JButton();
		VehicleManage=new JButton();
		
		UserName.setBounds(6,106,176,24);
		UserName.setText("营业厅业务员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		BusiLoad.setBounds(4,130,180,30);
		BusiLoad.setText("车辆装车管理");
		BusiLoad.setFont(font3);
		BusiLoad.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		BusiLoad.setBackground(Color.WHITE);
		
		DriverManage.setBounds(4,160,180,30);
		DriverManage.setText("司机信息管理");
		DriverManage.setFont(font3);
		DriverManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		DriverManage.setBackground(Color.WHITE);
		
		ReceOrderManage.setBounds(4,190,180,30);
		ReceOrderManage.setText("收款单管理");
		ReceOrderManage.setFont(font3);
		ReceOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		ReceOrderManage.setBackground(Color.WHITE);
		
		BusiHallArrivalOrderManage.setBounds(4,220,180,30);
		BusiHallArrivalOrderManage.setText("接收信息管理");
		BusiHallArrivalOrderManage.setFont(font3);
		BusiHallArrivalOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		BusiHallArrivalOrderManage.setBackground(Color.WHITE);
		
		DeliveryManage.setBounds(4,250,180,30);
		DeliveryManage.setText("派件信息管理");
		DeliveryManage.setFont(font3);
		DeliveryManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		DeliveryManage.setBackground(Color.WHITE);
		
		VehicleManage.setBounds(4,280,180,30);
		VehicleManage.setText("车辆信息管理");
		VehicleManage.setFont(font3);
		VehicleManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		VehicleManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(BusiLoad,new Integer(10), 0);
		layeredPane.add(DriverManage,new Integer(10), 0);
		layeredPane.add(ReceOrderManage,new Integer(10), 0);
		layeredPane.add(BusiHallArrivalOrderManage,new Integer(10), 0);
		layeredPane.add(DeliveryManage,new Integer(10), 0);
		layeredPane.add(VehicleManage,new Integer(10), 0);
	}
}
