package presentation.documentsui.BusiHallLoadingListui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import presentation.reuse.Images;
import presentation.reuse.Listui;
import presentation.userui.BusiHallClerkui;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallLoadingList;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogicservice.documentsblservice.BusiHallLoadingListblservice;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;

public class BusinessHallLoadingListListui extends Listui{
	
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		BusinessHallLoadingListListui uiPanel=new BusinessHallLoadingListListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public BusinessHallLoadingListListui(){
		sheetLabel.setText("车辆装车管理");
		
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
							BusiHallLoadingListblservice busiHallLoadingListblservice=new BusiHallLoadingList();
							try {
								javaBean1=busiHallLoadingListblservice.inquireB(dateString);
								ArrayList<BusiHallLoadingListlineitemVO> arrayList=
										(ArrayList<BusiHallLoadingListlineitemVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<BusiHallLoadingListlineitemVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","ID","目的地","车辆代号","运费","时间"}; //列名
		 String [][]tableVales={}; //数据
		 tableModel = new DefaultTableModel(tableVales,columnNames);
		 table = new JTable(tableModel){  
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
//		 ButtonGroup checkboxGroup=new ButtonGroup();
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
		 String[] Row1={" ","12345678","南京","11111111","20","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 BusiHallLoadingListlineitemVO oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getDestination(),oneLine.getTruckNum(),
					     String.valueOf(oneLine.getCarriage()),oneLine.getLoadingDate()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 JScrollPane scrollPane = new JScrollPane(table); //支持滚动
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
				   BusiHallLoadingListblservice busiHallLoadingListblservice=new BusiHallLoadingList();
				   busiHallLoadingListblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
