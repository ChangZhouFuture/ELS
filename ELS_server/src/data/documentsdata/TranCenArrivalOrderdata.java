package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.utility.Database;
import po.documentsPO.BusiHallArrivalOrderPO;
import po.documentsPO.TranCenArrivalOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
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
	TranCenArrivalOrderPO po;
	TransferOrderlineitemPO llpo;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now=new Date();
	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addTranCenArrivalOrder(TranCenArrivalOrderPO tranCenArrivalOrderPO) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO trancenarrivalorder(ID,tranCenID,arrivalDate,transferOrderID,origin,goodState,generateTime)"+
				"values(?,?,?,?,?,?,?)";
				try {
					stmt=con.prepareStatement(sql);
					stmt.setString(1, po.getID());
					stmt.setString(2, po.getTranCenID());
					stmt.setString(3, po.getArrivalDate());
					stmt.setString(4, po.getTransferOrderID());
					stmt.setString(5, po.getOrigin());
					stmt.setString(6, po.getGoodState().toString());
					stmt.setString(7, sdf.format(now));
					stmt.executeUpdate();
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
		String sql="DELETE FROM trancenarrivalorder WHERE ID='"+id+"'";
		try {
			stmt=con.prepareStatement(sql);
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
	public ArrayList<TranCenArrivalOrderPO> findA(String id) {
		// TODO Auto-generated method stub
		ArrayList<TranCenArrivalOrderPO> arrayList = new ArrayList<>();
		po=new TranCenArrivalOrderPO();
		try {
			stmt = con.prepareStatement("SELECT * FROM trancenarrivalorder WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
			    po.setID(id);
		        po.setTranCenID(rs.getString(2));
		        po.setArrivalDate(rs.getString(3));
		        po.setTransferOrderID(rs.getString(4));
		        po.setOrigin(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
		        po.setGenerateTime(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		arrayList.add(po);
		return arrayList;
	}

	@Override
	public ArrayList<TranCenArrivalOrderPO> findB(String date) {
		// TODO Auto-generated method stub
		ArrayList<TranCenArrivalOrderPO> pos=new ArrayList<TranCenArrivalOrderPO>();
		po=new TranCenArrivalOrderPO();
		String substr;
		try {
			stmt=con.prepareStatement("SELECT * FROM trancenarrivalorder");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				substr=rs.getString(7).substring(0, 10);
				if(substr==date){
					po.setID(rs.getString(1));
			        po.setTranCenID(rs.getString(2));
			        po.setArrivalDate(rs.getString(3));
			        po.setTransferOrderID(rs.getString(4));
			        po.setOrigin(rs.getString(5));
			        po.setGoodState(GoodState.valueOf(rs.getString(6)));
			        po.setGenerateTime(rs.getString(7));
					pos.add(po);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pos;
	}

	@Override
	public ArrayList<TranCenArrivalOrderPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(TranCenArrivalOrderPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE trancenarrivalorder SET tranCenID=?,arrivalDate=?,transferOrderID=?,"
					+ "origin=?,goodState=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getTranCenID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getTransferOrderID());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(6, po.getGenerateTime());
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
	public String generateStartAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
