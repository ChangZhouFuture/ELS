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
import data.utility.Database;
import data.utility.TimeCompare;
import po.stockPO.StockPO;
import po.stockPO.StorageListPO;
import state.ResultMessage;
import dataservice.stockdataservice.Stockdataservice;

public class Stockdata extends UnicastRemoteObject implements Stockdataservice{

	static final int Max_Size=20000;
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
	public StockPO stockCheck(String startTime, String endTime) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public JavaBean3 stockCount(String generateTime) {
		// TODO Auto-generated method stub
		int temp=0;
		jb3=new JavaBean3();
		po=new StockPO();
		ArrayList<StockPO> pos=new ArrayList<>();
		TimeCompare tc=new TimeCompare();
		String sql="select * from batchnum";
		int batch,batchNum;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				String str1=generateTime.substring(0, 10);
				String str2=rs.getString("generateTime").substring(0, 10);
				if(tc.dateCompare(str1, str2)==3){
					batchNum=1;
					batch=Integer.parseInt(rs.getString("batch"))+1;
				}else{
					batch=Integer.parseInt(rs.getString("batch"));
					batchNum=Integer.parseInt(rs.getString("batchNum"))+1;
				}
			}else{
				batch=1;
				batchNum=1;
			}
			String b=String.valueOf(batch);
			String bn=String.valueOf(batchNum);
			for(int i=0;i<4-b.length();i++){
				b="0"+b;
			}
			for(int j=0;j<4-bn.length();j++){
				bn="0"+bn;
			}jb3.setBatch(b);
			jb3.setBatchNum(bn);
			sql="insert into batchnum(generateTime,batch,batchNum) values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, generateTime);
			stmt.setString(2, b);
			stmt.setString(3, bn);
			sql="select * from stock";
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				po.setId(rs.getString(1));
				po.setInDate(rs.getString(2));
				po.setDestination(rs.getString(3));
				po.setAreaNum(rs.getString(4));
				po.setRowNum(rs.getString(5));
				po.setFrameNum(rs.getString(6));
				po.setPositionNum(rs.getString(7));
				po.setGenerateTime(rs.getString(8));
				pos.add(po);
			}jb3.setObject(pos);
			return jb3;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb3;
		}
		
		
	}

	@Override
	public ResultMessage adjustPartition(String id,String area) {
		// TODO Auto-generated method stub
		String sql="update stock set areaNum=? where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, area);
			stmt.setString(2, id);
			return ResultMessage.Success;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public JavaBean4 stockAlarm() {
		// TODO Auto-generated method stub
		String sql="select * from stock";
		ArrayList<String> areas=new ArrayList<>();
		jb4=new JavaBean4();
		jb4.setIfAlarm(false);
		int shipping=0;
		int trains=0;
		int trucks=0;
		int motor=0;
		try {
			stmt=con.prepareStatement(sql);
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
				jb4.setIfAlarm(true);
			}
			if(trains>Max_Size*percentage){
				areas.add("trains");
				jb4.setIfAlarm(true);
			}
			if(trucks>Max_Size*percentage){
				areas.add("trucks");
				jb4.setIfAlarm(true);
			}
			if(motor>Max_Size*percentage){
				areas.add("motor");
				jb4.setIfAlarm(true);
			}jb4.setArea(areas);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jb4;
	}

	@Override
	public void storage(StorageListPO po) {
		// TODO Auto-generated method stub
		String sql="insert into stock(ID,inDate,destination,areaNum,rowNum,frameNum,positionNum,generateTime)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getId());
			stmt.setString(2, po.getInDate());
			stmt.setString(3, po.getDestination());
			stmt.setString(4, po.getAreaNum());
			stmt.setString(5, po.getRowNum());
			stmt.setString(6, po.getFrameNum());
			stmt.setString(7, po.getPositionNum());
			stmt.setString(8, po.getGenerateTime());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void outBound(String id) {
		// TODO Auto-generated method stub
		String sql="delete from stock where ID=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
