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
import po.stockPO.OutBoundOrderPO;
import state.ApproState;
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
    GenerateId g;
    
	public OutBoundOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OutBoundOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into outboundorder(ID,date,destination,transportType,truckNum)"
				+ "values(?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getOutDate());
			stmt.setString(3, po.getDestination());
			stmt.setString(4, po.getTransportType().toString());
			stmt.setString(5, po.getTruckNum());
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
		String sql="update outboundorder set date=?,destination=?,transportType=?,truckNum=?,area=?"
				+ "where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getOutDate());
			stmt.setString(2, po.getDestination());
			stmt.setString(3, po.getTransportType().toString());
			stmt.setString(4, po.getTruckNum());
			stmt.setString(5, po.getId());
			stmt.setString(6, po.getArea());
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
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				po.setArea(rs.getString("area"));
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
		ArrayList<OutBoundOrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from outboundorder";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new OutBoundOrderPO();
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("NotApprove")){
					po.setId(rs.getString(1));
					po.setOutDate(date);
					po.setDestination(rs.getString(3));
					po.setTransportType(TransportType.valueOf(rs.getString(4)));
					po.setTruckNum(rs.getString(5));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setArea(rs.getString("area"));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("Approve")){
					po.setId(rs.getString(1));
					po.setOutDate(date);
					po.setDestination(rs.getString(3));
					po.setTransportType(TransportType.valueOf(rs.getString(4)));
					po.setTruckNum(rs.getString(5));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					po.setArea(rs.getString("area"));
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
		return g.generateDocumentId(date, "outboundorder");
	}

	@Override
	public String getArea(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select area from outboundorder where ID=?";
		String area=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				area=rs.getString("area");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return area;
	}

	@Override
	public JavaBean1 getOrderIDsAndAreaList(String date) throws RemoteException {
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		String orderIDsAndAreaList[][]=new String[4][];
		orderIDsAndAreaList[0][0]="机动区";
		orderIDsAndAreaList[1][0]="汽运区";
		orderIDsAndAreaList[2][0]="铁运区";
		orderIDsAndAreaList[3][0]="航运区";
		String sql="select ID,area from outboundorder where date=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				jb1.setResultMessage(ResultMessage.Success);
				if(rs.getString("area")=="机动区"){
					count1++;
					orderIDsAndAreaList[0][count1]=rs.getString("ID");
				}else if(rs.getString("area")=="汽运区"){
					count2++;
					orderIDsAndAreaList[1][count2]=rs.getString("ID");
				}else if(rs.getString("area")=="航运区"){
					count3++;
					orderIDsAndAreaList[2][count3]=rs.getString("ID");
				}else{
					count4++;
					orderIDsAndAreaList[3][count4]=rs.getString("ID");
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jb1.setObject(orderIDsAndAreaList);
		return jb1;
	}



}
