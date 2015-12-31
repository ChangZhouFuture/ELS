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
