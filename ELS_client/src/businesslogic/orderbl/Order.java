package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import dataservice.orderdataservice.Orderdataservice;
import state.ApproState;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.CalculateFreight;
import businesslogic.utilitybl.Time;
import businesslogicservice.orderblservice.Orderblservice;
/**
 * 
 * @author 周畅
 *
 */
public class Order implements Orderblservice {
	private Orderdataservice orderdataservice;
	private OrderVO orderVO;
	private OrderPO orderPO;
	private OrderlineitemVO orderlineitemVO;
	private OrderlineitemPO orderlineitemPO;
	private ArrayList<OrderlineitemPO> arrayList;
	private ArrayList<OrderlineitemVO> arrayList2;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	private String date;
	private double totalCost;
	private double freight;
	
	public Order() {
		try {
			orderdataservice = RMIHelper.getOrderDataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public  JavaBean1 add(OrderVO orderVO) {
		orderPO = new OrderPO();
		this.orderVO = orderVO;
		
		this.orderVO.setFreight(calculateFreight(orderVO.getAddresseeAdd()));
		this.orderVO.setPackingCharge(calculatePackingCharge());
		this.orderVO.setTotalCost(totalCost);
		this.orderVO.setGenerateDate(generateDate());
		this.orderVO.setGenerateTime(Time.generateTime());
		this.orderVO.setId(generateId());
		this.orderVO.setExpectedArrivalDate(generateExpectedArrivalDate());
		this.orderVO.setApproState(ApproState.NotApprove);
		VOtoPO();
		
		try {
			resultMessage = orderdataservice.add(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		javaBean1.setObject(this.orderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}

	@Override
	public ResultMessage deleteOne(String id) {
		return null;
		
	}

	@Override
	public JavaBean1 inquireA(String id) {
		try {
			javaBean1 = orderdataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		orderPO = (OrderPO)javaBean1.getObject();
		orderVO = new OrderVO();
		
		this.orderVO.setAddresseeAdd(orderPO.getAddresseeAdd());
		this.orderVO.setAddresseeCompany(orderPO.getAddresseeCompany());
		this.orderVO.setAddresseeName(orderPO.getAddresseeName());
		this.orderVO.setAddresseePhoneNumber(orderPO.getAddresseePhoneNumber());
		this.orderVO.setApproState(orderPO.getApproState());
		this.orderVO.setExpectedArrivalDate(orderPO.getExpectedArrivalDate());
		this.orderVO.setExpressType(orderPO.getExpressType());
		this.orderVO.setFreight(orderPO.getFreight());
		this.orderVO.setGenerateDate(orderPO.getGenerateTime());
		this.orderVO.setGoodsName(orderPO.getGoodsName());
		this.orderVO.setId(orderPO.getId());
		this.orderVO.setNumOfBags(orderPO.getNumOfBags());
		this.orderVO.setNumOfCartons(orderPO.getNumOfCartons());
		this.orderVO.setNumOfGoods(orderPO.getNumOfGoods());
		this.orderVO.setNumOfWoodenBox(orderPO.getNumOfWoodenBox());
		this.orderVO.setPackingCharge(orderPO.getPackingCharge());
		this.orderVO.setSenderAdd(orderPO.getSenderAdd());
		this.orderVO.setSenderCompany(orderPO.getSenderCompany());
		this.orderVO.setSenderName(orderPO.getSenderName());
		this.orderVO.setSenderPhoneNumber(orderPO.getSenderPhoneNumber());
		this.orderVO.setSize(orderPO.getSize());
		this.orderVO.setTotalCost(orderPO.getTotalCost());
		this.orderVO.setTrueAddressee(orderPO.getTrueAddressee());
		this.orderVO.setWeight(orderPO.getWeight());
		
		javaBean1.setObject(orderVO);
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(String date) {
		try {
			javaBean1 = orderdataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<OrderlineitemPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		lineitemPOtolineitemVO(k);
		
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	@Override
	public String generateId() {
		
		return date;
	}

	@Override
	public void endOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		try {
			orderlineitemPO = orderdataservice.getOrderlineitemPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		lineitemPOtolineitemVO(1);
		
		return orderlineitemVO;
	}

	@Override
	public ResultMessage modify(OrderVO orderVO) {
		orderPO = new OrderPO();
		this.orderVO = orderVO;
		
		VOtoPO();
		try {
			resultMessage = orderdataservice.update(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return resultMessage;
	}
	
	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		try {
			resultMessage = orderdataservice.deleteMany(idList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	@Override
	public double calculateFreight(String destination) {
		
		//截取字符串的一段
		freight = CalculateFreight.calculateFreight(destination);
		return freight;
	}

	@Override
	public String generateExpectedArrivalDate() {
		//仅仅是测试用
//		String expectedArrivalDate = date.substring(date.length()-2, date.length()-1);
		return date;
	}

	@Override
	public double calculatePackingCharge() {
		double packingCharge = 0;
		
		totalCost = packingCharge+freight;
		return packingCharge;
	}

	@Override
	public void VOtoPO() {
		this.orderPO.setAddresseeAdd(orderVO.getAddresseeAdd());
		this.orderPO.setAddresseeCompany(orderVO.getAddresseeCompany());
		this.orderPO.setAddresseeName(orderVO.getAddresseeName());
		this.orderPO.setAddresseePhoneNumber(orderVO.getAddresseePhoneNumber());
		this.orderPO.setApproState(orderVO.getApproState());
		this.orderPO.setExpectedArrivalDate(orderVO.getExpectedArrivalDate());
		this.orderPO.setExpressType(orderVO.getExpressType());
		this.orderPO.setFreight(orderVO.getFreight());
		this.orderPO.setGenerateDate(orderVO.getGenerateDate());
		this.orderPO.setGenerateTime(orderVO.getGenerateTime());
		this.orderPO.setGoodsName(orderVO.getGoodsName());
		this.orderPO.setId(orderVO.getId());
		this.orderPO.setNumOfBags(orderVO.getNumOfBags());
		this.orderPO.setNumOfCartons(orderVO.getNumOfCartons());
		this.orderPO.setNumOfGoods(orderVO.getNumOfGoods());
		this.orderPO.setNumOfWoodenBox(orderVO.getNumOfWoodenBox());
		this.orderPO.setPackingCharge(orderVO.getPackingCharge());
		this.orderPO.setSenderAdd(orderVO.getSenderAdd());
		this.orderPO.setSenderCompany(orderVO.getSenderCompany());
		this.orderPO.setSenderName(orderVO.getSenderName());
		this.orderPO.setSenderPhoneNumber(orderVO.getSenderPhoneNumber());
		this.orderPO.setSize(orderVO.getSize());
		this.orderPO.setTotalCost(orderVO.getTotalCost());
		this.orderPO.setTrueAddressee(orderVO.getTrueAddressee());
		this.orderPO.setWeight(orderVO.getWeight());
	}

	@Override
	public void lineitemPOtolineitemVO(int k) {
		arrayList2 = new ArrayList<OrderlineitemVO>();
		
		for (int i = 0; i < k; i++) {
			orderlineitemPO = arrayList.get(i);
			
			orderlineitemVO = new OrderlineitemVO();
			orderlineitemVO.setId(orderlineitemPO.getId());
			orderlineitemVO.setGenerateDate(orderlineitemPO.getGenerateDate());
			orderlineitemVO.setSenderAdd(orderlineitemPO.getSenderAdd());
			orderlineitemVO.setAddresseeAdd(orderlineitemPO.getAddresseeAdd());
			orderlineitemVO.setTotalCost(orderlineitemPO.getTotalCost());
			orderlineitemVO.setExpressType(orderlineitemPO.getExpressType());
			orderlineitemVO.setApproState(orderlineitemPO.getApproState());
		
			arrayList2.add(orderlineitemVO);
		}
	}

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}
	
}
