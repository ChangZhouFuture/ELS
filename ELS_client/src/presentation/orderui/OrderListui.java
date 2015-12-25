package presentation.orderui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.reuse.Listui;
import presentation.userui.Courierui;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;

public class OrderListui extends Listui{
	public Orderblservice orderblservice;
	public OrderlineitemVO oneLine;
	public JavaBean1 javaBean1;
	
	public static void main(String[] args){
		
		Courierui ui=new Courierui();
		OrderListui uiPanel=new OrderListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OrderListui(){
		String[] columnNames = {"ѡ��","ID","�ļ���ַ","�ռ���ַ","�������","�ܷ���","ʱ��"}; //����
		String [][]tableVales={}; //����
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
		
		sheetLabel.setText("������Ϣ����");
		
		dateFind.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String date=null;
				date=showDate.getText();
				System.out.println(date);
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
	}
	public void makeTable(ArrayList<OrderlineitemVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
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
		 String[] Row1={" ","12345678","����","����","����","δ����","20","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
			     oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getSenderAdd(),oneLine.getAddresseeAdd(),
			    		 oneLine.getExpressType().toString(),String.valueOf(oneLine.getTotalCost()),oneLine.getGenerateDate()};
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
				   orderblservice=new Order();
				   orderblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
