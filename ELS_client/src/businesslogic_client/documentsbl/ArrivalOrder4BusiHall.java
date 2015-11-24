package businesslogic_client.documentsbl;

import java.util.ArrayList;

import dataservice_client.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import po_client.documentsPO.ArrivalOrder4BusiHallPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4BusiHallblservice;
/**
 * 
 * @author 周畅
 *
 */
public class ArrivalOrder4BusiHall implements ArrivalOrder4BusiHallblservice{
	private ArrivalOrder4BusiHallPO arrivalOrder4BusiHallPO;
	private ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO;
	private ArrayList<ArrivalOrder4BusiHallPO> arrayList;
	private ArrayList<ArrivalOrder4BusiHallVO> arrayList2;
	private TransferOrder transferOrder;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private ArrivalOrder4BusiHalldataservice arrivalOrder4BusiHalldataservice;
	private ResultMessage resultMessage;
	
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
	public ResultMessage addArrivalOrder4BusiHall(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO) {
		arrivalOrder4BusiHallPO = new ArrivalOrder4BusiHallPO();
		this.arrivalOrder4BusiHallVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		arrivalOrder4BusiHallPO.setDate(generateDate());
		arrivalOrder4BusiHallPO.setId(generateId());
		
		resultMessage = arrivalOrder4BusiHalldataservice.
			addArrivalOrder4BusiHall(arrivalOrder4BusiHallPO);
	
		return resultMessage;
	}

	@Override
	public String generateId() {
		//调用数据层方法，0000000七位数字往后顺延
		return null;
	}

	@Override
	public ResultMessage modify(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO ) {
		arrivalOrder4BusiHallPO = new ArrivalOrder4BusiHallPO();
		this.arrivalOrder4BusiHallVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		resultMessage = arrivalOrder4BusiHalldataservice.
				update(arrivalOrder4BusiHallPO);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		resultMessage = arrivalOrder4BusiHalldataservice.deleteone(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		resultMessage = arrivalOrder4BusiHalldataservice.deleteMany(idlist);
	
		return resultMessage;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallVO> inquireA(String id) {
		arrivalOrder4BusiHallPO = arrivalOrder4BusiHalldataservice.findA(id);
		
		POtoVO(1);
		return arrayList2;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHallVO> inquireB(String date) {
		arrayList = arrivalOrder4BusiHalldataservice.findB(date);
		int k = arrayList.size();
		
		POtoVO(k);
		return arrayList2;	
	}
	
	@Override
	public ArrayList<ArrivalOrder4BusiHallVO> inquireC() {
		arrayList = arrivalOrder4BusiHalldataservice.findC();
		int k = arrayList.size();
		
		POtoVO(k);
		return arrayList2;
	}

	@Override
	public void end() {
		
	}

	@Override
	public void VOtoPO() {
		String transferOrderId = arrivalOrder4BusiHallVO.getTransferOrderId();
		arrivalOrder4BusiHallPO.setTransferOrderId(transferOrderId);
		arrivalOrder4BusiHallPO.setStartingAdd(generateStartAddress(transferOrderId));
		arrivalOrder4BusiHallPO.setGoodState(arrivalOrder4BusiHallVO.getGoodState());
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<ArrivalOrder4BusiHallVO>();
		
		for (int i = 0; i < k; i++) {
			arrivalOrder4BusiHallPO = arrayList.get(i);
			
			arrivalOrder4BusiHallVO = new ArrivalOrder4BusiHallVO();
			arrivalOrder4BusiHallVO.setId(arrivalOrder4BusiHallPO.getId());
			arrivalOrder4BusiHallVO.setTransferOrderId(arrivalOrder4BusiHallPO.getTransferOrderId());
			arrivalOrder4BusiHallVO.setStartingAdd(arrivalOrder4BusiHallPO.getStartingAdd());
			arrivalOrder4BusiHallVO.setGoodState(arrivalOrder4BusiHallPO.getGoodState());
			arrivalOrder4BusiHallVO.setDate(arrivalOrder4BusiHallPO.getDate());
			
			arrayList2.add(arrivalOrder4BusiHallVO);
		}

	}


}
