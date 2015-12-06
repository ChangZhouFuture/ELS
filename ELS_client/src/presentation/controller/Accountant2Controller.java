package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.documentsui.PaymentOrderui.PaymentOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Skip;
import presentation.userui.Accountantui1;
import presentation.userui.Accountantui2;
import vo.orderVO.OrderVO;
import bean.JavaBean1;
import businesslogicservice.orderblservice.Orderblservice;

public class Accountant2Controller {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Accountantui2 accountant2ui;
	ReceivablesOrderListui receivablesOrderListui;
	PaymentOrderListui paymentOrderListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	ReceivablesOrderui receivablesOrderui;
	Orderblservice orderblservice;
	JavaBean1 javaBean1;
	OrderVO orderVO;
	
	public Accountant2Controller(){
		accountant2ui = new Accountantui2();
		receivablesOrderListui = new ReceivablesOrderListui();
		receivablesOrderListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(receivablesOrderListui);
		JLayeredPane layeredPane = accountant2ui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAccountant1ui();
		inReceivablesOrderListui();
	}
	public void inAccountant1ui() {
		accountant2ui.receival.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui = new ReceivablesOrderListui();
				childPanel = receivablesOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
		accountant2ui.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountant2ui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountant2ui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
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
