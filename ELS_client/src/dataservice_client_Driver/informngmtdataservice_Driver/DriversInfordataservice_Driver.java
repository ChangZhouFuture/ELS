package dataservice_client_Driver.informngmtdataservice_Driver;

import dataservice_client.informngmtdataservice.DriversInfordataservice;
import dataservice_client_Driver.informngmtdataservice_Driver.DriversInfordataservice_Driver;
import dataservice_client_Stub.informngmtdataservice_Stub.DriversInfordataservice_Stub;

public class DriversInfordataservice_Driver {
	public void drive(DriversInfordataservice DriversInfordataservice) {
		DriversInfordataservice.deleteOne(null);
	}
	public static void main(String[] args) {
		DriversInfordataservice driversInfordataservice_Stub = new 
				DriversInfordataservice_Stub();
		DriversInfordataservice_Driver driver =new DriversInfordataservice_Driver();
		driver.drive(driversInfordataservice_Stub);
	}
}
