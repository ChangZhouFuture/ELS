package presentation.documentsui.BusiHallArrivalOrderui;

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
import vo.documentsVO.BusiHallArrivalOrderVO;
import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallArrivalOrder;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;

public class BusiHallArrivalOrderListui extends Listui{
	 BusiHallArrivalOrderblservice busiHallArrivalOrderblservice;
	 BusiHallArrivalOrderVO oneLine;
	 JavaBean1 javaBean1;
	 
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		BusiHallArrivalOrderListui uiPanel=new BusiHallArrivalOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public BusiHallArrivalOrderListui(){
		sheetLabel.setText("营业厅到达单管理");
		
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString=null;
				dateString=dateString+showDate.getText();
				busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				try {
					javaBean1=busiHallArrivalOrderblservice.inquireB(dateString);
					ArrayList<BusiHallArrivalOrderVO> arrayList = (ArrayList<BusiHallArrivalOrderVO>)javaBean1.getObject();
					makeTable(arrayList);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public void makeTable(ArrayList<BusiHallArrivalOrderVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 String[] columnNames = {"选择","ID","营业厅编号","中转单编号","出发地","到达日期","货物状态","时间"}; //列名
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
		 String[] Row1={" ","12345678","121212","010101","上海","2015-12-5","完整","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getBusiHallID(),oneLine.getTransferOrderID(),
			    		 oneLine.getOrigin(),oneLine.getArrivalDate(),
					     String.valueOf(oneLine.getGoodState()),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
					   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				       int selectedRow = table.getSelectedRow();//获得选中行的索引
				       if(selectedRow!=-1){
				           tableModel.removeRow(selectedRow);  //删除行 
				       }
				   }
				   busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				   busiHallArrivalOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}

