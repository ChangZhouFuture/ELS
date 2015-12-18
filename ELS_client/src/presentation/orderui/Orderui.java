package presentation.orderui;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.TextEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;
import java.util.InputMismatchException;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.TextAction;

import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.ParentDocuments;
import presentation.reuse.TextListener;
import presentation.userui.Courierui;
import vo.orderVO.OrderVO;

public class Orderui extends ParentDocuments{
	public JLabel order;
	public JLabel sender;
	public JLabel senderName;
	public JLabel senderAddress;
	public JLabel senderCompany;
	public JLabel senderPhone;
	public JLabel receiver;
	public JLabel receiverName;
	public JLabel receiverCompany;
	public JLabel receiverAddress;
	public JLabel other;
	public JLabel receiverPhone;
	public JLabel goodSize;
	public JLabel goodName;
	public JLabel goodWeight;
	public JLabel goodNum;
	public JLabel pack;
	public JLabel expressType;
	public JLabel freight;
	public JLabel amount;
	public JLabel actualReceiver;
	public JLabel expectedArrivalDate;
	public JLabel trueArrivalDate;
	public JTextField senderNameField;
	public JTextField senderAddressField;
	public JTextField senderCompanyField;
	public JTextField senderPhoneField;	
	public JTextField receiverNameField;
	public JTextField receiverAddressField;
	public JTextField receiverCompanyField;
	public JTextField receiverPhoneField;
	public JTextField goodNumField;
	public JTextField goodNameField;
	public JTextField goodWeightField;
	public JTextField goodSizeField;
	public JTextField amountField;
	public JTextField actualReceiverField;
	public JTextField trueArrivalDateField;
	public TitledBorder receiverBorder;
	public TitledBorder senderBorder;
	public TitledBorder otherBorder;
	public ButtonGroup packGroup;
	public ButtonGroup expressTypeGroup;
	Orderblservice orderblservice;
	OrderVO orderVO;
	
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
		other=new JLabel();
		otherBorder=new TitledBorder(BorderFactory.createLineBorder(Color.lightGray),"其他");
		goodNum=new JLabel();
		goodNumField=new JTextField();
		goodName=new JLabel();
		goodNameField=new JTextField();
		goodWeight=new JLabel();
		goodWeightField=new JTextField();
		goodSize=new JLabel();
		goodSizeField=new JTextField();
		pack=new JLabel();
		packGroup=new ButtonGroup();
		expressType=new JLabel();
		expressTypeGroup=new ButtonGroup();
		freight = new JLabel();
		amount=new JLabel();
		amountField=new JTextField();
		actualReceiver=new JLabel();
		actualReceiverField=new JTextField();
		expectedArrivalDate=new JLabel();
		trueArrivalDate=new JLabel();
		trueArrivalDateField=new JTextField();
		orderVO=new OrderVO();
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font4=new Font("TimesRoman",Font.BOLD,17);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		order.setBounds(218,10,180,30);
		order.setText("订单信息");
		order.setHorizontalAlignment(SwingConstants.CENTER);
		order.setFont(font1);
		order.setBackground(Color.WHITE);
		order.setOpaque(true);
		
		sender.setBounds(30,50,270,160);
		sender.setBorder(senderBorder);
		sender.setBackground(Color.WHITE);
		sender.setOpaque(true);
		
		senderName.setBounds(30,25,60,24);
		senderName.setText("姓名：");
		senderName.setFont(font5);
		senderName.setBackground(Color.WHITE);
		senderName.setOpaque(true);
		
		senderNameField.setBounds(90,27,160,20);
		
		senderAddress.setBounds(30,55,60,20);
		senderAddress.setText("住址：");
		senderAddress.setFont(font5);
		senderAddress.setBackground(Color.WHITE);
		senderAddress.setOpaque(true);
		
		senderAddressField.setBounds(90,57,160,20);
		
		senderCompany.setBounds(30,85,60,24);
		senderCompany.setText("单位：");
		senderCompany.setFont(font5);
		senderCompany.setBackground(Color.WHITE);
		senderCompany.setOpaque(true);
		
		senderCompanyField.setBounds(90,87,160,20);
		
		senderPhone.setBounds(30,115,60,24);
		senderPhone.setText("电话：");
		senderPhone.setFont(font5);
		senderPhone.setBackground(Color.WHITE);
		senderPhone.setOpaque(true);
		
		senderPhoneField.setBounds(90,117,160,20);
		
		sender.add(senderName);
		sender.add(senderAddress);
		sender.add(senderCompany);
		sender.add(senderPhone);
		
		sender.add(senderNameField);
		sender.add(senderAddressField);
		sender.add(senderCompanyField);
		sender.add(senderPhoneField);
		
		receiver.setBounds(320,50,270,160);
		receiver.setBorder(receiverBorder);
		receiver.setBackground(Color.WHITE);
		receiver.setOpaque(true);
		
		receiverName.setBounds(30,25,60,24);
		receiverName.setText("姓名：");
		receiverName.setFont(font5);
		receiverName.setBackground(Color.WHITE);
		receiverName.setOpaque(true);
		
