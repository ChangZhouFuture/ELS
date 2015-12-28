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
		inAccountant1ui();
	}
	public void inAccountant1ui() {
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
