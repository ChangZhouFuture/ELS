package presentation.reuse;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParentDocuments extends JPanel{
	public JButton makeOrder;
	public JButton modify;
	public JButton modifyOrder;
	public JButton delete;
	public JLabel approState;
	public JLabel docmID;
	public JLabel docmDate;
	
	public ParentDocuments(){
		approState=new JLabel();
		modify=new JButton();
		delete=new JButton();
		makeOrder=new JButton();
		modifyOrder=new JButton();
		docmID=new JLabel();
		docmDate=new JLabel();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		docmID.setBounds(450,0,160,24);
		docmID.setBackground(Color.WHITE);
		
		docmDate.setBounds(40,472,200,24);
		docmDate.setBackground(Color.WHITE);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		modifyOrder.setBounds(260,442,96,30);
		modifyOrder.setText("确认修改");
		modifyOrder.setFont(font1);
		modifyOrder.setBackground(Color.WHITE);
		modifyOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modifyOrder.setVisible(false);
		
		approState.setBounds(500,445,90,24);
		approState.setFont(font2);
		approState.setBackground(Color.WHITE);
		approState.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setBounds(0,0,24,24);
		modify.setIcon(Images.MODIFY_IMAGE);
		modify.setBackground(Color.WHITE);
		modify.setVisible(false);
		
		delete.setBounds(24,0,24,24);
		delete.setIcon(Images.DELETE_IMAGE);
		delete.setBackground(Color.WHITE);
		delete.setVisible(false);
		
		this.add(makeOrder);
		this.add(approState);
		this.add(modify);
		this.add(delete);
		this.add(modifyOrder);
		this.add(docmID);
		this.add(docmDate);
		this.setLocation(182,30);
		this.setSize(640,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	
}
