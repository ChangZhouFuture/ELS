package data.utility;

import  java.sql.*;

public class Database {
		Connection con;
        
        final String URL="jdbc:mysql://127.0.0.1:3306/information_store";
	
	public Database(){	
        try {
		    Class.forName("com.mysql.jdbc.Driver");        //����jdbc��������
		    con=DriverManager.getConnection(URL,"root","root");
		    System.out.println("�������ݿ�ɹ�");
	    } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    }
	}
	public Connection getConnection(){
		if (con==null) {
			System.out.println("�������ݿ�ʧ��");
			return null;
		} else {
			return con;
		}
	}
	
}
 