package dataservice_client_Driver.orderdataservice_Driver;

import dataservice_client.orderdataservice.Orderdataservice;
import dataservice_client_Stub.orderdataservice_Stub.Orderdataservice_Stub;

public class Orderdataservice_Driver {
    public void drive(Orderdataservice orderdataservice){
//    	orderdataservice.delete("");
//    	orderdataservice.inquireA("");
//    	orderdataservice.update();
    }
    
    public static void main(String[] args) {
		Orderdataservice orderdataservice_Stub=new Orderdataservice_Stub();
		Orderdataservice_Driver driver=new Orderdataservice_Driver();
		driver.drive(orderdataservice_Stub);
	}
}

