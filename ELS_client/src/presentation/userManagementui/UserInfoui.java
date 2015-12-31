package presentation.userManagementui;

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
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import presentation.reuse.DateChooser;
import presentation.reuse.ParentDocuments;
import presentation.userui.Administratorui;
import state.Gender;
import vo.userVO.UserVO;

public class UserInfoui extends ParentDocuments{
	public JLabel userInfo;
	public JLabel name;
	public JLabel password;
	public JLabel gender;
	public JLabel birthDate;
	public JTextField birthDateField;
	public DateChooser birthDateChooser;
	public JLabel identyNum;
	public JLabel phone;
	public JLabel area;
	public JLabel city;
	public JLabel region;
	public JLabel agencyID;
	public JLabel position;
	public JTextField nameField;
	public JTextField passwordField;
	public JTextField identyNumField;
	public JTextField phoneField;
	public JTextField regionField;
	public JTextField cityField;
	public JTextField agencyIDField;
	public JComboBox positionSeleted;
	String positionValue="快递员";
	state.Position positionSeletion=state.Position.Courier;
	public JComboBox sexType;
	String sexTypeValue="男";
	Gender sexTypeSeletion=Gender.MALE;
	JavaBean1 javaBean1;
	UserManagementblservice userManagementblservice;
	public UserVO userVO;
	
