package presentation.inforManagementui.Driversui;

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

import bean.JavaBean1;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.inforManagementbl.DriversInfor;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import presentation.documentsui.DeliveryOrderui.DeliveryOrderListui;
import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public class DriversListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton busiHallIDFind;
	public JTextField idField;
	public JTextField busiHallIDField;
	public JLabel findById;
	public JLabel findBybusiHallID;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public DefaultTableModel tableModel;
	DriversInforblservice driversInforblservice;
	DriverslineitemVO oneLine;
	
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		DriversListui uiPanel=new DriversListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public DriversListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JLabel();
		findBybusiHallID=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		busiHallIDFind=new JButton();
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		String[] columnNames = {"选择","ID","姓名","电话","性别","行驶证期限"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		table = new JTable(tableModel){  
			public boolean isCellEditable(int row, int column){
					return false;
			}
		 };
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setText("司机信息管理");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加单据");
		addText.setFont(font3);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findBybusiHallID.setBounds(30,125,200,24);
		findBybusiHallID.setText("查找本营业厅司机:");
		findBybusiHallID.setFont(font2);
		findBybusiHallID.setBackground(Color.WHITE);
		
		idField.setBounds(150,92,120,20);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		
		busiHallIDFind.setBounds(360,125,64,24);
		busiHallIDFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		busiHallIDFind.setBackground(Color.WHITE);
		busiHallIDFind.setText("查找");
		busiHallIDFind.setFont(font2);
		busiHallIDFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JavaBean1 javaBean1;
				driversInforblservice=new DriversInfor();
				try {
					javaBean1=driversInforblservice.inquireB(Loginui.agency);
					ArrayList<DriverslineitemVO> arrayList=(ArrayList<DriverslineitemVO>)javaBean1.getObject();
					makeTable(arrayList);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		
		delete=new JButton();
		delete.setBounds(30,420,50,24);
		delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		delete.setBackground(Color.WHITE);
		delete.setText("删除");
		delete.setFont(font2);
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findBybusiHallID);
		this.add(idField);
		this.add(idFind);
		this.add(busiHallIDFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<DriverslineitemVO> arrayList){
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
		 String[] Row1={" ","12345678","张三","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getID(),oneLine.getName(),oneLine.getPhone(),
					     oneLine.getGender().toString(),oneLine.getDriveLimitDate()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
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
		 delete.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				       int selectedRow = table.getSelectedRow();//获得选中行的索引
				       if(selectedRow!=-1){
				    	   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				           tableModel.removeRow(selectedRow);  //删除行 
				       }
				   }
				   driversInforblservice=new DriversInfor();
				   driversInforblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
