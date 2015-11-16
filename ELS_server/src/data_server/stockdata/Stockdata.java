package data_server.stockdata;

import po_server.stockPO.StockPO;
import dataservice_server.stockdataservice.Stockdataservice;

public class Stockdata implements Stockdataservice{

	@Override
	public StockPO stockCheck(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockPO stockCount() {
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
	public void outBound() {
		// TODO Auto-generated method stub
		
	}

}
