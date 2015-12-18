package presentation.documentsui.PaymentOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import presentation.reuse.ParentDocuments;
import presentation.userui.Accountantui2;


public class PaymentOrderui extends ParentDocuments{
	public JLabel paymentOrder;
	public JLabel paymentDate;
	public JTextField yearField;
	public JTextField monthField;
	public JTextField dayField;
	public JLabel year;
	public JLabel month;
	public JLabel day;
	public JLabel paymentMoney;
	public JTextField paymentMoneyField;
	public JLabel paymentPerson;
	public JTextField paymentPersonField;
	public JLabel paymentId;
	public JTextField paymentIdField;
	public JLabel entry;
	public ButtonGroup entryGroup;
	public JRadioButton carriage;
	public JRadioButton reward;
	public JRadioButton wages;
	public JRadioButton rent;
	public JLabel remarks;
	public JTextArea remarksArea;
	public JScrollPane scroller;
	
	public static void main(String[] args){
		Accountantui2 ui=new Accountantui2();
		PaymentOrderui uiPanel=new PaymentOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public PaymentOrderui(){
		paymentOrder=new JLabel();
		paymentDate=new JLabel();
		yearField=new JTextField();
		monthField=new JTextField();
		dayField=new JTextField();
		year=new JLabel();
		month=new JLabel();
		day=new JLabel();
		paymentMoney=new JLabel();
		paymentMoneyField=new JTextField();
		paymentPerson=new JLabel();
		paymentPersonField=new JTextField();
		paymentId=new JLabel();
		paymentIdField=new JTextField();
		entry=new JLabel();
		entryGroup=new ButtonGroup();
		carriage=new JRadioButton();
		reward=new JRadioButton();
		wages=new JRadioButton();
		rent=new JRadioButton();
		remarks=new JLabel();
		remarksArea=new JTextArea();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		paymentOrder.setBounds(218,10,180,30);
		paymentOrder.setText("付款单信息");
		paymentOrder.setHorizontalAlignment(SwingConstants.CENTER);
		paymentOrder.setFont(font1);
		paymentOrder.setBackground(Color.WHITE);
		paymentOrder.setOpaque(true);
		
		paymentDate.setBounds(40,50,90,24);
		paymentDate.setText("付款日期：");
		paymentDate.setFont(font2);
		paymentDate.setBackground(Color.WHITE);
		paymentDate.setOpaque(true);
		
		yearField.setBounds(130,52,48,20);
		
		year.setBounds(180,50,24,24);
		year.setText("年");
		year.setFont(font2);
		year.setBackground(Color.WHITE);
		year.setOpaque(true);
		
		monthField.setBounds(210,52,24,20);
		
		month.setBounds(240,50,24,24);
		month.setText("月");
		month.setFont(font2);
		month.setBackground(Color.WHITE);
		month.setOpaque(true);
		
		dayField.setBounds(270,52,24,20);
		
		day.setBounds(300,50,24,24);
		day.setText("日");
		day.setFont(font2);
		day.setBackground(Color.WHITE);
		day.setOpaque(true);
		
		paymentMoney.setBounds(40,80,90,24);
		paymentMoney.setText("付款金额：");
		paymentMoney.setFont(font2);
		paymentMoney.setBackground(Color.WHITE);
		paymentMoney.setOpaque(true);
		
		paymentMoneyField.setBounds(130,82,100,20);
		
		paymentPerson.setBounds(40,110,90,24);
		paymentPerson.setText("付款人：");
		paymentPerson.setFont(font2);
		paymentPerson.setBackground(Color.WHITE);
		paymentPerson.setOpaque(true);
		
		paymentPersonField.setBounds(130,112,100,20);
		
		paymentId.setBounds(40,140,90,24);
		paymentId.setText("付款账号：");
		paymentId.setFont(font2);
		paymentId.setBackground(Color.WHITE);
		paymentId.setOpaque(true);
		
		paymentIdField.setBounds(130,142,100,20);
		
		entry.setBounds(40,170,90,24);
		entry.setText("条目：");
		entry.setFont(font2);
		entry.setBackground(Color.WHITE);
		entry.setOpaque(true);
		
		carriage.setBounds(130,170,200,24);
		carriage.setText("运费（按次计算）");
		carriage.setFont(font2);
		carriage.setBackground(Color.WHITE);
		
		reward.setBounds(340,170,200,24);
		reward.setText("奖励（一次性）");
		reward.setFont(font2);
		reward.setBackground(Color.WHITE);
		
		wages.setBounds(130,200,200,24);
		wages.setText("人员工资（按月统计）");
		wages.setFont(font2);
		wages.setBackground(Color.WHITE);
		
		rent.setBounds(340,200,200,24);
		rent.setText("租金（按年收）");
		rent.setFont(font2);
		rent.setBackground(Color.WHITE);
		
		entryGroup.add(carriage);
		entryGroup.add(reward);
		entryGroup.add(wages);
		entryGroup.add(rent);
		
		remarks.setBounds(40,230,90,24);
		remarks.setText("备注：");
		remarks.setFont(font2);
		remarks.setBackground(Color.WHITE);
		remarks.setOpaque(true);
		
		remarksArea.setBounds(130,230,250,150);
		remarksArea.setFont(font2);
		remarksArea.setEnabled(true);
		remarksArea.setWrapStyleWord(true);
		remarksArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		remarksArea.setLineWrap(true);
		
		scroller=new JScrollPane(remarksArea);
		scroller.setBounds(130,230,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(paymentOrder);
		this.add(paymentDate);
		this.add(yearField);
		this.add(year);
		this.add(monthField);
		this.add(month);
		this.add(dayField);
		this.add(day);
		this.add(paymentMoney);
		this.add(paymentMoneyField);
		this.add(paymentPerson);
		this.add(paymentPersonField);
		this.add(paymentId);
		this.add(paymentIdField);
		this.add(entry);
		this.add(carriage);
		this.add(reward);
		this.add(wages);
		this.add(rent);
		this.add(remarks);
		this.add(scroller);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
