package dataservice_Driver.stockdataservice_Driver;

import dataservice.stockdataservice.StorageListdataservice;
import dataservice_Stub.stockdataservice_Stub.StorageListdataservice_Stub;

public class StorageListdataservice_Driver {
	public void drive(StorageListdataservice storageListdataservice) {
		storageListdataservice.deleteMany(null);
	}
	public static void main(String[] args) {
		StorageListdataservice storageListdataservice_Stub = new 
				StorageListdataservice_Stub();
		StorageListdataservice_Driver driver =new StorageListdataservice_Driver();
		driver.drive(storageListdataservice_Stub);
	}
}
