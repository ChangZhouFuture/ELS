package businesslogic_client.stockbl;

import state.ResultMessage;
import vo_client.stockVO.StockVO;
import businesslogicservice_client.stockblservice.Stockblservice;

public class Stock implements Stockblservice{

	@Override
	public StockVO stockCheck(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockVO stockCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adjustPartition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stockAlarm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage outBound(String id) {
		return null;
		// TODO Auto-generated method stub
		//id是指出库的快递的订单的id
	}

}
