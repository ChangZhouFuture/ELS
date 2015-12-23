package data.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.JavaBean1;
import bean.JavaBean3;
import bean.JavaBean4;
import bean.JavaBean5;
import data.userdata.Logindata;
import data.utility.Database;
import po.stockPO.StockPO;
import state.ResultMessage;
import dataservice.stockdataservice.Stockdataservice;

public class Stockdata extends UnicastRemoteObject implements Stockdataservice{

	static final int Max_Size=2000;
	static final double percentage=0.9;
	Database db=new Database();
    Connection con=db.getConnection();
    Statement sm;
    PreparedStatement stmt;
    JavaBean1 jb1;
    JavaBean3 jb3;
    JavaBean4 jb4;
    StockPO po;
    
	public Stockdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public JavaBean3 stockCount(String date) {
		// TODO Auto-generated method stub
		jb3=new JavaBean3();
		po=new StockPO();
		ArrayList<StockPO> pos=new ArrayList<>();
		String sql="select * from batchnum";
		int batchNum;
		String lastNum;
		batchNum=0;
		String batch=date.substring(0,4)+date.substring(5,7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(date.equals(rs.getString("date"))){
					if(Integer.parseInt(rs.getString("batchNum"))>batchNum){
						batchNum=Integer.parseInt(rs.getString("batchNum"));
					}	
				}
			}batchNum++;
			lastNum=String.valueOf(batchNum);
			sql="insert into batchnum(date,batch,batchNum) values (?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, date);
			stmt.setString(2, batch);
			stmt.setString(3, lastNum);
			jb3.setBatch(batch);
			jb3.setBatchNum(lastNum);
			sql="select * from stock where tranCenID=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, Logindata.agencyId);
			ResultSet rs2=stmt.executeQuery();
			while(rs2.next()){
				po.setId(rs.getString(1));
				po.setInDate(rs.getString(3));
				po.setDestination(rs.getString(4));
				po.setAreaNum(rs.getString(5));
				po.setRowNum(rs.getString(6));
				po.setFrameNum(rs.getString(7));
				po.setPositionNum(rs.getString(8));
				pos.add(po);
			}
			jb3.setObject(pos);
			return jb3;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb3;
		}
		
		
	}


	@Override
	public JavaBean4 stockAlarm() {
		// TODO Auto-generated method stub
		String sql="select * from stock where tranCenID=?";
		ArrayList<String> areas=new ArrayList<>();
		jb4=new JavaBean4();
		jb4.setAlarm(false);
		int shipping=0;
		int trains=0;
		int trucks=0;
		int motor=0;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, Logindata.agencyId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("areaNum").equals("shipping")){
					shipping++;
				}else if(rs.getString("areaNum").equals("trains")){
					trains++;
				}else if(rs.getString("areaNum").equals("trucks")){
					trucks++;
				}else{
					motor++;
				}
			}
			if(shipping>Max_Size*percentage){
				areas.add("shipping");
				jb4.setAlarm(true);
			}
			if(trains>Max_Size*percentage){
				areas.add("trains");
				jb4.setAlarm(true);
			}
			if(trucks>Max_Size*percentage){
				areas.add("trucks");
				jb4.setAlarm(true);
			}
			if(motor>Max_Size*percentage){
				areas.add("motor");
				jb4.setAlarm(true);
			}jb4.setAlarmArea(areas);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jb4;
	}

	@Override
	public ResultMessage storage(StockPO po) {
		// TODO Auto-generated method stub
		String sql="insert into stock(ID,tranCenID,inDate,destination,areaNum,rowNum,frameNum,positionNum)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, Logindata.agencyId);
			stmt.setString(3, po.getInDate());
			stmt.setString(4, po.getDestination());
			stmt.setString(5, po.getAreaNum());
			stmt.setString(6, po.getRowNum());
			stmt.setString(7, po.getFrameNum());
			stmt.setString(8, po.getPositionNum());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
		
		
	}

	@Override
	public ResultMessage outBound(String id) {
		// TODO Auto-generated method stub
		String sql="delete from stock where ID=?,tranCenID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, Logindata.agencyId);
			stmt.executeUpdate();
			return ResultMessage.Success;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;

		}
	}

	@Override
	public ResultMessage adjustPartition(ArrayList<String> IDList, String area) throws RemoteException {
		// TODO Auto-generated method stub
		int count=0;
		try {
			stmt=con.prepareStatement("select * from stock where tranCenID=?");
			stmt.setString(1, Logindata.agencyId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("areaNum").equals(area)){
					count++;
				}
			}
			if(count+IDList.size()>Max_Size){
				return ResultMessage.Fail;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="update stock set areaNum=? where ID=?";
		try {
			for(int i=0;i<IDList.size();i++){
				stmt=con.prepareStatement(sql);
				stmt.setString(1, area);
				stmt.setString(2, IDList.get(i));
			}
			
			return ResultMessage.Success;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

}
