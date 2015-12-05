package data.orderdata;

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
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import dataservice.orderdataservice.Orderdataservice;
import state.ApproState;
import state.ExpressType;
import state.ResultMessage;

public class Orderdata extends UnicastRemoteObject implements Orderdataservice{

	Database db=new Database();
    Connection con=db.getConnection();
    PreparedStatement stmt;
    JavaBean1 jb1;
    OrderPO po;
    GenerateId g;
    
	public Orderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into order(ID,senderName,senderAdd,senderCompany,senderPhone,addresseeName,addresseeAdd,"
				+ "addresseeCompany,addresseePhone,numOfGoods,weight,size,goodName,expressType,numOfCatons,"
				+ "numOfWoodenBox,numOfBags,generateTime)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getSenderName());
			stmt.setString(3, po.getSenderAdd());
			stmt.setString(4, po.getSenderCompany());
			stmt.setString(5, po.getSenderPhoneNumber());
			stmt.setString(6, po.getAddresseeName());
			stmt.setString(7, po.getAddresseeAdd());
			stmt.setString(8, po.getAddresseeCompany());
			stmt.setString(9, po.getAddresseePhoneNumber());
			stmt.setInt(10, po.getNumOfGoods());
			stmt.setDouble(11, po.getWeight());
			stmt.setDouble(12, po.getSize());
			stmt.setString(13, po.getGoodsName());
			stmt.setString(14, po.getExpressType().toString());
			stmt.setInt(15, po.getNumOfCartons());
			stmt.setInt(16, po.getNumOfWoodenBox());
			stmt.setInt(17, po.getNumOfBags());
			stmt.setString(18, po.getGenerateTime());
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
		try {
			stmt=con.prepareStatement("DELETE FROM order WHERE ID=?");
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
	public ResultMessage deleteMany(ArrayList<String> idList){
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<idList.size();i++){
			stmt=con.prepareStatement("DELETE FROM order WHERE ID=?");
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
	public JavaBean1 findA(String id) {
		// TODO Auto-generated method stub
		po=new OrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String  sql="select * from order where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				po.setId(id);
				po.setSenderName(rs.getString(2));
				po.setSenderAdd(rs.getString(3));
				po.setSenderCompany(rs.getString(4));
				po.setSenderPhoneNumber(rs.getString(5));
				po.setAddresseeName(rs.getString(6));
				po.setAddresseeAdd(rs.getString(7));
				po.setAddresseeCompany(rs.getString(8));
				po.setAddresseePhoneNumber(rs.getString(9));
				po.setNumOfGoods(rs.getInt(10));
				po.setWeight(rs.getDouble(11));
				po.setSize(rs.getDouble(12));
				po.setGoodsName(rs.getString(13));
				po.setExpressType(ExpressType.valueOf(rs.getString(14)));
				po.setNumOfCartons(rs.getInt(15));
				po.setNumOfWoodenBox(rs.getInt(16));
				po.setNumOfBags(rs.getInt(17));
				po.setGenerateTime(rs.getString(18));
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
		po=new OrderPO();
		ArrayList<OrderPO> pos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String  sql="select * from order";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("generateTime").substring(0, 10).equals(date)
						&&rs.getString("approState").equals("NotApprove")){
					po.setId(rs.getString(1));
					po.setSenderName(rs.getString(2));
					po.setSenderAdd(rs.getString(3));
					po.setSenderCompany(rs.getString(4));
					po.setSenderPhoneNumber(rs.getString(5));
					po.setAddresseeName(rs.getString(6));
					po.setAddresseeAdd(rs.getString(7));
					po.setAddresseeCompany(rs.getString(8));
					po.setAddresseePhoneNumber(rs.getString(9));
					po.setNumOfGoods(rs.getInt(10));
					po.setWeight(rs.getDouble(11));
					po.setSize(rs.getDouble(12));
					po.setGoodsName(rs.getString(13));
					po.setExpressType(ExpressType.valueOf(rs.getString(14)));
					po.setNumOfCartons(rs.getInt(15));
					po.setNumOfWoodenBox(rs.getInt(16));
					po.setNumOfBags(rs.getInt(17));
					po.setGenerateTime(rs.getString(18));
					pos.add(po);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("generateTime").substring(0, 10).equals(date)
						&&rs.getString("approState").equals("Approve")){
					po.setId(rs.getString(1));
					po.setSenderName(rs.getString(2));
					po.setSenderAdd(rs.getString(3));
					po.setSenderCompany(rs.getString(4));
					po.setSenderPhoneNumber(rs.getString(5));
					po.setAddresseeName(rs.getString(6));
					po.setAddresseeAdd(rs.getString(7));
					po.setAddresseeCompany(rs.getString(8));
					po.setAddresseePhoneNumber(rs.getString(9));
					po.setNumOfGoods(rs.getInt(10));
					po.setWeight(rs.getDouble(11));
					po.setSize(rs.getDouble(12));
					po.setGoodsName(rs.getString(13));
					po.setExpressType(ExpressType.valueOf(rs.getString(14)));
					po.setNumOfCartons(rs.getInt(15));
					po.setNumOfWoodenBox(rs.getInt(16));
					po.setNumOfBags(rs.getInt(17));
					po.setGenerateTime(rs.getString(18));
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
	public ResultMessage update(OrderPO po) {
		// TODO Auto-generated method stub
		String sql="update order set senderName=?,senderAdd=?,senderCompany=?,senderPhone=?,"
				+ "addresseeName=?,addresseeAdd=?,addresseeCompany=?,addresseePhone=?,numOfGoods=?,"
				+ "weight=?,size=?,goodName=?,expressType=?,numOfCatons=?,numOfWoodenBox=?,numOfBags=?,"
				+ "generateTime=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getSenderName());
			stmt.setString(2, po.getSenderAdd());
			stmt.setString(3, po.getSenderCompany());
			stmt.setString(4, po.getSenderPhoneNumber());
			stmt.setString(5, po.getAddresseeName());
			stmt.setString(6, po.getAddresseeAdd());
			stmt.setString(7, po.getAddresseeCompany());
			stmt.setString(8, po.getAddresseePhoneNumber());
			stmt.setInt(9, po.getNumOfGoods());
			stmt.setDouble(10, po.getWeight());
			stmt.setDouble(11, po.getSize());
			stmt.setString(12, po.getGoodsName());
			stmt.setString(13, po.getExpressType().toString());
			stmt.setInt(14, po.getNumOfCartons());
			stmt.setInt(15, po.getNumOfWoodenBox());
			stmt.setInt(16, po.getNumOfBags());
			stmt.setString(17, po.getGenerateTime());
			stmt.setString(18, po.getId());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public OrderlineitemPO getOrderlineitemPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateIdOfOrder();
	}

}
