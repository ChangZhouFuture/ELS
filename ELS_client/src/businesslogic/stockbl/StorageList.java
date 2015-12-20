package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.stockPO.StorageListPO;
import dataservice.stockdataservice.StorageListdataservice;
import state.ApproState;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.stockVO.StorageListVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.stockblservice.StorageListblservice;
/**
 * 
 * @author 周畅
 *
 */
public class StorageList implements StorageListblservice {
	private StorageListdataservice storageListdataservice;
	private StorageListVO storageListVO;
	private StorageListPO storageListPO;
	private ArrayList<StorageListPO> arrayList;
	private ArrayList<StorageListVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	private String date;
	
	public StorageList() {
		try {
			storageListdataservice = RMIHelper.getStorageListdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderlineitemVO addExpress(String expressID) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(expressID);
		
		return orderlineitemVO;
	}

	public String generateId() {
		//调用数据层方法
		return null;
	}

	public String generateTime() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public JavaBean1 add(StorageListVO storageListVO) {
		storageListPO = new StorageListPO();
		this.storageListVO = storageListVO;
		
		this.storageListVO.setApproState(ApproState.NotApprove);
		this.storageListVO.setInDate(generateTime());
		this.storageListVO.setId(generateId());
		VOtoPO();
		
		try {
			resultMessage = storageListdataservice.add(storageListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.storageListVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteone(String id4obo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> IDList) {
		try {
			resultMessage = storageListdataservice.deleteMany(IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public ResultMessage modify(StorageListVO storageListVO) {
		storageListPO = new StorageListPO();
		this.storageListVO = storageListVO;
		
		VOtoPO();
		try {
			resultMessage = storageListdataservice.update(storageListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String ID) {
		try {
			javaBean1 = storageListdataservice.findA(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<StorageListPO>)javaBean1.getObject();
		
		POtoVO(1);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = storageListdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<StorageListPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		
		return javaBean1;
	}

	public void VOtoPO() {
		storageListPO.setId(storageListVO.getId());
		storageListPO.setInDate(storageListVO.getInDate());
		storageListPO.setApproState(storageListVO.getApproState());
		storageListPO.setDestination(storageListVO.getDestination());
		storageListPO.setOrderID(storageListVO.getOrderID());
		storageListPO.setAreaNum(storageListVO.getAreaNum());
		storageListPO.setFrameNum(storageListVO.getFrameNum());
		storageListPO.setPositionNum(storageListVO.getPositionNum());
		storageListPO.setRowNum(storageListVO.getRowNum());
	}
	
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<StorageListVO>();
		
		for (int i = 0; i < k; i++) {
			storageListPO = arrayList.get(i);
			
			storageListVO = new StorageListVO();
			storageListVO.setId(storageListPO.getId());
			storageListVO.setInDate(storageListPO.getInDate());
			storageListVO.setApproState(storageListPO.getApproState());
			storageListVO.setOrderID(storageListPO.getOrderID());
			storageListVO.setAreaNum(storageListPO.getAreaNum());
			storageListVO.setFrameNum(storageListPO.getFrameNum());
			storageListVO.setRowNum(storageListPO.getRowNum());
			storageListVO.setPositionNum(storageListPO.getPositionNum());
			storageListVO.setDestination(storageListPO.getDestination());
			
			arrayList2.add(storageListVO);
		}
	}

}
