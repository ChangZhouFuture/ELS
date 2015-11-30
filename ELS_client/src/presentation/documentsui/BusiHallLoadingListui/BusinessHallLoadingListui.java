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
	JLabel BusiLoadOrder;
	JLabel BusiId;
	JTextField BusiIdField;
	JLabel MotorId;
	JTextField MotorIdField;
	JLabel Arrival;
	JTextField ArrivalField;
	JLabel VehicleId;
	JTextField VehicleIdField;
	JLabel JZY;
	JTextField JZYField;
	JLabel YYY;
	JTextField YYYField;
	JLabel Fare;
	JTextField FareField;
	JLabel OrderId;
	JTextField OrderIdField;
	JButton AddOrder;
	JTextArea OrderList;
	JScrollPane scroller;
	JButton MakeOrder;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		BusinessHallLoadingListui uiPanel=new BusinessHallLoadingListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public BusinessHallLoadingListui(){
		BusiLoadOrder=new JLabel();
		BusiId=new JLabel();
		BusiIdField=new JTextField();
		MotorId=new JLabel();
		MotorIdField=new JTextField();
		VehicleId=new JLabel();
		VehicleIdField=new JTextField();
		Arrival=new JLabel();
		ArrivalField=new JTextField();
		JZY=new JLabel();
		JZYField=new JTextField();
		YYY=new JLabel();
		YYYField=new JTextField();
		Fare=new JLabel();
		FareField=new JTextField();
		OrderId=new JLabel();
		OrderIdField=new JTextField();
		AddOrder=new JButton();
		OrderList=new JTextArea();
		MakeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		
		BusiLoadOrder.setBounds(218,10,180,30);
		BusiLoadOrder.setText("装车单信息");
		BusiLoadOrder.setHorizontalAlignment(SwingConstants.CENTER);
		BusiLoadOrder.setFont(font1);
		BusiLoadOrder.setBackground(Color.WHITE);
		BusiLoadOrder.setOpaque(true);
		
		BusiId.setBounds(40,50,100,24);
		BusiId.setText("营业厅编号：");
		BusiId.setFont(font2);
		BusiId.setBackground(Color.WHITE);
		BusiId.setOpaque(true);
		
		BusiIdField.setBounds(140,52,120,20);
		
		MotorId.setBounds(300,50,100,24);
		MotorId.setText("汽运编号：");
		MotorId.setFont(font2);
		MotorId.setBackground(Color.WHITE);
		MotorId.setOpaque(true);
		
		MotorIdField.setBounds(400,52,120,20);
		
		VehicleId.setBounds(40,80,100,24);
		VehicleId.setText("车辆代号：");
		VehicleId.setFont(font2);
		VehicleId.setBackground(Color.WHITE);
		VehicleId.setOpaque(true);
		
		VehicleIdField.setBounds(140,82,120,20);
		
		Arrival.setBounds(300,80,100,24);
		Arrival.setText("到达地：");
		Arrival.setFont(font2);
		Arrival.setBackground(Color.WHITE);
		Arrival.setOpaque(true);
		
		ArrivalField.setBounds(400,82,120,20);
		
		JZY.setBounds(40,110,100,24);
		JZY.setText("监装员：");
		JZY.setFont(font2);
		JZY.setBackground(Color.WHITE);
		JZY.setOpaque(true);
		
		JZYField.setBounds(140,112,120,20);
		
		YYY.setBounds(300,110,100,24);
		YYY.setText("押运员：");
		YYY.setFont(font2);
		YYY.setBackground(Color.WHITE);
		YYY.setOpaque(true);
		
		YYYField.setBounds(400,112,120,20);
		
		Fare.setBounds(40,140,100,24);
		Fare.setText("运费：");
		Fare.setFont(font2);
		Fare.setBackground(Color.WHITE);
		Fare.setOpaque(true);
		
		FareField.setBounds(140,142,120,20);
		FareField.setEditable(false);
		
		OrderId.setBounds(40,170,200,24);
		OrderId.setText("本次装箱所有订单条形码号：");
		OrderId.setFont(font2);
		OrderId.setBackground(Color.WHITE);
		OrderId.setOpaque(true);
		
		OrderIdField.setBounds(140,202,120,20);
		
		AddOrder.setBounds(280,200,70,24);
		AddOrder.setText("添加订单");
		AddOrder.setFont(font2);
		AddOrder.setBackground(Color.WHITE);
		AddOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		OrderList.setBounds(40,230,250,150);
		OrderList.setEnabled(false);
		OrderList.setFont(font2);
		OrderList.setBackground(Color.WHITE);
		OrderList.setWrapStyleWord(true);
		OrderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OrderList.setLineWrap(true);
		
		scroller=new JScrollPane(OrderList);
		scroller.setBounds(40,230,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(BusiLoadOrder);
		this.add(BusiId);
		this.add(BusiIdField);
		this.add(MotorId);
		this.add(MotorIdField);
		this.add(VehicleId);
		this.add(VehicleIdField);
		this.add(Arrival);
		this.add(ArrivalField);
		this.add(JZY);
		this.add(JZYField);
		this.add(YYY);
		this.add(YYYField);
		this.add(Fare);
		this.add(FareField);
		this.add(OrderId);
		this.add(OrderIdField);
		this.add(AddOrder);
		this.add(scroller);
		this.add(MakeOrder);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
