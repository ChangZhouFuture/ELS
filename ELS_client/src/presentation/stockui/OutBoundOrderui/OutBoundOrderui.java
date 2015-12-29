package presentation.stockui.OutBoundOrderui;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import bean.JavaBean1;
import businesslogic.stockbl.OutBoundOrder;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
import presentation.reuse.ParentDocuments;
import presentation.userui.StockManagerui;
import state.TransportType;
import vo.stockVO.OutBoundOrderVO;

public class OutBoundOrderui extends ParentDocuments{
	public JLabel outBoundOrder;
	public JLabel transportType;
	public JComboBox transportTypeType;
	String transportTypeValue="公路";
	TransportType transportTypeSeletion=TransportType.Truck;
	public JLabel orderId;
	public JTextField orderIdField;
	public JLabel destination;
	public JTextField destinationField;
	public JLabel tranOrMotorId;
	public JTextField tranOrMotorIdField;
	JavaBean1 javaBean1;
	OutBoundOrderblservice outBoundOrderblservice;
	public OutBoundOrderVO outBoundOrderVO;
	
	public static void main(String[] args){
		StockManagerui ui=new StockManagerui();
		OutBoundOrderui uiPanel=new OutBoundOrderui();
		JLayeredPane layeredPane=ui.getLayeredPane();
		layeredPane.add(uiPanel,0);
	}
	
	public OutBoundOrderui(){
		outBoundOrder=new JLabel();
		transportType=new JLabel();
		String[] transportTypeEntries={"公路","铁路","飞机"};
		transportTypeType=new JComboBox(transportTypeEntries);
		orderId=new JLabel();
		orderIdField=new JTextField();
		destination=new JLabel();
		destinationField=new JTextField();
		tranOrMotorId=new JLabel();
		tranOrMotorIdField=new JTextField();
		
		this.setLayout(null);
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		outBoundOrder.setBounds(218,10,180,30);
		outBoundOrder.setText("出库单信息");
		outBoundOrder.setHorizontalAlignment(SwingConstants.CENTER);
		outBoundOrder.setFont(font1);
		outBoundOrder.setBackground(Color.WHITE);
		outBoundOrder.setOpaque(true);
		
		transportType.setBounds(40,50,100,24);
		transportType.setText("装运形式：");
		transportType.setFont(font2);
		transportType.setBackground(Color.WHITE);
		transportType.setOpaque(true);
		
		transportTypeType.setBounds(140,50,100,24);
		transportTypeType.setFont(font2);
		transportTypeType.setBackground(Color.WHITE);
		transportTypeType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					transportTypeValue=(String)transportTypeType.getSelectedItem();
					switch(transportTypeValue){
					case "公路":transportTypeSeletion=TransportType.Truck;break;
					case "铁路":transportTypeSeletion=TransportType.Train;break;
					case "飞机":transportTypeSeletion=TransportType.Plane;break;
						default:break;
					}
					System.out.println(transportTypeValue);
				} 
			}
		});
		
		orderId.setBounds(40,80,100,24);
		orderId.setText("快递编号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		
		orderIdField.setBounds(140,82,150,20);
		
		destination.setBounds(40,110,100,24);
		destination.setText("目的地：");
		destination.setFont(font2);
		destination.setBackground(Color.WHITE);
		
		destinationField.setBounds(140,112,150,20);
		
		tranOrMotorId.setBounds(40,140,200,24);
		tranOrMotorId.setText("中转单编号或汽运编号：");
		tranOrMotorId.setFont(font2);
		tranOrMotorId.setBackground(Color.WHITE);
		
		tranOrMotorIdField.setBounds(140,172,150,20);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(1);
				refresh();
				approState.setText("未审批");
				outBoundOrderblservice=new OutBoundOrder();
				outBoundOrderVO.setTransportType(transportTypeSeletion);
				outBoundOrderVO.setDestination(destinationField.getText());
				outBoundOrderVO.setOrderID(orderIdField.getText());
				outBoundOrderVO.setTruckNum(tranOrMotorIdField.getText());
				javaBean1=outBoundOrderblservice.add(outBoundOrderVO);
				outBoundOrderVO=(OutBoundOrderVO)javaBean1.getObject();
				docmID.setText(outBoundOrderVO.getId());
				docmDate.setText(outBoundOrderVO.getOutDate());
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				outBoundOrderblservice=new OutBoundOrder();
				outBoundOrderVO.setTransportType(transportTypeSeletion);
				outBoundOrderVO.setDestination(destinationField.getText());
				outBoundOrderVO.setOrderID(orderIdField.getText());
				outBoundOrderVO.setTruckNum(tranOrMotorIdField.getText());
				javaBean1=outBoundOrderblservice.modify(outBoundOrderVO);
				outBoundOrderVO=(OutBoundOrderVO)javaBean1.getObject();
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(outBoundOrder);
		this.add(transportType);
		this.add(transportTypeType);
		this.add(orderId);
		this.add(orderIdField);
		this.add(destination);
		this.add(destinationField);
		this.add(tranOrMotorId);
		this.add(tranOrMotorIdField);
	}
	public void refresh() {
		orderIdField.setEditable(false);
		destinationField.setEditable(false);
		tranOrMotorIdField.setEditable(false);
		transportTypeType.setEnabled(false);
		
		destinationField.setBackground(Color.white);
		tranOrMotorIdField.setBackground(Color.white);
		orderIdField.setBackground(Color.white);
		
		destinationField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tranOrMotorIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		orderIdField.setEditable(true);
		destinationField.setVisible(true);
		tranOrMotorIdField.setVisible(true);
		transportTypeType.setEnabled(true);
		modifyOrder.setVisible(true);
		
		destinationField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		tranOrMotorIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
