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

public class MainFrame extends JFrame{
	JButton MinimizeButton;
	JButton CloseButton;
	JPanel MainPanel;
	JLabel MainLabel1;
	JLabel MainLabel2;
	JLabel MainLabel3;
	JButton UserLogo;
	JButton ExitButton;
	Point origin;
	JLabel left;
	
	public static void main(String[] args){
		MainFrame ui=new MainFrame();
	}
	public MainFrame(){
		MinimizeButton=new JButton();
		CloseButton=new JButton();
		MainPanel=new JPanel();
		MainLabel1=new JLabel();
		MainLabel2=new JLabel();
		MainLabel3=new JLabel();
		UserLogo=new JButton();
		origin=new Point();
		ExitButton=new JButton();
		left=new JLabel();
		
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2,(screenSize.height - this.getHeight()) / 2);
		this.getContentPane().setLayout(null);
		
		left.setBounds(0,24,2,502);
		left.setBackground(Color.lightGray);
		left.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		left.setOpaque(true);
		
		MainPanel.setLayout(null);
		MainPanel.setLocation(0,0);
		MainPanel.setSize(this.getWidth(),this.getHeight());
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setOpaque(true);
		
		MainLabel1.setBounds(0,0,this.getWidth(),24);
		MainLabel1.setBackground(Color.lightGray);
		MainLabel1.setOpaque(true);
		MainLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		MainLabel1.setText(" �������ϵͳ");
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		MainLabel1.setFont(font1);
		MainLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		MainLabel2.setBounds(0,this.getHeight()-24,this.getWidth(),24);
		MainLabel2.setBackground(Color.lightGray);
		MainLabel2.setOpaque(true);
		MainLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		MainLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		MainLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		MainLabel3.setBounds(2,24,176,502);
		MainLabel3.setBackground(Color.WHITE);
		
		UserLogo.setBounds(54,0,72,72);
		UserLogo.setIcon(Images.USERLOGO_IMAGE);
		
		ExitButton.setBounds(54,454,72,24);
		ExitButton.setText("�˳�");
		ExitButton.setFont(font1);
		ExitButton.setBackground(Color.WHITE);		
		
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
		
		MainLabel1.add(CloseButton);
		MainLabel1.add(MinimizeButton);
		MainLabel3.add(UserLogo);
		MainLabel3.add(ExitButton);
		MainPanel.add(MainLabel1);
		MainPanel.add(MainLabel2);
		MainPanel.add(MainLabel3);
		MainPanel.add(left);
		
		this.add(MainPanel);
		this.setVisible(true);
		this.validate();
		this.repaint();
	}
}
