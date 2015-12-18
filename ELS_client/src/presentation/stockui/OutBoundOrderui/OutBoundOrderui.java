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

import presentation.reuse.ParentDocuments;
import presentation.userui.StockManagerui;

public class OutBoundOrderui extends ParentDocuments{
	JLabel outBoundOrder;
	JLabel transportType;
	JRadioButton plane;
	JRadioButton train;
	JRadioButton truck;
	ButtonGroup transportTypeGroup;
	JLabel orderId;
	JTextField orderIdField;
	JLabel destination;
	JTextField destinationField;
	JList orderType;
	
	public static void main(String[] args){
		StockManagerui ui=new StockManagerui();
		OutBoundOrderui uiPanel=new OutBoundOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OutBoundOrderui(){
		outBoundOrder=new JLabel();
		makeOrder=new JButton();
		transportType=new JLabel();
		plane=new JRadioButton();
		train=new JRadioButton();
		truck=new JRadioButton();
		transportTypeGroup=new ButtonGroup();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		outBoundOrder.setBounds(218,10,180,30);
		outBoundOrder.setText("出库单信息");
		outBoundOrder.setHorizontalAlignment(SwingConstants.CENTER);
		outBoundOrder.setFont(font1);
		outBoundOrder.setBackground(Color.WHITE);
		outBoundOrder.setOpaque(true);
		
		transportType.setBounds(40,50,100,24);
		transportType.setText("装运形式：");
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
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(outBoundOrder);
		this.add(makeOrder);
		this.add(transportType);
		this.add(plane);
		this.add(train);
		this.add(truck);
		
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
