package presentation.documentsui.TransferOrderui;

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

import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.documentsbl.TransferOrder;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.documentsblservice.TransferOrderblservice;
import presentation.reuse.Listui;
import presentation.userui.TranCenClerkui;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

public class TransferOrderListui extends Listui{
	TransferOrderblservice transferOrderblservice;
	TransferOrderlineitemVO oneLine;
	
	public static void main(String[] args){
		
		TranCenClerkui ui=new TranCenClerkui();
		TransferOrderListui uiPanel=new TransferOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public TransferOrderListui(){
		
		sheetLabel.setText("中转单管理");
		
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
							transferOrderblservice=new TransferOrder();
							try {
								javaBean1=transferOrderblservice.inquireB(dateString);
								ArrayList<TransferOrderlineitemVO> arrayList = (ArrayList<TransferOrderlineitemVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<TransferOrderlineitemVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","ID","交通方式","出发地","到达地","航班号","运费","时间"}; //列名
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
		 String[] Row1={" ","12345678","火车","上海","南京","12345678","2000","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getTransportType().toString(),oneLine.getStartingAdd(),
					     oneLine.getEndAdd(),oneLine.getVehiclesId(),String.valueOf(oneLine.getCarriage()),oneLine.getDate()};
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
				   transferOrderblservice=new TransferOrder();
				   transferOrderblservice.delete(idList);
				  }});
		 this.add(delete);
	}
}
