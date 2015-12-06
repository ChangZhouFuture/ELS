package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.MainFrame;

public class TranCenClerkui extends MainFrame{
	public JButton tranCenArraivalOrderManage;
	public JButton trensferOrderManage;
	public JButton transferCenterLoadingList;
	public JLabel userName;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
	}
	public TranCenClerkui(){
		tranCenArraivalOrderManage=new JButton();
		trensferOrderManage=new JButton();
		transferCenterLoadingList=new JButton();
		userName=new JLabel();
		
		userName.setBounds(2,76,176,24);
		userName.setText("中转中心业务员："+"***");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		tranCenArraivalOrderManage.setBounds(0,100,180,30);
		tranCenArraivalOrderManage.setText("中转接收管理");
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		tranCenArraivalOrderManage.setFont(font3);
		tranCenArraivalOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		tranCenArraivalOrderManage.setBackground(Color.WHITE);
		
		trensferOrderManage.setBounds(0,130,180,30);
		trensferOrderManage.setText("中转单管理");
		trensferOrderManage.setFont(font3);
		trensferOrderManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		trensferOrderManage.setBackground(Color.WHITE);
		
		transferCenterLoadingList.setBounds(0,160,180,30);
		transferCenterLoadingList.setText("中转中心接收管理");
		transferCenterLoadingList.setFont(font3);
		transferCenterLoadingList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		transferCenterLoadingList.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(tranCenArraivalOrderManage);
		this.left.add(trensferOrderManage);
		this.left.add(transferCenterLoadingList);
	}
}
