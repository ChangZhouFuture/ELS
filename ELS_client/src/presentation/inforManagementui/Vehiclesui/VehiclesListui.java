package presentation.inforManagementui.Vehiclesui;

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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.inforManagementbl.VehiclesInfor;
import businesslogicservice.inforManagementblservice.VehiclesInforblservice;
import presentation.reuse.Images;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import vo.inforManagementVO.VehiclesVO;

public class VehiclesListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton BusiHallFind;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByBusiHall;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel tableModel;
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
		add=new JButton();
		addText=new JLabel();
		findById=new JLabel();
		findByBusiHall=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		BusiHallFind=new JButton();
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		String[] columnNames = {"选择","ID","营业厅编号","车牌号","服役时间"}; //列名
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
		sheetLabel.setFont(font1);
		sheetLabel.setText("车辆信息管理");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加车辆");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByBusiHall.setBounds(30,125,160,24);
		findByBusiHall.setText("查找本营业厅车辆:");
		findByBusiHall.setFont(font2);
		findByBusiHall.setBackground(Color.WHITE);
		
		idField.setBounds(150,92,120,20);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		BusiHallFind.setBounds(360,125,64,24);
		BusiHallFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		BusiHallFind.setBackground(Color.WHITE);
		BusiHallFind.setText("查找");
		BusiHallFind.setFont(font2);
		BusiHallFind.setOpaque(true);
		BusiHallFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JavaBean1 javaBean1;
				vehiclesInforblservice=new VehiclesInfor();
				try {
					javaBean1=vehiclesInforblservice.inquireB(Loginui.agency);
					ArrayList<VehiclesVO> arrayList=(ArrayList<VehiclesVO>)javaBean1.getObject();
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
		
		scrollPane=new JScrollPane(table);
		 
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByBusiHall);
		this.add(idField);
		this.add(idFind);
		this.add(BusiHallFind);
		this.add(scrollPane);
		this.add(delete);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<VehiclesVO> arrayList){
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
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 for(int i=arrayList.size()-1;i>=0;i--){
		     oneLine=arrayList.get(i);
			 String[] oneRow={"",oneLine.getID(),oneLine.getBusiHallID(),
					 oneLine.getPlateNum(),oneLine.getServiceTime()};
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
				   vehiclesInforblservice=new VehiclesInfor();
				   vehiclesInforblservice.deleteMany(idList);
				  }});
	}
}
