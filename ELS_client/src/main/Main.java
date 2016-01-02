package main;

import RMI.RMIHelper;
import presentation.userui.Mainui;

/**
 * 
 * @author Administrator
 * 客户端入口
 *
 */
public class Main {
	public static void main(String[] args) {
		RMIHelper.init();
		Mainui mainui = new Mainui();
	}
}
