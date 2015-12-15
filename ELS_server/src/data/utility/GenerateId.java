package data.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateId {

	Database db=new Database();
	Connection con=db.getConnection();
	PreparedStatement stmt;
	
	public String generateOrderId(String date,String orderName){
		String sql="select * from ?";
		String subId;
		int temp;
		int last=0;
		String formatDate=date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, orderName);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).substring(0, 8).equals(formatDate)){
					subId=rs.getString(1).substring(8);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=Integer.toString(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateTransferOrderId(String date,String trancenId){
		String sql="select * from transferorder";
		String subId;
		int temp;
		int last=0;
		String formatDate=date.substring(0, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString(1).substring(0, 15).equals(trancenId+formatDate)){
					subId=rs.getString(1).substring(15);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=Integer.toString(last);
			for(int i=0;i<7-subId.length();i++){
				subId="0"+subId;
			}
			return trancenId+formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateIdOfOrder(String date){
		String sql="select * from dingdanorder";
		String subId="";
		int temp;
		int last=0;
		String formatDate=date.substring(2, 4)+date.substring(5, 7)+date.substring(8, 10);
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(rs.getString("ID").substring(0, 6).equals(formatDate)){
					subId=rs.getString("ID").substring(6);
					temp=Integer.parseInt(subId);
					if(temp>last){
						last=temp;
					}
				}
			}last=last+1;
			subId=String.valueOf(last);
			for(int i=0;i<4-subId.length();i++){
				subId="0"+subId;
			}
			return formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
