package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.userui.Courierui;

public class CourierController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Courierui courierui;
	OrderListui orderListui;
	Orderui orderui;
	
	public CourierController(){
		courierui = new Courierui();
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		JLayeredPane layeredPane = courierui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		intoOrderListui();
	}
	public void intoOrderListui() {
		courierui.orderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = new OrderListui();
				childPanel = orderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				intoOrderui();
			}
		});
	}
	public void intoOrderui() {
		orderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderui = new Orderui();
				childPanel = orderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				intoOrderListui();
			}
		});
	}
	public static void main(String[] args) {
		CourierController loginController = new CourierController();
	}
}

