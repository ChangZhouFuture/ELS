package presentation.managerAndAccountantui.StatisAnalyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import bean.JavaBean1;
import businesslogic.managerAndAccountantbl.StatisAnaly;
import businesslogicservice.managerAndAccountantblservice.StatisAnalyblservice;
import po.StatisAnalyPO.CostAndIncomePO;
import po.documentsPO.PaymentOrderPO;
import po.documentsPO.ReceivablesOrderPO;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.Accountantui1;

public class StatisAnalyListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel startDate;
	public JLabel endDate;
	public JButton find;
	public JTextField startDateField;
	public DateChooser startDateChooser;
	public JTextField endDateField;
	public DateChooser endDateChooser;
	public JComboBox sheetType;
	public JScrollPane scrollPane;
	public JTable receivablesOrderTable;
	public JTable paymentOrderTable;
	public JTable costanIncomeTable;
	public DefaultTableModel receivablesOrderTableModel;
	public DefaultTableModel paymentOrderTableModel;
	public DefaultTableModel costanIncomeTableModel;
	ReceivablesOrderPO oneReceivablesOrderLine;
	PaymentOrderPO onePaymentOrderLine;
	CostAndIncomePO costAndIncomePO;
	StatisAnalyblservice statisAnalyblservice;
	JavaBean1 javaBean1;
	String sheetTypeValue="收款单";
	
	public static void main(String[] args){
		
		Accountantui1 ui=new Accountantui1();
		StatisAnalyListui uiPanel=new StatisAnalyListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		uiPanel.makePaymentOrderTable(null);
		layeredPane.add(uiPanel,0);
	}
	public StatisAnalyListui(){
		sheetLabel=new JLabel();
		startDate=new JLabel();
		endDate=new JLabel();
		find=new JButton();
		startDateField=new JTextField();
		startDateChooser=DateChooser.getInstance("yyyy-MM-dd");
		endDateField=new JTextField();
		endDateChooser=DateChooser.getInstance("yyyy-MM-dd");
		String[] sheetTypeEntries={"收款单","付款单","成本收益表"};
		sheetType=new JComboBox(sheetTypeEntries);
		String[] receivablesOrderColumnNames = {"ID","快递员","金额","收款日期","时间"}; //列名
		String [][]receivablesOrderTableVales={}; //数据
		receivablesOrderTableModel = new DefaultTableModel(receivablesOrderTableVales,receivablesOrderColumnNames);
		receivablesOrderTable = new JTable(receivablesOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] paymentOrderColumnNames = {"ID","付款人","付款账号","金额","条目","备注","时间"}; //列名
		String [][]paymentOrderTableVales={}; //数据
		paymentOrderTableModel = new DefaultTableModel(paymentOrderTableVales,paymentOrderColumnNames);
		paymentOrderTable = new JTable(paymentOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] costanIncomeColumnNames = {"总收入","总支出","总利润"}; //列名
		String [][]costanIncomeTableVales={}; //数据
		costanIncomeTableModel = new DefaultTableModel(costanIncomeTableVales,costanIncomeColumnNames);
		costanIncomeTable = new JTable(costanIncomeTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("统计报表");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		sheetType.setBackground(Color.WHITE);
		sheetType.setFont(font2);
		sheetType.setBounds(30,45,120,24);
		sheetType.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					sheetTypeValue=(String)sheetType.getSelectedItem();
				} 
			}     
		});
		
		startDate.setBounds(30,75,100,24);
		startDate.setText("开始日期:");
		startDate.setFont(font2);
		startDate.setBackground(Color.WHITE);
		startDate.setOpaque(true);
		
		startDateField.setBounds(130,77,120,20);
		startDateChooser.register(startDateField);
		
		endDate.setBounds(30,105,100,24);
		endDate.setText("结束日期:");
		endDate.setFont(font2);
		endDate.setBackground(Color.WHITE);
		endDate.setOpaque(true);
		
		endDateField.setBounds(130,107,120,20);
		endDateChooser.register(endDateField);
		
		find.setBounds(330,105,50,24);
		find.setText("查找");
		find.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		find.setFont(font2);
		find.setBackground(Color.WHITE);
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(sheetTypeValue){
				case "收款单":
					statisAnalyblservice=new StatisAnaly();
					javaBean1=statisAnalyblservice.inquireReceivalblesOrder2(startDateField.getText(),
							endDateField.getText());
					ArrayList<ReceivablesOrderPO> arrayReceivablesOrderList=
							(ArrayList<ReceivablesOrderPO>)javaBean1.getObject();
					makeReceivablesOrderTable(arrayReceivablesOrderList);
					break;
				case "付款单":
					statisAnalyblservice=new StatisAnaly();
					javaBean1=statisAnalyblservice.inquirePaymentOrder2(startDateField.getText(),
							endDateField.getText());
					ArrayList<PaymentOrderPO> arrayPaymentOrderList = (ArrayList<PaymentOrderPO>)javaBean1.getObject();
					makePaymentOrderTable(arrayPaymentOrderList);
					break;
				case "成本收益表":
					statisAnalyblservice=new StatisAnaly();
					javaBean1=statisAnalyblservice.inquireCostAndIncomeTable();
					costAndIncomePO=(CostAndIncomePO)javaBean1.getObject();
					makeCostanIncomeTable(costAndIncomePO);
					break;
				default:break;
				}
			}
		});
		scrollPane=new JScrollPane(paymentOrderTable);
		
		this.add(sheetLabel);
		this.add(startDate);
		this.add(endDate);
		this.add(startDateField);
		this.add(endDateField);
		this.add(find);
		this.add(sheetType);
		this.add(scrollPane);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeReceivablesOrderTable(ArrayList<ReceivablesOrderPO> arrayReceivablesOrderList){
		while(receivablesOrderTableModel.getRowCount()>0){
			receivablesOrderTableModel.removeRow(receivablesOrderTableModel.getRowCount()-1);
		}
		receivablesOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String[] Row1={"12345678","张三","200","2015-12-5","2015-12-5"};
		for(int i=0;i<arrayReceivablesOrderList.size();i++){
		    oneReceivablesOrderLine=arrayReceivablesOrderList.get(i);
			String[] oneRow={oneReceivablesOrderLine.getID(),
			    	oneReceivablesOrderLine.getCourier(),
			    	String.valueOf(oneReceivablesOrderLine.getAmount()),
			    	oneReceivablesOrderLine.getDate(),oneReceivablesOrderLine.getGenerateTime()};
			receivablesOrderTableModel.addRow(oneRow);
		}
		receivablesOrderTable.setRowHeight(24);
		receivablesOrderTable.setBackground(Color.WHITE);
		receivablesOrderTable.setShowVerticalLines(true);
		receivablesOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scrollPane.setSize(550,241);
		scrollPane.setLocation(30,160);
		scrollPane.setViewportView(receivablesOrderTable);
	}
	public void makePaymentOrderTable(ArrayList<PaymentOrderPO> arrayPaymentOrderList){
		while(paymentOrderTableModel.getRowCount()>0){
			paymentOrderTableModel.removeRow(paymentOrderTableModel.getRowCount()-1);
		}
		paymentOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		for(int i=0;i<arrayPaymentOrderList.size();i++){
		    onePaymentOrderLine=arrayPaymentOrderList.get(i);
			String[] oneRow={onePaymentOrderLine.getID(),onePaymentOrderLine.getPayer(),
			    onePaymentOrderLine.getBankAccount(),
			    String.valueOf(onePaymentOrderLine.getAmount()),onePaymentOrderLine.getEntry(),
				onePaymentOrderLine.getNote(),onePaymentOrderLine.getDate()};
			paymentOrderTableModel.addRow(oneRow);
		 }
		 paymentOrderTable.setRowHeight(24);
		 paymentOrderTable.setBackground(Color.WHITE);
		 paymentOrderTable.setShowVerticalLines(true);
		 paymentOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(paymentOrderTable);
	}
	public void makeCostanIncomeTable(CostAndIncomePO costAndIncomePO){
		while(costanIncomeTableModel.getRowCount()>0){
			costanIncomeTableModel.removeRow(costanIncomeTableModel.getRowCount()-1);
		}
		costanIncomeTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String[] oneRow={String.valueOf(costAndIncomePO.getIncome()),
				String.valueOf(costAndIncomePO.getCost()),
				String.valueOf(costAndIncomePO.getProfit())};
		costanIncomeTableModel.addRow(oneRow);
		costanIncomeTable.setRowHeight(24);
		costanIncomeTable.setBackground(Color.WHITE);
		costanIncomeTable.setShowVerticalLines(true);
		costanIncomeTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scrollPane.setSize(550,48);
		scrollPane.setLocation(30,160);
		scrollPane.setViewportView(costanIncomeTable);
	}
}
