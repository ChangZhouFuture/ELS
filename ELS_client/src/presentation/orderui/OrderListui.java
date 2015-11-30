package presentation.orderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.reuse.Images;
import presentation.userui.Courierui;

public class OrderListui extends JPanel{
	JLabel SheetLabel;
	JLabel Sheet;
	JLabel OrderName;
	JButton Add;
	JLabel AddText;
	JRadioButton FindById;
	JRadioButton FindByDate;
	ButtonGroup FindGroup;
	JTextField IdField;
	JTextField YearField;
	JTextField MonthField;
	JTextField DayField;
	JLabel Year;
	JLabel Month;
	JLabel Day;
	JButton IdFind;
	JButton DateFind;
	
	public static void main(String[] args){
		Courierui ui=new Courierui();
		OrderListui uiPanel=new OrderListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OrderListui(){
		SheetLabel=new JLabel();
		Sheet=new JLabel();
		OrderName=new JLabel();
		Add=new JButton();
		AddText=new JLabel();
		FindById=new JRadioButton();
		FindByDate=new JRadioButton();
		FindGroup=new ButtonGroup();
		IdField=new JTextField();
		YearField=new JTextField();
		MonthField=new JTextField();
		DayField=new JTextField();
		Year=new JLabel();
		Month=new JLabel();
		Day=new JLabel();
		IdFind=new JButton();
		DateFind=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		Sheet.setBounds(0,0,30,30);
		Sheet.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		Sheet.setIcon(Images.SHEET_IMAGE);
		Sheet.setOpaque(true);
		
		OrderName.setBounds(30,0,586,30);
		OrderName.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		OrderName.setText("订单信息管理");
		OrderName.setFont(font1);
		OrderName.setBackground(Color.WHITE);
		OrderName.setOpaque(true);
		
		SheetLabel.setBounds(0,0,616,30);
		SheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		SheetLabel.setBackground(Color.WHITE);
		SheetLabel.setOpaque(true);
		SheetLabel.add(Sheet);
		SheetLabel.add(OrderName);
		
		Add.setBounds(30,45,30,30);
		Add.setIcon(Images.ADD_IMAGE);
		
		AddText.setBounds(60,45,80,30);
		AddText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		AddText.setBackground(Color.WHITE);
		AddText.setText("增加订单");
		AddText.setFont(font3);
		AddText.setOpaque(true);
		
		FindById.setBounds(30,90,120,24);
		FindById.setText("按ID查找:");
		FindById.setFont(font2);
		FindById.setBackground(Color.WHITE);
		
		FindByDate.setBounds(30,125,120,24);
		FindByDate.setText("按日期查找:");
		FindByDate.setFont(font2);
		FindByDate.setBackground(Color.WHITE);
		
		FindGroup.add(FindById);
		FindGroup.add(FindByDate);
		
		IdField.setBounds(150,92,120,20);
		
		YearField.setBounds(150,127,48,20);
		
		Year.setBounds(200,125,24,24);
		Year.setText("年");
		Year.setFont(font2);
		Year.setBackground(Color.WHITE);
		Year.setOpaque(true);
		
		MonthField.setBounds(230,127,24,20);
		
		Month.setBounds(260,125,24,24);
		Month.setText("月");
		Month.setFont(font2);
		Month.setBackground(Color.WHITE);
		Month.setOpaque(true);
		
		DayField.setBounds(290,127,24,20);
		
		Day.setBounds(320,125,24,24);
		Day.setText("日");
		Day.setFont(font2);
		Day.setBackground(Color.WHITE);
		Day.setOpaque(true);
		
		IdFind.setBounds(360,90,64,24);
		IdFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		IdFind.setBackground(Color.WHITE);
		IdFind.setText("查找");
		IdFind.setFont(font2);
		IdFind.setOpaque(true);
		
		DateFind.setBounds(360,125,64,24);
		DateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		DateFind.setBackground(Color.WHITE);
		DateFind.setText("查找");
		DateFind.setFont(font2);
		DateFind.setOpaque(true);
		
		this.add(SheetLabel);
		this.add(Add);
		this.add(AddText);
		this.add(FindById);
		this.add(FindByDate);
		this.add(IdField);
		this.add(YearField);
		this.add(Year);
		this.add(MonthField);
		this.add(Month);
		this.add(DayField);
		this.add(Day);
		this.add(IdFind);
		this.add(DateFind);
		
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
