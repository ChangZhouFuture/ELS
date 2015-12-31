package presentation.inforManagementui.BankAccountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bean.JavaBean1;
import businesslogic.inforManagementbl.BankAccountInfor;
import businesslogic.inforManagementbl.VehiclesInfor;
import businesslogicservice.inforManagementblservice.BankAccountInforblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.Accountantui1;
import presentation.userui.Loginui;
import vo.inforManagementVO.BankAccountVO;
import vo.inforManagementVO.VehiclesVO;

public class BankAccountui extends ParentDocuments{
	public JLabel bankAccount;
	public JLabel name;
	public JTextField nameField;
	public JLabel money;
	public JTextField moneyField;
	BankAccountInforblservice bankAccountInforblservice;
	public BankAccountVO bankAccountVO;
	JavaBean1 javaBean1;
	
	public  BankAccountui(){
		bankAccount=new JLabel();
		name=new JLabel();
		nameField=new JTextField();
		money=new JLabel();
		moneyField=new JTextField();
		bankAccountVO=new BankAccountVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		
		bankAccount.setBounds(218,10,180,30);
		bankAccount.setText("银行账户信息");
		bankAccount.setHorizontalAlignment(SwingConstants.CENTER);
		bankAccount.setFont(font1);
		bankAccount.setBackground(Color.WHITE);
		
		name.setBounds(40,50,100,24);
		name.setText("名称：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		
		nameField.setBounds(140,52,120,20);
		
		money.setBounds(40,80,100,24);
		money.setText("金额：");
		money.setFont(font2);
		money.setBackground(Color.WHITE);
		
		moneyField.setBounds(140,82,120,20);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				bankAccountInforblservice=new BankAccountInfor();
				bankAccountVO.setName(nameField.getText());
				bankAccountVO.setAmount(Double.valueOf(moneyField.getText()));
				javaBean1=bankAccountInforblservice.add(bankAccountVO);
				bankAccountVO=(BankAccountVO)javaBean1.getObject();
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				bankAccountInforblservice=new BankAccountInfor();
				String oldName=bankAccountVO.getName();
				String newName=nameField.getText();
				bankAccountInforblservice.modify(oldName,newName);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(bankAccount);
		this.add(name);
		this.add(nameField);
		this.add(money);
		this.add(moneyField);
	}
	public void refresh(){
		nameField.setEditable(false);
		moneyField.setEditable(false);
		
		nameField.setBackground(Color.white);
		moneyField.setBackground(Color.white);
		
		nameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		moneyField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying(){
		nameField.setEditable(true);
		modifyOrder.setVisible(true);
		
		nameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
