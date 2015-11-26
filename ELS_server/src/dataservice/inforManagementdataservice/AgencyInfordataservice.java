package dataservice.inforManagementdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.inforManagementPO.AgencyPO;
import state.ResultMessage;

public interface AgencyInfordataservice extends Remote{
public ResultMessage add(AgencyPO po);
	
	public ResultMessage deleteOne(String Id);
	
	public ResultMessage deleteMany(ArrayList<String> Ids);
	
	public ResultMessage update(AgencyPO po);
	
	public AgencyPO find(String Id);
}
