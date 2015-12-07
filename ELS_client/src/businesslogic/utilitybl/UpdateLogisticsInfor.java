package businesslogic.utilitybl;

import java.rmi.RemoteException;
import RMI.RMIHelper;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;
import state.ResultMessage;

public class UpdateLogisticsInfor {
	UpdateLogisticsInfordataservice updateLogisticsInfordataservice;
	ResultMessage resultMessage;
	
	public UpdateLogisticsInfor(){
		try {
			updateLogisticsInfordataservice = RMIHelper.getUpdateLogisticsInfordataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage update(String time, String id, String description) {
//		try {
//			resultMessage = updateLogisticsInfordataservice.update(time, id, description);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		return resultMessage;
	}
}
