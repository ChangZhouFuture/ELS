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
import javax.swing.JTextField;

import presentation.reuse.Images;

public class Loginui {
	private JFrame LoginFrame;
	private JPanel LoginPanel;
	private JLabel LoginUser;
	private JLabel LoginPassword;
	private JButton LoginButton;
	private JTextField UserField;
	private JTextField PasswordField;
	private JButton MinimizeButton;
	private JButton CloseButton;
	static Point origin = new Point();
	public static void main(String[] args){
		Loginui ui=new Loginui();
	}
	public Loginui(){
		LoginFrame=new JFrame();
		LoginUser=new JLabel();
		LoginPassword=new JLabel();
		LoginButton=new JButton();
		UserField=new JTextField();
		PasswordField=new JTextField();
		MinimizeButton=new JButton();
		CloseButton=new JButton();
		Point origin = new Point();
		LoginPanel=new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(Images.BACKGROUND_IMAGE,0,0,400,300,null);
			}
		};
		
		LoginFrame.setUndecorated(true);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.getContentPane().setLayout(null);
		LoginFrame.setSize(400, 300);
		LoginPanel.setLayout(null);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		LoginFrame.setLocation((screenSize.width - LoginFrame.getWidth()) / 2,
				(screenSize.height - LoginFrame.getHeight()) / 2);
		
		LoginUser.setBounds(128,150,24,24);
		LoginUser.setIcon(Images.USER_IMAGE);
		
		LoginPassword.setBounds(128,180,24,24);
		LoginPassword.setIcon(Images.PASSWORD_IMAGE);
		
		UserField.setBounds(152,150,120,24);
		
		PasswordField.setBounds(152,180,120,24);
		
		LoginButton.setBounds(150,240,100,24);
		LoginButton.setBackground(Color.blue);
		LoginButton.setText("��    ½");
		Font font = new Font("TimesRoman",Font.BOLD,18);
		LoginButton.setFont(font);
		
		MinimizeButton.setBounds(LoginFrame.getWidth()-24*2,0,24,24);
		MinimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		MinimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame.setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
		CloseButton.setBounds(LoginFrame.getWidth()-24,0,24,24);
		CloseButton.setIcon(Images.CLOSE_IMAGE);
		CloseButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0); 
			}
		});
		LoginFrame.addMouseListener(new MouseAdapter() {
			// ���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {
				// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		LoginFrame.addMouseMotionListener(new MouseMotionAdapter() {
			// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
			public void mouseDragged(MouseEvent e) {
				// ������϶�ʱ��ȡ���ڵ�ǰλ��
				Point p =LoginFrame.getLocation();
				// ���ô��ڵ�λ��
				LoginFrame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
		
		LoginPanel.setLocation(0, 0);
		LoginPanel.setSize(LoginFrame.getWidth(),LoginFrame.getHeight());
		LoginPanel.add(MinimizeButton);
		LoginPanel.add(CloseButton);
		LoginPanel.add(LoginUser);
		LoginPanel.add(LoginPassword);
		LoginPanel.add(UserField);
		LoginPanel.add(PasswordField);
		LoginPanel.add(LoginButton);
		
		LoginFrame.add(LoginPanel);
		LoginFrame.setVisible(true);
		LoginFrame.validate();
		LoginFrame.repaint();
	}
}
