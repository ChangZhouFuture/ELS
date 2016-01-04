package presentation.documentsui.TranCenArrivalOrderui;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import bean.JavaBean1;
import businesslogic.documentsbl.TranCenArrivalOrder;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.Loginui;
import presentation.userui.TranCenClerkui;
import state.GoodState;
import vo.documentsVO.TranCenArrivalOrderVO;

public class TranCenArrivalOrderui extends ParentDocuments{
	public JLabel tranCenArrivalOrder;
	public JLabel tranCen;
	public JTextField tranCenId;
	public JLabel transferOrder;
	public JLabel departure;
	public JTextField transferOrderId;
	public JTextField departureField;
	public JLabel goodState;
	public JComboBox goodStateType;
	public String goodStateValue="完整";
	public GoodState goodStateSeletion=GoodState.COMPLETE;
	JScrollPane scroller;
	JavaBean1 javaBean1;
	TranCenArrivalOrderblservice tranCenArrivalOrderblservice;
	public TranCenArrivalOrderVO tranCenArrivalOrderVO;
	
	public TranCenArrivalOrderui(){
		tranCenArrivalOrder=new JLabel();
		departure=new JLabel();
		transferOrder=new JLabel();
		tranCen=new JLabel();
		tranCenId=new JTextField();
		goodState=new JLabel();
		transferOrderId=new JTextField();
		departureField=new JTextField();
		String[] goodStateEntries={"完整","损坏","丢失"};
		goodStateType=new JComboBox(goodStateEntries);
		tranCenArrivalOrderVO=new TranCenArrivalOrderVO();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		tranCenArrivalOrder.setBounds(218,10,180,30);
		tranCenArrivalOrder.setText("中转中心到达单信息");
		tranCenArrivalOrder.setHorizontalAlignment(SwingConstants.CENTER);
		tranCenArrivalOrder.setFont(font1);
		tranCenArrivalOrder.setBackground(Color.WHITE);
		
		tranCen.setBounds(40,50,120,24);
		tranCen.setText("中转中心编号：");
		tranCen.setFont(font2);
		tranCen.setBackground(Color.WHITE);
		
		tranCenId.setBounds(140,52,150,20);
		tranCenId.setEditable(false);
		tranCenId.setBackground(Color.WHITE);
		tranCenId.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tranCenId.setText(Loginui.agency);
		tranCenId.setFont(font2);
		
		transferOrder.setBounds(40,80,120,24);
		transferOrder.setText("中转单编号：");
		transferOrder.setFont(font2);
		transferOrder.setBackground(Color.WHITE);
		
		transferOrderId.setBounds(140,82,150,20);
		
		departure.setBounds(40,110,120,24);
		departure.setText("出发地：");
		departure.setFont(font2);
		departure.setBackground(Color.WHITE);
		
		departureField.setBounds(140,112,150,20);
		departureField.setEditable(false);
		departureField.setBackground(Color.WHITE);
		departureField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		departureField.setFont(font2);
		
		goodState.setBounds(40,140,120,24);
		goodState.setText("货物到达状态：");
		goodState.setFont(font2);
		goodState.setBackground(Color.WHITE);
		
		goodStateType.setBounds(160,140,150,24);
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
				tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				tranCenArrivalOrderVO.setTranCenID(Loginui.agency);
				tranCenArrivalOrderVO.setTransferOrderID(transferOrderId.getText());
				tranCenArrivalOrderVO.setGoodState(goodStateSeletion);
				javaBean1=tranCenArrivalOrderblservice.addTranCenArivalOrder(tranCenArrivalOrderVO);
				tranCenArrivalOrderVO=(TranCenArrivalOrderVO)javaBean1.getObject();
				docmID.setText(tranCenArrivalOrderVO.getID());
				docmDate.setText(tranCenArrivalOrderVO.getArrivalDate());
				departureField.setText(tranCenArrivalOrderVO.getOrigin());
				makeOrder.setEnabled(false);
			}
		});
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				tranCenArrivalOrderblservice=new TranCenArrivalOrder();
				tranCenArrivalOrderVO.setTranCenID(Loginui.agency);
				tranCenArrivalOrderVO.setTransferOrderID(transferOrderId.getText());
				tranCenArrivalOrderVO.setGoodState(goodStateSeletion);
				javaBean1=tranCenArrivalOrderblservice.modify(tranCenArrivalOrderVO);
				tranCenArrivalOrderVO=(TranCenArrivalOrderVO)javaBean1.getObject();
				docmDate.setText(tranCenArrivalOrderVO.getArrivalDate());
				departureField.setText(tranCenArrivalOrderVO.getOrigin());
			}
		});
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(tranCenArrivalOrder);
		this.add(transferOrder);
		this.add(tranCen);
		this.add(tranCenId);
		this.add(departure);
		this.add(goodState);
		this.add(goodStateType);
		this.add(transferOrderId);
		this.add(departureField);
	}
	public void refresh() {
		transferOrderId.setEditable(false);
		goodStateType.setEnabled(false);
		
		transferOrderId.setBackground(Color.white);
		
		transferOrderId.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		transferOrderId.setEditable(true);
		goodStateType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		transferOrderId.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
