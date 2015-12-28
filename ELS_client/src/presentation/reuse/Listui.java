package presentation.reuse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Listui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public DateChooser dateChooser;
	public JTextField showDate;
	public JButton add;
	public JButton idFind;
	public JButton dateFind;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByDate;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel tableModel;
	public JButton delete;
	
	public Listui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JLabel();
		findByDate=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		dateFind=new JButton();
		delete=new JButton();
		dateChooser = DateChooser.getInstance("yyyy-MM-dd");
		showDate = new JTextField("单击选择日期");
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加单据");
		addText.setFont(font3);
		
		findById.setBounds(30,90,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByDate.setBounds(30,125,120,24);
		findByDate.setText("按日期查找:");
		findByDate.setFont(font2);
		findByDate.setBackground(Color.WHITE);
		
		idField.setBounds(150,92,120,20);
		
		showDate.setBounds(150,127,120,20);
		dateChooser.register(showDate);
		
		idFind.setBounds(360,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		
		dateFind.setBounds(360,125,64,24);
		dateFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		dateFind.setBackground(Color.WHITE);
		dateFind.setText("查找");
		dateFind.setFont(font2);
		
		delete.setBounds(30,420,50,24);
		delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		delete.setBackground(Color.WHITE);
		delete.setText("删除");
		delete.setFont(font2);
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByDate);
		this.add(idField);
		this.add(idFind);
		this.add(dateFind);
		this.add(showDate);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
