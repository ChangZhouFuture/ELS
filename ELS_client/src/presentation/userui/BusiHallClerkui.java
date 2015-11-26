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
	JButton ArrivalOrder4BusiHallManage;
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
		ArrivalOrder4BusiHallManage=new JButton();
		DeliveryManage=new JButton();
		VehicleManage=new JButton();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("营业厅业务员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		BusiLoad.setBounds(2,120,180,30);
		BusiLoad.setText("车辆装车管理");
		BusiLoad.setFont(font3);
		BusiLoad.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		BusiLoad.setBackground(Color.WHITE);
		
		DriverManage.setBounds(2,150,180,30);
		DriverManage.setText("司机信息管理");
		DriverManage.setFont(font3);
		DriverManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		DriverManage.setBackground(Color.WHITE);
		
		ReceOrderManage.setBounds(2,180,180,30);
		ReceOrderManage.setText("收款单管理");
		ReceOrderManage.setFont(font3);
		ReceOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		ReceOrderManage.setBackground(Color.WHITE);
		
		ArrivalOrder4BusiHallManage.setBounds(2,210,180,30);
		ArrivalOrder4BusiHallManage.setText("接收信息管理");
		ArrivalOrder4BusiHallManage.setFont(font3);
		ArrivalOrder4BusiHallManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		ArrivalOrder4BusiHallManage.setBackground(Color.WHITE);
		
		DeliveryManage.setBounds(2,240,180,30);
		DeliveryManage.setText("派件信息管理");
		DeliveryManage.setFont(font3);
		DeliveryManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		DeliveryManage.setBackground(Color.WHITE);
		
		VehicleManage.setBounds(2,270,180,30);
		VehicleManage.setText("车辆信息管理");
		VehicleManage.setFont(font3);
		VehicleManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		VehicleManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(BusiLoad,new Integer(10), 0);
		layeredPane.add(DriverManage,new Integer(10), 0);
		layeredPane.add(ReceOrderManage,new Integer(10), 0);
		layeredPane.add(ArrivalOrder4BusiHallManage,new Integer(10), 0);
		layeredPane.add(DeliveryManage,new Integer(10), 0);
		layeredPane.add(VehicleManage,new Integer(10), 0);
	}
}
