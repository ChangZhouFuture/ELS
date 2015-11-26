package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class Administratorui extends MainFrame{
	JButton UserManage;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		Administratorui ui=new Administratorui();
	}
	public Administratorui(){
		UserManage=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("管理员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		UserManage.setBounds(2,120,180,30);
		UserManage.setText("用户管理");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		UserManage.setFont(font3);
		UserManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		UserManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(UserManage,new Integer(10), 0);
	}
}
