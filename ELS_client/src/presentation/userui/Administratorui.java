package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import businesslogic.userbl.Login;
import presentation.reuse.MainFrame;

public class Administratorui extends MainFrame{
	public JButton userManage;
	public JLabel userName;
	
	public static void main(String[] args){
		Administratorui ui=new Administratorui();
	}
	public Administratorui(){
		userManage=new JButton();
		userName=new JLabel();
		
		userName.setBounds(2,76,176,24);
		userName.setText("管理员："+Loginui.name);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		userManage.setBounds(0,100,180,30);
		userManage.setText("用户管理");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		userManage.setFont(font3);
		userManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		userManage.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(userManage);
	}
}
