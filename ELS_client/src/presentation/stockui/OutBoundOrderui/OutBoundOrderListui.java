package presentation.stockui.OutBoundOrderui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.stockbl.OutBoundOrder;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
import presentation.reuse.Listui;
import presentation.userui.StockManagerui;
import vo.stockVO.OutBoundOrderVO;

public class OutBoundOrderListui extends Listui{
	OutBoundOrderblservice outBoundOrderblservice;
	OutBoundOrderVO oneLine;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		
		StockManagerui ui=new StockManagerui();
		OutBoundOrderListui uiPanel=new OutBoundOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OutBoundOrderListui(){
		
		sheetLabel.setText("出库管理");
		String[] columnNames = {"选择","ID","目的地","快递编号","装运形式","出库日期","区号"}; //列名
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
				outBoundOrderblservice=new OutBoundOrder();
				try {
					javaBean1=outBoundOrderblservice.inquireB(dateString);
					ArrayList<OutBoundOrderVO> arrayList = (ArrayList<OutBoundOrderVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<OutBoundOrderVO> arrayList){
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
			 String[] oneRow={"",oneLine.getId(),oneLine.getDestination(),oneLine.getOrderID(),
			    	 oneLine.getTransportType().toString(), oneLine.getOutDate(),oneLine.getArea()};
			 tableModel.addRow(oneRow);
		 }
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
				   outBoundOrderblservice=new OutBoundOrder();
				   outBoundOrderblservice.deleteMany(idList);
				  }});
	}
}
