package businesslogicservice_client_Stub.stockblservice_Stub;

import java.util.ArrayList;

import businesslogicservice_client.stockblservice.OutBoundOrderblservice;
import vo_client.OrderVO;
import vo_client.stockVO.OutBoundOrderVO;

public class OutBoundOrderblservice_Stub implements OutBoundOrderblservice{
	OutBoundOrderVO oboVO;
	OrderVO oVO;
	String id4obo;
	String id4e;
	String id4to;
	String desti;
	String time;
	
	@Override
	public OrderVO addExpress(String id) {
		// TODO Auto-generated method stub
		// �˴��������ݲ�Ĳ��ҷ���
		
		System.out.println("���ӿ���ɹ�");
		return oVO;
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
		
		return oboVO;
	}

	@Override
	public void deleteone(String id4bob) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ���� PO
		
		//����ɾ�� ����VO
		
		System.out.println("ɾ��һ�����ⵥ�ɹ�");
	}
	
	@Override
	public void deleteMany(ArrayList<String> id4OBO) {
		// TODO Auto-generated method stub
		//����ɾ�� �������ݲ㷽�� ����PO
		
		//����ɾ�� ����VO
		
		System.out.println("ɾ��������ⵥ�ɹ�");
	}

	@Override
	public OutBoundOrderVO modify(String id4obo, String id4e, String id4to,
			String desti) {
		// TODO Auto-generated method stub
		//�������ݲ���޸ķ������޸�PO
		
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
		
		System.out.println("�����Գ��ⵥ����");
	}


}
