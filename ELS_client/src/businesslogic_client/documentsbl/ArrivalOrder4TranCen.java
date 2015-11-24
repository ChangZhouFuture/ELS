package businesslogic_client.documentsbl;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import dataservice_client.documentsdataservice.ArrivalOrder4TranCendataservice;
import po_client.documentsPO.ArrivalOrder4BusiHallPO;
import po_client.documentsPO.ArrivalOrder4TranCenPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4BusiHalllineitemPO;
import po_client.lineitemPO.documentslineitemPO.ArrivalOrder4TranCenlineitemPO;
import po_client.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4TranCenVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4TranCenlineitemVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import businesslogicservice_client.documentsblservice.ArrivalOrder4TranCenblservice;

public class ArrivalOrder4TranCen implements ArrivalOrder4TranCenblservice {
	private ArrivalOrder4TranCenVO arrivalOrder4TranCenVO;
	private ArrivalOrder4TranCenPO arrivalOrder4TranCenPO;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private ArrivalOrder4TranCendataservice arrivalOrder4TranCendataservice;
	private ArrayList<TransferOrderlineitemPO> arrayList1;
	private ArrayList<TransferOrderlineitemVO> arrayList2;
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
		resultMessage = arrivalOrder4TranCendataservice.deleteone(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		resultMessage = arrivalOrder4TranCendataservice.deleteMany(idList);
		
		return resultMessage;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireA(String id) {
		
		
		return null;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenVO> inquireB(String time) {
		
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POtoVO() {
		// TODO Auto-generated method stub
		
	}

	

}
