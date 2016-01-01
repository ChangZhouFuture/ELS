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
import businesslogic.stockbl.OutBoundOrder;
import businesslogic.stockbl.StorageList;
import businesslogicservice.stockblservice.OutBoundOrderblservice;
import businesslogicservice.stockblservice.StorageListblservice;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.EMSDialog;
import presentation.reuse.Skip;
import presentation.stockui.OutBoundOrderui.OutBoundOrderListui;
import presentation.stockui.OutBoundOrderui.OutBoundOrderui;
import presentation.stockui.StorageListui.StorageListListui;
import presentation.stockui.StorageListui.StorageListui;
import presentation.stockui.stockui.StockCheckui;
import presentation.stockui.stockui.StockCountui;
import presentation.userManagementui.UserInfoui;
import presentation.userManagementui.UserListui;
import presentation.userui.Administratorui;
import presentation.userui.StockManagerui;
import state.ResultMessage;
import vo.orderVO.OrderVO;
import vo.stockVO.OutBoundOrderVO;
import vo.stockVO.StorageListVO;

public class StockManagerController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	StockManagerui stockManagerui;
	OutBoundOrderListui outBoundOrderListui;
	StorageListListui storageListListui;
	StockCheckui stockCheckui;
	StockCountui stockCountui;
	OutBoundOrderui outBoundOrderui;
	StorageListui storageListui;
	JavaBean1 javaBean1;
	OutBoundOrderblservice outBoundOrderblservice;
	OutBoundOrderVO outBoundOrderVO;
	StorageListblservice storageListblservice;
	StorageListVO storageListVO;
	
	public StockManagerController(){
		stockManagerui = new StockManagerui();
		storageListListui = new StorageListListui();
		storageListListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(storageListListui);
		JLayeredPane layeredPane = stockManagerui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inStockManagerui();
		inStorageListListui();
	}
	public void inStockManagerui() {
		stockManagerui.outBoundManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outBoundOrderListui= new OutBoundOrderListui();
				childPanel = outBoundOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOutBoundOrderListui();
			}
		});
		stockManagerui.storageManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				storageListListui = new StorageListListui();
				childPanel = storageListListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		stockManagerui.stockCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stockCheckui = new StockCheckui();
				childPanel = stockCheckui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		stockManagerui.stockCount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stockCountui = new StockCountui();
				childPanel = stockCountui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inOutBoundOrderListui() {
		outBoundOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outBoundOrderListui = null;
				outBoundOrderui = new OutBoundOrderui();
				childPanel = outBoundOrderui;
				Skip.skip(mainPanel,childPanel);
				inOutBoundOrderui();
			}
		});
		outBoundOrderListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    outBoundOrderblservice=new OutBoundOrder();
					javaBean1=new JavaBean1();
					javaBean1=outBoundOrderblservice.inquireA(outBoundOrderListui.idField.getText());
					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						EMSDialog d=new EMSDialog();
						int n = d.showDialog(stockManagerui,"单据不存在",30);
					}
					outBoundOrderVO=(OutBoundOrderVO)javaBean1.getObject();
					outBoundOrderui=findOutBoundOrder(outBoundOrderVO);
					childPanel = outBoundOrderui;
					Skip.skip(mainPanel,childPanel);
					inOutBoundOrderui();
			}
		});
		outBoundOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)outBoundOrderListui.tableModel.
                			getValueAt(outBoundOrderListui.table.getSelectedRow(),1);
                	try {
                		outBoundOrderblservice=new OutBoundOrder();
                		javaBean1=new JavaBean1();
    					javaBean1=outBoundOrderblservice.inquireA(id);
    					outBoundOrderVO=(OutBoundOrderVO)javaBean1.getObject();
    					outBoundOrderui=findOutBoundOrder(outBoundOrderVO);
    					childPanel = outBoundOrderui;
    					Skip.skip(mainPanel,childPanel);
    					inOutBoundOrderui();
    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}
                }
             }
        });
	}
	public OutBoundOrderui findOutBoundOrder(OutBoundOrderVO outBoundOrderVO){
		outBoundOrderui=new OutBoundOrderui();
		outBoundOrderui.refresh();
		outBoundOrderui.outBoundOrderVO=outBoundOrderVO;
		outBoundOrderui.orderIdField.setText(outBoundOrderVO.getOrderID());
		outBoundOrderui.destinationField.setText(outBoundOrderVO.getDestination());
		outBoundOrderui.tranOrMotorIdField.setText(outBoundOrderVO.getTruckNum());
		switch (outBoundOrderVO.getTransportType()) {
		case Truck:outBoundOrderui.transportTypeType.setSelectedIndex(0);break;
		case Train:outBoundOrderui.transportTypeType.setSelectedIndex(1);break;
		case Plane:outBoundOrderui.transportTypeType.setSelectedIndex(2);break;
		default:break;
		}
		switch(outBoundOrderVO.getApproState()){
		case Approve:outBoundOrderui.approState.setText("已审批");break;
		case NotApprove:outBoundOrderui.approState.setText("未审批");break;
			default:break;
		}
		outBoundOrderui.docmID.setText(outBoundOrderVO.getId());
		outBoundOrderui.docmDate.setText(outBoundOrderVO.getOutDate());
		return outBoundOrderui;
	}
	public void inOutBoundOrderui(){
		outBoundOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(stockManagerui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=outBoundOrderui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    outBoundOrderblservice=new OutBoundOrder();
				    outBoundOrderblservice.deleteMany(deletearray);
				    outBoundOrderListui = new OutBoundOrderListui();
				    childPanel = outBoundOrderListui;
				    Skip.skip(mainPanel,childPanel);
				    inOutBoundOrderListui();
		        } else if (n == 0) {  
		        }
			}
		});
	}
	public void inStorageListListui() {
		storageListListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				storageListListui = null;
				storageListui = new StorageListui();
				childPanel = storageListui;
				Skip.skip(mainPanel,childPanel);
				inStorageListui();
			}
		});
		storageListListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				storageListblservice=new StorageList();
				javaBean1=new JavaBean1();
				javaBean1=storageListblservice.inquireA(storageListListui.idField.getText());
				if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					EMSDialog d=new EMSDialog();
					int n = d.showDialog(stockManagerui,"单据不存在",30);
				}else{
					storageListVO=(StorageListVO)javaBean1.getObject();
					storageListui=findStorageList(storageListVO);
					childPanel = storageListui;
					Skip.skip(mainPanel,childPanel);
					inOutBoundOrderui();
				}
			}
		});
		storageListListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)storageListListui.tableModel.
                			getValueAt(storageListListui.table.getSelectedRow(),1);
                	try {
                		storageListblservice=new StorageList();
                		javaBean1=new JavaBean1();
    					javaBean1=storageListblservice.inquireA(id);
    					storageListVO=(StorageListVO)javaBean1.getObject();
    					storageListui=findStorageList(storageListVO);
    					childPanel = storageListui;
    					Skip.skip(mainPanel,childPanel);
    					inOutBoundOrderui();
    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}
                }
             }
        });
	}
	public StorageListui findStorageList(StorageListVO storageListVO){
		storageListui=new StorageListui();
		storageListui.refresh();
		storageListui.storageListVO=storageListVO;
		storageListui.orderIdField.setText(storageListVO.getOrderID());
		storageListui.destinationField.setText(storageListVO.getDestination());
		storageListui.areaNumField.setText(storageListVO.getAreaNum());
		storageListui.rowNumField.setText(storageListVO.getRowNum());
		storageListui.frameNumField.setText(storageListVO.getFrameNum());
		storageListui.positionNumField.setText(storageListVO.getPositionNum());
		switch(storageListVO.getApproState()){
		case Approve:storageListui.approState.setText("已审批");break;
		case NotApprove:storageListui.approState.setText("未审批");break;
			default:break;
		}
		storageListui.docmID.setText(storageListVO.getId());
		storageListui.docmDate.setText(storageListVO.getInDate());
		return storageListui;
	}
	public void inStorageListui(){
		storageListui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(stockManagerui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=storageListui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    storageListblservice=new StorageList();
				    storageListblservice.deleteMany(deletearray);
				    storageListListui = new StorageListListui();
				    childPanel = storageListListui;
				    Skip.skip(mainPanel,childPanel);
				    inOutBoundOrderListui();
		        } else if (n == 0) {  
		        }
			}
		});
	}
	public static void main(String[] args) {
		StockManagerController stockManagerController = new StockManagerController();
	}
}
