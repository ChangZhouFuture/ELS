package presentation.managerAndAccountantui.Approdocmui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.DateChooser;
import presentation.reuse.Images;
import presentation.userui.Accountantui1;
import presentation.userui.GeneralManagerui;

public class DocmListui extends JPanel{
	public JComboBox sheetType;
	public JLabel sheetLabel;
	public JLabel findByDate;
	public JTextField dateField;
	public DateChooser dateChooser;
	public JButton dateFind;
	public JButton sheetTypeFind;
	public JButton approDocm;
	public JTable orderTable;
	public DefaultTableModel orderTableModel;
	public JScrollPane scrollPane;
	
	public static void main(String[] args){
		GeneralManagerui ui=new GeneralManagerui();
		DocmListui uiPanel=new DocmListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public DocmListui(){
		String[] sheetTypeEntries={"订单","营业厅到达单","营业厅装车单","派件单",
				"中转中心到达单","中转中心装车单","中转单","收款单","付款单","入库单","出库单"};
		sheetType=new JComboBox(sheetTypeEntries);
		sheetLabel=new JLabel();
		findByDate=new JLabel();
		dateFind=new JButton();
		sheetTypeFind=new JButton();
		approDocm=new JButton();
		dateField=new JTextField();
		
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("审批单据");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		sheetType.setBackground(Color.WHITE);
		sheetType.setFont(font2);
		sheetType.setBounds(30,45,160,24);
		
		findByDate.setBounds(30,75,90,24);
		findByDate.setText("日期:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		findByDate.setOpaque(true);
		
		dateField.setBounds(120,77,120,20);
		
		dateFind.setBounds(330,75,50,24);
		dateFind.setText("查找");
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setFont(font2);
		dateFind.setBackground(Color.WHITE);
		
		this.add(sheetLabel);
		this.add(findByDate);
		this.add(dateFind);
		this.add(dateField);
		this.add(sheetType);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
