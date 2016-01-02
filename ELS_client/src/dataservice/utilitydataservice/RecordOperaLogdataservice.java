package dataservice.utilitydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import state.OperaType;
import state.Position;
import state.ResultMessage;

public interface RecordOperaLogdataservice extends Remote{
	public ResultMessage recordOperaLog (OperaType type, String date, String objectType,
			String id, Position position, String operatorId) throws RemoteException;
}
