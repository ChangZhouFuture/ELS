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

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	
	public Approdocmdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


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
		String orderName=documentsType.toString().toLowerCase();
		ResultMessage r=ResultMessage.NotExist;
		if(documentsType.equals(DocumentsType.Order)){
			orderName="dingdanorder";
		}
		String sql="select * from ?";
		String state="NotApprove";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderName);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(Id)){
					r=ResultMessage.Success;
					if(rs.getString("approState")=="NotApprove"){
						state="Approve";
					}else{
						state="NotApprove";
					}
				}
			}
			sql="update ? set approState=? where ID=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderName);
			stmt.setString(2, state);
			stmt.setString(3, Id);
			stmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r;
		}
	}
	
}
