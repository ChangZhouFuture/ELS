package presentation.documentsui.ReceivablesOrderui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallLoadingList;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.ReceivablesOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class ReceivablesOrderui extends ParentDocuments{
	public JLabel receivablesOrder;
	public JLabel money;
	public JTextField moneyField;
	public JLabel courier;
	public JTextField courierId;
	public JLabel orderId;
	public JTextField orderIdField;
	public JButton addOrder;
	public JTable orderList;
	public DefaultTableModel tableModel;
	public JScrollPane scroller;
	public JButton deleteOrder;
	JavaBean1 javaBean1;
	public OrderlineitemVO orderlineitemVO;
	ReceivablesOrderblservice receivablesOrderblservice;
	public ReceivablesOrderVO receivablesOrderVO;

	public ReceivablesOrderui(){
		receivablesOrder=new JLabel();
		money=new JLabel();
		moneyField=new JTextField();
		courier=new JLabel();
		courierId=new JTextField();
		orderId=new JLabel();
		orderIdField=new JTextField();
		addOrder=new JButton();
		String[] columnNames = {"选择","ID","寄件地址","收件地址","快递类型","时间"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		orderList = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		 deleteOrder=new JButton();
		 receivablesOrderVO=new ReceivablesOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		receivablesOrder.setBounds(218,10,180,30);
		receivablesOrder.setText("收款单信息");
		receivablesOrder.setHorizontalAlignment(SwingConstants.CENTER);
		receivablesOrder.setFont(font1);
		receivablesOrder.setBackground(Color.WHITE);
		receivablesOrder.setOpaque(true);
		
		money.setBounds(40,50,100,24);
		money.setText("收款金额：");
		money.setFont(font2);
		money.setBackground(Color.WHITE);
		
		moneyField.setBounds(130,52,100,20);
		moneyField.setEditable(false);
		moneyField.setBackground(Color.WHITE);
		moneyField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		courier.setBounds(40,80,90,24);
		courier.setText("收款快递员：");
		courier.setFont(font2);
		courier.setBackground(Color.WHITE);
		courier.setOpaque(true);
		
		courierId.setBounds(130,82,100,20);
		
		orderId.setBounds(40,110,200,24);
		orderId.setText("快递订单条形码号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		orderId.setOpaque(true);
		
		orderIdField.setBounds(130,142,120,20);
		
		addOrder.setBounds(280,142,70,20);
		addOrder.setText("添加订单");
		addOrder.setFont(font2);
		addOrder.setBackground(Color.WHITE);
		addOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderblservice=new ReceivablesOrder();
				orderlineitemVO=receivablesOrderblservice.addOrder(orderIdField.getText());
				String[] oneRow={"",orderlineitemVO.getId(),orderlineitemVO.getSenderAdd(),
						orderlineitemVO.getAddresseeAdd(),orderlineitemVO.getExpressType().toString(),
						orderlineitemVO.getGenerateDate()};
			    tableModel.addRow(oneRow);
			}
		});
		
		orderList.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
			 @Override
			 public Component getTableCellRendererComponent(JTable table,
					 Object value, boolean isSelected, boolean hasFocus,
					 int row, int column) {
				 JCheckBox ck=new JCheckBox();
				 ck.setSelected(isSelected);
				 ck.setHorizontalAlignment((int) 0.5f);
				 ck.setBackground(Color.WHITE);
				 return ck;
			 }
		 });
		orderList.setRowHeight(24);
		orderList.setBackground(Color.WHITE);
		orderList.setShowVerticalLines(true);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderList.getColumnModel().getColumn(0).setPreferredWidth(40);
		orderList.setFont(font2);
		orderList.setBackground(Color.WHITE);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scroller=new JScrollPane(orderList);
		scroller.setViewportView(orderList);
		scroller.setBounds(40,170,500,216);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		deleteOrder.setBounds(40,400,50,24);
		deleteOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		deleteOrder.setBackground(Color.WHITE);
		deleteOrder.setText("删除");
		deleteOrder.setFont(font2);
		deleteOrder.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   for(int i=0;i<orderList.getRowCount();i++){
				    int selectedRow = orderList.getSelectedRow();//获得选中行的索引
				    if(selectedRow!=-1){
				     tableModel.removeRow(selectedRow);  //删除行 
				    }
				   }
				  }});
		
		makeOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				refresh();
				approState.setText("未审批");
				receivablesOrderblservice=new ReceivablesOrder();
				receivablesOrderVO.setCourier(courierId.getText());
				ArrayList<String> idList=new ArrayList<String>();
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				receivablesOrderVO.setOrderIDs(idList);
				javaBean1=new JavaBean1();
				javaBean1=receivablesOrderblservice.add(receivablesOrderVO);
				receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				moneyField.setText(String.valueOf(receivablesOrderVO.getAmount()));
				docmID.setText(receivablesOrderVO.getID());
				docmDate.setText(receivablesOrderVO.getDate());
				makeOrder.setEnabled(false);
			}
		});
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				receivablesOrderblservice=new ReceivablesOrder();
				receivablesOrderVO.setCourier(courierId.getText());
				ArrayList<String> idList=new ArrayList<String>();
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				receivablesOrderVO.setOrderIDs(idList);
				javaBean1=new JavaBean1();
				javaBean1=receivablesOrderblservice.modify(receivablesOrderVO);
				receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				moneyField.setText(String.valueOf(receivablesOrderVO.getAmount()));
			}
		});
		
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(receivablesOrder);
		this.add(money);
		this.add(moneyField);
		this.add(courier);
		this.add(courierId);
		this.add(orderId);
		this.add(orderIdField);
		this.add(addOrder);
		this.add(scroller);
		this.add(deleteOrder);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void refresh() {
		courierId.setEditable(false);
		orderIdField.setEditable(false);
		addOrder.setVisible(false);
		deleteOrder.setVisible(false);
		
		courierId.setBackground(Color.white);
		orderIdField.setBackground(Color.white);
		
		courierId.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		courierId.setEditable(true);
		orderIdField.setEditable(true);
		addOrder.setVisible(true);
		deleteOrder.setVisible(true);
		modifyOrder.setVisible(true);
		
		courierId.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
