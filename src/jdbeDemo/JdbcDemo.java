package jdbeDemo;

import java.sql.*;
import java.io.*;

public class JdbcDemo {

	public static void main(String[] args) {
		
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. creating the connection
			String url="jdbc:mysql://localhost:3306/learn";
			String username ="root";
			String password ="root";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			if(con.isClosed()) {
				System.out.println("Connection is closed");
			}else
			{
				System.out.println("Connection is created...");
			}
			// 3. create a query
			String q= "select * from student";
			
	    	//4. create a statement
			PreparedStatement psmt = con.prepareStatement(q);
			
		ResultSet rst =	psmt.executeQuery();
			
			while(rst.next()) {
				System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getString(4));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
