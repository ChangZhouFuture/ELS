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
//		此处传入VO除id外的所有参数，并由VO类里面generateID方法生成单号，记录oboVO（PO和VO的单号是一样的）；
		dovo = new DeliveryOrderVO(this.id,this.orsderidlist,this.couriername,this.deliverierid,this.date);
//		此处调用数据层的增加派件单方法，更新PO
		return dovo;
	}
	public String getDeliverier(String id){
		return null;
	}
	
	public ResultMessage addDeliverier(String id){
		if(id=="pj00000001")
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}
	public ArrayList<String> addOrder(String orderid){
		return null;
	}
	public String getDate(){
		String date="2015/10/23";
		return date;
	}
	
	public void end(){
		System.out.println("End the delivery!");
	}
	
	@Override
	public DeliveryOrderVO modify(String id,ArrayList<String> orsderidlist,String dn,String did,String d) {
		// TODO Auto-generated method stub
		System.out.println("Modify the delivery successfully!");
		return null;
	}
	@Override
	public void deleteMany(ArrayList<String> id) {
		// TODO Auto-generated method stub
		System.out.println("delete the deliveries successfully!");
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
	public void deleteone(String id) {
		// TODO Auto-generated method stub
		System.out.println("delete the delivery successfully!");
	}
	@Override
	public DeliveryOrderlineitemVO inquireB(String time) {
		// TODO Auto-generated method stub
		return null;
	}
}
