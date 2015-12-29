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
import businesslogicservice.stockblservice.OutBoundOrderblservice;
import presentation.orderui.OrderListui;
import presentation.orderui.Orderui;
import presentation.reuse.Skip;
import presentation.stockui.OutBoundOrderui.OutBoundOrderListui;
import presentation.stockui.OutBoundOrderui.OutBoundOrderui;
import presentation.stockui.StorageListui.StorageListListui;
import presentation.stockui.stockui.StockCheckui;
import presentation.stockui.stockui.StockCountui;
import presentation.userManagementui.UserInfoui;
import presentation.userManagementui.UserListui;
import presentation.userui.Administratorui;
import presentation.userui.StockManagerui;
import state.ResultMessage;
import vo.orderVO.OrderVO;
import vo.stockVO.OutBoundOrderVO;

public class StockManagerController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	StockManagerui stockManagerui;
	OutBoundOrderListui outBoundOrderListui;
	StorageListListui storageListListui;
	StockCheckui stockCheckui;
	StockCountui stockCountui;
	OutBoundOrderui outBoundOrderui;
	JavaBean1 javaBean1;
	OutBoundOrderblservice outBoundOrderblservice;
	OutBoundOrderVO outBoundOrderVO;
	
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
						JOptionPane.showMessageDialog(null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
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
    					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
    						JOptionPane.showMessageDialog(null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
    					}
    					outBoundOrderVO=(OutBoundOrderVO)javaBean1.getObject();
    					outBoundOrderui=findOutBoundOrder(outBoundOrderVO);
    					childPanel = outBoundOrderui;
    					Skip.skip(mainPanel,childPanel);
    					inOutBoundOrderui();
    				} catch (Exception e2) {
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
		outBoundOrderui.docmID.setText(outBoundOrderVO.getId());
		outBoundOrderui.docmDate.setText(outBoundOrderVO.getOutDate());
		return outBoundOrderui;
	}
	public void inOutBoundOrderui(){
		outBoundOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=outBoundOrderui.docmID.getText();
				ArrayList<String> deletearray=new ArrayList<String>();;
				deletearray.add(deleteId);
				outBoundOrderblservice=new OutBoundOrder();
				outBoundOrderblservice.deleteMany(deletearray);
				outBoundOrderListui = new OutBoundOrderListui();
				childPanel = outBoundOrderListui;
				Skip.skip(mainPanel,childPanel);
				inOutBoundOrderListui();
			}
		});
	}
	public void inStorageListListui() {
		
	}
	public static void main(String[] args) {
		StockManagerController stockManagerController = new StockManagerController();
	}
}
