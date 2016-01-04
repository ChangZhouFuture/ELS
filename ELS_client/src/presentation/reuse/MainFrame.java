package presentation.reuse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.userui.Loginui;

public class MainFrame extends JFrame{
	public JFrame loginui;
	public JButton minimizeButton;
	public JButton closeButton;
	public JButton exitButton;
	public JButton userLogo;
	public JLabel top;
	public JLabel bottom;
	public JLabel left;
	public JLabel backGroundLabel;
	public Point origin;
	public ImageIcon backGroundImag = Images.MAIN_FRAME_BACKGROUND;
	
	
	public MainFrame(){
		left=new JLabel();
		top = new JLabel();
		bottom = new JLabel();
		left = new JLabel();
		userLogo=new JButton();
		exitButton=new JButton();
		closeButton=new JButton();
		minimizeButton=new JButton();
		origin=new Point();
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,(screenSize.height - this.getHeight()) / 2);
		this.getContentPane().setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,20);
		
		//�Ϸ��ĳ�����
		top.setBounds(0,0,this.getWidth(),30);
		top.setText("      �������ϵͳ");
		top.setFont(font1);
		top.setForeground(Color.white);
		
		//�·��ĳ�����
		bottom.setBounds(0,this.getHeight()-24,this.getWidth(),24);
		
		//��ߵĲ˵���
		left.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		left.setBounds(4,30,180,496);
		left.setBackground(Color.white);
		left.setOpaque(true);
		
		userLogo.setBounds(54,0,70,70);
		userLogo.setIcon(Images.USERLOGO_IMAGE);
		
		Font font2 = new Font("TimesRoman",Font.BOLD,18);
		exitButton.setBounds((left.getWidth()-72)/2,442,72,30);
		exitButton.setText("�˳�");
		exitButton.setFont(font2);
		exitButton.setBackground(Color.WHITE);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginui = new Loginui();
			}
		});
		
		minimizeButton.setBounds(this.getWidth()-60,0,30,30);
		minimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		minimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
		closeButton.setBounds(this.getWidth()-30,0,30,30);
		closeButton.setIcon(Images.CLOSE_IMAGE);
		closeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		top.add(closeButton);
		top.add(minimizeButton);
		left.add(userLogo);
		left.add(exitButton);
		
		this.add(top);
		this.add(bottom);
		this.add(left);
		setBackGroundImag();
		this.setVisible(true);
	}
	
	public void setBackGroundImag() {
		JPanel jp = (JPanel)this.getContentPane();
		backGroundLabel = new JLabel(backGroundImag);
		backGroundLabel.setBounds(0, 0, backGroundImag.getIconWidth(), backGroundImag.
				getIconHeight());
		this.getLayeredPane().add(backGroundLabel, new Integer(Integer.MIN_VALUE));
		jp.setOpaque(false);
	}
	
}
