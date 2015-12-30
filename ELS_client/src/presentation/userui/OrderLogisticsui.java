package presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bean.JavaBean1;
import businesslogic.orderbl.InquireLogisticsInfor;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.InquireLogisticsInforblservice;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.Images;
import vo.orderVO.OrderVO;
import vo.utilityVO.LogisticsInforVO;

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
	InquireLogisticsInforblservice inquireLogisticsInforblservice;
	LogisticsInforVO logisticsInforVO;
	
	public static void main(String[] args){
		OrderLogisticsui orderLogisticsui=new OrderLogisticsui();
	}
	
	public OrderLogisticsui(){
		findOrder=new JLabel();
		orderIdField=new JTextField();
		find=new JButton();
		closeButton=new JButton();
		logisticsArea=new JTextArea();
		
		orderLogisticsPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(Images.LOGIN_BACKGROUND,0,0,400,300,null);
			}
		};
		
		this.setUndecorated(true);
		this.setLayout(null);
		this.setSize(400,300);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		findOrder.setBounds(30,30,160,24);
		findOrder.setForeground(Color.WHITE);
		findOrder.setText("请输入订单号：");
		Font font = new Font("TimesRoman",Font.BOLD,15);
		findOrder.setFont(font);
		
		orderIdField.setBounds(30,60,200,24);
		
		find.setBounds(240,60,70,24);
		find.setBackground(Color.WHITE);
		find.setText("查询");
		find.setFont(font);
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logisticsArea.setText("");
				String orderId=orderIdField.getText();
				orderblservice=new Order();
				javaBean1=orderblservice.inquireA(orderId);
				orderVO=new OrderVO();
				orderVO=(OrderVO)javaBean1.getObject();
				
				String orderInfo=orderVO.getSenderName()+"  "+orderVO.getSenderAdd()+"  "+
						orderVO.getAddresseeName()+"  "+orderVO.getAddresseeAdd()+"  "+
				orderVO.getGoodsName()+"\n";
				logisticsArea.append(orderInfo);
				inquireLogisticsInforblservice=new InquireLogisticsInfor();
				javaBean1=inquireLogisticsInforblservice.inquireLogisticsInfor(orderId);
				ArrayList<LogisticsInforVO> arrayList=(ArrayList<LogisticsInforVO>)javaBean1.getObject();
				String oneLine="";
				for(int i=arrayList.size()-1;i>=0;i--){
					logisticsInforVO=arrayList.get(i);
					oneLine=logisticsInforVO.getGenerateDate()+":"+logisticsInforVO.getDescripition()+"\n";
					logisticsArea.append(oneLine);
				}
			}
		});
		
		logisticsArea.setEditable(false);
		logisticsArea.setBounds(30,90,330,160);
		logisticsArea.setBackground(Color.WHITE);
		scroller=new JScrollPane(logisticsArea);
		scroller.setBounds(30,90,330,160);
		
		closeButton.setBounds(this.getWidth()-24,0,24,24);
		closeButton.setIcon(Images.CLOSE_IMAGE);
		closeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		this.addMouseListener(new MouseAdapter() {
			// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p =getLocation();
				// 设置窗口的位置
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
