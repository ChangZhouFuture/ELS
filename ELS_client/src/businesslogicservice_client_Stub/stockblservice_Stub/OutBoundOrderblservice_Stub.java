package businesslogicservice_client_Stub.stockblservice_Stub;

import java.util.ArrayList;

import businesslogicservice_client.stockblservice.OutBoundOrderblservice;
import state.ResultMessage;
import vo_client.lineitemVO.stocklineitemVO.OutBoundOrderlineitemVO;
import vo_client.orderVO.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;

public class OutBoundOrderblservice_Stub implements OutBoundOrderblservice{
	OutBoundOrderVO oboVO;
	OutBoundOrderlineitemVO obolineitemVO;
	OrderVO oVO;
	String id4obo;
	String id4e;
	String id4to;
	String desti;
	String time;
	
	@Override
	public OutBoundOrderlineitemVO addExpress(String id) {
		// TODO Auto-generated method stub
		// �˴�����id�Ѷ�Ӧ��OutBoundOrderlineitemVO��ֵ��obolineitemVO
		
		System.out.println("���ӿ���ɹ�");
		return obolineitemVO;
	}

	@Override
	public void generateId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateTime() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public OutBoundOrderVO add(String id4e, String id4to, String desti) {
		// TODO Auto-generated method stub
		this.id4e = id4e;
		this.id4to = id4to;
		this.desti = desti;
	
//		�˴�����VO���в�������¼oboVO��PO��VO�ĵ�����һ���ģ���
		oboVO = new OutBoundOrderVO(this.id4e, this.desti, this.id4to, this.id4obo, this.time);
		
		
//		�˴��������ݲ�����ӳ��ⵥ����������PO
		
		endOBO();
		return oboVO;
	}

	@Override
	public ResultMessage deleteone(String id4bob) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ���� PO
		
		//����ɾ�� ����VO
		
		endOBO();
		System.out.println("ɾ��һ�����ⵥ�ɹ�");
		return null;
	}
	
	@Override
	public ResultMessage deleteMany(ArrayList<String> id4OBO) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ����PO
		
		//����ɾ�� ����VO
		
		endOBO();
		System.out.println("ɾ��������ⵥ�ɹ�");
		return null;
	}

	@Override
	public OutBoundOrderVO modify(String id4obo, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		//�������ݲ���޸ķ������޸�PO
		
		endOBO();
		return null;
	}
	
	@Override
	public OutBoundOrderVO inquireA(String id) {
		// TODO Auto-generated method stub
		
		return oboVO;
	}
	
	@Override
	public OutBoundOrderVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void endOBO() {
		// TODO Auto-generated method stub
		
		//�˴��������ݲ��Update����
		
		System.out.println("�����Գ��ⵥ����");
	}


}
