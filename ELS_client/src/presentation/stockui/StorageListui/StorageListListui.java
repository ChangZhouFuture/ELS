package presentation.stockui.StorageListui;

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
import businesslogic.stockbl.StorageList;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.stockblservice.StorageListblservice;
import presentation.reuse.Listui;
import presentation.userui.StockManagerui;
import vo.documentsVO.DeliveryOrderVO;
import vo.stockVO.StorageListVO;

public class StorageListListui extends Listui{
	StorageListblservice storageListblservice;
	StorageListVO oneLine;
	
	public static void main(String[] args){
		
		StockManagerui ui=new StockManagerui();
		StorageListListui uiPanel=new StorageListListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public StorageListListui(){
		
		sheetLabel.setText("������");
		
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
							storageListblservice=new StorageList();
							try {
								javaBean1=storageListblservice.inquireB(dateString);
								ArrayList<StorageListVO> arrayList = (ArrayList<StorageListVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<StorageListVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"ѡ��","ID","Ŀ�ĵ�","��ݱ��","�������","����","ʱ��"}; //����
		 String [][]tableVales={}; //����
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
		 String[] Row1={" ","12345678","����","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getDestination(),oneLine.getOrderID(),
					     oneLine.getInDate(),oneLine.getGenerateTime()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
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
		 delete=new JButton();
		 delete.setBounds(30,420,50,24);
		 delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 delete.setBackground(Color.WHITE);
		 delete.setText("ɾ��");
		 Font font3=new Font("TimesRoman",Font.PLAIN,15);
		 delete.setFont(font3);
		 delete.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				    int selectedRow = table.getSelectedRow();//���ѡ���е�����
				    if(selectedRow!=-1){
				     tableModel.removeRow(selectedRow);  //ɾ���� 
				    }
				   }
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   storageListblservice=new StorageList();
				   storageListblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
