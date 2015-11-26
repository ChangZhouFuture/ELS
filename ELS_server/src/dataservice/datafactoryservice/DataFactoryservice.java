package dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.documentsdataservice.ArrivalOrder4BusiHalldataservice;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import dataservice.documentsdataservice.BuinessHallLoadingListdataservice;
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

public interface DataFactoryservice extends Remote{
	public Orderdataservice getOrderdataservice() throws RemoteException;
	
	public ArrivalOrder4BusiHalldataservice getArrivalOrder4BusiHalldataservice()
			throws RemoteException;
			
	public ArrivalOrder4TranCendataservice getArrivalOrder4TranCendataservice()
		throws RemoteException;
			
	public DeliveryOrderdataservice getDeliveryOrderdataservice() 
		throws RemoteException;
			
	public BuinessHallLoadingListdataservice getLoadingListdataservice() throws RemoteException;
		
			
	public PaymentOrderdataservice getPaymentOrderdataservice() throws RemoteException;
			
			
	public ReceivablesOrderdataservice getReceivablesOrderdataservice() 
			throws RemoteException;
			
	public TransferOrderdataservice getTransferOrderdataservice() throws RemoteException;
				
			
	public AgencyInfordataservice getAgencyInfordataservice() throws RemoteException;
			
			
	public BankAccountInfordataservice getBankAccountInfordataservice() throws RemoteException;
				
			
	public DriversInfordataservice getDriversInfordataservice() throws RemoteException;
				
			
	public StaffInfordataservice getStaffInfordataservice() throws RemoteException;
				
			
	public VehiclesInfordataservice getVehiclesInfordataservice() throws RemoteException;
				
			
	public Approdocmdataservice getApprodocmdataservice() throws RemoteException;
			
			
	public StatisAnalydataservice getStatisAnalydataservice() throws RemoteException;
				
			
	public  InquireOperaLogdataservice getInquireOperaLogdataservice() throws 
			RemoteException;
				
			
	public OutBoundOrderdataservice getOutBoundOrderdataservice() throws RemoteException;
				
			
	public Stockdataservice getStockdataservice() throws RemoteException;
				
		
	public StorageListdataservice getStorageListdataservice() throws RemoteException;
				
			
	public Logindataservice getLogindataservice() throws RemoteException;
			
			
	public UserManagementdataservice getUserManagementdataservice() throws RemoteException;
			
			
	public AutoGenerateTimedataservice getautAutoGenerateTimedataservice() throws 
			RemoteException;
				
			
	public RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
			RemoteException;
				
	public UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
			throws RemoteException;
}
