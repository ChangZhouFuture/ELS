package presentation.documentsui.TransferOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.userui.TranCenClerkui;

public class TransferOrderui extends JPanel{
	JLabel transferOrder;
	JButton makeOrder;
	JLabel transportType;
	JRadioButton plane;
	JRadioButton train;
	JRadioButton truck;
	ButtonGroup transportTypeGroup;
	JLabel transferOrderId;
	JTextField transferOrderIdField;
	JLabel departure;
	JTextField departureField;
	JLabel arrival;
	JTextField arrivalField;
	JLabel jZY;
	JTextField jZYField;
	JLabel yYY;
	JTextField yYYField;
	JLabel transportNum;
	JTextField transportNumField;
	JLabel containerId;
	JTextField containerIdField;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
		TransferOrderui uiPanel=new TransferOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public TransferOrderui(){
		transferOrder=new JLabel();
		makeOrder=new JButton();
		transportType=new JLabel();
		plane=new JRadioButton();
		train=new JRadioButton();
		truck=new JRadioButton();
		transportTypeGroup=new ButtonGroup();
		transferOrderId=new JLabel();
		transferOrderIdField=new JTextField();
		departure=new JLabel();
		departureField=new JTextField();
		arrival=new JLabel();
		arrivalField=new JTextField();
		jZY=new JLabel();
		jZYField=new JTextField();
		yYY=new JLabel();
		yYYField=new JTextField();
		transportNum=new JLabel();
		transportNumField=new JTextField();
		containerId=new JLabel();
		containerIdField=new JTextField();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		transferOrder.setBounds(218,10,180,30);
		transferOrder.setText("中转单信息");
		transferOrder.setHorizontalAlignment(SwingConstants.CENTER);
		transferOrder.setFont(font1);
		transferOrder.setBackground(Color.WHITE);
		transferOrder.setOpaque(true);
		
		transportType.setBounds(40,50,100,24);
		transportType.setText("交通方式：");
		transportType.setFont(font2);
		transportType.setBackground(Color.WHITE);
		transportType.setOpaque(true);
		
		plane.setBounds(140,50,100,24);
		plane.setText("飞机");
		plane.setFont(font2);
		plane.setBackground(Color.WHITE);
		
		train.setBounds(240,50,100,24);
		train.setText("铁路");
		train.setFont(font2);
		train.setBackground(Color.WHITE);
		
		truck.setBounds(340,50,100,24);
		truck.setText("公路");
		truck.setFont(font2);
		truck.setBackground(Color.WHITE); 

		transportTypeGroup.add(plane);
		transportTypeGroup.add(train);
		transportTypeGroup.add(truck);
		
		transferOrderId.setBounds(40,80,100,24);
		transferOrderId.setText("中转单编号：");
		transferOrderId.setFont(font2);
		transferOrderId.setBackground(Color.WHITE);
		transferOrderId.setOpaque(true);
		
		transferOrderIdField.setBounds(140,82,150,20);
		
		departure.setBounds(40,110,100,24);
		departure.setText("出发地：");
		departure.setFont(font2);
		departure.setBackground(Color.WHITE);
		departure.setOpaque(true);
		
		departureField.setBounds(140,112,150,20);
		
		arrival.setBounds(40,140,100,24);
		arrival.setText("到达地：");
		arrival.setFont(font2);
		arrival.setBackground(Color.WHITE);
		arrival.setOpaque(true);
		
		arrivalField.setBounds(140,142,150,20);
		
		jZY.setBounds(40,170,100,24);
		jZY.setText("监装员：");
		jZY.setFont(font2);
		jZY.setBackground(Color.WHITE);
		jZY.setOpaque(true);
		
		jZYField.setBounds(140,172,150,20);
		
		yYY.setBounds(40,200,100,24);
		yYY.setText("押运员：");
		yYY.setFont(font2);
		yYY.setBackground(Color.WHITE);
		yYY.setOpaque(true);
		
		yYYField.setBounds(140,202,150,20);
		
		transportNum.setBounds(40,230,100,24);
		transportNum.setText("航班号：");
		transportNum.setFont(font2);
		transportNum.setBackground(Color.WHITE);
		transportNum.setOpaque(true);
		
		transportNumField.setBounds(140,232,150,20);
		
		containerId.setBounds(40,260,100,24);
		containerId.setText("货柜号：");
		containerId.setFont(font2);
		containerId.setBackground(Color.WHITE);
		containerId.setOpaque(true);
		
		containerIdField.setBounds(140,262,150,20);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(transferOrder);
		this.add(makeOrder);
		this.add(transportType);
		this.add(plane);
		this.add(train);
		this.add(truck);
		this.add(transferOrderId);
		this.add(transferOrderIdField);
		this.add(departure);
		this.add(departureField);
		this.add(arrival);
		this.add(arrivalField);
		this.add(jZY);
		this.add(jZYField);
		this.add(yYY);
		this.add(yYYField);
		this.add(transportNum);
		this.add(transportNumField);
		this.add(containerId);
		this.add(containerIdField);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
