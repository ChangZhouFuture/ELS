package presentation.inforManagementui.Staffui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentation.reuse.Images;

public class WageStrategyListui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public JButton modify;
	public JButton makeModify;
	public JScrollPane scrollPane;
	public DefaultTableModel tableModel;
	
	public WageStrategyListui(){
		sheetLabel=new JLabel();
		makeModify=new JButton();
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		
		makeModify.setBounds(30,420,120,24);
		makeModify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		makeModify.setBackground(Color.WHITE);
		makeModify.setText("È·ÈÏÐÞ¸Ä");
		makeModify.setFont(font2);
		
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
