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
				if(rs.getString(1).substring(0, 12).equals(trancenId+formatDate)){
					subId=rs.getString(1).substring(12);
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
			return formatDate+subId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateIdOfOrder(){
		String sql="select * from order";
		int temp;
		int last=0;
		String id;
		try {
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				temp=Integer.parseInt(rs.getString(1));
				if(temp>last){
					last=temp;
				}
			}last=last+1;
			id=String.valueOf(last);
			for(int i=0;i<10-id.length();i++){
				id="0"+id;
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
