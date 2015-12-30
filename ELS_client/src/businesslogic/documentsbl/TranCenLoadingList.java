package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.TranCenLoadingListPO;
import po.lineitemPO.documentslineitemPO.TranCenLoadingListlineitemPO;
import dataservice.documentsdataservice.TranCenLoadingListdataservice;
import state.ApproState;
import state.ResultMessage;
import state.TransportType;
import vo.documentsVO.TranCenLoadingListVO;
import vo.lineitemVO.documentslineitemVO.TranCenLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.CalculateFreight;
import businesslogic.utilitybl.Time;
import businesslogic.utilitybl.UpdateLogisticsInfor;
import businesslogicservice.documentsblservice.TranCenLoadingListblservice;

public class TranCenLoadingList implements TranCenLoadingListblservice{
	private TranCenLoadingListdataservice tranCenLoadingListdataservice;
	private TranCenLoadingListVO tranCenLoadingListVO;
	private TranCenLoadingListPO tranCenLoadingListPO;
	private TranCenLoadingListlineitemPO tranCenLoadingListlineitemPO;
	private TranCenLoadingListlineitemVO tranCenLoadingListlineitemVO;
	private ArrayList<TranCenLoadingListlineitemPO> arrayList;
	private ArrayList<TranCenLoadingListlineitemVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private UpdateLogisticsInfor updateLogisticsInfor;
	private ResultMessage resultMessage;
	String date;
	private JavaBean1 javaBean1 = new JavaBean1();
	
