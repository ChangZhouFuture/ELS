package presentation.documentsui.TransferOrderui;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.documentsbl.TransferOrder;
import businesslogicservice.documentsblservice.TransferOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.Loginui;
import presentation.userui.TranCenClerkui;
import state.TransportType;
import vo.documentsVO.TransferOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class TransferOrderui extends ParentDocuments{
	public JLabel transferOrder;
	public JLabel transportType;
	public JComboBox transportTypeType;
	public JLabel departure;
	public JTextField departureField;
	public JLabel arrival;
	public JTextField arrivalField;
	public JLabel jZY;
	public JTextField jZYField;
	public JLabel transportNum;
	public JTextField transportNumField;
	public JLabel containerId;
	public JTextField containerIdField;
	public JLabel carriage;
	public JTextField carriageField;
	public JLabel orderId;
	public JTextField orderIdField;
	public JButton addOrder;
	public JTable orderList;
	public DefaultTableModel tableModel;
	public JScrollPane scroller;
	public JButton deleteOrder;
	JavaBean1 javaBean1;
	public OrderlineitemVO orderlineitemVO;
	String transportTypeValue="公路";
	TransportType transportTypeSeletion=TransportType.Truck;
	String city = Loginui.city;
	TransferOrderblservice transferOrderblservice;
	TransferOrderVO transferOrderVO;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
		TransferOrderui uiPanel=new TransferOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public TransferOrderui(){
		transferOrder=new JLabel();
		transportType=new JLabel();
		String[] transportTypeEntries={"公路","铁路","飞机"};
		transportTypeType=new JComboBox(transportTypeEntries);
		departure=new JLabel();
		departureField=new JTextField();
		arrival=new JLabel();
		arrivalField=new JTextField();
		jZY=new JLabel();
		jZYField=new JTextField();
		transportNum=new JLabel();
		transportNumField=new JTextField();
		containerId=new JLabel();
		containerIdField=new JTextField();
		carriage=new JLabel();
		carriageField=new JTextField();
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
		 transferOrderVO=new TransferOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		transferOrder.setBounds(218,10,180,30);
		transferOrder.setText("中转单信息");
		transferOrder.setHorizontalAlignment(SwingConstants.CENTER);
		transferOrder.setFont(font1);
		transferOrder.setBackground(Color.WHITE);
		transferOrder.setOpaque(true);
		
		transportType.setBounds(40,50,100,24);
		transportType.setText("交通方式：");
		transportType.setFont(font2);
		transportType.setBackground(Color.WHITE);
		transportType.setOpaque(true);
		
		transportTypeType.setBounds(140,50,100,24);
		transportTypeType.setFont(font2);
		transportTypeType.setBackground(Color.WHITE);
		transportTypeType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					transportTypeValue=(String)transportTypeType.getSelectedItem();
					switch(transportTypeValue){
					case "公路":transportTypeSeletion=TransportType.Truck;break;
					case "铁路":transportTypeSeletion=TransportType.Train;break;
					case "飞机":transportTypeSeletion=TransportType.Plane;break;
						default:break;
					}
					System.out.println(transportTypeValue);
				} 
			}
		});
		
		departure.setBounds(40,80,100,24);
		departure.setText("出发地：");
		departure.setFont(font2);
		departure.setBackground(Color.WHITE);
		departure.setOpaque(true);
		
		departureField.setBounds(140,82,150,20);
		
		arrival.setBounds(300,80,100,24);
		arrival.setText("到达地：");
		arrival.setFont(font2);
		arrival.setBackground(Color.WHITE);
		arrival.setOpaque(true);
		
		arrivalField.setBounds(400,82,150,20);
		
		jZY.setBounds(40,110,100,24);
		jZY.setText("监装员：");
		jZY.setFont(font2);
		jZY.setBackground(Color.WHITE);
		jZY.setOpaque(true);
		
		jZYField.setBounds(140,112,150,20);
		
		transportNum.setBounds(40,140,100,24);
		transportNum.setText("航班号：");
		transportNum.setFont(font2);
		transportNum.setBackground(Color.WHITE);
		transportNum.setOpaque(true);
		
		transportNumField.setBounds(140,142,150,20);
		
		containerId.setBounds(300,140,100,24);
		containerId.setText("货柜号：");
		containerId.setFont(font2);
		containerId.setBackground(Color.WHITE);
		containerId.setOpaque(true);
		
		containerIdField.setBounds(400,142,150,20);
		
		carriage.setBounds(40,170,80,24);
		carriage.setText("运费：");
		carriage.setFont(font2);
		carriage.setBackground(Color.WHITE);
		carriage.setOpaque(true);
		
		carriageField.setBounds(200,172,80,20);
		carriageField.setEditable(false);
		carriageField.setBackground(Color.WHITE);
		carriageField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		orderId.setBounds(40,200,200,24);
		orderId.setText("本次装箱所有订单条形码号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		orderId.setOpaque(true);
		
		orderIdField.setBounds(240,202,120,20);
		
		addOrder.setBounds(400,200,70,24);
		addOrder.setText("添加订单");
		addOrder.setFont(font2);
		addOrder.setBackground(Color.WHITE);
		addOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderblservice=new TransferOrder();
				orderlineitemVO=transferOrderblservice.addOrder(orderIdField.getText());
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
		scroller=new JScrollPane(orderList);
		scroller.setSize(500,144);
		scroller.setLocation(40,230);
		scroller.setViewportView(orderList);
		orderList.setFont(font2);
		orderList.setBackground(Color.WHITE);
		orderList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
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
			public void actionPerformed(ActionEvent e) {
				System.out.println(1);
				refresh();
				approState.setText("未审批");
				transferOrderblservice=new TransferOrder();
				transferOrderVO.setTransportType(transportTypeSeletion);
				transferOrderVO.setOrigin(departureField.getText());
				transferOrderVO.setDestination(arrivalField.getText());
				transferOrderVO.setSupervisionMan(jZYField.getText());
				transferOrderVO.setFlightNum(transportNumField.getText());
				transferOrderVO.setContainerNum(containerIdField.getText());
				ArrayList<String> idList=new ArrayList<String>();
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				transferOrderVO.setOrderIDs(idList);
				javaBean1=transferOrderblservice.addTransferOrder(transferOrderVO);
				transferOrderVO=(TransferOrderVO)javaBean1.getObject();
				docmID.setText(transferOrderVO.getID());
				carriageField.setText(String.valueOf(transferOrderVO.getCarriage()));
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				transferOrderblservice=new TransferOrder();
				transferOrderVO.setTransportType(transportTypeSeletion);
				transferOrderVO.setOrigin(departureField.getText());
				transferOrderVO.setDestination(arrivalField.getText());
				transferOrderVO.setSupervisionMan(jZYField.getText());
				transferOrderVO.setFlightNum(transportNumField.getText());
				transferOrderVO.setContainerNum(containerIdField.getText());
				ArrayList<String> idList=null;
				for(int i=0;i<orderList.getRowCount();i++){
					idList.add((String)orderList.getValueAt(i,1));
				}
				transferOrderVO.setOrderIDs(idList);
				modifyOrder.setVisible(false);
				transferOrderblservice.modify(transferOrderVO);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(transferOrder);
		this.add(transportType);
		this.add(transportTypeType);
		this.add(departure);
		this.add(departureField);
		this.add(arrival);
		this.add(arrivalField);
		this.add(jZY);
		this.add(jZYField);
		this.add(transportNum);
		this.add(transportNumField);
		this.add(containerId);
		this.add(containerIdField);
		this.add(carriage);
		this.add(carriageField);
		this.add(orderId);
		this.add(orderIdField);
		this.add(addOrder);
		this.add(deleteOrder);
		this.add(scroller);
	}
	public void refresh() {
		departureField.setEditable(false);
		arrivalField.setEditable(false);
		jZYField.setEditable(false);
		transportNumField.setEditable(false);
		containerIdField.setEditable(false);
		orderIdField.setEditable(false);
		addOrder.setVisible(false);
		deleteOrder.setVisible(false);
		transportTypeType.setEnabled(false);
		
		departureField.setBackground(Color.white);
		arrivalField.setBackground(Color.white);
		jZYField.setBackground(Color.white);
		transportNumField.setBackground(Color.white);
		containerIdField.setBackground(Color.white);
		orderIdField.setBackground(Color.white);
		
		departureField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		arrivalField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jZYField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		transportNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		containerIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
	}
	public void modifying() {
		departureField.setEditable(true);
		arrivalField.setEditable(true);
		jZYField.setEditable(true);
		transportNumField.setEditable(true);
		containerIdField.setEditable(true);
		orderIdField.setEditable(true);
		addOrder.setVisible(true);
		deleteOrder.setVisible(true);
		transportTypeType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		departureField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		arrivalField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		jZYField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		transportNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		containerIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
