package data.userManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import po.userPO.UserPO;
import data.utility.Database;
import dataservice.userManagementdataservice.UserManagementdataservice;
import state.AgencyType;
import state.Gender;
import state.Position;
import state.ResultMessage;

public class UserManagementdata extends UnicastRemoteObject implements UserManagementdataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    UserPO po;
    JavaBean1 jb1;
    
    public UserManagementdata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
	@Override
	public ResultMessage add(UserPO po) {
		// TODO Auto-generated method stub
		try {
			stmt = con.prepareStatement("INSERT INTO user(ID,password,name,gender,birthDate,identyNum,phone,city,agencyType,region,agencyID,position) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getPassword());
		    stmt.setString(3, po.getName());
		    stmt.setString(4, po.getGender().toString());
		    stmt.setString(5, po.getBirthDate());
		    stmt.setString(6, po.getIdentyNum());
		    stmt.setString(7, po.getPhone());
		    stmt.setString(8, po.getCity());
//		    stmt.setString(9, po.getAgencyType().toString());
		    stmt.setString(10, po.getRegion());
		    stmt.setString(11, po.getAgencyID());
		    stmt.setString(12, po.getPosition().toString());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteOne(String Id) {
		// TODO Auto-generated method stub
		try {
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<Ids.size();i++){
			stmt=con.prepareStatement("DELETE FROM user WHERE ID=?");
			stmt.setString(1, Ids.get(i));
			stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage update(UserPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE agency SET password=?,name=?,gender=?,birthDate=?,identyNum=?,phone=?,city=?,"
					+ "agencyType=?,region=?,agencyID=?,position=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getPassword());
		    stmt.setString(2, po.getName());
		    stmt.setString(3, po.getGender().toString());
		    stmt.setString(4, po.getBirthDate());
		    stmt.setString(5, po.getIdentyNum());
		    stmt.setString(6, po.getPhone());
		    stmt.setString(7, po.getCity());
//		    stmt.setString(8, po.getAgencyType().toString());
		    stmt.setString(9, po.getRegion());
		    stmt.setString(10, po.getAgencyID());
		    stmt.setString(11, po.getPosition().toString());
		    stmt.setString(12, po.getId());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public JavaBean1 findA(String Id) {
		// TODO Auto-generated method stub
		po = new UserPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setId(Id);
		        po.setPassword(rs.getString(2));
		        po.setName(rs.getString(3));
		        po.setGender(Gender.valueOf(rs.getString(4)));
		        po.setBirthDate(rs.getString(5));
		        po.setIdentyNum(rs.getString(6));
		        po.setPhone(rs.getString(7));
		        po.setCity(rs.getString(8));
//		        po.setAgencyType(AgencyType.valueOf(rs.getString(9)));
		        po.setRegion(rs.getString(10));
		        po.setAgencyID(rs.getString(11));
		        po.setPosition(Position.valueOf(rs.getString(12)));
		        jb1.setResultMessage(ResultMessage.Success);
		        jb1.setObject(po);
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			return jb1;
		}
	}



	@Override
	public JavaBean1 findB(String position) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
