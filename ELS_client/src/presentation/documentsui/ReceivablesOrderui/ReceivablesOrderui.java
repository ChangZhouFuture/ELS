package presentation.documentsui.ReceivablesOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;

public class ReceivablesOrderui extends ParentDocuments{
	JLabel ReceivablesOrder;
	JLabel ReceiveDate;
	JTextField YearField;
	JTextField MonthField;
	JTextField DayField;
	JLabel Year;
	JLabel Month;
	JLabel Day;
	JLabel Money;
	JTextField MoneyField;
	JLabel Courier;
	JTextField CourierId;
	JLabel OrderId;
	JTextField OrderIdField;
	JButton AddOrder;
	JTextArea OrderList;
	JScrollPane scroller;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		ReceivablesOrderui uiPanel=new ReceivablesOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public ReceivablesOrderui(){
		ReceivablesOrder=new JLabel();
		ReceiveDate=new JLabel();
		YearField=new JTextField();
		MonthField=new JTextField();
		DayField=new JTextField();
		Year=new JLabel();
		Month=new JLabel();
		Day=new JLabel();
		Money=new JLabel();
		MoneyField=new JTextField();
		Courier=new JLabel();
		CourierId=new JTextField();
		OrderId=new JLabel();
		OrderIdField=new JTextField();
		AddOrder=new JButton();
		OrderList=new JTextArea();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		ReceivablesOrder.setBounds(218,10,180,30);
		ReceivablesOrder.setText("收款单信息");
		ReceivablesOrder.setHorizontalAlignment(SwingConstants.CENTER);
		ReceivablesOrder.setFont(font1);
		ReceivablesOrder.setBackground(Color.WHITE);
		ReceivablesOrder.setOpaque(true);
		
		ReceiveDate.setBounds(40,50,100,24);
		ReceiveDate.setText("收款日期：");
		ReceiveDate.setFont(font2);
		ReceiveDate.setBackground(Color.WHITE);
		ReceiveDate.setOpaque(true);
		
		YearField.setBounds(130,52,48,20);
		
		Year.setBounds(180,50,24,24);
		Year.setText("年");
		Year.setFont(font2);
		Year.setBackground(Color.WHITE);
		Year.setOpaque(true);
		
		MonthField.setBounds(210,52,24,20);
		
		Month.setBounds(240,50,24,24);
		Month.setText("月");
		Month.setFont(font2);
		Month.setBackground(Color.WHITE);
		Month.setOpaque(true);
		
		DayField.setBounds(270,52,24,20);
		
		Day.setBounds(300,50,24,24);
		Day.setText("日");
		Day.setFont(font2);
		Day.setBackground(Color.WHITE);
		Day.setOpaque(true);
		
		Money.setBounds(40,80,100,24);
		Money.setText("收款金额：");
		Money.setFont(font2);
		Money.setBackground(Color.WHITE);
		Money.setOpaque(true);
		
		MoneyField.setBounds(130,82,100,20);
		MoneyField.setEditable(false);
		
		Courier.setBounds(40,110,100,24);
		Courier.setText("收款快递员：");
		Courier.setFont(font2);
		Courier.setBackground(Color.WHITE);
		Courier.setOpaque(true);
		
		CourierId.setBounds(130,112,100,20);
		
		OrderId.setBounds(40,140,200,30);
		OrderId.setText("快递订单条形码号：");
		OrderId.setFont(font2);
		OrderId.setBackground(Color.WHITE);
		OrderId.setOpaque(true);
		
		OrderIdField.setBounds(140,172,120,24);
		
		AddOrder.setBounds(280,172,70,24);
		AddOrder.setText("添加订单");
		AddOrder.setFont(font2);
		AddOrder.setBackground(Color.WHITE);
		AddOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		OrderList.setBounds(40,200,250,150);
		OrderList.setEnabled(false);
		OrderList.setFont(font2);
		OrderList.setBackground(Color.WHITE);
		OrderList.setWrapStyleWord(true);
		OrderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OrderList.setLineWrap(true);
		
		scroller=new JScrollPane(OrderList);
		scroller.setBounds(40,200,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(ReceivablesOrder);
		this.add(ReceiveDate);
		this.add(YearField);
		this.add(Year);
		this.add(MonthField);
		this.add(Month);
		this.add(DayField);
		this.add(Day);
		this.add(Money);
		this.add(MoneyField);
		this.add(Courier);
		this.add(CourierId);
		this.add(OrderId);
		this.add(OrderIdField);
		this.add(AddOrder);
		this.add(scroller);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
