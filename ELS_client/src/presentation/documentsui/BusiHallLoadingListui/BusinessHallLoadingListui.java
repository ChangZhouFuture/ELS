package presentation.documentsui.BusiHallLoadingListui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import presentation.userui.BusiHallClerkui;

public class BusinessHallLoadingListui extends JPanel{
	public JLabel busiLoadOrder;
	public JLabel busiId;
	public JTextField busiIdField;
	public JLabel motorId;
	public JTextField motorIdField;
	public JLabel arrival;
	public JTextField arrivalField;
	public JLabel vehicleId;
	public JTextField vehicleIdField;
	public JLabel jZY;
	public JTextField jZYField;
	public JLabel yYY;
	public JTextField yYYField;
	public JLabel fare;
	public JTextField fareField;
	public JLabel orderId;
	public JTextField orderIdField;
	public JButton addOrder;
	public JTextArea orderList;
	public JScrollPane scroller;
	public JButton makeOrder;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		BusinessHallLoadingListui uiPanel=new BusinessHallLoadingListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public BusinessHallLoadingListui(){
		busiLoadOrder=new JLabel();
		busiId=new JLabel();
		busiIdField=new JTextField();
		motorId=new JLabel();
		motorIdField=new JTextField();
		vehicleId=new JLabel();
		vehicleIdField=new JTextField();
		arrival=new JLabel();
		arrivalField=new JTextField();
		jZY=new JLabel();
		jZYField=new JTextField();
		yYY=new JLabel();
		yYYField=new JTextField();
		fare=new JLabel();
		fareField=new JTextField();
		orderId=new JLabel();
		orderIdField=new JTextField();
		addOrder=new JButton();
		orderList=new JTextArea();
		makeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		
		busiLoadOrder.setBounds(218,10,180,30);
		busiLoadOrder.setText("装车单信息");
		busiLoadOrder.setHorizontalAlignment(SwingConstants.CENTER);
		busiLoadOrder.setFont(font1);
		busiLoadOrder.setBackground(Color.WHITE);
		busiLoadOrder.setOpaque(true);
		
		busiId.setBounds(40,50,100,24);
		busiId.setText("营业厅编号：");
		busiId.setFont(font2);
		busiId.setBackground(Color.WHITE);
		busiId.setOpaque(true);
		
		busiIdField.setBounds(140,52,120,20);
		
		motorId.setBounds(300,50,100,24);
		motorId.setText("汽运编号：");
		motorId.setFont(font2);
		motorId.setBackground(Color.WHITE);
		motorId.setOpaque(true);
		
		motorIdField.setBounds(400,52,120,20);
		
		vehicleId.setBounds(40,80,100,24);
		vehicleId.setText("车辆代号：");
		vehicleId.setFont(font2);
		vehicleId.setBackground(Color.WHITE);
		vehicleId.setOpaque(true);
		
		vehicleIdField.setBounds(140,82,120,20);
		
		arrival.setBounds(300,80,100,24);
		arrival.setText("到达地：");
		arrival.setFont(font2);
		arrival.setBackground(Color.WHITE);
		arrival.setOpaque(true);
		
		arrivalField.setBounds(400,82,120,20);
		
		jZY.setBounds(40,110,100,24);
		jZY.setText("监装员：");
		jZY.setFont(font2);
		jZY.setBackground(Color.WHITE);
		jZY.setOpaque(true);
		
		jZYField.setBounds(140,112,120,20);
		
		yYY.setBounds(300,110,100,24);
		yYY.setText("押运员：");
		yYY.setFont(font2);
		yYY.setBackground(Color.WHITE);
		yYY.setOpaque(true);
		
		yYYField.setBounds(400,112,120,20);
		
		fare.setBounds(40,140,100,24);
		fare.setText("运费：");
		fare.setFont(font2);
		fare.setBackground(Color.WHITE);
		fare.setOpaque(true);
		
		fareField.setBounds(140,142,120,20);
		fareField.setEditable(false);
		
		orderId.setBounds(40,170,200,24);
		orderId.setText("本次装箱所有订单条形码号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		orderId.setOpaque(true);
		
		orderIdField.setBounds(140,202,120,20);
		
		addOrder.setBounds(280,200,70,24);
		addOrder.setText("添加订单");
		addOrder.setFont(font2);
		addOrder.setBackground(Color.WHITE);
		addOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		orderList.setBounds(40,230,250,150);
		orderList.setEnabled(false);
		orderList.setFont(font2);
		orderList.setBackground(Color.WHITE);
		orderList.setWrapStyleWord(true);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderList.setLineWrap(true);
		
		scroller=new JScrollPane(orderList);
		scroller.setBounds(40,230,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(busiLoadOrder);
		this.add(busiId);
		this.add(busiIdField);
		this.add(motorId);
		this.add(motorIdField);
		this.add(vehicleId);
		this.add(vehicleIdField);
		this.add(arrival);
		this.add(arrivalField);
		this.add(jZY);
		this.add(jZYField);
		this.add(yYY);
		this.add(yYYField);
		this.add(fare);
		this.add(fareField);
		this.add(orderId);
		this.add(orderIdField);
		this.add(addOrder);
		this.add(scroller);
		this.add(makeOrder);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
