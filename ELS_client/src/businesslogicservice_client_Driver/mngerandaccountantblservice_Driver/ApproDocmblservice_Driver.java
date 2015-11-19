package businesslogicservice_client_Driver.mngerandaccountantblservice_Driver;

import businesslogicservice_client.managerAndAccountantblservice.ApproDocmblservice;
import businesslogicservice_client_Stub.mngerandaccountantblservice_Stub.ApproDocmblservice_Stub;

public class ApproDocmblservice_Driver {
    public void drive(ApproDocmblservice approDocmblservice){ 
    	approDocmblservice.delete("");
    }
    
    public static void main(String[] args) {
    	ApproDocmblservice approDocmblservice_Stub=new ApproDocmblservice_Stub();
    	ApproDocmblservice_Driver driver=new ApproDocmblservice_Driver();
    	driver.drive(approDocmblservice_Stub);
    	
	}
}

