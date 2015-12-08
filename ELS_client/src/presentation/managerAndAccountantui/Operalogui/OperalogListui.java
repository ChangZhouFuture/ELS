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
		
		add.setVisible(false);
		addText.setVisible(false);
		findById.setVisible(false);
		idField.setVisible(false);
		idFind.setVisible(false);
		delete.setVisible(false);
		
		findByDate.setBounds(30,65,120,24);
		yearField.setBounds(150,67,48,20);
		year.setBounds(200,65,24,24);
		monthField.setBounds(230,67,24,20);
		month.setBounds(260,65,24,24);
		dayField.setBounds(290,67,24,20);
		day.setBounds(320,65,24,24);
		dateFind.setBounds(360,65,64,24);		
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
							operaLogblservice=new InquireOperaLog();
							try {
								javaBean1=operaLogblservice.inquireOperaLog(dateString);
								ArrayList<OperaLogVO> arrayList = (ArrayList<OperaLogVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<OperaLogVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","职位","操作者","操作","对象","对象id","操作日期"}; //列名
		 String [][]tableVales={}; //数据
		 tableModel = new DefaultTableModel(tableVales,columnNames);
		 table = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		 table.getColumnModel().getColumn(4).setPreferredWidth(120);
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
		 String[] Row1={" ","12345678","121212","010101","上海","2015-12-5","完整","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getPositon(),oneLine.getOperatorId(),oneLine.getOperaType().toString(),
			    		 oneLine.getObjectType().toString(),oneLine.getId(),oneLine.getDate()};
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
	}
}
