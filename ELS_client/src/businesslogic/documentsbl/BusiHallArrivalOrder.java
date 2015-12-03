package businesslogic.documentsbl;

import java.util.ArrayList;
import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;
import po.documentsPO.BusiHallArrivalOrderPO;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.BusiHallArrivalOrderblservice;
/**
 * 
 * @author 周畅
 *
 */
public class BusiHallArrivalOrder implements BusiHallArrivalOrderblservice{
	private BusiHallArrivalOrderdataservice busiHallArrivalOrderdataservice;
	private BusiHallArrivalOrderPO busiHallArrivalOrderPO;
	private BusiHallArrivalOrderVO busiHallArrivalOrderVO;
	private ArrayList<BusiHallArrivalOrderPO> arrayList;
	private ArrayList<BusiHallArrivalOrderVO> arrayList2;
	private TransferOrder transferOrder;
	private TransferOrderlineitemVO transferOrderlineitemVO;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	private String date;
	
	public BusiHallArrivalOrder() {
		try {
			busiHallArrivalOrderdataservice = RMIHelper.
					getBusiHallArrivalOrderdataservice();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public String generateStartAddress(String transferOrderId) {
		//根据中转中心的编号来匹配位置
		String startAdd = busiHallArrivalOrderdataservice.generateStartAdd(transferOrderId);
		return startAdd;
	}

	@Override
	public TransferOrderlineitemVO addTransferOrder(String id) {
		transferOrderlineitemVO = transferOrder.getTransferOrderlineitemVO(id);
		
		return transferOrderlineitemVO;
	}

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public JavaBean1 addBusiHallArrivalOrder(BusiHallArrivalOrderVO busiHallArrivalOrderVO) {
		busiHallArrivalOrderPO = new BusiHallArrivalOrderPO();
		this.busiHallArrivalOrderVO = busiHallArrivalOrderVO;
		
		this.busiHallArrivalOrderVO.setArrivalDate(generateDate());
		this.busiHallArrivalOrderVO.setId(generateId());
		VOtoPO();
		
		resultMessage = busiHallArrivalOrderdataservice.
			addBusiHallArrivalOrder(busiHallArrivalOrderPO);
		javaBean1.setObject(this.busiHallArrivalOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public String generateId() {              
		//生成营业厅到达单Id
		//调用数据层方法，0000000七位数字往后顺延
		String id = busiHallArrivalOrderdataservice.generateId(date);	
		return id;
	}

	@Override
	public ResultMessage modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO ) {
		busiHallArrivalOrderPO = new BusiHallArrivalOrderPO();
		this.busiHallArrivalOrderVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		resultMessage = busiHallArrivalOrderdataservice.
				update(busiHallArrivalOrderPO);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		resultMessage = busiHallArrivalOrderdataservice.deleteOne(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		resultMessage = busiHallArrivalOrderdataservice.deleteMany(idlist);
	
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		javaBean1 = busiHallArrivalOrderdataservice.findA(id);
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		javaBean1 = busiHallArrivalOrderdataservice.findB(date);
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;	
	}
	
	@Override
	public ArrayList<BusiHallArrivalOrderVO> inquireC() {
		arrayList = busiHallArrivalOrderdataservice.findC();
		int k = arrayList.size();
		
		POtoVO(k);
		return arrayList2;
	}

	@Override
	public void end() {
		
	}

	@Override
	public void VOtoPO() {
		String transferOrderId = busiHallArrivalOrderVO.getTransferOrderID();
		busiHallArrivalOrderPO.setTransferOrderID(transferOrderId);
		busiHallArrivalOrderPO.setOrigin(generateStartAddress(transferOrderId));
		busiHallArrivalOrderPO.setGoodState(busiHallArrivalOrderVO.getGoodState());
		busiHallArrivalOrderPO.setArrivalDate(busiHallArrivalOrderVO.getArrivalDate());
		busiHallArrivalOrderPO.setId(busiHallArrivalOrderVO.getId());
	}

	@Override
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<BusiHallArrivalOrderVO>();
		
		for (int i = 0; i < k; i++) {
			busiHallArrivalOrderPO = arrayList.get(i);
			
			busiHallArrivalOrderVO = new BusiHallArrivalOrderVO();
			busiHallArrivalOrderVO.setId(busiHallArrivalOrderPO.getId());
			busiHallArrivalOrderVO.setTransferOrderID(busiHallArrivalOrderPO.getTransferOrderID());
			busiHallArrivalOrderVO.setOrigin(busiHallArrivalOrderPO.getOrigin());
			busiHallArrivalOrderVO.setGoodState(busiHallArrivalOrderPO.getGoodState());
			busiHallArrivalOrderVO.setArrivalDate(busiHallArrivalOrderPO.getArrivalDate());
			
			arrayList2.add(busiHallArrivalOrderVO);
		}

	}


}
