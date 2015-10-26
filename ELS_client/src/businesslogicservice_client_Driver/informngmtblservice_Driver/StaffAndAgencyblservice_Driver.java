package businesslogicservice_client_Driver.informngmtblservice_Driver;

import businesslogicservice_client.informngmtblservice.StaffAndAgencyblservice;
import businesslogicservice_client_Stub.informngmtblservice_Stub.StaffAndAgencyblservice_Stub;

public class StaffAndAgencyblservice_Driver {
    public void drive(StaffAndAgencyblservice staffAndAgencyblservice){
    	staffAndAgencyblservice.delete("");
    }
    
    public static void main(String[] args) {
		StaffAndAgencyblservice  staffAndAgency_Stub=new StaffAndAgencyblservice_Stub();
		StaffAndAgencyblservice_Driver driver=new StaffAndAgencyblservice_Driver();
		driver.drive(staffAndAgency_Stub);
	}
}


