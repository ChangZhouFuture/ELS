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
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
import presentation.documentsui.DeliveryOrderui.DeliveryOrderListui;
import presentation.reuse.Listui;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.DeliveryOrderVO;
import vo.documentsVO.ReceivablesOrderVO;

public class ReceivablesOrderListui extends Listui{
	ReceivablesOrderblservice receivablesOrderblservice;
	ReceivablesOrderVO oneLine;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		ReceivablesOrderListui uiPanel=new ReceivablesOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public ReceivablesOrderListui(){
		
		sheetLabel.setText("�������");
		String[] columnNames = {"ѡ��","ID","���Ա","���","�տ�����","ʱ��"}; //����
		String [][]tableVales={}; //����
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		};
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString=null;
			    dateString=dateString+showDate.getText();
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
	}
	public void makeTable(ArrayList<ReceivablesOrderVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
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
		 String[] Row1={" ","12345678","����","200","2015-12-5","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getCourier(),String.valueOf(oneLine.getAmount()),
					     oneLine.getDate(),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
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
		 delete.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				       int selectedRow = table.getSelectedRow();//���ѡ���е�����
				       if(selectedRow!=-1){
				    	   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				           tableModel.removeRow(selectedRow);  //ɾ���� 
				       }
				   }
				   receivablesOrderblservice=new ReceivablesOrder();
				   receivablesOrderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
