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
import po.documentsPO.BusiHallLoadingListPO;
import po.lineitemPO.documentslineitemPO.BusiHallLoadingListlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.BusiHallLoadingListdataservice;

public class BusiHallLoadingListdata extends UnicastRemoteObject  implements BusiHallLoadingListdataservice {

	

	public BusiHallLoadingListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	GenerateId g;
	BusiHallLoadingListPO po;
	BusiHallLoadingListlineitemPO llpo;
	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLoadingList(BusiHallLoadingListPO po) {
		// TODO Auto-generated method stub
		String sql="insert into busihallloadinglist(ID,loadingDate,busiHallID,trucksNum,destination,vehiclesId,supervisionMan,escortMan,orderIDs,carriage,generateTime)"
				+"values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1,po.getID());
			stmt.setString(2, po.getLoadingDate());
			stmt.setString(3, po.getBusiHallID());
			stmt.setString(4, po.getTruckNum());
			stmt.setString(5, po.getDestination());
			stmt.setString(6, po.getGenerateTime());
			stmt.setString(7, po.getSupervisionMan());
			stmt.setString(8, po.getEscortMan());
			stmt.setDouble(10, po.getCarriage());
			stmt.setString(11, po.getGenerateTime());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}
			str=str.substring(0,str.length()-1);
			stmt.setString(9, str);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteone(String id) {
		// TODO Auto-generated method stub
		String sql="delete from busihallloadinglist where ID=?";
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
	public ResultMessage deleteMany(ArrayList<String> idlist) {
		// TODO Auto-generated method stub
		String sql="delete from busihallloadinglist where ID=?";
		try {
			for(int i=0;i<idlist.size();i++){
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
		po=new BusiHallLoadingListPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from busihallloadinglist where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setID(id);
				po.setLoadingDate(rs.getString(2));
				po.setBusiHallID(rs.getString(3));
				po.setTruckNum(rs.getString(4));
				po.setDestination(rs.getString(5));
				po.setVehiclesID(rs.getString(6));
				po.setSupervisionMan(rs.getString(7));
				po.setEscortMan(rs.getString(8));
				po.setCarriage(rs.getDouble(10));
				po.setGenerateTime(rs.getString(11));
				String str=rs.getString(9);
				String[] s=str.split(";");
				ArrayList<String> arr=new ArrayList<>();
				for(int i=0;i<s.length;i++){
					arr.add(i, s[i]);
				}
				po.setOrderIDs(arr);
				jb1.setResultMessage(ResultMessage.Success);
				jb1.setPOObject(po);
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
		llpo=new BusiHallLoadingListlineitemPO();
        ArrayList<BusiHallLoadingListlineitemPO> llpos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from busihallloadinglist";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("generateTime").substring(0,10).equals(date)){
					jb1.setResultMessage(ResultMessage.Success);
					llpo.setLoadingDate(date);
			        llpo.setID(rs.getString(1));
					llpo.setDestination(rs.getString(5));
					llpo.setTruckNum(rs.getString(4));
					llpo.setCarriage(rs.getDouble(10));
					llpos.add(llpo);
				}
			}
			jb1.setPOObject(llpos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}

	}

	@Override
	public ResultMessage update(BusiHallLoadingListPO po) {
		// TODO Auto-generated method stub
		String sql="update busihallloadinglist set loadingDate=?,busiHallID=?,trucksNum=?,destination=?,"
				+ "vehiclesID=?,supervisionMan=?,escortMan=?,orderIDs=?,carriage=?,generateTime=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(11,po.getID());
			stmt.setString(1, po.getLoadingDate());
			stmt.setString(2, po.getBusiHallID());
			stmt.setString(3, po.getTruckNum());
			stmt.setString(4, po.getDestination());
			stmt.setString(5, po.getVehiclesID());
			stmt.setString(6, po.getSupervisionMan());
			stmt.setString(7, po.getEscortMan());
			stmt.setDouble(9,po.getCarriage());
			stmt.setString(10, po.getGenerateTime());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}
			str=str.substring(0,str.length()-1);
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
	public String generateId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateOrderId(date, "busihallloadinglist");
	}

	
}
