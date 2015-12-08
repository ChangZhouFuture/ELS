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
	public ResultMessage updateApproState(String documentsType, ArrayList<String> IDList) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select * from ? where ID=?";
		String state="NotApprove";
		try {
			for(int i=0;i<IDList.size();i++){
				stmt=con.prepareStatement(sql);
				stmt.setString(1, documentsType);
				stmt.setString(2, IDList.get(i));
				ResultSet rs=stmt.executeQuery();
				if(rs.next()){
					if(rs.getString("approState").equals("NotApprove")){
						state="Approve";
					}else{
						state="NotApprove";
					}
				}
				sql="update ? set approState=? where ID=?";
				stmt.setString(1, documentsType);
				stmt.setString(2, state);
				stmt.setString(3, IDList.get(i));
				stmt.executeUpdate();
			}
			return ResultMessage.Success;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

}
