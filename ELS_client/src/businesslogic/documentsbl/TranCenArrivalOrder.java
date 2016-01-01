package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;
import po.documentsPO.TranCenArrivalOrderPO;
import state.AgencyType;
import state.ApproState;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;

public class TranCenArrivalOrder implements TranCenArrivalOrderblservice {
	private TranCenArrivalOrderVO tranCenArrivalOrderVO;
	private TranCenArrivalOrderPO tranCenArrivalOrderPO;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private TranCenArrivalOrderdataservice tranCenArrivalOrderdataservice;
	private ArrayList<TranCenArrivalOrderPO> arrayList1;
	private ArrayList<TranCenArrivalOrderVO> arrayList2;
	private TransferOrder transferOrder;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	private String date;
	
	public TranCenArrivalOrder(){
		try {
			tranCenArrivalOrderdataservice = RMIHelper.getTranCenArrivalOrderdataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String generateStartAddress(String transferOrderId) {
		//根据中转中心的编号来匹配位置
		String startAdd = null;
		try {
			startAdd = tranCenArrivalOrderdataservice.generateStartAdd(transferOrderId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return startAdd;
	}

	@Override
	public TransferOrderlineitemVO addTransferOrder(String id) {
		transferOrderlineitemVO = transferOrder.getTransferOrderlineitemVO(id);
		return transferOrderlineitemVO;
	}

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public JavaBean1 addTranCenArivalOrder(TranCenArrivalOrderVO tranCenArrivalOrderVO) {
		tranCenArrivalOrderPO = new TranCenArrivalOrderPO();
		this.tranCenArrivalOrderVO = tranCenArrivalOrderVO;
		
		if (tranCenArrivalOrderVO.getAgencyType() == AgencyType.BusinessHall) {
			this.tranCenArrivalOrderVO.setOrigin(Login.city);
		} else {
			this.tranCenArrivalOrderVO.setOrigin(generateStartAddress(
					tranCenArrivalOrderVO.getTransferOrderID()));
		}
		
		this.tranCenArrivalOrderVO.setArrivalDate(generateDate());
		this.tranCenArrivalOrderVO.setGenerateTime(Time.generateTime());
		this.tranCenArrivalOrderVO.setID(generateId());
		this.tranCenArrivalOrderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = tranCenArrivalOrderdataservice.addTranCenArrivalOrder
					(this.tranCenArrivalOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.tranCenArrivalOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	public String generateId() {
		String id = null;
		try {
			id = tranCenArrivalOrderdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		return id;
	}

	@Override
	public JavaBean1 modify(TranCenArrivalOrderVO tranCenArrivalOrderVO) {
		tranCenArrivalOrderPO = new TranCenArrivalOrderPO();
		this.tranCenArrivalOrderVO = tranCenArrivalOrderVO;
		
		this.tranCenArrivalOrderVO.setOrigin(generateStartAddress(
				tranCenArrivalOrderVO.getTransferOrderID()));
		VOtoPO();
		try {
			resultMessage = tranCenArrivalOrderdataservice.update(tranCenArrivalOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1 = new JavaBean1();
		javaBean1.setObject(this.tranCenArrivalOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = tranCenArrivalOrderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = tranCenArrivalOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList1 = (ArrayList<TranCenArrivalOrderPO>)javaBean1.getObject();
		
		if (javaBean1.getResultMessage() == ResultMessage.NotExist) {
			return javaBean1;
		}
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = tranCenArrivalOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList1 = (ArrayList<TranCenArrivalOrderPO>)javaBean1.getObject();
		int k = arrayList1.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
		
	}

	public void VOtoPO() {
		tranCenArrivalOrderPO.setArrivalDate(tranCenArrivalOrderVO.getArrivalDate());
		tranCenArrivalOrderPO.setGenerateTime(tranCenArrivalOrderVO.getGenerateTime());
		tranCenArrivalOrderPO.setGoodState(tranCenArrivalOrderVO.getGoodState());
		tranCenArrivalOrderPO.setID(tranCenArrivalOrderVO.getID());
		tranCenArrivalOrderPO.setOrigin(tranCenArrivalOrderVO.getOrigin());
		tranCenArrivalOrderPO.setTranCenID(tranCenArrivalOrderVO.getTranCenID());
		tranCenArrivalOrderPO.setTransferOrderID(tranCenArrivalOrderVO.
				getTransferOrderID());
		tranCenArrivalOrderPO.setAgencyType(tranCenArrivalOrderVO.getAgencyType());
		tranCenArrivalOrderPO.setApproState(tranCenArrivalOrderVO.getApproState());
	}
	
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<TranCenArrivalOrderVO>();
		
		for (int i = 0; i < k; i++) {
			tranCenArrivalOrderPO = arrayList1.get(i);
			
			tranCenArrivalOrderVO = new TranCenArrivalOrderVO();
			tranCenArrivalOrderVO.setID(tranCenArrivalOrderPO.getID());
			tranCenArrivalOrderVO.setArrivalDate(tranCenArrivalOrderPO.getArrivalDate());
			tranCenArrivalOrderVO.setTranCenID(tranCenArrivalOrderPO.getTranCenID());
			tranCenArrivalOrderVO.setTransferOrderID(tranCenArrivalOrderPO.
					getTransferOrderID());
			tranCenArrivalOrderVO.setAgencyType(tranCenArrivalOrderPO.getAgencyType());
			tranCenArrivalOrderVO.setOrigin(tranCenArrivalOrderPO.getOrigin());
			tranCenArrivalOrderVO.setGoodState(tranCenArrivalOrderPO.getGoodState());
			tranCenArrivalOrderVO.setApproState(tranCenArrivalOrderPO.getApproState());
			
			arrayList2.add(tranCenArrivalOrderVO);
		}
	}

}
