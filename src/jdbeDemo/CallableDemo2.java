package jdbeDemo;

import java.sql.*;

public class CallableDemo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/learn";
			String username="root";
			String password="root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			//Function call	
			
				CallableStatement csmt = conn.prepareCall("{?=call representId(?)}");
				csmt.registerOutParameter(1, Types.VARCHAR);
				csmt.setInt(2, 1);
				csmt.execute();
				
				System.out.println(csmt.getString(1));
					    
		}
		catch(Exception e) {
			
		}

	}

}
