package businesslogic_client.stockbl;

import state.ResultMessage;

public class MockStock extends Stock{
	
	public ResultMessage outBound(String id) {
		//id��ָ����Ŀ�ݵĶ�����id
		//����������ݲ㷽���Ѳֿ��Ÿÿ�ݵ�λ������Ϊ�գ���ʾ����Ѿ�����
		
		return ResultMessage.Success;
	}
}
