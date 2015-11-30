package presentation.documentsui.BusiHallArrivalOrderui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import presentation.documentsui.DeliveryOrderui.DeliveryOrderui;
import presentation.userui.BusiHallClerkui;

public class BusiHallArrivalOrderui extends JPanel{
	JLabel BusiHallArrivalOrder;
	JLabel TransferOrder;
	JLabel Departure;
	JTextField TransferOrderId;
	JTextField DepartureName;
	JLabel GoodState;
	JButton MakeOrder;
	JRadioButton Complete;
	JRadioButton Damaged;
	JRadioButton Lost;
	ButtonGroup GoodStateGroup;
	JLabel Remarks;
	JTextArea RemarksArea;
	JScrollPane scroller;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		BusiHallArrivalOrderui uiPanel=new BusiHallArrivalOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public BusiHallArrivalOrderui(){
		BusiHallArrivalOrder=new JLabel();
		Departure=new JLabel();
		MakeOrder=new JButton();
		TransferOrder=new JLabel();
		GoodState=new JLabel();
		TransferOrderId=new JTextField();
		DepartureName=new JTextField();
		Complete=new JRadioButton();
		Damaged=new JRadioButton();
		Lost=new JRadioButton();
		GoodStateGroup=new ButtonGroup();
		Remarks=new JLabel();
		RemarksArea=new JTextArea();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		BusiHallArrivalOrder.setBounds(218,10,180,30);
		BusiHallArrivalOrder.setText("营业厅到达单信息");
		BusiHallArrivalOrder.setHorizontalAlignment(SwingConstants.CENTER);
		BusiHallArrivalOrder.setFont(font1);
		BusiHallArrivalOrder.setBackground(Color.WHITE);
		BusiHallArrivalOrder.setOpaque(true);
		
		TransferOrder.setBounds(40,50,120,24);
		TransferOrder.setText("中转单编号：");
		TransferOrder.setFont(font2);
		TransferOrder.setBackground(Color.WHITE);
		TransferOrder.setOpaque(true);
		
		TransferOrderId.setBounds(140,52,150,20);
		
		Departure.setBounds(40,80,120,24);
		Departure.setText("出发地：");
		Departure.setFont(font2);
		Departure.setBackground(Color.WHITE);
		Departure.setOpaque(true);
		
		DepartureName.setBounds(140,82,150,20);
		
		GoodState.setBounds(40,110,120,24);
		GoodState.setText("货物到达状态：");
		GoodState.setFont(font2);
		GoodState.setBackground(Color.WHITE);
		GoodState.setOpaque(true);
		
		Complete.setBounds(140,140,150,24);
		Complete.setText("完整");
		Complete.setFont(font2);
		Complete.setBackground(Color.WHITE);
		
		Damaged.setBounds(140,170,150,24);
		Damaged.setText("损坏");
		Damaged.setFont(font2);
		Damaged.setBackground(Color.WHITE);
		
		Lost.setBounds(140,200,150,24);
		Lost.setText("丢失");
		Lost.setFont(font2);
		Lost.setBackground(Color.WHITE); 
		
		GoodStateGroup.add(Complete);
		GoodStateGroup.add(Damaged);
		GoodStateGroup.add(Lost);
		
		Remarks.setBounds(300,110,120,24);
		Remarks.setText("备注：");
		Remarks.setFont(font2);
		Remarks.setBackground(Color.WHITE);
		Remarks.setOpaque(true);
		
		RemarksArea.setBounds(330,140,190,100);
		RemarksArea.setFont(font2);
		RemarksArea.setEnabled(true);
		RemarksArea.setWrapStyleWord(true);
		RemarksArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		RemarksArea.setLineWrap(true);
		
		scroller=new JScrollPane(RemarksArea);
		scroller.setBounds(330,140,190,100);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		MakeOrder.setBounds(260,442,96,30);
		MakeOrder.setText("确认生成");
		MakeOrder.setFont(font1);
		MakeOrder.setBackground(Color.WHITE);
		MakeOrder.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		this.add(BusiHallArrivalOrder);
		this.add(TransferOrder);
		this.add(Departure);
		this.add(GoodState);
		this.add(Complete);
		this.add(Damaged);
		this.add(Lost);
		this.add(Remarks);
		this.add(scroller);
		this.add(TransferOrderId);
		this.add(DepartureName);
		this.add(MakeOrder);
		setLocation(184,30);
		this.setSize(616,490);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
