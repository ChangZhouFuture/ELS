package presentation.documentsui.PaymentOrderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.security.auth.Refreshable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import bean.JavaBean1;
import businesslogic.documentsbl.PaymentOrder;
import businesslogicservice.documentsblservice.PaymentOrderblservice;
import presentation.reuse.DateChooser;
import presentation.reuse.ParentDocuments;
import presentation.userui.Accountantui2;
import vo.documentsVO.PaymentOrderVO;


public class PaymentOrderui extends ParentDocuments{
	public JLabel paymentOrder;
	public JLabel paymentMoney;
	public JTextField paymentMoneyField;
	public JLabel paymentPerson;
	public JTextField paymentPersonField;
	public JLabel paymentId;
	public JTextField paymentIdField;
	public JLabel entry;
	public JComboBox payType;
	public JLabel remarks;
	public JTextArea remarksArea;
	public JScrollPane scroller;
	String payTypeValue="运费（按次计算）";
	PaymentOrderblservice paymentOrderblservice;
	PaymentOrderVO paymentOrderVO;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		Accountantui2 ui=new Accountantui2();
		PaymentOrderui uiPanel=new PaymentOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public PaymentOrderui(){
		paymentOrder=new JLabel();
		paymentMoney=new JLabel();
		paymentMoneyField=new JTextField();
		paymentPerson=new JLabel();
		paymentPersonField=new JTextField();
		paymentId=new JLabel();
		paymentIdField=new JTextField();
		entry=new JLabel();
		String[] payTypeEntries={"运费（按次计算）","奖励（一次性）","人员工资（按月统计）","租金（按年收）"};
		payType=new JComboBox(payTypeEntries);
		remarks=new JLabel();
		remarksArea=new JTextArea();
		paymentOrderVO=new PaymentOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		paymentOrder.setBounds(218,10,180,30);
		paymentOrder.setText("付款单信息");
		paymentOrder.setHorizontalAlignment(SwingConstants.CENTER);
		paymentOrder.setFont(font1);
		paymentOrder.setBackground(Color.WHITE);
		paymentOrder.setOpaque(true);
		
		paymentMoney.setBounds(40,50,90,24);
		paymentMoney.setText("付款金额：");
		paymentMoney.setFont(font2);
		paymentMoney.setBackground(Color.WHITE);
		paymentMoney.setOpaque(true);
		
		paymentMoneyField.setBounds(130,52,100,20);
		
		paymentPerson.setBounds(40,80,90,24);
		paymentPerson.setText("付款人：");
		paymentPerson.setFont(font2);
		paymentPerson.setBackground(Color.WHITE);
		paymentPerson.setOpaque(true);
		
		paymentPersonField.setBounds(130,82,100,20);
		
		paymentId.setBounds(40,110,90,24);
		paymentId.setText("付款账号：");
		paymentId.setFont(font2);
		paymentId.setBackground(Color.WHITE);
		paymentId.setOpaque(true);
		
		paymentIdField.setBounds(130,112,100,20);
		paymentIdField.setEditable(false);
		paymentIdField.setBackground(Color.WHITE);
		paymentIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		entry.setBounds(40,140,90,24);
		entry.setText("条目：");
		entry.setFont(font2);
		entry.setBackground(Color.WHITE);
		entry.setOpaque(true);
		
		payType.setBounds(130,140,200,24);
		payType.setFont(font2);
		payType.setBackground(Color.WHITE);
		payType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					payTypeValue=(String)payType.getSelectedItem();
				} 
			}
		});
		
		remarks.setBounds(40,170,90,24);
		remarks.setText("备注：");
		remarks.setFont(font2);
		remarks.setBackground(Color.WHITE);
		remarks.setOpaque(true);
		
		remarksArea.setBounds(130,170,250,150);
		remarksArea.setFont(font2);
		remarksArea.setEnabled(true);
		remarksArea.setWrapStyleWord(true);
		remarksArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		remarksArea.setLineWrap(true);
		
		scroller=new JScrollPane(remarksArea);
		scroller.setBounds(130,170,250,150);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				paymentOrderblservice=new PaymentOrder();
				paymentOrderVO.setAmount(Double.valueOf(paymentMoneyField.getText()));
				paymentOrderVO.setPayer(paymentPersonField.getText());
				paymentOrderVO.setEntry(payTypeValue);
				paymentOrderVO.setNote(remarksArea.getText());
				javaBean1=paymentOrderblservice.add(paymentOrderVO);
				paymentOrderVO=(PaymentOrderVO)javaBean1.getObject();
				docmID.setText(paymentOrderVO.getID());
				paymentIdField.setText(paymentOrderVO.getBankAccount());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				paymentOrderblservice=new PaymentOrder();
				paymentOrderVO.setAmount(Double.valueOf(paymentMoneyField.getText()));
				paymentOrderVO.setPayer(paymentPersonField.getText());
				paymentOrderVO.setEntry(payTypeValue);
				paymentOrderVO.setNote(remarksArea.getText());
				modifyOrder.setEnabled(false);
				modifyOrder.setVisible(false);
				paymentOrderblservice.modify(paymentOrderVO);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(paymentOrder);
		this.add(paymentMoney);
		this.add(paymentMoneyField);
		this.add(paymentPerson);
		this.add(paymentPersonField);
		this.add(paymentId);
		this.add(paymentIdField);
		this.add(entry);
		this.add(payType);
		this.add(remarks);
		this.add(scroller);
	}
	public void refresh(){
		paymentMoneyField.setEditable(false);
		paymentPersonField.setEditable(false);
		payType.setEnabled(false);
		remarksArea.setEditable(false);
		
		paymentMoneyField.setBackground(Color.white);
		paymentPersonField.setBackground(Color.white);
		
		paymentMoneyField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		paymentPersonField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
	}
	public void modifying(){
		paymentMoneyField.setEditable(true);
		paymentPersonField.setEditable(true);
		payType.setEnabled(true);
		remarksArea.setEditable(true);
		modifyOrder.setVisible(true);
		
		paymentMoneyField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		paymentPersonField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
