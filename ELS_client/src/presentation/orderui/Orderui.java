package presentation.orderui;

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
	JLabel order;
	JLabel sender;
	JLabel senderName;
	JLabel senderAddress;
	JLabel senderCompany;
	JLabel senderPhone;
	JLabel senderMobile;
	JLabel receiver;
	JLabel receiverName;
	JLabel receiverCompany;
	JLabel receiverAddress;
	JLabel other;
	JLabel receiverMobile;
	JLabel receiverPhone;
	JLabel goodVolume;
	JLabel goodName;
	JLabel goodWeight;
	JLabel goodNum;
	JLabel pack;
	JLabel expressType;
	JLabel carriage;
	JLabel actualReceiver;
	JTextField senderNameField;
	JTextField senderAddressField;
	JTextField senderCompanyField;
	JTextField senderPhoneField;
	JTextField receiverNameField;
	JTextField senderMobileField;
	JTextField receiverAddressField;
	JTextField receiverCompanyField;
	JTextField receiverPhoneField;
	JTextField receiverMobileField;
	JTextField goodNumField;
	JTextField goodNameField;
	JTextField goodWeightField;
	JTextField goodVolumeField;
	JTextField carriageField;
	JTextField actualReceiverField;
	TitledBorder receiverBorder;
	TitledBorder senderBorder;
	TitledBorder otherBorder;
	JRadioButton paper;
	JRadioButton wood;
	JRadioButton bag;
	JRadioButton economic;
	JRadioButton standard;
	JRadioButton eMS;
	ButtonGroup packGroup;
	ButtonGroup expressTypeGroup;
	public JButton makeOrder;
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
		Orderui uiPanel=new Orderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public Orderui() {
		order=new JLabel();
		sender=new JLabel();
		senderBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"寄件人");
		senderName=new JLabel();
		senderNameField=new JTextField();
		senderAddress=new JLabel();
		senderAddressField=new JTextField();
		senderCompany=new JLabel();
		senderCompanyField=new JTextField();
		senderPhone=new JLabel();
		senderPhoneField=new JTextField();
		senderMobile=new JLabel();
		senderMobileField=new JTextField();
		receiver=new JLabel();
		receiverBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"收件人");
		receiverName=new JLabel();
		receiverNameField=new JTextField();
		receiverAddress=new JLabel();
		receiverAddressField=new JTextField();
		receiverCompany=new JLabel();
		receiverCompanyField=new JTextField();
		receiverPhone=new JLabel();
		receiverPhoneField=new JTextField();
		receiverMobile=new JLabel();
		receiverMobileField=new JTextField();
		other=new JLabel();
		otherBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"其他");
		goodNum=new JLabel();
		goodNumField=new JTextField();
		goodName=new JLabel();
		goodNameField=new JTextField();
		goodWeight=new JLabel();
		goodWeightField=new JTextField();
		goodVolume=new JLabel();
		goodVolumeField=new JTextField();
		pack=new JLabel();
		paper=new JRadioButton();
		wood=new JRadioButton();
		bag=new JRadioButton();
		packGroup=new ButtonGroup();
		expressType=new JLabel();
		economic=new JRadioButton();
		standard=new JRadioButton();
		eMS=new JRadioButton();
		expressTypeGroup=new ButtonGroup();
		carriage=new JLabel();
		carriageField=new JTextField();
		actualReceiver=new JLabel();
		actualReceiverField=new JTextField();
		makeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font4=new Font("TimesRoman",Font.BOLD,15);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		order.setBounds(218,10,180,30);
		order.setText("订单信息");
		order.setHorizontalAlignment(SwingConstants.CENTER);
		order.setFont(font1);
		order.setBackground(Color.WHITE);
		order.setOpaque(true);
		
		sender.setBounds(30,45,270,180);
		sender.setBorder(senderBorder);
		sender.setBackground(Color.WHITE);
		sender.setOpaque(true);
		
		senderName.setBounds(30,20,60,24);
		senderName.setText("姓名：");
		senderName.setFont(font5);
		senderName.setBackground(Color.WHITE);
		senderName.setOpaque(true);
		
		senderNameField.setBounds(90,22,160,20);
		
		senderAddress.setBounds(30,50,60,20);
		senderAddress.setText("住址：");
		senderAddress.setFont(font5);
		senderAddress.setBackground(Color.WHITE);
		senderAddress.setOpaque(true);
		
		senderAddressField.setBounds(90,52,160,20);
		
		senderCompany.setBounds(30,80,60,24);
		senderCompany.setText("单位：");
		senderCompany.setFont(font5);
		senderCompany.setBackground(Color.WHITE);
		senderCompany.setOpaque(true);
		
		senderCompanyField.setBounds(90,82,160,20);
		
		senderPhone.setBounds(30,110,60,24);
		senderPhone.setText("电话：");
		senderPhone.setFont(font5);
		senderPhone.setBackground(Color.WHITE);
		senderPhone.setOpaque(true);
		
		senderPhoneField.setBounds(90,112,160,20);
		
		senderMobile.setBounds(30,140,60,24);
		senderMobile.setText("手机：");
		senderMobile.setFont(font5);
		senderMobile.setBackground(Color.WHITE);
		senderMobile.setOpaque(true);
		
		senderMobileField.setBounds(90,142,160,20);
		
		sender.add(senderName);
		sender.add(senderAddress);
		sender.add(senderCompany);
		sender.add(senderPhone);
		sender.add(senderMobile);
		
		sender.add(senderNameField);
		sender.add(senderAddressField);
		sender.add(senderCompanyField);
		sender.add(senderPhoneField);
		sender.add(senderMobileField);
		
		receiver.setBounds(320,45,270,180);
		receiver.setBorder(receiverBorder);
		receiver.setBackground(Color.WHITE);
		receiver.setOpaque(true);
		
		receiverName.setBounds(30,20,60,24);
		receiverName.setText("姓名：");
		receiverName.setFont(font5);
		receiverName.setBackground(Color.WHITE);
		receiverName.setOpaque(true);
		
		receiverNameField.setBounds(90,22,160,20);
		
		receiverAddress.setBounds(30,50,60,20);
		receiverAddress.setText("住址：");
		receiverAddress.setFont(font5);
		receiverAddress.setBackground(Color.WHITE);
		receiverAddress.setOpaque(true);
		
		receiverAddressField.setBounds(90,52,160,20);
		
		receiverCompany.setBounds(30,80,60,24);
		receiverCompany.setText("单位：");
		receiverCompany.setFont(font5);
		receiverCompany.setBackground(Color.WHITE);
		receiverCompany.setOpaque(true);
		
		receiverCompanyField.setBounds(90,82,160,20);
		
		receiverPhone.setBounds(30,110,60,24);
		receiverPhone.setText("电话：");
		receiverPhone.setFont(font5);
		receiverPhone.setBackground(Color.WHITE);
		receiverPhone.setOpaque(true);
		
		receiverPhoneField.setBounds(90,112,160,20);
		
		receiverMobile.setBounds(30,140,60,24);
		receiverMobile.setText("手机：");
		receiverMobile.setFont(font5);
		receiverMobile.setBackground(Color.WHITE);
		receiverMobile.setOpaque(true);
		
		receiverMobileField.setBounds(90,142,160,20);
		
		receiver.add(receiverName);
		receiver.add(receiverAddress);
		receiver.add(receiverCompany);
		receiver.add(receiverPhone);
		receiver.add(receiverMobile);
		
		receiver.add(receiverNameField);
		receiver.add(receiverAddressField);
		receiver.add(receiverCompanyField);
		receiver.add(receiverPhoneField);
		receiver.add(receiverMobileField);
		
		other.setBounds(30,230,560,180);
		other.setBorder(otherBorder);
		other.setBackground(Color.WHITE);
		other.setOpaque(true);
		
		goodNum.setBounds(30,20,80,24);
		goodNum.setText("托运数量：");
		goodNum.setFont(font5);
		goodNum.setBackground(Color.WHITE);
		goodNum.setOpaque(true);
		
		goodNumField.setBounds(110,22,80,20);
		
		goodName.setBounds(240,20,80,24);
		goodName.setText("内件品名：");
		goodName.setFont(font5);
		goodName.setBackground(Color.WHITE);
		goodName.setOpaque(true);
		
		goodNameField.setBounds(320,22,120,20);
		
		goodWeight.setBounds(30,50,60,24);
		goodWeight.setText("重量：");
		goodWeight.setFont(font5);
		goodWeight.setBackground(Color.WHITE);
		goodWeight.setOpaque(true);
		
		goodWeightField.setBounds(110,52,80,20);
		
		goodVolume.setBounds(240,50,60,24);
		goodVolume.setText("体积：");
		goodVolume.setFont(font5);
		goodVolume.setBackground(Color.WHITE);
		goodVolume.setOpaque(true);
		
		goodVolumeField.setBounds(320,52,80,20);
		
		pack.setBounds(30,80,60,24);
		pack.setText("包装费：");
		pack.setFont(font5);
		pack.setBackground(Color.WHITE);
		pack.setOpaque(true);
		
		paper.setBounds(90,80,120,24);
		paper.setText("纸箱（5元）");
		paper.setFont(font5);
		paper.setBackground(Color.WHITE);
		
		wood.setBounds(210,80,120,24);
		wood.setText("木箱（10元）");
		wood.setFont(font5);
		wood.setBackground(Color.WHITE);
		
		bag.setBounds(330,80,120,24);
		bag.setText("快递袋（1元）");
		bag.setFont(font5);
		bag.setBackground(Color.WHITE);
		
		packGroup.add(paper);
		packGroup.add(wood);
		packGroup.add(bag);
		
		expressType.setBounds(30,110,80,24);
		expressType.setText("快递类型：");
		expressType.setFont(font5);
		expressType.setBackground(Color.WHITE);
		expressType.setOpaque(true);
		
		economic.setBounds(110,110,120,24);
		economic.setText("经济快递");
		economic.setFont(font5);
		economic.setBackground(Color.WHITE);
		
		standard.setBounds(230,110,120,24);
		standard.setText("标准快递");
		standard.setFont(font5);
		standard.setBackground(Color.WHITE);
		
		eMS.setBounds(350,110,120,24);
		eMS.setText("特快专递");
		eMS.setFont(font5);
		eMS.setBackground(Color.WHITE);
		
		expressTypeGroup.add(economic);
		expressTypeGroup.add(standard);
		expressTypeGroup.add(eMS);
		
		carriage.setBounds(30,140,80,24);
		carriage.setText("总费用：");
		carriage.setFont(font5);
		carriage.setBackground(Color.WHITE);
		carriage.setOpaque(true);
		
		carriageField.setBounds(110,142,80,20);
		carriageField.setEditable(false);
		carriageField.setBackground(Color.WHITE);
		carriageField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		actualReceiver.setBounds(240,140,80,24);
		actualReceiver.setText("代收人：");
		actualReceiver.setFont(font5);
		actualReceiver.setBackground(Color.WHITE);
		actualReceiver.setOpaque(true);
		
		actualReceiverField.setBounds(300,142,80,20);
		actualReceiverField.setEditable(false);
		actualReceiverField.setBackground(Color.WHITE);
		actualReceiverField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		other.add(goodNum);
		other.add(goodName);
		other.add(goodNumField);
		other.add(goodNameField);
		other.add(goodWeight);
		other.add(goodVolume);
		other.add(goodWeightField);
		other.add(goodVolumeField);
		other.add(pack);
		other.add(paper);
		other.add(wood);
		other.add(bag);
		other.add(expressType);
		other.add(economic);
		other.add(standard);
		other.add(eMS);
		other.add(carriage);
		other.add(carriageField);
		other.add(actualReceiver);
		other.add(actualReceiverField);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
				
		this.add(order);
		this.add(sender);
		this.add(receiver);
		this.add(other);
		this.add(makeOrder);
		this.setLocation(182,40);
		this.setSize(640,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}

}
