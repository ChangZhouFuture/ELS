package presentation.inforManagementui.agencyui;

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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean1;
import businesslogic.inforManagementbl.AgencyInfor;
import businesslogicservice.inforManagementblservice.AgencyInforblservice;
import presentation.reuse.Images;
import presentation.userui.GeneralManagerui;
import state.AgencyType;
import vo.inforManagementVO.AgencyVO;

public class AgencyListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton typeFind;
	public JButton delete;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByType;
	public JTable table;
	public DefaultTableModel tableModel;
	public JComboBox agencyType;
	public JScrollPane scrollPane;
	String agencyTypeValue="营业厅";
	AgencyType agencyTypeSeletion=AgencyType.BusinessHall;
	JavaBean1 javaBean1;
	AgencyInforblservice agencyInforblservice;
	AgencyVO oneLine;
	
	public AgencyListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JLabel();
		findByType=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		typeFind=new JButton();
		String[] agencyTypeEntries={"营业厅","中转中心"};
		agencyType=new JComboBox(agencyTypeEntries);
		
		String[] columnNames = {"选择","ID","所在城市","所在区域","机构类型"}; //列名
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
		sheetLabel.setFont(font1);
		sheetLabel.setText("机构管理");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		agencyType.setBackground(Color.WHITE);
		agencyType.setFont(font2);
		agencyType.setBounds(150,115,120,24);
		agencyType.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					agencyTypeValue=(String)agencyType.getSelectedItem();
					switch(agencyTypeValue){
					case"营业厅":
						agencyTypeSeletion=AgencyType.BusinessHall;
						break;
					case"中转中心":
						agencyTypeSeletion=AgencyType.TransferCenter;
						break;
						default:
							break;
					}
				} 
			}     
		});
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加机构");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,85,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByType.setBounds(30,115,120,24);
		findByType.setText("按类型查找:");
		findByType.setFont(font2);
		findByType.setBackground(Color.WHITE);
		
		idField.setBounds(150,87,120,20);
		
		idFind.setBounds(380,85,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		typeFind.setBounds(380,115,64,24);
		typeFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		typeFind.setBackground(Color.WHITE);
		typeFind.setText("查找");
		typeFind.setFont(font2);
		typeFind.setOpaque(true);
		typeFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agencyInforblservice=new AgencyInfor();
				javaBean1=agencyInforblservice.inquireB(agencyTypeSeletion);
				ArrayList<AgencyVO>  arrayList=(ArrayList<AgencyVO>)javaBean1.getObject();
				makeTable(arrayList);
			}
		});
		
		scrollPane=new JScrollPane(table);
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
		this.add(findByType);
		this.add(idField);
		this.add(idFind);
		this.add(typeFind);
		this.add(agencyType);
		this.add(scrollPane);
		this.add(delete);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<AgencyVO>  arrayList){
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
			 String agency="";
			 switch(oneLine.getAgencyType()){
			 case BusinessHall:agency="营业厅";break;
			 case TransferCenter:agency="中转中心";break;
			 }
			 String[] oneRow={"",oneLine.getID(),oneLine.getCity(),oneLine.getRegion(),agency};
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
				   agencyInforblservice=new AgencyInfor();
				   agencyInforblservice.deleteMany(idList);
				  }});
	}
}
