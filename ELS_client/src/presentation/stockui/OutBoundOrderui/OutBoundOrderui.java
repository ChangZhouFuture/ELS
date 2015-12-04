package presentation.stockui.OutBoundOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.userui.StockManagerui;

public class OutBoundOrderui extends JPanel{
	JLabel OutBoundOrder;
	JButton MakeOrder;
	JLabel TransportType;
	JRadioButton Plane;
	JRadioButton Train;
	JRadioButton Truck;
	ButtonGroup TransportTypeGroup;
	JLabel OrderId;
	JTextField OrderIdField;
	JLabel Destination;
	JTextField DestinationField;
	JList OrderType;
	
	public static void main(String[] args){
		StockManagerui ui=new StockManagerui();
		OutBoundOrderui uiPanel=new OutBoundOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OutBoundOrderui(){
		OutBoundOrder=new JLabel();
		MakeOrder=new JButton();
		TransportType=new JLabel();
		Plane=new JRadioButton();
		Train=new JRadioButton();
		Truck=new JRadioButton();
		TransportTypeGroup=new ButtonGroup();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		OutBoundOrder.setBounds(218,10,180,30);
		OutBoundOrder.setText("出库单信息");
		OutBoundOrder.setHorizontalAlignment(SwingConstants.CENTER);
		OutBoundOrder.setFont(font1);
		OutBoundOrder.setBackground(Color.WHITE);
		OutBoundOrder.setOpaque(true);
		
		TransportType.setBounds(40,50,100,24);
		TransportType.setText("装运形式：");
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
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(OutBoundOrder);
		this.add(MakeOrder);
		this.add(TransportType);
		this.add(Plane);
		this.add(Train);
		this.add(Truck);
		
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
