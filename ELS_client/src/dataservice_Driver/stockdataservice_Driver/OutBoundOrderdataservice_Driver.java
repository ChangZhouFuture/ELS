package dataservice_Driver.stockdataservice_Driver;

import java.util.ArrayList;

import dataservice.stockdataservice.OutBoundOrderdataservice;
import dataservice_Stub.stockdataservice_Stub.OutBoundOrderdataservice_Stub;

public class OutBoundOrderdataservice_Driver {
	public void drive(OutBoundOrderdataservice outBoundOrderdataservice) {
		outBoundOrderdataservice.deleteMany(null);
	}
	public static void main(String[] args) {
		OutBoundOrderdataservice outBoundOrderdataservice_Stub = new 
				OutBoundOrderdataservice_Stub();
		OutBoundOrderdataservice_Driver driver =new OutBoundOrderdataservice_Driver();
		driver.drive(outBoundOrderdataservice_Stub);
	}
}
