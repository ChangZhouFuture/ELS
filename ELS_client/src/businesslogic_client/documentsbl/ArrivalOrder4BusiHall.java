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
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private TransferOrderlineitemPO transferOrderlineitemPO;
	private ArrivalOrder4BusiHalldataservice arrivalOrder4BusiHalldataservice;
	private ArrayList<ArrivalOrder4BusiHalllineitemPO> arrayList;
	private ArrayList<ArrivalOrder4BusiHalllineitemVO> arrayList2;
	
	@Override
	public String generateStartAddress(String transferOrderId) {
		//根据中转中心的编号来匹配位置
		
		return null;
	}

	@Override
	public TransferOrderlineitemVO addTransferOrder(String id) {
		transferOrderlineitemPO = arrivalOrder4BusiHalldataservice.addTransferOrder(id);
		transferOrderlineitemVO = new TransferOrderlineitemVO();
		
		transferOrderlineitemVO.setCarriage(transferOrderlineitemPO.getCarriage());
		transferOrderlineitemVO.setDate(transferOrderlineitemPO.getDate());
		transferOrderlineitemVO.setStartingAdd(transferOrderlineitemPO.getStartingAdd());
		transferOrderlineitemVO.setEndAdd(transferOrderlineitemPO.getEndAdd());
		transferOrderlineitemVO.setId(transferOrderlineitemPO.getId());
		transferOrderlineitemVO.setTransportType(transferOrderlineitemPO.getTransportType());
		transferOrderlineitemVO.setVehiclesId(transferOrderlineitemPO.getVehiclesId());
		
		return transferOrderlineitemVO;
	}

	@Override
	public String generateDate() {
		
		return null;
	}

	@Override
	public void addArrivalOrder4BusiHall(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO) {
		arrivalOrder4BusiHallPO = new ArrivalOrder4BusiHallPO();
		
		VOtoPO(arrivalOrder4BusiHallVO);
		arrivalOrder4BusiHallPO.setDate(generateDate());
		arrivalOrder4BusiHallPO.setId(generateId());
		
		arrivalOrder4BusiHalldataservice.addArrivalOrder4BusiHall(arrivalOrder4BusiHallPO);
	}

	@Override
	public String generateId() {
		//调用数据层方法，0000000七位数字往后顺延
		return null;
	}

	@Override
	public void modify(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO ) {
		arrivalOrder4BusiHallPO = new ArrivalOrder4BusiHallPO();
		
		VOtoPO(arrivalOrder4BusiHallVO);
		arrivalOrder4BusiHalldataservice.modify(arrivalOrder4BusiHallPO);
		arrivalOrder4BusiHallPO = null;
	}

	@Override
	public ResultMessage deleteone(String id) {
		ResultMessage resultMessage = arrivalOrder4BusiHalldataservice.deleteone(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		ResultMessage resultMessage = arrivalOrder4BusiHalldataservice.deleteMany(idlist);
	
		return resultMessage;
	}

	@Override
	public ArrivalOrder4BusiHallVO inquireA(String id) {
		arrivalOrder4BusiHallPO = arrivalOrder4BusiHalldataservice.inquireA(id);
		arrivalOrder4BusiHallVO = new ArrivalOrder4BusiHallVO();
		
		arrivalOrder4BusiHallVO.setDate(arrivalOrder4BusiHallPO.getDate());
		arrivalOrder4BusiHallVO.setGoodState(arrivalOrder4BusiHallPO.getGoodState());
		arrivalOrder4BusiHallVO.setId(arrivalOrder4BusiHallPO.getId());
		arrivalOrder4BusiHallVO.setStartingAdd(arrivalOrder4BusiHallPO.getStartingAdd());
		arrivalOrder4BusiHallVO.setTransferOrderId(arrivalOrder4BusiHallPO.getTransferOrderId());
		return arrivalOrder4BusiHallVO;
	}

	@Override
	public ArrayList<ArrivalOrder4BusiHalllineitemVO> inquireB(String date) {
		arrayList = arrivalOrder4BusiHalldataservice.inquireB(date);
		arrayList2 = new ArrayList<ArrivalOrder4BusiHalllineitemVO>();
		
		int i = 0;
		while (arrayList.get(i)!=null) {
			//还没写完
			i++;
		}
		
		return arrayList2;
	}
	
	@Override
	public ArrayList<ArrivalOrder4BusiHalllineitemVO> inquireC() {
		arrayList = arrivalOrder4BusiHalldataservice.inquireC();
		arrayList2 = new ArrayList<ArrivalOrder4BusiHalllineitemVO>();
		
		//处理把PO转成VO
		return arrayList2;
	}

	@Override
	public void end() {
		
	}

	@Override
	public void VOtoPO(ArrivalOrder4BusiHallVO arrivalOrder4BusiHallVO) {
		String transferOrderId = arrivalOrder4BusiHallVO.getTransferOrderId();
		arrivalOrder4BusiHallPO.setTransferOrderId(transferOrderId);
		arrivalOrder4BusiHallPO.setStartingAdd(generateStartAddress(transferOrderId));
		arrivalOrder4BusiHallPO.setGoodState(arrivalOrder4BusiHallVO.getGoodState());
	}

	@Override
	public void POlineitemToVOlineitem() {
		
	}

}
