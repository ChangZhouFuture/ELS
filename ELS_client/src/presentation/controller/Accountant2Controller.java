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

import presentation.documentsui.PaymentOrderui.PaymentOrderListui;
import presentation.documentsui.PaymentOrderui.PaymentOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.BankAccountui.BankAccountui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Skip;
import presentation.userui.Accountantui1;
import presentation.userui.Accountantui2;
import vo.documentsVO.PaymentOrderVO;
import businesslogic.documentsbl.PaymentOrder;
import businesslogicservice.documentsblservice.PaymentOrderblservice;

public class Accountant2Controller {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Accountantui1 accountantui;
	ReceivablesOrderListui receivablesOrderListui;
	PaymentOrderListui paymentOrderListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	ReceivablesOrderui receivablesOrderui;
	PaymentOrderui paymentOrderui;
	BankAccountui bankAccountui;
	PaymentOrderblservice paymentOrderblservice;
	PaymentOrderVO paymentOrderVO;
	JButton totalAmount=new JButton();
	JTextField totalAmountField=new JTextField();
	Font font3=new Font("TimesRoman",Font.PLAIN,15);
	
	public Accountant2Controller(){
		accountantui = new Accountantui1();
		accountantui.bankAccount.setVisible(false);
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
		JLayeredPane layeredPane = accountantui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAccountant1ui();
		inReceivablesOrderListui();
	}
	public void inAccountant1ui() {
		accountantui.receival.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui = new ReceivablesOrderListui();
				childPanel = receivablesOrderListui;
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
		accountantui.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
			}
		});
		accountantui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountantui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inPaymentOrderListui(){
		paymentOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderui=new PaymentOrderui();
				childPanel=paymentOrderui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderui();
			}
		});
	}
	public void inPaymentOrderui(){
		paymentOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=paymentOrderui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				paymentOrderblservice=new PaymentOrder();
				paymentOrderblservice.deleteMany(deletearray);
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
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
	public static void main(String[] args) {
		Accountant2Controller accountant2Controller = new Accountant2Controller();
	}
}
