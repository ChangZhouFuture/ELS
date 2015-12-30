package presentation.inforManagementui.Staffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import presentation.reuse.Images;

public class WageStrategyListui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public JButton modify;
	public JButton makeModify;
	public DefaultTableCellRenderer r;
	
	public WageStrategyListui(){
		sheetLabel=new JLabel();
		modify=new JButton();
		makeModify=new JButton();
		String[] columnNames = {"职位","付薪方式","基本工资","提成百分比"}; //列名
		r=new DefaultTableCellRenderer();
		table=new JTable(9,4){
			public boolean isCellEditable(int row, int column){
				 return false;
		 }
		};
		
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		
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
		
		modify.setBounds(30,50,70,24);
		modify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modify.setBackground(Color.WHITE);
		modify.setText("修改");
		modify.setFont(font2);
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		table.setSize(550,216);
		table.setLocation(30,100);
		table.setRowHeight(24);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(true);
		table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		table.setValueAt("职位",0,0);
		table.setValueAt("快递员",1,0);
		table.setValueAt("营业厅业务员",2,0);
		table.setValueAt("中转中心业务员",3,0);
		table.setValueAt("库存管理人员",4,0);
		table.setValueAt("财务人员",5,0);
		table.setValueAt("高级财务人员",6,0);
		table.setValueAt("总经理",7,0);
		table.setValueAt("管理员",8,0);
		table.setValueAt("付薪方式",0,1);
		table.setValueAt("底薪",0,2);
		table.setValueAt("提成百分比",0,3);
		
		makeModify.setBounds(30,420,100,24);
		makeModify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		makeModify.setBackground(Color.WHITE);
		makeModify.setText("确认修改");
		makeModify.setFont(font2);
		
		this.add(sheetLabel);
		this.add(modify);
		this.add(makeModify);
		this.add(table);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
