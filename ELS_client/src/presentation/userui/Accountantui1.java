package presentation.userui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class Accountantui1 extends Accountantui2{
	public JButton bankAccount;
	public JLayeredPane layeredPane;
	
	public Accountantui1(){
		bankAccount = new JButton();
		
		Font font = new Font("TimesRoman",Font.PLAIN,18);
		bankAccount.setBounds(0,220,180,30);
		bankAccount.setText("银行账户管理");
		bankAccount.setFont(font);
		bankAccount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		bankAccount.setBackground(Color.WHITE);
		
		this.left.add(bankAccount);
	}
	
}
