package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactoryservice;
import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;
import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import dataservice.documentsdataservice.PaymentOrderdataservice;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;
import dataservice.documentsdataservice.TranCenLoadingListdataservice;
import dataservice.documentsdataservice.TransferOrderdataservice;
import dataservice.inforManagementdataservice.AgencyInfordataservice;
import dataservice.inforManagementdataservice.BankAccountInfordataservice;
import dataservice.inforManagementdataservice.DriversInfordataservice;
import dataservice.inforManagementdataservice.StaffInfordataservice;
import dataservice.inforManagementdataservice.VehiclesInfordataservice;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;
import dataservice.managerAndAccountantdataservice.InquireOperaLogdataservice;
import dataservice.managerAndAccountantdataservice.StatisAnalydataservice;
import dataservice.orderdataservice.InquireLogisticsInfordataservice;
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
					("rmi://127.0.0.1:6602/dataFactoryservice");
			System.out.println("客户端已连接至服务器端");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Orderdataservice getOrderDataservice() throws RemoteException {
		return dataFactoryservice.getOrderdataservice();
	}
	
	public static BusiHallArrivalOrderdataservice getBusiHallArrivalOrderdataservice()
			throws RemoteException{
		return dataFactoryservice.getBusiHallArrivalOrderdataservice();
	}
			
	public static TranCenArrivalOrderdataservice getTranCenArrivalOrderdataservice()
		throws RemoteException{
		return dataFactoryservice.getTranCenArrivalOrderdataservice();
	}
			
	public static DeliveryOrderdataservice getDeliveryOrderdataservice() 
		throws RemoteException{
		return dataFactoryservice.getDeliveryOrderdataservice();
	}
	
	public static BusiHallLoadingListdataservice getBuinessHallLoadingListdataservice()
			throws RemoteException {
		return dataFactoryservice.getBuinessHallLoadingListdataservice();
	}

	public static TranCenLoadingListdataservice getTransferCenterLoadingListdataservice()
			throws RemoteException {
		return dataFactoryservice.getTransferCenterLoadingListdataservice();
	}
	
	public static PaymentOrderdataservice getPaymentOrderdataservice() throws RemoteException{
		return dataFactoryservice.getPaymentOrderdataservice();
	}
			
	public static ReceivablesOrderdataservice getReceivablesOrderdataservice() 
	throws RemoteException{
		return dataFactoryservice.getReceivablesOrderdataservice();
	}
			
	public static TransferOrderdataservice getTransferOrderdataservice() throws RemoteException{
		return dataFactoryservice.getTransferOrderdataservice();
	}
			
	public static AgencyInfordataservice getAgencyInfordataservice() throws RemoteException{
		return dataFactoryservice.getAgencyInfordataservice();
	}
			
	public static BankAccountInfordataservice getBankAccountInfordataservice() throws RemoteException{
		return dataFactoryservice.getBankAccountInfordataservice();
	}
			
	public static DriversInfordataservice getDriversInfordataservice() throws RemoteException{
		return dataFactoryservice.getDriversInfordataservice();
	}
			
	public static StaffInfordataservice getStaffInfordataservice() throws RemoteException{
		return dataFactoryservice.getStaffInfordataservice();
	}
			
	public static VehiclesInfordataservice getVehiclesInfordataservice() throws RemoteException{
		return dataFactoryservice.getVehiclesInfordataservice();
	}
			
	public static Approdocmdataservice getApprodocmdataservice() throws RemoteException{
		return dataFactoryservice.getApprodocmdataservice();
	}
			
	public static StatisAnalydataservice getStatisAnalydataservice() throws RemoteException{
		return dataFactoryservice.getStatisAnalydataservice();
	}
			
	public static InquireOperaLogdataservice getInquireOperaLogdataservice() throws 
	RemoteException{
		return dataFactoryservice.getInquireOperaLogdataservice();
	}
			
	public static OutBoundOrderdataservice getOutBoundOrderdataservice() throws RemoteException{
		return dataFactoryservice.getOutBoundOrderdataservice();
	}
			
	public static Stockdataservice getStockdataservice() throws RemoteException{
		return dataFactoryservice.getStockdataservice();
	}
			
	public static StorageListdataservice getStorageListdataservice() throws RemoteException{
		return dataFactoryservice.getStorageListdataservice();
	}
			
	public static Logindataservice getLogindataservice() throws RemoteException{
		return dataFactoryservice.getLogindataservice();	
	}
			
	public static UserManagementdataservice getUserManagementdataservice() throws RemoteException{
		return dataFactoryservice.getUserManagementdataservice();
	}
			
	public static RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
	RemoteException{
		return dataFactoryservice.getRecordOperaLogdataservice();
	}
			
	public static UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
	throws RemoteException{
		return dataFactoryservice.getUpdateLogisticsInfordataservice();
	}
	
	public static InquireLogisticsInfordataservice getInquireLogisticsInfordataservice() 
			throws RemoteException {
		return dataFactoryservice.getInquireLogisticsInfordataservice();
	}
	
	public static void main(String[] args) {
		init();
	}
}
