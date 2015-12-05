package dataservice.utilitydataservice;

import java.rmi.Remote;
import state.ResultMessage;

public interface UpdateLogisticsInfordataservice extends Remote{
	public ResultMessage update(String id, String description);
}
