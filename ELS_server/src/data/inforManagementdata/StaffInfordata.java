package data.inforManagementdata;

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
import state.AgencyType;
import state.Gender;
import state.PayType;
import state.Position;
import state.ResultMessage;
import data.utility.Database;
import dataservice.inforManagementdataservice.StaffInfordataservice;


public class StaffInfordata extends UnicastRemoteObject implements StaffInfordataservice{
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    UserPO po;
    JavaBean1 jb1;
    
    public StaffInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
    
    public JavaBean1 find(String Id){
    	po = new UserPO();
    	jb1=new JavaBean1();
    	jb1.setResultMessage(ResultMessage.NotExist);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setId(Id);
		        po.setName(rs.getString("name"));
		        po.setPassword(rs.getString("password"));
		        po.setGender(Gender.valueOf(rs.getString("gender")));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setCity(rs.getString("city"));
		        po.setAgencyType(AgencyType.valueOf(rs.getString("agencyType")));
		        po.setRegion(rs.getString("region"));
		        po.setAgencyID(rs.getString("agencyID"));
		        po.setPosition(Position.valueOf(rs.getString("position")));
		        po.setPayType(PayType.valueOf(rs.getString("payType")));
		        po.setPayAmount(rs.getDouble("payAmount"));
		        po.setPercentage(rs.getString("percentage"));
		        jb1.setObject(po);
		        jb1.setResultMessage(ResultMessage.Success);
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
    }
    
   
    public ResultMessage update(UserPO po){
		try {
			String sql=("UPDATE user SET payType=?,payAmount=?,percentage=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
		    stmt.setString(1, po.getPayType().toString());
		    stmt.setDouble(2, po.getPayAmount());
		    stmt.setString(3, po.getPercentage());
		    stmt.setString(4, po.getId());
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
    }
}

