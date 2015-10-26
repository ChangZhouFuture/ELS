package dataservice_client_Driver.mngerandaccountantdataservice_Driver;

import dataservice_client.mngerandaccountantdataservice.OperaLogdataservice;
import dataservice_client_Stub.mngerandaccountantdataservice_Stub.OperaLogdataservice_Stub;

public class OperaLogdataservice_Driver {
    public void drive(OperaLogdataservice operaLogdataservice){
    	operaLogdataservice.inquireA("", "");
    	operaLogdataservice.inquireB("");
    	operaLogdataservice.inquireC("");
    
    }
    
    public static void main(String[] args) {
		OperaLogdataservice operaLogdataservice_Stub=new OperaLogdataservice_Stub();
		OperaLogdataservice_Driver driver=new OperaLogdataservice_Driver();
		driver.drive(operaLogdataservice_Stub);
	}
}
