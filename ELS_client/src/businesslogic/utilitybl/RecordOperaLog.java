package businesslogic.utilitybl;

import java.rmi.RemoteException;

import RMI.RMIHelper;
import dataservice.utilitydataservice.RecordOperaLogdataservice;
import state.OperaType;
import state.Position;
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
	
	public ResultMessage recordOperaLog (OperaType type, String objectType, String id,
			Position position, String operatorId) {
		String date = Time.generateDate();
		try {
			resultMessage = recordOperaLogdataservice.recordOperaLog(type, date, 
					objectType,	id, position, operatorId);
			//这里没有写成把VO转换成PO，算了
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
