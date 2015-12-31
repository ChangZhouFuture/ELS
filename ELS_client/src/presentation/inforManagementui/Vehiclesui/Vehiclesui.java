package presentation.inforManagementui.Vehiclesui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bean.JavaBean1;
import businesslogic.inforManagementbl.DriversInfor;
import businesslogic.inforManagementbl.VehiclesInfor;
import businesslogicservice.inforManagementblservice.VehiclesInforblservice;
import presentation.reuse.Images;
import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import vo.inforManagementVO.DriversVO;
import vo.inforManagementVO.VehiclesVO;

public class Vehiclesui extends ParentDocuments{
	public JLabel vehicles;
	public JLabel plateNum;
	public JLabel serviceTime;
	public JTextField plateNumField;
	public JTextField serviceTimeField;
	VehiclesInforblservice vehiclesInforblservice;
	public VehiclesVO vehiclesVO;
	JavaBean1 javaBean1;
	
	public Vehiclesui(){
		vehicles=new JLabel();
		plateNum=new JLabel();
		serviceTime=new JLabel();
		plateNumField=new JTextField();
		serviceTimeField=new JTextField();
		vehiclesVO=new VehiclesVO();
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		vehicles.setBounds(218,10,180,30);
		vehicles.setText("车辆信息");
		vehicles.setHorizontalAlignment(SwingConstants.CENTER);
		vehicles.setFont(font1);
		vehicles.setBackground(Color.WHITE);
		
		plateNum.setBounds(40,50,120,24);
		plateNum.setText("车牌号：");
		plateNum.setFont(font2);
		plateNum.setBackground(Color.WHITE);
		
		plateNumField.setBounds(160,52,120,20);

		serviceTime.setBounds(40,80,120,24);
		serviceTime.setText("服役时间：");
		serviceTime.setFont(font2);
		serviceTime.setBackground(Color.WHITE);
		
		serviceTimeField.setBounds(160,82,120,20);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				vehiclesInforblservice=new VehiclesInfor();
				vehiclesVO.setPlateNum(plateNumField.getText());
				vehiclesVO.setServiceTime(serviceTimeField.getText());
				vehiclesVO.setBusiHallID(Loginui.agency);
				javaBean1=vehiclesInforblservice.add(vehiclesVO);
				vehiclesVO=(VehiclesVO)javaBean1.getObject();
				docmID.setText(vehiclesVO.getID());
				makeOrder.setEnabled(false);
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				vehiclesInforblservice=new VehiclesInfor();
				vehiclesVO.setPlateNum(plateNumField.getText());
				vehiclesVO.setServiceTime(serviceTimeField.getText());
				vehiclesVO.setBusiHallID(Loginui.agency);
				vehiclesInforblservice.modify(vehiclesVO);
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(vehicles);
		this.add(plateNum);
		this.add(serviceTime);
		this.add(plateNumField);
		this.add(serviceTimeField);
	}
	public void refresh(){
		plateNumField.setEditable(false);
		serviceTimeField.setEditable(false);
		
		plateNumField.setBackground(Color.white);
		serviceTimeField.setBackground(Color.white);
		
		plateNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		serviceTimeField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying(){
		plateNumField.setEditable(true);
		serviceTimeField.setEditable(true);
		modifyOrder.setVisible(true);
		
		plateNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		serviceTimeField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
