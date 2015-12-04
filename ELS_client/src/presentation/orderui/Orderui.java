package presentation.orderui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import presentation.userui.Courierui;

public class Orderui extends JPanel{
	JLabel Order;
	JLabel Sender;
	TitledBorder SenderBorder;
	JLabel SenderName;
	JTextField SenderNameField;
	JLabel SenderAddress;
	JTextField SenderAddressField;
	JLabel SenderCompany;
	JTextField SenderCompanyField;
	JLabel SenderPhone;
	JTextField SenderPhoneField;
	JLabel SenderMobile;
	JTextField SenderMobileField;
	JLabel Receiver;
	TitledBorder ReceiverBorder;
	JLabel ReceiverName;
	JTextField ReceiverNameField;
	JLabel ReceiverAddress;
	JTextField ReceiverAddressField;
	JLabel ReceiverCompany;
	JTextField ReceiverCompanyField;
	JLabel ReceiverPhone;
	JTextField ReceiverPhoneField;
	JLabel ReceiverMobile;
	JTextField ReceiverMobileField;
	JLabel Other;
	TitledBorder OtherBorder;
	JLabel GoodNum;
	JTextField GoodNumField;
	JLabel GoodName;
	JTextField GoodNameField;
	JLabel GoodWeight;
	JTextField GoodWeightField;
	JLabel GoodVolume;
	JTextField GoodVolumeField;
	JLabel Pack;
	JRadioButton Paper;
	JRadioButton Wood;
	JRadioButton Bag;
	ButtonGroup PackGroup;
	JLabel ExpressType;
	JRadioButton Economic;
	JRadioButton Standard;
	JRadioButton EMS;
	ButtonGroup ExpressTypeGroup;
	JLabel Carriage;
	JTextField CarriageField;
	JLabel ActualReceiver;
	JTextField ActualReceiverField;
	public JButton MakeOrder;
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
		Orderui uiPanel=new Orderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public Orderui() {
		Order=new JLabel();
		Sender=new JLabel();
		SenderBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"寄件人");
		SenderName=new JLabel();
		SenderNameField=new JTextField();
		SenderAddress=new JLabel();
		SenderAddressField=new JTextField();
		SenderCompany=new JLabel();
		SenderCompanyField=new JTextField();
		SenderPhone=new JLabel();
		SenderPhoneField=new JTextField();
		SenderMobile=new JLabel();
		SenderMobileField=new JTextField();
		Receiver=new JLabel();
		ReceiverBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"收件人");
		ReceiverName=new JLabel();
		ReceiverNameField=new JTextField();
		ReceiverAddress=new JLabel();
		ReceiverAddressField=new JTextField();
		ReceiverCompany=new JLabel();
		ReceiverCompanyField=new JTextField();
		ReceiverPhone=new JLabel();
		ReceiverPhoneField=new JTextField();
		ReceiverMobile=new JLabel();
		ReceiverMobileField=new JTextField();
		Other=new JLabel();
		OtherBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"其他");
		GoodNum=new JLabel();
		GoodNumField=new JTextField();
		GoodName=new JLabel();
		GoodNameField=new JTextField();
		GoodWeight=new JLabel();
		GoodWeightField=new JTextField();
		GoodVolume=new JLabel();
		GoodVolumeField=new JTextField();
		Pack=new JLabel();
		Paper=new JRadioButton();
		Wood=new JRadioButton();
		Bag=new JRadioButton();
		PackGroup=new ButtonGroup();
		ExpressType=new JLabel();
		Economic=new JRadioButton();
		Standard=new JRadioButton();
		EMS=new JRadioButton();
		ExpressTypeGroup=new ButtonGroup();
		Carriage=new JLabel();
		CarriageField=new JTextField();
		ActualReceiver=new JLabel();
		ActualReceiverField=new JTextField();
		MakeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font4=new Font("TimesRoman",Font.BOLD,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		Order.setBounds(218,10,180,30);
		Order.setText("订单信息");
		Order.setHorizontalAlignment(SwingConstants.CENTER);
		Order.setFont(font1);
		Order.setBackground(Color.WHITE);
		Order.setOpaque(true);
		
		Sender.setBounds(30,45,270,180);
		Sender.setBorder(SenderBorder);
		Sender.setBackground(Color.WHITE);
		Sender.setOpaque(true);
		
		SenderName.setBounds(30,20,60,24);
		SenderName.setText("姓名：");
		SenderName.setFont(font5);
		SenderName.setBackground(Color.WHITE);
		SenderName.setOpaque(true);
		
		SenderNameField.setBounds(90,22,160,20);
		
		SenderAddress.setBounds(30,50,60,20);
		SenderAddress.setText("住址：");
		SenderAddress.setFont(font5);
		SenderAddress.setBackground(Color.WHITE);
		SenderAddress.setOpaque(true);
		
		SenderAddressField.setBounds(90,52,160,20);
		
		SenderCompany.setBounds(30,80,60,24);
		SenderCompany.setText("单位：");
		SenderCompany.setFont(font5);
		SenderCompany.setBackground(Color.WHITE);
		SenderCompany.setOpaque(true);
		
		SenderCompanyField.setBounds(90,82,160,20);
		
		SenderPhone.setBounds(30,110,60,24);
		SenderPhone.setText("电话：");
		SenderPhone.setFont(font5);
		SenderPhone.setBackground(Color.WHITE);
		SenderPhone.setOpaque(true);
		
		SenderPhoneField.setBounds(90,112,160,20);
		
		SenderMobile.setBounds(30,140,60,24);
		SenderMobile.setText("手机：");
		SenderMobile.setFont(font5);
		SenderMobile.setBackground(Color.WHITE);
		SenderMobile.setOpaque(true);
		
		SenderMobileField.setBounds(90,142,160,20);
		
		Sender.add(SenderName);
		Sender.add(SenderAddress);
		Sender.add(SenderCompany);
		Sender.add(SenderPhone);
		Sender.add(SenderMobile);
		
		Sender.add(SenderNameField);
		Sender.add(SenderAddressField);
		Sender.add(SenderCompanyField);
		Sender.add(SenderPhoneField);
		Sender.add(SenderMobileField);
		
		Receiver.setBounds(320,45,270,180);
		Receiver.setBorder(ReceiverBorder);
		Receiver.setBackground(Color.WHITE);
		Receiver.setOpaque(true);
		
		ReceiverName.setBounds(30,20,60,24);
		ReceiverName.setText("姓名：");
		ReceiverName.setFont(font5);
		ReceiverName.setBackground(Color.WHITE);
		ReceiverName.setOpaque(true);
		
		ReceiverNameField.setBounds(90,22,160,20);
		
		ReceiverAddress.setBounds(30,50,60,20);
		ReceiverAddress.setText("住址：");
		ReceiverAddress.setFont(font5);
		ReceiverAddress.setBackground(Color.WHITE);
		ReceiverAddress.setOpaque(true);
		
		ReceiverAddressField.setBounds(90,52,160,20);
		
		ReceiverCompany.setBounds(30,80,60,24);
		ReceiverCompany.setText("单位：");
		ReceiverCompany.setFont(font5);
		ReceiverCompany.setBackground(Color.WHITE);
		ReceiverCompany.setOpaque(true);
		
		ReceiverCompanyField.setBounds(90,82,160,20);
		
		ReceiverPhone.setBounds(30,110,60,24);
		ReceiverPhone.setText("电话：");
		ReceiverPhone.setFont(font5);
		ReceiverPhone.setBackground(Color.WHITE);
		ReceiverPhone.setOpaque(true);
		
		ReceiverPhoneField.setBounds(90,112,160,20);
		
		ReceiverMobile.setBounds(30,140,60,24);
		ReceiverMobile.setText("手机：");
		ReceiverMobile.setFont(font5);
		ReceiverMobile.setBackground(Color.WHITE);
		ReceiverMobile.setOpaque(true);
		
		ReceiverMobileField.setBounds(90,142,160,20);
		
		Receiver.add(ReceiverName);
		Receiver.add(ReceiverAddress);
		Receiver.add(ReceiverCompany);
		Receiver.add(ReceiverPhone);
		Receiver.add(ReceiverMobile);
		
		Receiver.add(ReceiverNameField);
		Receiver.add(ReceiverAddressField);
		Receiver.add(ReceiverCompanyField);
		Receiver.add(ReceiverPhoneField);
		Receiver.add(ReceiverMobileField);
		
		Other.setBounds(30,230,560,180);
		Other.setBorder(OtherBorder);
		Other.setBackground(Color.WHITE);
		Other.setOpaque(true);
		
		GoodNum.setBounds(30,20,80,24);
		GoodNum.setText("托运数量：");
		GoodNum.setFont(font5);
		GoodNum.setBackground(Color.WHITE);
		GoodNum.setOpaque(true);
		
		GoodNumField.setBounds(110,22,80,20);
		
		GoodName.setBounds(240,20,80,24);
		GoodName.setText("内件品名：");
		GoodName.setFont(font5);
		GoodName.setBackground(Color.WHITE);
		GoodName.setOpaque(true);
		
		GoodNameField.setBounds(320,22,120,20);
		
		GoodWeight.setBounds(30,50,60,24);
		GoodWeight.setText("重量：");
		GoodWeight.setFont(font5);
		GoodWeight.setBackground(Color.WHITE);
		GoodWeight.setOpaque(true);
		
		GoodWeightField.setBounds(110,52,80,20);
		
		GoodVolume.setBounds(240,50,60,24);
		GoodVolume.setText("体积：");
		GoodVolume.setFont(font5);
		GoodVolume.setBackground(Color.WHITE);
		GoodVolume.setOpaque(true);
		
		GoodVolumeField.setBounds(320,52,80,20);
		
		Pack.setBounds(30,80,60,24);
		Pack.setText("包装费：");
		Pack.setFont(font5);
		Pack.setBackground(Color.WHITE);
		Pack.setOpaque(true);
		
		Paper.setBounds(90,80,120,24);
		Paper.setText("纸箱（5元）");
		Paper.setFont(font5);
		Paper.setBackground(Color.WHITE);
		
		Wood.setBounds(210,80,120,24);
		Wood.setText("木箱（10元）");
		Wood.setFont(font5);
		Wood.setBackground(Color.WHITE);
		
		Bag.setBounds(330,80,120,24);
		Bag.setText("快递袋（1元）");
		Bag.setFont(font5);
		Bag.setBackground(Color.WHITE);
		
		PackGroup.add(Paper);
		PackGroup.add(Wood);
		PackGroup.add(Bag);
		
		ExpressType.setBounds(30,110,80,24);
		ExpressType.setText("快递类型：");
		ExpressType.setFont(font5);
		ExpressType.setBackground(Color.WHITE);
		ExpressType.setOpaque(true);
		
		Economic.setBounds(110,110,120,24);
		Economic.setText("经济快递");
		Economic.setFont(font5);
		Economic.setBackground(Color.WHITE);
		
		Standard.setBounds(230,110,120,24);
		Standard.setText("标准快递");
		Standard.setFont(font5);
		Standard.setBackground(Color.WHITE);
		
		EMS.setBounds(350,110,120,24);
		EMS.setText("特快专递");
		EMS.setFont(font5);
		EMS.setBackground(Color.WHITE);
		
		ExpressTypeGroup.add(Economic);
		ExpressTypeGroup.add(Standard);
		ExpressTypeGroup.add(EMS);
		
		Carriage.setBounds(30,140,80,24);
		Carriage.setText("总费用：");
		Carriage.setFont(font5);
		Carriage.setBackground(Color.WHITE);
		Carriage.setOpaque(true);
		
		CarriageField.setBounds(110,142,80,20);
		CarriageField.setEditable(false);
		CarriageField.setBackground(Color.WHITE);
		CarriageField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		ActualReceiver.setBounds(240,140,80,24);
		ActualReceiver.setText("代收人：");
		ActualReceiver.setFont(font5);
		ActualReceiver.setBackground(Color.WHITE);
		ActualReceiver.setOpaque(true);
		
		ActualReceiverField.setBounds(300,142,80,20);
		ActualReceiverField.setEditable(false);
		ActualReceiverField.setBackground(Color.WHITE);
		ActualReceiverField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		Other.add(GoodNum);
		Other.add(GoodName);
		Other.add(GoodNumField);
		Other.add(GoodNameField);
		Other.add(GoodWeight);
		Other.add(GoodVolume);
		Other.add(GoodWeightField);
		Other.add(GoodVolumeField);
		Other.add(Pack);
		Other.add(Paper);
		Other.add(Wood);
		Other.add(Bag);
		Other.add(ExpressType);
		Other.add(Economic);
		Other.add(Standard);
		Other.add(EMS);
		Other.add(Carriage);
		Other.add(CarriageField);
		Other.add(ActualReceiver);
		Other.add(ActualReceiverField);
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(Order);
		this.add(Sender);
		this.add(Receiver);
		this.add(Other);
		this.add(MakeOrder);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}

	public Orderui(CardLayout cardLayout) {
		super(cardLayout);
	}
}
