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
	
	public BusiHallArrivalOrderListui(){
		sheetLabel.setText("营业厅到达单管理");
		 String[] columnNames = {"选择","ID","营业厅编号","中转单编号","出发地","到达日期","货物状态"}; //列名
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
				String dateString=showDate.getText();
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
		scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		this.add(delete);
	}
	public void makeTable(ArrayList<BusiHallArrivalOrderVO> arrayList){
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
		 for(int i=arrayList.size()-1;i>=0;i--){
		     oneLine=arrayList.get(i);
			 String[] oneRow={"",oneLine.getId(),oneLine.getBusiHallID(),oneLine.getTransferOrderID(),
			    	 oneLine.getOrigin(),oneLine.getArrivalDate(),
					 String.valueOf(oneLine.getGoodState())};
			 tableModel.addRow(oneRow);
		 }
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
		 delete.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(table.getSelectedRow()>=0){
				       idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				       tableModel.removeRow(table.getSelectedRow());  //删除行 
				   }
				   busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				   busiHallArrivalOrderblservice.deleteMany(idList);
				  }});
		 
	}
}

