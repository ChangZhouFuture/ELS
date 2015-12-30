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
		String[] columnNames = {"ְλ","��н��ʽ","��������","��ɰٷֱ�"}; //����
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
		sheetLabel.setText("���ʲ��Թ���");
		
		modify.setBounds(30,50,70,24);
		modify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modify.setBackground(Color.WHITE);
		modify.setText("�޸�");
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
		
		table.setValueAt("ְλ",0,0);
		table.setValueAt("���Ա",1,0);
		table.setValueAt("Ӫҵ��ҵ��Ա",2,0);
		table.setValueAt("��ת����ҵ��Ա",3,0);
		table.setValueAt("��������Ա",4,0);
		table.setValueAt("������Ա",5,0);
		table.setValueAt("�߼�������Ա",6,0);
		table.setValueAt("�ܾ���",7,0);
		table.setValueAt("����Ա",8,0);
		table.setValueAt("��н��ʽ",0,1);
		table.setValueAt("��н",0,2);
		table.setValueAt("��ɰٷֱ�",0,3);
		
		makeModify.setBounds(30,420,100,24);
		makeModify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		makeModify.setBackground(Color.WHITE);
		makeModify.setText("ȷ���޸�");
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
