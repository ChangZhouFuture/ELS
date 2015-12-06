package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import bean.JavaBean1;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.userui.Courierui;
import vo.orderVO.OrderVO;

public class CourierController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Courierui courierui;
	OrderListui orderListui;
	Orderui orderui;
	Orderblservice orderblservice;
	JavaBean1 javaBean1;
	OrderVO orderVO;
	
	public CourierController(){
		courierui = new Courierui();
		orderListui = new OrderListui();
		orderListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(orderListui);
		JLayeredPane layeredPane = courierui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inCourierui();
		inOrderListui();
	}
	public void inCourierui() {
		courierui.orderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = new OrderListui();
				childPanel = orderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOrderListui();
			}
		});
	}
	public void inOrderListui() {
		orderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderui = new Orderui();
				childPanel = orderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOrderui();
			}
		});
		orderListui.findById.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderui = new Orderui();
				childPanel = orderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				try {
					javaBean1=orderblservice.inquireA(orderListui.idField.getText());
					orderVO=(OrderVO)javaBean1.getObject();
					
					orderui.senderNameField.setText(orderVO.getSenderName());
					orderui.senderNameField.setEditable(false);
					
					orderui.senderAddressField.setText(orderVO.getSenderAdd());
					orderui.senderAddressField.setEditable(false);
					
					orderui.senderCompanyField.setText(orderVO.getSenderCompany());
					orderui.senderCompanyField.setEditable(false);
					
					orderui.senderPhoneField.setText(orderVO.getSenderPhoneNumber());
					orderui.senderPhoneField.setEditable(false);
					
					orderui.receiverNameField.setText(orderVO.getAddresseeName());
					orderui.receiverNameField.setEditable(false);
					
					orderui.receiverAddressField.setText(orderVO.getAddresseeAdd());
					orderui.receiverAddressField.setEditable(false);
					
					orderui.receiverCompanyField.setText(orderVO.getAddresseeCompany());
					orderui.receiverCompanyField.setEditable(false);
					
					orderui.receiverPhoneField.setText(orderVO.getAddresseePhoneNumber());
					orderui.receiverPhoneField.setEditable(false);
					
					orderui.goodNumField.setText(String.valueOf(orderVO.getNumOfGoods()));
					orderui.goodNumField.setEditable(false);
					
					orderui.goodNameField.setText(orderVO.getGoodsName());
					orderui.goodNameField.setEditable(false);
					
					orderui.goodWeightField.setText(String.valueOf(orderVO.getWeight()));
					orderui.goodWeightField.setEditable(false);
					
					orderui.goodVolumeField.setText(String.valueOf(orderVO.getSize()));
					orderui.goodVolumeField.setEditable(false);
					
					orderui.carriageField.setText(String.valueOf(orderVO.getTotalCost()));
					orderui.carriageField.setEditable(false);
					
					orderui.actualReceiverField.setText(orderVO.getTrueAddressee());
					orderui.actualReceiverField.setEditable(false);
					
					orderui.expectedArrivalDateField.setText(orderVO.getExpectedArrivalDate());
					orderui.expectedArrivalDateField.setEditable(false);
					
					orderui.carriageField.setText(String.valueOf(orderVO.getTotalCost()));
					orderui.carriageField.setEditable(false);
					
					if(orderVO.getTrueAddressee()!=null){
						orderui.actualReceiver.setVisible(true);
						orderui.actualReceiverField.setText(String.valueOf(orderVO.getTrueAddressee()));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public void inOrderui() {
		
	}
	public static void main(String[] args) {
		CourierController courierController = new CourierController();
	}
}

