package businesslogicservice_client_Stub.orderblservice_Stub;

import businesslogicservice_client.orderblservice.Orderblservice;
import state.ExpressType;
import vo_client.lineitemVO.orderlineitemVO.OrderlineitemVO;
import vo_client.orderVO.OrderVO;

public class Orderblservice_Stub implements Orderblservice{
    OrderVO oVO;
    String sender;
    String addressee;
    String desti;
    String startingPlace;
    ExpressType eType;
    String name;
    String id;
    int num;
    
    public OrderVO add(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num){
    	this.sender = sender;
		this.addressee = addressee;
		this.desti = desti;
		this.startingPlace = startingPlace;
		this.eType = eType;
		this.name = name;
		this.num = num;
		
        //此处传入VO所有参数，记录oVO
		oVO=new OrderVO(this.sender,this.addressee,this.desti,this.startingPlace,this.eType,
				this.name,id,this.num);
		
	    //调用数据层增加订单方法，更新PO
		
		return oVO;
    }
    
    public void delete(String id){
    	//处理删除，调用数据层删除订单方法，更新PO
    	
    	//处理删除，更新VO
    	
    	System.out.println("删除成功");
    }
    
    public OrderVO modify(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num){
    	//处理修改，调用数据层方法，更新PO
    	
    	System.out.println("修改成功");
    	return null;
    }
    
    public OrderVO inquireA(String id){
    	return oVO;
    }
    
    public OrderVO inquireB(String date){
    	return null;
    }
	
    public void generateId(){
    	
    }
    
    public double getTotalPrice(String startingPlace,String desti,ExpressType eType,int num){
    	return 100.00;
    }
    public void endOrder(){
    	System.out.println("结束订单处理");
    }

	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
     
   
   
}
