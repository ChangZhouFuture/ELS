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
		
        //�˴�����VO���в�������¼oVO
		oVO=new OrderVO(this.sender,this.addressee,this.desti,this.startingPlace,this.eType,
				this.name,id,this.num);
		
	    //�������ݲ����Ӷ�������������PO
		
		return oVO;
    }
    
    public void delete(String id){
    	//����ɾ�����������ݲ�ɾ����������������PO
    	
    	//����ɾ��������VO
    	
    	System.out.println("ɾ���ɹ�");
    }
    
    public OrderVO modify(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num){
    	//�����޸ģ��������ݲ㷽��������PO
    	
    	System.out.println("�޸ĳɹ�");
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
    	System.out.println("������������");
    }

	@Override
	public OrderlineitemVO getOrderlineitemVO(String id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
     
   
   
}
