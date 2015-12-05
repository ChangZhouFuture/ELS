package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.userui.Courierui;

public class ControllerTest {
	Courierui courierui;
	JPanel mainPanel;
	JPanel childPanel;
	OrderListui orderListui;
	Orderui orderui;
	
	public ControllerTest(){
		courierui = new Courierui();
		courierui.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(184, 40, 640, 490);
		mainPanel.setLayout(null);
		mainPanel.setOpaque(true);
		
		orderListui = new OrderListui();
		orderListui.setBounds(0, 0, 640, 490);
		orderListui.setOpaque(true);

		mainPanel.add(orderListui);
		courierui.getLayeredPane().add(mainPanel, 0);
		
		inOrderListui();
	}
	
	
	public void inOrderListui() {
		orderListui.jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderui = new Orderui();
				childPanel = orderui;
				Skip.skip(mainPanel, childPanel);
				inOrderui();
			}
		});
	}
	
	public void inOrderui() {
		orderui.MakeOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderListui = new OrderListui();
				childPanel = orderListui;
				Skip.skip(mainPanel, childPanel);
				inOrderListui();
			}
		});
	}
	
	public static void main(String[] args) {
		ControllerTest loginController = new ControllerTest();
	}
}
