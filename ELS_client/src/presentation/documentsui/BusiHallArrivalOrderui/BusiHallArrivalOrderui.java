package presentation.documentsui.BusiHallArrivalOrderui;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import bean.JavaBean1;
import businesslogic.documentsbl.BusiHallArrivalOrder;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import state.GoodState;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.orderVO.OrderVO;

public class BusiHallArrivalOrderui extends ParentDocuments{
	public JLabel busiHallArrivalOrder;
	public JLabel transferOrder;
	public JLabel departure;
	public JTextField transferOrderField;
	public JTextField departureField;
	public JLabel goodState;
	public JComboBox goodStateType;
	public String goodStateValue="完整";
	public GoodState goodStateSeletion=GoodState.COMPLETE;
	public BusiHallArrivalOrderblservice busiHallArrivalOrderblservice;
	public BusiHallArrivalOrderVO busiHallArrivalOrderVO;
	JavaBean1 javaBean1;
	
	public static void main(String[] args){
		BusiHallClerkui ui=new BusiHallClerkui();
		BusiHallArrivalOrderui uiPanel=new BusiHallArrivalOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	public BusiHallArrivalOrderui(){
		busiHallArrivalOrder=new JLabel();
		departure=new JLabel();
		transferOrder=new JLabel();
		goodState=new JLabel();
		transferOrderField=new JTextField();
		departureField=new JTextField();
		String[] goodStateEntries={"完整","损坏","丢失"};
		goodStateType=new JComboBox(goodStateEntries);
		busiHallArrivalOrderVO=new BusiHallArrivalOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		busiHallArrivalOrder.setBounds(218,10,180,30);
		busiHallArrivalOrder.setText("营业厅到达单信息");
		busiHallArrivalOrder.setHorizontalAlignment(SwingConstants.CENTER);
		busiHallArrivalOrder.setFont(font1);
		busiHallArrivalOrder.setBackground(Color.WHITE);
		busiHallArrivalOrder.setOpaque(true);
		
		transferOrder.setBounds(40,50,100,24);
		transferOrder.setText("中转单编号：");
		transferOrder.setFont(font2);
		transferOrder.setBackground(Color.WHITE);
		transferOrder.setOpaque(true);
		
		transferOrderField.setBounds(140,52,150,20);
		
		departure.setBounds(40,80,100,24);
		departure.setText("出发地：");
		departure.setFont(font2);
		departure.setBackground(Color.WHITE);
		departure.setOpaque(true);
		
		departureField.setBounds(140,82,150,20);
		
		goodState.setBounds(40,110,120,24);
		goodState.setText("货物到达状态：");
		goodState.setFont(font2);
		goodState.setBackground(Color.WHITE);
		goodState.setOpaque(true);
		
		goodStateType.setBounds(160,110,100,24);
		goodStateType.setFont(font2);
		goodStateType.setBackground(Color.WHITE);
		goodStateType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					goodStateValue=(String)goodStateType.getSelectedItem();
					try {
						switch(goodStateValue){
						case "完整":goodStateSeletion=GoodState.COMPLETE;break;
						case "损坏":goodStateSeletion=GoodState.BROKE;break;
						case "丢失":goodStateSeletion=GoodState.LOST;break;
						default:break;
						}
					} catch (Exception e) {
						
					}
				} 
			}
		});
		
		makeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				approState.setText("未审批");
				busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				busiHallArrivalOrderVO.setTransferOrderID(transferOrderField.getText());
				busiHallArrivalOrderVO.setOrigin(departureField.getText());
				busiHallArrivalOrderVO.setGoodState(goodStateSeletion);
				busiHallArrivalOrderVO.setBusiHallID(Loginui.agency);
				javaBean1=busiHallArrivalOrderblservice.addBusiHallArrivalOrder(busiHallArrivalOrderVO);
				busiHallArrivalOrderVO=(BusiHallArrivalOrderVO)javaBean1.getObject();
				docmID.setText(busiHallArrivalOrderVO.getId());
				docmDate.setText(busiHallArrivalOrderVO.getArrivalDate());
				makeOrder.setEnabled(false);
			}
		});
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				busiHallArrivalOrderVO.setTransferOrderID(transferOrderField.getText());
				busiHallArrivalOrderVO.setOrigin(departureField.getText());
				busiHallArrivalOrderVO.setGoodState(goodStateSeletion);
				busiHallArrivalOrderVO.setBusiHallID(Loginui.agency);
				javaBean1=busiHallArrivalOrderblservice.modify(busiHallArrivalOrderVO);
				busiHallArrivalOrderVO=(BusiHallArrivalOrderVO)javaBean1.getObject();
			}
		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(busiHallArrivalOrder);
		this.add(transferOrder);
		this.add(departure);
		this.add(goodState);
		this.add(goodStateType);
		this.add(transferOrderField);
		this.add(departureField);
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		this.setOpaque(true);
	}
	public void refresh() {
		transferOrderField.setEditable(false);
		departureField.setEditable(false);
		goodStateType.setEnabled(false);
		
		transferOrderField.setBackground(Color.white);
		departureField.setBackground(Color.white);
		
		transferOrderField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		departureField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		transferOrderField.setEditable(true);
		departureField.setEditable(true);
		goodStateType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		transferOrderField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		departureField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
