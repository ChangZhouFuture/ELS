package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.documentsPO.DeliveryOrderPO;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import state.ResultMessage;
import vo.documentsVO.DeliveryOrderVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.DeliveryOrderblservice;
/**
 * ÅÉ¼þµ¥
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

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public JavaBean1 addDeliveryOrder(DeliveryOrderVO deliveryOrderVO) {
		this.deliveryOrderPO = new DeliveryOrderPO();
		this.deliveryOrderVO = deliveryOrderVO;
		
		this.deliveryOrderVO.setArrivalDate(generateDate());
		this.deliveryOrderVO.setID(generateId());
		VOtoPO();
		
		try {
			resultMessage = deliveryOrderdataservice.addDeliveryOrder(this.deliveryOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.deliveryOrderVO);		
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public String generateId() {
		String id;
		try {
			id = date+deliveryOrderdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
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
	public ResultMessage deleteone(String id) {
		try {
			resultMessage = deliveryOrderdataservice.deleteone(id);
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

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VOtoPO() {
		deliveryOrderPO.setArrivalDate(deliveryOrderVO.getArrivalDate());
		deliveryOrderPO.setDeliverier(deliveryOrderVO.getDeliverier());
		deliveryOrderPO.setOrderID(deliveryOrderVO.getOrderID());
		deliveryOrderPO.setID(deliveryOrderVO.getID());
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<DeliveryOrderVO>();
		
		for (int i = 0; i < k; i++) {
			deliveryOrderPO = arrayList.get(i);
			
			deliveryOrderVO = new DeliveryOrderVO();
			deliveryOrderVO.setID(deliveryOrderPO.getID());
			deliveryOrderVO.setArrivalDate(deliveryOrderPO.getArrivalDate());
			deliveryOrderVO.setDeliverier(deliveryOrderPO.getDeliverier());
			deliveryOrderVO.setOrderID(deliveryOrderPO.getOrderID());
			
			arrayList2.add(deliveryOrderVO);
		}
	}
	
}
