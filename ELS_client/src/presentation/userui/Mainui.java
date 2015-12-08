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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.reuse.Images;

public class Mainui extends JFrame{
	public JPanel mainPanel;
	public JButton findOrder;
	public JButton login;
	public JButton minimizeButton;
	public JButton closeButton;
	public Point origin = new Point();
	public OrderLogisticsui orderLogisticsui;
	
	public static void main(String[] args){
		Mainui ui=new Mainui();
	}
	public Mainui(){
		mainPanel=new JPanel();
		findOrder=new JButton();
		login=new JButton();
		minimizeButton=new JButton();
		closeButton=new JButton();
		
		mainPanel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(Images.LOGIN_BACKGROUND,0,0,400,300,null);
			}
		};
		
		this.setUndecorated(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(400, 300);
		mainPanel.setLayout(null);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		minimizeButton.setBounds(this.getWidth()-24*2,0,24,24);
		minimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		minimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
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
		
		findOrder.setBounds(125,110,150,24);
		findOrder.setBackground(Color.white);
		findOrder.setText("��ѯ��������");
		Font font = new Font("TimesRoman",Font.BOLD,18);
		findOrder.setFont(font);
		findOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				OrderLogisticsui orderLogisticsui=new OrderLogisticsui(); 
			}
		});
		
		login.setBounds(125,170,150,24);
		login.setBackground(Color.white);
		login.setText("������Ա��½");
		login.setFont(font);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				Loginui loginui=new Loginui();
			}
		});
		
		mainPanel.setLocation(0, 0);
		mainPanel.setSize(this.getWidth(),this.getHeight());
		mainPanel.add(minimizeButton);
		mainPanel.add(closeButton);
		mainPanel.add(findOrder);
		mainPanel.add(login);
		this.add(mainPanel);
		this.setVisible(true);
		this.validate();
		this.repaint();
	}
}
