package businesslogic.utilitybl;

import java.rmi.RemoteException;

import RMI.RMIHelper;
import dataservice.utilitydataservice.RecordOperaLogdataservice;
import state.OperaType;
import state.ResultMessage;

public class RecordOperaLog {
	RecordOperaLogdataservice recordOperaLogdataservice;
	ResultMessage resultMessage;
	
	public RecordOperaLog(){
		try {
			recordOperaLogdataservice = RMIHelper.getRecordOperaLogdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage recordOperaLog (OperaType type, String objectType, String id, String operatorId) {
		String date = Time.generateDate();
		try {
			resultMessage = recordOperaLogdataservice.recordOperaLog(type, date, objectType,
					id, operatorId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
