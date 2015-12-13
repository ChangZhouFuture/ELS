package presentation.inforManagementui.Vehiclesui;

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
import businesslogic.inforManagementbl.DriversInfor;
import businesslogic.inforManagementbl.VehiclesInfor;
import businesslogicservice.inforManagementblservice.VehiclesInforblservice;
import presentation.inforManagementui.Driversui.DriversListui;
import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;
import vo.inforManagementVO.VehiclesVO;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public class VehiclesListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JLabel city;
	public JLabel region;
	public JButton add;
	public JButton idFind;
	public JButton cityFind;
	public JTextField idField;
	public JTextField cityField;
	public JTextField regionField;
	public JRadioButton findById;
	public JRadioButton findByCity;
	public ButtonGroup findGroup;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public VehiclesInforblservice vehiclesInforblservice;
	public VehiclesVO oneLine;
	
	public static void main(String[] args){
		
		BusiHallClerkui ui=new BusiHallClerkui();
		VehiclesListui uiPanel=new VehiclesListui();
		uiPanel.makeTable(null);
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public VehiclesListui(){
		sheetLabel=new JLabel();
		city=new JLabel();
		region=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JRadioButton();
		findByCity=new JRadioButton();
		findGroup=new ButtonGroup();
		idField=new JTextField();
		cityField=new JTextField();
		regionField=new JTextField();
		idFind=new JButton();
		cityFind=new JButton();
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("车辆信息管理");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加单据");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByCity.setBounds(30,125,120,24);
		findByCity.setText("按地区查找:");
		findByCity.setFont(font2);
		findByCity.setBackground(Color.WHITE);
		
		findGroup.add(findById);
		findGroup.add(findByCity);
		
		idField.setBounds(150,92,120,20);
		
		cityField.setBounds(150,127,100,20);
		
		city.setBounds(255,125,24,24);
		city.setBackground(Color.WHITE);
		city.setText("市");
		city.setFont(font2);
		city.setOpaque(true);
		
		regionField.setBounds(285,127,48,20);
		
		region.setBounds(340,125,24,24);
		region.setBackground(Color.WHITE);
		region.setText("区");
		region.setFont(font2);
		region.setOpaque(true);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		cityFind.setBounds(380,125,64,24);
		cityFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		cityFind.setBackground(Color.WHITE);
		cityFind.setText("查找");
		cityFind.setFont(font2);
		cityFind.setOpaque(true);
		cityFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cityString=null;
				String regionString=null;
				if(cityField.getText()!=null&&regionField.getText()!=null){
					cityString=cityField.getText();
					regionString=regionField.getText();
					JavaBean1 javaBean1;
					vehiclesInforblservice=new VehiclesInfor();
					try {
//						javaBean1=vehiclesInforblservice.inquireB(cityString,regionString);
//						ArrayList<VehiclesVO> arrayList=(ArrayList<VehiclesVO>)javaBean1.getObject();
//						makeTable(arrayList);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				else{
					System.out.println("Error");
				}
			}
		});
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByCity);
		this.add(idField);
		this.add(idFind);
		this.add(cityField);
		this.add(city);
		this.add(region);
		this.add(regionField);
		this.add(cityFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<VehiclesVO> arrayList){
		try{
			 this.remove(scrollPane);
			 this.remove(delete);
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 DefaultTableModel tableModel;
		 String[] columnNames = {"选择","ID","市","区","车牌号","服役时间"}; //列名
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
//		 String[] Row1={" ","12345678","张三","2015-12-5","12345678","2015-12-5"};
		 try{
		     for(int i=0;i<arrayList.size();i++){
		    	 oneLine=arrayList.get(i);
//			     String[] oneRow={"",oneLine.getID(),oneLine.getCity(),oneLine.getRegion(),
//					     oneLine.getPlateNum(),oneLine.getServiceTime()};
//			     tableModel.addRow(oneRow);
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
				   vehiclesInforblservice=new VehiclesInfor();
				   vehiclesInforblservice.deleteMany(idList);
				  }});
		 this.add(delete);
	}
}
