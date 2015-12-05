package businesslogic.documentsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.documentsPO.TranCenLoadingListPO;
import po.lineitemPO.documentslineitemPO.TranCenLoadingListlineitemPO;
import dataservice.documentsdataservice.TranCenLoadingListdataservice;
import state.ResultMessage;
import vo.documentsVO.TranCenLoadingListVO;
import vo.lineitemVO.documentslineitemVO.TranCenLoadingListlineitemVO;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.documentsblservice.TranCenLoadingListblservice;

public class TranCenLoadingList implements TranCenLoadingListblservice{
	private TranCenLoadingListdataservice tranCenLoadingListdataservice;
	private TranCenLoadingListVO tranCenLoadingListVO;
	private TranCenLoadingListPO tranCenLoadingListPO;
	private TranCenLoadingListlineitemPO tranCenLoadingListlineitemPO;
	private TranCenLoadingListlineitemVO tranCenLoadingListlineitemVO;
	private ArrayList<TranCenLoadingListlineitemPO> arrayList;
	private ArrayList<TranCenLoadingListlineitemVO> arrayList2;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private JavaBean1 javaBean1;
	private ResultMessage resultMessage;
	String date;
	
	public TranCenLoadingList() {
		try {
			tranCenLoadingListdataservice = RMIHelper.getTransferCenterLoadingListdataservice();
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

	@Override
	public String generateId() {
		String id = null;
		try {
			id = date+tranCenLoadingListdataservice.generateId(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String generateDate() {
		date = Time.generateDate();
		return date;
	}

	@Override
	public String generateVehieclesId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double generateFeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JavaBean1 add(TranCenLoadingListVO tranCenLoadingListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(TranCenLoadingListVO tranCenLoadingListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireA(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void VOtoPO() {
		// TODO Auto-generated method stub
		
	}

}
