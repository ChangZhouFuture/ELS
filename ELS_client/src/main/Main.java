package main;

import businesslogic.orderbl.Order;
import presentation.userui.Loginui;
import presentation.userui.Mainui;
import RMI.RMIHelper;

/**
 * 
 * @author Administrator
 * �ͻ������
 *
 */
public class Main {
	public static void main(String[] args) {
		RMIHelper.init();
//		Loginui loginui=new Loginui();
		Mainui mainui = new Mainui();
		
	}
}
