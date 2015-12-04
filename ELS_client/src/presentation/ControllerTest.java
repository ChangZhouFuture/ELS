package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;

public class ControllerTest {
	JFrame jFrame;
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	OrderListui orderListui;
	Orderui orderui;
	
	public ControllerTest(){
		orderListui = new OrderListui();
		jFrame = new JFrame();
		jFrame.setBounds(200, 200, 100, 100);
		jFrame.setVisible(true);
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 500, 500);
		mainPanel.add(orderListui);
		jFrame.add(mainPanel);
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
