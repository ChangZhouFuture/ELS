package dataservice_client_Driver.stockdataservice_Driver;

import dataservice_client.stockdataservice.StorageListdataservice;
import dataservice_client_Stub.stockdataservice_Stub.StorageListdataservice_Stub;

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
