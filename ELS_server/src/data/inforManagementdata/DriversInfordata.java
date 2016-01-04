package data.inforManagementdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

import bean.JavaBean1;
import po.inforManagementPO.DriversPO;
import po.lineitemPO.inforManagementlineitemPO.DriverslineitemPO;
import state.Gender;
import state.ResultMessage;
import data.utility.Database;
import dataservice.inforManagementdataservice.DriversInfordataservice;

public class DriversInfordata extends UnicastRemoteObject implements DriversInfordataservice {
		Database db=new Database();
	    Connection con=db.getConnection();
	    PreparedStatement stmt;
	    DriversPO po;
	    JavaBean1 jb1;
	    
	    public DriversInfordata() throws RemoteException {
	    	super();
	    	// TODO Auto-generated constructor stub
	    }
    //增加新司机信息
	public ResultMessage add(DriversPO po){
		try {
			// “?” 即占位符
			stmt = con.prepareStatement("INSERT INTO driver(ID,name,birthDate,identyNum,phone,gender,DriveLimitDate,busiHallID)"
					+ " VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, po.getID());
		    stmt.setString(2, po.getName());
		    stmt.setString(3, po.getBirthDate());
		    stmt.setString(4, po.getIdentyNum());
		    stmt.setString(5, po.getPhone());
		    stmt.setString(6, po.getGender().toString());
		    stmt.setString(7, po.getDriveLimitDate());
		    stmt.setString(8, po.getBusiHallID());
		    stmt.executeUpdate();
		    return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}
	
	//查找司机信息
	public JavaBean1 findA(String Id){
		po = new DriversPO();
		jb1=new JavaBean1();
		jb1.setResultMessage(ResultMessage.NotExist);	
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM driver WHERE ID='"+Id+"'");
			
			 //大小写无区别，此处大写为区别表的名字，where表示条件
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()){
			    po.setID(Id);
		        po.setName(rs.getString("name"));
		        po.setBirthDate(rs.getString("birthDate"));
		        po.setIdentyNum(rs.getString("identyNum"));
		        po.setPhone(rs.getString("phone"));
		        po.setGender(Gender.valueOf(rs.getString("gender")));
		        po.setDriveLimitDate(rs.getString("driveLimitDate"));
		        po.setBusiHallID(rs.getString("busiHallID"));
		        jb1.setResultMessage(ResultMessage.Success);
		       
			}jb1.setObject(po);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}

	}
	
	//删除司机信息
	@Override
	public ResultMessage deleteMany(ArrayList<String> Ids) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<Ids.size();i++){
				stmt=con.prepareStatement("DELETE FROM driver WHERE ID=?");
			    stmt.setString(1, Ids.get(i));
			    stmt.executeUpdate();
			}
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	} 
	
	//修改司机信息
	public ResultMessage update(DriversPO po){
		con=db.getConnection();
		try {
			String sql=("UPDATE driver SET name=?,birthDate=?,identyNum=?,phone=?,gender=?,driveLimitDate=?,busiHallID=? WHERE ID=?");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, po.getName());
			stmt.setString(2, po.getBirthDate());
			stmt.setString(3, po.getIdentyNum());
			stmt.setString(4, po.getPhone());
			stmt.setString(5, po.getGender().toString());
			stmt.setString(6, po.getDriveLimitDate());
			stmt.setString(7, po.getBusiHallID());
			stmt.setString(8, po.getID());
			stmt.executeUpdate();
			return ResultMessage.Success;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NotExist;
		}
	}

	@Override
	public JavaBean1 findB(String busiHallId) throws RemoteException {
		// TODO Auto-generated method stub
		
		jb1=new JavaBean1();
		ArrayList<DriverslineitemPO> pos=new ArrayList<>();
		jb1.setResultMessage(ResultMessage.NotExist);	
		try {
			stmt = con.prepareStatement("SELECT * FROM driver WHERE busiHallId=?");
			stmt.setString(1, busiHallId);
			ResultSet rs=stmt.executeQuery(); 
			if(rs.next()){
				DriverslineitemPO llpo=new DriverslineitemPO();
			    llpo.setID(rs.getString("ID"));
		        llpo.setName(rs.getString("name"));
		        llpo.setPhone(rs.getString("phone"));
		        llpo.setGender(Gender.valueOf(rs.getString("gender")));
		        llpo.setDriveLimitDate(rs.getString("driveLimitDate"));
		        jb1.setResultMessage(ResultMessage.Success);
		        pos.add(llpo);
			}
			jb1.setObject(pos);
			return jb1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jb1;
		}
	}
	@Override
	public String generateID(String bisHallId) throws RemoteException {
		// TODO Auto-generated method stub
		String formatBusiHallId=bisHallId.substring(0, 3)+bisHallId.substring(4);
		int temp=0;
		int subId=0;
		String sql="select * from driver";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("ID").substring(0, 6).equals(formatBusiHallId)){
					subId=Integer.parseInt(rs.getString("ID").substring(6));
					if(subId>temp){
						temp=subId;
					}
				}
			}temp++;
			String last=String.valueOf(temp);
			int length=last.length();
			for(int i=0;i<3-length;i++){
				last="0"+last;
			}
			return formatBusiHallId+last;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
//	public static void main(String[] args) throws RemoteException {
//		DriversPO po=new DriversPO();
//		DriversInfordata df=new DriversInfordata();
//		po.setID("010001001");
//		po.setName("司机1");
//		po.setBirthDate("1991-01-01");
//		po.setPhone("12345678");
//		po.setBusiHallID("0101001");
//		po.setGender(Gender.MALE);
//		po.setDriveLimitDate("2016-09");
//		po.setIdentyNum("320212199101010511");
//		df.update(po);
//		JavaBean1 jb1=df.findA("010001001");
//		ArrayList<DriversPO> arr=(ArrayList<DriversPO>)jb1.getObject();
//		DriversPO po1=arr.get(0);
//		System.out.println(po.getBirthDate());
//		JavaBean1 jb11=df.findB("0101001");
//		ArrayList<DriverslineitemPO> arr2=(ArrayList<DriverslineitemPO>)jb11.getObject();
//		DriverslineitemPO llpo=arr2.get(0);
//		System.out.println(llpo.getName());
//	}
}
