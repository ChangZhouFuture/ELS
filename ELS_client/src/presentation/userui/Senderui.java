package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class Senderui extends MainFrame{
	JButton LogisticsCheck;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Senderui ui=new Senderui();
	}
	public Senderui(){
		LogisticsCheck=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("寄件人："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		LogisticsCheck.setBounds(2,120,180,30);
		LogisticsCheck.setText("物流信息查询");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		LogisticsCheck.setFont(font3);
		LogisticsCheck.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		LogisticsCheck.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(LogisticsCheck,new Integer(10), 0);
	}
}
