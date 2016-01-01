package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import dataservice.documentsdataservice.TransferOrderdataservice;
import state.ApproState;
import state.ResultMessage;
import state.TransportType;
import vo.documentsVO.TransferOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.CalculateFreight;
import businesslogic.utilitybl.Time;
import businesslogic.utilitybl.UpdateLogisticsInfor;
import businesslogicservice.documentsblservice.TransferOrderblservice;
/**
 * 
 * @author 周畅
 * 
 */
public class TransferOrder implements TransferOrderblservice {
	private TransferOrderdataservice transferOrderdataservice;
	private TransferOrderVO transferOrderVO;
	private TransferOrderPO transferOrderPO;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private TransferOrderlineitemPO transferOrderlineitemPO;
	private ArrayList<TransferOrderlineitemPO> arrayList;
	private ArrayList<TransferOrderlineitemVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private UpdateLogisticsInfor updateLogisticsInfor;
	private ResultMessage resultMessage;
	private String date;
	private JavaBean1 javaBean1 = new JavaBean1();
	
	public TransferOrder() {
		try {
			transferOrderdataservice = RMIHelper.getTransferOrderdataservice();
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

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public double generateFare(String destination, TransportType tType) {
		double fare = CalculateFreight.transportCost(destination, tType);
		return fare;
	}

	@Override
	public JavaBean1 addTransferOrder(TransferOrderVO transferOrderVO) {
		transferOrderPO = new TransferOrderPO();
		this.transferOrderVO = transferOrderVO;
		
		this.transferOrderVO.setApproState(ApproState.NotApprove);
		this.transferOrderVO.setLoadingDate(generateDate());
		this.transferOrderVO.setGenerateTime(Time.generateTime());
		this.transferOrderVO.setOrigin(CalculateFreight.origin);
		this.transferOrderVO.setID(generateId());
		this.transferOrderVO.setCarriage(generateFare(transferOrderVO.
				getDestination(), transferOrderVO.getTransportType()));
		VOtoPO();
		
		try {
			resultMessage = transferOrderdataservice.addTransferOrder(transferOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			updateLogisticsInfor = new UpdateLogisticsInfor();
			ArrayList<String> orderIDs = this.transferOrderVO.getOrderIDs();
			String orderID;
			for (int i = 0; i < orderIDs.size(); i++) {
				orderID = orderIDs.get(i);
				updateLogisticsInfor.update(date, orderID, " 订单已从" + 
				Login.city + "中转中心发出,下一站： " + this.transferOrderVO.
				getDestination() + "中转中心");
			}
		}
		javaBean1.setObject(this.transferOrderVO);
		javaBean1.setResultMessage(resultMessage);

		return javaBean1;
	}

	public String generateId() {
		String agencyId = Login.agencyID;
		String id = null;
		try {
			id = transferOrderdataservice.
					generateId(date, agencyId);
			//返回完整的
		} catch (RemoteException e) {
			e.printStackTrace();
		}
				
		return id;
	}

	@Override
	public JavaBean1 modify(TransferOrderVO transferOrderVO) {
		transferOrderPO = new TransferOrderPO();
		this.transferOrderVO = transferOrderVO;
		
		this.transferOrderVO.setCarriage(generateFare(transferOrderVO.
				getDestination(), transferOrderVO.getTransportType()));
		VOtoPO();
		try {
			resultMessage = transferOrderdataservice.update(transferOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.transferOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage delete(ArrayList<String> idList) {
		try {
			resultMessage = transferOrderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = transferOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		transferOrderPO = (TransferOrderPO)javaBean1.getObject();
		this.transferOrderVO = new TransferOrderVO();
		
		if (javaBean1.getResultMessage() == ResultMessage.NotExist) {
			return javaBean1;
		}
		this.transferOrderVO.setID(transferOrderPO.getID());
		this.transferOrderVO.setLoadingDate(transferOrderPO.getLoadingDate());
		this.transferOrderVO.setCarriage(transferOrderPO.getCarriage());
		this.transferOrderVO.setOrigin(transferOrderPO.getOrigin());
		this.transferOrderVO.setDestination(transferOrderPO.getDestination());
		this.transferOrderVO.setFlightNum(transferOrderPO.getVehicleNum());
		this.transferOrderVO.setContainerNum(transferOrderPO.getContainerNum());
		this.transferOrderVO.setOrderIDs(transferOrderPO.getOrderIDs());
		this.transferOrderVO.setSupervisionMan(transferOrderPO.getSupervisionMan());
		this.transferOrderVO.setApproState(transferOrderPO.getApproState());
		this.transferOrderVO.setTransportType(transferOrderPO.getTransportType());
		
		javaBean1.setObject(transferOrderVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String time) {
		try {
			javaBean1 = transferOrderdataservice.findB(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<TransferOrderlineitemPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		lineitemPOtolineitemVO(k);
		
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public TransferOrderlineitemVO getTransferOrderlineitemVO(String id) {
		try {
			transferOrderlineitemPO = transferOrderdataservice.getTransferOrderlineitemPO(
					id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		lineitemPOtolineitemVO(1);
		return transferOrderlineitemVO;
	}

	public void VOtoPO() {
		this.transferOrderPO.setID(transferOrderVO.getID());
		this.transferOrderPO.setLoadingDate(transferOrderVO.getLoadingDate());
		this.transferOrderPO.setGenerateTime(transferOrderVO.getGenerateTime());
		this.transferOrderPO.setCarriage(transferOrderVO.getCarriage());
		this.transferOrderPO.setOrigin(transferOrderVO.getOrigin());
		this.transferOrderPO.setDestination(transferOrderVO.getDestination());
		this.transferOrderPO.setVehicleNum(transferOrderVO.getFlightNum());
		this.transferOrderPO.setContainerNum(transferOrderVO.getContainerNum());
		this.transferOrderPO.setOrderIDs(transferOrderVO.getOrderIDs());
		this.transferOrderPO.setSupervisionMan(transferOrderVO.getSupervisionMan());
		this.transferOrderPO.setApproState(transferOrderVO.getApproState());
		this.transferOrderPO.setTransportType(transferOrderVO.getTransportType());
	}

	public void lineitemPOtolineitemVO(int k) {
		arrayList2 = new ArrayList<TransferOrderlineitemVO>();
		
		for (int i = 0; i < k; i++) {
			transferOrderlineitemPO = arrayList.get(i);
			
			transferOrderlineitemVO = new TransferOrderlineitemVO();
			transferOrderlineitemVO.setApproState(transferOrderlineitemPO.
					getApproState());
			transferOrderlineitemVO.setCarriage(transferOrderlineitemPO.getCarriage());
			transferOrderlineitemVO.setDate(transferOrderlineitemPO.getDate());
			transferOrderlineitemVO.setEndAdd(transferOrderlineitemPO.getDestination());
			transferOrderlineitemVO.setId(transferOrderlineitemPO.getId());
			transferOrderlineitemVO.setTransportType(transferOrderlineitemPO.
					getTransportType());
			transferOrderlineitemVO.setVehiclesId(transferOrderlineitemPO.getVehiclesNum());
			transferOrderlineitemVO.setStartingAdd(transferOrderlineitemPO.
					getOrigin());
			
			arrayList2.add(transferOrderlineitemVO);
		}
		
	}

}
