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
	
	public ParentDocuments(){
		approState=new JLabel();
		modify=new JButton();
		delete=new JButton();
		makeOrder=new JButton();
		modifyOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
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
		//不显示是因为没有setText
		
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
		this.setLocation(182,30);
		this.setSize(640,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	
	public static void main(String[] args) {
		ParentDocuments parentDocuments = new ParentDocuments();
		MainFrame mainFrame = new MainFrame();
		mainFrame.add(parentDocuments);
	}
}
