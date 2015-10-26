package dataservice_client_Driver.mngerandaccountantdataservice_Driver;

import dataservice_client.mngerandaccountantdataservice.Approdocmdataservice;
import dataservice_client_Stub.mngerandaccountantdataservice_Stub.Approdocmdataservice_Stub;

public class Approdocmdataservice_Driver {
    public void drive(Approdocmdataservice approdocmdataservice){
    	approdocmdataservice.inquireA("");
    	approdocmdataservice.modify();
    	approdocmdataservice.update();
    	
    }
    
    public static void main(String[] args) {
		Approdocmdataservice approdocmdataservice_Stub=new Approdocmdataservice_Stub();
		Approdocmdataservice_Driver driver=new Approdocmdataservice_Driver();
		driver.drive(approdocmdataservice_Stub);
	}
}
