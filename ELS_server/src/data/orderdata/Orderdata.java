package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bean.JavaBean1;
import data.utility.Database;
import data.utility.GenerateId;
import po.lineitemPO.orderlineitemPO.OrderlineitemPO;
import po.orderPO.OrderPO;
import dataservice.orderdataservice.Orderdataservice;
import state.ApproState;
import state.ExpressArrivalStatus;
import state.ExpressType;
import state.ResultMessage;

public class Orderdata extends UnicastRemoteObject implements Orderdataservice{

	public Orderdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	Database db=new Database();
    Connection con=db.getConnection();
    PreparedStatement stmt;
    JavaBean1 jb1;
    OrderPO po;
    OrderlineitemPO llpo;
    GenerateId g;
    

	@Override
	public ResultMessage add(OrderPO po) {
		// TODO Auto-generated method stub
		String sql="insert into dingdanorder(ID,senderName,senderAdd,senderCompany,senderPhone,addresseeName,addresseeAdd,"
				+ "addresseeCompany,addresseePhone,goodName,numOfGoods,weight,size,freight,expressType,"
				+ "packingCharge,totalCost,expectedArrivalDate,date,expressArrivalStatus)values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			stmt.setString(10, po.getGoodsName());
			stmt.setInt(11, po.getNumOfGoods());
			stmt.setDouble(12, po.getWeight());
			stmt.setDouble(13, po.getSize());
			stmt.setDouble(14, po.getFreight());
			stmt.setString(15, po.getExpressType().toString());
			stmt.setDouble(16, po.getPackingCharge());
			stmt.setDouble(17, po.getTotalCost());
			stmt.setString(18, po.getExpectedArrivalDate());
			stmt.setString(19, po.getGenerateDate());
			stmt.setString(20, po.getExpressArrivalStatus().toString());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}

	@Override
	public ResultMessage deleteMany(ArrayList<String> idList){
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<idList.size();i++){
			stmt=con.prepareStatement("DELETE FROM dingdanorder WHERE ID=?");
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
		String  sql="select * from dingdanorder where ID=?";
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
				po.setPackingCharge(rs.getDouble(17));
				po.setTotalCost(rs.getDouble(18));
				po.setExpectedArrivalDate(rs.getString(19));
				po.setArrivalDate(rs.getString(20));
				po.setApproState(ApproState.valueOf(rs.getString("approState")));
				po.setGenerateDate(rs.getString("date"));
				po.setExpressArrivalStatus(ExpressArrivalStatus.valueOf(rs.getString("expressArrivalStatus")));
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
		
		ArrayList<OrderlineitemPO> llpos=new ArrayList<>();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);
		String  sql="select * from dingdanorder";
		try {
		    stmt=con.prepareStatement(sql);
		    ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				llpo=new OrderlineitemPO();
				if(rs.getString("date")!=null){
					if(rs.getString("date").equals(date)
							&&rs.getString("approState").equals("NotApprove")){
						llpo.setId(rs.getString("ID"));
						llpo.setGenerateDate(rs.getString("date"));
						llpo.setSenderAdd(rs.getString("senderAdd"));
						llpo.setAddresseeAdd(rs.getString("addresseeAdd"));
						llpo.setTotalCost(rs.getDouble("totalCost"));
						llpo.setExpressType(ExpressType.valueOf(rs.getString("expressType")));
						llpo.setApproState(ApproState.valueOf(rs.getString("approState")));
						llpo.setExpressArrivalStatus(ExpressArrivalStatus.valueOf(rs.getString("expressArrivalStatus")));
						llpos.add(llpo);
						jb1.setResultMessage(ResultMessage.Success);
					}
					if(rs.getString("date").equals(date)
							&&rs.getString("approState").equals("Approve")){
						llpo.setId(rs.getString("ID"));
						llpo.setGenerateDate(rs.getString("date"));
						llpo.setSenderAdd(rs.getString("senderAdd"));
						llpo.setAddresseeAdd(rs.getString("addresseeAdd"));
						llpo.setTotalCost(rs.getDouble("totalCost"));
						llpo.setExpressType(ExpressType.valueOf(rs.getString("expressType")));
						llpo.setApproState(ApproState.valueOf(rs.getString("approState")));
						llpo.setExpressArrivalStatus(ExpressArrivalStatus.valueOf(rs.getString("expressArrivalStatus")));
						llpos.add(llpo);
						jb1.setResultMessage(ResultMessage.Success);
					}
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
		String sql="update dingdanorder set senderName=?,senderAdd=?,senderCompany=?,senderPhone=?,"
				+ "addresseeName=?,addresseeAdd=?,addresseeCompany=?,addresseePhone=?,"
				+ "trueAddressee=?,goodName=?,numOfGoods=?,"
				+ "weight=?,size=?,freight=?,expressType=?,"
				+ "packingCharge=?,totalCost=?,expectedArrivalDate=?,trueArrivalDate=?,"
				+ "date=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(21, po.getId());
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
			stmt.setDouble(16, po.getPackingCharge());
			stmt.setDouble(17, po.getTotalCost());
			stmt.setString(18, po.getExpectedArrivalDate());
			stmt.setString(19, po.getArrivalDate());
			stmt.setString(20, po.getGenerateDate());
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
		llpo=new OrderlineitemPO();
		String sql="select * from dingdanorder where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				llpo.setId(rs.getString("ID"));
				llpo.setGenerateDate(rs.getString("date"));
				llpo.setSenderAdd(rs.getString("senderAdd"));
				llpo.setAddresseeAdd(rs.getString("addresseeAdd"));
				llpo.setTotalCost(rs.getDouble("totalCost"));
				llpo.setExpressType(ExpressType.valueOf(rs.getString("expressType")));
				llpo.setApproState(ApproState.valueOf(rs.getString("approState")));
				llpo.setExpressArrivalStatus(ExpressArrivalStatus.valueOf(rs.getString("expressArrivalStatus")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return llpo;
	}

	@Override
	public String generateId(String date) {
		// TODO Auto-generated method stub
		g=new GenerateId();
		return g.generateIdOfOrder(date);
	}

	@Override
	public ResultMessage receive(String id,String date, String trueAddresseeName) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="update dingdanorder set trueArrivalDate=?,trueAddressee=?,expressArrivalStatus=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(4, id);
			stmt.setString(1, date);
			stmt.setString(2, trueAddresseeName);
			stmt.setString(3, "Arrival");
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}


	public int daysBetween(String sDate,String eDate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(sDate));
		
	    long time1=cal.getTimeInMillis();
	    cal.setTime((sdf.parse(eDate))); 
	    long time2=cal.getTimeInMillis();
	    long between_days=(time2-time1)/(1000*24*3600) ;
	    return Integer.parseInt(String.valueOf(between_days)); 
	}
	
	public String getExpectedArrivalDate(String date,int day) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		int Year=cal.get(Calendar.YEAR);
		int Month=cal.get(Calendar.MONTH);
		int Day=cal.get(Calendar.DAY_OF_MONTH);
		int NewDay=Day+day;
		cal.set(Calendar.YEAR,Year);
		cal.set(Calendar.MONTH,Month);
		cal.set(Calendar.DAY_OF_MONTH,NewDay);
		long time=cal.getTimeInMillis();
		Date d=new Date(time);
		return String.valueOf(d);
	}

