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
    OrderlineitemPO llpo;
    GenerateId g;
    
	public Orderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage add(OrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into order(ID,senderName,senderAdd,senderCompany,senderPhone,addresseeName,addresseeAdd,"
				+ "addresseeCompany,addresseePhone,trueAddressee,goodName,numOfGoods,weight,size,freight,expressType,numOfCatons,"
				+ "numOfWoodenBox,numOfBags,packingCharge,totalCost,expectedArrivalDate,generateTime,date)values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			stmt.setString(10, po.getTrueAddressee());
			stmt.setString(11, po.getGoodsName());
			stmt.setInt(12, po.getNumOfGoods());
			stmt.setDouble(13, po.getWeight());
			stmt.setDouble(14, po.getSize());
			stmt.setDouble(15, po.getFreight());
			stmt.setString(16, po.getExpressType().toString());
			stmt.setInt(17, po.getNumOfCartons());
			stmt.setInt(18, po.getNumOfWoodenBox());
			stmt.setInt(19, po.getNumOfBags());
			stmt.setDouble(20, po.getPackingCharge());
			stmt.setDouble(21, po.getTotalCost());
			stmt.setString(22, po.getExpectedArrivalDate());
			stmt.setString(23, po.getGenerateTime());
			stmt.setString(24, po.getDate());
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
				po.setTrueAddressee(rs.getString(10));
				po.setGoodsName(rs.getString(11));
				po.setNumOfGoods(rs.getInt(12));
				po.setWeight(rs.getDouble(13));
				po.setSize(rs.getDouble(14));
				po.setFreight(rs.getDouble(15));
				po.setExpressType(ExpressType.valueOf(rs.getString(16)));
				po.setNumOfCartons(rs.getInt(17));
				po.setNumOfWoodenBox(rs.getInt(18));
				po.setNumOfBags(rs.getInt(19));
				po.setPackingCharge(rs.getDouble(20));
				po.setTotalCost(rs.getDouble(21));
				po.setExpectedArrivalDate(rs.getString(22));
				po.setGenerateTime(rs.getString(23));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				po.setDate(rs.getString("date"));
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
		llpo=new OrderlineitemPO();
		ArrayList<OrderlineitemPO> llpos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String  sql="select * from order";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("generateTime").substring(0, 10).equals(date)
						&&rs.getString("approState").equals("NotApprove")){
					llpo.setId(rs.getString("ID"));
					llpo.setDate(rs.getString("date"));
					llpo.setSenderAdd(rs.getString("senderAdd"));
					llpo.setAddresseeAdd(rs.getString("addresseeAdd"));
					llpo.setTotalCost(rs.getDouble("totalCost"));
					llpo.setExpressType(ExpressType.valueOf(rs.getString("expressType")));
					llpo.setApproState(ApproState.valueOf(rs.getString("approState")));
					llpos.add(llpo);
					jb1.setResultMessage(ResultMessage.Success);
				}
				if(rs.getString("generateTime").substring(0, 10).equals(date)
						&&rs.getString("approState").equals("Approve")){
					llpo.setId(rs.getString("ID"));
					llpo.setDate(rs.getString("date"));
					llpo.setSenderAdd(rs.getString("senderAdd"));
					llpo.setAddresseeAdd(rs.getString("addresseeAdd"));
					llpo.setTotalCost(rs.getDouble("totalCost"));
					llpo.setExpressType(ExpressType.valueOf(rs.getString("expressType")));
					llpo.setApproState(ApproState.valueOf(rs.getString("approState")));
					llpos.add(llpo);
					jb1.setResultMessage(ResultMessage.Success);
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
	public ResultMessage update(OrderPO po) {
		// TODO Auto-generated method stub
		String sql="update order set senderName=?,senderAdd=?,senderCompany=?,senderPhone=?,"
				+ "addresseeName=?,addresseeAdd=?,addresseeCompany=?,addresseePhone=?,"
				+ "trueAddressee=?,goodName=?,numOfGoods=?,"
				+ "weight=?,size=?,freight=?,expressType=?,numOfCatons=?,numOfWoodenBox=?,numOfBags=?,"
				+ "packingCharge=?,totalCost=?,ExpectedArrivalDate=?,generateTime=?,date=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(23, po.getId());
			stmt.setString(1, po.getSenderName());
			stmt.setString(2, po.getSenderAdd());
			stmt.setString(3, po.getSenderCompany());
			stmt.setString(4, po.getSenderPhoneNumber());
			stmt.setString(5, po.getAddresseeName());
			stmt.setString(6, po.getAddresseeAdd());
			stmt.setString(7, po.getAddresseeCompany());
			stmt.setString(8, po.getAddresseePhoneNumber());
			stmt.setString(9, po.getTrueAddressee());
			stmt.setString(10, po.getGoodsName());
			stmt.setInt(11, po.getNumOfGoods());
			stmt.setDouble(12, po.getWeight());
			stmt.setDouble(13, po.getSize());
			stmt.setDouble(14, po.getFreight());
			stmt.setString(15, po.getExpressType().toString());
			stmt.setInt(16, po.getNumOfCartons());
			stmt.setInt(17, po.getNumOfWoodenBox());
			stmt.setInt(18, po.getNumOfBags());
			stmt.setDouble(19, po.getPackingCharge());
			stmt.setDouble(20, po.getTotalCost());
			stmt.setString(21, po.getExpectedArrivalDate());
			stmt.setString(22, po.getGenerateTime());
			stmt.setString(23, po.getDate());
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
