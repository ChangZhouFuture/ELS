package data.documentsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import data.utility.Database;
import po.documentsPO.DeliveryOrderPO;
import po.lineitemPO.documentslineitemPO.DeliveryOrderlineitemPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.DeliveryOrderdataservice;


public class DeliveryOrderdata extends UnicastRemoteObject implements DeliveryOrderdataservice {

	public DeliveryOrderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    DeliveryOrderPO po;
	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage addDeliveryOrder(DeliveryOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into deliveryorder(ID,arrivalDate,orderIDs,deliverier,generateTime)values(?,?,?,?,?))";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(4, po.getDeliverier());
			stmt.setString(5, po.getGenerateTime());
			String ids="";
			ArrayList<String> arr=po.getOrderIDs();
			for(int i=0;i<arr.size();i++){
				ids=ids+arr.get(i)+";";
			}
			ids=ids.substring(0, ids.length()-1);
			stmt.setString(3, ids);
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
		String sql="delete from deliveryorder where ID=?";
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
		String sql="delete from deliveryorder where ID=?";
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
		po=new DeliveryOrderPO();
		String sql="select * from deliveryorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<DeliveryOrderlineitemPO> findB(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(DeliveryOrderPO po) {
		// TODO Auto-generated method stub
		String sql="update deliveryorder se arrivalDate=?,orderIDs=?,deliverier=?,generateTime=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getArrivalDate());
			stmt.setString(3,po.getDeliverier() );
			stmt.setString(4, po.getGenerateTime());
			stmt.setString(5, po.getID());
			ArrayList<String> arr=po.getOrderIDs();
			String ids="";
			for(int i=0;i<arr.size();i++){
				ids=ids+arr.get(i)+";";
			}
			ids=ids.substring(0, ids.length()-1);
			stmt.setString(2, ids);
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
		
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		return null;
	}

}
