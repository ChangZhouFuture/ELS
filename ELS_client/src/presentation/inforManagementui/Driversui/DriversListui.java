package presentation.inforManagementui.Driversui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.inforManagementbl.DriversInfor;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import presentation.reuse.Images;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public class DriversListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton cityFind;
	public JTextField idField;
	public JTextField cityField;
	public JRadioButton findById;
	public JRadioButton findByName;
	public ButtonGroup findGroup;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public DriversInforblservice driversInforblservice;
	
	public DriversListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JRadioButton();
		findByName=new JRadioButton();
		findGroup=new ButtonGroup();
		idField=new JTextField();
		cityField=new JTextField();
		idFind=new JButton();
		cityFind=new JButton();
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setText("˾����Ϣ����");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("���ӵ���");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("��ID����:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByName.setBounds(30,125,120,24);
		findByName.setText("����������:");
		findByName.setFont(font2);
		findByName.setBackground(Color.WHITE);
		
		findGroup.add(findById);
		findGroup.add(findByName);
		
		idField.setBounds(150,92,120,20);
		
		cityField.setBounds(150,127,48,20);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("����");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		cityFind.setBounds(360,125,64,24);
		cityFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		cityFind.setBackground(Color.WHITE);
		cityFind.setText("����");
		cityFind.setFont(font2);
		cityFind.setOpaque(true);
		cityFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cityString=null;
				if(cityField.getText()!=null){
					cityString=cityString+cityField.getText();
					JavaBean1 javaBean1;
					driversInforblservice=new DriversInfor();
					try {
						javaBean1=driversInforblservice.inquire(cityString);
//						ArrayList<DriverslineitemVO> arrayList=(DriverslineitemVO>)javaBean1.getObject();
//						makeTable(arrayList);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				else{
					System.out.println("Error");
				}
			}
		});
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByName);
		this.add(idField);
		this.add(cityField);
		this.add(idFind);
		this.add(cityFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<DriverslineitemVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"ѡ��","ID","����Ա","�����","������","ʱ��"}; //����
		 String [][]tableVales={}; //����
		 tableModel = new DefaultTableModel(tableVales,columnNames);
		 table = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		 table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
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
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 String[] Row1={" ","12345678","����","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 DriverslineitemVO oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getDeliverier(),oneLine.getArrivalDate(),
					     oneLine.getOrderID(),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane = new JScrollPane(table); //֧�ֹ���
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
		 this.add(scrollPane);
		 delete=new JButton();
		 delete.setBounds(30,420,50,24);
		 delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 delete.setBackground(Color.WHITE);
		 delete.setText("ɾ��");
		 Font font3=new Font("TimesRoman",Font.PLAIN,15);
		 delete.setFont(font3);
		 delete.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				    int selectedRow = table.getSelectedRow();//���ѡ���е�����
				    if(selectedRow!=-1){
				     tableModel.removeRow(selectedRow);  //ɾ���� 
				    }
				   }
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   DeliveryOrderblservice deliveryOrderblservice=new DeliveryOrder();
				   deliveryOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
