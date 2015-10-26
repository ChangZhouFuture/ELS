package businesslogicservice_client_Stub.documentsblservice_Stub;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;
import vo_client.userVO.CourierVO;
import businesslogicservice_client.documentsblservice.DeliveryOrderblservice;

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
//		此处传入VO所有参数，记录oboVO（PO和VO的单号是一样的）；
		dovo = new DeliveryOrderVO(this.id,this.orsderidlist,this.couriername,this.deliverierid,this.date);
//		此处调用数据层的增加派件单方法，更新PO
		end();
		return dovo;
	}
	public String generateDeliverier(String id){
		//此处根据id返回快递员姓名
		return couriername;
	}
	
	public ResultMessage addDeliverier(String id){
		if(id=="cr00000001")
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}
	public ArrayList<String> addOrder(String orderid){
		System.out.println("Add Express successfully!");
		return null;
	}
	public String generateDate(){
		String date="2015/10/23";
		return date;
	}
	
	public void end(){
		//此处调用数据层的Update方法
		
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
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
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
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		//处理删除 调用数据层方法 更新 PO
		
		//处理删除 更新VO
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