		receiverNameField.setBounds(90,27,160,20);
		
		receiverAddress.setBounds(30,55,60,20);
		receiverAddress.setText("住址：");
		receiverAddress.setFont(font5);
		receiverAddress.setBackground(Color.WHITE);
		receiverAddress.setOpaque(true);
		
		receiverAddressField.setBounds(90,57,160,20);
		
		receiverCompany.setBounds(30,85,60,24);
		receiverCompany.setText("单位：");
		receiverCompany.setFont(font5);
		receiverCompany.setBackground(Color.WHITE);
		receiverCompany.setOpaque(true);
		
		receiverCompanyField.setBounds(90,87,160,20);
		
		receiverPhone.setBounds(30,115,60,24);
		receiverPhone.setText("电话：");
		receiverPhone.setFont(font5);
		receiverPhone.setBackground(Color.WHITE);
		receiverPhone.setOpaque(true);
		
		receiverPhoneField.setBounds(90,117,160,20);
		
		receiver.add(receiverName);
		receiver.add(receiverAddress);
		receiver.add(receiverCompany);
		receiver.add(receiverPhone);
		
		receiver.add(receiverNameField);
		receiver.add(receiverAddressField);
		receiver.add(receiverCompanyField);
		receiver.add(receiverPhoneField);

		other.setBounds(30,215,560,210);
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
		goodWeightField.getDocument().addDocumentListener(new TextListener(
				goodWeightField));
		
		goodSize.setBounds(240,50,60,24);
		goodSize.setText("体积：");
		goodSize.setFont(font5);
		goodSize.setBackground(Color.WHITE);
		goodSize.setOpaque(true);
		
		goodSizeField.setBounds(320,52,80,20);
		goodSizeField.getDocument().addDocumentListener(new TextListener(
				goodSizeField));
		
		pack.setBounds(30,80,60,24);
		pack.setText("包装：");
		pack.setFont(font5);
		pack.setBackground(Color.WHITE);
		pack.setOpaque(true);
		
		freight.setBounds(152,80,60,24);
		freight.setText("运费：");
		freight.setFont(font5);
		freight.setBackground(Color.WHITE);
		freight.setOpaque(true);
		//到时候直接跟在后面写运费是多少
		
		amount.setBounds(255,80,80,24);
		amount.setText("总费用：");
		amount.setFont(font5);
		amount.setBackground(Color.WHITE);
		amount.setOpaque(true);
		
		expressType.setBounds(30,110,80,24);
		expressType.setText("快递类型：");
		expressType.setFont(font5);
		expressType.setBackground(Color.WHITE);
		expressType.setOpaque(true);
		
		amountField.setBounds(110,172,80,20);
		amountField.setEditable(false);
		amountField.setBackground(Color.WHITE);
		amountField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		actualReceiver.setBounds(240,140,80,24);//注意，要改
		actualReceiver.setText("代收人：");
		actualReceiver.setFont(font5);
		actualReceiver.setBackground(Color.WHITE);
		actualReceiver.setVisible(false);
		
		actualReceiverField.setBounds(300,142,80,20);
		actualReceiverField.setEditable(false);
		actualReceiverField.setBackground(Color.WHITE);
		actualReceiverField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		expectedArrivalDate.setBounds(30,140,100,24);
		expectedArrivalDate.setText("预计到达时间：");
		expectedArrivalDate.setFont(font5);
		expectedArrivalDate.setBackground(Color.WHITE);
		expectedArrivalDate.setOpaque(true);
		
		trueArrivalDate.setBounds(240,170,100,24);
		trueArrivalDate.setText("实际到达时间：");
		trueArrivalDate.setFont(font5);
		trueArrivalDate.setBackground(Color.WHITE);
		trueArrivalDate.setVisible(false);
		
		trueArrivalDateField.setBounds(340,232,100,20);
		trueArrivalDateField.setEditable(false);
		trueArrivalDateField.setBackground(Color.WHITE);
		trueArrivalDateField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		other.add(goodNum);
		other.add(goodName);
		other.add(goodNumField);
		other.add(goodNameField);
		other.add(goodWeight);
		other.add(goodSize);
		other.add(goodWeightField);
		other.add(goodSizeField);
		other.add(pack);
		other.add(expressType);
		other.add(freight);
		other.add(amount);
		other.add(amountField);
		other.add(actualReceiver);
		other.add(expectedArrivalDate);
		other.add(trueArrivalDate);
		other.add(trueArrivalDateField);
		
		makeOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
//				double packingCharge=0;
//				orderblservice=new Order();
//				double totalcost=orderblservice.calculateFreight(receiverAddressField.getText())+packingCharge;
//				carriageField.setText(String.valueOf(totalcost));
//				expectedArrivalDateField.setText(orderblservice.generateExpectedArrivalDate());
				approState.setText("未审批");
				orderVO.setSenderName(senderNameField.getText());
				orderVO.setSenderAdd(senderAddressField.getText());
				orderVO.setSenderCompany(senderCompanyField.getText());
				orderVO.setSenderPhoneNumber(senderPhoneField.getText());
				orderVO.setAddresseeName(receiverNameField.getText());;
				orderVO.setAddresseeAdd(receiverAddressField.getText());
				orderVO.setAddresseeCompany(receiverCompanyField.getText());
				orderVO.setAddresseePhoneNumber(receiverPhoneField.getText());
//				orderVO.setExpectedArrivalDate(orderblservice.generateExpectedArrivalDate());
//				orderVO.setExpressType(express);
//				orderVO.setTotalCost(totalcost);
				orderVO.setSize(Double.valueOf(goodSizeField.getText()));
				orderVO.setWeight(Double.valueOf(goodWeightField.getText()));
				orderVO.setGoodsName(goodNameField.getText());
//				orderVO.setGenerateDate(orderblservice.generateDate());
//				orderVO.setGenerateTime(orderblservice.generateDate());
//				orderVO.setId(orderblservice.generateId());
				orderblservice.add(orderVO);
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				senderNameField.setEditable(false);
				senderAddressField.setEditable(false);
				senderCompanyField.setEditable(false);
				senderPhoneField.setEditable(false);
				receiverNameField.setEditable(false);
				receiverAddressField.setEditable(false);
				receiverCompanyField.setEditable(false);
				receiverPhoneField.setEditable(false);
				goodNumField.setEditable(false);
				goodNameField.setEditable(false);
				goodWeightField.setEditable(false);
				goodSizeField.setEditable(false);
				amountField.setEditable(false);
				double packingCharge=0;
//				double totalcost=orderblservice.calculateFreight(receiverAddressField.getText())+packingCharge;
//				carriageField.setText(String.valueOf(totalcost));
//				expectedArrivalDateField.setText(orderblservice.generateExpectedArrivalDate());
				orderVO.setSenderName(senderNameField.getText());
				orderVO.setSenderAdd(senderAddressField.getText());
				orderVO.setSenderCompany(senderCompanyField.getText());
				orderVO.setSenderPhoneNumber(senderPhoneField.getText());
				orderVO.setAddresseeName(receiverNameField.getText());;
				orderVO.setAddresseeAdd(receiverAddressField.getText());
				orderVO.setAddresseeCompany(receiverCompanyField.getText());
				orderVO.setAddresseePhoneNumber(receiverPhoneField.getText());
//				orderVO.setExpectedArrivalDate(orderblservice.generateExpectedArrivalDate());
//				orderVO.setExpressType(express);
//				orderVO.setTotalCost(totalcost);
				orderVO.setSize(Double.valueOf(goodSizeField.getText()));
				orderVO.setWeight(Double.valueOf(goodWeightField.getText()));
				orderVO.setGoodsName(goodNameField.getText());
//				orderVO.setGenerateTime(orderblservice.generateDate());
				orderblservice.modify(orderVO);
			}
		});
		
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(order);
		this.add(sender);
		this.add(receiver);
		this.add(other);
	}
	
	public void refresh() {
		senderNameField.setEditable(false);
		senderAddressField.setEditable(false);
		senderCompanyField.setEditable(false);
		senderPhoneField.setEditable(false);
		receiverNameField.setEditable(false);
		receiverAddressField.setEditable(false);
		receiverCompanyField.setEditable(false);
		receiverPhoneField.setEditable(false);
		goodNumField.setEditable(false);
		goodNameField.setEditable(false);
		goodWeightField.setEditable(false);
		goodSizeField.setEditable(false);
		amountField.setEditable(false);
		
		senderNameField.setBackground(Color.white);
//		senderNameField.setBorder(null);
		senderAddressField.setBackground(Color.white);
		senderCompanyField.setBackground(Color.white);
		senderPhoneField.setBackground(Color.white);
		receiverAddressField.setBackground(Color.white);
		receiverNameField.setBackground(Color.white);
		receiverCompanyField.setBackground(Color.white);
		receiverPhoneField.setBackground(Color.white);
		goodNameField.setBackground(Color.white);
		goodNumField.setBackground(Color.white);
		goodWeightField.setBackground(Color.white);
		goodSizeField.setBackground(Color.white);
		amountField.setBackground(Color.white);

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		
	}
	
	public void checking(OrderVO orderVO) {
		//把VO的参数都设置进来
	}

	public void modifying() {
		senderNameField.setEditable(true);
		senderAddressField.setEditable(true);
		senderCompanyField.setEditable(true);
		senderPhoneField.setEditable(true);
		receiverNameField.setEditable(true);
		receiverAddressField.setEditable(true);
		receiverCompanyField.setEditable(true);
		receiverPhoneField.setEditable(true);
		goodNumField.setEditable(true);
		goodNameField.setEditable(true);
		goodWeightField.setEditable(true);
		goodSizeField.setEditable(true);
		amountField.setEditable(true);
	}
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
		Orderui uiPanel=new Orderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
}
