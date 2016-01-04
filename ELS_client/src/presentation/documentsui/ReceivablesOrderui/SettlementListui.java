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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.ReceivablesOrderVO;

public class SettlementListui extends JPanel{
	public JLabel sheetLabel;
	public DateChooser dateChooser;
	public JTextField showDate;
	public JButton busiHallIDFind;
	public JButton dateFind;
	public JTextField busiHallIDField;
	public JLabel findByBusiHallID;
	public JLabel findByDate;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel tableModel;
	public JButton totalFigure;
	public JLabel totalAmount;
	ReceivablesOrderblservice receivablesOrderblservice;
	ReceivablesOrderVO oneLine;
	JavaBean1 javaBean1;
	double totalValue=0.0;
	
	public SettlementListui(){
		sheetLabel=new JLabel();
		findByBusiHallID=new JLabel();
		findByDate=new JLabel();
		busiHallIDField=new JTextField();
		busiHallIDFind=new JButton();
		dateFind=new JButton();
		totalFigure=new JButton();
		dateChooser = DateChooser.getInstance("yyyy-MM-dd");
		showDate = new JTextField("单击选择日期");
		totalAmount=new JLabel();
		
		String[] columnNames = {"选择","ID","快递员","金额","收款日期","时间"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString="";
			    dateString=showDate.getText();
			    receivablesOrderblservice=new ReceivablesOrder();
			    try {
				    javaBean1=receivablesOrderblservice.inqurieB(dateString);
				    ArrayList<ReceivablesOrderVO> arrayList = (ArrayList<ReceivablesOrderVO>)javaBean1.getObject();
				    makeTable(arrayList);
			    } catch (Exception e2) {
				    e2.printStackTrace();
			    }
			    }
		});
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("结算管理");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		
		findByBusiHallID.setBounds(30,60,120,24);
		findByBusiHallID.setText("按营业厅查找:");
		findByBusiHallID.setFont(font2);
		findByBusiHallID.setBackground(Color.WHITE);
		
		findByDate.setBounds(30,95,120,24);
		findByDate.setText("按日期查找:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		
		busiHallIDField.setBounds(150,62,120,20);
		
		showDate.setBounds(150,97,120,20);
		dateChooser.register(showDate);
		
		busiHallIDFind.setBounds(360,60,64,24);
		busiHallIDFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		busiHallIDFind.setBackground(Color.WHITE);
		busiHallIDFind.setText("查找");
		busiHallIDFind.setFont(font2);
		busiHallIDFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String busiHallIDString=null;
				busiHallIDString=busiHallIDString+busiHallIDField.getText();
			    receivablesOrderblservice=new ReceivablesOrder();
			    try {
				    javaBean1=receivablesOrderblservice.inquireC(busiHallIDString);
				    ArrayList<ReceivablesOrderVO> arrayList = (ArrayList<ReceivablesOrderVO>)javaBean1.getObject();
				    makeTable(arrayList);
			    } catch (Exception e2) {
				    e2.printStackTrace();
			    }
			    }
		});
		
		dateFind.setBounds(360,95,64,24);
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setBackground(Color.WHITE);
		dateFind.setText("查找");
		dateFind.setFont(font2);
		
		totalFigure.setBounds(30,420,60,24);
		totalFigure.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		totalFigure.setBackground(Color.WHITE);
		totalFigure.setText("合计");
		totalFigure.setFont(font2);
		
		totalAmount.setBounds(130,420,100,24);
		totalAmount.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		totalAmount.setBackground(Color.WHITE);
		totalAmount.setFont(font2);
		
		scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		this.add(sheetLabel);
		this.add(findByBusiHallID);
		this.add(findByDate);
		this.add(busiHallIDField);
		this.add(busiHallIDFind);
		this.add(dateFind);
		this.add(showDate);
		this.add(totalFigure);
		this.add(totalAmount);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
	public void makeTable(ArrayList<ReceivablesOrderVO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(tableModel.getRowCount()>0){
			tableModel.removeRow(tableModel.getRowCount()-1);
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
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 for(int i=arrayList.size()-1;i>=0;i--){
		     oneLine=arrayList.get(i);
			 String[] oneRow={"",oneLine.getID(),oneLine.getCourier(),String.valueOf(oneLine.getAmount()),
					 oneLine.getDate(),oneLine.getGenerateTime()};
			 tableModel.addRow(oneRow);
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
		 totalFigure.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   for(int i=0;i<tableModel.getRowCount();i++){
					   totalValue=totalValue+Double.valueOf(String.valueOf(tableModel.getValueAt(i,3)));
				   }
				   totalAmount.setText(String.valueOf(totalValue));
				  }});
		 
	}
}
