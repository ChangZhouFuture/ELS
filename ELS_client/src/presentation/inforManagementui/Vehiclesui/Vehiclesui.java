package presentation.inforManagementui.Vehiclesui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Vehiclesui extends JPanel{
	public JLabel vehicles;
	public JLabel city;
	public JLabel region;
	public JLabel plateNum;
	public JLabel serviceTime;
	public JTextField cityField;
	public JTextField regionField;
	public JTextField plateNumField;
	public JTextField serviceTimeField;
	public JButton makeOrder;
	public JButton modify;
	public JButton modifyOrder;
	public JButton delete;
	
	public Vehiclesui(){
		vehicles=new JLabel();
		city=new JLabel();
		region=new JLabel();
		plateNum=new JLabel();
		serviceTime=new JLabel();
		cityField=new JTextField();
		regionField=new JTextField();
		plateNumField=new JTextField();
		serviceTimeField=new JTextField();
		makeOrder=new JButton();
		modify=new JButton();
		modifyOrder=new JButton();
		delete=new JButton();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		
		vehicles.setBounds(218,10,180,30);
		vehicles.setText("≥µ¡æ–≈œ¢");
		vehicles.setHorizontalAlignment(SwingConstants.CENTER);
		vehicles.setFont(font1);
		vehicles.setBackground(Color.WHITE);
		vehicles.setOpaque(true);
		
		this.add(vehicles);
		this.add(city);
		this.add(region);
		this.add(plateNum);
		this.add(serviceTime);
		this.add(cityField);
		this.add(regionField);
		this.add(plateNumField);
		this.add(serviceTimeField);
		this.add(makeOrder);
		this.add(modify);
		this.add(modifyOrder);
		this.add(delete);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
