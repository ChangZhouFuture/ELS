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

import presentation.userui.BusiHallClerkui;

public class DeliveryOrderui extends JPanel{
	JLabel DeliveryOrder;
	JLabel Courier;
	JLabel Order;
	JTextField Courierid;
	JTextField Orderid;
	JButton MakeOrder;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		DeliveryOrderui uiPanel=new DeliveryOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public DeliveryOrderui(){
		DeliveryOrder=new JLabel();
		Order=new JLabel();
		MakeOrder=new JButton();
		Courier=new JLabel();
		Courierid=new JTextField();
		Orderid=new JTextField();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		DeliveryOrder.setBounds(219,10,180,30);
		DeliveryOrder.setText("派件单信息");
		DeliveryOrder.setFont(font1);
		DeliveryOrder.setBackground(Color.WHITE);
		DeliveryOrder.setOpaque(true);
		
		Courier.setBounds(40,50,70,30);
		Courier.setText("派送员：");
		Courier.setFont(font2);
		Courier.setBackground(Color.WHITE);
		Courier.setOpaque(true);
		
		Courierid.setBounds(110,50,150,24);
		
		Order.setBounds(40,80,180,30);
		Order.setText("托运订单条形码号：");
		Order.setFont(font2);
		Order.setBackground(Color.WHITE);
		Order.setOpaque(true);
		
		Orderid.setBounds(110,110,150,24);
		
		MakeOrder.setBounds(219,454,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(DeliveryOrder);
		this.add(Courier);
		this.add(Order);
		this.add(Courierid);
		this.add(Orderid);
		this.add(MakeOrder);
		setLocation(182,24);
		this.setSize(618,502);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
