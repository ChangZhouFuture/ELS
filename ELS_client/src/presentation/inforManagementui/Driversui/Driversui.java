package presentation.inforManagementui.Driversui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import presentation.userui.BusiHallClerkui;

public class Driversui extends JPanel{
	public JLabel drivers;
	public JLabel birthDate;
	public JTextField birthYearField;
	public JTextField birthMonthField;
	public JTextField birthDayField;
	public JLabel birthYear;
	public JLabel birthMonth;
	public JLabel birthDay;
	public JLabel limitDate;
	public JTextField limitYearField;
	public JTextField limitMonthField;
	public JTextField limitDayField;
	public JLabel limitYear;
	public JLabel limitMonth;
	public JLabel limitDay;
	public JLabel name;
	public JTextField nameField;
	public JLabel sex;
	public JRadioButton man;
	public JRadioButton woman;
	public ButtonGroup sexGroup;
	public JLabel idCard;
	public JTextField idCardField;
	public JLabel phone;
	public JTextField phoneField;
	public JButton makeOrder;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		Driversui uiPanel=new Driversui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public Driversui(){
		drivers=new JLabel();
		birthDate=new JLabel();
		birthYearField=new JTextField();
		birthMonthField=new JTextField();
		birthDayField=new JTextField();
		birthYear=new JLabel();
		birthMonth=new JLabel();
		birthDay=new JLabel();
		limitDate=new JLabel();
		limitYearField=new JTextField();
		limitMonthField=new JTextField();
		limitDayField=new JTextField();
		limitYear=new JLabel();
		limitMonth=new JLabel();
		limitDay=new JLabel();
		name=new JLabel();
		nameField=new JTextField();
		sex=new JLabel();
		man=new JRadioButton();
		woman=new JRadioButton();
		sexGroup=new ButtonGroup();
		idCard=new JLabel();
		idCardField=new JTextField();
		phone=new JLabel();
		phoneField=new JTextField();
		makeOrder=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		drivers.setBounds(218,10,180,30);
		drivers.setText("司机信息");
		drivers.setHorizontalAlignment(SwingConstants.CENTER);
		drivers.setFont(font1);
		drivers.setBackground(Color.WHITE);
		drivers.setOpaque(true);
		
		sex.setBounds(40,80,90,24);
		sex.setText("性别：");
		sex.setFont(font2);
		sex.setBackground(Color.WHITE);
		sex.setOpaque(true);
		
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
		
		limitDate.setBounds(40,200,90,24);
		limitDate.setText("行驶证期限：");
		limitDate.setFont(font2);
		limitDate.setBackground(Color.WHITE);
		limitDate.setOpaque(true);
		
		limitYearField.setBounds(130,202,48,20);
		
		limitYear.setBounds(180,200,24,24);
		limitYear.setText("年");
		limitYear.setFont(font2);
		limitYear.setBackground(Color.WHITE);
		limitYear.setOpaque(true);
		
		limitMonthField.setBounds(210,202,24,20);
		
		limitMonth.setBounds(240,200,24,24);
		limitMonth.setText("月");
		limitMonth.setFont(font2);
		limitMonth.setBackground(Color.WHITE);
		limitMonth.setOpaque(true);
		
		limitDayField.setBounds(270,202,24,20);
		
		limitDay.setBounds(300,200,24,24);
		limitDay.setText("日");
		limitDay.setFont(font2);
		limitDay.setBackground(Color.WHITE);
		limitDay.setOpaque(true);
		
		name.setBounds(40,50,90,24);
		name.setText("姓名：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		name.setOpaque(true);
		
		nameField.setBounds(130,52,100,20);
		
		idCard.setBounds(40,140,90,24);
		idCard.setText("身份证号：");
		idCard.setFont(font2);
		idCard.setBackground(Color.WHITE);
		idCard.setOpaque(true);
		
		idCardField.setBounds(130,142,160,20);
		
		phone.setBounds(40,170,90,24);
		phone.setText("手机：");
		phone.setFont(font2);
		phone.setBackground(Color.WHITE);
		phone.setOpaque(true);
		
		phoneField.setBounds(130,172,160,20);
		
		makeOrder.setBounds(260,442,96,30);
		makeOrder.setText("确认生成");
		makeOrder.setFont(font1);
		makeOrder.setBackground(Color.WHITE);
		makeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(drivers);
		this.add(birthDate);
		this.add(birthYearField);
		this.add(birthYear);
		this.add(birthMonthField);
		this.add(birthMonth);
		this.add(birthDayField);
		this.add(birthDay);
		this.add(limitDate);
		this.add(limitYearField);
		this.add(limitYear);
		this.add(limitMonthField);
		this.add(limitMonth);
		this.add(limitDayField);
		this.add(limitDay);
		this.add(name);
		this.add(nameField);
		this.add(sex);
		this.add(man);
		this.add(woman);
		this.add(idCard);
		this.add(idCardField);
		this.add(phone);
		this.add(phoneField);
		this.add(makeOrder);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
