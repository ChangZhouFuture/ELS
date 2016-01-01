package RMI;
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

public class RMIui extends JFrame{
	JFrame thisFrame;
	JPanel mainPanel;
	JLabel rmiSuccessInit;
	JButton exitButton;
	JButton minimizeButton;
	Point origin = new Point();
	RMIHelper rmiHelper = new RMIHelper();
	
	public static void main(String[] args){
		RMIui ui=new RMIui();
	}
	public RMIui(){
		thisFrame=this;
		rmiSuccessInit=new JLabel();
		exitButton=new JButton();
		minimizeButton=new JButton();
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
		
		minimizeButton.setBounds(this.getWidth()-24,0,24,24);
		minimizeButton.setIcon(Images.MINIMIZE_IMAGE);
		minimizeButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED); 
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
		
		Font font = new Font("TimesRoman",Font.BOLD,18);
		
		rmiHelper.init();
		rmiSuccessInit.setBounds(95,80,210,24);
		rmiSuccessInit.setText("���������ѳɹ�����!");
		rmiSuccessInit.setHorizontalAlignment(0);
		rmiSuccessInit.setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 19));
		rmiSuccessInit.setForeground(Color.white);
		
		exitButton.setBounds(115,170,170,24);
		exitButton.setBackground(Color.white);
		exitButton.setText("�ͷŷ������˿�");
		exitButton.setFont(font);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog dialog=new EMSDialog();
				int n=dialog.showDialog(null,"�Ƿ��ͷ�",60);
		        if (n == 1) {
		        	thisFrame.dispose();
				    rmiHelper.release();
		        } else if (n == 0) {  
		        }
			}
		});
		
		mainPanel.setLocation(0, 0);
		mainPanel.setSize(this.getWidth(),this.getHeight());
		mainPanel.add(minimizeButton);
		mainPanel.add(exitButton);
		mainPanel.add(rmiSuccessInit);
		this.add(mainPanel);
		this.setVisible(true);
		this.validate();
		this.repaint();
	}
}
