package presentation.inforManagementui.Vehiclesui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;

public class Vehiclesui extends JPanel{
	public JLabel vehicles;
	public JLabel area;
	public JLabel city;
	public JLabel region;
	public JLabel plateNum;
	public JLabel serviceTime;
	public JLabel approState;
	public JTextField cityField;
	public JTextField regionField;
	public JTextField plateNumField;
	public JTextField serviceTimeField;
	public JButton makeOrder;
	public JButton modify;
	public JButton modifyOrder;
	public JButton delete;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		Vehiclesui uiPanel=new Vehiclesui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public Vehiclesui(){
		vehicles=new JLabel();
		area=new JLabel();
		city=new JLabel();
		region=new JLabel();
		plateNum=new JLabel();
		serviceTime=new JLabel();
		cityField=new JTextField();
		regionField=new JTextField();
		plateNumField=new JTextField();
		serviceTimeField=new JTextField();
		makeOrder=new JButton();
		modify=new JButton();
		modifyOrder=new JButton();
		delete=new JButton();
		approState=new JLabel();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		vehicles.setBounds(218,10,180,30);
		vehicles.setText("车辆信息");
		vehicles.setHorizontalAlignment(SwingConstants.CENTER);
		vehicles.setFont(font1);
		vehicles.setBackground(Color.WHITE);
		vehicles.setOpaque(true);
		
		plateNum.setBounds(40,50,60,24);
		plateNum.setText("车牌号：");
		plateNum.setFont(font2);
		plateNum.setBackground(Color.WHITE);
		plateNum.setOpaque(true);
		
		plateNumField.setBounds(110,52,80,20);
		
		area.setBounds(40,80,60,24);
		area.setText("地区：");
		area.setFont(font2);
		area.setBackground(Color.WHITE);
		area.setOpaque(true);
		
		cityField.setBounds(110,82,80,20);
		
		city.setBounds(190,80,24,24);
		city.setText("市");
		city.setFont(font2);
		city.setBackground(Color.WHITE);
		city.setOpaque(true);
		
		regionField.setBounds(220,82,80,20);
		
		region.setBounds(300,80,24,24);
		region.setText("区");
		region.setFont(font2);
		region.setBackground(Color.WHITE);
		region.setOpaque(true);
		
		serviceTime.setBounds(40,50,60,24);
		serviceTime.setText("服役时间：");
		serviceTime.setFont(font2);
		serviceTime.setBackground(Color.WHITE);
		serviceTime.setOpaque(true);
		
		serviceTimeField.setBounds(110,52,80,20);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		modifyOrder.setBounds(260,442,96,30);
		modifyOrder.setText("确认修改");
		modifyOrder.setFont(font1);
		modifyOrder.setBackground(Color.WHITE);
		modifyOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modifyOrder.setVisible(false);
		
		approState.setBounds(500,445,90,24);
		approState.setFont(font2);
		approState.setBackground(Color.WHITE);
		approState.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setBounds(0,0,24,24);
		modify.setIcon(Images.MODIFY_IMAGE);;
		modify.setBackground(Color.WHITE);
		modify.setVisible(false);
		
		delete.setBounds(24,0,24,24);
		delete.setIcon(Images.DELETE_IMAGE);;
		delete.setBackground(Color.WHITE);
		delete.setVisible(false);
		
		this.add(vehicles);
		this.add(area);
		this.add(city);
		this.add(region);
		this.add(plateNum);
		this.add(serviceTime);
		this.add(cityField);
		this.add(regionField);
		this.add(plateNumField);
		this.add(serviceTimeField);
		this.add(makeOrder);
		this.add(modify);
		this.add(modifyOrder);
		this.add(delete);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
