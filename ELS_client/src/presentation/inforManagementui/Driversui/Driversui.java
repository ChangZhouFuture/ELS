package presentation.inforManagementui.Driversui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bean.JavaBean1;
import businesslogic.documentsbl.PaymentOrder;
import businesslogic.inforManagementbl.DriversInfor;
import businesslogicservice.inforManagementblservice.DriversInforblservice;
import presentation.reuse.DateChooser;
import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;
import state.Gender;
import vo.documentsVO.PaymentOrderVO;
import vo.inforManagementVO.DriversVO;

public class Driversui extends ParentDocuments{
	public JLabel drivers;
	public JLabel birthDate;
	public JTextField birthDateField;
	public DateChooser birthDateChooser;
	public JLabel limitDate;
	public JTextField limitDateField;
	public DateChooser limitDateChooser;
	public JLabel name;
	public JTextField nameField;
	public JLabel sex;
	public JComboBox sexType;
	String sexTypeValue="男";
	Gender sexTypeSeletion=Gender.MALE;
	public JLabel idCard;
	public JTextField idCardField;
	public JLabel phone;
	public JTextField phoneField;
	DriversInforblservice driversInforblservice;
	DriversVO driversVO;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		Driversui uiPanel=new Driversui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public Driversui(){
		drivers=new JLabel();
		birthDate=new JLabel();
		birthDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		birthDateField = new JTextField("单击选择日期");
		limitDate=new JLabel();
		limitDateChooser = DateChooser.getInstance("yyyy-MM-dd");
		limitDateField = new JTextField("单击选择日期");
		name=new JLabel();
		nameField=new JTextField();
		sex=new JLabel();
		String[] sexTypeEntries={"男","女"};
		sexType=new JComboBox(sexTypeEntries);
		idCard=new JLabel();
		idCardField=new JTextField();
		phone=new JLabel();
		phoneField=new JTextField();
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		drivers.setBounds(218,10,180,30);
		drivers.setText("司机信息");
		drivers.setHorizontalAlignment(SwingConstants.CENTER);
		drivers.setFont(font1);
		drivers.setBackground(Color.WHITE);
		
		sex.setBounds(40,80,90,24);
		sex.setText("性别：");
		sex.setFont(font2);
		sex.setBackground(Color.WHITE);
		
		sexType.setBounds(130,80,90,24);
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
		
		limitDate.setBounds(40,200,90,24);
		limitDate.setText("行驶证期限：");
		limitDate.setFont(font2);
		limitDate.setBackground(Color.WHITE);
		
		limitDateField.setBounds(130,202,120,20);
		limitDateChooser.register(limitDateField);
		
		name.setBounds(40,50,90,24);
		name.setText("姓名：");
		name.setFont(font2);
		name.setBackground(Color.WHITE);
		
		nameField.setBounds(130,52,100,20);
		
		idCard.setBounds(40,140,90,24);
		idCard.setText("身份证号：");
		idCard.setFont(font2);
		idCard.setBackground(Color.WHITE);
		
		idCardField.setBounds(130,142,160,20);
		
		phone.setBounds(40,170,90,24);
		phone.setText("手机：");
		phone.setFont(font2);
		phone.setBackground(Color.WHITE);
		
		phoneField.setBounds(130,172,160,20);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				driversInforblservice=new DriversInfor();
				driversVO.setName(nameField.getText());
				driversVO.setGender(sexTypeSeletion);
				driversVO.setBirthDate(birthDateField.getText());
				driversVO.setDriveLimitDate(limitDateField.getText());
				driversVO.setIdentyNum(idCardField.getText());
				driversVO.setPhone(phoneField.getText());
				javaBean1=driversInforblservice.add(driversVO);
				driversVO=(DriversVO)javaBean1.getObject();
				docmID.setText(driversVO.getID());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				driversInforblservice=new DriversInfor();
				driversVO.setName(nameField.getText());
				driversVO.setGender(sexTypeSeletion);
				driversVO.setBirthDate(birthDateField.getText());
				driversVO.setDriveLimitDate(limitDateField.getText());
				driversVO.setIdentyNum(idCardField.getText());
				driversVO.setPhone(phoneField.getText());
				modifyOrder.setVisible(false);
				driversInforblservice.modify(driversVO);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(drivers);
		this.add(birthDate);
		this.add(birthDateField);
		this.add(limitDate);
		this.add(limitDateField);
		this.add(name);
		this.add(nameField);
		this.add(sex);
		this.add(sexType);
		this.add(idCard);
		this.add(idCardField);
		this.add(phone);
		this.add(phoneField);
	}
	public void refresh(){
		birthDateField.setEditable(false);
		limitDateField.setEditable(false);
		nameField.setEditable(false);
		sexType.setEnabled(false);
		idCardField.setEditable(false);
		phoneField.setEditable(false);
		
		birthDateField.setBackground(Color.white);
		limitDateField.setBackground(Color.white);
		nameField.setBackground(Color.white);
		idCardField.setBackground(Color.white);
		phoneField.setBackground(Color.white);
		
		birthDateField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		limitDateField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		idCardField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		phoneField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
	}
	public void modifying(){
		birthDateField.setEditable(true);
		limitDateField.setEditable(true);
		nameField.setEditable(true);
		sexType.setEnabled(true);
		idCardField.setEditable(true);
		phoneField.setEditable(true);
		modifyOrder.setVisible(true);
		
		birthDateField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		limitDateField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		nameField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		idCardField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		phoneField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
