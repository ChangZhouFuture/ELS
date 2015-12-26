package presentation.documentsui.DeliveryOrderui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import presentation.reuse.Listui;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.DeliveryOrderVO;
import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;

public class DeliveryOrderListui extends Listui{
	DeliveryOrderblservice deliveryOrderblservice;
	DeliveryOrderVO oneLine;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
	
		BusiHallClerkui ui=new BusiHallClerkui();
		DeliveryOrderListui uiPanel=new DeliveryOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public DeliveryOrderListui(){
		
		sheetLabel.setText("派件单管理");
		
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString=null;
				dateString=dateString+showDate.getText();
				deliveryOrderblservice=new DeliveryOrder();
				try {
					javaBean1=deliveryOrderblservice.inquireB(dateString);
					ArrayList<DeliveryOrderVO> arrayList = (ArrayList<DeliveryOrderVO>)javaBean1.getObject();
					makeTable(arrayList);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public void makeTable(ArrayList<DeliveryOrderVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
		 }
		 String[] columnNames = {"选择","ID","派送员","到达地","订单号","时间"}; //列名
		 String [][]tableVales={}; //数据
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
		 String[] Row1={" ","12345678","张三","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getDeliverier(),oneLine.getArrivalDate(),
					     oneLine.getOrderID(),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
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
		 delete.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				       int selectedRow = table.getSelectedRow();//获得选中行的索引
				       if(selectedRow!=-1){
				    	   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				           tableModel.removeRow(selectedRow);  //删除行 
				       }
				   }
				   deliveryOrderblservice=new DeliveryOrder();
				   deliveryOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
