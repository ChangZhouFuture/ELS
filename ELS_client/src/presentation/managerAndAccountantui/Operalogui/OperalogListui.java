package presentation.managerAndAccountantui.Operalogui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallArrivalOrder;
import businesslogic.managerAndAccountantbl.InquireOperaLog;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
import businesslogicservice.managerAndAccountantblservice.OperaLogblservice;
import presentation.reuse.Listui;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.utilityVO.OperaLogVO;

public class OperalogListui extends Listui{
	OperaLogblservice operaLogblservice;
	OperaLogVO oneLine;
	
	public OperalogListui(){
		
		sheetLabel.setText("查询操作日志");
		String[] columnNames = {"职位","操作者","操作","对象","对象id","操作日期"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		 };
		add.setVisible(false);
		addText.setVisible(false);
		findById.setVisible(false);
		idField.setVisible(false);
		idFind.setVisible(false);
		delete.setVisible(false);
		
		findByDate.setBounds(30,65,120,24);
		showDate.setBounds(150,67,120,20);
		dateFind.setBounds(360,65,64,24);		
		dateFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dateString="";
				dateString=showDate.getText();
				JavaBean1 javaBean1;
				operaLogblservice=new InquireOperaLog();
				try {
					javaBean1=operaLogblservice.inquireOperaLog(dateString);
					ArrayList<OperaLogVO> arrayList = (ArrayList<OperaLogVO>)javaBean1.getObject();
					makeTable(arrayList);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		scrollPane=new JScrollPane(table);
		this.add(scrollPane);
	}
	public void makeTable(ArrayList<OperaLogVO> arrayList){
		if(arrayList.size()==0){
			 return;
		 }
		while(tableModel.getRowCount()>0){
			tableModel.removeRow(tableModel.getRowCount()-1);
		}
		 table.getColumnModel().getColumn(4).setPreferredWidth(120);
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 for(int i=arrayList.size()-1;i>=0;i--){
		     oneLine=arrayList.get(i);
			 String[] oneRow={oneLine.getPositon().toString(),oneLine.getOperatorId(),
					 oneLine.getOperaType().toString(),oneLine.getObjectType().
					 toString(),oneLine.getId(),oneLine.getDate()};
			 tableModel.addRow(oneRow);
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,100);
		 scrollPane.setViewportView(table);
	}
}
