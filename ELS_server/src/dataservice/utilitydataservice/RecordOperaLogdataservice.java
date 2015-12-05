package dataservice.utilitydataservice;

import java.rmi.Remote;
import state.OperaType;
import state.ResultMessage;

public interface RecordOperaLogdataservice extends Remote{
	public ResultMessage recordOperaLog (OperaType type, String date, String objectType,
			String id, String operatorId);
}
