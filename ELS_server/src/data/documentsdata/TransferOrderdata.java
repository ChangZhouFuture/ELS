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
import po.documentsPO.TransferOrderPO;
import po.lineitemPO.documentslineitemPO.TransferOrderlineitemPO;
import state.ApproState;
import state.ResultMessage;
import state.TransportType;
import dataservice.documentsdataservice.TransferOrderdataservice;


public class TransferOrderdata extends UnicastRemoteObject implements TransferOrderdataservice {

	public TransferOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	JavaBean1 jb1;
	GenerateId g;
	TransferOrderPO po;
	TransferOrderlineitemPO llpo;

	@Override
	public ResultMessage addTransferOrder(TransferOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into transferorder(ID,date,transportType,vehicleNum,origin,destination,containerNum,supervisionMan,orderIDs,carriage)"
				+"values(?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setString(2, po.getLoadingDate());
			stmt.setString(3, po.getTransportType().toString());
			stmt.setString(4, po.getVehicleNum());
			stmt.setString(5, po.getOrigin());
			stmt.setString(6, po.getDestination());
			stmt.setString(7, po.getContainerNum());
			stmt.setString(8, po.getSupervisionMan());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}str=str.substring(0, str.length()-1);
			stmt.setString(9, str);
			stmt.setDouble(10, po.getCarriage());
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
		String sql="delete from transferorder where ID=?";
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
		po=new TransferOrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String sql="select * from transferorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setID(id);
				po.setLoadingDate(rs.getString(2));
				po.setTransportType(TransportType.valueOf(rs.getString(3)));
				po.setVehicleNum(rs.getString(4));
				po.setOrigin(rs.getString(5));
				po.setDestination(rs.getString(6));
				po.setContainerNum(rs.getString(7));
				po.setSupervisionMan(rs.getString(8));
				String str=rs.getString(9);
				String[] s=str.split(";");
				ArrayList<String> arr=new ArrayList<>();
				for(int i=0;i<s.length;i++){
					arr.add(i, s[i]);
				}po.setOrderIDs(arr);
				po.setCarriage(rs.getDouble(10));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
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
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		llpo=new TransferOrderlineitemPO();
		ArrayList<TransferOrderlineitemPO> llpos=new ArrayList<>();
		String sql="select * from transferorder";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("NotApprove")){
					jb1.setResultMessage(ResultMessage.Success);
					llpo.setID(rs.getString(1));
					llpo.setLoadingDate(rs.getString(2));
					llpo.setTranType(TransportType.valueOf(rs.getString(3)));
					llpo.setVehicleNum(rs.getString(4));
					llpo.setDestination(rs.getString(6));
					llpo.setCarriage(rs.getDouble(10));
					llpos.add(llpo);
				}
				if(rs.getString("date").equals(date)
						&&rs.getString("approState").equals("Approve")){
					jb1.setResultMessage(ResultMessage.Success);
					llpo.setID(rs.getString(1));
					llpo.setLoadingDate(rs.getString(2));
					llpo.setTranType(TransportType.valueOf(rs.getString(3)));
					llpo.setVehicleNum(rs.getString(4));
					llpo.setDestination(rs.getString(6));
					llpo.setCarriage(rs.getDouble(10));
					llpos.add(llpo);
				}
			}jb1.setObject(llpos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

	@Override
	public ResultMessage update(TransferOrderPO po) {
		// TODO Auto-generated method stub
		String sql="update transferorder set date=?,transportType=?,vehicleNum=?,origin=?,destination=?,containerNum=?,"
				+ "supervisionMan=?,orderIDs=?,carriage=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getLoadingDate());
			stmt.setString(2, po.getTransportType().toString());
			stmt.setString(3, po.getVehicleNum());
			stmt.setString(4, po.getOrigin());
			stmt.setString(5, po.getDestination());
			stmt.setString(6, po.getContainerNum());
			stmt.setString(7, po.getSupervisionMan());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}str=str.substring(0, str.length()-1);
			stmt.setString(8, str);
			stmt.setDouble(9, po.getCarriage());
			stmt.setString(10, po.getID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}


	@Override
	public String generateId(String date,String trancenId) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateTransferOrderId(date, trancenId);
	}

	@Override
	public TransferOrderlineitemPO getTransferOrderlineitemPO(String id) throws RemoteException {
		// TODO Auto-generated method stub
		llpo=new TransferOrderlineitemPO();
		String sql="select * from transferorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				llpo.setID(id);
			    llpo.setLoadingDate(rs.getString(2));
			    llpo.setTranType(TransportType.valueOf(rs.getString(3)));
			    llpo.setVehicleNum(rs.getString(4));
			    llpo.setDestination(rs.getString(6));
			    llpo.setCarriage(rs.getDouble(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llpo;
	}

}
