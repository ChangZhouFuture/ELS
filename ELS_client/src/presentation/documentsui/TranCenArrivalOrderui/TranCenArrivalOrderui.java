package presentation.documentsui.TranCenArrivalOrderui;

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

import presentation.reuse.ParentDocuments;
import presentation.userui.TranCenClerkui;

public class TranCenArrivalOrderui extends ParentDocuments{
	JLabel TranCenArrivalOrder;
	JLabel TranCen;
	JTextField TranCenId;
	JLabel TransferOrder;
	JLabel Departure;
	JTextField TransferOrderId;
	JTextField DepartureField;
	JLabel GoodState;
	JRadioButton Complete;
	JRadioButton Damaged;
	JRadioButton Lost;
	ButtonGroup GoodStateGroup;
	JLabel Remarks;
	JTextArea RemarksArea;
	JScrollPane scroller;
	
	public static void main(String[] args){
		TranCenClerkui ui=new TranCenClerkui();
		TranCenArrivalOrderui uiPanel=new TranCenArrivalOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public TranCenArrivalOrderui(){
		TranCenArrivalOrder=new JLabel();
		Departure=new JLabel();
		TransferOrder=new JLabel();
		TranCen=new JLabel();
		TranCenId=new JTextField();
		GoodState=new JLabel();
		TransferOrderId=new JTextField();
		DepartureField=new JTextField();
		Complete=new JRadioButton();
		Damaged=new JRadioButton();
		Lost=new JRadioButton();
		GoodStateGroup=new ButtonGroup();
		Remarks=new JLabel();
		RemarksArea=new JTextArea();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		TranCenArrivalOrder.setBounds(218,10,180,30);
		TranCenArrivalOrder.setText("中转中心到达单信息");
		TranCenArrivalOrder.setHorizontalAlignment(SwingConstants.CENTER);
		TranCenArrivalOrder.setFont(font1);
		TranCenArrivalOrder.setBackground(Color.WHITE);
		TranCenArrivalOrder.setOpaque(true);
		
		TranCen.setBounds(40,50,120,24);
		TranCen.setText("中转中心编号：");
		TranCen.setFont(font2);
		TranCen.setBackground(Color.WHITE);
		TranCen.setOpaque(true);
		
		TranCenId.setBounds(140,52,150,20);
		
		TransferOrder.setBounds(40,80,120,24);
		TransferOrder.setText("中转单编号：");
		TransferOrder.setFont(font2);
		TransferOrder.setBackground(Color.WHITE);
		TransferOrder.setOpaque(true);
		
		TransferOrderId.setBounds(140,82,150,20);
		
		Departure.setBounds(40,110,120,24);
		Departure.setText("出发地：");
		Departure.setFont(font2);
		Departure.setBackground(Color.WHITE);
		Departure.setOpaque(true);
		
		DepartureField.setBounds(140,112,150,20);
		
		GoodState.setBounds(40,140,120,24);
		GoodState.setText("货物到达状态：");
		GoodState.setFont(font2);
		GoodState.setBackground(Color.WHITE);
		GoodState.setOpaque(true);
		
		Complete.setBounds(140,170,150,24);
		Complete.setText("完整");
		Complete.setFont(font2);
		Complete.setBackground(Color.WHITE);
		
		Damaged.setBounds(140,200,150,24);
		Damaged.setText("损坏");
		Damaged.setFont(font2);
		Damaged.setBackground(Color.WHITE);
		
		Lost.setBounds(140,230,150,24);
		Lost.setText("丢失");
		Lost.setFont(font2);
		Lost.setBackground(Color.WHITE); 
		
		GoodStateGroup.add(Complete);
		GoodStateGroup.add(Damaged);
		GoodStateGroup.add(Lost);
		
		Remarks.setBounds(300,140,120,24);
		Remarks.setText("备注：");
		Remarks.setFont(font2);
		Remarks.setBackground(Color.WHITE);
		Remarks.setOpaque(true);
		
		RemarksArea.setBounds(330,170,190,100);
		RemarksArea.setFont(font2);
		RemarksArea.setEnabled(true);
		RemarksArea.setWrapStyleWord(true);
		RemarksArea.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		RemarksArea.setLineWrap(true);
		
		scroller=new JScrollPane(RemarksArea);
		scroller.setBounds(330,170,190,100);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(TranCenArrivalOrder);
		this.add(TransferOrder);
		this.add(TranCen);
		this.add(TranCenId);
		this.add(Departure);
		this.add(GoodState);
		this.add(Complete);
		this.add(Damaged);
		this.add(Lost);
		this.add(Remarks);
		this.add(scroller);
		this.add(TransferOrderId);
		this.add(DepartureField);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
}
