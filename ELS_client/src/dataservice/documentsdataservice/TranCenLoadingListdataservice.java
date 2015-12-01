package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import bean.JavaBean1;
import po.documentsPO.TranCenLoadingListPO;
import state.ResultMessage;

public interface TranCenLoadingListdataservice extends Remote{

	public ResultMessage addLoadingList(TranCenLoadingListPO po);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage update(TranCenLoadingListPO po);
	
	public JavaBean1 findA(String Id);
	
	public JavaBean1 findB(String date);
	
	public String generateId(String date);
}