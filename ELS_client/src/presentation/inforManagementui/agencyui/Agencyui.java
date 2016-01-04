package presentation.inforManagementui.agencyui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import bean.JavaBean1;
import businesslogic.inforManagementbl.AgencyInfor;
import businesslogicservice.inforManagementblservice.AgencyInforblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.GeneralManagerui;
import state.AgencyType;
import vo.inforManagementVO.AgencyVO;

public class Agencyui extends ParentDocuments{
	public JLabel agencyInfo;
	public JLabel city;
	public JLabel region;
	public JLabel agencyType;
	public JTextField cityField;
	public JTextField regionField;
	public JComboBox agencyTypeType;
	String agencyValue="营业厅";
	AgencyType agencyTypeSeletion=AgencyType.BusinessHall;
	AgencyInforblservice agencyInforblservice;
	public AgencyVO agencyVO;
	JavaBean1 javaBean1;

	public Agencyui(){
		agencyInfo=new JLabel();
		city=new JLabel();
		region=new JLabel();
		agencyType=new JLabel();
		cityField=new JTextField();
		regionField=new JTextField();
		String[] agencyTypeEntries={"营业厅","中转中心"};
		agencyTypeType=new JComboBox(agencyTypeEntries);
		agencyVO=new AgencyVO();
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		agencyInfo.setBounds(218,10,180,30);
		agencyInfo.setText("机构信息");
		agencyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		agencyInfo.setFont(font1);
		agencyInfo.setBackground(Color.WHITE);
		
		city.setBounds(40,50,120,24);
		city.setText("所在城市：");
		city.setFont(font2);
		city.setBackground(Color.WHITE);
		
		cityField.setBounds(160,52,120,20);

		region.setBounds(40,80,120,24);
		region.setText("所在区域：");
		region.setFont(font2);
		region.setBackground(Color.WHITE);
		
		regionField.setBounds(160,82,120,20);
		
		agencyType.setBounds(40,110,120,24);
		agencyType.setText("机构类型：");
		agencyType.setFont(font2);
		agencyType.setBackground(Color.WHITE);
		
		agencyTypeType.setBounds(160,110,100,24);
		agencyTypeType.setFont(font2);
		agencyTypeType.setBackground(Color.WHITE);
		agencyTypeType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					agencyValue=(String)agencyTypeType.getSelectedItem();
					switch(agencyValue){
					case "营业厅":agencyTypeSeletion=AgencyType.BusinessHall;break;
					case "中转中心":agencyTypeSeletion=AgencyType.TransferCenter;break;
					default:break;
					}
				} 
			}
		});
		
		makeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				agencyInforblservice=new AgencyInfor();
				agencyVO.setCity(cityField.getText());
				agencyVO.setRegion(regionField.getText());
				agencyVO.setAgencyType(agencyTypeSeletion);
				javaBean1=agencyInforblservice.add(agencyVO);
				agencyVO=(AgencyVO)javaBean1.getObject();
				docmID.setText(agencyVO.getID());
				makeOrder.setEnabled(false);
			}
		});
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				agencyInforblservice=new AgencyInfor();
				agencyVO.setCity(cityField.getText());
				agencyVO.setRegion(regionField.getText());
				agencyVO.setAgencyType(agencyTypeSeletion);
				agencyInforblservice.modify(agencyVO);
			}
		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(agencyInfo);
		this.add(city);
		this.add(cityField);
		this.add(region);
		this.add(regionField);
		this.add(agencyType);
		this.add(agencyTypeType);
	}
	public void refresh() {
		cityField.setEditable(false);
		regionField.setEditable(false);
		agencyTypeType.setEnabled(false);
		
		cityField.setBackground(Color.white);
		regionField.setBackground(Color.white);
		
		cityField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		regionField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		cityField.setEditable(true);
		regionField.setEditable(true);
		agencyTypeType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		cityField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		regionField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
