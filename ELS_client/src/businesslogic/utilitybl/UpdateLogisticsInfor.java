package businesslogic.utilitybl;

import java.rmi.RemoteException;

import RMI.RMIHelper;
import po.utilityPO.LogisticsInforPO;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;
import state.ResultMessage;

public class UpdateLogisticsInfor {
	private UpdateLogisticsInfordataservice updateLogisticsInfordataservice;
	private LogisticsInforPO logisticsInforPO;
	private ResultMessage resultMessage;
	
	public UpdateLogisticsInfor(){
		try {
			updateLogisticsInfordataservice = RMIHelper.getUpdateLogisticsInfordataservice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage update(String date, String id, String description) {
		logisticsInforPO = new LogisticsInforPO();
		logisticsInforPO.setId(id);
		logisticsInforPO.setGenerateDate(date);
		logisticsInforPO.setDescription(description);
		
		try {
			resultMessage = updateLogisticsInfordataservice.update(logisticsInforPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
