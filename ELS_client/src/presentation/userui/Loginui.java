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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import bean.JavaBean2;
import businesslogic.userbl.Login;
import businesslogicservice.userblservice.Loginblservice;
import presentation.controller.Accountant1Controller;
import presentation.controller.Accountant2Controller;
import presentation.controller.AdministratorController;
import presentation.controller.BusiHallClerkController;
import presentation.controller.CourierController;
import presentation.controller.GeneralManagerController;
import presentation.controller.StockManagerController;
import presentation.controller.TranCenClerkController;
import presentation.reuse.Images;

public class Loginui extends JFrame{
	public JPanel loginPanel;
	public JLabel loginUser;
	public JLabel loginPassword;
	public JButton loginButton;
	public JTextField userField;
	public JPasswordField passwordField;
	public JButton minimizeButton;
	public JButton closeButton;
	public Point origin = new Point();
	public Loginblservice loginAndOutblservice;
	public JavaBean2 javaBean2;
	public CourierController courierController;
	public Accountant1Controller accountant1Controller;
	public Accountant2Controller accountant2Controller;
	public AdministratorController administratorController;
	public BusiHallClerkController busiHallClerkController;
	public GeneralManagerController generalManagerController;
	public StockManagerController stockManagerController;
	public TranCenClerkController tranCenClerkController;
	
	public static void main(String[] args){
		Loginui ui=new Loginui();
	}
	
	public Loginui(){
		loginUser=new JLabel();
		loginPassword=new JLabel();
		loginButton=new JButton();
		userField=new JTextField();
		passwordField=new JPasswordField();
		minimizeButton=new JButton();
		closeButton=new JButton();
		origin = new Point();
		
		loginPanel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(Images.LOGIN_BACKGROUND,0,0,400,300,null);
			}
		};
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(400, 300);
		loginPanel.setLayout(null);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		loginUser.setBounds(125,140,30,30);
		loginUser.setIcon(Images.USER_IMAGE);
		
		loginPassword.setBounds(125,180,30,30);
		loginPassword.setIcon(Images.PASSWORD_IMAGE);
		
		userField.setBounds(155,140,120,30);
		
		passwordField.setBounds(155,180,120,30);
		passwordField.setEchoChar('*');
		
		loginButton.setBounds(150,240,100,24);
		loginButton.setBackground(Color.white);
		loginButton.setText("登    陆");
		Font font = new Font("TimesRoman",Font.BOLD,18);
		loginButton.setFont(font);
		
		minimizeButton.setBounds(this.getWidth()-24*2,0,24,24);
		minimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		minimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
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
		
		loginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginAndOutblservice=new Login();
				javaBean2=loginAndOutblservice.login(userField.getText(),String.valueOf(passwordField.getPassword()));
				String position=javaBean2.getPosition().toString();
				switch (position) {
				case "Accountant1":
					dispose();
					accountant1Controller=new Accountant1Controller();
					break;
				case "Accountant2":
					dispose();
					accountant2Controller=new Accountant2Controller();
					break;
				case "Administrator":
					dispose();
					administratorController=new AdministratorController();
					break;
				case "BusiHallClerk":
					dispose();
					busiHallClerkController=new BusiHallClerkController();
					break;
				case "Courier":
					dispose();
					courierController=new CourierController();
					break;
				case "GeneralManager":
					dispose();
					generalManagerController=new GeneralManagerController();
					break;
				case "StockManager":
					dispose();
					stockManagerController=new StockManagerController();
					break;
				case "TranCenClerk":
					dispose();
					tranCenClerkController=new TranCenClerkController();
					break;
				default:
					break;
				}
			}
		});
		
		loginPanel.setLocation(0, 0);
		loginPanel.setSize(this.getWidth(),this.getHeight());
		loginPanel.add(minimizeButton);
		loginPanel.add(closeButton);
		loginPanel.add(loginUser);
		loginPanel.add(loginPassword);
		loginPanel.add(userField);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);
		
		this.add(loginPanel);
		this.setVisible(true);
	}
}
