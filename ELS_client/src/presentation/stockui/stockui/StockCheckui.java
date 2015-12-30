package presentation.stockui.stockui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.StockManagerui;

public class StockCheckui extends JPanel{
	public JLabel sheetLabel;
	public JLabel startDate;
	public JLabel endDate;
	public JButton find;
	public JTextField startDateField;
	public JTextField endDateField;
	public DateChooser startDateChooser;
	public DateChooser endDateChooser;
	public JTable table;
	public DefaultTableCellRenderer r;
	
	public static void main(String[] args){
		
		StockManagerui ui=new StockManagerui();
		StockCheckui uiPanel=new StockCheckui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public StockCheckui(){
		sheetLabel=new JLabel();
		startDate=new JLabel();
		endDate=new JLabel();
		find=new JButton();
		startDateField=new JTextField("单击选择日期");
		endDateField=new JTextField("单击选择日期");
		startDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		endDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		r=new DefaultTableCellRenderer();
		table=new JTable(6,5){
			public boolean isCellEditable(int row, int column){
				 return false;
		 }
		};
		
		this.setLayout(null);
		
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("库存查看");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		
		startDate.setBounds(30,75,100,24);
		startDate.setText("开始日期:");
		startDate.setFont(font2);
		startDate.setBackground(Color.WHITE);
		
		startDateField.setBounds(120,77,120,20);
		startDateChooser.register(startDateField);
		
		endDate.setBounds(30,105,100,24);
		endDate.setText("结束日期:");
		endDate.setFont(font2);
		endDate.setBackground(Color.WHITE);
		endDate.setOpaque(true);
		
		endDateField.setBounds(120,107,120,20);
		endDateChooser.register(endDateField);
		
		find.setBounds(330,105,50,24);
		find.setText("查找");
		find.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		find.setFont(font2);
		find.setBackground(Color.WHITE);
		find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		table.setSize(550,144);
		table.setLocation(30,160);
		table.setRowHeight(24);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(true);
		table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		table.setValueAt("分区",0,0);
		table.setValueAt("机动区",1,0);
		table.setValueAt("汽运区",2,0);
		table.setValueAt("铁运区",3,0);
		table.setValueAt("航运区",4,0);
		table.setValueAt("总计",5,0);
		table.setValueAt("入库数量",0,1);
		table.setValueAt("出库数量",0,2);
		table.setValueAt("入库金额",0,3);
		table.setValueAt("出库金额",0,4);
		
		this.add(sheetLabel);
		this.add(startDate);
		this.add(endDate);
		this.add(find);
		this.add(startDateField);
		this.add(endDateField);
		this.add(table);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
