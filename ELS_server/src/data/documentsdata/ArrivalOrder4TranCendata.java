package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.utility.Database;
import po.documentsPO.ArrivalOrder4BusiHallPO;
import po.documentsPO.ArrivalOrder4TranCenPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.GoodState;
import state.ResultMessage;
import dataservice.documentsdataservice.ArrivalOrder4TranCendataservice;


public class ArrivalOrder4TranCendata extends UnicastRemoteObject implements ArrivalOrder4TranCendataservice{

	public ArrivalOrder4TranCendata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	ArrivalOrder4TranCenPO po;
	TransferOrderlineitemPO llpo;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now=new Date();
	@Override
	public TransferOrderlineitemPO addTransferOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addArrivalOrder4TranCen(ArrivalOrder4TranCenPO arrivalOrder4TranCenPO) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO arrivalorder4trancen(ID,ID4TranCen,arrivalDate,ID4TransferOrder,startingAddress,status,generateTime)"+
				"values(?,?,?,?,?,?,?)";
				try {
					stmt=con.prepareStatement(sql);
					stmt.setString(1, po.getId());
					stmt.setString(2, po.getTransferCenterId());
					stmt.setString(3, po.getDate());
					stmt.setString(4, po.getTransferOrderid());
					stmt.setString(5, po.getStartingAdd());
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
		String sql="DELETE FROM arrivalorder4trancen WHERE ID='"+id+"'";
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
			String sql="DELETE FROM arrivalorder4trancen WHERE ID=?";
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
	public ArrayList<ArrivalOrder4TranCenPO> findA(String id) {
		// TODO Auto-generated method stub
		ArrayList<ArrivalOrder4TranCenPO> arrayList = new ArrayList<ArrivalOrder4TranCenPO>();
		po=new ArrivalOrder4TranCenPO();
		try {
			stmt = con.prepareStatement("SELECT * FROM arrivalorder4trancen WHERE ID='"+id+"'");
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
			    po.setId(id);
		        po.setTransferCenterId(rs.getString(2));
		        po.setDate(rs.getString(3));
		        po.setTransferOrderid(rs.getString(4));
		        po.setStartingAdd(rs.getString(5));
		        po.setGoodState(GoodState.valueOf(rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		arrayList.add(po);
		return arrayList;
	}

	@Override
	public ArrayList<ArrivalOrder4TranCenPO> findB(String date) {
		// TODO Auto-generated method stub
		ArrayList<ArrivalOrder4TranCenPO> pos=new ArrayList<ArrivalOrder4TranCenPO>();
		po=new ArrivalOrder4TranCenPO();
		String substr;
		try {
			stmt=con.prepareStatement("SELECT * FROM arrivalorder4trancen");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				substr=rs.getString(7).substring(0, 10);
				if(substr==date){
					po.setId(rs.getString(1));
					po.setTransferCenterId(rs.getString(2));
					po.setDate(rs.getString(3));
					po.setTransferOrderid(rs.getString(4));
					po.setStartingAdd(rs.getString(5));
					po.setGoodState(GoodState.valueOf(rs.getString(6)));
//					po.setGenerateTime(rs.getString(7));
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
	public ArrayList<ArrivalOrder4TranCenPO> findC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(ArrivalOrder4TranCenPO po) {
		// TODO Auto-generated method stub
		try {
			String sql=("UPDATE arrivalorder4trancen SET ID4TranCen=?,arrivalDate=?,ID4TransferOrder=?,"
					+ "startingAddress=?,status=?,generateTime=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getTransferCenterId());
			stmt.setString(2, po.getDate());
			stmt.setString(3, po.getTransferOrderid());
			stmt.setString(4, po.getStartingAdd());
			stmt.setString(5, po.getGoodState().toString());
			stmt.setString(7, po.getId());
//			stmt.setString(6, po.getGenerateTime());
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
