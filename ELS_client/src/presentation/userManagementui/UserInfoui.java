package presentation.userManagementui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.userui.Administratorui;

public class UserInfoui extends JPanel{
	public JLabel userInfo;
	public JLabel name;
	public JLabel password;
	public JLabel gender;
	public JLabel birthDate;
	public JTextField birthYearField;
	public JTextField birthMonthField;
	public JTextField birthDayField;
	public JLabel birthYear;
	public JLabel birthMonth;
	public JLabel birthDay;
	public JLabel identyNum;
	public JLabel phone;
	public JLabel agencyType;
	public JLabel area;
	public JLabel city;
	public JLabel region;
	public JLabel agencyID;
	public JLabel position;
	public JLabel payType;
	public JTextField nameField;
	public JTextField passwordField;
	public JTextField identyNumField;
	public JTextField phoneField;
	public JTextField regionField;
	public JTextField cityField;
	public JTextField agencyIDField;
	public JComboBox positionSeleted;
	public JComboBox agencyTypeSeleted;
	public JRadioButton man;
	public JRadioButton woman;
	public ButtonGroup sexGroup;
	public JRadioButton byMonth;
	public JRadioButton byReward;
	public JRadioButton byOne;
	public ButtonGroup payGroup;
	public JButton makeOrder;
	
