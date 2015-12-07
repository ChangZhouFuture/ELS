package businesslogic.managerAndAccountantbl;

import java.util.ArrayList;
import po.utilityPO.OperaLogPO;
import state.ResultMessage;
import vo.utilityVO.OperaLogVO;
import dataservice.managerAndAccountantdataservice.InquireOperaLogdataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.managerAndAccountantblservice.OperaLogblservice;

public class InquireOperaLog implements OperaLogblservice{
	private InquireOperaLogdataservice InquireOperaLogdataservice;
	private OperaLogPO operaLogPO;
	private OperaLogVO operaLogVO;
	private ArrayList<OperaLogPO> arrayList;
	private ArrayList<OperaLogVO> arrayList2;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public InquireOperaLog() {
		try {
			InquireOperaLogdataservice = RMIHelper.getInquireOperaLogdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireOperaLog(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
