package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.JavaBean2;
import data.utility.Database;
import dataservice.userdataservice.Logindataservice;
import state.Position;
import state.ResultMessage;


public class Logindata extends UnicastRemoteObject implements Logindataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    public static String agencyId;
    public static String personId;
    
	public Logindata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public JavaBean2 login(String id, String passWord) throws RemoteException{
		// TODO Auto-generated method stub
		JavaBean2 bean=new JavaBean2();
		personId=id;
		try {
			stmt=con.prepareStatement("select * from user");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(id)){
					if(rs.getString(2).equals(passWord)){
						bean.setName(rs.getString("name"));
						bean.setPosition(Position.valueOf(rs.getString("position")));
						bean.setResultMessage(ResultMessage.Success);
						bean.setAgencyID(rs.getString("agencyID"));
						agencyId=rs.getString("agencyID");
						return bean;
					}else{
						bean.setResultMessage(ResultMessage.wrongPassWord);
						return bean;
					}
				}
			}
			bean.setResultMessage(ResultMessage.NotExist);
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setResultMessage(ResultMessage.NotExist);
			return bean;
		}
		
	}

}
