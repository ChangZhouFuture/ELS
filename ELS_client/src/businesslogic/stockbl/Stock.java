package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import dataservice.stockdataservice.Stockdataservice;
import po.lineitemPO.stocklineitemPO.StocklineitemPO;
import po.stockPO.StockPO;
import state.ResultMessage;
import vo.lineitemVO.stocklineitemVO.StocklineitemVO;
import vo.stockVO.StorageListVO;
import RMI.RMIHelper;
import bean.JavaBean1;
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
	private StorageList storageList;
	private OutBoundOrder outBoundOrder;
	private Order order;
	private JavaBean1 javaBean1;
	private JavaBean3 javaBean3;
	private JavaBean4 javaBean4;
	private JavaBean5 javaBean5;
	private ArrayList<StocklineitemPO> arrayList;
	private ArrayList<StocklineitemVO> arrayList2;
	private ArrayList<JavaBean5> arrayList3;
	private ResultMessage resultMessage;
	private int[] inNum = new int[4];  //分别是四个区的入库数量计数器,初始都是0
	private int[] outNum = new int[4];
	private double[] inAmount = new double[4];  //分别是四个区的入库金额,初始都是0
	private double[] outAmount = new double[4];
	
	public Stock() {
		try {
			stockdataservice = RMIHelper.getStockdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<JavaBean5> stockCheck(String startDate, String endDate) {
		ArrayList<String> arrayList = null;
		try {
			arrayList = Time.getEveryDay(startDate, endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		inNum = new int[4];
		inAmount = new double[4];
		outNum = new int[4];
		outAmount = new double[4];
		
		int k = arrayList.size();
		for (int i = 0; i < k; i++) {
			//时间段循环
			String date = arrayList.get(i);
				
			String area;
			String orderID;
			String[][] areaListAndOrderIDs;
			int m;
			
			javaBean1 = storageList.getOrderIDsAndAreaList(date);
			//要改，不要调用查B，调用一个新方法，返回值是areaList + orderIDs
			areaListAndOrderIDs = (String[][])javaBean1.getObject();
			m = areaListAndOrderIDs[0].length;
			
			//for循环条件,获取各个area
			for (int j = 0; j < m; j++) {
				area = areaListAndOrderIDs[0][j];
				orderID = areaListAndOrderIDs[1][j];
				increaseNumAndAmount(true, area, orderID);
			}
			//结束对入库数量、金额的计算
			
			javaBean1 = outBoundOrder.getOrderIDsAndAreaList(date);
			//要改，不要调用查B，调用一个新方法，返回值是areaList + orderIDs
			areaListAndOrderIDs = (String[][])javaBean1.getObject();
			m = areaListAndOrderIDs[0].length;
			
			for (int j = 0; j < m; j++) {
				area = areaListAndOrderIDs[0][j];
				orderID = areaListAndOrderIDs[1][j];
				increaseNumAndAmount(false, area, orderID);
			}
			
		}
		//外层for循环结束
		
		String[] areas = {"机动区", "汽运区", "铁运区", "航运区"};
		arrayList3 = new ArrayList<JavaBean5>();
		
		for (int i = 0; i < 4; i++) {
			javaBean5 = new JavaBean5();
			
			javaBean5.setArea(areas[i]);
			javaBean5.setInNum(inNum[i]);
			javaBean5.setInAmount(inNum[i]);
			javaBean5.setOutNum(outNum[i]);
			javaBean5.setOutAmount(outAmount[i]);
			javaBean5.setResultMessage(ResultMessage.Success);
			
			arrayList3.add(javaBean5);
		}
		
		return arrayList3;
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
	
	public JavaBean4 stockAlarm() {
		try {
			javaBean4 = stockdataservice.stockAlarm();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return javaBean4;
	}


	@Override
	public JavaBean4 storage(StorageListVO storageListVO) {
		stockPO = new StockPO();
		
		stockPO.setId(storageListVO.getOrderID());
		stockPO.setInDate(storageListVO.getInDate());
		stockPO.setAreaNum(storageListVO.getAreaNum());
		stockPO.setFrameNum(storageListVO.getFrameNum());
		stockPO.setRowNum(storageListVO.getRowNum());
		stockPO.setPositionNum(storageListVO.getPositionNum());
		stockPO.setDestination(storageListVO.getDestination());
		
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
		//指的是对应快递的id
		
		try {
			resultMessage = stockdataservice.outBound(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	public double getOrderAmount(String orderID) {
		double amount = order.getOrderAmount(orderID);
		//调用订单类的方法
		return amount;
	}
	
	public void increaseNumAndAmount(boolean flag, String area, String orderID) {
		if (flag) {
			//计算与入库相关的变量
			switch (area) {
			case "机动区":
				inAmount[0] += getOrderAmount(orderID);
				inNum[0]++;
				break;
			case "汽运区":
				inAmount[1] += getOrderAmount(orderID);
				inNum[1]++;
				break;
			case "铁运区":
				inAmount[2] += getOrderAmount(orderID);
				inNum[2]++;
				break;
			case "航运区":
				inAmount[3] += getOrderAmount(orderID);
				inNum[3]++;
				break;
			default:
				break;
			}
		} else {
			//计算与出库相关的变量
			switch (area) {
			case "机动区":
				outAmount[0] += getOrderAmount(orderID);
				outNum[0]++;
				break;
			case "汽运区":
				outAmount[1] += getOrderAmount(orderID);
				outNum[1]++;
				break;
			case "铁运区":
				outAmount[2] += getOrderAmount(orderID);
				outNum[2]++;
				break;
			case "航运区":
				outAmount[3] += getOrderAmount(orderID);
				outNum[3]++;
				break;
			default:
				break;
			}
			
		}
		
	}
	
	
}
