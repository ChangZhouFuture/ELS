package data.datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.documentsdata.BusiHallArrivalOrderdata;
import data.documentsdata.BusiHallLoadingListdata;
import data.documentsdata.DeliveryOrderdata;
import data.orderdata.Orderdata;
import dataservice.datafactoryservice.DataFactoryservice;
import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;
import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;
import dataservice.documentsdataservice.DeliveryOrderdataservice;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;
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
import dataservice.orderdataservice.Orderdataservice;
import dataservice.stockdataservice.OutBoundOrderdataservice;
import dataservice.stockdataservice.Stockdataservice;
import dataservice.stockdataservice.StorageListdataservice;
import dataservice.userManagementdataservice.UserManagementdataservice;
import dataservice.userdataservice.Logindataservice;
import dataservice.utilitydataservice.RecordOperaLogdataservice;
import dataservice.utilitydataservice.UpdateLogisticsInfordataservice;

public class DataFactory extends UnicastRemoteObject implements DataFactoryservice{
	
	public DataFactory() throws RemoteException {
		super();
	}

	public Orderdataservice getOrderdataservice() throws RemoteException {
		Orderdataservice orderdataservice = new Orderdata();
		return orderdataservice;
	}
	
	public BusiHallArrivalOrderdataservice getArrivalOrder4BusiHalldataservice()
	throws RemoteException{
		
		return null;
	}
	
	public TranCenArrivalOrderdataservice getArrivalOrder4TranCendataservice()
		throws RemoteException{
				
		return null;
	}
	
	public DeliveryOrderdataservice getDeliveryOrderdataservice() 
		throws RemoteException{
		DeliveryOrderdataservice deliveryOrderdataservice = new DeliveryOrderdata();
		return deliveryOrderdataservice;
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
	
	public RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
	RemoteException{
		return null;
		
	}
	
	public UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
	throws RemoteException{
		return null;
		
	}

	@Override
	public BusiHallLoadingListdataservice getBuinessHallLoadingListdataservice()
			throws RemoteException {
		BusiHallLoadingListdataservice busiHallLoadingListdataservice = new
				BusiHallLoadingListdata();
		return busiHallLoadingListdataservice;
	}

	@Override
	public TranCenLoadingListdataservice getTransferCenterLoadingListdataservice()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
