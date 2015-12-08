package data.datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.documentsdata.BusiHallArrivalOrderdata;
import data.documentsdata.BusiHallLoadingListdata;
import data.documentsdata.DeliveryOrderdata;
import data.documentsdata.PaymentOrderdata;
import data.documentsdata.ReceivablesOrderdata;
import data.documentsdata.TranCenArrivalOrderdata;
import data.documentsdata.TranCenLoadingListdata;
import data.documentsdata.TransferOrderdata;
import data.inforManagementdata.AgencyInfordata;
import data.inforManagementdata.BankAccountInfordata;
import data.inforManagementdata.DriversInfordata;
import data.inforManagementdata.StaffInfordata;
import data.inforManagementdata.VehiclesInfordata;
import data.managerAndAccountantdata.Approdocmdata;
import data.managerAndAccountantdata.InquireOperaLogdata;
import data.managerAndAccountantdata.StatisAnalydata;
import data.orderdata.InquireLogisticsInfordata;
import data.orderdata.Orderdata;
import data.stockdata.OutBoundOrderdata;
import data.stockdata.Stockdata;
import data.stockdata.StorageListdata;
import data.userManagementdata.UserManagementdata;
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
import dataservice.orderdataservice.InquireLogisticsInfordataservice;
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
		PaymentOrderdataservice paymentOrderdataservice = new PaymentOrderdata();
		return paymentOrderdataservice;
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
		AgencyInfordataservice agencyInfordataservice = new AgencyInfordata();
		return agencyInfordataservice;
	}
	
	public BankAccountInfordataservice getBankAccountInfordataservice() throws RemoteException{
		BankAccountInfordataservice bankAccountInfordataservice = new 
				BankAccountInfordata();
		return bankAccountInfordataservice;
	}
	
	public DriversInfordataservice getDriversInfordataservice() throws RemoteException{
		DriversInfordataservice driversInfordataservice = new DriversInfordata();
		return driversInfordataservice;
	}
	
	public StaffInfordataservice getStaffInfordataservice() throws RemoteException{
		StaffInfordataservice staffInfordataservice = new StaffInfordata();
		return staffInfordataservice;
	}
	
	public VehiclesInfordataservice getVehiclesInfordataservice() throws RemoteException{
		VehiclesInfordataservice vehiclesInfordataservice = new VehiclesInfordata();
		return vehiclesInfordataservice;
	}
	
	public Approdocmdataservice getApprodocmdataservice() throws RemoteException{
		Approdocmdataservice approdocmdataservice = new Approdocmdata();
		return approdocmdataservice;
	}
	
	public StatisAnalydataservice getStatisAnalydataservice() throws RemoteException{
		StatisAnalydataservice statisAnalydataservice = new StatisAnalydata();
		return statisAnalydataservice;
	}
	
	public  InquireOperaLogdataservice getInquireOperaLogdataservice() throws 
	RemoteException{
		InquireOperaLogdataservice inquireOperaLogdataservice = new 
				InquireOperaLogdata();
		return inquireOperaLogdataservice;
	}
	
	public OutBoundOrderdataservice getOutBoundOrderdataservice() throws RemoteException{
		OutBoundOrderdataservice outBoundOrderdataservice = new OutBoundOrderdata();
		return outBoundOrderdataservice;
	}
	
	public Stockdataservice getStockdataservice() throws RemoteException{
		Stockdataservice stockdataservice = new Stockdata();
		return stockdataservice;
	}
	
	public StorageListdataservice getStorageListdataservice() throws RemoteException{
		StorageListdataservice storageListdataservice = new StorageListdata();
		return storageListdataservice;
	}
	
	public Logindataservice getLogindataservice() throws RemoteException{
		Logindataservice logindataservice = new Logindata();
		return logindataservice;
	}
	
	public UserManagementdataservice getUserManagementdataservice() throws RemoteException{
		UserManagementdataservice userManagementdataservice = new 
				UserManagementdata();
		return userManagementdataservice;
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

	@Override
	public InquireLogisticsInfordataservice getInquireLogisticsInfordataservice() throws RemoteException {
		// TODO Auto-generated method stub
		InquireLogisticsInfordataservice inquireLogisticsInfordataservice =new 
				InquireLogisticsInfordata(); 
		return inquireLogisticsInfordataservice;
	}
}
