package businesslogicservice_client_Driver.documentsblservice_Driver;

import businesslogicservice_client.documentsblservice.DeliveryOrderblservice;
import businesslogicservice_client_Stub.documentsblservice_Stub.DeliveryOrderblservice_Stub;
import state.ResultMessage;

public class DeliveryOrderblservice_Driver {
	public void drive(DeliveryOrderblservice deliveryorderblservice){
		ResultMessage result1=deliveryorderblservice.addDeliverier("kd01100201");
		if(result1==ResultMessage.Exist)
			System.out.println("Deliverier exist\n");
		deliveryorderblservice.deleteone("1010203013");
		deliveryorderblservice.end();
	}
	public static void main(String[] args){
		DeliveryOrderblservice deliveryorderblservice_Stub=new DeliveryOrderblservice_Stub();
		DeliveryOrderblservice_Driver driver=new DeliveryOrderblservice_Driver();
		driver.drive(deliveryorderblservice_Stub);
	}
}


