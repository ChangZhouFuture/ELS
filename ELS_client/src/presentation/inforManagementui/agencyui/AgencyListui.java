package presentation.inforManagementui.agencyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bean.JavaBean1;
import businesslogic.inforManagementbl.DriversInfor;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Images;
import presentation.userui.Accountantui1;
import presentation.userui.GeneralManagerui;
import vo.lineitemVO.inforManagementlineitemVO.DriverslineitemVO;

public class AgencyListui extends JPanel{
	public JLabel sheetLabel;
	public JLabel addText;
	public JLabel city;
	public JLabel region;
	public JButton add;
	public JButton idFind;
	public JButton cityFind;
	public JButton delete;
	public JTextField idField;
	public JTextField cityField;
	public JTextField regionField;
	public JLabel findById;
	public JLabel findByCity;
	public JTable table;
	public JComboBox sheetType;
	public JScrollPane scrollPane;
	String sheetTypebl=null;
	
	public static void main(String[] args){
		
		GeneralManagerui ui=new GeneralManagerui();
		AgencyListui uiPanel=new AgencyListui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public AgencyListui(){
		sheetLabel=new JLabel();
		add=new JButton();
		addText=new JLabel();
		city=new JLabel();
		region=new JLabel();
		findById=new JLabel();
		findByCity=new JLabel();
		idField=new JTextField();
		cityField=new JTextField();
		regionField=new JTextField();
		idFind=new JButton();
		cityFind=new JButton();
		String[] sheetTypeEntries={"营业厅","中转中心","总部"};
		sheetType=new JComboBox(sheetTypeEntries);
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setText("机构管理");
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
					case"营业厅":
						sheetTypebl="Busi";
						break;
					case"中转中心":
						sheetTypebl="Tran";
						break;
					case"总部":
						sheetTypebl="General";
						break;
						default:
							break;
					}
				} 
			}     
		});
		add.setBounds(30,80,30,30);
		add.setIcon(Images.ADD_IMAGE);
		
		addText.setBounds(60,80,80,30);
		addText.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		addText.setBackground(Color.WHITE);
		addText.setText("增加机构");
		addText.setFont(font3);
		addText.setOpaque(true);
		
		findById.setBounds(30,115,120,24);
		findById.setText("按ID查找:");
		findById.setFont(font2);
		findById.setBackground(Color.WHITE);
		
		findByCity.setBounds(30,145,120,24);
		findByCity.setText("按地区查找:");
		findByCity.setFont(font2);
		findByCity.setBackground(Color.WHITE);
		
		idField.setBounds(150,117,120,20);
		
		cityField.setBounds(150,147,100,20);
		
		city.setBounds(255,145,24,24);
		city.setBackground(Color.WHITE);
		city.setText("市");
		city.setFont(font2);
		city.setOpaque(true);
		
		regionField.setBounds(285,147,48,20);
		
		region.setBounds(340,145,24,24);
		region.setBackground(Color.WHITE);
		region.setText("区");
		region.setFont(font2);
		region.setOpaque(true);
		
		idFind.setBounds(380,115,64,24);
		idFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idFind.setBackground(Color.WHITE);
		idFind.setText("查找");
		idFind.setFont(font2);
		idFind.setOpaque(true);
		
		cityFind.setBounds(380,145,64,24);
		cityFind.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		cityFind.setBackground(Color.WHITE);
		cityFind.setText("查找");
		cityFind.setFont(font2);
		cityFind.setOpaque(true);
		cityFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cityString=null;
				String regionString=null;
				if(cityField.getText()!=null&&regionField.getText()!=null){
					cityString=cityField.getText();
					regionString=regionField.getText();
					JavaBean1 javaBean1;
					
					try {
						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				else{
					System.out.println("Error");
				}
			}
		});
		
		this.add(sheetLabel);
		this.add(add);
		this.add(addText);
		this.add(findById);
		this.add(findByCity);
		this.add(idField);
		this.add(cityField);
		this.add(city);
		this.add(region);
		this.add(regionField);
		this.add(idFind);
		this.add(cityFind);
		this.add(sheetType);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
