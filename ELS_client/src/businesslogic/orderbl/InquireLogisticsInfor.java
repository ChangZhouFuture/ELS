package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.utilityPO.LogisticsInforPO;
import state.ResultMessage;
import vo.utilityVO.LogisticsInforVO;
import dataservice.orderdataservice.InquireLogisticsInfordataservice;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.orderblservice.InquireLogisticsInforblservice;

public class InquireLogisticsInfor implements InquireLogisticsInforblservice{
	private InquireLogisticsInfordataservice inquireLogisticsInfordataservice;
	private LogisticsInforPO logisticsInforPO;
	private LogisticsInforVO logisticsInforVO;
	private ArrayList<LogisticsInforPO> arrayList;
	private ArrayList<LogisticsInforVO> arrayList2;
	private JavaBean1 javaBean1;
	
	public InquireLogisticsInfor() {
		try {
			inquireLogisticsInfordataservice = RMIHelper.getInquireLogisticsInfordataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireLogisticsInfor(String orderID) {
		//为了方便,展示层直接调用order的findA方法，得到lineitem
		try {
			javaBean1 = inquireLogisticsInfordataservice.inquireLogisticsInfor(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		arrayList = (ArrayList<LogisticsInforPO>)javaBean1.getObject();
		
		if (javaBean1.getResultMessage() == ResultMessage.NotExist) {
			return javaBean1;
		}
		int k = arrayList.size();
		
		POtoVO(k);
		javaBean1.setObject(arrayList2);
		return javaBean1;
	}

	public void POtoVO(int k) {
		arrayList2 = new ArrayList<LogisticsInforVO>();
		
		for (int i = 0; i < k; i++) {
			logisticsInforPO = arrayList.get(i);
			
			logisticsInforVO = new LogisticsInforVO();
			logisticsInforVO.setGenerateDate(logisticsInforPO.getGenerateDate());
			logisticsInforVO.setDescripition(logisticsInforPO.getDescription());
			
			arrayList2.add(logisticsInforVO);
		}
	}
	
}
