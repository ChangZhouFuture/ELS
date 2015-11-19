package businesslogicservice_client_Driver.informngmtblservice_Driver;

import businesslogicservice_client.inforManagementblservice.DriversInforblservice;
import businesslogicservice_client_Stub.informngmtblservice_Stub.DriversInforblservice_Stub;

public class DriversInforblservice_Driver {
	public void drive(DriversInforblservice DriversInforblservice) {
		DriversInforblservice.inquire(null);
	}
	
	public static void main(String[] args) {
		DriversInforblservice DriversInforblservice_Stub = new
				DriversInforblservice_Stub();
		DriversInforblservice_Driver driver = new DriversInforblservice_Driver();
		driver.drive(DriversInforblservice_Stub);
	}
}
