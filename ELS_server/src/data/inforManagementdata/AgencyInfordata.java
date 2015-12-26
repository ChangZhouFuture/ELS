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
import po.inforManagementPO.AgencyPO;
import data.utility.Database;
import dataservice.inforManagementdataservice.AgencyInfordataservice;
import state.AgencyType;
import state.ResultMessage;

public class AgencyInfordata  extends UnicastRemoteObject implements AgencyInfordataservice{	
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    AgencyPO po;
    JavaBean1 jb1;
    
    public AgencyInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
//增加新机构信息
public ResultMessage add(AgencyPO po){
	try {
		stmt = con.prepareStatement("INSERT INTO agency(ID,agencyType,city,region) VALUES(?,?,?,?)");
		stmt.setString(1, po.getID());
	    stmt.setString(2, po.getAgencyType().toString());
	    stmt.setString(3, po.getCity());
	    stmt.setString(4, po.getRegion());
	    stmt.executeUpdate();
	    return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.Fail;
	}
}

//查找机构信息
public JavaBean1 find(String Id){
	
	po = new AgencyPO();
	jb1=new JavaBean1();
	jb1.setResultMessage(ResultMessage.NotExist);
	try {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM agency WHERE ID='"+Id+"'");
		
		 //大小写无区别，此处大写为区别表的名字，where表示条件
		ResultSet rs=ps.executeQuery(); 
		if(rs.next()){
		    po.setID(Id);
		    po.setAgencyType(AgencyType.valueOf(rs.getString("agencyType")));
	        po.setCity(rs.getString("city"));
	        po.setRegion(rs.getString("region"));
	        jb1.setObject(po);
	        jb1.setResultMessage(ResultMessage.Success);
		}
		return jb1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return jb1;
	}
}

//删除机构信息
@Override
public ResultMessage deleteMany(ArrayList<String> Ids) {
	// TODO Auto-generated method stub
	try {
		for(int i=0;i<Ids.size();i++){
		stmt=con.prepareStatement("DELETE FROM agency WHERE ID=?");
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

//修改机构信息
public ResultMessage update(AgencyPO po){
	try {
		String sql=("UPDATE agency SET agencyType=?,city=?,region=? WHERE ID=?");
		stmt=con.prepareStatement(sql);	
		stmt.setString(1, po.getAgencyType().toString());
		stmt.setString(2, po.getCity());
		stmt.setString(3, po.getRegion());
		stmt.setString(4, po.getID());
		stmt.executeUpdate();
		return ResultMessage.Success;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.NotExist;
	}
}
@Override
public String generateID(String firstPart) throws RemoteException {
	// TODO Auto-generated method stub
	String sql="select * from agency where agencyType=?";
	int subId=0;
	int temp=0;
	try {
		stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			if(rs.getString("ID").substring(0, 4).equals(firstPart)){
				subId=Integer.parseInt(rs.getString("ID").substring(4));
				if(temp<subId){
					temp=subId;
				}temp++;
			}
		}
		String last=String.valueOf(temp);
		int length=last.length();
		for(int i=0;i<3-length;i++){
			last="0"+last;
		}
		return firstPart+last;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
@Override
public JavaBean1 findB(AgencyType agencyType) throws RemoteException {
	// TODO Auto-generated method stub
	jb1=new JavaBean1();
	jb1.setResultMessage(ResultMessage.NotExist);
	ArrayList<AgencyPO> pos=new ArrayList<>();
	String sql="select * from agency where agencyType=?";
	try {
		stmt=con.prepareStatement(sql);
		stmt.setString(1, agencyType.toString());
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			po=new AgencyPO();
			po.setID(rs.getString("ID"));
			po.setAgencyType(agencyType);
			po.setCity(rs.getString("city"));
			po.setRegion(rs.getString("region"));
			jb1.setResultMessage(ResultMessage.Success);
			pos.add(po);
		}jb1.setObject(pos);
		return jb1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return jb1;
	}
}


}
