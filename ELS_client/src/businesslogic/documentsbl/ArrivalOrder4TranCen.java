package businesslogic.documentsbl;

import java.util.ArrayList;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;
import po.documentsPO.ArrivalOrder4TranCenPO;
import state.ResultMessage;
import vo.documentsVO.ArrivalOrder4TranCenVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice.documentsblservice.ArrivalOrder4TranCenblservice;

public class ArrivalOrder4TranCen implements ArrivalOrder4TranCenblservice {
	private ArrivalOrder4TranCenVO arrivalOrder4TranCenVO;
	private ArrivalOrder4TranCenPO arrivalOrder4TranCenPO;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private ArrivalOrder4TranCendataservice arrivalOrder4TranCendataservice;
	private ArrayList<ArrivalOrder4TranCenPO> arrayList1;
	private ArrayList<ArrivalOrder4TranCenVO> arrayList2;
	private TransferOrder transferOrder;
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
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO) {
		arrivalOrder4TranCenPO = new ArrivalOrder4TranCenPO();
		this.arrivalOrder4TranCenVO = arrivalOrder4TranCenVO;
		
		VOtoPO();
		arrivalOrder4TranCenPO.setDate(generateDate());
		arrivalOrder4TranCenPO.setId(generateId());
		
		resultMessage = arrivalOrder4TranCendataservice.
				addArrivalOrder4TranCen(arrivalOrder4TranCenPO);
		return resultMessage;
	}

	@Override
	public String generateId() {
		
		
		return null;
	}

	@Override
	public ResultMessage modify(ArrivalOrder4TranCenVO arrivalOrder4TranCenVO) {
		arrivalOrder4TranCenPO = new ArrivalOrder4TranCenPO();
		this.arrivalOrder4TranCenVO = arrivalOrder4TranCenVO;
		
		VOtoPO();
		resultMessage = arrivalOrder4TranCendataservice.
				update(arrivalOrder4TranCenPO);
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		resultMessage = arrivalOrder4TranCendataservice.deleteOne(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		resultMessage = arrivalOrder4TranCendataservice.deleteMany(idList);
		
		return resultMessage;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireA(String id) {
		arrayList1 = arrivalOrder4TranCendataservice.findA(id);
		POtoVO(1);
		return arrayList2;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireB(String time) {
		arrayList1 = arrivalOrder4TranCendataservice.findB(time);
		int k = arrayList1.size();
		
		POtoVO(k);
		return arrayList2;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireC() {
		
		
		return null;
	}

	@Override
	public void VOtoPO() {
		String transferOrderId = arrivalOrder4TranCenVO.getTransferOrderId();
		arrivalOrder4TranCenPO.setTransferOrderid(transferOrderId);
		arrivalOrder4TranCenPO.setStartingAdd(generateStartAddress(transferOrderId));
		arrivalOrder4TranCenPO.setGoodState(arrivalOrder4TranCenVO.getGoodState());
	}

	@Override
	public void end() {
		
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<ArrivalOrder4TranCenVO>();
		
		for (int i = 0; i < k; i++) {
			arrivalOrder4TranCenPO = arrayList1.get(i);
			
			arrivalOrder4TranCenVO = new ArrivalOrder4TranCenVO();
			arrivalOrder4TranCenVO.setId(arrivalOrder4TranCenPO.getId());
			arrivalOrder4TranCenVO.setDate(arrivalOrder4TranCenPO.getDate());
			arrivalOrder4TranCenVO.setTransferOrderId(arrivalOrder4TranCenPO.getTransferOrderid());
			arrivalOrder4TranCenVO.setStartingAdd(arrivalOrder4TranCenPO.getStartingAdd());
			arrivalOrder4TranCenVO.setGoodState(arrivalOrder4TranCenPO.getGoodState());
		}
	}

	

}
