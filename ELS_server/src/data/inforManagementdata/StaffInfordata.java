package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po.inforManagementPO.StaffPO;
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
    StaffPO po;
    
    public StaffInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
    public ResultMessage add(StaffPO po){
		try {
			stmt = con.prepareStatement("INSERT INTO staff(ID,name,gender,birthDate,identyNum,phone,agency,position,payType,payAmount,percentage) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getName());
		    stmt.setString(3, po.getGender().toString());
		    stmt.setString(4, po.getBirthDate());
		    stmt.setString(5, po.getIdentyNum());
		    stmt.setString(6, po.getPhone());
		    stmt.setString(7, po.getAgency());
		    stmt.setString(8, po.getPosition().toString());
		    stmt.setString(9, po.getPayType().toString());
		    stmt.setDouble(10, po.getPayAmount());
		    stmt.setString(11, po.getPercentage());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
    }
    
    public StaffPO find(String Id){
    	po = new StaffPO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM staff WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setName(rs.getString("name"));
		        po.setGender(Gender.valueOf(rs.getString("gender")));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setAgency(rs.getString("agency"));
		        po.setPosition(Position.valueOf(rs.getString("position")));
		        po.setPayType(PayType.valueOf(rs.getString("payType")));
		        po.setPayAmount(rs.getDouble("payAmount"));
		        po.setPercentage(rs.getString("percentage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
    }
    
    public ResultMessage deleteOne(String Id){
		try {
			stmt=con.prepareStatement("DELETE FROM staff WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
    }
    
    public ResultMessage deleteMany(ArrayList<String> Ids){
    	try {
    		for(int i=0;i<Ids.size();i++){
			stmt=con.prepareStatement("DELETE FROM staff WHERE ID=?");
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
    
    public ResultMessage update(StaffPO po){
		try {
			String sql=("UPDATE drivers SET name=?,gender=?,birthDate=?,identyNum=?,phone=?,agency=?,position=?,payType=?,payAmount=?,percentage=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getName());
		    stmt.setString(2, po.getGender().toString());
		    stmt.setString(3, po.getBirthDate());
		    stmt.setString(4, po.getIdentyNum());
		    stmt.setString(5, po.getPhone());
		    stmt.setString(6, po.getAgency());
		    stmt.setString(7, po.getPosition().toString());
		    stmt.setString(8, po.getPayType().toString());
		    stmt.setDouble(9, po.getPayAmount());
		    stmt.setString(10, po.getPercentage());
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
    }
}

