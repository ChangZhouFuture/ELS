package businesslogic.managerAndAccountantbl;

import java.util.ArrayList;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;
import state.ResultMessage;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.managerAndAccountantblservice.ApproDocmblservice;

public class ApproDocm implements ApproDocmblservice{
	private Approdocmdataservice approdocmdataservice;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public ApproDocm() {
		try {
			approdocmdataservice = RMIHelper.getApprodocmdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireA(String id, String documentType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaBean1 inquireB(String documentsType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approveDocuments(ArrayList<String> IDList,
			String documentsType) {
		// TODO Auto-generated method stub
		return null;
	}

}
