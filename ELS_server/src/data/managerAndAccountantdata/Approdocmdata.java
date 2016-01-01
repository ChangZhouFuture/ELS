package data.managerAndAccountantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.utility.Database;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;
import state.DocumentsType;
import state.ResultMessage;


public class Approdocmdata extends UnicastRemoteObject implements Approdocmdataservice{

	public Approdocmdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	

	@Override
	public ResultMessage updateApproState(DocumentsType documentsType, ArrayList<String> IDList) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage r=ResultMessage.NotExist;
		for(int i=0;i<IDList.size();i++){
			r=singleUpdateApproState(documentsType, IDList.get(i));
		}
		return r;
	}
	
	public ResultMessage singleUpdateApproState(DocumentsType documentsType,String Id){
		ResultMessage r=ResultMessage.NotExist;
		String sql=null;
		if(documentsType==DocumentsType.Order){
			sql="select * from dingdanorder where ID=?";
		}else if(documentsType==DocumentsType.BusiHallArrivalOrder){
			sql="select * from busihallarrivalorder where ID=?";
		}else if(documentsType==DocumentsType.BusiHallLoadingList){
			sql="select * from busihallloadinglist where ID=?";
		}else if(documentsType==DocumentsType.DeliveryOrder){
			sql="select * from deliveryorder where ID=?";
		}else if(documentsType==DocumentsType.OutBoundOrder){
			sql="select * from outboundorder where ID=?";
		}else if(documentsType==DocumentsType.PaymentOrder){
			sql="select * from paymentorder where ID=?";
		}else if(documentsType==DocumentsType.ReceivablesOrder){
			sql="select * from receivablesorder where ID=?";
		}else if(documentsType==DocumentsType.StorageList){
			sql="select * from storagelist where ID=?";
		}else if(documentsType==DocumentsType.TranCenArrivalOrder){
			sql="select * from trancenarrivalorder where ID=?";
		}else if(documentsType==DocumentsType.TranCenLoadingList){
			sql="select * from trancenloadinglist where ID=?";
		}else{
			sql="select * from transferorder where ID=?";
		}
		
		String state=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, Id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				r=ResultMessage.Success;
				
				if(rs.getString("approState").equals("NotApprove")){
					state="Approve";
				}else{
					state="NotApprove";
				}
			}
			if(documentsType==DocumentsType.Order){
				sql="update dingdanorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.BusiHallArrivalOrder){
				sql="update busihallarrivalorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.BusiHallLoadingList){
				sql="update busihallloadinglist set approState=? where ID=?";
			}else if(documentsType==DocumentsType.DeliveryOrder){
				sql="update deliveryorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.OutBoundOrder){
				sql="update outboundorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.PaymentOrder){
				sql="update paymentorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.ReceivablesOrder){
				sql="update receivablesorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.StorageList){
				sql="update storagelist set approState=? where ID=?";
			}else if(documentsType==DocumentsType.TranCenArrivalOrder){
				sql="update trancenarrivalorder set approState=? where ID=?";
			}else if(documentsType==DocumentsType.TranCenLoadingList){
				sql="update trancenloadinglist set approState=? where ID=?";
			}else{
				sql="update transferorder set approState=? where ID=?";
			}
			stmt=con.prepareStatement(sql);
			
			stmt.setString(1, state);
			stmt.setString(2, Id);
			stmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r;
		}
	}
	
//	public static void main(String[] args) throws RemoteException {
//		Approdocmdata a=new Approdocmdata();
//		ArrayList<String> IDList=new ArrayList<>();
//		IDList.add("1512240002");
//		IDList.add("1512290001");
//		a.updateApproState(DocumentsType.Order, IDList);
//		
//	}
}
