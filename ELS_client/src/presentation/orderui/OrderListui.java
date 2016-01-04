package presentation.orderui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.Listui;
import presentation.userui.Courierui;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class OrderListui extends Listui{
	public Orderblservice orderblservice;
	public OrderlineitemVO oneLine;
	public JavaBean1 javaBean1;
	
	public OrderListui(){
		String[] columnNames = {"选择","ID","寄件地址","收件地址","快递类型","总费用","时间"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){
			 public boolean isCellEditable(int row, int column){
					 return false;
			 }
		 };
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setText("订单信息管理");
		
		dateFind.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String date="";
				date=showDate.getText();
				orderblservice=new Order();
				try {
					javaBean1=orderblservice.inquireB(date);
					ArrayList<OrderlineitemVO> arrayList = 
							(ArrayList<OrderlineitemVO>)javaBean1.getObject();
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
	public void makeTable(ArrayList<OrderlineitemVO> arrayList){
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
			 String[] oneRow={"",oneLine.getId(),oneLine.getSenderAdd(),oneLine.getAddresseeAdd(),
			    	 oneLine.getExpressType().toString(),String.valueOf(oneLine.getTotalCost()),oneLine.getGenerateDate()};
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
				   orderblservice=new Order();
				   orderblservice.deleteMany(idList);
				  }});
	}
}
