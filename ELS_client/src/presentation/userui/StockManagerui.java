package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.reuse.Images;
import presentation.reuse.MainFrame;

public class StockManagerui extends MainFrame{
	public JButton outBoundManage;
	public JButton storageManage;
	public JButton stockCheck;
	public JButton stockCount;
	public JLabel userName;
	public JLabel stockBell;
	
	public StockManagerui(){
		storageManage=new JButton();
		userName=new JLabel();
		outBoundManage=new JButton();
		stockCheck=new JButton();
		stockCount=new JButton();
		stockBell=new JLabel();
		
		stockBell.setBounds(124,46,24,24);
		stockBell.setIcon(Images.BELL_IMAGE);
		stockBell.setVisible(false);
		
		userName.setBounds(2,76,176,24);
		userName.setText("库存管理人员："+Loginui.name);
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		userName.setFont(font2);
		userName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		userName.setBackground(Color.WHITE);
		userName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		storageManage.setBounds(0,100,180,30);
		storageManage.setText("入库管理");
		storageManage.setFont(font3);
		storageManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		storageManage.setBackground(Color.WHITE);
		
		outBoundManage.setBounds(0,130,180,30);
		outBoundManage.setText("出库管理");
		outBoundManage.setFont(font3);
		outBoundManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		outBoundManage.setBackground(Color.WHITE);
		
		stockCheck.setBounds(0,160,180,30);
		stockCheck.setText("库存查看");
		stockCheck.setFont(font3);
		stockCheck.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		stockCheck.setBackground(Color.WHITE);
		
		stockCount.setBounds(0,190,180,30);
		stockCount.setText("库存盘点");
		stockCount.setFont(font3);
		stockCount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		stockCount.setBackground(Color.WHITE);
		
		this.left.add(userName);
		this.left.add(storageManage);
		this.left.add(outBoundManage);
		this.left.add(stockCheck);
		this.left.add(stockCount);
		this.left.add(stockBell);
	}
}
