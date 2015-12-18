package main;

import presentation.userui.Mainui;
import RMI.RMIHelper;

/**
 * 
 * @author Administrator
 * 客户端入口
 *
 */
public class Main {
	public static void main(String[] args) {
		RMIHelper.init();
//		Loginui loginui=new Loginui();
		Mainui mainui = new Mainui();
		
	}
}
