package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import dataservice.datafactoryservice.DataFactoryservice;
import dataservice.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import dataservice.documentsdataservice.LoadingListdataservice;
import dataservice.documentsdataservice.PaymentOrderdataservice;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;
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
import dataservice.utilitydataservice.AutoGenerateTimedataservice;
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
	
	public ArrivalOrder4BusiHalldataservice getArrivalOrder4BusiHalldataservice()
			throws RemoteException{
				return null;
	}
			
	public ArrivalOrder4TranCendataservice getArrivalOrder4TranCendataservice()
		throws RemoteException{
						
		return null;
	}
			
	public DeliveryOrderdataservice getDeliveryOrderdataservice() 
		throws RemoteException{
				
		return null;
	}
			
	public LoadingListdataservice getLoadingListdataservice() throws RemoteException{
		return null;
				
	}
			
	public PaymentOrderdataservice getPaymentOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public ReceivablesOrderdataservice getReceivablesOrderdataservice() 
	throws RemoteException{
		return null;
				
	}
			
	public TransferOrderdataservice getTransferOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public AgencyInfordataservice getAgencyInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public BankAccountInfordataservice getBankAccountInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public DriversInfordataservice getDriversInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public StaffInfordataservice getStaffInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public VehiclesInfordataservice getVehiclesInfordataservice() throws RemoteException{
		return null;
				
	}
			
	public Approdocmdataservice getApprodocmdataservice() throws RemoteException{
		return null;
				
	}
			
	public StatisAnalydataservice getStatisAnalydataservice() throws RemoteException{
		return null;
				
	}
			
	public  InquireOperaLogdataservice getInquireOperaLogdataservice() throws 
	RemoteException{
		return null;
				
	}
			
	public OutBoundOrderdataservice getOutBoundOrderdataservice() throws RemoteException{
		return null;
				
	}
			
	public Stockdataservice getStockdataservice() throws RemoteException{
		return null;
				
	}
			
	public StorageListdataservice getStorageListdataservice() throws RemoteException{
		return null;
				
	}
			
	public Logindataservice getLogindataservice() throws RemoteException{
		return null;
				
	}
			
	public UserManagementdataservice getUserManagementdataservice() throws RemoteException{
		return null;
				
	}
			
	public AutoGenerateTimedataservice getautAutoGenerateTimedataservice() throws 
	RemoteException{
		return null;
				
	}
			
	public RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
	RemoteException{
		return null;
				
	}
			
	public UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
	throws RemoteException{
		return null;
				
	}
}
