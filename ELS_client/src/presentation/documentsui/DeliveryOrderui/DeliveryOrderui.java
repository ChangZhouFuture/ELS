package presentation.documentsui.DeliveryOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;

public class DeliveryOrderui extends ParentDocuments{
	JLabel DeliveryOrder;
	JLabel Courier;
	JLabel Order;
	JTextField Courierid;
	JTextField Orderid;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		DeliveryOrderui uiPanel=new DeliveryOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public DeliveryOrderui(){
		DeliveryOrder=new JLabel();
		Order=new JLabel();
		Courier=new JLabel();
		Courierid=new JTextField();
		Orderid=new JTextField();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		DeliveryOrder.setBounds(218,10,180,30);
		DeliveryOrder.setText("派件单信息");
		DeliveryOrder.setFont(font1);
		DeliveryOrder.setBackground(Color.WHITE);
		DeliveryOrder.setOpaque(true);
		
		Courier.setBounds(40,50,70,24);
		Courier.setText("派送员：");
		Courier.setFont(font2);
		Courier.setBackground(Color.WHITE);
		Courier.setOpaque(true);
		
		Courierid.setBounds(110,52,150,20);
		
		Order.setBounds(40,80,180,24);
		Order.setText("托运订单条形码号：");
		Order.setFont(font2);
		Order.setBackground(Color.WHITE);
		Order.setOpaque(true);
		
		Orderid.setBounds(110,112,150,20);
		
		this.add(DeliveryOrder);
		this.add(Courier);
		this.add(Order);
		this.add(Courierid);
		this.add(Orderid);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
