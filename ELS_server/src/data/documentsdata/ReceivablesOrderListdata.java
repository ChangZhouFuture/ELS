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
import po.documentsPO.ReceivablesOrderPO;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import state.ResultMessage;
import dataservice.documentsdataservice.ReceivablesOrderdataservice;

public class ReceivablesOrderListdata extends UnicastRemoteObject implements ReceivablesOrderdataservice{

	public ReceivablesOrderListdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    ReceivablesOrderPO po;
	@Override
	public ResultMessage add(ReceivablesOrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into receivablesorder(ID,amount,courier,orderIDs,date)values(?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getID());
			stmt.setDouble(2, po.getAmount());
			stmt.setString(3, po.getCourier());
			stmt.setString(4, po.getDate());
			ArrayList<String> arr=po.getOrderIDs();
			String str="";
			for(int i=0;i<arr.size();i++){
				str=str+arr.get(i)+";";
			}
			str=str.substring(0, str.length()-1);
			stmt.setString(5, str);
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
		String sql="delete from receivablesorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
		
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList) {
		// TODO Auto-generated method stub
		String sql="delete from receivablesorder where ID=?";
		try {
			for(int i=0;i<idList.size();i++){
				stmt=con.prepareStatement(sql);
				stmt.setString(1, idList.get(i));
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
		po=new ReceivablesOrderPO();
		String sql="select * from receivablesorder where ID='"+id+"'";
		jb1.setResultMessage(ResultMessage.NotExist);
		try {
			stmt=con.prepareStatement(sql);
		    ResultSet rs=stmt.executeQuery();
		    if(rs.next()){ 
		    	jb1.setResultMessage(ResultMessage.Success);
		    	po.setID(id);
			    po.setAmount(rs.getDouble(2));
			    po.setCourier(rs.getString(3));
			    po.setDate(rs.getString(5));
			    String str=rs.getString(4);
			    String[] s=str.split(";");
			    ArrayList<String> arr=new ArrayList<>();
			    for(int i=0;i<s.length;i++){
			    	arr.add(i, s[i]);
			    }
			    po.setOrderIDs(arr);
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
		po=new ReceivablesOrderPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		ArrayList<ReceivablesOrderPO> pos=new ArrayList<>();
		ArrayList<String> arr;
		String[] s;
		String sql="select * from receivablesorder where date='"+date+"'";
		
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				jb1.setResultMessage(ResultMessage.Success);
				po.setID(rs.getString(1));
				po.setAmount(rs.getDouble(2));
				po.setCourier(rs.getString(3));
				String str=rs.getString(4);
				s=str.split(";");
				arr=new ArrayList<>();
				for(int i=0;i<s.length;i++){
					arr.add(i, s[i]);
				}
				po.setOrderIDs(arr);
				po.setDate(date);
				pos.add(po);
			}
			jb1.setPOObject(pos);
			
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}

	@Override
	public ArrayList<OrderlineitemPO> generateOrder(String courierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double generateFreight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(ReceivablesOrderPO receivablesOrderPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		String sql="select * from receivablesorder where date='"+date+"'";
		String sub,subId;
		int x;
		int last=0;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(!rs.next()){
				return date+"0001";
			}
			while(rs.next()){
				sub=rs.getString(1).substring(8);
				x=Integer.parseInt(sub);
				if(x>last){
					last=x;
				}
			}
			subId=Integer.toString(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return date+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
