package presentation.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.documentsui.PaymentOrderui.PaymentOrderListui;
import presentation.documentsui.PaymentOrderui.PaymentOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.BankAccountui.BankAccountListui;
import presentation.inforManagementui.BankAccountui.BankAccountui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Skip;
import presentation.userui.Accountantui1;

public class Accountant1Controller {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Accountantui1 accountant1ui;
	ReceivablesOrderListui receivablesOrderListui;
	PaymentOrderListui paymentOrderListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	BankAccountListui bankAccountListui;
	ReceivablesOrderui receivablesOrderui;
	PaymentOrderui paymentOrderui;
	BankAccountui bankAccountui;
	JButton totalAmount=new JButton();
	JTextField totalAmountField=new JTextField();
	Font font3=new Font("TimesRoman",Font.PLAIN,15);
	
	public Accountant1Controller(){
		accountant1ui = new Accountantui1();
		receivablesOrderListui = new ReceivablesOrderListui();
		receivablesOrderListui.sheetLabel.setText("结算管理");
		receivablesOrderListui.add.setVisible(false);
		receivablesOrderListui.addText.setVisible(false);
		receivablesOrderListui.findById.setText("按营业厅查找");
		totalAmount.setBounds(30,420,50,24);
		totalAmount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		totalAmount.setBackground(Color.WHITE);
		totalAmount.setText("合计");
		
		totalAmount.setFont(font3);
		totalAmountField.setBounds(80,422,80,20);
		totalAmountField.setEditable(false);
		totalAmountField.setBackground(Color.WHITE);
		totalAmountField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		receivablesOrderListui.add(totalAmount);
		receivablesOrderListui.add(totalAmountField);
		receivablesOrderListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(receivablesOrderListui);
		JLayeredPane layeredPane = accountant1ui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAccountant1ui();
		inReceivablesOrderListui();
	}
	public void inAccountant1ui() {
		accountant1ui.receival.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui = new ReceivablesOrderListui();
				receivablesOrderListui.sheetLabel.setText("结算管理");
				receivablesOrderListui.add.setVisible(false);
				receivablesOrderListui.addText.setVisible(false);
				receivablesOrderListui.findById.setText("按营业厅查找");
				receivablesOrderListui.delete.setVisible(false);
				totalAmount.setBounds(30,420,50,24);
				totalAmount.setBorder(BorderFactory.createLineBorder(Color.lightGray));
				totalAmount.setBackground(Color.WHITE);
				totalAmount.setText("合计");
				totalAmount.setFont(font3);
				totalAmountField.setBounds(80,422,80,20);
				totalAmountField.setEditable(false);
				totalAmountField.setBackground(Color.WHITE);
				totalAmountField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				receivablesOrderListui.add(totalAmount);
				receivablesOrderListui.add(totalAmountField);
				childPanel = receivablesOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
		accountant1ui.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
			}
		});
		accountant1ui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountant1ui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountant1ui.bankAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankAccountListui = new BankAccountListui();
				childPanel = bankAccountListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBankAccountListui();
			}
		});
	}
	public void inReceivablesOrderListui() {
		receivablesOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderui = new ReceivablesOrderui();
				childPanel = receivablesOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inPaymentOrderListui(){
		paymentOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paymentOrderui=new PaymentOrderui();
				childPanel=paymentOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inBankAccountListui(){
		bankAccountListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankAccountui=new BankAccountui();
				childPanel=bankAccountui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public static void main(String[] args) {
		Accountant1Controller accountant1Controller = new Accountant1Controller();
	}
}
