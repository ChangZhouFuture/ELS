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
import po.inforManagementPO.VehiclesPO;
import state.ResultMessage;
import data.utility.Database;
import dataservice.inforManagementdataservice.VehiclesInfordataservice;

public class VehiclesInfordata extends UnicastRemoteObject implements VehiclesInfordataservice {
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    VehiclesPO po;
    JavaBean1 jb1;
    
    public VehiclesInfordata() throws RemoteException {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
    public ResultMessage add(VehiclesPO po){
		try {
			stmt = con.prepareStatement("INSERT INTO vehicles(ID,plateNum,serviceTime,busiHallID) VALUES(?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getPlateNum());
		    stmt.setString(3, po.getServiceTime());
		    stmt.setString(4, po.getBusiHallID());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
    }
    
    public JavaBean1 findA(String Id){
    	po = new VehiclesPO();
    	jb1=new JavaBean1();
    	jb1.setResultMessage(ResultMessage.NotExist);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicles WHERE ID='"+Id+"'");
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setPlateNum(rs.getString("plateNum"));
		        po.setServiceTime(rs.getString("serviceTime"));
                po.setBusiHallID(rs.getString("busiHallID"));
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
    
    public ResultMessage update(VehiclesPO po){

		try {
			String sql=("UPDATE drivers SET plateNum=?,serviceTime=?,busiHallID=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(4, po.getID());
			stmt.setString(1, po.getPlateNum());
			stmt.setString(2, po.getServiceTime());
            stmt.setString(3, po.getBusiHallID());              
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
			stmt=con.prepareStatement("DELETE FROM vehicles WHERE ID=?");
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
	public JavaBean1 findB(String busiHallId) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select * from vehicles where busiHallID=?";
		ArrayList<VehiclesPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, busiHallId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new VehiclesPO();
				po.setID(rs.getString("ID"));
		        po.setPlateNum(rs.getString("plateNum"));
		        po.setServiceTime(rs.getString("serviceTime"));
                po.setBusiHallID(rs.getString("busiHallID"));
                pos.add(po);
                jb1.setResultMessage(ResultMessage.Success);
			}jb1.setObject(pos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jb1;
	}

	@Override
	public String generateID(String firstPart) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select * from vehicles";
		int subId=0;
		int temp=0;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("ID").substring(0, 6).equals(firstPart)){
					subId=Integer.parseInt(rs.getString("ID").substring(6));
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
    
}
