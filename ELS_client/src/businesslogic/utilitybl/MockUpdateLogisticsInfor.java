package businesslogic.utilitybl;

import state.ResultMessage;

public class MockUpdateLogisticsInfor extends UpdateLogisticsInfor{
	public ResultMessage update(String id) {
		
		System.out.println("ÕıÔÚÅÉ¼ş");
		return ResultMessage.Success;
	}
}
