package presentation.userManagementui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import presentation.reuse.Images;
import presentation.userui.Administratorui;
import vo.lineitemVO.userlineitemVO.UserlineitemVO;

public class UserListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton positionFind;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByPosition;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public JComboBox position;
	public UserlineitemVO oneLine;
	public UserManagementblservice userManagementblservice;
	public DefaultTableModel tableModel;
	JavaBean1 javaBean1;
	String positionbl="快递员";
	
	public UserListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
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
		sheetLabel.setText("用户管理");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加人员");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByPosition.setBounds(30,125,120,24);
		findByPosition.setText("按职位查找:");
		findByPosition.setFont(font2);
		findByPosition.setBackground(Color.WHITE);
		
		idField.setBounds(150,92,120,20);
		
		position.setBackground(Color.WHITE);
		position.setFont(font2);
		position.setBounds(150,125,160,24);
		position.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					String positionString=null;
					positionString=(String)position.getSelectedItem();
					switch(positionString){
					case"快递员":
						positionbl="Courier";
						break;
					case"营业厅业务员":
						positionbl="BusiHallClerk";
						break;
					case"中转中心业务员":
						positionbl="TranCenClerk";
						break;
					case"库存管理人员":
						positionbl="StockManager";
						break;
					case"财务人员":
						positionbl="Accountant2";
						break;
					case"财务人员(高)":
						positionbl="Accountant1";
						break;
					case"总经理":
						positionbl="GeneralManager";
						break;
					case"管理员":
						positionbl="Administrator";
						break;
						default:
							break;
					}
				} 
			}     
		});
		
		idFind.setBounds(380,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		positionFind.setBounds(380,125,64,24);
		positionFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		positionFind.setBackground(Color.WHITE);
		positionFind.setText("查找");
		positionFind.setFont(font2);
		positionFind.setOpaque(true);
		positionFind.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				userManagementblservice=new UserManagement();
				javaBean1=userManagementblservice.inquireB(positionbl);
				ArrayList<UserlineitemVO> arrayList=(ArrayList<UserlineitemVO>)javaBean1.getObject();
				makeTable(arrayList);
			}
		});
		
		scrollPane = new JScrollPane(table); 
		
		delete=new JButton();
		delete.setBounds(30,420,50,24);
		delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		delete.setBackground(Color.WHITE);
		delete.setText("删除");
		delete.setFont(font2);
		 
		this.add(scrollPane);
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(idField);
		this.add(idFind);
		this.add(findByPosition);
		this.add(position);
		this.add(positionFind);
		this.add(delete);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<UserlineitemVO> arrayList){
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
			 String[] oneRow={"",oneLine.getId(),oneLine.getName(),oneLine.getGender().toString(),
			    	oneLine.getPhone(),oneLine.getCity(),oneLine.getRegion(),
			    	oneLine.getPosition().toString()};
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
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   userManagementblservice=new UserManagement();
				   userManagementblservice.deleteMany(idList);
				  }});
	}
}
