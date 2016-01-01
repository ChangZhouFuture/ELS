package presentation.stockui.stockui;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean3;
import businesslogic.stockbl.Stock;
import businesslogicservice.stockblservice.Stockblservice;
import presentation.reuse.Images;
import vo.lineitemVO.stocklineitemVO.StocklineitemVO;

public class StockCountui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public DefaultTableModel tableModel;
	public JButton adjust;
	public JComboBox areaType;
	String areaTypeValue="机动区";
	JScrollPane scrollPane;
	JavaBean3 javaBean3;
	Stockblservice stockblservice;
	StocklineitemVO stocklineitemVO;
	public StockCountui(){
		sheetLabel=new JLabel();
		adjust=new JButton();
		String[] areaTypeEntries={"机动区","汽运区","铁运区","航运区"};
		areaType=new JComboBox(areaTypeEntries);
		String[] columnNames = {"选择","ID","目的地","区号","排号","架号","位号","入库日期"}; //列名
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
		sheetLabel.setText("库存盘点");
		sheetLabel.setIcon(Images.SHEET_IMAGE);

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
		stockblservice=new Stock();
		javaBean3=stockblservice.stockCount();
		ArrayList<StocklineitemVO> arrayList=(ArrayList<StocklineitemVO>)javaBean3.getObject();
		for(int i=arrayList.size()-1;i>=0;i--){
			stocklineitemVO=arrayList.get(i);
			String[] oneRow={"",stocklineitemVO.getId(),stocklineitemVO.getDestination(),
					stocklineitemVO.getAreaNum(),stocklineitemVO.getRowNum(),
					stocklineitemVO.getFrameNum(),stocklineitemVO.getPositionNum(),
					stocklineitemVO.getInDate()};
			tableModel.addRow(oneRow);
		}
		table.setRowHeight(24);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(true);
		table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scrollPane = new JScrollPane(table); //支持滚动
		scrollPane.setSize(550,361);
		scrollPane.setLocation(30,50);
		scrollPane.setViewportView(table);
		
		areaType.setBounds(30,430,100,24);
		areaType.setBackground(Color.WHITE);
		areaType.setFont(font2);
		areaType.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					areaTypeValue=(String)areaType.getSelectedItem();
				}
			}
		});
		
		adjust.setBounds(150,430,50,24);
		adjust.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		adjust.setBackground(Color.WHITE);
		adjust.setText("调整");
		adjust.setFont(font2);
		adjust.addActionListener(new ActionListener(){//添加事件
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(table.getSelectedRow()>=0){
				       idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   }
				   stockblservice.adjustPartition(idList,areaTypeValue);
				  }});
		
		this.add(sheetLabel);
		this.add(scrollPane);
		this.add(adjust);
		this.add(areaType);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
