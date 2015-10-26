package businesslogicservice_client_Driver.mngerandaccountantblservice_Driver;

import businesslogicservice_client.mngerandaccountantblservice.OperaLogblservice;
import businesslogicservice_client_Stub.mngerandaccountantblservice_Stub.OperaLogblservice_Stub;

public class OperaLogblservice_Driver {
    public void drive(OperaLogblservice operaLogblservice){
    	operaLogblservice.inquireA("","");
    }
    
    public static void main(String[] args){
    	OperaLogblservice operaLogblservice_Stub=new OperaLogblservice_Stub();
    	OperaLogblservice_Driver driver=new OperaLogblservice_Driver();
    	driver.drive(operaLogblservice_Stub);
		
	}
}
