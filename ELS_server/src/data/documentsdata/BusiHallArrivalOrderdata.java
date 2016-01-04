package data.documentsdata;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.JavaBean1;
import data.utility.Database;
import data.utility.GenerateId;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ApproState;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.BusiHallArrivalOrderdataservice;

public class BusiHallArrivalOrderdata  extends UnicastRemoteObject
implements BusiHallArrivalOrderdataservice {
	
	public BusiHallArrivalOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    PreparedStatement stmt;
    JavaBean1 jb1;
    BusiHallArrivalOrderPO po;
    TransferOrderlineitemPO llpo;
    GenerateId g;

	@Override
	public ResultMessage addBusiHallArrivalOrder(BusiHallArrivalOrderPO po) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO busihallarrivalorder(ID,busiHallID,date,transferOrderID,origin,goodState)"+
		"values(?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getBusiHallID());
			stmt.setString(3, po.getArrivalDate());
			stmt.setString(4, po.getTransferOrderID());
			stmt.setString(5, po.getOrigin());
			stmt.setString(6, po.getGoodState().toString());
			stmt.executeUpdate();
            return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	public ResultMessage update(BusiHallArrivalOrderPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE busihallarrivalorder SET busiHallID=?,date=?,transferOrderID=?,"
					+ "origin=?,goodState=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getBusiHallID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getTransferOrderID());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getGoodState().toString());
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
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<idlist.size();i++){
			stmt=con.prepareStatement("DELETE FROM busihallarrivalorder WHERE ID=?");
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
		
		jb1=new JavaBean1();
		ArrayList<BusiHallArrivalOrderPO> pos = new ArrayList<BusiHallArrivalOrderPO>();
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt = con.prepareStatement("SELECT * FROM busihallarrivalorder WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
				po=new BusiHallArrivalOrderPO();
			    po.setId(id);
		        po.setBusiHallID(rs.getString(2));
		        po.setArrivalDate(rs.getString(3));
		        po.setTransferOrderID(rs.getString(4));
		        po.setOrigin(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
		        po.setApproState(ApproState.valueOf(rs.getString("approState")));
		        jb1.setResultMessage(ResultMessage.Success);
		        pos.add(po);
		        jb1.setObject(pos);
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
		
		jb1=new JavaBean1();
		ArrayList<BusiHallArrivalOrderPO> pos = new ArrayList<BusiHallArrivalOrderPO>();
		String sql="SELECT * FROM busihallarrivalorder";
		
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(); 
			
			while(rs.next()){
				po=new BusiHallArrivalOrderPO();
				
				    if(rs.getString("date").equals(date)&&rs.getString("approState").equals("NotApprove")){
					   po.setId(rs.getString(1));
					   po.setBusiHallID(rs.getString(2));
					   po.setArrivalDate(rs.getString(3));
					   po.setTransferOrderID(rs.getString(4));
					   po.setOrigin(rs.getString(5));
					   po.setGoodState(GoodState.valueOf(rs.getString(6)));
					   po.setGenerateTime(rs.getString(7));
					   po.setApproState(ApproState.valueOf(rs.getString("approState")));
					   jb1.setResultMessage(ResultMessage.Success);
					   pos.add(po);
		            }	
				    if(rs.getString("date").equals(date)&&rs.getString("approState").equals("Approve")){
				    	 po.setId(rs.getString(1));
						 po.setBusiHallID(rs.getString(2));
						 po.setArrivalDate(rs.getString(3));
						 po.setTransferOrderID(rs.getString(4));
						 po.setOrigin(rs.getString(5));
						 po.setGoodState(GoodState.valueOf(rs.getString(6)));
						 po.setGenerateTime(rs.getString(7));
						 po.setApproState(ApproState.valueOf(rs.getString("approState")));
						 jb1.setResultMessage(ResultMessage.Success);
						 pos.add(po);  
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
	public String generateId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateDocumentId(date, "busihallarrivalorder");
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

}
