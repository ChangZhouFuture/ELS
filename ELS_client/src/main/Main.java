package main;

import RMI.RMIHelper;
import presentation.userui.Mainui;

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
