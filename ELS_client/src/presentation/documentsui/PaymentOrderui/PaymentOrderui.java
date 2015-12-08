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

import presentation.userui.Accountantui2;


public class PaymentOrderui extends JPanel{
	JLabel PaymentOrder;
	JLabel PaymentDate;
	JTextField YearField;
	JTextField MonthField;
	JTextField DayField;
	JLabel Year;
	JLabel Month;
	JLabel Day;
	JLabel PaymentMoney;
	JTextField PaymentMoneyField;
	JLabel PaymentPerson;
	JTextField PaymentPersonField;
	JLabel PaymentId;
	JTextField PaymentIdField;
	JLabel Entry;
	ButtonGroup EntryGroup;
	JRadioButton Carriage;
	JRadioButton Reward;
	JRadioButton Wages;
	JRadioButton Rent;
	JLabel Remarks;
	JTextArea RemarksArea;
	JScrollPane scroller;
	JButton MakeOrder;
	
	public static void main(String[] args){
		Accountantui2 ui=new Accountantui2();
		PaymentOrderui uiPanel=new PaymentOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public PaymentOrderui(){
		PaymentOrder=new JLabel();
		PaymentDate=new JLabel();
		YearField=new JTextField();
		MonthField=new JTextField();
		DayField=new JTextField();
		Year=new JLabel();
		Month=new JLabel();
		Day=new JLabel();
		PaymentMoney=new JLabel();
		PaymentMoneyField=new JTextField();
		PaymentPerson=new JLabel();
		PaymentPersonField=new JTextField();
		PaymentId=new JLabel();
		PaymentIdField=new JTextField();
		Entry=new JLabel();
		EntryGroup=new ButtonGroup();
		Carriage=new JRadioButton();
		Reward=new JRadioButton();
		Wages=new JRadioButton();
		Rent=new JRadioButton();
		Remarks=new JLabel();
		RemarksArea=new JTextArea();
		MakeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		PaymentOrder.setBounds(218,10,180,30);
		PaymentOrder.setText("付款单信息");
		PaymentOrder.setHorizontalAlignment(SwingConstants.CENTER);
		PaymentOrder.setFont(font1);
		PaymentOrder.setBackground(Color.WHITE);
		PaymentOrder.setOpaque(true);
		
		PaymentDate.setBounds(40,50,90,24);
		PaymentDate.setText("付款日期：");
		PaymentDate.setFont(font2);
		PaymentDate.setBackground(Color.WHITE);
		PaymentDate.setOpaque(true);
		
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
		
		PaymentMoney.setBounds(40,80,90,24);
		PaymentMoney.setText("付款金额：");
		PaymentMoney.setFont(font2);
		PaymentMoney.setBackground(Color.WHITE);
		PaymentMoney.setOpaque(true);
		
		PaymentMoneyField.setBounds(130,82,100,20);
		
		PaymentPerson.setBounds(40,110,90,24);
		PaymentPerson.setText("付款人：");
		PaymentPerson.setFont(font2);
		PaymentPerson.setBackground(Color.WHITE);
		PaymentPerson.setOpaque(true);
		
		PaymentPersonField.setBounds(130,112,100,20);
		
		PaymentId.setBounds(40,140,90,24);
		PaymentId.setText("付款账号：");
		PaymentId.setFont(font2);
		PaymentId.setBackground(Color.WHITE);
		PaymentId.setOpaque(true);
		
		PaymentIdField.setBounds(130,142,100,20);
		
		Entry.setBounds(40,170,90,24);
		Entry.setText("条目：");
		Entry.setFont(font2);
		Entry.setBackground(Color.WHITE);
		Entry.setOpaque(true);
		
		Carriage.setBounds(130,170,200,24);
		Carriage.setText("运费（按次计算）");
		Carriage.setFont(font2);
		Carriage.setBackground(Color.WHITE);
		
		Reward.setBounds(340,170,200,24);
		Reward.setText("奖励（一次性）");
		Reward.setFont(font2);
		Reward.setBackground(Color.WHITE);
		
		Wages.setBounds(130,200,200,24);
		Wages.setText("人员工资（按月统计）");
		Wages.setFont(font2);
		Wages.setBackground(Color.WHITE);
		
		Rent.setBounds(340,200,200,24);
		Rent.setText("租金（按年收）");
		Rent.setFont(font2);
		Rent.setBackground(Color.WHITE);
		
		EntryGroup.add(Carriage);
		EntryGroup.add(Reward);
		EntryGroup.add(Wages);
		EntryGroup.add(Rent);
		
		Remarks.setBounds(40,230,90,24);
		Remarks.setText("备注：");
		Remarks.setFont(font2);
		Remarks.setBackground(Color.WHITE);
		Remarks.setOpaque(true);
		
		RemarksArea.setBounds(130,230,250,150);
		RemarksArea.setFont(font2);
		RemarksArea.setEnabled(true);
		RemarksArea.setWrapStyleWord(true);
		RemarksArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		RemarksArea.setLineWrap(true);
		
		scroller=new JScrollPane(RemarksArea);
		scroller.setBounds(130,230,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(PaymentOrder);
		this.add(PaymentDate);
		this.add(YearField);
		this.add(Year);
		this.add(MonthField);
		this.add(Month);
		this.add(DayField);
		this.add(Day);
		this.add(PaymentMoney);
		this.add(PaymentMoneyField);
		this.add(PaymentPerson);
		this.add(PaymentPersonField);
		this.add(PaymentId);
		this.add(PaymentIdField);
		this.add(Entry);
		this.add(Carriage);
		this.add(Reward);
		this.add(Wages);
		this.add(Rent);
		this.add(Remarks);
		this.add(scroller);
		this.add(MakeOrder);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
