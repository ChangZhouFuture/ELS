package dataservice_client_Driver.documentsdataservice_Driver;

import dataservice_client.documentsdataservice.ReceivablesOrderdataservice;
import dataservice_client_Stub.documentsdataservice_Stub.ReceivablesOrderdataservice_Stub;

public class ReceivablesOrderdataservice_Driver {
	public void drive(ReceivablesOrderdataservice ReceivablesOrderdataservice) {
		ReceivablesOrderdataservice.inquire(null);
	}
	
	public static void main(String[] args) {
		ReceivablesOrderdataservice ReceivablesOrderdateservice_Stub = new ReceivablesOrderdataservice_Stub();
		ReceivablesOrderdataservice_Driver driver = new ReceivablesOrderdataservice_Driver();
		driver.drive(ReceivablesOrderdateservice_Stub);
	}
}
