package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;

public class ControllerTest {
	JFrame jFrame;
	JPanel mainPanel = new JPanel();
	JPanel jPanel;
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
				jPanel = orderui;
				skip();
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
				jPanel = orderListui;
				skip();
				inOrderListui();
			}
		});
	}
	
	public void skip() {
		mainPanel.removeAll();
		mainPanel.add(jPanel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
	public static void main(String[] args) {
		ControllerTest loginController = new ControllerTest();
	}
}
