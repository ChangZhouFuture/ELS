package main;

import businesslogic.orderbl.Order;
import presentation.userui.Loginui;
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
		Loginui loginui=new Loginui();
		
		
	}
}
