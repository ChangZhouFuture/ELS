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
	
	public ResultMessage update(String id, String description) {
		resultMessage = updateLogisticsInfordataservice.update(id, description);
		return resultMessage;
	}
}
