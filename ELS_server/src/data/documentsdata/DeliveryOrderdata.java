package data.documentsdata;

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
import po.documentsPO.DeliveryOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ApproState;
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
    JavaBean1 jb1;
    GenerateId g;
	@Override
	public OrderlineitemPO addOrder(String id) {
		// TODO Auto-generated method stub
		OrderlineitemPO orderllpo=new OrderlineitemPO();
		String sql="select * from order where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderllpo;
	}

	@Override
	public ResultMessage addDeliveryOrder(DeliveryOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into deliveryorder(ID,arrivalDate,orderIDs,deliverier,generateTime)values(?,?,?,?,?))";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setString(2, po.getArrivalDate());
			stmt.setString(3, po.getOrderID());
			stmt.setString(4, po.getDeliverier());
			stmt.setString(5, po.getGenerateTime());
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
		jb1=new JavaBean1();
		String sql="select * from deliveryorder where ID='"+id+"'";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			jb1.setResultMessage(ResultMessage.NotExist);
			if(rs.next()){ 
				po.setID(id);
				po.setArrivalDate(rs.getString(2));
				po.setOrderID(rs.getString(3));
				po.setDeliverier(rs.getString(4));
				po.setGenerateTime(rs.getString(5));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				jb1.setObject(po);
				jb1.setResultMessage(ResultMessage.Success);
				
			}return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jb1.setResultMessage(ResultMessage.NotExist);
			return jb1;
		}
	}

	@Override
	public JavaBean1 findB(String date) {
		// TODO Auto-generated method stub
		po=new DeliveryOrderPO();
		ArrayList<DeliveryOrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		String substr;
		
		String sql="select * from deliveryorder";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			jb1.setResultMessage(ResultMessage.NotExist);
			while(rs.next()){
				substr=rs.getString(5).substring(0, 10);
				if(substr.equals(date)&&rs.getString("approState").equals("NotApprove")){
					po.setID(rs.getString(1));
					po.setArrivalDate(rs.getString(2));
					po.setOrderID(rs.getString(3));
					po.setDeliverier(rs.getString(4));
					po.setGenerateTime(rs.getString(5));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(substr.equals(date)&&rs.getString("approState").equals("Approve")){
					po.setID(rs.getString(1));
					po.setArrivalDate(rs.getString(2));
					po.setOrderID(rs.getString(3));
					po.setDeliverier(rs.getString(4));
					po.setGenerateTime(rs.getString(5));
					po.setApproState(ApproState.valueOf(rs.getString("approState")));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
			}
			jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jb1.setResultMessage(ResultMessage.NotExist);
			return jb1;
		}
	}

	@Override
	public ResultMessage update(DeliveryOrderPO po) {
		// TODO Auto-generated method stub
		String sql="update deliveryorder se arrivalDate=?,orderIDs=?,deliverier=?,generateTime=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getArrivalDate());
			stmt.setString(2, po.getOrderID());
			stmt.setString(3,po.getDeliverier() );
			stmt.setString(4, po.getGenerateTime());
			stmt.setString(5, po.getID());
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
		return g.generateOrderId(date, "deliveryorder");
	}

}
