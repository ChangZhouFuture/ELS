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
		Mainui mainui = new Mainui();
	}
}
