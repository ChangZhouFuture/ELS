package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class TranCenClerkui extends MainFrame{
	JButton ArraivalOrder4TranCenManage;
	JButton TrensferOrderManage;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
	}
	public TranCenClerkui(){
		ArraivalOrder4TranCenManage=new JButton();
		TrensferOrderManage=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("中转中心业务员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		ArraivalOrder4TranCenManage.setBounds(2,120,180,30);
		ArraivalOrder4TranCenManage.setText("中转接收管理");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		ArraivalOrder4TranCenManage.setFont(font3);
		ArraivalOrder4TranCenManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		ArraivalOrder4TranCenManage.setBackground(Color.WHITE);
		
		TrensferOrderManage.setBounds(2,150,180,30);
		TrensferOrderManage.setText("中转单管理");
		TrensferOrderManage.setFont(font3);
		TrensferOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		TrensferOrderManage.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(ArraivalOrder4TranCenManage,new Integer(10), 0);
		layeredPane.add(TrensferOrderManage,new Integer(10), 0);
	}
}
