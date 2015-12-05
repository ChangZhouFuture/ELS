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
import po.stockPO.OutBoundOrderPO;
import state.ResultMessage;
import state.TransportType;
import dataservice.stockdataservice.OutBoundOrderdataservice;


public class OutBoundOrderdata extends UnicastRemoteObject implements OutBoundOrderdataservice {


	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    OutBoundOrderPO po;
    Stockdata stock=new Stockdata();
    
	public OutBoundOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OutBoundOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into outboundorder(ID,outDate,destination,transportType,truckNum,generateTime)"
				+ "values(?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getOutDate());
			stmt.setString(3, po.getDestination());
			stmt.setString(4, po.getTransportType().toString());
			stmt.setString(5, po.getTruckNum());
			stmt.setString(6, po.getGenerateTime());
			stmt.executeUpdate();
			stock.outBound(po.getId());
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteOne(String id) {
		// TODO Auto-generated method stub
		String sql="delete from outboundorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from outboundorder where ID=?";
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
	public ResultMessage update(OutBoundOrderPO po) {
		// TODO Auto-generated method stub
		po=new OutBoundOrderPO();
		String sql="update outboundorder set outDate=?,destination=?,transportType=?,truckNum=?,generateTime=? "
				+ "where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getOutDate());
			stmt.setString(2, po.getDestination());
			stmt.setString(3, po.getTransportType().toString());
			stmt.setString(4, po.getTruckNum());
			stmt.setString(5, po.getGenerateTime());
			stmt.setString(6, po.getId());
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
		po=new OutBoundOrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from outboundorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setId(id);
				po.setOutDate(rs.getString(2));
				po.setDestination(rs.getString(3));
				po.setTransportType(TransportType.valueOf(rs.getString(4)));
				po.setTruckNum(rs.getString(5));
				po.setGenerateTime(rs.getString(6));
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

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		po=new OutBoundOrderPO();
		ArrayList<OutBoundOrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from outboundorder";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("outDate").equals(date)){
					po.setId(rs.getString(1));
					po.setOutDate(date);
					po.setDestination(rs.getString(3));
					po.setTransportType(TransportType.valueOf(rs.getString(4)));
					po.setTruckNum(rs.getString(5));
					po.setGenerateTime(rs.getString(6));
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



}
