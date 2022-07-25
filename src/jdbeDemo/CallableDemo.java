package jdbeDemo;

import java.sql.*;

public class CallableDemo {

	public static void main(String[] args) {
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 String url="jdbc:mysql://localhost:3306/learn";
				String username="root";
				String password="root";
				Connection conn = DriverManager.getConnection(url, username, password);
				
				//Stored procedure call	
				
				CallableStatement csmt = conn.prepareCall("{call Insertid(?)}");
				csmt.setInt(1, 3);
			    ResultSet rs= csmt.executeQuery();
			    
			    if (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("city")); 
				System.out.println(rs.getString("country"));
	    
			    }
			    
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }

	}

}
