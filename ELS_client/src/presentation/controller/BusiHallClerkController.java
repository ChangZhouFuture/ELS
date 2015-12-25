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
import businesslogic.documentsbl.BusiHallArrivalOrder;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
import presentation.documentsui.BusiHallArrivalOrderui.BusiHallArrivalOrderListui;
import presentation.documentsui.BusiHallArrivalOrderui.BusiHallArrivalOrderui;
import presentation.documentsui.BusiHallLoadingListui.BusinessHallLoadingListListui;
import presentation.documentsui.BusiHallLoadingListui.BusinessHallLoadingListui;
import presentation.documentsui.DeliveryOrderui.DeliveryOrderListui;
import presentation.documentsui.DeliveryOrderui.DeliveryOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderListui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.Driversui.DriversListui;
import presentation.inforManagementui.Driversui.Driversui;
import presentation.inforManagementui.Vehiclesui.VehiclesListui;
import presentation.inforManagementui.Vehiclesui.Vehiclesui;
import presentation.orderui.OrderListui;
import presentation.reuse.Skip;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.orderVO.OrderVO;

public class BusiHallClerkController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	BusiHallClerkui busiHallClerkui;
	BusinessHallLoadingListListui businessHallLoadingListListui;
	DriversListui driversListui;
	ReceivablesOrderListui receivablesOrderListui;
	BusiHallArrivalOrderListui busiHallArrivalOrderListui;
	DeliveryOrderListui deliveryOrderListui;
	VehiclesListui vehiclesListui;
	BusinessHallLoadingListui businessHallLoadingListui;
	Driversui driversui;
	ReceivablesOrderui receivablesOrderui;
	BusiHallArrivalOrderui busiHallArrivalOrderui;
	DeliveryOrderui deliveryOrderui;
	Vehiclesui vehiclesui;
	BusiHallArrivalOrderblservice busiHallArrivalOrderblservice;
	BusiHallArrivalOrderVO busiHallArrivalOrderVO;
	JavaBean1 javaBean1;
	
	public BusiHallClerkController(){
		busiHallClerkui = new BusiHallClerkui();
		busiHallClerkui.userName.setText("营业厅业务员："+Loginui.name);
		businessHallLoadingListListui = new BusinessHallLoadingListListui();
		businessHallLoadingListListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(businessHallLoadingListListui);
		JLayeredPane layeredPane = busiHallClerkui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inBusiHallClerkui();
		inBusinessHallLoadingListListui();
	}
	public void inBusiHallClerkui() {
		busiHallClerkui.busiLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				businessHallLoadingListListui= new BusinessHallLoadingListListui();
				childPanel = businessHallLoadingListListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusinessHallLoadingListListui();
			}
		});
		busiHallClerkui.driverManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				driversListui= new DriversListui();
				childPanel = driversListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDriversListui();
			}
		});
		busiHallClerkui.receOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui= new ReceivablesOrderListui();
				childPanel = receivablesOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
		busiHallClerkui.busiHallArrivalOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				busiHallArrivalOrderListui= new BusiHallArrivalOrderListui();
				childPanel = busiHallArrivalOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderListui();
			}
		});
		busiHallClerkui.deliveryManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deliveryOrderListui= new DeliveryOrderListui();
				childPanel = deliveryOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDeliveryOrderListui();
			}
		});
		busiHallClerkui.vehicleManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vehiclesListui= new VehiclesListui();
				childPanel = vehiclesListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inVehiclesListui();
			}
		});
	}
	public void inBusinessHallLoadingListListui() {
		businessHallLoadingListListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				businessHallLoadingListListui=null;
				businessHallLoadingListui= new BusinessHallLoadingListui();
				childPanel = businessHallLoadingListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusinessHallLoadingListui();
			}
		});
	}
	public void inBusinessHallLoadingListui() {
		
	}
	public void inDriversListui(){
		driversListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				driversListui=null;
				driversui=new Driversui();
				childPanel=driversui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDriversui();
			}
		});
	}
	public void inDriversui(){
		
	}
	public void inReceivablesOrderListui(){
		receivablesOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				receivablesOrderListui=null;
				receivablesOrderui=new ReceivablesOrderui();
				childPanel=receivablesOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderui();
			}
		});
	}
	public void inReceivablesOrderui(){
		
	}
	public void inBusiHallArrivalOrderListui(){
		busiHallArrivalOrderListui.add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				busiHallArrivalOrderListui=null;
				busiHallArrivalOrderui=new BusiHallArrivalOrderui();
				childPanel=busiHallArrivalOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderui();
			}
		});
		busiHallArrivalOrderListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				javaBean1=new JavaBean1();
				javaBean1=busiHallArrivalOrderblservice.inquireA(
						busiHallArrivalOrderListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					JOptionPane.showMessageDialog
					(null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
				}
				busiHallArrivalOrderVO=(BusiHallArrivalOrderVO)javaBean1.getObject();
				busiHallArrivalOrderui=findBusiHallArrivalOrder(busiHallArrivalOrderVO);
				childPanel = busiHallArrivalOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderui();
			}
		});
		busiHallArrivalOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)busiHallArrivalOrderListui.tableModel.
               			getValueAt(busiHallArrivalOrderListui.table.getSelectedRow(),1);
               	System.out.println(id);
               	try {
               		busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
    				javaBean1=new JavaBean1();
   					javaBean1=busiHallArrivalOrderblservice.inquireA(id);
   					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
   					busiHallArrivalOrderui=findBusiHallArrivalOrder(busiHallArrivalOrderVO);
   					childPanel = busiHallArrivalOrderui;
   					Skip.skip(mainPanel,childPanel);
   					inBusiHallArrivalOrderui();
   				} catch (Exception e2) {
   					e2.printStackTrace();
   				}
               }
            }
       });
	}
	public BusiHallArrivalOrderui findBusiHallArrivalOrder(BusiHallArrivalOrderVO busiHallArrivalOrderVO){
		busiHallArrivalOrderui=new BusiHallArrivalOrderui();
		busiHallArrivalOrderui.modify.setVisible(true);
		busiHallArrivalOrderui.delete.setVisible(true);
		busiHallArrivalOrderui.modifyOrder.setVisible(true);
		busiHallArrivalOrderui.makeOrder.setVisible(false);
		
		busiHallArrivalOrderui.transferOrderField.setText(busiHallArrivalOrderVO.getTransferOrderID());
		busiHallArrivalOrderui.transferOrderField.setEditable(false);
		
		busiHallArrivalOrderui.departureField.setText(busiHallArrivalOrderVO.getOrigin());
		busiHallArrivalOrderui.departureField.setEditable(false);
		
		busiHallArrivalOrderui.goodStateType.setEditable(false);
		switch(busiHallArrivalOrderVO.getGoodState()){
		case COMPLETE:busiHallArrivalOrderui.goodStateType.setSelectedIndex(0);break;
		case BROKE:busiHallArrivalOrderui.goodStateType.setSelectedIndex(1);break;
		case LOST:busiHallArrivalOrderui.goodStateType.setSelectedIndex(2);break;
		default:break;
		}
		switch(busiHallArrivalOrderVO.getApproState()){
		case Approve:busiHallArrivalOrderui.approState.setText("已审批");break;
		case NotApprove:busiHallArrivalOrderui.approState.setText("未审批");break;
			default:break;
		}
		busiHallArrivalOrderui.docmID.setText(busiHallArrivalOrderVO.getId());
		
		return busiHallArrivalOrderui;
	}
	public void inBusiHallArrivalOrderui(){
		busiHallArrivalOrderui.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String deleteId=busiHallArrivalOrderVO.getId();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				busiHallArrivalOrderblservice.deleteMany(deletearray);
				busiHallArrivalOrderListui = new BusiHallArrivalOrderListui();
				childPanel = busiHallArrivalOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderListui();
			}
		});
	}
	public void inDeliveryOrderListui(){
		deliveryOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deliveryOrderListui=null;
				deliveryOrderui=new DeliveryOrderui();
				childPanel=deliveryOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDeliveryOrderui();
			}
		});
	}
	public void inDeliveryOrderui(){
		
	}
	public void inVehiclesListui(){
		vehiclesListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vehiclesListui=null;
				vehiclesui=new Vehiclesui();
				childPanel=vehiclesui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inVehiclesui();
			}
		});
	}
	public void inVehiclesui(){
		
	}
	public static void main(String[] args) {
		BusiHallClerkController busiHallClerkController = new BusiHallClerkController();
	}
}
