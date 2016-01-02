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
import businesslogicservice.managerAndAccountantblservice.ApproDocmblservice;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.documentsPO.DeliveryOrderPO;
import po.documentsPO.PaymentOrderPO;
import po.documentsPO.ReceivablesOrderPO;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.documentslineitemPO.TranCenLoadingListlineitemPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.stockPO.OutBoundOrderPO;
import po.stockPO.StorageListPO;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.GeneralManagerui;
import state.ApproState;
import state.DocumentsType;

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
	BusiHallLoadingListlineitemPO busiHallLoadingListlineitemPO;
	DeliveryOrderPO deliveryOrderPO;
	TranCenArrivalOrderPO tranCenArrivalOrderPO;
	TranCenLoadingListlineitemPO tranCenLoadingListlineitemPO;
	TransferOrderlineitemPO transferOrderlineitemPO;
	ReceivablesOrderPO receivablesOrderPO;
	PaymentOrderPO paymentOrderPO;
	OutBoundOrderPO outBoundOrderPO;
	StorageListPO storageListPO;
	
	public JScrollPane scrollPane;
	
	String documentsValue="����";
	DocumentsType documentsType=DocumentsType.Order;
	
	public static void main(String[] args){
		GeneralManagerui ui=new GeneralManagerui();
		DocmListui uiPanel=new DocmListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public DocmListui(){
		String[] sheetTypeEntries={"����","Ӫҵ�����ﵥ","Ӫҵ��װ����","�ɼ���",
				"��ת���ĵ��ﵥ","��ת����װ����","��ת��","�տ","���","��ⵥ","���ⵥ"};
		sheetType=new JComboBox(sheetTypeEntries);
		sheetLabel=new JLabel();
		findByDate=new JLabel();
		dateFind=new JButton();
		sheetTypeFind=new JButton();
		approDocm=new JButton();
		dateField=new JTextField("����ѡ������");
		dateChooser = DateChooser.getInstance("yyyy-MM-dd");
		String[] orderColumnNames = {"ѡ��","ID","�ļ���ַ","�ռ���ַ","�������","�ܷ���","����״̬"}; //����
		String [][]tableVales={}; //����
		orderTableModel = new DefaultTableModel(tableVales,orderColumnNames);
	    orderTable = new JTable(orderTableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		String[] busiHallArrivalColumnNames = {"ѡ��","ID","Ӫҵ�����","��ת�����","������","��������","����״̬","����״̬"}; //����
		busiHallArrivalOrderTableModel = new DefaultTableModel(tableVales,busiHallArrivalColumnNames);
		busiHallArrivalOrderTable = new JTable(busiHallArrivalOrderTableModel){  
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		String[] busiHallLoadingListColumnNames = {"ѡ��","ID","Ŀ�ĵ�","��������","�˷�","ʱ��","����״̬"}; //����
		busiHallLoadingListTableModel = new DefaultTableModel(tableVales,busiHallLoadingListColumnNames);
		busiHallLoadingListTable = new JTable(busiHallLoadingListTableModel){  
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		String[] deliveryOrderTableClumnNames = {"ѡ��","ID","����Ա","�����","������","ʱ��","����״̬"}; //����
		deliveryOrderTableModel = new DefaultTableModel(tableVales,deliveryOrderTableClumnNames);
		deliveryOrderTable = new JTable(deliveryOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] tranCenArrivalOrderColumnNames = {"ѡ��","ID","��ת���ı��","��ת�����","������","����״̬","��������","����״̬"}; //����
		tranCenArrivalOrderTableModel = new DefaultTableModel(tableVales,tranCenArrivalOrderColumnNames);
		tranCenArrivalOrderTable= new JTable(tranCenArrivalOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] tranCenLoadingListColumnNames = {"ѡ��","ID","Ŀ�ĵ�","��������","�˷�","װ������","����״̬"}; //����
		tranCenLoadingListTableModel = new DefaultTableModel(tableVales,tranCenLoadingListColumnNames);
		tranCenLoadingListTable = new JTable(tranCenLoadingListTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] transferOrderColumnNames = {"ѡ��","ID","��ͨ��ʽ","������","�����","�����","�˷�","ʱ��","����״̬"}; //����
		transferOrderTableModel = new DefaultTableModel(tableVales,transferOrderColumnNames);
		transferOrderTable = new JTable(transferOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] receivablesOrderColumnNames = {"ѡ��","ID","���Ա","���","�տ�����","ʱ��","����״̬"}; //����
		receivablesOrderTableModel = new DefaultTableModel(tableVales,receivablesOrderColumnNames);
		receivablesOrderTable = new JTable(receivablesOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] paymentOrderColumnNames = {"ѡ��","ID","������","�����˺�","���","��Ŀ","ʱ��","����״̬"}; //����
		paymentOrderTableModel = new DefaultTableModel(tableVales,paymentOrderColumnNames);
		paymentOrderTable = new JTable(paymentOrderTableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		String[] outBoundOrderColumnNames = {"ѡ��","ID","Ŀ�ĵ�","��ݱ��","װ����ʽ","��������","����","����״̬"}; //����
		outBoundOrderTableModel = new DefaultTableModel(tableVales,outBoundOrderColumnNames);
		outBoundOrderTable = new JTable(outBoundOrderTableModel){  
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		String[] storageListColumnNames = {"ѡ��","ID","Ŀ�ĵ�","��ݱ��","����","�ź�","�������","����״̬"}; //����
		storageListTableModel = new DefaultTableModel(tableVales,storageListColumnNames);
		storageListTable = new JTable(storageListTableModel){  
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
		sheetLabel.setText("��������");
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
				case "����":documentsType=DocumentsType.Order;break;
				case "Ӫҵ�����ﵥ":documentsType=DocumentsType.BusiHallArrivalOrder;break;
				case "Ӫҵ��װ����":documentsType=DocumentsType.BusiHallLoadingList;break;
				case "�ɼ���":documentsType=DocumentsType.DeliveryOrder;break;
				case "��ת���ĵ��ﵥ":documentsType=DocumentsType.TranCenArrivalOrder;break;
				case "��ת����װ����":documentsType=DocumentsType.TranCenLoadingList;break;
				case "��ת��":documentsType=DocumentsType.TransferOrder;break;
				case "�տ":documentsType=DocumentsType.ReceivablesOrder;break;
				case "���":documentsType=DocumentsType.PaymentOrder;break;
				case "��ⵥ":documentsType=DocumentsType.OutBoundOrder;break;
				case "���ⵥ":documentsType=DocumentsType.StorageList;break;
				default:break;
				}
			}     
		});
		
		findByDate.setBounds(30,75,90,24);
		findByDate.setText("����:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		findByDate.setOpaque(true);
		
		dateField.setBounds(120,77,120,20);
		dateChooser.register(dateField);
		
		dateFind.setBounds(330,75,50,24);
		dateFind.setText("����");
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
					ArrayList<BusiHallLoadingListlineitemPO> busiHallLoadingListArrayList=
							(ArrayList<BusiHallLoadingListlineitemPO>)javaBean1.getObject();
					makeBusiHallLoadingListTable(busiHallLoadingListArrayList);
					break;
				case DeliveryOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<DeliveryOrderPO> deliveryOrderArrayList=
							(ArrayList<DeliveryOrderPO>)javaBean1.getObject();
					makeDeliveryOrderTable(deliveryOrderArrayList);
					break;
				case TranCenArrivalOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<TranCenArrivalOrderPO> tranCenArrivalOrderArrayList=
							(ArrayList<TranCenArrivalOrderPO>)javaBean1.getObject();
					makeTranCenArrivalOrderTable(tranCenArrivalOrderArrayList);
					break;
				case TranCenLoadingList:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<TranCenLoadingListlineitemPO> tranCenLoadingListArrayList=
							(ArrayList<TranCenLoadingListlineitemPO>)javaBean1.getObject();
					makeTranCenLoadingListTable(tranCenLoadingListArrayList);
					break;
				case TransferOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<TransferOrderlineitemPO> transferOrderArrayList=
							(ArrayList<TransferOrderlineitemPO>)javaBean1.getObject();
					makeTransferOrderTable(transferOrderArrayList);
					break;
				case ReceivablesOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<ReceivablesOrderPO> receivablesOrderArrayList=
							(ArrayList<ReceivablesOrderPO>)javaBean1.getObject();
					makeReceivablesOrderTable(receivablesOrderArrayList);
					break;
				case PaymentOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<PaymentOrderPO> paymentOrderArrayList=
							(ArrayList<PaymentOrderPO>)javaBean1.getObject();
					makePaymentOrderTable(paymentOrderArrayList);
					break;
				case OutBoundOrder:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<OutBoundOrderPO> outBoundOrderArrayList=
							(ArrayList<OutBoundOrderPO>)javaBean1.getObject();
					makeOutBoundOrderTable(outBoundOrderArrayList);
					break;
				case StorageList:
					javaBean1=approDocmblservice.inquireB(documentsType,date);
					ArrayList<StorageListPO> storageListArrayList=
							(ArrayList<StorageListPO>)javaBean1.getObject();
					makeStorageListTable(storageListArrayList);
					break;
				default:break;
				}
			}
		});
		scrollPane = new JScrollPane(orderTable);
		approDocm.setBounds(30,420,50,24);
		approDocm.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		approDocm.setBackground(Color.WHITE);
		approDocm.setText("����");
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
		if(arrayList.size()==0){
			 return;
		 }
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
		String dateString=arrayList.get(arrayList.size()-1).getGenerateDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 orderlineitemPO=arrayList.get(i);
			 if(orderlineitemPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",orderlineitemPO.getId(),orderlineitemPO.getSenderAdd(),
			        orderlineitemPO.getAddresseeAdd(),orderlineitemPO.getExpressType().toString(),
			    	String.valueOf(orderlineitemPO.getTotalCost()),"δ��"};
			     orderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 orderlineitemPO=arrayList.get(i);
			 if(orderlineitemPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",orderlineitemPO.getId(),orderlineitemPO.getSenderAdd(),
			        orderlineitemPO.getAddresseeAdd(),orderlineitemPO.getExpressType().toString(),
			    	String.valueOf(orderlineitemPO.getTotalCost()),"����"};
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
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(orderTable.getSelectedRow()>=0){
				       idList.add((String)orderTable.getValueAt(orderTable.getSelectedRow(),1));
				       orderTableModel.removeRow(orderTable.getSelectedRow());
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.Order);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.Order,dateString);
				   ArrayList<OrderlineitemPO> orderArrayList = 
							(ArrayList<OrderlineitemPO>)javaBean1.getObject();
					makeOrderTable(orderArrayList);
				  }});
	}
	public void makeBusiHallArrivalOrderTable(ArrayList<BusiHallArrivalOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
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
		String dateString=arrayList.get(arrayList.size()-1).getArrivalDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallArrivalOrderPO=arrayList.get(i);
		     if(busiHallArrivalOrderPO.getApproState()==ApproState.NotApprove){
			       String[] oneRow={"",busiHallArrivalOrderPO.getId(),busiHallArrivalOrderPO.getBusiHallID(),
					 busiHallArrivalOrderPO.getTransferOrderID(),busiHallArrivalOrderPO.getOrigin(),
					 busiHallArrivalOrderPO.getArrivalDate(),busiHallArrivalOrderPO.getGoodState().toString(),
					 "δ��"};
			    busiHallArrivalOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallArrivalOrderPO=arrayList.get(i);
		     if(busiHallArrivalOrderPO.getApproState()==ApproState.Approve){
			       String[] oneRow={"",busiHallArrivalOrderPO.getId(),busiHallArrivalOrderPO.getBusiHallID(),
					 busiHallArrivalOrderPO.getTransferOrderID(),busiHallArrivalOrderPO.getOrigin(),
					 busiHallArrivalOrderPO.getArrivalDate(),busiHallArrivalOrderPO.getGoodState().toString(),
					 "����"};
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
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(busiHallArrivalOrderTable.getSelectedRow()>=0){
				       idList.add((String)busiHallArrivalOrderTable.getValueAt(
				    		   busiHallArrivalOrderTable.getSelectedRow(),1));
				       busiHallArrivalOrderTableModel.removeRow(busiHallArrivalOrderTable.getSelectedRow());
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.BusiHallArrivalOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.BusiHallArrivalOrder,dateString);
				   ArrayList<BusiHallArrivalOrderPO> busiHallArrivalOrderArrayList = 
							(ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
				   makeBusiHallArrivalOrderTable(busiHallArrivalOrderArrayList);
				  }});
	}
	public void makeBusiHallLoadingListTable(ArrayList<BusiHallLoadingListlineitemPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(busiHallLoadingListTableModel.getRowCount()>0){
			busiHallLoadingListTableModel.removeRow(busiHallLoadingListTableModel.getRowCount()-1);
		}
		busiHallLoadingListTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		busiHallLoadingListTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getLoadingDate();
		for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallLoadingListlineitemPO=arrayList.get(i);
		     if(busiHallLoadingListlineitemPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",busiHallLoadingListlineitemPO.getID(),
					 busiHallLoadingListlineitemPO.getDestination(),busiHallLoadingListlineitemPO.getTruckNum(),
					 String.valueOf(busiHallLoadingListlineitemPO.getCarriage()),
					 busiHallLoadingListlineitemPO.getLoadingDate(),"δ��"};
			     busiHallLoadingListTableModel.addRow(oneRow);
		     }
		 }
		for(int i=arrayList.size()-1;i>=0;i--){
		     busiHallLoadingListlineitemPO=arrayList.get(i);
		     if(busiHallLoadingListlineitemPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",busiHallLoadingListlineitemPO.getID(),
					 busiHallLoadingListlineitemPO.getDestination(),busiHallLoadingListlineitemPO.getTruckNum(),
					 String.valueOf(busiHallLoadingListlineitemPO.getCarriage()),
					 busiHallLoadingListlineitemPO.getLoadingDate(),"����"};
			     busiHallLoadingListTableModel.addRow(oneRow);
		     }
		 }
		 busiHallLoadingListTable.setRowHeight(24);
		 busiHallLoadingListTable.setBackground(Color.WHITE);
		 busiHallLoadingListTable.setShowVerticalLines(true);
		 busiHallLoadingListTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(busiHallLoadingListTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(busiHallLoadingListTable.getSelectedRow()>=0){
				       idList.add((String)busiHallLoadingListTable.getValueAt(busiHallLoadingListTable.getSelectedRow(),1));
				       busiHallLoadingListTableModel.removeRow(busiHallLoadingListTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.BusiHallLoadingList);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.BusiHallLoadingList,dateString);
				   ArrayList<BusiHallLoadingListlineitemPO> busiHallLoadingListArrayList = 
							(ArrayList<BusiHallLoadingListlineitemPO>)javaBean1.getObject();
				   makeBusiHallLoadingListTable(busiHallLoadingListArrayList);
				  }});
	}
	public void makeDeliveryOrderTable(ArrayList<DeliveryOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(deliveryOrderTableModel.getRowCount()>0){
			deliveryOrderTableModel.removeRow(deliveryOrderTableModel.getRowCount()-1);
		}
		 deliveryOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		 deliveryOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 String dateString=arrayList.get(arrayList.size()-1).getArrivalDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 deliveryOrderPO=arrayList.get(i);
			 if(deliveryOrderPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",deliveryOrderPO.getID(),deliveryOrderPO.getDeliverier(),
					 deliveryOrderPO.getArrivalDate(),deliveryOrderPO.getOrderID(),
					 deliveryOrderPO.getGenerateTime(),"δ��"};
			     deliveryOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 deliveryOrderPO=arrayList.get(i);
			 if(deliveryOrderPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",deliveryOrderPO.getID(),deliveryOrderPO.getDeliverier(),
					 deliveryOrderPO.getArrivalDate(),deliveryOrderPO.getOrderID(),
					 deliveryOrderPO.getGenerateTime(),"����"};
			     deliveryOrderTableModel.addRow(oneRow);
			 }
		 }
		 deliveryOrderTable.setRowHeight(24);
		 deliveryOrderTable.setBackground(Color.WHITE);
		 deliveryOrderTable.setShowVerticalLines(true);
		 deliveryOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(deliveryOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(deliveryOrderTable.getSelectedRow()>=0){
				       idList.add((String)deliveryOrderTable.getValueAt(deliveryOrderTable.getSelectedRow(),1));
				       deliveryOrderTableModel.removeRow(deliveryOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.DeliveryOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.DeliveryOrder,dateString);
				   ArrayList<DeliveryOrderPO> deliveryOrderArrayList = 
							(ArrayList<DeliveryOrderPO>)javaBean1.getObject();
				   makeDeliveryOrderTable(deliveryOrderArrayList);
				  }});
	}
	public void makeTranCenArrivalOrderTable(ArrayList<TranCenArrivalOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(tranCenArrivalOrderTableModel.getRowCount()>0){
			tranCenArrivalOrderTableModel.removeRow(tranCenArrivalOrderTableModel.getRowCount()-1);
		}
		 tranCenArrivalOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		 tranCenArrivalOrderTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		 tranCenArrivalOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 String dateString=arrayList.get(arrayList.size()-1).getArrivalDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 tranCenArrivalOrderPO=arrayList.get(i);
			 if(tranCenArrivalOrderPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",tranCenArrivalOrderPO.getID(),tranCenArrivalOrderPO.getTranCenID(),
					 tranCenArrivalOrderPO.getTransferOrderID(),tranCenArrivalOrderPO.getOrigin(),
					 tranCenArrivalOrderPO.getGoodState().toString(),tranCenArrivalOrderPO.getArrivalDate(),
					 "δ��"};
			     tranCenArrivalOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 tranCenArrivalOrderPO=arrayList.get(i);
			 if(tranCenArrivalOrderPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",tranCenArrivalOrderPO.getID(),tranCenArrivalOrderPO.getTranCenID(),
					 tranCenArrivalOrderPO.getTransferOrderID(),tranCenArrivalOrderPO.getOrigin(),
					 tranCenArrivalOrderPO.getGoodState().toString(),tranCenArrivalOrderPO.getArrivalDate(),
					 "����"};
			     tranCenArrivalOrderTableModel.addRow(oneRow);
			 }
		 }
		 tranCenArrivalOrderTable.setRowHeight(24);
		 tranCenArrivalOrderTable.setBackground(Color.WHITE);
		 tranCenArrivalOrderTable.setShowVerticalLines(true);
		 tranCenArrivalOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(tranCenArrivalOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(tranCenArrivalOrderTable.getSelectedRow()>=0){
				       idList.add((String)tranCenArrivalOrderTable.getValueAt(tranCenArrivalOrderTable.getSelectedRow(),1));
				       tranCenArrivalOrderTableModel.removeRow(tranCenArrivalOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.TranCenArrivalOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.TranCenArrivalOrder,dateString);
				   ArrayList<TranCenArrivalOrderPO> tranCenArrivalOrderArrayList = 
							(ArrayList<TranCenArrivalOrderPO>)javaBean1.getObject();
				   makeTranCenArrivalOrderTable(tranCenArrivalOrderArrayList);
				  }});
	}
	public void makeTranCenLoadingListTable(ArrayList<TranCenLoadingListlineitemPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(tranCenLoadingListTableModel.getRowCount()>0){
			tranCenLoadingListTableModel.removeRow(tranCenLoadingListTableModel.getRowCount()-1);
		}
		tranCenLoadingListTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		tranCenLoadingListTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getLoadingDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 tranCenLoadingListlineitemPO=arrayList.get(i);
			 if(tranCenLoadingListlineitemPO.getApproState()==ApproState.NotApprove){
			    String[] oneRow={"",tranCenLoadingListlineitemPO.getID(),tranCenLoadingListlineitemPO.getDestination(),
					 tranCenLoadingListlineitemPO.getTruckNum(),
					 String.valueOf(tranCenLoadingListlineitemPO.getCarriage()),
					 tranCenLoadingListlineitemPO.getLoadingDate(),"δ��"};
			    tranCenLoadingListTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 tranCenLoadingListlineitemPO=arrayList.get(i);
			 if(tranCenLoadingListlineitemPO.getApproState()==ApproState.Approve){
			    String[] oneRow={"",tranCenLoadingListlineitemPO.getID(),tranCenLoadingListlineitemPO.getDestination(),
					 tranCenLoadingListlineitemPO.getTruckNum(),
					 String.valueOf(tranCenLoadingListlineitemPO.getCarriage()),
					 tranCenLoadingListlineitemPO.getLoadingDate(),"����"};
			    tranCenLoadingListTableModel.addRow(oneRow);
			 }
		 }
		 tranCenLoadingListTable.setRowHeight(24);
		 tranCenLoadingListTable.setBackground(Color.WHITE);
		 tranCenLoadingListTable.setShowVerticalLines(true);
		 tranCenLoadingListTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(tranCenLoadingListTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(tranCenLoadingListTable.getSelectedRow()>=0){
				       idList.add((String)tranCenLoadingListTable.getValueAt(tranCenLoadingListTable.getSelectedRow(),1));
				       tranCenLoadingListTableModel.removeRow(tranCenLoadingListTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.TranCenLoadingList);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.TranCenLoadingList,dateString);
				   ArrayList<TranCenLoadingListlineitemPO> tranCenLoadingListArrayList = 
							(ArrayList<TranCenLoadingListlineitemPO>)javaBean1.getObject();
				   makeTranCenLoadingListTable(tranCenLoadingListArrayList);
				  }});
	}
	public void makeTransferOrderTable(ArrayList<TransferOrderlineitemPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(transferOrderTableModel.getRowCount()>0){
			transferOrderTableModel.removeRow(transferOrderTableModel.getRowCount()-1);
		}
		transferOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		transferOrderTable.getColumnModel().getColumn(1).setPreferredWidth(160);
		transferOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 transferOrderlineitemPO=arrayList.get(i);
			 if(transferOrderlineitemPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",transferOrderlineitemPO.getId(),
					 transferOrderlineitemPO.getTransportType().toString(),
					 transferOrderlineitemPO.getOrigin(),transferOrderlineitemPO.getDestination(),
					 transferOrderlineitemPO.getVehiclesNum(),
					 String.valueOf(transferOrderlineitemPO.getCarriage()),
					 transferOrderlineitemPO.getDate(),"δ��"};
			     transferOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 transferOrderlineitemPO=arrayList.get(i);
			 if(transferOrderlineitemPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",transferOrderlineitemPO.getId(),
					 transferOrderlineitemPO.getTransportType().toString(),
					 transferOrderlineitemPO.getOrigin(),transferOrderlineitemPO.getDestination(),
					 transferOrderlineitemPO.getVehiclesNum(),
					 String.valueOf(transferOrderlineitemPO.getCarriage()),
					 transferOrderlineitemPO.getDate(),"����"};
			     transferOrderTableModel.addRow(oneRow);
			 }
		 }
		 transferOrderTable.setRowHeight(24);
		 transferOrderTable.setBackground(Color.WHITE);
		 transferOrderTable.setShowVerticalLines(true);
		 transferOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(transferOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(transferOrderTable.getSelectedRow()>=0){
				       idList.add((String)transferOrderTable.getValueAt(transferOrderTable.getSelectedRow(),1));
				       transferOrderTableModel.removeRow(transferOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.TransferOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.TransferOrder,dateString);
				   ArrayList<TransferOrderlineitemPO> transferOrderArrayList = 
							(ArrayList<TransferOrderlineitemPO>)javaBean1.getObject();
				   makeTransferOrderTable(transferOrderArrayList);
				  }});
	}
	public void makeReceivablesOrderTable(ArrayList<ReceivablesOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(receivablesOrderTableModel.getRowCount()>0){
			receivablesOrderTableModel.removeRow(receivablesOrderTableModel.getRowCount()-1);
		}
		receivablesOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		receivablesOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getDate();
		for(int i=arrayList.size()-1;i>=0;i--){
		    receivablesOrderPO=arrayList.get(i);
		    if(receivablesOrderPO.getApproState()==ApproState.NotApprove){
			    String[] oneRow={"",receivablesOrderPO.getID(),receivablesOrderPO.getCourier(),
					String.valueOf(receivablesOrderPO.getAmount()),
					receivablesOrderPO.getDate(),"δ��"};
			    receivablesOrderTableModel.addRow(oneRow);
		    }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
		    receivablesOrderPO=arrayList.get(i);
		    if(receivablesOrderPO.getApproState()==ApproState.Approve){
			    String[] oneRow={"",receivablesOrderPO.getID(),receivablesOrderPO.getCourier(),
					String.valueOf(receivablesOrderPO.getAmount()),
					receivablesOrderPO.getDate(),"����"};
			    receivablesOrderTableModel.addRow(oneRow);
		    }
		 }
		 receivablesOrderTable.setRowHeight(24);
		 receivablesOrderTable.setBackground(Color.WHITE);
		 receivablesOrderTable.setShowVerticalLines(true);
		 receivablesOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(receivablesOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(receivablesOrderTable.getSelectedRow()>=0){
				       idList.add((String)receivablesOrderTable.getValueAt(receivablesOrderTable.getSelectedRow(),1));
				       receivablesOrderTableModel.removeRow(receivablesOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.ReceivablesOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.ReceivablesOrder,dateString);
				   ArrayList<ReceivablesOrderPO> receivablesOrderArrayList = 
							(ArrayList<ReceivablesOrderPO>)javaBean1.getObject();
				   makeReceivablesOrderTable(receivablesOrderArrayList);
				  }});
	}
	public void makePaymentOrderTable(ArrayList<PaymentOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(paymentOrderTableModel.getRowCount()>0){
			paymentOrderTableModel.removeRow(paymentOrderTableModel.getRowCount()-1);
		}
		paymentOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		paymentOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getDate();
		for(int i=arrayList.size()-1;i>=0;i--){
		     paymentOrderPO=arrayList.get(i);
		     if(paymentOrderPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",paymentOrderPO.getID(),paymentOrderPO.getPayer(),
					 paymentOrderPO.getBankAccount(),String.valueOf(paymentOrderPO.getAmount()),
					 paymentOrderPO.getEntry(),paymentOrderPO.getDate(),"δ��"};
			     paymentOrderTableModel.addRow(oneRow);
		     }
		 }
		for(int i=arrayList.size()-1;i>=0;i--){
		     paymentOrderPO=arrayList.get(i);
		     if(paymentOrderPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",paymentOrderPO.getID(),paymentOrderPO.getPayer(),
					 paymentOrderPO.getBankAccount(),String.valueOf(paymentOrderPO.getAmount()),
					 paymentOrderPO.getEntry(),paymentOrderPO.getDate(),"����"};
			     paymentOrderTableModel.addRow(oneRow);
		     }
		 }
		 paymentOrderTable.setRowHeight(24);
		 paymentOrderTable.setBackground(Color.WHITE);
		 paymentOrderTable.setShowVerticalLines(true);
		 paymentOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(paymentOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(paymentOrderTable.getSelectedRow()>=0){
				       idList.add((String)paymentOrderTable.getValueAt(paymentOrderTable.getSelectedRow(),1));
				       paymentOrderTableModel.removeRow(paymentOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.PaymentOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.PaymentOrder,dateString);
				   ArrayList<PaymentOrderPO> paymentOrderArrayList = 
							(ArrayList<PaymentOrderPO>)javaBean1.getObject();
				   makePaymentOrderTable(paymentOrderArrayList);
				  }});
	}
	public void makeOutBoundOrderTable(ArrayList<OutBoundOrderPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(outBoundOrderTableModel.getRowCount()>0){
			outBoundOrderTableModel.removeRow(outBoundOrderTableModel.getRowCount()-1);
		}
		outBoundOrderTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		outBoundOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getOutDate();
		 for(int i=arrayList.size()-1;i>=0;i--){
			 outBoundOrderPO=arrayList.get(i);
			 if(outBoundOrderPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",outBoundOrderPO.getId(),outBoundOrderPO.getDestination(),
					 outBoundOrderPO.getOrderID(),outBoundOrderPO.getTransportType().toString(),
					 outBoundOrderPO.getOutDate(),outBoundOrderPO.getArea(),"δ��"};
			     outBoundOrderTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=arrayList.size()-1;i>=0;i--){
			 outBoundOrderPO=arrayList.get(i);
			 if(outBoundOrderPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",outBoundOrderPO.getId(),outBoundOrderPO.getDestination(),
					 outBoundOrderPO.getOrderID(),outBoundOrderPO.getTransportType().toString(),
					 outBoundOrderPO.getOutDate(),outBoundOrderPO.getArea(),"����"};
			     outBoundOrderTableModel.addRow(oneRow);
			 }
		 }
		 outBoundOrderTable.setRowHeight(24);
		 outBoundOrderTable.setBackground(Color.WHITE);
		 outBoundOrderTable.setShowVerticalLines(true);
		 outBoundOrderTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(outBoundOrderTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(outBoundOrderTable.getSelectedRow()>=0){
				       idList.add((String)outBoundOrderTable.getValueAt(outBoundOrderTable.getSelectedRow(),1));
				       outBoundOrderTableModel.removeRow(outBoundOrderTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.OutBoundOrder);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.OutBoundOrder,dateString);
				   ArrayList<OutBoundOrderPO> outBoundOrderArrayList = 
							(ArrayList<OutBoundOrderPO>)javaBean1.getObject();
				   makeOutBoundOrderTable(outBoundOrderArrayList);
				  }});
	}
	public void makeStorageListTable(ArrayList<StorageListPO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(storageListTableModel.getRowCount()>0){
			storageListTableModel.removeRow(storageListTableModel.getRowCount()-1);
		}
		storageListTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		storageListTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String dateString=arrayList.get(arrayList.size()-1).getInDate();
		 for(int i=0;i<arrayList.size();i++){
			 storageListPO=arrayList.get(i);
			 if(storageListPO.getApproState()==ApproState.NotApprove){
			     String[] oneRow={"",storageListPO.getId(),storageListPO.getDestination(),
					 storageListPO.getOrderID(),storageListPO.getAreaNum(),
					 storageListPO.getRowNum(),storageListPO.getInDate(),"δ��"};
			     storageListTableModel.addRow(oneRow);
			 }
		 }
		 for(int i=0;i<arrayList.size();i++){
			 storageListPO=arrayList.get(i);
			 if(storageListPO.getApproState()==ApproState.Approve){
			     String[] oneRow={"",storageListPO.getId(),storageListPO.getDestination(),
					 storageListPO.getOrderID(),storageListPO.getAreaNum(),
					 storageListPO.getRowNum(),storageListPO.getInDate(),"����"};
			     storageListTableModel.addRow(oneRow);
			 }
		 }
		 storageListTable.setRowHeight(24);
		 storageListTable.setBackground(Color.WHITE);
		 storageListTable.setShowVerticalLines(true);
		 storageListTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(storageListTable);
		 approDocm.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(storageListTable.getSelectedRow()>=0){
				       idList.add((String)storageListTable.getValueAt(storageListTable.getSelectedRow(),1));
				       storageListTableModel.removeRow(storageListTable.getSelectedRow());  //ɾ���� 
				   }
				   approDocmblservice=new ApproDocm();
				   approDocmblservice.approveDocuments(idList,DocumentsType.StorageList);
				   javaBean1=approDocmblservice.inquireB(DocumentsType.StorageList,dateString);
				   ArrayList<StorageListPO> storageListArrayList = 
							(ArrayList<StorageListPO>)javaBean1.getObject();
				   makeStorageListTable(storageListArrayList);
				  }});
	}
}
