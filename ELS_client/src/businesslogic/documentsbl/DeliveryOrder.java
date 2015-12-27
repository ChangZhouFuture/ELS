package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.DeliveryOrderPO;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import state.ApproState;
import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogic.utilitybl.UpdateLogisticsInfor;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
/**
 * 派件单
 * @author 
 *
 */
public class DeliveryOrder implements DeliveryOrderblservice{
	private DeliveryOrderdataservice deliveryOrderdataservice;
	private DeliveryOrderVO deliveryOrderVO;
	private DeliveryOrderPO deliveryOrderPO;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private ArrayList<DeliveryOrderPO> arrayList;
	private ArrayList<DeliveryOrderVO> arrayList2;
	private UpdateLogisticsInfor updateLogisticsInfor;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	private String date;
	
	public DeliveryOrder(){
		try {
			deliveryOrderdataservice = RMIHelper.getDeliveryOrderdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderlineitemVO addOrder(String orderID) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(orderID);
		return orderlineitemVO;
	}

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public JavaBean1 addDeliveryOrder(DeliveryOrderVO deliveryOrderVO) {
		this.deliveryOrderPO = new DeliveryOrderPO();
		this.deliveryOrderVO = deliveryOrderVO;
		
		this.deliveryOrderVO.setArrivalDate(generateDate());
		this.deliveryOrderVO.setGenerateTime(Time.generateTime());
		this.deliveryOrderVO.setID(generateId());
		this.deliveryOrderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = deliveryOrderdataservice.addDeliveryOrder(this.deliveryOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			updateLogisticsInfor = new UpdateLogisticsInfor();
			updateLogisticsInfor.update(date, this.deliveryOrderVO.getOrderID(), date
				+ " 订单正在派件中...");
		}
		javaBean1.setObject(this.deliveryOrderVO);		
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	public String generateId() {
		String id = null;
		try {
			id = deliveryOrderdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public ResultMessage modify(DeliveryOrderVO deliveryOrderVO) {
		deliveryOrderPO = new DeliveryOrderPO();
		this.deliveryOrderVO = deliveryOrderVO;
		
		VOtoPO();
		try {
			resultMessage = deliveryOrderdataservice.update(deliveryOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = deliveryOrderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = deliveryOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<DeliveryOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = deliveryOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<DeliveryOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public void VOtoPO() {
		deliveryOrderPO.setArrivalDate(deliveryOrderVO.getArrivalDate());
		deliveryOrderPO.setGenerateTime(deliveryOrderVO.getGenerateTime());
		deliveryOrderPO.setDeliverier(deliveryOrderVO.getDeliverier());
		deliveryOrderPO.setOrderID(deliveryOrderVO.getOrderID());
		deliveryOrderPO.setID(deliveryOrderVO.getID());
		deliveryOrderPO.setApproState(deliveryOrderVO.getApproState());
	}

	public void POtoVO(int k) {
		arrayList2 = new ArrayList<DeliveryOrderVO>();
		
		for (int i = 0; i < k; i++) {
			deliveryOrderPO = arrayList.get(i);
			
			deliveryOrderVO = new DeliveryOrderVO();
			deliveryOrderVO.setID(deliveryOrderPO.getID());
			deliveryOrderVO.setArrivalDate(deliveryOrderPO.getArrivalDate());
			deliveryOrderVO.setDeliverier(deliveryOrderPO.getDeliverier());
			deliveryOrderVO.setOrderID(deliveryOrderPO.getOrderID());
			deliveryOrderVO.setApproState(deliveryOrderPO.getApproState());
			
			arrayList2.add(deliveryOrderVO);
		}
	}
	
}
