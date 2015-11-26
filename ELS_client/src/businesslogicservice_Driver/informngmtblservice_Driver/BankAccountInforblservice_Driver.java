package businesslogicservice_Driver.informngmtblservice_Driver;

import businesslogicservice.inforManagementblservice.BankAccountInforblservice;
import businesslogicservice_Stub.informngmtblservice_Stub.BankAccountInforblservice_Stub;

public class BankAccountInforblservice_Driver {
	
	public void drive(BankAccountInforblservice bankAccountInforblservice) {
//		bankAccountInforblservice.inquire(null);
	}
	
	public static void main(String[] args) {
		BankAccountInforblservice bankAccountInforblservice_Stub = new
				BankAccountInforblservice_Stub();
		BankAccountInforblservice_Driver driver = new BankAccountInforblservice_Driver();
		driver.drive(bankAccountInforblservice_Stub);
	}
}
//	public void drive(BankAccountInforblservice bankAccountInforblservice) {
//		bankAccountInforblservice.inquire(null);
//	}
//	
//	public static void main(String[] args) {
//		BankAccountInforblservice bankAccountInforblservice_Stub = new
//				BankAccountInforblservice_Stub();
//		BankAccountInforblservice_Driver driver = new BankAccountInforblservice_Driver();
//		driver.drive(bankAccountInforblservice_Stub);
//	}
