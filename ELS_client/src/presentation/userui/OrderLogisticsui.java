package presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.Images;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;

public class OrderLogisticsui extends JDialog{ 
	public JPanel orderLogisticsPanel;
	public JLabel findOrder;
	public JTextField orderIdField;
	public JButton find;
	public JButton closeButton;
	public JTextArea logisticsArea;
	public JavaBean1 javaBean1;
	public Orderblservice orderblservice;
	public JScrollPane scroller;
	public OrderVO orderVO;
	public Point origin = new Point();
	
	public static void main(String[] args){
		OrderLogisticsui orderLogisticsui=new OrderLogisticsui();
	}
	
	public OrderLogisticsui(){
		orderLogisticsPanel=new JPanel();
		findOrder=new JLabel();
		orderIdField=new JTextField();
		find=new JButton();
		closeButton=new JButton();
		logisticsArea=new JTextArea();
		
		this.setUndecorated(true);
		this.setLayout(null);
		this.setSize(400,300);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		findOrder.setBounds(30,30,160,24);
		findOrder.setBackground(Color.WHITE);
		findOrder.setText("�����붩���ţ�");
		Font font = new Font("TimesRoman",Font.BOLD,15);
		findOrder.setFont(font);
		
		orderIdField.setBounds(30,60,200,24);
		
		find.setBounds(240,60,70,24);
		find.setBackground(Color.WHITE);
		find.setText("��ѯ");
		find.setFont(font);
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String orderId=orderIdField.getText();
				orderblservice=new Order();
				JavaBean1 javaBean1=orderblservice.inquireA(orderId);
				orderVO=new OrderVO();
				orderVO=(OrderVO)javaBean1.getObject();
				
				String orderInfo=orderVO.getSenderName()+"  "+orderVO.getAddresseeName()+"  "+orderVO.getGoodsName()+" ";
			}
		});
		
		logisticsArea.setEditable(false);
		logisticsArea.setBounds(30,90,300,160);
		logisticsArea.setBackground(Color.WHITE);
		
		scroller=new JScrollPane(logisticsArea);
		scroller.setBounds(30,90,300,160);
		
		closeButton.setBounds(this.getWidth()-24,0,24,24);
		closeButton.setIcon(Images.CLOSE_IMAGE);
		closeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0); 
			}
		});
		this.addMouseListener(new MouseAdapter() {
			// ���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {
				// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
			public void mouseDragged(MouseEvent e) {
				// ������϶�ʱ��ȡ���ڵ�ǰλ��
				Point p =getLocation();
				// ���ô��ڵ�λ��
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
		
		orderLogisticsPanel.setSize(this.getWidth(),this.getHeight());
		orderLogisticsPanel.setLocation(0,0);
		orderLogisticsPanel.setBackground(Color.WHITE);
		orderLogisticsPanel.setLayout(null);
		orderLogisticsPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderLogisticsPanel.add(findOrder);
		orderLogisticsPanel.add(orderIdField);
		orderLogisticsPanel.add(find);
		orderLogisticsPanel.add(scroller);
		orderLogisticsPanel.add(closeButton);
		this.add(orderLogisticsPanel);
		this.setVisible(true);
	}
}