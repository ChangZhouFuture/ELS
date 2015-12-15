package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.stockdataservice.Stockdataservice;
import po.lineitemPO.stocklineitemPO.StocklineitemPO;
import po.stockPO.StockPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.lineitemVO.stocklineitemVO.StocklineitemVO;
import RMI.RMIHelper;
import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import businesslogic.orderbl.Order;
import businesslogic.utilitybl.Time;
import businesslogicservice.stockblservice.Stockblservice;

public class Stock implements Stockblservice{
	private Stockdataservice stockdataservice;
	private StockPO stockPO;
	private StocklineitemPO stocklineitemPO;
	private StocklineitemVO stocklineitemVO;
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private ArrayList<StocklineitemPO> arrayList;
	private ArrayList<StocklineitemVO> arrayList2;
	private ArrayList<OrderlineitemVO> arrayList3;
	private ResultMessage resultMessage;
	private JavaBean3 javaBean3;
	private JavaBean4 javaBean4;
	private JavaBean5 javaBean5;
	
	public Stock() {
		try {
			stockdataservice = RMIHelper.getStockdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean5 stockCheck(String inOrOut, String startDate, String endDate) {
		if (inOrOut == "入库") {
			//用time类里面的方法，查看时间段内每一天总共的入库单lineitem
		} else {

		}
		//要设置现有的库存数量，可能是调用库存盘点方法
		//要设置总金额，需要根据每个单上的订单id查订单价格，累加。多次调用订单的差多个方法
		
		return null;
	}

	@Override
	public JavaBean3 stockCount() {
		try {
			javaBean3 = stockdataservice.stockCount(Time.generateDate());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<StocklineitemPO>)javaBean3.getObject();
		arrayList2 = new ArrayList<StocklineitemVO>();
		int k = arrayList.size();
		
		for (int i = 0; i < k; i++) {
			stocklineitemPO = arrayList.get(i);
			
			stocklineitemVO = new StocklineitemVO();
			stocklineitemVO.setId(stocklineitemPO.getId());
			stocklineitemVO.setInDate(stocklineitemPO.getInDate());
			stocklineitemVO.setAreaNum(stocklineitemPO.getAreaNum());
			stocklineitemVO.setFrameNum(stocklineitemPO.getFrameNum());
			stocklineitemVO.setRowNum(stocklineitemPO.getRowNum());
			stocklineitemVO.setPositionNum(stocklineitemPO.getPositionNum());
			stocklineitemVO.setDestination(stocklineitemPO.getDestination());
			
			arrayList2.add(stocklineitemVO);
		}
		javaBean3.setObject(arrayList2);
		
		return javaBean3;
	}
	
	@Override
	public JavaBean4 adjustPartition(ArrayList<String> IDList, String area) {
		try {
			resultMessage = stockdataservice.adjustPartition(IDList, area);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		javaBean4 = stockAlarm();
		javaBean4.setResultMessage(resultMessage);
		return javaBean4;
	}
	
	@Override
	public JavaBean4 stockAlarm() {
		try {
			javaBean4 = stockdataservice.stockAlarm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return javaBean4;
	}


	@Override
	public JavaBean4 storage(StorageListPO storageListPO) {
		stockPO.setId(storageListPO.getOrderID());
		stockPO.setInDate(storageListPO.getInDate());
		stockPO.setAreaNum(storageListPO.getAreaNum());
		stockPO.setFrameNum(storageListPO.getFrameNum());
		stockPO.setRowNum(storageListPO.getRowNum());
		stockPO.setPositionNum(storageListPO.getPositionNum());
		stockPO.setDestination(storageListPO.getDestination());
		
		try {
			resultMessage = stockdataservice.storage(stockPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		javaBean4 = stockAlarm();
		javaBean4.setResultMessage(resultMessage);
		return javaBean4;
	}

	@Override
	public ResultMessage outBound(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
