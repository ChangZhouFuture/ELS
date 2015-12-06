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

import bean.JavaBean1;
import bean.JavaBean2;
import businesslogic.userbl.LoginAndOut;
import businesslogicservice.userblservice.LoginAndOutblservice;
import presentation.MainFrame;
import presentation.reuse.Images;

public class Loginui extends JFrame{
	public JPanel LoginPanel;
	public JLabel LoginUser;
	public JLabel LoginPassword;
	public JButton LoginButton;
	public JTextField UserField;
	public JPasswordField PasswordField;
	public JButton MinimizeButton;
	public JButton CloseButton;
	public Point origin = new Point();
	public LoginAndOutblservice loginAndOutblservice;
	public JavaBean2 javaBean2;
	
	public static void main(String[] args){
		Loginui ui=new Loginui();
	}
	
	public Loginui(){
		LoginUser=new JLabel();
		LoginPassword=new JLabel();
		LoginButton=new JButton();
		UserField=new JTextField();
		PasswordField=new JPasswordField();
		MinimizeButton=new JButton();
		CloseButton=new JButton();
		Point origin = new Point();
		
		LoginPanel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(Images.LOGIN_BACKGROUND,0,0,400,300,null);
			}
		};
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setSize(400, 300);
		LoginPanel.setLayout(null);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		LoginUser.setBounds(125,140,30,30);
		LoginUser.setIcon(Images.USER_IMAGE);
		
		LoginPassword.setBounds(125,180,30,30);
		LoginPassword.setIcon(Images.PASSWORD_IMAGE);
		
		UserField.setBounds(155,140,120,30);
		
		PasswordField.setBounds(155,180,120,30);
		PasswordField.setEchoChar('*');
		
		LoginButton.setBounds(150,240,100,24);
		LoginButton.setBackground(Color.white);
		LoginButton.setText("��    ½");
		Font font = new Font("TimesRoman",Font.BOLD,18);
		LoginButton.setFont(font);
		
		MinimizeButton.setBounds(this.getWidth()-24*2,0,24,24);
		MinimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		MinimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
		CloseButton.setBounds(this.getWidth()-24,0,24,24);
		CloseButton.setIcon(Images.CLOSE_IMAGE);
		CloseButton.addActionListener(new ActionListener(){
			
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
		
		LoginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame mineFrame;
				loginAndOutblservice=new LoginAndOut();
				javaBean2=loginAndOutblservice.login(UserField.getText(),String.valueOf(PasswordField.getPassword()));
				
			}
		});
		
		LoginPanel.setLocation(0, 0);
		LoginPanel.setSize(this.getWidth(),this.getHeight());
		LoginPanel.add(MinimizeButton);
		LoginPanel.add(CloseButton);
		LoginPanel.add(LoginUser);
		LoginPanel.add(LoginPassword);
		LoginPanel.add(UserField);
		LoginPanel.add(PasswordField);
		LoginPanel.add(LoginButton);
		
		this.add(LoginPanel);
		this.setVisible(true);
		this.validate();
		this.repaint();
	}
}
