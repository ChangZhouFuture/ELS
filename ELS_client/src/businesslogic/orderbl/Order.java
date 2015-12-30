package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import dataservice.orderdataservice.Orderdataservice;
import state.ApproState;
import state.ExpressArrivalStatus;
import state.ExpressType;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.orderVO.OrderVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.utilitybl.CalculateFreight;
import businesslogic.utilitybl.Time;
import businesslogic.utilitybl.UpdateLogisticsInfor;
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
	private UpdateLogisticsInfor updateLogisticsInfor;
	private ResultMessage resultMessage;
	private String date;
	private double totalCost;
	private double freight;
	private JavaBean1 javaBean1 = new JavaBean1();
	
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
		
		this.orderVO.setFreight(calculateFreight(orderVO.getAddresseeAdd(), orderVO.
				getWeight(), orderVO.getExpressType()));
		this.orderVO.setTotalCost(totalCost);
		this.orderVO.setGenerateDate(generateDate());
		this.orderVO.setGenerateTime(Time.generateTime());
		this.orderVO.setId(generateId());
		this.orderVO.setExpectedArrivalDate(generateExpectedArrivalDate());
		this.orderVO.setApproState(ApproState.NotApprove);
		this.orderVO.setExpressArrivalStatus(ExpressArrivalStatus.NotArrival);
		VOtoPO();
		
		try {
			resultMessage = orderdataservice.add(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (resultMessage == ResultMessage.Success) {
			updateLogisticsInfor = new UpdateLogisticsInfor();
			updateLogisticsInfor.update(date, this.orderVO.getId(), "订单已生成");
		}
		javaBean1.setObject(this.orderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
	}
	
	@Override
	public JavaBean1 receive(String id, String trueAddresseeName) {
		//直接调用数据层方法，由数据层来设置trueAddresseeName
		//数据层接口增加一个参数，接收日期
		generateDate();
		
		try {
			resultMessage = orderdataservice.receive(id, date, trueAddresseeName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		updateLogisticsInfor.update(date, id, date + " 订单已被接收");
		javaBean1.setObject(date);//只返回确认收货日期
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
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
		this.orderVO.setGoodsName(orderPO.getGoodsName());
		this.orderVO.setId(orderPO.getId());
		this.orderVO.setGenerateDate(orderPO.getGenerateDate());
		this.orderVO.setExpressArrivalStatus(orderPO.getExpressArrivalStatus());
		this.orderVO.setNumOfGoods(orderPO.getNumOfGoods());
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

	public String generateId() {
		String id = null;
		
		try {
			id = orderdataservice.generateId(date);
			//需要一个可以复用的方法，把日期字符串中的减号去掉，剩下的加上数据层几位数字
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	public OrderlineitemVO getOrderlineitemVO(String id) {
		try {
			orderlineitemPO = orderdataservice.getOrderlineitemPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		arrayList = new ArrayList<OrderlineitemPO>();
		arrayList.add(orderlineitemPO);
		lineitemPOtolineitemVO(1);
		
		return orderlineitemVO;
	}

	@Override
	public JavaBean1 modify(OrderVO orderVO) {
		orderPO = new OrderPO();
		this.orderVO = orderVO;
		
		this.orderVO.setFreight(calculateFreight(orderVO.getAddresseeAdd(), orderVO.
				getWeight(), orderVO.getExpressType()));
		this.orderVO.setTotalCost(totalCost);
		VOtoPO();
		try {
			resultMessage = orderdataservice.update(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		javaBean1.setObject(this.orderVO);
		javaBean1.setResultMessage(resultMessage);
		
		return javaBean1;
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

	public double calculateFreight(String destination, double weight, ExpressType eType)
	{
		//截取字符串的一段
		//先计算运费再计算包装费
		freight = CalculateFreight.expressFreight(destination, weight, eType);
		totalCost = freight + this.orderVO.getPackingCharge();
		return freight;
	}

	public String generateExpectedArrivalDate() {
		//仅仅是测试用
//		String expectedArrivalDate = date.substring(date.length()-2, date.length()-1);
		return date;
	}

	public void VOtoPO() {
		this.orderPO.setAddresseeAdd(orderVO.getAddresseeAdd());
		this.orderPO.setAddresseeCompany(orderVO.getAddresseeCompany());
		this.orderPO.setAddresseeName(orderVO.getAddresseeName());
		this.orderPO.setAddresseePhoneNumber(orderVO.getAddresseePhoneNumber());
		this.orderPO.setApproState(orderVO.getApproState());
		this.orderPO.setExpectedArrivalDate(orderVO.getExpectedArrivalDate());
		this.orderPO.setExpressArrivalStatus(ExpressArrivalStatus.NotArrival);
		this.orderPO.setExpressType(orderVO.getExpressType());
		this.orderPO.setFreight(orderVO.getFreight());
		this.orderPO.setGenerateDate(orderVO.getGenerateDate());
		this.orderPO.setGoodsName(orderVO.getGoodsName());
		this.orderPO.setId(orderVO.getId());
		this.orderPO.setNumOfGoods(orderVO.getNumOfGoods());
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

	public String generateDate() {
		date = Time.generateDate();
		return date;
	}
	
}
