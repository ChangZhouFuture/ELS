package dataservice_client_Driver.documentsdataservice_Driver;

import dataservice_client.documentsdataservice.PaymentOrderdataservice;
import dataservice_client_Stub.documentsdataservice_Stub.PaymentOrderdataservice_Stub;


public class PaymentOrderdataservice_Driver {
	public void drive(PaymentOrderdataservice PaymentOrderdataservice) {
		PaymentOrderdataservice.inquire(null);
	}
	
	public static void main(String[] args) {
		PaymentOrderdataservice PaymentOrderdataservice_Stub = new
				PaymentOrderdataservice_Stub();
		PaymentOrderdataservice_Driver driver = new PaymentOrderdataservice_Driver();
		driver.drive(PaymentOrderdataservice_Stub);
	}
}
