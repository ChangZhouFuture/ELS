package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.ReceivablesOrderPO;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;
import state.ApproState;
import state.ResultMessage;
import vo.documentsVO.ReceivablesOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.inforManagementbl.BankAccountInfor;
import businesslogic.managerAndAccountantbl.StatisAnaly;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
/**
 * 
 * @author ÷‹≥©
 *
 */
public class ReceivablesOrder implements ReceivablesOrderblservice{
	private ReceivablesOrderdataservice receivablesOrderdataservice;
	private ReceivablesOrderVO receivablesOrderVO;
	private ReceivablesOrderPO receivablesOrderPO;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private ArrayList<ReceivablesOrderPO> arrayList;
	private ArrayList<ReceivablesOrderVO> arrayList2;
	private BankAccountInfor bankAccountInfor;
	private StatisAnaly statisAnaly;
	private ResultMessage resultMessage;
	private String date;
	private JavaBean1 javaBean1 = new JavaBean1();
	
    public ReceivablesOrder() {
		 try {
			receivablesOrderdataservice = RMIHelper.getReceivablesOrderdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	@Override
	public JavaBean1 add(ReceivablesOrderVO receivablesOrderVO) {
		receivablesOrderPO = new ReceivablesOrderPO();
		this.receivablesOrderVO = receivablesOrderVO;
		
		this.receivablesOrderVO.setDate(generateDate());
		this.receivablesOrderVO.setGenerateTime(Time.generateTime());
		this.receivablesOrderVO.setID(generateID());
		this.receivablesOrderVO.setAmount(calculateAmount(receivablesOrderVO.getOrderIDs()));
		this.receivablesOrderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = receivablesOrderdataservice.add(receivablesOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		statisAnaly.updateCostAndIncomeTable(this.receivablesOrderVO.getAmount(),
				"income");
		bankAccountInfor.updateBalance("add", this.receivablesOrderVO.getAmount());
		
		javaBean1.setObject(this.receivablesOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = receivablesOrderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 modify(ReceivablesOrderVO receivablesOrderVO) {
		receivablesOrderPO = new ReceivablesOrderPO();
		this.receivablesOrderVO = receivablesOrderVO;
		
		this.receivablesOrderVO.setAmount(calculateAmount(receivablesOrderVO.getOrderIDs()));
		VOtoPO();
		try {
			resultMessage = receivablesOrderdataservice.update(receivablesOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.receivablesOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = receivablesOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<ReceivablesOrderPO>)javaBean1.getObject(); 
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inqurieB(String date) {
		try {
			javaBean1 = receivablesOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<ReceivablesOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}
	
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public String generateID() {
		String id = null;
		try {
			id = date+ receivablesOrderdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public OrderlineitemVO addOrder(String orderId) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(orderId);
		return orderlineitemVO;
	}

	public void VOtoPO() {
		receivablesOrderPO.setID(receivablesOrderVO.getID());
		receivablesOrderPO.setDate(receivablesOrderVO.getDate());
		receivablesOrderPO.setGenerateTime(receivablesOrderVO.getGenerateTime());
		receivablesOrderPO.setAmount(receivablesOrderVO.getAmount());
		receivablesOrderPO.setCourier(receivablesOrderVO.getCourier());
		receivablesOrderPO.setOrderIDs(receivablesOrderVO.getOrderIDs());
		receivablesOrderPO.setApproState(receivablesOrderVO.getApproState());
	}

	public void POtoVO(int k) {
		arrayList2 = new ArrayList<ReceivablesOrderVO>();
		
		for (int i = 0; i < k; i++) {
			receivablesOrderPO = arrayList.get(i);
			
			receivablesOrderVO = new ReceivablesOrderVO();
			receivablesOrderVO.setID(receivablesOrderPO.getID());
			receivablesOrderVO.setDate(receivablesOrderPO.getDate());
			receivablesOrderVO.setAmount(receivablesOrderPO.getAmount());
			receivablesOrderVO.setCourier(receivablesOrderPO.getCourier());
			receivablesOrderVO.setApproState(receivablesOrderPO.getApproState());
			
			arrayList2.add(receivablesOrderVO);
		}
		
	}

	public double calculateAmount(ArrayList<String> OrdersId) {
		double amount = 0;
		
		try {
			amount = receivablesOrderdataservice.generateAmount(OrdersId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return amount;
	}

}
