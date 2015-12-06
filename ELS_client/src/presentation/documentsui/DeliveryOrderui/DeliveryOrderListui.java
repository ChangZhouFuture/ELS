package presentation.documentsui.DeliveryOrderui;

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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.orderbl.Order;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.orderblservice.Orderblservice;

public class DeliveryOrderListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JLabel year;
	public JLabel month;
	public JLabel day;
	public JButton add;
	public JButton idFind;
	public JButton dateFind;
	public JTextField idField;
	public JTextField yearField;
	public JTextField monthField;
	public JTextField dayField;
	public JRadioButton findById;
	public JRadioButton findByDate;
	public ButtonGroup findGroup;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		DeliveryOrderListui uiPanel=new DeliveryOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public DeliveryOrderListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JRadioButton();
		findByDate=new JRadioButton();
		findGroup=new ButtonGroup();
		idField=new JTextField();
		yearField=new JTextField();
		monthField=new JTextField();
		dayField=new JTextField();
		year=new JLabel();
		month=new JLabel();
		day=new JLabel();
		idFind=new JButton();
		dateFind=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setText("派件信息管理");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加单据");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByDate.setBounds(30,125,120,24);
		findByDate.setText("按日期查找:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		
		findGroup.add(findById);
		findGroup.add(findByDate);
		
		idField.setBounds(150,92,120,20);
		
		yearField.setBounds(150,127,48,20);
		
		year.setBounds(200,125,24,24);
		year.setText("年");
		year.setFont(font2);
		year.setBackground(Color.WHITE);
		year.setOpaque(true);
		
		monthField.setBounds(230,127,24,20);
		
		month.setBounds(260,125,24,24);
		month.setText("月");
		month.setFont(font2);
		month.setBackground(Color.WHITE);
		month.setOpaque(true);
		
		dayField.setBounds(290,127,24,20);
		
		day.setBounds(320,125,24,24);
		day.setText("日");
		day.setFont(font2);
		day.setBackground(Color.WHITE);
		day.setOpaque(true);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		dateFind.setBounds(360,125,64,24);
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setBackground(Color.WHITE);
		dateFind.setText("查找");
		dateFind.setFont(font2);
		dateFind.setOpaque(true);
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString=null;
				if(yearField.getText()!=null){
					dateString=dateString+yearField.getText()+"-";
					if(monthField.getText()!=null){
						dateString=dateString+monthField.getText()+"-";
						if(dayField.getText()!=null){
							dateString=dateString+dayField.getText();
							JavaBean1 javaBean1;
							DeliveryOrderblservice deliveryOrderblservice=new DeliveryOrder();
							try {
								javaBean1=deliveryOrderblservice.inquireB(dateString);
								ArrayList<DeliveryOrderVO> arrayList = (ArrayList<DeliveryOrderVO>)javaBean1.getObject();
								makeTable(arrayList);
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
						else{
							System.out.println("Error");
						}
					}
					else{
						System.out.println("Error");
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
		this.add(findByDate);
		this.add(idField);
		this.add(yearField);
		this.add(year);
		this.add(monthField);
		this.add(month);
		this.add(dayField);
		this.add(day);
		this.add(idFind);
		this.add(dateFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<DeliveryOrderVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","ID","派送员","到达地","订单号","时间"}; //列名
		 String [][]tableVales={}; //数据
		 tableModel = new DefaultTableModel(tableVales,columnNames);
		 table = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
//		 ButtonGroup checkboxGroup=new ButtonGroup();
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
		 String[] Row1={" ","12345678","张三","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     DeliveryOrderVO oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getDeliverier(),oneLine.getArrivalDate(),
					     oneLine.getOrderID(),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 tableModel.addRow(Row1);
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane = new JScrollPane(table); //支持滚动
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
		 this.add(scrollPane);
		 delete=new JButton();
		 delete.setBounds(30,420,50,24);
		 delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 delete.setBackground(Color.WHITE);
		 delete.setText("删除");
		 Font font3=new Font("TimesRoman",Font.PLAIN,15);
		 delete.setFont(font3);
		 delete.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				    int selectedRow = table.getSelectedRow();//获得选中行的索引
				    if(selectedRow!=-1){
				     tableModel.removeRow(selectedRow);  //删除行 
				    }
				   }
//				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
//				     DeliveryOrderblservice deliveryOrderblservice=new DeliveryOrder();
//				     deliveryOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
