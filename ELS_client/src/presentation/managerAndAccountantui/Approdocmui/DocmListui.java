package presentation.managerAndAccountantui.Approdocmui;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.GeneralManagerui;
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
				
			}
		});
		
		this.add(sheetLabel);
		this.add(findByDate);
		this.add(dateFind);
		this.add(dateField);
		this.add(sheetType);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
