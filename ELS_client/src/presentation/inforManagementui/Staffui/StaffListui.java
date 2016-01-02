package presentation.inforManagementui.Staffui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.inforManagementbl.StaffInfor;
import businesslogicservice.inforManagementblservice.StaffInforblservice;
import presentation.reuse.Images;
import vo.lineitemVO.userlineitemVO.UserlineitemVO;

public class StaffListui extends JPanel{
	public JLabel sheetLabel;
	public JButton idFind;
	public JButton positionFind;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByPosition;
	public JTable table;
	public JScrollPane scrollPane;
	public JComboBox position;
	public UserlineitemVO oneLine;
	public StaffInforblservice staffInforblservice;
	public DefaultTableModel tableModel;
	JavaBean1 javaBean1;
	state.Position positionSeletion=state.Position.Courier;
	
	public StaffListui(){
		sheetLabel=new JLabel();
		findById=new JLabel();
		findByPosition=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		positionFind=new JButton();
		String[] positionEntries={"快递员","营业厅业务员","中转中心业务员","库存管理人员","财务人员","财务人员(高)","总经理","管理员"};
		position=new JComboBox(positionEntries);
		String[] columnNames = {"选择","ID","姓名","性别","电话","市","区","职位"}; //列名
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
			
			sheetLabel.setBounds(0,0,616,30);
			sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			sheetLabel.setBackground(Color.WHITE);
			sheetLabel.setText("人员管理");
			sheetLabel.setFont(font1);
			sheetLabel.setIcon(Images.SHEET_IMAGE);
			sheetLabel.setOpaque(true);
			
			findById.setBounds(30,60,120,24);
			findById.setText("按ID查找:");
			findById.setFont(font2);
			findById.setBackground(Color.WHITE);
			
			findByPosition.setBounds(30,95,120,24);
			findByPosition.setText("按职位查找:");
			findByPosition.setFont(font2);
			findByPosition.setBackground(Color.WHITE);
			
			idField.setBounds(150,62,120,20);
			
			position.setBackground(Color.WHITE);
			position.setFont(font2);
			position.setBounds(150,95,160,24);
			position.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent evt) {
					if(evt.getStateChange() == ItemEvent.SELECTED){
						String positionString="";
						positionString=(String)position.getSelectedItem();
						switch(positionString){
						case"快递员":
							positionSeletion=state.Position.Courier;
							break;
						case"营业厅业务员":
							positionSeletion=state.Position.BusiHallClerk;
							break;
						case"中转中心业务员":
							positionSeletion=state.Position.TranCenClerk;
							break;
						case"库存管理人员":
							positionSeletion=state.Position.StockManager;
							break;
						case"财务人员":
							positionSeletion=state.Position.Accountant2;
							break;
						case"财务人员(高)":
							positionSeletion=state.Position.Accountant1;
							break;
						case"总经理":
							positionSeletion=state.Position.GeneralManager;
							break;
						case"管理员":
							positionSeletion=state.Position.Administrator;
							break;
							default:
								break;
						}
					} 
				}     
			});
			
			idFind.setBounds(380,60,64,24);
			idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			idFind.setBackground(Color.WHITE);
			idFind.setText("查找");
			idFind.setFont(font2);
			idFind.setOpaque(true);
			
			positionFind.setBounds(380,95,64,24);
			positionFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			positionFind.setBackground(Color.WHITE);
			positionFind.setText("查找");
			positionFind.setFont(font2);
			positionFind.setOpaque(true);
			positionFind.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					staffInforblservice=new StaffInfor();
					javaBean1=staffInforblservice.inquireB(positionSeletion);
					ArrayList<UserlineitemVO> arrayList=(ArrayList<UserlineitemVO>)javaBean1.getObject();
					makeTable(arrayList);
				}
			});
			scrollPane=new JScrollPane(table);
			this.add(scrollPane);
			
			this.add(sheetLabel);
			this.add(findById);
			this.add(idField);
			this.add(idFind);
			this.add(findByPosition);
			this.add(position);
			this.add(positionFind);
			
			setLocation(184,30);
			this.setSize(616,496);
			this.setBackground(Color.WHITE);
			this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
			this.setOpaque(true);
	}
	public void makeTable(ArrayList<UserlineitemVO> arrayList){
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
		 try{
		     for(int i=arrayList.size()-1;i>=0;i--){
		    	oneLine=arrayList.get(i);
			     String[] oneRow={"",oneLine.getId(),oneLine.getName(),oneLine.getGender().toString(),
			    		 oneLine.getPhone(),oneLine.getCity(),oneLine.getRegion(),
			    		 oneLine.getPosition().toString()};
			     tableModel.addRow(oneRow);
		     }
		 }catch(Exception e2){
			 e2.printStackTrace(); 
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
	}
}
