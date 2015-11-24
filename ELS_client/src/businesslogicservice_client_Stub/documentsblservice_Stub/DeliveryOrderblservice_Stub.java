package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;
 


 import state.ResultMessage;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.lineitemVO.userlineitemVO.SenderlineitemVO;
import businesslogicservice_client.documentsblservice.DeliveryOrderblservice;

/**
 * 
 * @author �쿡��
 *
 */
 public class DeliveryOrderblservice_Stub implements DeliveryOrderblservice{
 	String couriername;
 	String deliverierid;
 	String date;
 	DeliveryOrderVO dovo;
 	ArrayList<String> orsderidlist;
 	String id;
 	public DeliveryOrderVO addDeliveryOrder(String id,ArrayList<String> oil,String dn,String did,String d){
 		this.couriername=dn;
 		this.date=d;
 		this.deliverierid=did;
 		this.orsderidlist=oil;
 		this.id=id;
 //		�˴�����VO���в�������¼oboVO��PO��VO�ĵ�����һ���ģ���
 		dovo = new DeliveryOrderVO(this.id,this.orsderidlist,this.couriername,this.deliverierid,this.date);
 //		�˴��������ݲ�������ɼ�������������PO
 		end();
 		return dovo;
 	}
 	public String generateName(String id){
 		//�˴�����id���ؿ��Ա����
 		return couriername;
 	}
 	
 	public SenderlineitemVO addDeliverier(String id){
		return null;
 		
 	}
 	public OrderlineitemVO addOrder(String orderid){
 		System.out.println("Add Express successfully!");
 		return null;
 	}
 	public String generateDate(){
 		String date="2015/10/23";
 		return date;
 	}
 	
 	public void end(){
 		//�˴��������ݲ��Update����
 		
 		System.out.println("End the delivery!");
 	}
 	
 	@Override
 	public DeliveryOrderVO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d) {
 		// TODO Auto-generated method stub
 		end();
 		System.out.println("Modify the delivery successfully!");
 		return null;
 	}
 	@Override
 	public ResultMessage deleteMany(ArrayList<String> id) {
 		// TODO Auto-generated method stub
 		//����ɾ�� �������ݲ㷽�� ���� PO
 		
 		//����ɾ�� ����VO
 		end();
 		System.out.println("Delete the deliveries successfully!");
 		return null;
 	}
 	@Override
 	public DeliveryOrderVO inquireA(String id) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 	
 	@Override
 	public void generateId() {
 		// TODO Auto-generated method stub
 	}
 	@Override
 	public ResultMessage deleteone(String id) {
 		// TODO Auto-generated method stub
 		//����ɾ�� �������ݲ㷽�� ���� PO
 		
 		//����ɾ�� ����VO
 		end();
 		System.out.println("delete the delivery successfully!");
 		return null;
 	}
 	@Override
 	public DeliveryOrderlineitemVO inquireB(String time) {
 		// TODO Auto-generated method stub
 		return null;
 	}
 }
