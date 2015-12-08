package presentation.documentsui.PaymentOrderui;

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
import presentation.reuse.Listui;
import presentation.userui.Accountantui2;
import vo.documentsVO.PaymentOrderVO;
import bean.JavaBean1;
import businesslogic.documentsbl.PaymentOrder;
import businesslogicservice.documentsblservice.PaymentOrderblservice;

public class PaymentOrderListui extends Listui{
	PaymentOrderblservice paymentOrderblservice;
	PaymentOrderVO oneLine;
	
	public static void main(String[] args){
		
		Accountantui2 ui=new Accountantui2();
		PaymentOrderListui uiPanel=new PaymentOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public PaymentOrderListui(){
		
		sheetLabel.setText("成本管理");
		
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
							paymentOrderblservice=new PaymentOrder();
							try {
								javaBean1=paymentOrderblservice.inquireB(dateString);
								ArrayList<PaymentOrderVO> arrayList = (ArrayList<PaymentOrderVO>)javaBean1.getObject();
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
	}
	public void makeTable(ArrayList<PaymentOrderVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","ID","付款人","付款账号","金额","条目","备注","时间"}; //列名
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
		 String[] Row1={" ","12345678","张三","00000000","1000","工资","无","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getPayer(),oneLine.getBankAccount(),
					     String.valueOf(oneLine.getAmount()),oneLine.getEntry(),
					     oneLine.getNote(),oneLine.getDate()};
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
				   paymentOrderblservice=new PaymentOrder();
				   paymentOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
