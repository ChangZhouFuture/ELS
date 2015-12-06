package data.datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.documentsdata.BusiHallArrivalOrderdata;
import data.documentsdata.BusiHallLoadingListdata;
import data.documentsdata.DeliveryOrderdata;
import data.documentsdata.ReceivablesOrderdata;
import data.documentsdata.TranCenArrivalOrderdata;
import data.documentsdata.TranCenLoadingListdata;
import data.documentsdata.TransferOrderdata;
import data.orderdata.Orderdata;
import data.userdata.Logindata;
import data.utility.RecordOperaLogdata;
import data.utility.UpdateLogisticsInfordata;
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
	
	public BusiHallArrivalOrderdataservice getBusiHallArrivalOrderdataservice()
	throws RemoteException{
		BusiHallArrivalOrderdataservice busiHallArrivalOrderdataservice = new 
				BusiHallArrivalOrderdata();
		return busiHallArrivalOrderdataservice;
	}
	
	public TranCenArrivalOrderdataservice getTranCenArrivalOrderdataservice()
		throws RemoteException{
		TranCenArrivalOrderdataservice tranCenArrivalOrderdataservice = new 
				TranCenArrivalOrderdata();
		return tranCenArrivalOrderdataservice;
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
		ReceivablesOrderdataservice receivablesOrderdataservice = new 
				ReceivablesOrderdata();
		return receivablesOrderdataservice;
	}
	
	public TransferOrderdataservice getTransferOrderdataservice() throws RemoteException{
		TransferOrderdataservice transferOrderdataservice = new TransferOrderdata();
		return transferOrderdataservice;
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
		Logindataservice logindataservice = new Logindata();
		return logindataservice;
	}
	
	public UserManagementdataservice getUserManagementdataservice() throws RemoteException{
		return null;
		
	}
	
	public RecordOperaLogdataservice getRecordOperaLogdataservice() throws 
	RemoteException{
		RecordOperaLogdataservice recordOperaLogdataservice = new RecordOperaLogdata();
		return recordOperaLogdataservice;
	}
	
	public UpdateLogisticsInfordataservice getUpdateLogisticsInfordataservice() 
	throws RemoteException{
		UpdateLogisticsInfordataservice updateLogisticsInfordataservice = new 
				UpdateLogisticsInfordata();
		return updateLogisticsInfordataservice;
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
		TranCenLoadingListdataservice tranCenLoadingListdataservice = new 
				TranCenLoadingListdata();
		return tranCenLoadingListdataservice;
	}
}
