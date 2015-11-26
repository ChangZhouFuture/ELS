package businesslogicservice_Driver.documentsblservice_Driver;

import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
import businesslogicservice_Stub.documentsblservice_Stub.ReceivablesOrderblservice_Stub;


public class ReceivablesOrderblservice_Driver {
	public void drive(ReceivablesOrderblservice ReceivablesOrderblservice) {
		ReceivablesOrderblservice.inquire(null);
	}
	
	public static void main(String[] args) {
		ReceivablesOrderblservice ReceivablesOrderblservice_Stub = new
				ReceivablesOrderblservice_Stub();
		ReceivablesOrderblservice_Driver driver = new ReceivablesOrderblservice_Driver();
		driver.drive(ReceivablesOrderblservice_Stub);
	}
}
