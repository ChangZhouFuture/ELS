package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.DriversPO;
import state.Gender;
import state.ResultMessage;
import data.utility.Database;
import dataservice.inforManagementdataservice.DriversInfordataservice;

public class DriversInfordata extends UnicastRemoteObject implements DriversInfordataservice {
		Database db=new Database();
	    Connection con=db.getConnection();
	    Statement sm;
	    PreparedStatement stmt;
	    DriversPO po;
	    JavaBean1 jb1;
	    
	    public DriversInfordata() throws RemoteException {
	    	super();
	    	// TODO Auto-generated constructor stub
	    }
    //增加新司机信息
	public ResultMessage add(DriversPO po){
		try {
			// “?” 即占位符
			stmt = con.prepareStatement("INSERT INTO driver(ID,name,birthDate,identyNum,phone,gender,DriveLimitDate) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getName());
		    stmt.setString(3, po.getBirthDate());
		    stmt.setString(4, po.getIdentyNum());
		    stmt.setString(5, po.getPhone());
		    stmt.setString(6, po.getGender().toString());
		    stmt.setString(7, po.getDriveLimitDate());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}
	
	//查找司机信息
	public JavaBean1 find(String Id){
		po = new DriversPO();
		jb1=new JavaBean1();
			jb1.setResultMessage(ResultMessage.NotExist);	
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM driver WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setName(rs.getString("name"));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setGender(Gender.valueOf(rs.getString("gender")));
		        po.setDriveLimitDate(rs.getString("driveLimitDate"));
		        jb1.setResultMessage(ResultMessage.Success);
		        jb1.setObject(po);
			}
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}

	}
	
	//删除司机信息
	public ResultMessage deleteOne(String Id){
		try {
			stmt=con.prepareStatement("DELETE FROM driver WHERE ID=?");
			stmt.setString(1, Id);
			stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}
	
	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<Ids.size();i++){
				stmt=con.prepareStatement("DELETE FROM driver WHERE ID=?");
			    stmt.setString(1, Ids.get(i));
			    stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	} 
	
	//修改司机信息
	public ResultMessage update(DriversPO po){
		con=db.getConnection();
		try {
			String sql=("UPDATE drivers SET name=?,birthDate=?,identyNum=?,phone=?,gender=?,driveLimitDate=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getName());
			stmt.setString(2, po.getBirthDate());
			stmt.setString(3, po.getIdentyNum());
			stmt.setString(4, po.getPhone());
			stmt.setString(5, po.getGender().toString());
			stmt.setString(6, po.getDriveLimitDate());
			stmt.setString(7, po.getID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}
}
