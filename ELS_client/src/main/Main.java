package main;

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
