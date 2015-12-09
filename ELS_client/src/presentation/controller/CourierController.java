package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.userui.Courierui;
import state.ExpressType;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;

public class CourierController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Courierui courierui;
	OrderListui orderListui;
	Orderui orderui;
	Orderblservice orderblservice;
	JavaBean1 javaBean1;
	OrderVO orderVO;
	
	public CourierController(){
		courierui = new Courierui();
		orderListui = new OrderListui();
		orderListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(orderListui);
		JLayeredPane layeredPane = courierui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inCourierui();
		inOrderListui();
	}
	public void inCourierui() {
		courierui.orderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = new OrderListui();
				childPanel = orderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOrderListui();
			}
		});
	}
	public void inOrderListui() {
		orderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderListui = null;
				orderui = new Orderui();
				childPanel = orderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOrderui();
			}
		});
		orderListui.findById.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					orderblservice=new Order();
					javaBean1=orderblservice.inquireA(orderListui.idField.getText());
					orderVO=(OrderVO)javaBean1.getObject();
					orderui=find(orderVO);
					childPanel = orderui;
					orderui.modify.setVisible(true);
					orderui.delete.setVisible(true);
					orderui.modifyOrder.setVisible(true);
					orderui.makeOrder.setVisible(false);
					childPanel.setLocation(0,0);
					Skip.skip(mainPanel,childPanel);
					inOrderui();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		orderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)orderListui.tableModel.getValueAt(orderListui.table.getSelectedRow(),1);
                	try {
    					javaBean1=orderblservice.inquireA(id);
    					orderVO=(OrderVO)javaBean1.getObject();
    					orderui=find(orderVO);
    					childPanel = orderui;
    					orderui.modify.setVisible(true);
    					orderui.delete.setVisible(true);
    					orderui.modifyOrder.setVisible(true);
    					orderui.makeOrder.setVisible(false);
    					childPanel.setLocation(0,0);
    					Skip.skip(mainPanel,childPanel);
    					inOrderui();
    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}
                }
             }
        });
	}
	public Orderui find(OrderVO orderVO){
		orderui = new Orderui();
		orderui.senderNameField.setText(orderVO.getSenderName());
		orderui.senderNameField.setEditable(false);
					
		orderui.senderAddressField.setText(orderVO.getSenderAdd());
		orderui.senderAddressField.setEditable(false);
					
		orderui.senderCompanyField.setText(orderVO.getSenderCompany());
		orderui.senderCompanyField.setEditable(false);
					
		orderui.senderPhoneField.setText(orderVO.getSenderPhoneNumber());
		orderui.senderPhoneField.setEditable(false);
					
		orderui.receiverNameField.setText(orderVO.getAddresseeName());
		orderui.receiverNameField.setEditable(false);
					
		orderui.receiverAddressField.setText(orderVO.getAddresseeAdd());
		orderui.receiverAddressField.setEditable(false);
					
		orderui.receiverCompanyField.setText(orderVO.getAddresseeCompany());
		orderui.receiverCompanyField.setEditable(false);
					
		orderui.receiverPhoneField.setText(orderVO.getAddresseePhoneNumber());
		orderui.receiverPhoneField.setEditable(false);
					
		orderui.goodNumField.setText(String.valueOf(orderVO.getNumOfGoods()));
		orderui.goodNumField.setEditable(false);
					
		orderui.goodNameField.setText(orderVO.getGoodsName());
		orderui.goodNameField.setEditable(false);
					
		orderui.goodWeightField.setText(String.valueOf(orderVO.getWeight()));
		orderui.goodWeightField.setEditable(false);
					
		orderui.goodVolumeField.setText(String.valueOf(orderVO.getSize()));
		orderui.goodVolumeField.setEditable(false);
					
		orderui.carriageField.setText(String.valueOf(orderVO.getTotalCost()));
		orderui.carriageField.setEditable(false);
					
		orderui.expectedArrivalDateField.setText(orderVO.getExpectedArrivalDate());
		orderui.expectedArrivalDateField.setEditable(false);
					
		orderui.carriageField.setText(String.valueOf(orderVO.getTotalCost()));
		orderui.carriageField.setEditable(false);
					
		if(orderVO.getTrueAddressee()!=null){
			orderui.actualReceiver.setVisible(true);
			orderui.actualReceiverField.setText(String.valueOf(orderVO.getTrueAddressee()));
		}
					
		if(orderVO.getArrivalDate()!=null){
			orderui.trueArrivalDate.setVisible(true);
			orderui.trueArrivalDateField.setText(orderVO.getArrivalDate());
		}
		if(orderVO.getNumOfBags()!=0){
			orderui.bag.setSelected(true);
		}
		if(orderVO.getNumOfWoodenBox()!=0){
			orderui.wood.setSelected(true);
		}
		if(orderVO.getNumOfCartons()!=0){
			orderui.paper.setSelected(true);
		}
		if(orderVO.getExpressType()==ExpressType.Economic){
			orderui.economic.setSelected(true);
		}else if(orderVO.getExpressType()==ExpressType.Standard){
			orderui.standard.setSelected(true);
		}else if(orderVO.getExpressType()==ExpressType.EMS){
			orderui.eMS.setSelected(true);
		}
		return orderui;
	}
	public void inOrderui() {
		orderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String deleteId=orderVO.getId();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				orderblservice.deleteMany(deletearray);
				orderListui = new OrderListui();
				childPanel = orderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOrderListui();
			}
		});
	}
	public static void main(String[] args) {
		CourierController courierController = new CourierController();
	}
}

