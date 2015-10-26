package businesslogicservice_client_Driver.orderblservice_Driver;

import businesslogicservice_client.orderblservice.Orderblservice;
import businesslogicservice_client_Stub.orderblservice_Stub.Orderblservice_Stub;

public class Orderblservice_Driver {
    public void drive(Orderblservice orderblservice){
    	orderblservice.delete("");
    }
    
    public static void main(String[] args){
    	Orderblservice  orderblservice_Stub=new Orderblservice_Stub();
    	Orderblservice_Driver driver=new Orderblservice_Driver();
    	driver.drive(orderblservice_Stub);
    	
    }
}
