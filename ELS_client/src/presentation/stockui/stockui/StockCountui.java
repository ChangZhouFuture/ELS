package presentation.stockui.stockui;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import bean.JavaBean3;
import businesslogic.inforManagementbl.DriversInfor;
import businesslogic.stockbl.Stock;
import businesslogicservice.stockblservice.Stockblservice;
import presentation.reuse.Images;
import vo.lineitemVO.stocklineitemVO.StocklineitemVO;

public class StockCountui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public DefaultTableModel tableModel;
	public JButton adjust;
	JScrollPane scrollPane;
	JavaBean3 javaBean3;
	Stockblservice stockblservice;
	StocklineitemVO stocklineitemVO;
	public StockCountui(){
		sheetLabel=new JLabel();
		adjust=new JButton();
		String[] columnNames = {"ѡ��","ID","Ŀ�ĵ�","����","�ź�","�ܺ�","λ��","�������"}; //����
		String [][]tableVales={}; //����
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
		sheetLabel.setText("����̵�");
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
		scrollPane = new JScrollPane(table); //֧�ֹ���
		scrollPane.setSize(550,361);
		scrollPane.setLocation(30,50);
		scrollPane.setViewportView(table);
		
		adjust.setBounds(150,430,50,24);
		adjust.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		adjust.setBackground(Color.WHITE);
		adjust.setText("����");
		adjust.setFont(font2);
		adjust.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   for(int i=0;i<table.getRowCount();i++){
				       int selectedRow = table.getSelectedRow();//���ѡ���е�����
				       if(selectedRow!=-1){
				    	   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				           tableModel.removeRow(selectedRow);  //ɾ���� 
				       }
				   }
//				   stockblservice.adjustPartition(idList,area);
				  }});
		
		this.add(sheetLabel);
		this.add(scrollPane);
		this.add(adjust);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
