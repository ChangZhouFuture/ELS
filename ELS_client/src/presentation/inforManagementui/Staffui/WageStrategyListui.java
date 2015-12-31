package presentation.inforManagementui.Staffui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import presentation.reuse.Images;

public class WageStrategyListui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public DefaultTableModel tableModel;
	public JTable modifyTable;
	public JButton modify;
	public JButton makeModify;
	public DefaultTableCellRenderer r;
	TableColumn tableColumn;
	JComboBox cbx;
	TableColumn modifyTableColumn;
	TableCellEditor tce;
	JScrollPane scrollPane;
	JScrollPane modifyScrollPane;
	
	public WageStrategyListui(){
		sheetLabel=new JLabel();
		modify=new JButton();
		makeModify=new JButton();
		cbx= new JComboBox();  
		cbx.addItem("按月");  
		cbx.addItem("按次");
		String[] columnNames = {"职位","付薪方式","基本工资","提成百分比"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		r=new DefaultTableCellRenderer();
		table=new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				 return false;
		    }
		};
		
		String[] line1={"快递员","","",""};
		tableModel.addRow(line1);
		String[] line2={"营业厅业务员","","",""};
		tableModel.addRow(line2);
		String[] line3={"中转中心业务员","","",""};
		tableModel.addRow(line3);
		String[] line4={"库存管理人员","","",""};
		tableModel.addRow(line4);
		String[] line5={"财务人员","","",""};
		tableModel.addRow(line5);
		String[] line6={"高级财务人员","","",""};
		tableModel.addRow(line6);
		String[] line7={"总经理","","",""};
		tableModel.addRow(line7);
		String[] line8={"管理员","","",""};
		tableModel.addRow(line8);
		
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		
		tableColumn = table.getColumn("付薪方式");
		tableColumn.setCellEditor(new DefaultCellEditor(cbx));
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setText("工资策略管理");
		
		table.setRowHeight(24);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(true);
		table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scrollPane = new JScrollPane(table);
		scrollPane.setSize(550,217);
		scrollPane.setLocation(30,100);
		scrollPane.setViewportView(table);
		
		modifyTable=new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				if(column==0){
				 return false;
				}else return true;
		    }
		};
		
		modifyTableColumn = modifyTable.getColumn("付薪方式");
		modifyTableColumn.setCellEditor(new DefaultCellEditor(cbx));
		cbx.setVisible(true);
		modifyTable.setDefaultRenderer(Object.class,r);
		modifyTable.setRowHeight(24);
		modifyTable.setBackground(Color.WHITE);
		modifyTable.setShowVerticalLines(true);
		modifyTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modifyScrollPane = new JScrollPane(modifyTable);
		modifyScrollPane.setSize(550,217);
		modifyScrollPane.setLocation(30,100);
		modifyScrollPane.setViewportView(modifyTable);
		
		modify.setBounds(30,50,70,24);
		modify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modify.setBackground(Color.WHITE);
		modify.setText("修改");
		modify.setFont(font2);
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(scrollPane);
				makeModify.setVisible(true);
				add(modifyScrollPane);
				repaint();
			}
		});
		
		makeModify.setBounds(30,420,100,24);
		makeModify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		makeModify.setBackground(Color.WHITE);
		makeModify.setText("确认修改");
		makeModify.setFont(font2);
		makeModify.setVisible(false);
		makeModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.add(sheetLabel);
		this.add(modify);
		this.add(makeModify);
		this.add(scrollPane);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
