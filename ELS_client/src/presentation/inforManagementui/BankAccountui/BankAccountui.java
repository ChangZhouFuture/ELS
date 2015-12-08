package presentation.inforManagementui.BankAccountui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.documentsui.TranCenLoadingListui.TransferCenterLoadingListui;
import presentation.userui.Accountantui1;
import presentation.userui.TranCenClerkui;

public class BankAccountui extends JPanel{
	public JLabel bankAccount;
	public JLabel name;
	public JTextField nameField;
	public JLabel money;
	public JTextField moneyField;
	public JButton makeOrder;
	
	public static void main(String[] args){
		Accountantui1 ui=new Accountantui1();
		BankAccountui uiPanel=new BankAccountui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public  BankAccountui(){
		bankAccount=new JLabel();
		name=new JLabel();
		nameField=new JTextField();
		money=new JLabel();
		moneyField=new JTextField();
		makeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		
		bankAccount.setBounds(218,10,180,30);
		bankAccount.setText("银行账户信息");
		bankAccount.setHorizontalAlignment(SwingConstants.CENTER);
		bankAccount.setFont(font1);
		bankAccount.setBackground(Color.WHITE);
		bankAccount.setOpaque(true);
		
		name.setBounds(40,50,100,24);
		name.setText("名称：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		name.setOpaque(true);
		
		nameField.setBounds(140,52,120,20);
		
		money.setBounds(40,80,100,24);
		money.setText("金额：");
		money.setFont(font2);
		money.setBackground(Color.WHITE);
		money.setOpaque(true);
		
		moneyField.setBounds(140,82,120,20);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(bankAccount);
		this.add(name);
		this.add(nameField);
		this.add(money);
		this.add(moneyField);
		this.add(makeOrder);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
