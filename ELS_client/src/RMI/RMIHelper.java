package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import dataservice.datafactoryservice.DataFactoryservice;
import dataservice.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;
import dataservice.documentsdataservice.BuinessHallLoadingListdataservice;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import dataservice.documentsdataservice.PaymentOrderdataservice;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;
import dataservice.documentsdataservice.TransferCenterLoadingListdataservice;
import dataservice.documentsdataservice.TransferOrderdataservice;
import dataservice.inforManagementdataservice.AgencyInfordataservice;
import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import dataservice.inforManagementdataservice.DriversInfordataservice;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import dataservice.inforManagementdataservice.VehiclesInfordataservice;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;
import dataservice.managerAndAccountantdataservice.InquireOperaLogdataservice;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;
import dataservice.orderdataservice.Orderdataservice;
import dataservice.stockdataservice.OutBoundOrderdataservice;
import dataservice.stockdataservice.Stockdataservice;
import dataservice.stockdataservice.StorageListdataservice;
import dataservice.userManagementdataservice.UserManagementdataservice;
import dataservice.userdataservice.Logindataservice;
import dataservice.utilitydataservice.RecordOperaLogdataservice;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;

public class RMIHelper {
	public static DataFactoryservice dataFactoryservice;
	
	public static void init() {
		try {
			dataFactoryservice = (DataFactoryservice)Naming.lookup
					("rmi://127.0.0.1:6600/dataFactoryservice");
			System.out.println("客户端已连接至服务器端");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Orderdataservice getOrderDataservice() throws RemoteException {
		return dataFactoryservice.getOrderdataservice();
	}
	
	public static ArrivalOrder4BusiHalldataservice getArrivalOrder4BusiHalldataservice()
			throws RemoteException{
				return null;
	}
			
	public static ArrivalOrder4TranCendataservice getArrivalOrder4TranCendataservice()
		throws RemoteException{
						
		return null;
	}
			
	public static DeliveryOrderdataservice getDeliveryOrderdataservice() 
		throws RemoteException{
				
		return null;
	}
	
	public static BuinessHallLoadingListdataservice getBuinessHallLoadingListdataservice()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public static TransferCenterLoadingListdataservice getTransferCenterLoadingListdataservice()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static PaymentOrderdataservice getPaymentOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public static ReceivablesOrderdataservice getReceivablesOrderdataservice() 
	throws RemoteException{
		return null;
				
	}
			
	public static TransferOrderdataservice getTransferOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public static AgencyInfordataservice getAgencyInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public static BankAccountInfordataservice getBankAccountInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public static DriversInfordataservice getDriversInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public static StaffInfordataservice getStaffInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public static VehiclesInfordataservice getVehiclesInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public static Approdocmdataservice getApprodocmdataservice() throws RemoteException{
		return null;
				
	}
			
	public static StatisAnalydataservice getStatisAnalydataservice() throws RemoteException{
		return null;
				
	}
			
	public static InquireOperaLogdataservice getInquireOperaLogdataservice() throws 
	RemoteException{
		return null;
				
	}
			
	public static OutBoundOrderdataservice getOutBoundOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public static Stockdataservice getStockdataservice() throws RemoteException{
		return null;
				
	}
			
	public static StorageListdataservice getStorageListdataservice() throws RemoteException{
		return null;
				
	}
			
	public static Logindataservice getLogindataservice() throws RemoteException{
		return dataFactoryservice.getLogindataservice();	
	}
			
	public static UserManagementdataservice getUserManagementdataservice() throws RemoteException{
		return null;
				
	}
			
	public static RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
	RemoteException{
		return null;
				
	}
			
	public static UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
	throws RemoteException{
		return null;
				
	}
}
