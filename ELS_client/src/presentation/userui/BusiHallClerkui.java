package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class BusiHallClerkui extends MainFrame{
	public JButton busiLoad;
	public JButton driverManage;
	public JButton receOrderManage;
	public JButton busiHallArrivalOrderManage;
	public JButton deliveryManage;
	public JButton vehicleManage;
	public JLabel userName;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
	}
	public BusiHallClerkui(){
		busiLoad=new JButton();
		userName=new JLabel();
		driverManage=new JButton();
		receOrderManage=new JButton();
		busiHallArrivalOrderManage=new JButton();
		deliveryManage=new JButton();
		vehicleManage=new JButton();
		
		userName.setBounds(2,76,176,24);
		userName.setText("营业厅业务员："+Loginui.name);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		busiLoad.setBounds(0,100,180,30);
		busiLoad.setText("装车单管理");
		busiLoad.setFont(font3);
		busiLoad.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		busiLoad.setBackground(Color.WHITE);
		
		driverManage.setBounds(0,220,180,30);
		driverManage.setText("司机信息管理");
		driverManage.setFont(font3);
		driverManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		driverManage.setBackground(Color.WHITE);
		
		receOrderManage.setBounds(0,160,180,30);
		receOrderManage.setText("收款单管理");
		receOrderManage.setFont(font3);
		receOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receOrderManage.setBackground(Color.WHITE);
		
		busiHallArrivalOrderManage.setBounds(0,190,180,30);
		busiHallArrivalOrderManage.setText("到达单管理");
		busiHallArrivalOrderManage.setFont(font3);
		busiHallArrivalOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		busiHallArrivalOrderManage.setBackground(Color.WHITE);
		
		deliveryManage.setBounds(0,130,180,30);
		deliveryManage.setText("派件单管理");
		deliveryManage.setFont(font3);
		deliveryManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		deliveryManage.setBackground(Color.WHITE);
		
		vehicleManage.setBounds(0,250,180,30);
		vehicleManage.setText("车辆信息管理");
		vehicleManage.setFont(font3);
		vehicleManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		vehicleManage.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(busiLoad);
		this.left.add(driverManage);
		this.left.add(receOrderManage);
		this.left.add(busiHallArrivalOrderManage);
		this.left.add(deliveryManage);
		this.left.add(vehicleManage);
	}
}
