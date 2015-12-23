package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;
import state.ResultMessage;
import state.TransportType;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.userbl.Login;
import businesslogic.utilitybl.CalculateFreight;
import businesslogic.utilitybl.Time;
import businesslogic.utilitybl.UpdateLogisticsInfor;
import businesslogicservice.documentsblservice.BusiHallLoadingListblservice;
/**
 * 
 * @author 
 *
 */
public class BusiHallLoadingList implements BusiHallLoadingListblservice{
	private BusiHallLoadingListdataservice busiHallLoadingListdtaservice;
	private BusiHallLoadingListVO busiHallLoadingListVO;
	private BusiHallLoadingListPO busiHallLoadingListPO;
	private BusiHallLoadingListlineitemPO busiHallLoadingListlineitemPO;
	private BusiHallLoadingListlineitemVO busiHallLoadingListlineitemVO;
	private ArrayList<BusiHallLoadingListlineitemPO> arrayList;
	private ArrayList<BusiHallLoadingListlineitemVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private UpdateLogisticsInfor updateLogisticsInfor;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	private String date;
	
	
	public BusiHallLoadingList() {
		try {
			busiHallLoadingListdtaservice = RMIHelper.
					getBuinessHallLoadingListdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderlineitemVO addOrder(String orderId) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(orderId);
		return orderlineitemVO;
	}

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	public String generatevehiclesID() {
		//调用数据层方法,自动生成 营业厅编号+20150921日期+00000编码 、五位数字
		String vehiclesID = null;
		try {
			vehiclesID = Login.agencyID +date+busiHallLoadingListdtaservice.
					generateId(date);//这里要改
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vehiclesID;
	}

	public double generateFreight(String destination, TransportType tType) 
	{
		double freight = CalculateFreight.transportCost(destination, tType);
		return freight;
	}

	@Override
	public JavaBean1 addBusinessHallLoadingList(BusiHallLoadingListVO businessHallLoadingListVO) {
		busiHallLoadingListPO = new BusiHallLoadingListPO();
		this.busiHallLoadingListVO = businessHallLoadingListVO;
		
		this.busiHallLoadingListVO.setBusiHallID(Login.agencyID);
		this.busiHallLoadingListVO.setLoadingDate(generateDate());
		this.busiHallLoadingListVO.setGenerateTime(Time.generateTime());
		this.busiHallLoadingListVO.setVehiclesID(generatevehiclesID());
		this.busiHallLoadingListVO.setCarriage(generateFreight(
				businessHallLoadingListVO.getDestination(), TransportType.Truck));
		this.busiHallLoadingListVO.setID(generateId());
		VOtoPO();
		
		try {
			resultMessage = busiHallLoadingListdtaservice.addLoadingList(busiHallLoadingListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			updateLogisticsInfor = new UpdateLogisticsInfor();
			ArrayList<String> orderIDs = this.busiHallLoadingListVO.getOrderIDs();
			String orderID;
			for (int i = 0; i < orderIDs.size(); i++) {
				orderID = orderIDs.get(i);
				updateLogisticsInfor.update(date, orderID, date + " 订单已在" + 
				Login.city + Login.region +"营业厅装车");
			}
		}
		javaBean1.setObject(this.busiHallLoadingListVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	public String generateId() {
		//调用数据层方法
		String id = null;
		try {
			id = busiHallLoadingListdtaservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public ResultMessage modify(BusiHallLoadingListVO businessHallLoadingListVO) {
		busiHallLoadingListPO = new BusiHallLoadingListPO();
		this.busiHallLoadingListVO = businessHallLoadingListVO;
		
		VOtoPO();
		try {
			resultMessage = busiHallLoadingListdtaservice.update(busiHallLoadingListPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		try {
			resultMessage = busiHallLoadingListdtaservice.deleteone(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = busiHallLoadingListdtaservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = busiHallLoadingListdtaservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		busiHallLoadingListPO = (BusiHallLoadingListPO)javaBean1.getObject();
		busiHallLoadingListVO = new BusiHallLoadingListVO();
		
		busiHallLoadingListVO.setDestination(busiHallLoadingListPO.getDestination());
		busiHallLoadingListVO.setEscortMan(busiHallLoadingListPO.getEscortMan());
		busiHallLoadingListVO.setSupervisionMan(busiHallLoadingListPO.getSupervisionMan());
		busiHallLoadingListVO.setOrderIDs(busiHallLoadingListPO.getOrderIDs());
		busiHallLoadingListVO.setTruckNum(busiHallLoadingListPO.getTruckNum());
		busiHallLoadingListVO.setBusiHallID(busiHallLoadingListPO.getBusiHallID());
		busiHallLoadingListVO.setLoadingDate(busiHallLoadingListPO.getLoadingDate());
		busiHallLoadingListVO.setVehiclesID(busiHallLoadingListPO.getVehiclesID());
		busiHallLoadingListVO.setCarriage(busiHallLoadingListPO.getCarriage());
		busiHallLoadingListVO.setID(busiHallLoadingListPO.getID());
		busiHallLoadingListVO.setApproState(busiHallLoadingListPO.getApproState());
		
		javaBean1.setObject(busiHallLoadingListVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = busiHallLoadingListdtaservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<BusiHallLoadingListlineitemPO>)javaBean1.getObject();
		arrayList2 = new ArrayList<BusiHallLoadingListlineitemVO>();
		int k = arrayList.size();
		
		for (int i = 0; i < k; i++) {
			busiHallLoadingListlineitemPO = arrayList.get(i);
			
			busiHallLoadingListlineitemVO = new BusiHallLoadingListlineitemVO();
			busiHallLoadingListlineitemVO.setID(busiHallLoadingListlineitemPO.getID());
			busiHallLoadingListlineitemVO.setLoadingDate(busiHallLoadingListlineitemPO.
					getLoadingDate());
			busiHallLoadingListlineitemVO.setDestination(busiHallLoadingListlineitemPO.
					getDestination());
			busiHallLoadingListlineitemVO.setCarriage(busiHallLoadingListlineitemPO.
					getCarriage());
			busiHallLoadingListlineitemVO.setTruckNum(busiHallLoadingListlineitemPO.
					getTruckNum());
			
			arrayList2.add(busiHallLoadingListlineitemVO);
		}
		
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public void VOtoPO() {
		busiHallLoadingListPO.setDestination(busiHallLoadingListVO.getDestination());
		busiHallLoadingListPO.setEscortMan(busiHallLoadingListVO.getEscortMan());
		busiHallLoadingListPO.setSupervisionMan(busiHallLoadingListVO.getSupervisionMan());
		busiHallLoadingListPO.setOrderIDs(busiHallLoadingListVO.getOrderIDs());
		busiHallLoadingListPO.setTruckNum(busiHallLoadingListVO.getTruckNum());
		busiHallLoadingListPO.setBusiHallID(busiHallLoadingListVO.getBusiHallID());
		busiHallLoadingListPO.setLoadingDate(busiHallLoadingListVO.getLoadingDate());
		busiHallLoadingListPO.setGenerateTime(busiHallLoadingListVO.getGenerateTime());
		busiHallLoadingListPO.setVehiclesID(busiHallLoadingListVO.getVehiclesID());
		busiHallLoadingListPO.setCarriage(busiHallLoadingListVO.getCarriage());
		busiHallLoadingListPO.setID(busiHallLoadingListVO.getID());
		busiHallLoadingListPO.setApproState(busiHallLoadingListVO.getApproState());
	}

	

}
