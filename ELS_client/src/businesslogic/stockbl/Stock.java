package businesslogic.stockbl;

import po.stockPO.StorageListPO;
import state.ResultMessage;
import bean.JavaBean3;
import bean.JavaBean5;
import businesslogicservice.stockblservice.Stockblservice;

public class Stock implements Stockblservice{

	@Override
	public JavaBean5 stockCheck(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean3 stockCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage adjustPartition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stockAlarm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage storage(StorageListPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage outBound(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
