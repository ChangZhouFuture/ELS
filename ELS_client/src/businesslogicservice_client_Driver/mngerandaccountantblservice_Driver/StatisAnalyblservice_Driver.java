package businesslogicservice_client_Driver.mngerandaccountantblservice_Driver;

import businesslogicservice_client.managerAndAccountantblservice.StatisAnalyblservice;
import businesslogicservice_client_Stub.mngerandaccountantblservice_Stub.StatisAnalyblservice_Stub;

public class StatisAnalyblservice_Driver {
    public void drive(StatisAnalyblservice statisAnalyblservice){
    	statisAnalyblservice.CAI();
    }
    
    public static void main(String[] args) {
    	StatisAnalyblservice statisAnalyblservice_Stub=new StatisAnalyblservice_Stub();
    	StatisAnalyblservice_Driver driver=new StatisAnalyblservice_Driver();
    	driver.drive(statisAnalyblservice_Stub);
	}
}