	@Override
	public String expectedArrivalDate(String date, String senderAdd, String addresseeAdd) throws RemoteException, ParseException {
		// TODO Auto-generated method stub
  
		String sql="select * from dingdanorder where senderAdd=?";
		String generateDate=null;
		String trueArrivalDate=null;
		int total=0;
		int count=0;
		int average=0;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, senderAdd);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("addresseeAdd").equals(addresseeAdd)){
					if(rs.getString("trueArrivalDate")!=null){
						trueArrivalDate=rs.getString("trueArrivalDate");
						generateDate=rs.getString("date");
						total=total+daysBetween(generateDate, trueArrivalDate);
						count++;
					}
				}
			}
			if(count!=0){
				average=total/count;
				return getExpectedArrivalDate(date, average);
			}else{
				return date;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return date;
		}	
	}

	@Override
	public double getOrderAmount(String orderID) throws RemoteException {
		String sql="select totalCost from dingdanorder where ID=?";
		double amount=0;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				amount=rs.getDouble("totalCost");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amount;
	}
	
//	public static void main(String[] args) throws RemoteException, ParseException {
//		Orderdata od=new Orderdata();
//		od.receive("1512240002", "2015-12-27", "实际收件人2");
//		OrderPO po=new OrderPO();
//		String e=od.expectedArrivalDate("2015-12-29", "上海", "南京");
//		System.out.println(e);
//		po.setExpectedArrivalDate(e);
//		po.setSenderName("寄件人c");
//		po.setSenderAdd("上海");
//		po.setSenderCompany("公司a");
//		po.setSenderPhoneNumber("1323156");
//		po.setAddresseeName("收件人c");
//		po.setAddresseeAdd("南京");
//		po.setAddresseeCompany("公司b");
//		po.setAddresseePhoneNumber("15664655");
//		po.setGoodsName("XXX");
//		po.setNumOfGoods(3);
//		po.setWeight(1);
//		po.setSize(2);
//		po.setFreight(1);
//		po.setId("1512290001");
//		po.setGenerateDate("2015-12-29");
//		po.setExpressType(ExpressType.Economic);
//		ResultMessage r=od.update(po);	
//	}
}
