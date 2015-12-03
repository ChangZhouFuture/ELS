package businesslogic.documentsbl;

import java.util.ArrayList;
import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;
import state.ResultMessage;
import vo.documentsVO.BusiHallLoadingListVO;
import vo.lineitemVO.documentslineitemVO.BusiHallLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
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
	public String getBusiHallId() {
		
		return null;
	}
	
	@Override
	public OrderlineitemVO addOrder(String orderId) {
		order = new Order();
		orderlineitemVO = order.getOrderlineitemVO(orderId);
		return orderlineitemVO;
	}

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public String generatevehiclesID() {
		//调用数据层方法,自动生成 营业厅编号+20150921日期+00000编码 、五位数字
		String vehiclesID = getBusiHallId()+date+busiHallLoadingListdtaservice.
				generateId(date);
		return vehiclesID;
	}

	@Override
	public double generateFreight(String destination) {
		
		
		return 0;
	}

	@Override
	public JavaBean1 addBusinessHallLoadingList(BusiHallLoadingListVO businessHallLoadingListVO) {
		busiHallLoadingListPO = new BusiHallLoadingListPO();
		this.busiHallLoadingListVO = busiHallLoadingListVO;
		
		this.busiHallLoadingListVO.setBusiHallID(getBusiHallId());
		this.busiHallLoadingListVO.setLoadingDate(generateDate());
		this.busiHallLoadingListVO.setVehiclesID(generatevehiclesID());
		this.busiHallLoadingListVO.setCarriage(generateFreight(
				businessHallLoadingListVO.getDestination()));
		this.busiHallLoadingListVO.setID(generateId());
		VOtoPO();
		
		resultMessage = busiHallLoadingListdtaservice.addLoadingList(busiHallLoadingListPO);
		javaBean1.setObject(this.busiHallLoadingListVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public String generateId() {
		//调用数据层方法
		String id = date+busiHallLoadingListdtaservice.generateId(date);
		return id;
	}

	@Override
	public ResultMessage modify(BusiHallLoadingListVO businessHallLoadingListVO) {
		busiHallLoadingListPO = new BusiHallLoadingListPO();
		this.busiHallLoadingListVO = businessHallLoadingListVO;
		
		VOtoPO();
		resultMessage = busiHallLoadingListdtaservice.update(busiHallLoadingListPO);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteone(String id) {
		resultMessage = busiHallLoadingListdtaservice.deleteone(id);
		
		return resultMessage;
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		resultMessage = busiHallLoadingListdtaservice.deleteMany(idList);
		
		return resultMessage;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		javaBean1 = busiHallLoadingListdtaservice.findA(id);
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
		
		javaBean1.setObject(busiHallLoadingListVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		javaBean1 = busiHallLoadingListdtaservice.findB(date);
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

	@Override
	public void end() {
		
	}

	@Override
	public void VOtoPO() {
		busiHallLoadingListPO.setDestination(busiHallLoadingListVO.getDestination());
		busiHallLoadingListPO.setEscortMan(busiHallLoadingListVO.getEscortMan());
		busiHallLoadingListPO.setSupervisionMan(busiHallLoadingListVO.getSupervisionMan());
		busiHallLoadingListPO.setOrderIDs(busiHallLoadingListVO.getOrderIDs());
		busiHallLoadingListPO.setTruckNum(busiHallLoadingListVO.getTruckNum());
		busiHallLoadingListPO.setBusiHallID(busiHallLoadingListVO.getBusiHallID());
		busiHallLoadingListPO.setLoadingDate(busiHallLoadingListVO.getLoadingDate());
		busiHallLoadingListPO.setVehiclesID(busiHallLoadingListVO.getVehiclesID());
		busiHallLoadingListPO.setCarriage(busiHallLoadingListVO.getCarriage());
		busiHallLoadingListPO.setID(busiHallLoadingListVO.getID());
	}

	

}
