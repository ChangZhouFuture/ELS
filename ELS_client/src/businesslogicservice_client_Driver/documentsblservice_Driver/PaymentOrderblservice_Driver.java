package businesslogicservice_client_Driver.documentsblservice_Driver;

import businesslogicservice_client.documentsblservice.PaymentOrderblservice;
import businesslogicservice_client_Stub.documentsblservice_Stub.PaymentOrderblservice_Stub;

public class PaymentOrderblservice_Driver {
	public void drive(PaymentOrderblservice PaymentOrderblservice) {
		PaymentOrderblservice.inquireA(null);
	}
	
	public static void main(String[] args) {
		PaymentOrderblservice PaymentOrderblservice_Stub = new
				PaymentOrderblservice_Stub();
		PaymentOrderblservice_Driver driver = new PaymentOrderblservice_Driver();
		driver.drive(PaymentOrderblservice_Stub);
	}
}
