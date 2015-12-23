package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import data.utility.GenerateId;
import dataservice.documentsdataservice.TranCenLoadingListdataservice;
import po.documentsPO.BusiHallLoadingListPO;
import po.documentsPO.TranCenLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.documentslineitemPO.TranCenLoadingListlineitemPO;
import state.ApproState;
import state.ResultMessage;

public class TranCenLoadingListdata extends UnicastRemoteObject implements TranCenLoadingListdataservice {

	public TranCenLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	GenerateId g;
	TranCenLoadingListPO po;
	TranCenLoadingListlineitemPO llpo;
	@Override
	public ResultMessage addLoadingList(TranCenLoadingListPO po) {
		// TODO Auto-generated method stub
		String sql="insert into trancenloadinglist(ID,date,tranCenID,trucksNum,destination,vehiclesID,supervisionMan,escortMan,orderIDs,carriage)"
				+"values(?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setString(2, po.getLoadingDate());
			stmt.setString(3, po.getTranCenID());
			stmt.setString(4, po.getTrucksNum());
			stmt.setString(5, po.getDestination());
			stmt.setString(6, po.getVehiclesID());
			stmt.setString(7, po.getSupervisionMan());
			stmt.setString(8, po.getEscortMan());
			stmt.setDouble(10, po.getCarriage());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}str=str.substring(0, str.length()-1);
			stmt.setString(9, str);
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
		String sql="delete from trancenloadinglist where ID=?";
		try {
			for(int i=0;i<Ids.size();i++){
				stmt=con.prepareStatement(sql);
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
	public ResultMessage update(TranCenLoadingListPO po) {
		// TODO Auto-generated method stub
		String sql="update trancenloadinglist set date=?,tranCenID=?,trucksNum=?,destination=?,vehiclesID=?,"
				+"supervisionMan=?,escortMan=?,orderIDs=?,carriage=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getLoadingDate());
			stmt.setString(2, po.getTranCenID());
			stmt.setString(3, po.getTrucksNum());
			stmt.setString(4, po.getDestination());
			stmt.setString(5, po.getVehiclesID());
			stmt.setString(6, po.getSupervisionMan());
			stmt.setString(7, po.getEscortMan());
			stmt.setDouble(9, po.getCarriage());
			stmt.setString(10, po.getID());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}str=str.substring(0, str.length()-1);
			stmt.setString(8, str);
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
		po=new TranCenLoadingListPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from trancenloadinglist where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setID(id);
				po.setLoadingDate(rs.getString(2));
				po.setTranCenID(rs.getString(3));
				po.setTrucksNum(rs.getString(4));
				po.setDestination(rs.getString(5));
				po.setVehiclesID(rs.getString(6));
				po.setSupervisionMan(rs.getString(7));
				po.setEscortMan(rs.getString(8));
				po.setCarriage(rs.getDouble(10));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				String str=rs.getString(9);
				String[] s=str.split(";");
				ArrayList<String> arr=new ArrayList<>();
				for(int i=0;i<s.length;i++){
					arr.add(i, s[i]);
				}
				po.setOrderIDs(arr);
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

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		llpo=new TranCenLoadingListlineitemPO();
        ArrayList<TranCenLoadingListlineitemPO> llpos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from trancenloadinglist";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("NotApprove")){
					jb1.setResultMessage(ResultMessage.Success);
					llpo.setID(rs.getString(1));
					llpo.setLoadingDate(date);
					llpo.setDestination(rs.getString(5));
					llpo.setTruckNum(rs.getString(4));
					llpo.setCarriage(rs.getDouble(10));
					llpos.add(llpo);
				}
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("Approve")){
					jb1.setResultMessage(ResultMessage.Success);
					llpo.setID(rs.getString(1));
					llpo.setLoadingDate(date);
					llpo.setDestination(rs.getString(5));
					llpo.setTruckNum(rs.getString(4));
					llpo.setCarriage(rs.getDouble(10));
					llpos.add(llpo);
				}
			}
			jb1.setObject(llpos);
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
		return g.generateDocumentId(date, "trancenloadinglist");
	}

	@Override
	public String generateTruckNum(String firstPart) throws RemoteException {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateTrucksNum(firstPart, "trancenloadinglist");
	}

}
