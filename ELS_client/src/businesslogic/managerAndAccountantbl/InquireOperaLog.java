package businesslogic.managerAndAccountantbl;

import java.rmi.RemoteException;
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
		try {
			javaBean1 = InquireOperaLogdataservice.inquire(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<OperaLogPO>)javaBean1.getObject();
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}
	
	public void POtoVO(int k) {
		arrayList2 = new ArrayList<OperaLogVO>();
		
		for (int i = 0; i < k; i++) {
			operaLogPO = arrayList.get(i);
			
			operaLogVO = new OperaLogVO();
			operaLogVO.setGenerateTime(operaLogPO.getGenerateTime());
			operaLogVO.setPositon(operaLogPO.getPositon());
			operaLogVO.setOperatorId(operaLogPO.getOperatorId());
			operaLogVO.setOperaType(operaLogPO.getOperaType());
			operaLogVO.setObjectType(operaLogPO.getObjectType());
			operaLogVO.setId(operaLogPO.getId());
			
			arrayList2.add(operaLogVO);
		}
	}

}
