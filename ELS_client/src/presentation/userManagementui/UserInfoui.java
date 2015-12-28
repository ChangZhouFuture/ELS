package presentation.userManagementui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

import presentation.reuse.DateChooser;
import presentation.reuse.ParentDocuments;
import presentation.userui.Administratorui;
import state.Gender;
import state.PayType;

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
	public JComboBox sexType;
	String sexTypeValue="��";
	Gender sexTypeSeletion=Gender.MALE;
	public JComboBox payTypeType;
	String payTypevalue="����";
	PayType payTypeSeletion=PayType.BYMONTH;
	
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
		birthDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		birthDateField = new JTextField("����ѡ������");
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
		String[] sexTypeEntries={"��","Ů"};
		sexType=new JComboBox(sexTypeEntries);
		String[] payTypeEntries={"����","����"};
		payTypeType=new JComboBox(payTypeEntries);
		String[] positionEntries={"���Ա","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","��������Ա","������Ա","������Ա(��)","�ܾ���","����Ա"};
		positionSeleted=new JComboBox(positionEntries);
		String[] agencyTypeEntries={"Ӫҵ��","��ת����","�ܲ�"};
		agencyTypeSeleted=new JComboBox(agencyTypeEntries);
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		userInfo.setBounds(218,10,180,30);
		userInfo.setText("��Ա��Ϣ");
		userInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo.setFont(font1);
		userInfo.setBackground(Color.WHITE);
		
		name.setBounds(40,50,90,24);
		name.setText("������");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		
		nameField.setBounds(130,52,120,20);
		
		password.setBounds(300,50,90,24);
		password.setText("���룺");
		password.setFont(font2);
		password.setBackground(Color.WHITE);
		
		passwordField.setBounds(390,52,120,20);
		
		gender.setBounds(40,80,90,24);
		gender.setText("�Ա�");
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
					case "��":sexTypeSeletion=Gender.MALE;break;
					case "Ů":sexTypeSeletion=Gender.FEMALE;break;
					default:break;
					}
				} 
			}
		});
		
		birthDate.setBounds(40,110,90,24);
		birthDate.setText("�������ڣ�");
		birthDate.setFont(font2);
		birthDate.setBackground(Color.WHITE);
		
		birthDateField.setBounds(130,112,120,20);
		birthDateChooser.register(birthDateField);
		
		identyNum.setBounds(40,140,90,24);
		identyNum.setText("���֤�ţ�");
		identyNum.setFont(font2);
		identyNum.setBackground(Color.WHITE);
		identyNum.setOpaque(true);
		
		identyNumField.setBounds(130,142,160,20);
		
		phone.setBounds(40,170,90,24);
		phone.setText("�ֻ���");
		phone.setFont(font2);
		phone.setBackground(Color.WHITE);
		
		phoneField.setBounds(130,172,120,20);
		
		area.setBounds(40,200,60,24);
		area.setText("������");
		area.setFont(font2);
		area.setBackground(Color.WHITE);
		
		cityField.setBounds(130,202,120,20);
		
		city.setBounds(260,200,24,24);
		city.setText("��");
		city.setFont(font2);
		city.setBackground(Color.WHITE);
		
		regionField.setBounds(290,202,120,20);
		
		region.setBounds(420,200,24,24);
		region.setText("��");
		region.setFont(font2);
		region.setBackground(Color.WHITE);
		
		agencyType.setBounds(40,230,90,24);
		agencyType.setText("������");
		agencyType.setFont(font2);
		agencyType.setBackground(Color.WHITE);
		
		agencyTypeSeleted.setBackground(Color.WHITE);
		agencyTypeSeleted.setFont(font2);
		agencyTypeSeleted.setBounds(130,230,120,24);
		
		agencyID.setBounds(40,260,90,24);
		agencyID.setText("������ţ�");
		agencyID.setFont(font2);
		agencyID.setBackground(Color.WHITE);
		agencyID.setOpaque(true);
		
		agencyIDField.setBounds(130,262,120,20);
		
		position.setBounds(40,290,90,24);
		position.setText("ְλ��");
		position.setFont(font2);
		position.setBackground(Color.WHITE);
		position.setOpaque(true);
		
		positionSeleted.setBackground(Color.WHITE);
		positionSeleted.setFont(font2);
		positionSeleted.setBounds(130,290,120,24);
		
		payType.setBounds(40,320,90,24);
		payType.setText("��н��ʽ��");
		payType.setFont(font2);
		payType.setBackground(Color.WHITE);
		payType.setOpaque(true);
		
		payTypeType.setBounds(130,320,120,24);
		payTypeType.setBackground(Color.WHITE);
		payTypeType.setFont(font2);

		this.add(userInfo);
		this.add(name);
		this.add(password);
		this.add(gender);
		this.add(birthDate);
		this.add(birthDateField);
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
		this.add(sexType);
		this.add(payTypeType);
	}
}
