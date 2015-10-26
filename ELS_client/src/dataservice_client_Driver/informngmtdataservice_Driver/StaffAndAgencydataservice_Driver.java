package dataservice_client_Driver.informngmtdataservice_Driver;

import dataservice_client.informngmtdataservice.StaffAndAgencydataservice;
import dataservice_client_Stub.informngmtdataservice_Stub.StaffAndAgencydataservice_Stub;

public class StaffAndAgencydataservice_Driver {
     public void drive(StaffAndAgencydataservice staffAndAgencydataservice){
    	 staffAndAgencydataservice.delete("");
    	 staffAndAgencydataservice.update();
     }
     
     public static void main(String[] args) {
		StaffAndAgencydataservice staffAndAgencydataservice_Stub=new StaffAndAgencydataservice_Stub();
		StaffAndAgencydataservice_Driver driver=new StaffAndAgencydataservice_Driver();
		driver.drive(staffAndAgencydataservice_Stub);
	}
}
