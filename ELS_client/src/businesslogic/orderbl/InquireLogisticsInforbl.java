package businesslogic.orderbl;

import dataservice.orderdataservice.InquireLogisticsInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.orderblservice.InquireLogisticsInforblservice;

public class InquireLogisticsInforbl implements InquireLogisticsInforblservice{
	private InquireLogisticsInfordataservice inquireLogisticsInfordataservice;
	
	public InquireLogisticsInforbl() {
		try {
			inquireLogisticsInfordataservice = RMIHelper.getInquireLogisticsInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireLogisticsInfor(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
