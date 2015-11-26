package presentation.userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import presentation.MainFrame;

public class StockManagerui extends MainFrame{
	JButton OutBoundManage;
	JButton StorageManage;
	JButton StockCheck;
	JButton StockCount;
	JLabel UserName;
	JLayeredPane layeredPane;
	
	public static void main(String[] args){
		StockManagerui ui=new StockManagerui();
	}
	public StockManagerui(){
		StorageManage=new JButton();
		UserName=new JLabel();
		layeredPane=getLayeredPane();
		OutBoundManage=new JButton();
		StockCheck=new JButton();
		StockCount=new JButton();
		
		UserName.setBounds(4,96,176,24);
		UserName.setText("库存管理人员："+"***");
		UserName.setHorizontalAlignment(SwingConstants.CENTER);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		UserName.setFont(font2);
		UserName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		UserName.setBackground(Color.WHITE);
		UserName.setOpaque(true);
		
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		StorageManage.setBounds(2,120,180,30);
		StorageManage.setText("入库管理");
		StorageManage.setFont(font3);
		StorageManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StorageManage.setBackground(Color.WHITE);
		
		OutBoundManage.setBounds(2,150,180,30);
		OutBoundManage.setText("出库管理");
		OutBoundManage.setFont(font3);
		OutBoundManage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OutBoundManage.setBackground(Color.WHITE);
		
		StockCheck.setBounds(2,180,180,30);
		StockCheck.setText("库存查看");
		StockCheck.setFont(font3);
		StockCheck.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StockCheck.setBackground(Color.WHITE);
		
		StockCount.setBounds(2,210,180,30);
		StockCount.setText("库存盘点");
		StockCount.setFont(font3);
		StockCount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		StockCount.setBackground(Color.WHITE);
		
		layeredPane.add(UserName,new Integer(10), 0);
		layeredPane.add(StorageManage,new Integer(10), 0);
		layeredPane.add(OutBoundManage,new Integer(10), 0);
		layeredPane.add(StockCheck,new Integer(10), 0);
		layeredPane.add(StockCount,new Integer(10), 0);
	}
}
