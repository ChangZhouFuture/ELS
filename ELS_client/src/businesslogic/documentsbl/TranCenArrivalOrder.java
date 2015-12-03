package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;
import po.documentsPO.TranCenArrivalOrderPO;
import state.ResultMessage;
import vo.documentsVO.TranCenArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import bean.JavaBean1;
import businesslogicservice.documentsblservice.TranCenArrivalOrderblservice;

public class TranCenArrivalOrder implements TranCenArrivalOrderblservice {
	private TranCenArrivalOrderVO arrivalOrder4TranCenVO;
	private TranCenArrivalOrderPO arrivalOrder4TranCenPO;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private TranCenArrivalOrderdataservice arrivalOrder4TranCendataservice;
	private ArrayList<TranCenArrivalOrderPO> arrayList1;
	private ArrayList<TranCenArrivalOrderVO> arrayList2;
	private TransferOrder transferOrder;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	private Class class1;
	
	@Override
	public String generateStartAddress(String transferOrderId) {
		//根据中转中心的编号来匹配位置
		
		return null;
	}

	@Override
	public TransferOrderlineitemVO addTransferOrder(String id) {
		transferOrderlineitemVO = transferOrder.getTransferOrderlineitemVO(id);
		
		return transferOrderlineitemVO;
	}

	@Override
	public String generateDate() {
		
		
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4TranCen(TranCenArrivalOrderVO arrivalOrder4TranCenVO) {
		arrivalOrder4TranCenPO = new TranCenArrivalOrderPO();
		this.arrivalOrder4TranCenVO = arrivalOrder4TranCenVO;
		
		VOtoPO();
		arrivalOrder4TranCenPO.setArrivalDate(generateDate());
		arrivalOrder4TranCenPO.setID(generateId());
		
		try {
			resultMessage = arrivalOrder4TranCendataservice.
					addTranCenArrivalOrder(arrivalOrder4TranCenPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public String generateId() {
		
		
		return null;
	}

	@Override
	public ResultMessage modify(TranCenArrivalOrderVO arrivalOrder4TranCenVO) {
		arrivalOrder4TranCenPO = new TranCenArrivalOrderPO();
		this.arrivalOrder4TranCenVO = arrivalOrder4TranCenVO;
		
		VOtoPO();
		try {
			resultMessage = arrivalOrder4TranCendataservice.
					update(arrivalOrder4TranCenPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		try {
			resultMessage = arrivalOrder4TranCendataservice.deleteOne(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = arrivalOrder4TranCendataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = arrivalOrder4TranCendataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList1 = (ArrayList<TranCenArrivalOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String time) {
		try {
			javaBean1 = arrivalOrder4TranCendataservice.findB(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int k = arrayList1.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public ArrayList<TranCenArrivalOrderVO> inquireC() {
		
		
		return null;
	}

	@Override
	public void VOtoPO() {
		String transferOrderId = arrivalOrder4TranCenVO.getTransferOrderID();
		arrivalOrder4TranCenPO.setTransferOrderID(transferOrderId);
		arrivalOrder4TranCenPO.setOrigin(generateStartAddress(transferOrderId));
		arrivalOrder4TranCenPO.setGoodState(arrivalOrder4TranCenVO.getGoodState());
	}

	@Override
	public void end() {
		
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<TranCenArrivalOrderVO>();
		
		for (int i = 0; i < k; i++) {
			arrivalOrder4TranCenPO = arrayList1.get(i);
			
			arrivalOrder4TranCenVO = new TranCenArrivalOrderVO();
			arrivalOrder4TranCenVO.setID(arrivalOrder4TranCenPO.getID());
			arrivalOrder4TranCenVO.setArrivalDate(arrivalOrder4TranCenPO.getArrivalDate());
			arrivalOrder4TranCenVO.setTransferOrderID(arrivalOrder4TranCenPO.getTransferOrderID());
			arrivalOrder4TranCenVO.setOrigin(arrivalOrder4TranCenPO.getOrigin());
			arrivalOrder4TranCenVO.setGoodState(arrivalOrder4TranCenPO.getGoodState());
		}
	}

	

}
