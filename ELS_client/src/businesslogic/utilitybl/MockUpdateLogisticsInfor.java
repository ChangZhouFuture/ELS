package businesslogic.utilitybl;

import state.ResultMessage;

public class MockUpdateLogisticsInfor extends UpdateLogisticsInfor{
	public ResultMessage update(String id) {
		
		System.out.println("�����ɼ�");
		return ResultMessage.Success;
	}
}
