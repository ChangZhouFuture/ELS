package businesslogicservice_client_Driver.stockblservice_Driver;

import businesslogicservice_client.stockblservice.OutBoundOrderblservice;
import businesslogicservice_client_Stub.stockblservice_Stub.OutBoundOrderblservice_Stub;


public class OutBoundOrderblservice_Driver {
	public void drive(OutBoundOrderblservice outBoundOrderblservice) {
		outBoundOrderblservice.deleteone("");
	}
	
	public static void main(String[] args) {
		OutBoundOrderblservice outBoundOrderblservice_Stub = new
				OutBoundOrderblservice_Stub();
		OutBoundOrderblservice_Driver driver = new OutBoundOrderblservice_Driver();
		driver.drive(outBoundOrderblservice_Stub);
	}
}
