package businesslogicservice_Driver.documentsblservice_Driver;

import businesslogicservice.documentsblservice.PaymentOrderblservice;
import businesslogicservice_Stub.documentsblservice_Stub.PaymentOrderblservice_Stub;

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
