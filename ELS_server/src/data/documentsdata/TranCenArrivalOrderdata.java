package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import data.utility.GenerateId;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.AgencyType;
import state.ApproState;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.TranCenArrivalOrderdataservice;


public class TranCenArrivalOrderdata extends UnicastRemoteObject  implements TranCenArrivalOrderdataservice{
	

	public TranCenArrivalOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	TranCenArrivalOrderPO po;
	TransferOrderlineitemPO llpo;
	GenerateId g;
	

	@Override
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tranCenArrivalOrderPO) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO trancenarrivalorder(ID,tranCenID,date,transferOrderID,origin,goodState,agencyType)"+
				"values(?,?,?,?,?,?,?)";
				try {
					stmt=con.prepareStatement(sql);
					stmt.setString(1, po.getID());
					stmt.setString(2, po.getTranCenID());
					stmt.setString(3, po.getArrivalDate());
					stmt.setString(4, po.getTransferOrderID());
					stmt.setString(5, po.getOrigin());
					stmt.setString(6, po.getGoodState().toString());
					stmt.setString(7, po.getAgencyType().toString());
					stmt.executeUpdate();
		            return ResultMessage.Success;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ResultMessage.Fail;
				}
	}


	@Override
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		
		try {
			for(int i=0;i<idlist.size();i++){
			String sql="DELETE FROM trancenarrivalorder WHERE ID=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, idlist.get(i));
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
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		ArrayList<TranCenArrivalOrderPO> pos = new ArrayList<>();
		
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt = con.prepareStatement("SELECT * FROM trancenarrivalorder WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
				po=new TranCenArrivalOrderPO();
				jb1.setResultMessage(ResultMessage.Success);
			    po.setID(id);
		        po.setTranCenID(rs.getString(2));
		        po.setArrivalDate(rs.getString(3));
		        po.setTransferOrderID(rs.getString(4));
		        po.setOrigin(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
		        po.setApproState(ApproState.valueOf(rs.getString("approState")));
		        po.setAgencyType(AgencyType.valueOf(rs.getString("agencyType")));
		        pos.add(po);
			}
			jb1.setObject(pos);
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
		ArrayList<TranCenArrivalOrderPO> pos=new ArrayList<TranCenArrivalOrderPO>();	
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement("SELECT * FROM trancenarrivalorder");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				po=new TranCenArrivalOrderPO();
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("NotApprove")){
					po.setID(rs.getString(1));
			        po.setTranCenID(rs.getString(2));
			        po.setArrivalDate(rs.getString(3));
			        po.setTransferOrderID(rs.getString(4));
			        po.setOrigin(rs.getString(5));
			        po.setGoodState(GoodState.valueOf(rs.getString(6)));
			        po.setApproState(ApproState.valueOf(rs.getString("approState")));
			        po.setAgencyType(AgencyType.valueOf(rs.getString("agencyType")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("date").equals(date)&&rs.getString("approState").equals("Approve")){
					po.setID(rs.getString(1));
			        po.setTranCenID(rs.getString(2));
			        po.setArrivalDate(rs.getString(3));
			        po.setTransferOrderID(rs.getString(4));
			        po.setOrigin(rs.getString(5));
			        po.setGoodState(GoodState.valueOf(rs.getString(6)));
			        po.setApproState(ApproState.valueOf(rs.getString("approState")));
			        po.setAgencyType(AgencyType.valueOf(rs.getString("agencyType")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
			}
			jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
		
	}

	@Override
	public ResultMessage update(TranCenArrivalOrderPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE trancenarrivalorder SET tranCenID=?,date=?,transferOrderID=?,"
					+ "origin=?,goodState=?,agencyType=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getTranCenID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getTransferOrderID());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(6, po.getAgencyType().toString());
			stmt.setString(7, po.getID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}


	@Override
	public String generateStartAdd(String transferOrderId) {
		// TODO Auto-generated method stub
		String sql="select * from transferorder where ID=?";
		String destination = null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, transferOrderId);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				destination=rs.getString("destination");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
	}
	
	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateDocumentId(date, "trancenarrivalorder");
	}

}
