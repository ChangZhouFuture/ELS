package presentation.reuse;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Listui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JLabel year;
	public JLabel month;
	public JLabel day;
	public JButton add;
	public JButton idFind;
	public JButton dateFind;
	public JTextField idField;
	public JTextField yearField;
	public JTextField monthField;
	public JTextField dayField;
	public JRadioButton findById;
	public JRadioButton findByDate;
	public ButtonGroup findGroup;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	
	public Listui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JRadioButton();
		findByDate=new JRadioButton();
		findGroup=new ButtonGroup();
		idField=new JTextField();
		yearField=new JTextField();
		monthField=new JTextField();
		dayField=new JTextField();
		year=new JLabel();
		month=new JLabel();
		day=new JLabel();
		idFind=new JButton();
		dateFind=new JButton();
		
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
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加单据");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByDate.setBounds(30,125,120,24);
		findByDate.setText("按日期查找:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		
		findGroup.add(findById);
		findGroup.add(findByDate);
		
		idField.setBounds(150,92,120,20);
		
		yearField.setBounds(150,127,48,20);
		
		year.setBounds(200,125,24,24);
		year.setText("年");
		year.setFont(font2);
		year.setBackground(Color.WHITE);
		year.setOpaque(true);
		
		monthField.setBounds(230,127,24,20);
		
		month.setBounds(260,125,24,24);
		month.setText("月");
		month.setFont(font2);
		month.setBackground(Color.WHITE);
		month.setOpaque(true);
		
		dayField.setBounds(290,127,24,20);
		
		day.setBounds(320,125,24,24);
		day.setText("日");
		day.setFont(font2);
		day.setBackground(Color.WHITE);
		day.setOpaque(true);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		dateFind.setBounds(360,125,64,24);
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setBackground(Color.WHITE);
		dateFind.setText("查找");
		dateFind.setFont(font2);
		dateFind.setOpaque(true);
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByDate);
		this.add(idField);
		this.add(yearField);
		this.add(year);
		this.add(monthField);
		this.add(month);
		this.add(dayField);
		this.add(day);
		this.add(idFind);
		this.add(dateFind);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
