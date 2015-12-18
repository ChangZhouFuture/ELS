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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import presentation.reuse.ParentDocuments;
import presentation.userui.TranCenClerkui;

public class TransferOrderui extends ParentDocuments{
	public JLabel transferOrder;
	public JLabel transportType;
	public JRadioButton plane;
	public JRadioButton train;
	public JRadioButton truck;
	public ButtonGroup transportTypeGroup;
	public JLabel transferOrderId;
	public JTextField transferOrderIdField;
	public JLabel departure;
	public JTextField departureField;
	public JLabel arrival;
	public JTextField arrivalField;
	public JLabel jZY;
	public JTextField jZYField;
	public JLabel yYY;
	public JTextField yYYField;
	public JLabel transportNum;
	public JTextField transportNumField;
	public JLabel containerId;
	public JTextField containerIdField;
	public JLabel carriage;
	public JTextField carriageField;
	public JLabel orderId;
	public JTextField orderIdField;
	public JButton addOrder;
	public JTextArea orderList;
	public JScrollPane scroller;
	
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
		carriage=new JLabel();
		carriageField=new JTextField();
		orderId=new JLabel();
		orderIdField=new JTextField();
		addOrder=new JButton();
		orderList=new JTextArea();
		
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
		
		arrival.setBounds(300,110,100,24);
		arrival.setText("到达地：");
		arrival.setFont(font2);
		arrival.setBackground(Color.WHITE);
		arrival.setOpaque(true);
		
		arrivalField.setBounds(400,112,150,20);
		
		jZY.setBounds(40,140,100,24);
		jZY.setText("监装员：");
		jZY.setFont(font2);
		jZY.setBackground(Color.WHITE);
		jZY.setOpaque(true);
		
		jZYField.setBounds(140,142,150,20);
		
		yYY.setBounds(300,140,100,24);
		yYY.setText("押运员：");
		yYY.setFont(font2);
		yYY.setBackground(Color.WHITE);
		yYY.setOpaque(true);
		
		yYYField.setBounds(400,142,150,20);
		
		transportNum.setBounds(40,170,100,24);
		transportNum.setText("航班号：");
		transportNum.setFont(font2);
		transportNum.setBackground(Color.WHITE);
		transportNum.setOpaque(true);
		
		transportNumField.setBounds(140,172,150,20);
		
		containerId.setBounds(300,170,100,24);
		containerId.setText("货柜号：");
		containerId.setFont(font2);
		containerId.setBackground(Color.WHITE);
		containerId.setOpaque(true);
		
		containerIdField.setBounds(400,172,150,20);
		
		carriage.setBounds(40,200,80,24);
		carriage.setText("运费：");
		carriage.setFont(font2);
		carriage.setBackground(Color.WHITE);
		carriage.setOpaque(true);
		
		carriageField.setBounds(200,202,80,20);
		carriageField.setEditable(false);
		carriageField.setBackground(Color.WHITE);
		carriageField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		orderId.setBounds(40,230,200,24);
		orderId.setText("本次装箱所有订单条形码号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		orderId.setOpaque(true);
		
		orderIdField.setBounds(240,232,120,20);
		
		addOrder.setBounds(400,230,70,24);
		addOrder.setText("添加订单");
		addOrder.setFont(font2);
		addOrder.setBackground(Color.WHITE);
		addOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		orderList.setBounds(40,260,250,150);
		orderList.setEnabled(false);
		orderList.setFont(font2);
		orderList.setBackground(Color.WHITE);
		orderList.setWrapStyleWord(true);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderList.setLineWrap(true);
		
		scroller=new JScrollPane(orderList);
		scroller.setBounds(40,260,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
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
		this.add(carriage);
		this.add(carriageField);
		this.add(orderId);
		this.add(orderIdField);
		this.add(addOrder);
		this.add(scroller);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
