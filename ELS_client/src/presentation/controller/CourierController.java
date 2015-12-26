package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.Orderblservice;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.userui.Courierui;
import presentation.userui.Loginui;
import state.ExpressArrivalStatus;
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
		courierui.userName.setText("快递员："+Loginui.name);
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
				Skip.skip(mainPanel,childPanel);
				inOrderui();
			}
		});
		orderListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					orderblservice=new Order();
					javaBean1=new JavaBean1();
					javaBean1=orderblservice.inquireA(orderListui.idField.getText());
					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
					orderVO=(OrderVO)javaBean1.getObject();
					orderui=find(orderVO);
					childPanel = orderui;
					Skip.skip(mainPanel,childPanel);
					inOrderui();
			}
		});
		orderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)orderListui.tableModel.
                			getValueAt(orderListui.table.getSelectedRow(),1);
                	try {
                		orderblservice=new Order();
                		javaBean1=new JavaBean1();
    					javaBean1=orderblservice.inquireA(id);
    					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
    						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
    					}
    					orderVO=(OrderVO)javaBean1.getObject();
    					orderui=find(orderVO);
    					childPanel = orderui;
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
		
		orderui.refresh();
		orderui.senderNameField.setText(orderVO.getSenderName());
		orderui.senderAddressField.setText(orderVO.getSenderAdd());
		orderui.senderCompanyField.setText(orderVO.getSenderCompany());
		orderui.senderPhoneField.setText(orderVO.getSenderPhoneNumber());
		orderui.receiverNameField.setText(orderVO.getAddresseeName());
		orderui.receiverAddressField.setText(orderVO.getAddresseeAdd());
		orderui.receiverCompanyField.setText(orderVO.getAddresseeCompany());
		orderui.receiverPhoneField.setText(orderVO.getAddresseePhoneNumber());
		orderui.goodNumField.setText(String.valueOf(orderVO.getNumOfGoods()));
		orderui.goodNameField.setText(orderVO.getGoodsName());
		orderui.goodWeightField.setText(String.valueOf(orderVO.getWeight()));
		orderui.goodSizeField.setText(String.valueOf(orderVO.getSize()));
		if(orderVO.getPackingCharge()==5.0){
			orderui.packType.setSelectedIndex(0);
		}else if(orderVO.getPackingCharge()==10.0){
			orderui.packType.setSelectedIndex(1);
		}else if(orderVO.getPackingCharge()==1.0){
			orderui.packType.setSelectedIndex(2);
		}
		switch(orderVO.getExpressType()){
		case Economic:orderui.expressTypeType.setSelectedIndex(0);break;
		case Standard:orderui.expressTypeType.setSelectedIndex(1);break;
		case EMS:orderui.expressTypeType.setSelectedIndex(2);break;
		default:break;
		}
		switch(orderVO.getApproState()){
		case Approve:orderui.approState.setText("已审批");break;
		case NotApprove:orderui.approState.setText("未审批");break;
			default:break;
		}
		orderui.freightField.setText(String.valueOf(orderVO.getFreight()));
		orderui.amountField.setText(String.valueOf(orderVO.getTotalCost()));
		orderui.expectedArrivalDate.setText("预计到达时间："+orderVO.getExpectedArrivalDate());
		
		orderui.sureReceive.setVisible(true);
		if(orderVO.getExpressArrivalStatus()!=ExpressArrivalStatus.NotArrival){
			orderui.actualReceiver.setVisible(true);
			orderui.sureReceive.setVisible(false);
			orderui.actualReceiverField.setText(String.valueOf(orderVO.getTrueAddressee()));
			orderui.trueArrivalDate.setVisible(true);
			orderui.trueArrivalDateField.setText(orderVO.getArrivalDate());
		}
		orderui.docmID.setText(orderVO.getId());
		return orderui;
	}
	public void inOrderui() {
		orderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=orderui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				orderblservice=new Order();
				orderblservice.deleteMany(deletearray);
				orderListui = new OrderListui();
				childPanel = orderListui;
				Skip.skip(mainPanel,childPanel);
				inOrderListui();
			}
		});
	}
	public static void main(String[] args) {
		CourierController courierController = new CourierController();
	}
}

