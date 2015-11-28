package businesslogic.documentsbl;

import java.util.ArrayList;

import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;
import po.documentsPO.BusiHallArrivalOrderPO;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import bean.JavaBean1;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
/**
 * 
 * @author 周畅
 *
 */
public class BusiHallArrivalOrder implements BusiHallArrivalOrderblservice{
	private BusiHallArrivalOrderPO arrivalOrder4BusiHallPO;
	private BusiHallArrivalOrderVO arrivalOrder4BusiHallVO;
	private ArrayList<BusiHallArrivalOrderPO> arrayList;
	private ArrayList<BusiHallArrivalOrderVO> arrayList2;
	private TransferOrder transferOrder;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private BusiHallArrivalOrderdataservice arrivalOrder4BusiHalldataservice;
	private JavaBean1 javaBean1;
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
	public JavaBean1 addArrivalOrder4BusiHall(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO) {
		arrivalOrder4BusiHallPO = new BusiHallArrivalOrderPO();
		this.arrivalOrder4BusiHallVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		arrivalOrder4BusiHallPO.setArrivalDate(generateDate());
		arrivalOrder4BusiHallPO.setId(generateId());
		
		resultMessage = arrivalOrder4BusiHalldataservice.
			addBusiHallArrivalOrder(arrivalOrder4BusiHallPO);
	
		return null;
	}

	@Override
	public String generateId() {              //生成营业厅到达单Id
		//调用数据层方法，0000000七位数字往后顺延
		return null;
	}

	@Override
	public ResultMessage modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO ) {
		arrivalOrder4BusiHallPO = new BusiHallArrivalOrderPO();
		this.arrivalOrder4BusiHallVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		resultMessage = arrivalOrder4BusiHalldataservice.
				update(arrivalOrder4BusiHallPO);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		resultMessage = arrivalOrder4BusiHalldataservice.deleteOne(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		resultMessage = arrivalOrder4BusiHalldataservice.deleteMany(idlist);
	
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		javaBean1 = arrivalOrder4BusiHalldataservice.findA(id);
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		javaBean1 = arrivalOrder4BusiHalldataservice.findB(date);
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;	
	}
	
	@Override
	public ArrayList<BusiHallArrivalOrderVO> inquireC() {
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
		String transferOrderId = arrivalOrder4BusiHallVO.getTransferOrderID();
		arrivalOrder4BusiHallPO.setTransferOrderID(transferOrderId);
		arrivalOrder4BusiHallPO.setOrigin(generateStartAddress(transferOrderId));
		arrivalOrder4BusiHallPO.setGoodState(arrivalOrder4BusiHallVO.getGoodState());
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<BusiHallArrivalOrderVO>();
		
		for (int i = 0; i < k; i++) {
			arrivalOrder4BusiHallPO = arrayList.get(i);
			
			arrivalOrder4BusiHallVO = new BusiHallArrivalOrderVO();
			arrivalOrder4BusiHallVO.setId(arrivalOrder4BusiHallPO.getId());
			arrivalOrder4BusiHallVO.setTransferOrderID(arrivalOrder4BusiHallPO.getTransferOrderID());
			arrivalOrder4BusiHallVO.setOrigin(arrivalOrder4BusiHallPO.getOrigin());
			arrivalOrder4BusiHallVO.setGoodState(arrivalOrder4BusiHallPO.getGoodState());
			arrivalOrder4BusiHallVO.setArrivalDate(arrivalOrder4BusiHallPO.getArrivalDate());
			
			arrayList2.add(arrivalOrder4BusiHallVO);
		}

	}


}
