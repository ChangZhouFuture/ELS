package presentation.managerAndAccountantui.StatisAnalyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import presentation.reuse.Images;
import presentation.userui.Accountantui1;

public class StatisAnalyListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel startDate;
	public JLabel endDate;
	public JLabel startYear;
	public JLabel startMonth;
	public JLabel startDay;
	public JLabel endYear;
	public JLabel endMonth;
	public JLabel endDay;
	public JButton find;
	public JTextField startYearField;
	public JTextField startMonthField;
	public JTextField startDayField;
	public JTextField endYearField;
	public JTextField endMonthField;
	public JTextField endDayField;
	public JComboBox sheetType;
	public JScrollPane scrollPane;
	String sheetTypebl=null;
	
	public static void main(String[] args){
		
		Accountantui1 ui=new Accountantui1();
		StatisAnalyListui uiPanel=new StatisAnalyListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public StatisAnalyListui(){
		sheetLabel=new JLabel();
		startDate=new JLabel();
		endDate=new JLabel();
		startYear=new JLabel();
		startMonth=new JLabel();
		startDay=new JLabel();
		endYear=new JLabel();
		endMonth=new JLabel();
		endDay=new JLabel();
		find=new JButton();
		startYearField=new JTextField();
		startMonthField=new JTextField();
		startDayField=new JTextField();
		endYearField=new JTextField();
		endMonthField=new JTextField();
		endDayField=new JTextField();
		String[] sheetTypeEntries={"收款单","付款单","成本收益表"};
		sheetType=new JComboBox(sheetTypeEntries);
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("统计报表");
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		sheetType.setBackground(Color.WHITE);
		sheetType.setFont(font2);
		sheetType.setBounds(30,45,120,24);
		sheetType.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					String sheetTypeString=null;
					sheetTypeString=(String)sheetType.getSelectedItem();
					
					switch(sheetTypeString){
					case"收款单":
						sheetTypebl="ReceivablesOrder";
						break;
					case"付款单":
						sheetTypebl="PaymentOrder";
						break;
					case"成本收益表":
						sheetTypebl="CostanIncomeVo";
						break;
						default:
							break;
					}
				} 
			}     
		});
		
		startDate.setBounds(30,75,100,24);
		startDate.setText("开始日期:");
		startDate.setFont(font2);
		startDate.setBackground(Color.WHITE);
		startDate.setOpaque(true);
		
		startYearField.setBounds(120,77,48,20);
		
		startYear.setBounds(170,75,24,24);
		startYear.setText("年");
		startYear.setFont(font2);
		startYear.setBackground(Color.WHITE);
		startYear.setOpaque(true);
		
		startMonthField.setBounds(200,77,24,20);
		
		startMonth.setBounds(230,75,24,24);
		startMonth.setText("月");
		startMonth.setFont(font2);
		startMonth.setBackground(Color.WHITE);
		startMonth.setOpaque(true);
		
		startDayField.setBounds(260,77,24,20);
		
		startDay.setBounds(290,75,24,24);
		startDay.setText("日");
		startDay.setFont(font2);
		startDay.setBackground(Color.WHITE);
		startDay.setOpaque(true);
		
		endDate.setBounds(30,105,100,24);
		endDate.setText("结束日期:");
		endDate.setFont(font2);
		endDate.setBackground(Color.WHITE);
		endDate.setOpaque(true);
		
		endYearField.setBounds(120,107,48,20);
		
		endYear.setBounds(170,105,24,24);
		endYear.setText("年");
		endYear.setFont(font2);
		endYear.setBackground(Color.WHITE);
		endYear.setOpaque(true);
		
		endMonthField.setBounds(200,107,24,20);
		
		endMonth.setBounds(230,105,24,24);
		endMonth.setText("月");
		endMonth.setFont(font2);
		endMonth.setBackground(Color.WHITE);
		endMonth.setOpaque(true);
		
		endDayField.setBounds(260,107,24,20);
		
		endDay.setBounds(290,105,24,24);
		endDay.setText("日");
		endDay.setFont(font2);
		endDay.setBackground(Color.WHITE);
		endDay.setOpaque(true);
		
		find.setBounds(330,105,50,24);
		find.setText("查找");
		find.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		find.setFont(font2);
		find.setBackground(Color.WHITE);
		
		this.add(sheetLabel);
		this.add(startDate);
		this.add(endDate);
		this.add(startYear);
		this.add(startMonth);
		this.add(startDay);
		this.add(endYear);
		this.add(endMonth);
		this.add(endDay);
		this.add(find);
		this.add(startYearField);
		this.add(startMonthField);
		this.add(startDayField);
		this.add(endYearField);
		this.add(endMonthField);
		this.add(endDayField);
		this.add(sheetType);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
