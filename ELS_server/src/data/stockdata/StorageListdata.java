package data.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import data.utility.GenerateId;
import po.stockPO.StorageListPO;
import state.ApproState;
import state.ResultMessage;
import dataservice.stockdataservice.StorageListdataservice;


public class StorageListdata extends UnicastRemoteObject implements StorageListdataservice {

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    StorageListPO po;
    GenerateId g;
    
    
	public StorageListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(StorageListPO po) {
		// TODO Auto-generated method stub
		String sql="insert into storagelist(ID,date,destination,areaNum,rowNum,frameNum,positionNum,orderID)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getInDate());
			stmt.setString(3, po.getDestination());
			stmt.setString(4, po.getAreaNum());
			stmt.setString(5, po.getRowNum());
			stmt.setString(6, po.getFrameNum());
			stmt.setString(7, po.getPositionNum());
			stmt.setString(8, po.getOrderID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from storagelist where ID=?";
		try {
			for(int i=0;i<idList.size();i++){
				stmt=con.prepareStatement(sql);
			    stmt.setString(1, idList.get(i));
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
	public ResultMessage update(StorageListPO po) {
		// TODO Auto-generated method stub
		po=new StorageListPO();
		String sql="update storagelist set date=?,destination=?,areaNum=?,rowNum=?,frameNum=?,positionNum=?,orderID=? "
				+ "where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getInDate());
			stmt.setString(2, po.getDestination());
			stmt.setString(3, po.getAreaNum());
			stmt.setString(4, po.getRowNum());
			stmt.setString(5, po.getFrameNum());
			stmt.setString(6, po.getPositionNum());
			stmt.setString(7, po.getOrderID());
			stmt.setString(8, po.getId());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		po=new StorageListPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from storagelist where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setId(id);
				po.setInDate(rs.getString(2));
				po.setDestination(rs.getString(3));
				po.setAreaNum(rs.getString(4));
				po.setRowNum(rs.getString(5));
				po.setFrameNum(rs.getString(6));
				po.setPositionNum(rs.getString(7));
				po.setOrderID(rs.getString("orderID"));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				jb1.setObject(po);
				jb1.setResultMessage(ResultMessage.Success);
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}

	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		
		ArrayList<StorageListPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from storagelist";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new StorageListPO();
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("NotApprove")){
					po.setId(rs.getString(1));
					po.setInDate(date);
					po.setDestination(rs.getString(3));
					po.setAreaNum(rs.getString(4));
					po.setRowNum(rs.getString(5));
					po.setFrameNum(rs.getString(6));
					po.setPositionNum(rs.getString(7));
					po.setOrderID(rs.getString("orderID"));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("Approve")){
					po.setId(rs.getString(1));
					po.setInDate(date);
					po.setDestination(rs.getString(3));
					po.setAreaNum(rs.getString(4));
					po.setRowNum(rs.getString(5));
					po.setFrameNum(rs.getString(6));
					po.setPositionNum(rs.getString(7));
					po.setOrderID(rs.getString("orderID"));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
			}jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
		
	}
	
	 @Override
	    public String generateId(String date) throws RemoteException {
	    	// TODO Auto-generated method stub
	    	g=new GenerateId();
	    	return g.generateDocumentId(date, "storagelist");
	    }

	@Override
	public JavaBean1 getOrderIDsAndAreaList(String date) throws RemoteException {
		// TODO Auto-generated method stub
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		int count=0;
		String orderIDsAndAreaList[][]=new String[4][];
		String sql="select ID,areaNum from storagelist where date=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				jb1.setResultMessage(ResultMessage.Success);
				count++;
				orderIDsAndAreaList[0][count]=rs.getString("areaNum");
				orderIDsAndAreaList[1][count]=rs.getString("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jb1.setObject(orderIDsAndAreaList);
		return jb1;
	}
}
