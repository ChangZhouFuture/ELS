package presentation.documentsui.DeliveryOrderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.Refreshable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.DeliveryOrderVO;

public class DeliveryOrderui extends ParentDocuments{
	public JLabel deliveryOrder;
	public JLabel courier;
	public JLabel order;
	public JTextField courierid;
	public JTextField orderid;
	DeliveryOrderblservice deliveryOrderblservice;
	DeliveryOrderVO deliveryOrderVO;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		DeliveryOrderui uiPanel=new DeliveryOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public DeliveryOrderui(){
		deliveryOrder=new JLabel();
		order=new JLabel();
		courier=new JLabel();
		courierid=new JTextField();
		orderid=new JTextField();
		deliveryOrderVO=new DeliveryOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		deliveryOrder.setBounds(218,10,180,30);
		deliveryOrder.setText("派件单信息");
		deliveryOrder.setFont(font1);
		deliveryOrder.setBackground(Color.WHITE);
		deliveryOrder.setOpaque(true);
		
		courier.setBounds(40,50,70,24);
		courier.setText("派送员：");
		courier.setFont(font2);
		courier.setBackground(Color.WHITE);
		courier.setOpaque(true);
		
		courierid.setBounds(110,52,150,20);
		
		order.setBounds(40,80,180,24);
		order.setText("托运订单条形码号：");
		order.setFont(font2);
		order.setBackground(Color.WHITE);
		order.setOpaque(true);
		
		orderid.setBounds(110,112,150,20);
		
		makeOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				deliveryOrderblservice=new DeliveryOrder();
				deliveryOrderVO.setDeliverier(courierid.getText());
				deliveryOrderVO.setOrderID(orderid.getText());
				javaBean1=deliveryOrderblservice.addDeliveryOrder(deliveryOrderVO);
				deliveryOrderVO=(DeliveryOrderVO)javaBean1.getObject();
				docmID.setText(deliveryOrderVO.getID());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				deliveryOrderblservice=new DeliveryOrder();
				deliveryOrderVO.setDeliverier(courierid.getText());
				deliveryOrderVO.setOrderID(orderid.getText());
				modifyOrder.setEnabled(false);
				deliveryOrderblservice.modify(deliveryOrderVO);
			}
		});
		
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(deliveryOrder);
		this.add(courier);
		this.add(order);
		this.add(courierid);
		this.add(orderid);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void refresh(){
		courierid.setEditable(false);
		orderid.setEditable(false);
		
		courierid.setBackground(Color.white);
		orderid.setBackground(Color.white);
		
		courierid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderid.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
	}
	public void modifying() {
		courierid.setEditable(true);
		orderid.setEditable(true);
		
		courierid.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderid.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