	public TranCenLoadingList() {
		try {
			tranCenLoadingListdataservice = RMIHelper.getTransferCenterLoadingListdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderlineitemVO addOrder(String orderId) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(orderId);
		return orderlineitemVO;
	}

	public String generateId() {
		String id = null;
		try {
			id = tranCenLoadingListdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public String generateTruckNum() {
		//仿造营业厅装车单
		String truckNum = null;
		try {
			truckNum = tranCenLoadingListdataservice.
					generateTruckNum(Login.agencyID + date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return truckNum;
	}

	public double generateFeight(String destination, TransportType tType) {
		double freight = CalculateFreight.transportCost(destination, tType);
		return freight;
	}

	@Override
	public JavaBean1 add(TranCenLoadingListVO tranCenLoadingListVO) {
		tranCenLoadingListPO = new TranCenLoadingListPO();
		this.tranCenLoadingListVO = tranCenLoadingListVO;
		
		this.tranCenLoadingListVO.setTranCenID(Login.agencyID);
		this.tranCenLoadingListVO.setLoadingDate(generateDate());
		this.tranCenLoadingListVO.setGenerateTime(Time.generateTime());
		this.tranCenLoadingListVO.setID(generateId());
		this.tranCenLoadingListVO.setTrucksNum(generateTruckNum());
		this.tranCenLoadingListVO.setCarriage(generateFeight(tranCenLoadingListVO.
				getDestination(), TransportType.Truck));
		this.tranCenLoadingListVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = tranCenLoadingListdataservice.addLoadingList(tranCenLoadingListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			updateLogisticsInfor = new UpdateLogisticsInfor();
			ArrayList<String> orderIDs = this.tranCenLoadingListVO.getOrderIDs();
			String orderID;
			for (int i = 0; i < orderIDs.size(); i++) {
				orderID = orderIDs.get(i);
				updateLogisticsInfor.update(date, orderID, " 订单已在" + 
				Login.city + "中转中心装车");
			}
		}
		javaBean1.setObject(this.tranCenLoadingListVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage delete (ArrayList<String> idList) {
		try {
			resultMessage = tranCenLoadingListdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 modify(TranCenLoadingListVO tranCenLoadingListVO) {
		tranCenLoadingListPO = new TranCenLoadingListPO();
		this.tranCenLoadingListVO = tranCenLoadingListVO;
		
		this.tranCenLoadingListVO.setCarriage(generateFeight(tranCenLoadingListVO.
				getDestination(), TransportType.Truck));
		VOtoPO();
		try {
			resultMessage = tranCenLoadingListdataservice.update(tranCenLoadingListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.tranCenLoadingListVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = tranCenLoadingListdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		tranCenLoadingListPO = (TranCenLoadingListPO)javaBean1.getObject();
		tranCenLoadingListVO = new TranCenLoadingListVO();
		
		if (javaBean1.getResultMessage() == ResultMessage.NotExist) {
			return javaBean1;
		}
		tranCenLoadingListVO.setID(tranCenLoadingListPO.getID());
		tranCenLoadingListVO.setLoadingDate(tranCenLoadingListPO.getLoadingDate());
		tranCenLoadingListVO.setTranCenID(tranCenLoadingListPO.getTranCenID());
		tranCenLoadingListVO.setDestination(tranCenLoadingListPO.getDestination());
		tranCenLoadingListVO.setVehiclesID(tranCenLoadingListPO.getVehiclesID());
		tranCenLoadingListVO.setOrderIDs(tranCenLoadingListPO.getOrderIDs());
		tranCenLoadingListVO.setTrucksNum(tranCenLoadingListPO.getTrucksNum());
		tranCenLoadingListVO.setEscortMan(tranCenLoadingListPO.getEscortMan());
		tranCenLoadingListVO.setSupervisionMan(tranCenLoadingListPO.getSupervisionMan());
		tranCenLoadingListVO.setCarriage(tranCenLoadingListPO.getCarriage());
		tranCenLoadingListVO.setApproState(tranCenLoadingListPO.getApproState());
		
		javaBean1.setObject(tranCenLoadingListVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = tranCenLoadingListdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<TranCenLoadingListlineitemPO>)javaBean1.getObject();
		arrayList2 = new ArrayList<TranCenLoadingListlineitemVO>();
		int k = arrayList.size();
		
		for (int i = 0; i < k; i++) {
			tranCenLoadingListlineitemPO = arrayList.get(i);
			
			tranCenLoadingListlineitemVO = new TranCenLoadingListlineitemVO();
			tranCenLoadingListlineitemVO.setID(tranCenLoadingListlineitemPO.getID());
			tranCenLoadingListlineitemVO.setDestination(tranCenLoadingListlineitemPO.
					getDestination());
			tranCenLoadingListlineitemVO.setCarriage(tranCenLoadingListlineitemPO.
					getCarriage());
			tranCenLoadingListlineitemVO.setLoadingDate(tranCenLoadingListlineitemPO.
					getLoadingDate());
			tranCenLoadingListlineitemVO.setTruckNum(tranCenLoadingListlineitemPO.
					getTruckNum());
			tranCenLoadingListlineitemVO.setApproState(tranCenLoadingListlineitemPO.
					getApproState());
			
			arrayList2.add(tranCenLoadingListlineitemVO);
		}
		
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public void VOtoPO() {
		tranCenLoadingListPO.setID(tranCenLoadingListVO.getID());
		tranCenLoadingListPO.setLoadingDate(tranCenLoadingListVO.getLoadingDate());
		tranCenLoadingListPO.setGenerateTime(tranCenLoadingListVO.getGenerateTime());
		tranCenLoadingListPO.setDestination(tranCenLoadingListVO.getDestination());
		tranCenLoadingListPO.setVehiclesID(tranCenLoadingListVO.getVehiclesID());
		tranCenLoadingListPO.setTrucksNum(tranCenLoadingListVO.getTrucksNum());
		tranCenLoadingListPO.setEscortMan(tranCenLoadingListVO.getEscortMan());
		tranCenLoadingListPO.setSupervisionMan(tranCenLoadingListVO.getSupervisionMan());
		tranCenLoadingListPO.setCarriage(tranCenLoadingListVO.getCarriage());
		tranCenLoadingListPO.setOrderIDs(tranCenLoadingListVO.getOrderIDs());
		tranCenLoadingListPO.setTranCenID(tranCenLoadingListVO.getTranCenID());
		tranCenLoadingListPO.setApproState(tranCenLoadingListVO.getApproState());
	}

}