	public static void main(String[] args){
		Administratorui ui=new Administratorui();
		UserInfoui uiPanel=new UserInfoui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public UserInfoui(){
		userInfo=new JLabel();
		name=new JLabel();
		password=new JLabel();
		gender=new JLabel();
		birthDate=new JLabel();
		birthYearField=new JTextField();
		birthMonthField=new JTextField();
		birthDayField=new JTextField();
		birthYear=new JLabel();
		birthMonth=new JLabel();
		birthDay=new JLabel();
		identyNum=new JLabel();
		phone=new JLabel();
		agencyType=new JLabel();
		area=new JLabel();
		city=new JLabel();
		region=new JLabel();
		agencyID=new JLabel();
		position=new JLabel();
		payType=new JLabel();
		nameField=new JTextField();
		passwordField=new JTextField();
		identyNumField=new JTextField();
		phoneField=new JTextField();
		regionField=new JTextField();
		cityField=new JTextField();
		agencyIDField=new JTextField();
		positionSeleted=new JComboBox();
		man=new JRadioButton();
		woman=new JRadioButton();
		sexGroup=new ButtonGroup();
		byMonth=new JRadioButton();
		byReward=new JRadioButton();
		byOne=new JRadioButton();
		payGroup=new ButtonGroup();
		makeOrder=new JButton();
		String[] positionEntries={"快递员","营业厅业务员","中转中心业务员","库存管理人员","财务人员","财务人员(高)","总经理","管理员"};
		positionSeleted=new JComboBox(positionEntries);
		String[] agencyTypeEntries={"营业厅","中转中心","总部"};
		agencyTypeSeleted=new JComboBox(agencyTypeEntries);
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		userInfo.setBounds(218,10,180,30);
		userInfo.setText("人员信息");
		userInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo.setFont(font1);
		userInfo.setBackground(Color.WHITE);
		userInfo.setOpaque(true);
		
		name.setBounds(40,50,90,24);
		name.setText("姓名：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		name.setOpaque(true);
		
		nameField.setBounds(130,52,100,20);
		
		password.setBounds(300,50,90,24);
		password.setText("密码：");
		password.setFont(font2);
		password.setBackground(Color.WHITE);
		password.setOpaque(true);
		
		passwordField.setBounds(390,52,100,20);
		
		gender.setBounds(40,80,90,24);
		gender.setText("性别：");
		gender.setFont(font2);
		gender.setBackground(Color.WHITE);
		gender.setOpaque(true);
		
		man.setBounds(130,80,90,24);
		man.setText("男");
		man.setFont(font2);
		man.setBackground(Color.WHITE);
		man.setOpaque(true);
		
		woman.setBounds(220,80,90,24);
		woman.setText("女");
		woman.setFont(font2);
		woman.setBackground(Color.WHITE);
		woman.setOpaque(true);
		
		sexGroup.add(man);
		sexGroup.add(woman);
		
		birthDate.setBounds(40,110,90,24);
		birthDate.setText("出生日期：");
		birthDate.setFont(font2);
		birthDate.setBackground(Color.WHITE);
		birthDate.setOpaque(true);
		
		birthYearField.setBounds(130,112,48,20);
		
		birthYear.setBounds(180,110,24,24);
		birthYear.setText("年");
		birthYear.setFont(font2);
		birthYear.setBackground(Color.WHITE);
		birthYear.setOpaque(true);
		
		birthMonthField.setBounds(210,112,24,20);
		
		birthMonth.setBounds(240,110,24,24);
		birthMonth.setText("月");
		birthMonth.setFont(font2);
		birthMonth.setBackground(Color.WHITE);
		birthMonth.setOpaque(true);
		
		birthDayField.setBounds(270,112,24,20);
		
		birthDay.setBounds(300,110,24,24);
		birthDay.setText("日");
		birthDay.setFont(font2);
		birthDay.setBackground(Color.WHITE);
		birthDay.setOpaque(true);
		
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
		phone.setOpaque(true);
		
		phoneField.setBounds(130,172,160,20);
		
		area.setBounds(40,200,60,24);
		area.setText("地区：");
		area.setFont(font2);
		area.setBackground(Color.WHITE);
		area.setOpaque(true);
		
		cityField.setBounds(130,202,80,20);
		
		city.setBounds(210,200,24,24);
		city.setText("市");
		city.setFont(font2);
		city.setBackground(Color.WHITE);
		city.setOpaque(true);
		
		regionField.setBounds(240,202,80,20);
		
		region.setBounds(320,200,24,24);
		region.setText("区");
		region.setFont(font2);
		region.setBackground(Color.WHITE);
		region.setOpaque(true);
		
		agencyType.setBounds(40,230,90,24);
		agencyType.setText("机构：");
		agencyType.setFont(font2);
		agencyType.setBackground(Color.WHITE);
		agencyType.setOpaque(true);
		
		agencyTypeSeleted.setBackground(Color.WHITE);
		agencyTypeSeleted.setFont(font2);
		agencyTypeSeleted.setBounds(130,230,160,24);
		
		agencyID.setBounds(40,260,90,24);
		agencyID.setText("机构编号：");
		agencyID.setFont(font2);
		agencyID.setBackground(Color.WHITE);
		agencyID.setOpaque(true);
		
		agencyIDField.setBounds(130,262,120,20);
		
		position.setBounds(40,290,90,24);
		position.setText("职位：");
		position.setFont(font2);
		position.setBackground(Color.WHITE);
		position.setOpaque(true);
		
		positionSeleted.setBackground(Color.WHITE);
		positionSeleted.setFont(font2);
		positionSeleted.setBounds(130,290,160,24);
		
		payType.setBounds(40,320,90,24);
		payType.setText("付薪方式：");
		payType.setFont(font2);
		payType.setBackground(Color.WHITE);
		payType.setOpaque(true);
		
		byMonth.setBounds(130,320,90,24);
		byMonth.setText("月薪");
		byMonth.setFont(font2);
		byMonth.setBackground(Color.WHITE);
		byMonth.setOpaque(true);
		
		byReward.setBounds(220,320,90,24);
		byReward.setText("提成");
		byReward.setFont(font2);
		byReward.setBackground(Color.WHITE);
		byReward.setOpaque(true);
		
		byOne.setBounds(310,320,90,24);
		byOne.setText("计次");
		byOne.setFont(font2);
		byOne.setBackground(Color.WHITE);
		byOne.setOpaque(true);
		
		payGroup.add(byMonth);
		payGroup.add(byReward);
		payGroup.add(byOne);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.add(userInfo);
		this.add(name);
		this.add(password);
		this.add(gender);
		this.add(birthDate);
		this.add(birthYearField);
		this.add(birthYear);
		this.add(birthMonthField);
		this.add(birthMonth);
		this.add(birthDayField);
		this.add(birthDay);
		this.add(identyNum);
		this.add(phone);
		this.add(agencyType);
		this.add(area);
		this.add(city);
		this.add(region);
		this.add(agencyID);
		this.add(position);
		this.add(payType);
		this.add(nameField);
		this.add(passwordField);
		this.add(identyNumField);
		this.add(nameField);
		this.add(phoneField);
		this.add(regionField);
		this.add(cityField);
		this.add(agencyIDField);
		this.add(positionSeleted);
		this.add(agencyTypeSeleted);
		this.add(man);
		this.add(woman);
		this.add(byMonth);
		this.add(byReward);
		this.add(byOne);
		this.add(makeOrder);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
