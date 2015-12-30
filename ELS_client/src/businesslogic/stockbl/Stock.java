package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import dataservice.stockdataservice.Stockdataservice;
import po.lineitemPO.stocklineitemPO.StocklineitemPO;
import po.stockPO.OutBoundOrderPO;
import po.stockPO.StockPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;
import vo.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo.lineitemVO.stocklineitemVO.StocklineitemVO;
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
	private Order order;
	private OrderlineitemVO orderlineitemVO;
	private StorageList storageList;
	private OutBoundOrder outBoundOrder;
	private StorageListPO storageListPO;
	private OutBoundOrderPO outBoundOrderPO;
	private ArrayList<StocklineitemPO> arrayList;
	private ArrayList<StocklineitemVO> arrayList2;
	private ArrayList<OrderlineitemVO> arrayList3;
	private ArrayList<StorageListPO> arrayList4;
	private ArrayList<OutBoundOrderPO> arrayList5;
	private JavaBean1 javaBean1;
	private JavaBean3 javaBean3;
	private JavaBean4 javaBean4;
	private JavaBean5 javaBean5;
	private ResultMessage resultMessage;
	private int[] inNum = new int[4];  //�ֱ����ĸ������������������,��ʼ����0
	private int[] outNum = new int[4];
	private double[] inAmount = new double[4];  //�ֱ����ĸ����������,��ʼ����0
	private double[] outAmount = new double[4];
	
	public Stock() {
		try {
			stockdataservice = RMIHelper.getStockdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean5 stockCheck(String startDate, String endDate) {
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
			//ʱ���ѭ��
			String date = arrayList.get(i);
				
			javaBean1 = storageList.inquireB(date);
			//Ҫ�ģ���Ҫ���ò�B������һ���·���������ֵ��areaList + orderIDs
			
			String area = "";
			//forѭ������Ҫ��,��ȡ����area
			for (int j = 0; j < arrayList4.size(); j++) {
				//����һ��������ⵥ��������
//				area = storageListPO.getAreaNum();
				increaseNumAndAmount(true, area);
				
			}//������������������ļ���
			
			javaBean1 = outBoundOrder.inquireB(date);
			//Ҫ�ģ���Ҫ���ò�B������һ���·���������ֵ��areaList + orderIDs
			//��������һ�����ڲ�forѭ��
			
			
		}
		//���forѭ������
			
		
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
		//ָ���Ƕ�Ӧ��ݵ�id
		
		try {
			resultMessage = stockdataservice.outBound(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	public double getOrderAmount(String orderID) {
		
		//���ö�����ķ���
		return 0;
	}
	
	public void increaseNumAndAmount(boolean flag, String area) {
		if (flag) {
			//�����������صı���
			switch (area) {
			case "������":
//				inAmount[0] += getOrderAmount();
				//���û�ȡ���ݽ��ķ�����
				inNum[0]++;
				break;
			case "������":
//				inAmount[1] += getOrderAmount();
				inNum[1]++;
				break;
			case "������":
//				inAmount[2] += getOrderAmount();
				inNum[2]++;
				break;
			case "������":
//				inAmount[3] += getOrderAmount();
				inNum[3]++;
				break;
			default:
				break;
			}
		} else {
			//�����������صı���
		}
	}
}
