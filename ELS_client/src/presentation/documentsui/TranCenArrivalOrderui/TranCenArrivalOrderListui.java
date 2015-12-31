package presentation.documentsui.TranCenArrivalOrderui;

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
import businesslogic.documentsbl.TranCenArrivalOrder;
import businesslogic.documentsbl.TransferOrder;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;
import businesslogicservice.documentsblservice.TransferOrderblservice;
import presentation.reuse.Listui;
import presentation.userui.TranCenClerkui;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

public class TranCenArrivalOrderListui extends Listui{
	TranCenArrivalOrderblservice tranCenArrivalOrderblservice;
	TranCenArrivalOrderVO oneLine;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		
		TranCenClerkui ui=new TranCenClerkui();
		TranCenArrivalOrderListui uiPanel=new TranCenArrivalOrderListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public TranCenArrivalOrderListui(){
		
		sheetLabel.setText("��ת���ĵ��ﵥ����");
		String[] columnNames = {"ѡ��","ID","��ת���ı��","��ת�����","������","����״̬","��������","ʱ��"}; //����
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
				String dateString="";
				dateString=showDate.getText();
				tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				try {
					javaBean1=tranCenArrivalOrderblservice.inquireB(dateString);
					ArrayList<TranCenArrivalOrderVO> arrayList = (ArrayList<TranCenArrivalOrderVO>)javaBean1.getObject();
					makeTable(arrayList);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		this.add(delete);
	}
	public void makeTable(ArrayList<TranCenArrivalOrderVO> arrayList){
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
		 table.getColumnModel().getColumn(2).setPreferredWidth(90);
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 for(int i=0;i<arrayList.size();i++){
			 oneLine=arrayList.get(i);
			 String[] oneRow={"",oneLine.getID(),oneLine.getTranCenID(),oneLine.getTransferOrderID(),oneLine.getOrigin(),
			    	 oneLine.getGoodState().toString(),oneLine.getArrivalDate(),oneLine.getGenerateTime()};
			 tableModel.addRow(oneRow);
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane = new JScrollPane(table); //֧�ֹ���
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
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
				   tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				   tranCenArrivalOrderblservice.deleteMany(idList);
				  }});
	}
}
