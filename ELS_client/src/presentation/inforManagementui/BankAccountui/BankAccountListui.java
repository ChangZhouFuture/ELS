package presentation.inforManagementui.BankAccountui;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import presentation.reuse.Images;
import vo.inforManagementVO.BankAccountVO;
import bean.JavaBean1;
import businesslogic.inforManagementbl.BankAccountInfor;
import businesslogicservice.inforManagementblservice.BankAccountInforblservice;

public class BankAccountListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton nameFind;
	public JTextField nameField;
	public JLabel findByName;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public DefaultTableModel tableModel;
	BankAccountInforblservice bankAccountInforblservice;
	BankAccountVO oneLine;
	
	public BankAccountListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findByName=new JLabel();
		nameField=new JTextField();
		nameFind=new JButton();
		String[] columnNames = {"选择","名称","金额"}; //列名
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
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		sheetLabel.setText("银行账户管理");
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加账户");
		addText.setFont(font3);
		

		findByName.setBounds(30,95,120,24);
		findByName.setText("按关键字查找:");
		findByName.setFont(font2);
		findByName.setBackground(Color.WHITE);
		
		nameField.setBounds(150,97,120,20);
		
		nameFind.setBounds(300,95,64,24);
		nameFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		nameFind.setBackground(Color.WHITE);
		nameFind.setText("查找");
		nameFind.setFont(font2);
		nameFind.setOpaque(true);
		nameFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameString="";
				if(nameField.getText()!=null){
					nameString=nameField.getText();
					JavaBean1 javaBean1;
					bankAccountInforblservice=new BankAccountInfor();
					try {
						javaBean1=bankAccountInforblservice.inquire(nameString);
						ArrayList<BankAccountVO> arrayList = (ArrayList<BankAccountVO>)javaBean1.getObject();
						makeTable(arrayList);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				else{
					System.out.println("Error");
				}
			}
		});
		scrollPane=new JScrollPane(table);
		delete=new JButton();
		delete.setBounds(30,420,50,24);
		delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		delete.setBackground(Color.WHITE);
		delete.setText("删除");
		delete.setFont(font2);
		this.add(scrollPane);
		this.add(delete);
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findByName);
		this.add(nameField);
		this.add(nameFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<BankAccountVO> arrayList){
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
			 String[] oneRow={"",oneLine.getName(),String.valueOf(oneLine.getAmount())};
			 tableModel.addRow(oneRow);
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,110);
		 scrollPane.setViewportView(table);
		 delete.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(table.getSelectedRow()>=0){
				       idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				       tableModel.removeRow(table.getSelectedRow());  //删除行 
				   }
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   bankAccountInforblservice=new BankAccountInfor();
				   bankAccountInforblservice.deleteMany(idList);
				  }});
	}
}
