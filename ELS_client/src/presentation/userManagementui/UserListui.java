package presentation.userManagementui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import bean.JavaBean1;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import presentation.reuse.Images;
import presentation.userui.Administratorui;
import vo.lineitemVO.userlineitemVO.UserlineitemVO;

public class UserListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JButton add;
	public JButton idFind;
	public JButton positionFind;
	public JTextField idField;
	public JLabel findById;
	public JLabel findByPosition;
	public JTable table;
	public JScrollPane scrollPane;
	public JButton delete;
	public JComboBox position;
	public UserlineitemVO oneLine;
	public UserManagementblservice userManagementblservice;
	public DefaultTableModel tableModel;
	JavaBean1 javaBean1;
	String positionbl="���Ա";
	
	public UserListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		findById=new JLabel();
		findByPosition=new JLabel();
		idField=new JTextField();
		idFind=new JButton();
		positionFind=new JButton();
		String[] positionEntries={"���Ա","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","��������Ա","������Ա","������Ա(��)","�ܾ���","����Ա"};
		position=new JComboBox(positionEntries);
		String[] columnNames = {"ѡ��","ID","����","�Ա�","�绰","��","��","ְλ"}; //����
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
		sheetLabel.setText("�û�����");
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setOpaque(true);
		
		add.setBounds(30,45,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,45,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("������Ա");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,90,120,24);
		findById.setText("��ID����:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByPosition.setBounds(30,125,120,24);
		findByPosition.setText("��ְλ����:");
		findByPosition.setFont(font2);
		findByPosition.setBackground(Color.WHITE);
		
		idField.setBounds(150,92,120,20);
		
		position.setBackground(Color.WHITE);
		position.setFont(font2);
		position.setBounds(150,125,160,24);
		position.addItemListener(new ItemListener(){
			public void  itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					String positionString=null;
					positionString=(String)position.getSelectedItem();
					switch(positionString){
					case"���Ա":
						positionbl="Courier";
						break;
					case"Ӫҵ��ҵ��Ա":
						positionbl="BusiHallClerk";
						break;
					case"��ת����ҵ��Ա":
						positionbl="TranCenClerk";
						break;
					case"��������Ա":
						positionbl="StockManager";
						break;
					case"������Ա":
						positionbl="Accountant2";
						break;
					case"������Ա(��)":
						positionbl="Accountant1";
						break;
					case"�ܾ���":
						positionbl="GeneralManager";
						break;
					case"����Ա":
						positionbl="Administrator";
						break;
						default:
							break;
					}
				} 
			}     
		});
		
		idFind.setBounds(380,90,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("����");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		positionFind.setBounds(380,125,64,24);
		positionFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		positionFind.setBackground(Color.WHITE);
		positionFind.setText("����");
		positionFind.setFont(font2);
		positionFind.setOpaque(true);
		positionFind.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				userManagementblservice=new UserManagement();
				javaBean1=userManagementblservice.inquireB(positionbl);
				ArrayList<UserlineitemVO> arrayList=(ArrayList<UserlineitemVO>)javaBean1.getObject();
				makeTable(arrayList);
			}
		});
		
		scrollPane = new JScrollPane(table); 
		
		delete=new JButton();
		delete.setBounds(30,420,50,24);
		delete.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		delete.setBackground(Color.WHITE);
		delete.setText("ɾ��");
		delete.setFont(font2);
		 
		this.add(scrollPane);
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(idField);
		this.add(idFind);
		this.add(findByPosition);
		this.add(position);
		this.add(positionFind);
		this.add(delete);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void makeTable(ArrayList<UserlineitemVO> arrayList){
		while(tableModel.getRowCount()>0){
			tableModel.removeRow(tableModel.getRowCount()-1);
		}
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
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 for(int i=arrayList.size()-1;i>=0;i--){
		     oneLine=arrayList.get(i);
			 String[] oneRow={"",oneLine.getId(),oneLine.getName(),oneLine.getGender().toString(),
			    	oneLine.getPhone(),oneLine.getCity(),oneLine.getRegion(),
			    	oneLine.getPosition().toString()};
			 tableModel.addRow(oneRow);
		 }
		 table.setRowHeight(24);
		 table.setBackground(Color.WHITE);
		 table.setShowVerticalLines(true);
		 table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		 scrollPane.setSize(550,241);
		 scrollPane.setLocation(30,160);
		 scrollPane.setViewportView(table);
		 delete.addActionListener(new ActionListener(){//����¼�
			   public void actionPerformed(ActionEvent e){
				   ArrayList<String> idList=new ArrayList<String>();
				   while(table.getSelectedRow()>=0){
				       idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				       tableModel.removeRow(table.getSelectedRow());  //ɾ���� 
				   }
				   idList.add((String)table.getValueAt(table.getSelectedRow(),1));
				   userManagementblservice=new UserManagement();
				   userManagementblservice.deleteMany(idList);
				  }});
	}
}
