package presentation.managerAndAccountantui.Approdocmui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.managerAndAccountantbl.ApproDocm;
import businesslogic.orderbl.Order;
import businesslogicservice.managerAndAccountantblservice.ApproDocmblservice;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.GeneralManagerui;
import state.ApproState;
import state.DocumentsType;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class DocmListui extends JPanel{
	public JComboBox sheetType;
	public JLabel sheetLabel;
	public JLabel findByDate;
	public JTextField dateField;
	public DateChooser dateChooser;
	public JButton dateFind;
	public JButton sheetTypeFind;
	public JButton approDocm;
	public JTable orderTable;
	public DefaultTableModel orderTableModel;
	public JTable busiHallArrivalOrderTable;
	public DefaultTableModel busiHallArrivalOrderTableModel;
	public JTable busiHallLoadingListTable;
	public DefaultTableModel busiHallLoadingListTableModel;
	public JTable deliveryOrderTable;
	public DefaultTableModel deliveryOrderTableModel;
	public JTable tranCenArrivalOrderTable;
	public DefaultTableModel tranCenArrivalOrderTableModel;
	public JTable tranCenLoadingListTable;
	public DefaultTableModel tranCenLoadingListTableModel;
	public JTable transferOrderTable;
	public DefaultTableModel transferOrderTableModel;
	public JTable receivablesOrderTable;
	public DefaultTableModel receivablesOrderTableModel;
	public JTable paymentOrderTable;
	public DefaultTableModel paymentOrderTableModel;
	public JTable outBoundOrderTable;
	public DefaultTableModel outBoundOrderTableModel;
	public JTable storageListTable;
	public DefaultTableModel storageListTableModel;
	ApproDocmblservice approDocmblservice;
	JavaBean1 javaBean1;
	OrderlineitemPO orderlineitemPO;
	BusiHallArrivalOrderPO busiHallArrivalOrderPO;
	
	public JScrollPane scrollPane;
	
	String documentsValue="订单";
	DocumentsType documentsType=DocumentsType.Order;
	
	public static void main(String[] args){
		GeneralManagerui ui=new GeneralManagerui();
		DocmListui uiPanel=new DocmListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public DocmListui(){
		String[] sheetTypeEntries={"订单","营业厅到达单","营业厅装车单","派件单",
				"中转中心到达单","中转中心装车单","中转单","收款单","付款单","入库单","出库单"};
		sheetType=new JComboBox(sheetTypeEntries);
		sheetLabel=new JLabel();
		findByDate=new JLabel();
		dateFind=new JButton();
		sheetTypeFind=new JButton();
		approDocm=new JButton();
		dateField=new JTextField("单击选择日期");
		dateChooser = DateChooser.getInstance("yyyy-MM-dd");
		String[] orderColumnNames = {"选择","ID","寄件地址","收件地址","快递类型","总费用","审批状态"}; //列名
		String [][]tableVales={}; //数据
		orderTableModel = new DefaultTableModel(tableVales,orderColumnNames);
		orderTable = new JTable(orderTableModel){
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		 String[] busiHallArrivalColumnNames = {"选择","ID","营业厅编号","中转单编号","出发地","到达日期","货物状态","审批状态"}; //列名
		 busiHallArrivalOrderTableModel = new DefaultTableModel(tableVales,busiHallArrivalColumnNames);
		 busiHallArrivalOrderTable = new JTable(busiHallArrivalOrderTableModel){  
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
		sheetLabel.setText("审批单据");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		sheetType.setBackground(Color.WHITE);
		sheetType.setFont(font2);
		sheetType.setBounds(30,45,160,24);
		sheetType.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					documentsValue=(String)sheetType.getSelectedItem();
				}
				switch(documentsValue){
				case "订单":documentsType=DocumentsType.Order;break;
				case "营业厅到达单":documentsType=DocumentsType.BusiHallArrivalOrder;break;
				case "营业厅装车单":documentsType=DocumentsType.BusiHallLoadingList;break;
				case "派件单":documentsType=DocumentsType.DeliveryOrder;break;
				case "中转中心到达单":documentsType=DocumentsType.TranCenArrivalOrder;break;
				case "中转中心装车单":documentsType=DocumentsType.TranCenLoadingList;break;
				case "中转单":documentsType=DocumentsType.TransferOrder;break;
				case "收款单":documentsType=DocumentsType.ReceivablesOrder;break;
				case "付款单":documentsType=DocumentsType.PaymentOrder;break;
				case "入库单":documentsType=DocumentsType.OutBoundOrder;break;
				case "出库单":documentsType=DocumentsType.StorageList;break;
				default:break;
				}
			}     
		});
		
		findByDate.setBounds(30,75,90,24);
		findByDate.setText("日期:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		findByDate.setOpaque(true);
		
		dateField.setBounds(120,77,120,20);
		dateChooser.register(dateField);
		
		dateFind.setBounds(330,75,50,24);
		dateFind.setText("查找");
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setFont(font2);
		dateFind.setBackground(Color.WHITE);
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String date="";
				date=dateField.getText();
				approDocmblservice=new ApproDocm();
				switch(documentsType){
				case Order:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<OrderlineitemPO> orderArrayList = 
							(ArrayList<OrderlineitemPO>)javaBean1.getObject();
					makeOrderTable(orderArrayList);
					break;
				case BusiHallArrivalOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<BusiHallArrivalOrderPO> busiHallArrivalOrderArrayList=
							(ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
					makeBusiHallArrivalOrderTable(busiHallArrivalOrderArrayList);
					break;
				case BusiHallLoadingList:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case DeliveryOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case TranCenArrivalOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case TranCenLoadingList:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case TransferOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case ReceivablesOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case PaymentOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case OutBoundOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				case StorageList:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					break;
				default:break;
				}
			}
		});
		scrollPane = new JScrollPane(orderTable);
		approDocm.setBounds(30,420,50,24);
		approDocm.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		approDocm.setBackground(Color.WHITE);
		approDocm.setText("审批");
		approDocm.setFont(font2);
		
		this.add(approDocm);
		this.add(sheetLabel);
		this.add(findByDate);
		this.add(dateFind);
		this.add(dateField);
		this.add(sheetType);
		this.add(scrollPane);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeOrderTable(ArrayList<OrderlineitemPO> arrayList){
		while(orderTableModel.getRowCount()>0){
			orderTableModel.removeRow(orderTableModel.getRowCount()-1);
		}
		orderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		 for(int i=arrayList.size()-1;i>=0;i--){
			 orderlineitemPO=arrayList.get(i);
			 if(orderlineitemPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",orderlineitemPO.getId(),orderlineitemPO.getSenderAdd(),
			        orderlineitemPO.getAddresseeAdd(),orderlineitemPO.getExpressType().toString(),
			    	String.valueOf(orderlineitemPO.getTotalCost()),"未审"};
			     orderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 orderlineitemPO=arrayList.get(i);
			 if(orderlineitemPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",orderlineitemPO.getId(),orderlineitemPO.getSenderAdd(),
			        orderlineitemPO.getAddresseeAdd(),orderlineitemPO.getExpressType().toString(),
			    	String.valueOf(orderlineitemPO.getTotalCost()),"未审"};
			     orderTableModel.addRow(oneRow);
			 }
		 }
		 orderTable.setRowHeight(24);
		 orderTable.setBackground(Color.WHITE);
		 orderTable.setShowVerticalLines(true);
		 orderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(orderTable);
		 approDocm.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<orderTable.getRowCount();i++){
					   int selectedRow = orderTable.getSelectedRow();//获得选中行的索引
				       if(selectedRow!=-1){
				    	   idList.add((String)orderTable.getValueAt(orderTable.getSelectedRow(),1));
				       }
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.Order);
				   
				  }});
	}
	public void makeBusiHallArrivalOrderTable(ArrayList<BusiHallArrivalOrderPO> arrayList){
		while(busiHallArrivalOrderTableModel.getRowCount()>0){
			busiHallArrivalOrderTableModel.removeRow(busiHallArrivalOrderTableModel.getRowCount()-1);
		}
		busiHallArrivalOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		 for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallArrivalOrderPO=arrayList.get(i);
		     if(busiHallArrivalOrderPO.getApproState()==ApproState.NotApprove){
			       String[] oneRow={"",busiHallArrivalOrderPO.getId(),busiHallArrivalOrderPO.getBusiHallID(),
					 busiHallArrivalOrderPO.getTransferOrderID(),busiHallArrivalOrderPO.getOrigin(),
					 busiHallArrivalOrderPO.getArrivalDate(),busiHallArrivalOrderPO.getGoodState().toString(),
					 "未审"};
			    busiHallArrivalOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallArrivalOrderPO=arrayList.get(i);
		     if(busiHallArrivalOrderPO.getApproState()==ApproState.Approve){
			       String[] oneRow={"",busiHallArrivalOrderPO.getId(),busiHallArrivalOrderPO.getBusiHallID(),
					 busiHallArrivalOrderPO.getTransferOrderID(),busiHallArrivalOrderPO.getOrigin(),
					 busiHallArrivalOrderPO.getArrivalDate(),busiHallArrivalOrderPO.getGoodState().toString(),
					 "已审"};
			    busiHallArrivalOrderTableModel.addRow(oneRow);
			 }
		 }
		 busiHallArrivalOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 busiHallArrivalOrderTable.setRowHeight(24);
		 busiHallArrivalOrderTable.setBackground(Color.WHITE);
		 busiHallArrivalOrderTable.setShowVerticalLines(true);
		 busiHallArrivalOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(busiHallArrivalOrderTable);
		 approDocm.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<busiHallArrivalOrderTable.getRowCount();i++){
					   int selectedRow = busiHallArrivalOrderTable.getSelectedRow();//获得选中行的索引
				       if(selectedRow!=-1){
				    	   idList.add((String)busiHallArrivalOrderTable.getValueAt
				    			   (busiHallArrivalOrderTable.getSelectedRow(),1));
				       }
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.BusiHallArrivalOrder);
				   
				  }});
	}
}
