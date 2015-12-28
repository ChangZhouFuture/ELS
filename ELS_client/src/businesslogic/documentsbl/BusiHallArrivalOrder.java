package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;
import po.documentsPO.BusiHallArrivalOrderPO;
import state.ApproState;
import state.ResultMessage;
import vo.documentsVO.BusiHallArrivalOrderVO;
import vo.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.userbl.Login;
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
	private ResultMessage resultMessage;
	private String date;
	private JavaBean1 javaBean1 = new JavaBean1();
	
	public BusiHallArrivalOrder() {
		try {
			busiHallArrivalOrderdataservice = RMIHelper.
					getBusiHallArrivalOrderdataservice();	
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public JavaBean1 addBusiHallArrivalOrder(BusiHallArrivalOrderVO busiHallArrivalOrderVO) {
		busiHallArrivalOrderPO = new BusiHallArrivalOrderPO();
		this.busiHallArrivalOrderVO = busiHallArrivalOrderVO;
		
		this.busiHallArrivalOrderVO.setArrivalDate(generateDate());
		this.busiHallArrivalOrderVO.setGenerateTime(Time.generateTime());
		this.busiHallArrivalOrderVO.setId(generateId());
		this.busiHallArrivalOrderVO.setOrigin(Login.city);
		this.busiHallArrivalOrderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = busiHallArrivalOrderdataservice.
				addBusiHallArrivalOrder(busiHallArrivalOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.busiHallArrivalOrderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	public String generateId() {              
		//生成营业厅到达单Id
		//调用数据层方法，0000000七位数字往后顺延
		String id = null;
		try {
			id = busiHallArrivalOrderdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		return id;
	}

	@Override
	public JavaBean1 modify(BusiHallArrivalOrderVO arrivalOrder4BusiHallVO ) {
		busiHallArrivalOrderPO = new BusiHallArrivalOrderPO();
		this.busiHallArrivalOrderVO = arrivalOrder4BusiHallVO;
		
		VOtoPO();
		try {
			resultMessage = busiHallArrivalOrderdataservice.
					update(busiHallArrivalOrderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.busiHallArrivalOrderVO);
		javaBean1.setResultMessage(resultMessage);
	
		return javaBean1;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		try {
			resultMessage = busiHallArrivalOrderdataservice.deleteMany(idlist);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = busiHallArrivalOrderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = busiHallArrivalOrderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<BusiHallArrivalOrderPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;	
	}

	public void VOtoPO() {
		String transferOrderId = busiHallArrivalOrderVO.getTransferOrderID();
		busiHallArrivalOrderPO.setTransferOrderID(transferOrderId);
		busiHallArrivalOrderPO.setOrigin(busiHallArrivalOrderVO.getOrigin());
		busiHallArrivalOrderPO.setGoodState(busiHallArrivalOrderVO.getGoodState());
		busiHallArrivalOrderPO.setArrivalDate(busiHallArrivalOrderVO.getArrivalDate());
		busiHallArrivalOrderPO.setGenerateTime(busiHallArrivalOrderVO.getGenerateTime());
		busiHallArrivalOrderPO.setId(busiHallArrivalOrderVO.getId());
		busiHallArrivalOrderPO.setApproState(busiHallArrivalOrderVO.getApproState());
	}

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
			busiHallArrivalOrderVO.setApproState(busiHallArrivalOrderPO.getApproState());
			
			arrayList2.add(busiHallArrivalOrderVO);
		}

	}


}
