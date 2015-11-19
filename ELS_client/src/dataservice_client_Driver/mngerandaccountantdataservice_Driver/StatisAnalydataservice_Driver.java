package dataservice_client_Driver.mngerandaccountantdataservice_Driver;

import dataservice_client.managerAndAccountantdataservice.StatisAnalydataservice;
import dataservice_client_Stub.mngerandaccountantdataservice_Stub.StatisAnalydataservice_Stub;

public class StatisAnalydataservice_Driver {
    public void drive(StatisAnalydataservice statisAnalydataservice){
    	statisAnalydataservice.BS("", "");
    	statisAnalydataservice.CAI();
    	statisAnalydataservice.profit(20000, 5000);
    }
    
    public static void main(String[] args) {
		StatisAnalydataservice statisAnalydataservice_Stub=new StatisAnalydataservice_Stub();
		StatisAnalydataservice_Driver driver=new StatisAnalydataservice_Driver();
		driver.drive(statisAnalydataservice_Stub);
	}
}
