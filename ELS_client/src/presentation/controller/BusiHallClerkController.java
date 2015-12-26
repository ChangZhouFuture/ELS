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
import businesslogic.documentsbl.BusiHallLoadingList;
import businesslogic.documentsbl.DeliveryOrder;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
import businesslogicservice.documentsblservice.BusiHallLoadingListblservice;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
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
import presentation.reuse.Skip;
import presentation.userui.BusiHallClerkui;
import presentation.userui.Loginui;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.documentsVO.DeliveryOrderVO;
import vo.documentsVO.ReceivablesOrderVO;

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
	BusiHallLoadingListblservice busiHallLoadingListblservice;
	DeliveryOrderblservice deliveryOrderblservice;
	ReceivablesOrderblservice receivablesOrderblservice;
	BusiHallArrivalOrderVO busiHallArrivalOrderVO;
	BusiHallLoadingListVO busiHallLoadingListVO;
	DeliveryOrderVO deliveryOrderVO;
	ReceivablesOrderVO receivablesOrderVO;
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
				Skip.skip(mainPanel,childPanel);
				inBusinessHallLoadingListListui();
			}
		});
		busiHallClerkui.driverManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				driversListui= new DriversListui();
				childPanel = driversListui;
				Skip.skip(mainPanel,childPanel);
				inDriversListui();
			}
		});
		busiHallClerkui.receOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui= new ReceivablesOrderListui();
				childPanel = receivablesOrderListui;
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
		busiHallClerkui.busiHallArrivalOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				busiHallArrivalOrderListui= new BusiHallArrivalOrderListui();
				childPanel = busiHallArrivalOrderListui;
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderListui();
			}
		});
		busiHallClerkui.deliveryManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deliveryOrderListui= new DeliveryOrderListui();
				childPanel = deliveryOrderListui;
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
				Skip.skip(mainPanel,childPanel);
				inBusinessHallLoadingListui();
			}
		});
		businessHallLoadingListListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				busiHallLoadingListblservice=new BusiHallLoadingList();
				javaBean1=new JavaBean1();
				javaBean1=busiHallLoadingListblservice.inquireA(
						businessHallLoadingListListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					JOptionPane.showMessageDialog
					(null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
				}
				busiHallLoadingListVO=(BusiHallLoadingListVO)javaBean1.getObject();
				businessHallLoadingListui=findBusiHallLoadingList(busiHallLoadingListVO);
				childPanel = businessHallLoadingListui;
				Skip.skip(mainPanel,childPanel);
				inBusinessHallLoadingListui();
			}
		});
		businessHallLoadingListListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)businessHallLoadingListListui.tableModel.
               			getValueAt(businessHallLoadingListListui.table.getSelectedRow(),1);
               	System.out.println(id);
               	try {
               		busiHallLoadingListblservice=new BusiHallLoadingList();
    				javaBean1=new JavaBean1();
   					javaBean1=busiHallLoadingListblservice.inquireA(id);
   					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
   					businessHallLoadingListui=findBusiHallLoadingList(busiHallLoadingListVO);
   					childPanel = businessHallLoadingListui;
   					Skip.skip(mainPanel,childPanel);
   					inBusinessHallLoadingListui();
   				} catch (Exception e2) {
   				}
               }
            }
       });
	}
	public BusinessHallLoadingListui findBusiHallLoadingList(BusiHallLoadingListVO busiHallLoadingListVO){
		businessHallLoadingListui=new BusinessHallLoadingListui();
		businessHallLoadingListui.refresh();
		businessHallLoadingListui.busiIdField.setText(busiHallLoadingListVO.getBusiHallID());
		businessHallLoadingListui.motorIdField.setText(busiHallLoadingListVO.getTruckNum());
		businessHallLoadingListui.vehicleIdField.setText(busiHallLoadingListVO.getVehiclesID());
		businessHallLoadingListui.arrivalField.setText(busiHallLoadingListVO.getDestination());
		businessHallLoadingListui.jZYField.setText(busiHallLoadingListVO.getSupervisionMan());
		businessHallLoadingListui.yYYField.setText(busiHallLoadingListVO.getEscortMan());
		ArrayList<String> idList=null;
		idList=busiHallLoadingListVO.getOrderIDs();
		for(int i=0;i<idList.size();i++){
			busiHallLoadingListblservice=new BusiHallLoadingList();
			businessHallLoadingListui.orderlineitemVO=busiHallLoadingListblservice.addOrder(idList.get(i));
			String[] oneRow={"",businessHallLoadingListui.orderlineitemVO.getId(),
					businessHallLoadingListui.orderlineitemVO.getSenderAdd(),
					businessHallLoadingListui.orderlineitemVO.getAddresseeAdd(),
					businessHallLoadingListui.orderlineitemVO.getExpressType().toString(),
					businessHallLoadingListui.orderlineitemVO.getGenerateDate()};
			businessHallLoadingListui.tableModel.addRow(oneRow);
		}
		switch(busiHallLoadingListVO.getApproState()){
		case Approve:businessHallLoadingListui.approState.setText("已审批");break;
		case NotApprove:businessHallLoadingListui.approState.setText("未审批");break;
			default:break;
		}
		businessHallLoadingListui.docmID.setText(busiHallLoadingListVO.getID());
		return businessHallLoadingListui;
	}
	public void inBusinessHallLoadingListui() {
		businessHallLoadingListui.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=businessHallLoadingListui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				busiHallLoadingListblservice=new BusiHallLoadingList();
				busiHallLoadingListblservice.deleteMany(deletearray);
				businessHallLoadingListListui = new BusinessHallLoadingListListui();
				childPanel = businessHallLoadingListListui;
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderListui();
			}
		});
	}
	public void inDriversListui(){
		driversListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				driversListui=null;
				driversui=new Driversui();
				childPanel=driversui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDriversui();
			}
		});
		driversListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		driversListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
            	   
               }
            }
       });
	}
	public void inDriversui(){
		
	}
	public void inReceivablesOrderListui(){
		receivablesOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderListui=null;
				receivablesOrderui=new ReceivablesOrderui();
				childPanel=receivablesOrderui;
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderui();
			}
		});
		receivablesOrderListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receivablesOrderblservice=new ReceivablesOrder();
				javaBean1=new JavaBean1();
				javaBean1=receivablesOrderblservice.inquireA(receivablesOrderListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					JOptionPane.showMessageDialog
					(null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
				}
				receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				receivablesOrderui=finReceivablesOrder(receivablesOrderVO);
				childPanel = receivablesOrderui;
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderui();
			}
		});

		receivablesOrderListui.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent evt) {
	            if (evt.getClickCount() == 2) {
	               	String id=(String)busiHallArrivalOrderListui.tableModel.
	               			getValueAt(busiHallArrivalOrderListui.table.getSelectedRow(),1);
	            	try {
	            		receivablesOrderblservice=new ReceivablesOrder();
				        javaBean1=new JavaBean1();
				        javaBean1=receivablesOrderblservice.inquireA(id);
				        if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					        JOptionPane.showMessageDialog
					        (null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
				        }
				        receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				        receivablesOrderui=finReceivablesOrder(receivablesOrderVO);
				        childPanel = receivablesOrderui;
				        Skip.skip(mainPanel,childPanel);
				        inReceivablesOrderui();
			        }catch(Exception e2){
			        }
	            }
	       }
		});
	}
	public ReceivablesOrderui finReceivablesOrder(ReceivablesOrderVO receivablesOrderVO){
		receivablesOrderui=new ReceivablesOrderui();
		receivablesOrderui.refresh();
		receivablesOrderui.moneyField.setText(String.valueOf(receivablesOrderVO.getAmount()));
		receivablesOrderui.courierId.setText(receivablesOrderVO.getCourier());
		ArrayList<String> idList=null;
		idList=receivablesOrderVO.getOrderIDs();
		for(int i=0;i<idList.size();i++){
			receivablesOrderblservice=new ReceivablesOrder();
			receivablesOrderui.orderlineitemVO=busiHallLoadingListblservice.addOrder(idList.get(i));
			String[] oneRow={"",receivablesOrderui.orderlineitemVO.getId(),
					receivablesOrderui.orderlineitemVO.getSenderAdd(),
					receivablesOrderui.orderlineitemVO.getAddresseeAdd(),
					receivablesOrderui.orderlineitemVO.getExpressType().toString(),
					receivablesOrderui.orderlineitemVO.getGenerateDate()};
			receivablesOrderui.tableModel.addRow(oneRow);
		}
		switch(receivablesOrderVO.getApproState()){
		case Approve:receivablesOrderui.approState.setText("已审批");break;
		case NotApprove:receivablesOrderui.approState.setText("未审批");break;
			default:break;
		}
		receivablesOrderui.docmID.setText(receivablesOrderVO.getID());
		return receivablesOrderui;
	}
	public void inReceivablesOrderui(){
		receivablesOrderui.delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=receivablesOrderui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				receivablesOrderblservice=new ReceivablesOrder();
				receivablesOrderblservice.deleteMany(deletearray);
				receivablesOrderListui = new ReceivablesOrderListui();
				childPanel = receivablesOrderListui;
				Skip.skip(mainPanel,childPanel);
				inReceivablesOrderListui();
			}
		});
	}
	public void inBusiHallArrivalOrderListui(){
		busiHallArrivalOrderListui.add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				busiHallArrivalOrderListui=null;
				busiHallArrivalOrderui=new BusiHallArrivalOrderui();
				childPanel=busiHallArrivalOrderui;
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderui();
			}
		});
		busiHallArrivalOrderListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderui();
			}
		});
		busiHallArrivalOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)busiHallArrivalOrderListui.tableModel.
               			getValueAt(busiHallArrivalOrderListui.table.getSelectedRow(),1);
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
   				}
               }
            }
       });
	}
	public BusiHallArrivalOrderui findBusiHallArrivalOrder(BusiHallArrivalOrderVO busiHallArrivalOrderVO){
		busiHallArrivalOrderui=new BusiHallArrivalOrderui();
		busiHallArrivalOrderui.refresh();
		busiHallArrivalOrderui.transferOrderField.setText(busiHallArrivalOrderVO.getTransferOrderID());
		busiHallArrivalOrderui.departureField.setText(busiHallArrivalOrderVO.getOrigin());
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
				String deleteId=busiHallArrivalOrderui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				busiHallArrivalOrderblservice=new BusiHallArrivalOrder();
				busiHallArrivalOrderblservice.deleteMany(deletearray);
				busiHallArrivalOrderListui = new BusiHallArrivalOrderListui();
				childPanel = busiHallArrivalOrderListui;
				Skip.skip(mainPanel,childPanel);
				inBusiHallArrivalOrderListui();
			}
		});
	}
	public void inDeliveryOrderListui(){
		deliveryOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deliveryOrderListui=null;
				deliveryOrderui=new DeliveryOrderui();
				childPanel=deliveryOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inDeliveryOrderui();
			}
		});
		deliveryOrderListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deliveryOrderblservice=new DeliveryOrder();
				javaBean1=new JavaBean1();
				javaBean1=deliveryOrderblservice.inquireA(deliveryOrderListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
				}
				deliveryOrderVO=(DeliveryOrderVO)javaBean1.getObject();
				deliveryOrderui=findDeliveryOrder(deliveryOrderVO);
				childPanel = deliveryOrderui;
				Skip.skip(mainPanel,childPanel);
				inDeliveryOrderui();
			}
		});
		deliveryOrderListui.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)deliveryOrderListui.tableModel.
                			getValueAt(deliveryOrderListui.table.getSelectedRow(),1);
                	try {
                		deliveryOrderblservice=new DeliveryOrder();
                		javaBean1=new JavaBean1();
    					javaBean1=deliveryOrderblservice.inquireA(id);
    					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
    						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
    					}
    					deliveryOrderVO=(DeliveryOrderVO)javaBean1.getObject();
    					deliveryOrderui=findDeliveryOrder(deliveryOrderVO);
    					childPanel = deliveryOrderui;
    					Skip.skip(mainPanel,childPanel);
    					inDeliveryOrderui();
    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}
                }
             }
		});
	}
	public DeliveryOrderui findDeliveryOrder(DeliveryOrderVO deliveryOrderVO){
		deliveryOrderui=new DeliveryOrderui();
		deliveryOrderui.refresh();
		deliveryOrderui.courierid.setText(deliveryOrderVO.getDeliverier());
		deliveryOrderui.orderid.setText(deliveryOrderVO.getOrderID());
		switch(deliveryOrderVO.getApproState()){
		case Approve:deliveryOrderui.approState.setText("已审批");break;
		case NotApprove:deliveryOrderui.approState.setText("未审批");break;
			default:break;
		}
		deliveryOrderui.docmID.setText(deliveryOrderVO.getID());
		return deliveryOrderui;
	}
	public void inDeliveryOrderui(){
		deliveryOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=deliveryOrderui.docmID.getText();
				ArrayList<String> deletearray=null;
				deletearray.add(deleteId);
				deliveryOrderblservice=new DeliveryOrder();
				deliveryOrderblservice.deleteMany(deletearray);
				deliveryOrderListui = new DeliveryOrderListui();
				childPanel = deliveryOrderListui;
				Skip.skip(mainPanel,childPanel);
				inDeliveryOrderListui();
			}
		});
	}
	public void inVehiclesListui(){
		vehiclesListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
