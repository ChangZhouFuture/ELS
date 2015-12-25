package presentation.orderui;

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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.Images;
import presentation.userui.Courierui;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class OrderListui extends JPanel{
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
	public JLabel findById;
	public JLabel findByDate;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public DefaultTableModel tableModel;
	public Orderblservice orderblservice;
	public OrderlineitemVO oneLine;
	public JavaBean1 javaBean1;
	
	public static void main(String[] args){
		
		Courierui ui=new Courierui();
		OrderListui uiPanel=new OrderListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OrderListui(){
		addText=new JLabel();
		sheetLabel=new JLabel();
		findById = new JLabel();
		findByDate = new JLabel();
		year=new JLabel();
		month=new JLabel();
		day=new JLabel();
		idField=new JTextField();
		yearField=new JTextField();
		monthField=new JTextField();
		dayField=new JTextField();
		add=new JButton();
		idFind=new JButton();
		dateFind=new JButton();
		String[] columnNames = {"选择","ID","寄件地址","收件地址","快递类型","总费用","时间"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){  
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
		sheetLabel.setText("订单信息管理");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加订单");
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
		dateFind.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String date = null;
				int year = Integer.parseInt(yearField.getText());
				int month = Integer.parseInt(monthField.getText());
				int day = Integer.parseInt(dayField.getText());
				
				if (year < 2015 || month < 0 || month > 12 || day < 0 || day > 31) {
					System.out.println("请重新输入日期");
					return ;
				}
				date = yearField.getText() + "-" + monthField.getText() + "-" 
						+ dayField.getText();
				System.out.println(date);
				orderblservice=new Order();
				try {
					javaBean1=orderblservice.inquireB(date);
					ArrayList<OrderlineitemVO> arrayList = 
							(ArrayList<OrderlineitemVO>)javaBean1.getObject();
					makeTable(arrayList);
				} catch (Exception e2) {
					e2.printStackTrace();
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
	public void makeTable(ArrayList<OrderlineitemVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 
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
		 String[] Row1={" ","12345678","张三","李四","被子","未到达","20","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getSenderAdd(),oneLine.getAddresseeAdd(),
			    		 oneLine.getExpressType().toString(),String.valueOf(oneLine.getTotalCost()),oneLine.getGenerateDate()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
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
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   orderblservice=new Order();
				   orderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
