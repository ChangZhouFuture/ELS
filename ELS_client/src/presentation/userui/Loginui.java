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
import state.Position;
import state.ResultMessage;

public class Loginui extends JFrame{
	public JPanel loginPanel;
	public JLabel loginUser;
	public JLabel loginPassword;
	public JLabel result;
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
	Position position;
	public static String name;
	public static String city;
	public static String region;
	public static String agency;
	
	public static void main(String[] args){
		Loginui ui=new Loginui();
	}
	
	public Loginui(){
		loginUser=new JLabel();
		loginPassword=new JLabel();
		result=new JLabel();
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
		loginButton.setText("��    ½");
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
		result.setBounds(0,this.getHeight()-24,this.getWidth(),24);
		result.setFont(font);
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
		
		loginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginAndOutblservice=new Login();
				javaBean2=loginAndOutblservice.login(userField.getText(),String.valueOf(passwordField.getPassword()));
				if((ResultMessage)javaBean2.getResultMessage()==ResultMessage.Success){
				position=javaBean2.getPosition();
				name=javaBean2.getName();
				city=javaBean2.getCity();
				region=javaBean2.getRegion();
				agency=javaBean2.getAgencyID();
				switch (position) {
				case Accountant1:
					accountant1Controller=new Accountant1Controller();
					dispose();
					break;
				case Accountant2:
					accountant2Controller=new Accountant2Controller();
					dispose();
					break;
				case Administrator:
					administratorController=new AdministratorController();
					dispose();
					break;
				case BusiHallClerk:
					busiHallClerkController=new BusiHallClerkController();
					dispose();
					break;
				case Courier:
					courierController=new CourierController();
					dispose();
					break;
				case GeneralManager:
					generalManagerController=new GeneralManagerController();
					dispose();
					break;
				case StockManager:
					stockManagerController=new StockManagerController();
					dispose();
					break;
				case TranCenClerk:
					tranCenClerkController=new TranCenClerkController();
					dispose();
					break;
				default:
					break;
				}
				}else{
					result.setText("�û�����������������µ�¼��");
					result.setBackground(Color.WHITE);
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
		loginPanel.add(result);
		
		this.add(loginPanel);
		this.setVisible(true);
	}
}
