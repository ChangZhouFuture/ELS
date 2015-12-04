package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import presentation.reuse.Images;
import presentation.userui.Loginui;

public class MainFrame extends JFrame{
	JButton minimizeButton;
	JButton closeButton;
	JPanel mainPanel;
	JLabel mainLabel1;
	JLabel mainLabel2;
	JLabel mainLabel3;
	JButton userLogo;
	JButton exitButton;
	Point origin;
	JLabel left;
	JFrame jFrame;
	
	public static void main(String[] args){
		MainFrame ui=new MainFrame();
	}
	public MainFrame(){
		minimizeButton=new JButton();
		closeButton=new JButton();
		mainPanel=new JPanel();
		mainLabel1=new JLabel();
		mainLabel2=new JLabel();
		mainLabel3=new JLabel();
		userLogo=new JButton();
		origin=new Point();
		exitButton=new JButton();
		left=new JLabel();
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,(screenSize.height - this.getHeight()) / 2);
		this.getContentPane().setLayout(null);
		
		left.setBounds(0,30,4,490);
		left.setBackground(Color.lightGray);
		left.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		left.setOpaque(true);
		
		mainPanel.setLayout(null);
		mainPanel.setLocation(0,0);
		mainPanel.setSize(this.getWidth(),this.getHeight());
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setOpaque(true);
		
		mainLabel1.setBounds(0,0,this.getWidth(),30);
		mainLabel1.setBackground(Color.lightGray);
		mainLabel1.setOpaque(true);
		mainLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		mainLabel1.setText(" 快递物流系统");
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		mainLabel1.setFont(font1);
		mainLabel1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		mainLabel2.setBounds(0,this.getHeight()-30,this.getWidth(),30);
		mainLabel2.setBackground(Color.lightGray);
		mainLabel2.setOpaque(true);
		mainLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		mainLabel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		mainLabel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainLabel3.setBounds(4,30,180,490);
		mainLabel3.setBackground(Color.WHITE);
		
		userLogo.setBounds((mainLabel3.getWidth()-72)/2,0,72,72);
		userLogo.setIcon(Images.USERLOGO_IMAGE);
		
		exitButton.setBounds((mainLabel3.getWidth()-72)/2,442,72,30);
		exitButton.setText("退出");
		exitButton.setFont(font1);
		exitButton.setBackground(Color.WHITE);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				jFrame = new Loginui();
			}
		});
		
		minimizeButton.setBounds(this.getWidth()-30*2,0,30,30);
		minimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		minimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); 
			}
		});
		
		closeButton.setBounds(this.getWidth()-30,0,30,30);
		closeButton.setIcon(Images.CLOSE_IMAGE);
		closeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		
		mainLabel1.add(closeButton);
		mainLabel1.add(minimizeButton);
		mainLabel3.add(userLogo);
		mainLabel3.add(exitButton);
		mainPanel.add(mainLabel1);
		mainPanel.add(mainLabel2);
		mainPanel.add(mainLabel3);
		mainPanel.add(left);
		
		this.add(mainPanel);
		this.setVisible(true);
		this.validate();
		this.repaint();
	}
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
	public JButton getUserLogo() {
		return this.userLogo;
	}
	public JButton getExitButton() {
		return this.exitButton;
	}
}
