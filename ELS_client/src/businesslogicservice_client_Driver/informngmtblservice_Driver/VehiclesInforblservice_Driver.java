package businesslogicservice_client_Driver.informngmtblservice_Driver;


import businesslogicservice_client.informngmtblservice.VehiclesInforblservice;
import businesslogicservice_client_Stub.informngmtblservice_Stub.VehiclesInforblservice_Stub;

public class VehiclesInforblservice_Driver {
	public void drive(VehiclesInforblservice VehiclesInforblservice) {
		VehiclesInforblservice.inquire(null);
	}
	
	public static void main(String[] args) {
		VehiclesInforblservice VehiclesInforblservice_Stub = new
				VehiclesInforblservice_Stub();
		VehiclesInforblservice_Driver vehicles = new VehiclesInforblservice_Driver();
		vehicles.drive(VehiclesInforblservice_Stub);
	}
}
