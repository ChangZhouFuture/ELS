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
	JLabel TransferOrder;
	JButton MakeOrder;
	JLabel TransportType;
	JRadioButton Plane;
	JRadioButton Train;
	JRadioButton Truck;
	ButtonGroup TransportTypeGroup;
	JLabel TransferOrderId;
	JTextField TransferOrderIdField;
	JLabel Departure;
	JTextField DepartureField;
	JLabel Arrival;
	JTextField ArrivalField;
	JLabel JZY;
	JTextField JZYField;
	JLabel YYY;
	JTextField YYYField;
	JLabel TransportNum;
	JTextField TransportNumField;
	JLabel ContainerId;
	JTextField ContainerIdField;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
		TransferOrderui uiPanel=new TransferOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public TransferOrderui(){
		TransferOrder=new JLabel();
		MakeOrder=new JButton();
		TransportType=new JLabel();
		Plane=new JRadioButton();
		Train=new JRadioButton();
		Truck=new JRadioButton();
		TransportTypeGroup=new ButtonGroup();
		TransferOrderId=new JLabel();
		TransferOrderIdField=new JTextField();
		Departure=new JLabel();
		DepartureField=new JTextField();
		Arrival=new JLabel();
		ArrivalField=new JTextField();
		JZY=new JLabel();
		JZYField=new JTextField();
		YYY=new JLabel();
		YYYField=new JTextField();
		TransportNum=new JLabel();
		TransportNumField=new JTextField();
		ContainerId=new JLabel();
		ContainerIdField=new JTextField();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		TransferOrder.setBounds(218,10,180,30);
		TransferOrder.setText("中转单信息");
		TransferOrder.setHorizontalAlignment(SwingConstants.CENTER);
		TransferOrder.setFont(font1);
		TransferOrder.setBackground(Color.WHITE);
		TransferOrder.setOpaque(true);
		
		TransportType.setBounds(40,50,100,24);
		TransportType.setText("交通方式：");
		TransportType.setFont(font2);
		TransportType.setBackground(Color.WHITE);
		TransportType.setOpaque(true);
		
		Plane.setBounds(140,50,100,24);
		Plane.setText("飞机");
		Plane.setFont(font2);
		Plane.setBackground(Color.WHITE);
		
		Train.setBounds(240,50,100,24);
		Train.setText("铁路");
		Train.setFont(font2);
		Train.setBackground(Color.WHITE);
		
		Truck.setBounds(340,50,100,24);
		Truck.setText("公路");
		Truck.setFont(font2);
		Truck.setBackground(Color.WHITE); 

		TransportTypeGroup.add(Plane);
		TransportTypeGroup.add(Train);
		TransportTypeGroup.add(Truck);
		
		TransferOrderId.setBounds(40,80,100,24);
		TransferOrderId.setText("中转单编号：");
		TransferOrderId.setFont(font2);
		TransferOrderId.setBackground(Color.WHITE);
		TransferOrderId.setOpaque(true);
		
		TransferOrderIdField.setBounds(140,82,150,20);
		
		Departure.setBounds(40,110,100,24);
		Departure.setText("出发地：");
		Departure.setFont(font2);
		Departure.setBackground(Color.WHITE);
		Departure.setOpaque(true);
		
		DepartureField.setBounds(140,112,150,20);
		
		Arrival.setBounds(40,140,100,24);
		Arrival.setText("到达地：");
		Arrival.setFont(font2);
		Arrival.setBackground(Color.WHITE);
		Arrival.setOpaque(true);
		
		ArrivalField.setBounds(140,142,150,20);
		
		JZY.setBounds(40,170,100,24);
		JZY.setText("监装员：");
		JZY.setFont(font2);
		JZY.setBackground(Color.WHITE);
		JZY.setOpaque(true);
		
		JZYField.setBounds(140,172,150,20);
		
		YYY.setBounds(40,200,100,24);
		YYY.setText("押运员：");
		YYY.setFont(font2);
		YYY.setBackground(Color.WHITE);
		YYY.setOpaque(true);
		
		YYYField.setBounds(140,202,150,20);
		
		TransportNum.setBounds(40,230,100,24);
		TransportNum.setText("航班号：");
		TransportNum.setFont(font2);
		TransportNum.setBackground(Color.WHITE);
		TransportNum.setOpaque(true);
		
		TransportNumField.setBounds(140,232,150,20);
		
		ContainerId.setBounds(40,260,100,24);
		ContainerId.setText("货柜号：");
		ContainerId.setFont(font2);
		ContainerId.setBackground(Color.WHITE);
		ContainerId.setOpaque(true);
		
		ContainerIdField.setBounds(140,262,150,20);
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(TransferOrder);
		this.add(MakeOrder);
		this.add(TransportType);
		this.add(Plane);
		this.add(Train);
		this.add(Truck);
		this.add(TransferOrderId);
		this.add(TransferOrderIdField);
		this.add(Departure);
		this.add(DepartureField);
		this.add(Arrival);
		this.add(ArrivalField);
		this.add(JZY);
		this.add(JZYField);
		this.add(YYY);
		this.add(YYYField);
		this.add(TransportNum);
		this.add(TransportNumField);
		this.add(ContainerId);
		this.add(ContainerIdField);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