	public UserInfoui(){
		userInfo=new JLabel();
		name=new JLabel();
		password=new JLabel();
		gender=new JLabel();
		birthDate=new JLabel();
		birthDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		birthDateField = new JTextField("单击选择日期");
		identyNum=new JLabel();
		phone=new JLabel();
		area=new JLabel();
		city=new JLabel();
		region=new JLabel();
		agencyID=new JLabel();
		position=new JLabel();
		nameField=new JTextField();
		passwordField=new JTextField();
		identyNumField=new JTextField();
		phoneField=new JTextField();
		regionField=new JTextField();
		cityField=new JTextField();
		agencyIDField=new JTextField();
		positionSeleted=new JComboBox();
		String[] sexTypeEntries={"男","女"};
		sexType=new JComboBox(sexTypeEntries);
		String[] positionEntries={"快递员","营业厅业务员","中转中心业务员","库存管理人员","财务人员","财务人员(高)","总经理","管理员"};
		positionSeleted=new JComboBox(positionEntries);
		userVO=new UserVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		userInfo.setBounds(218,10,180,30);
		userInfo.setText("人员信息");
		userInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo.setFont(font1);
		userInfo.setBackground(Color.WHITE);
		
		name.setBounds(40,50,90,24);
		name.setText("姓名：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		
		nameField.setBounds(130,52,120,20);
		
		password.setBounds(300,50,90,24);
		password.setText("密码：");
		password.setFont(font2);
		password.setBackground(Color.WHITE);
		
		passwordField.setBounds(390,52,120,20);
		
		gender.setBounds(40,80,90,24);
		gender.setText("性别：");
		gender.setFont(font2);
		gender.setBackground(Color.WHITE);
		
		sexType.setBounds(130,80,120,24);
		sexType.setFont(font2);
		sexType.setBackground(Color.WHITE);
		sexType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					sexTypeValue=(String)sexType.getSelectedItem();
					switch(sexTypeValue){
					case "男":sexTypeSeletion=Gender.MALE;break;
					case "女":sexTypeSeletion=Gender.FEMALE;break;
					default:break;
					}
				} 
			}
		});
		
		birthDate.setBounds(40,110,90,24);
		birthDate.setText("出生日期：");
		birthDate.setFont(font2);
		birthDate.setBackground(Color.WHITE);
		
		birthDateField.setBounds(130,112,120,20);
		birthDateChooser.register(birthDateField);
		
		identyNum.setBounds(40,140,90,24);
		identyNum.setText("身份证号：");
		identyNum.setFont(font2);
		identyNum.setBackground(Color.WHITE);
		identyNum.setOpaque(true);
		
		identyNumField.setBounds(130,142,160,20);
		
		phone.setBounds(40,170,90,24);
		phone.setText("手机：");
		phone.setFont(font2);
		phone.setBackground(Color.WHITE);
		
		phoneField.setBounds(130,172,120,20);
		
		area.setBounds(40,200,60,24);
		area.setText("地区：");
		area.setFont(font2);
		area.setBackground(Color.WHITE);
		
		cityField.setBounds(130,202,120,20);
		
		city.setBounds(260,200,24,24);
		city.setText("市");
		city.setFont(font2);
		city.setBackground(Color.WHITE);
		
		regionField.setBounds(290,202,120,20);
		
		region.setBounds(420,200,24,24);
		region.setText("区");
		region.setFont(font2);
		region.setBackground(Color.WHITE);
		
		agencyID.setBounds(40,230,90,24);
		agencyID.setText("机构编号：");
		agencyID.setFont(font2);
		agencyID.setBackground(Color.WHITE);
		agencyID.setOpaque(true);
		
		agencyIDField.setBounds(130,232,120,20);
		
		position.setBounds(40,260,90,24);
		position.setText("职位：");
		position.setFont(font2);
		position.setBackground(Color.WHITE);
		position.setOpaque(true);
		
		positionSeleted.setBackground(Color.WHITE);
		positionSeleted.setFont(font2);
		positionSeleted.setBounds(130,260,120,24);
		positionSeleted.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					positionValue=(String)positionSeleted.getSelectedItem();
					switch(positionValue){
					case "快递员":positionSeletion=state.Position.Courier;break;
					case "营业厅业务员":positionSeletion=state.Position.BusiHallClerk;break;
					case "中转中心业务员":positionSeletion=state.Position.TranCenClerk;break;
					case "库存管理人员":positionSeletion=state.Position.StockManager;break;
					case "财务人员":positionSeletion=state.Position.Accountant2;break;
					case "财务人员(高)":positionSeletion=state.Position.Accountant1;break;
					case "总经理":positionSeletion=state.Position.GeneralManager;break;
					case "管理员":positionSeletion=state.Position.Administrator;break;
					default:break;
					}
				} 
			}
		});
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				userManagementblservice=new UserManagement();
				userVO.setName(nameField.getText());
				userVO.setGender(sexTypeSeletion);
				userVO.setBirthDate(birthDateField.getText());
				userVO.setPassword(passwordField.getText());
				userVO.setPhone(phoneField.getText());
				userVO.setIdentyNum(identyNumField.getText());
				userVO.setCity(cityField.getText());
				userVO.setRegion(regionField.getText());
				userVO.setPhone(phoneField.getText());
				userVO.setAgencyID(agencyIDField.getText());
				userVO.setPosition(positionSeletion);
				javaBean1=userManagementblservice.add(userVO);
				userVO=(UserVO)javaBean1.getObject();
				docmID.setText(userVO.getId());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				userManagementblservice=new UserManagement();
				userVO.setName(nameField.getText());
				userVO.setGender(sexTypeSeletion);
				userVO.setBirthDate(birthDateField.getText());
				userVO.setPassword(passwordField.getText());
				userVO.setPhone(phoneField.getText());
				userVO.setIdentyNum(identyNumField.getText());
				userVO.setCity(cityField.getText());
				userVO.setRegion(regionField.getText());
				userVO.setPhone(phoneField.getText());
				userVO.setAgencyID(agencyIDField.getText());
				userVO.setPosition(positionSeletion);
				userManagementblservice.modify(userVO);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(userInfo);
		this.add(name);
		this.add(password);
		this.add(gender);
		this.add(birthDate);
		this.add(birthDateField);
		this.add(identyNum);
		this.add(phone);
		this.add(area);
		this.add(city);
		this.add(region);
		this.add(agencyID);
		this.add(position);
		this.add(nameField);
		this.add(passwordField);
		this.add(identyNumField);
		this.add(nameField);
		this.add(phoneField);
		this.add(regionField);
		this.add(cityField);
		this.add(agencyIDField);
		this.add(positionSeleted);
		this.add(sexType);
	}
	public void refresh(){
		birthDateField.setEditable(false);
		passwordField.setEditable(false);
		nameField.setEditable(false);
		sexType.setEnabled(false);
		positionSeleted.setEnabled(false);
		identyNumField.setEditable(false);
		phoneField.setEditable(false);
		cityField.setEditable(false);
		regionField.setEditable(false);
		agencyIDField.setEditable(false);
		
		birthDateField.setBackground(Color.white);
		passwordField.setBackground(Color.white);
		nameField.setBackground(Color.white);
		identyNumField.setBackground(Color.white);
		phoneField.setBackground(Color.white);
		cityField.setBackground(Color.white);
		regionField.setBackground(Color.white);
		agencyIDField.setBackground(Color.white);
		
		birthDateField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		identyNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		phoneField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		cityField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		regionField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		agencyIDField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying(){
		birthDateField.setEditable(true);
		passwordField.setEditable(true);
		nameField.setEditable(true);
		sexType.setEnabled(true);
		positionSeleted.setEnabled(true);
		identyNumField.setEditable(true);
		phoneField.setEditable(true);
		cityField.setEditable(true);
		regionField.setEditable(true);
		agencyIDField.setEditable(true);
		modifyOrder.setVisible(true);
		
		birthDateField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		passwordField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		nameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		identyNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		phoneField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		cityField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		regionField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		agencyIDField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
