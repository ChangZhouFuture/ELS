package presentation.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.documentsbl.PaymentOrder;
import businesslogic.orderbl.Order;
import businesslogicservice.documentsblservice.PaymentOrderblservice;
import presentation.documentsui.PaymentOrderui.PaymentOrderListui;
import presentation.documentsui.PaymentOrderui.PaymentOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.BankAccountui.BankAccountListui;
import presentation.inforManagementui.BankAccountui.BankAccountui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.orderui.OrderListui;
import presentation.reuse.Skip;
import presentation.userui.Accountantui1;
import vo.documentsVO.PaymentOrderVO;

public class Accountant1Controller extends Accountant2Controller{
	BankAccountListui bankAccountListui;
	
	public Accountant1Controller(){
		accountantui.bankAccount.setVisible(true);
	}
	public void inAccountant1ui() {
		accountantui.receival.addActionListener(new ActionListener() {
			
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
		accountantui.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
			}
		});
		accountantui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountantui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountantui.bankAccount.addActionListener(new ActionListener() {
			
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
