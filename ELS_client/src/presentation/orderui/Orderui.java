package presentation.orderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.ParentDocuments;
import presentation.reuse.TextListener;
import presentation.userui.Courierui;
import state.ExpressType;
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
	public JTextField freightField;
	public JTextField actualReceiverField;
	public JTextField trueArrivalDateField;
	public TitledBorder receiverBorder;
	public TitledBorder senderBorder;
	public TitledBorder otherBorder;
	public JComboBox expressTypeType;
	public JComboBox packType;
	public JButton sureReceive;
	public JButton makeSure;
	String expressValue="经济快递";
	String packValue="纸箱（5）";
	double packing=5.0;
	ExpressType expressTypeSeletion=ExpressType.Economic;
	Orderblservice orderblservice;
	public OrderVO orderVO;
	JavaBean1 javaBean1;
	
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
		expressType=new JLabel();
		freight = new JLabel();
		freightField=new JTextField();
		amount=new JLabel();
		amountField=new JTextField();
		sureReceive=new JButton();
		makeSure=new JButton();
		actualReceiver=new JLabel();
		actualReceiverField=new JTextField();
		expectedArrivalDate=new JLabel();
		trueArrivalDate=new JLabel();
		trueArrivalDateField=new JTextField();
		String[] expressTypeEntries={"经济快递","标准快递","特快专递"};
		expressTypeType=new JComboBox(expressTypeEntries);
		String[] packEntries={"纸箱（5）","木箱（10）","纸袋（1）"};
		packType=new JComboBox(packEntries);
		orderVO=new OrderVO();
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font4=new Font("TimesRoman",Font.BOLD,17);
		Font font5=new Font("TimesRoman",Font.PLAIN,14);
		order.setBounds(218,10,180,30);
		order.setText("订单信息");
		order.setHorizontalAlignment(SwingConstants.CENTER);
		order.setFont(font1);
		order.setBackground(Color.WHITE);
		
		sender.setBounds(30,50,270,160);
		sender.setBorder(senderBorder);
		sender.setBackground(Color.WHITE);
		
		senderName.setBounds(30,25,60,24);
		senderName.setText("姓名：");
		senderName.setFont(font5);
		senderName.setBackground(Color.WHITE);
		
		senderNameField.setBounds(90,27,160,20);
		
		senderAddress.setBounds(30,55,60,20);
		senderAddress.setText("住址：");
		senderAddress.setFont(font5);
		senderAddress.setBackground(Color.WHITE);
		
		senderAddressField.setBounds(90,57,160,20);
		
		senderCompany.setBounds(30,85,60,24);
		senderCompany.setText("单位：");
		senderCompany.setFont(font5);
		senderCompany.setBackground(Color.WHITE);
		
		senderCompanyField.setBounds(90,87,160,20);
		
		senderPhone.setBounds(30,115,60,24);
		senderPhone.setText("电话：");
		senderPhone.setFont(font5);
		senderPhone.setBackground(Color.WHITE);
		
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
		
		receiverName.setBounds(30,25,60,24);
		receiverName.setText("姓名：");
		receiverName.setFont(font5);
		receiverName.setBackground(Color.WHITE);
		
		receiverNameField.setBounds(90,27,160,20);
		
		receiverAddress.setBounds(30,55,60,20);
		receiverAddress.setText("住址：");
		receiverAddress.setFont(font5);
		receiverAddress.setBackground(Color.WHITE);
		
		receiverAddressField.setBounds(90,57,160,20);
		
		receiverCompany.setBounds(30,85,60,24);
		receiverCompany.setText("单位：");
		receiverCompany.setFont(font5);
		receiverCompany.setBackground(Color.WHITE);
		
		receiverCompanyField.setBounds(90,87,160,20);
		
		receiverPhone.setBounds(30,115,60,24);
		receiverPhone.setText("电话：");
		receiverPhone.setFont(font5);
		receiverPhone.setBackground(Color.WHITE);
		
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
		
		goodNum.setBounds(30,20,80,24);
		goodNum.setText("托运数量：");
		goodNum.setFont(font5);
		goodNum.setBackground(Color.WHITE);
		
		goodNumField.setBounds(110,22,80,20);
		
		goodName.setBounds(240,20,80,24);
		goodName.setText("内件品名：");
		goodName.setFont(font5);
		goodName.setBackground(Color.WHITE);
		
		goodNameField.setBounds(320,22,120,20);
		
		goodWeight.setBounds(30,50,100,24);
		goodWeight.setText("重量(kg)：");
		goodWeight.setFont(font5);
		goodWeight.setBackground(Color.WHITE);
		
		goodWeightField.setBounds(110,52,80,20);
		goodWeightField.getDocument().addDocumentListener(new TextListener(
				goodWeightField));
		
		goodSize.setBounds(240,50,100,24);
		goodSize.setText("体积（m^3）：");
		goodSize.setFont(font5);
		goodSize.setBackground(Color.WHITE);
		
		goodSizeField.setBounds(350,52,90,20);
		goodSizeField.getDocument().addDocumentListener(new TextListener(
				goodSizeField));
		
		pack.setBounds(30,80,80,24);
		pack.setText("包装：");
		pack.setFont(font5);
		pack.setBackground(Color.WHITE);
		
		packType.setBounds(110,80,90,24);
		packType.setBackground(Color.WHITE);
		packType.setFont(font5);
		packType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					packValue=(String)packType.getSelectedItem();
					try {
						switch(packValue){
						case "纸箱（5）":packing=5.0;break;
						case "木箱（10）":packing=10.0;break;
						case "纸袋（1）":packing=1.0;break;
						default:break;
						}
					} catch (Exception e) {
						
					}
				} 
			}
		});
		
		freight.setBounds(240,80,60,24);
		freight.setText("运费：");
		freight.setFont(font5);
		freight.setBackground(Color.WHITE);

		freightField.setBounds(300,82,80,20);
		freightField.setEditable(false);
		freightField.setBackground(Color.WHITE);
		freightField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		amount.setBounds(380,80,80,24);
		amount.setText("总费用：");
		amount.setFont(font5);
		amount.setBackground(Color.WHITE);
		
		expressType.setBounds(30,110,80,24);
		expressType.setText("快递类型：");
		expressType.setFont(font5);
		expressType.setBackground(Color.WHITE);
		
		expressTypeType.setBounds(110,110,90,24);
		expressTypeType.setBackground(Color.WHITE);
		expressTypeType.setFont(font5);
		expressTypeType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					expressValue=(String)expressTypeType.getSelectedItem();
					try {
						switch(expressValue){
					    case "经济快递":expressTypeSeletion=ExpressType.Economic;break;
					    case "标准快递":expressTypeSeletion=ExpressType.Standard;break;
					    case "特快专递":expressTypeSeletion=ExpressType.EMS;break;
					    default:break;
					    }
					} catch (Exception e) {
					}
				} 
			}
		});
		
		amountField.setBounds(460,82,80,20);
		amountField.setEditable(false);
		amountField.setBackground(Color.WHITE);
		amountField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		sureReceive.setBounds(30,170,90,24);
		sureReceive.setText("收件");
		sureReceive.setFont(font5);
		sureReceive.setBackground(Color.WHITE);
		sureReceive.setVisible(false);
		sureReceive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualReceiverField.setEditable(true);
				makeSure.setVisible(true);
				actualReceiverField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
				actualReceiverField.setText(receiverNameField.getText());
			}
		});
		
		makeSure.setBounds(420,170,90,24);
		makeSure.setText("确认收件");
		makeSure.setFont(font5);
		makeSure.setBackground(Color.WHITE);
		makeSure.setVisible(false);
		makeSure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualReceiverField.setEditable(false);
				actualReceiverField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				orderblservice=new Order();
				orderblservice.receive(docmID.getText(),actualReceiverField.getText());
				makeSure.setVisible(false);
			}
		});
		
		actualReceiver.setBounds(240,170,100,24);
		actualReceiver.setText("实际收件人：");
		actualReceiver.setFont(font5);
		actualReceiver.setBackground(Color.WHITE);
		actualReceiver.setVisible(false);
		
		actualReceiverField.setBounds(340,142,80,20);
		actualReceiverField.setEditable(false);
		actualReceiverField.setBackground(Color.WHITE);
		actualReceiverField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		expectedArrivalDate.setBounds(30,140,210,24);
		expectedArrivalDate.setText("预计到达时间：");
		expectedArrivalDate.setFont(font5);
		expectedArrivalDate.setBackground(Color.WHITE);
		
		trueArrivalDate.setBounds(240,140,100,24);
		trueArrivalDate.setText("实际到达时间：");
		trueArrivalDate.setFont(font5);
		trueArrivalDate.setBackground(Color.WHITE);
		trueArrivalDate.setVisible(false);
		
		trueArrivalDateField.setBounds(340,142,100,20);
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
		other.add(packType);
		other.add(expressTypeType);
		other.add(freight);
		other.add(freightField);
		other.add(amount);
		other.add(amountField);
		other.add(sureReceive);
		other.add(actualReceiver);
		other.add(expectedArrivalDate);
		other.add(trueArrivalDate);
		other.add(makeSure);
		other.add(trueArrivalDateField);
		
		makeOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				orderblservice=new Order();
				orderVO.setSenderName(senderNameField.getText());
				orderVO.setSenderAdd(senderAddressField.getText());
				orderVO.setSenderCompany(senderCompanyField.getText());
				orderVO.setSenderPhoneNumber(senderPhoneField.getText());
				orderVO.setAddresseeName(receiverNameField.getText());;
				orderVO.setAddresseeAdd(receiverAddressField.getText());
				orderVO.setAddresseeCompany(receiverCompanyField.getText());
				orderVO.setAddresseePhoneNumber(receiverPhoneField.getText());
				orderVO.setNumOfGoods(Integer.valueOf(goodNumField.getText()));
				orderVO.setSize(Double.valueOf(goodSizeField.getText()));
				orderVO.setWeight(Double.valueOf(goodWeightField.getText()));
				orderVO.setGoodsName(goodNameField.getText());
				orderVO.setPackingCharge(packing);
				orderVO.setExpressType(expressTypeSeletion);
				javaBean1=orderblservice.add(orderVO);
				orderVO=(OrderVO)javaBean1.getObject();
				expectedArrivalDate.setText("预计到达时间："+
				        orderVO.getExpectedArrivalDate());
				freightField.setText(String.valueOf(orderVO.getFreight()));
				amountField.setText(String.valueOf(orderVO.getTotalCost()));
				docmID.setText(orderVO.getId());
				docmDate.setText(orderVO.getGenerateDate());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				orderblservice=new Order();
				orderVO.setSenderName(senderNameField.getText());
				orderVO.setSenderAdd(senderAddressField.getText());
				orderVO.setSenderCompany(senderCompanyField.getText());
				orderVO.setSenderPhoneNumber(senderPhoneField.getText());
				orderVO.setAddresseeName(receiverNameField.getText());;
				orderVO.setAddresseeAdd(receiverAddressField.getText());
				orderVO.setAddresseeCompany(receiverCompanyField.getText());
				orderVO.setAddresseePhoneNumber(receiverPhoneField.getText());
				orderVO.setPackingCharge(packing);
				orderVO.setExpressType(expressTypeSeletion);
				orderVO.setSize(Double.valueOf(goodSizeField.getText()));
				orderVO.setWeight(Double.valueOf(goodWeightField.getText()));
				orderVO.setGoodsName(goodNameField.getText());
				orderVO.setNumOfGoods(Integer.valueOf(goodNumField.getText()));
				javaBean1=orderblservice.modify(orderVO);
				orderVO=(OrderVO)javaBean1.getObject();
				expectedArrivalDate.setText("预计到达时间："+
				        orderVO.getExpectedArrivalDate());
				freightField.setText(String.valueOf(orderVO.getFreight()));
				amountField.setText(String.valueOf(orderVO.getTotalCost()));
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
		packType.setEnabled(false);
		expressTypeType.setEnabled(false);
		
		senderNameField.setBackground(Color.white);
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
		
		senderNameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		senderAddressField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		senderCompanyField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		senderPhoneField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		receiverAddressField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		receiverNameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		receiverCompanyField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		receiverPhoneField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		goodNameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		goodNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		goodWeightField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		goodSizeField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
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
		packType.setEnabled(true);
		expressTypeType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		senderNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		senderAddressField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		senderCompanyField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		senderPhoneField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receiverAddressField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receiverNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receiverCompanyField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		receiverPhoneField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		goodNameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		goodNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		goodWeightField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		goodSizeField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
		Orderui uiPanel=new Orderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
}
