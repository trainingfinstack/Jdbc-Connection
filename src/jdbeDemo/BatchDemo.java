package jdbeDemo;

import java.sql.*;

public class BatchDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/learn";
			String username="root";
			String password="root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Statement st= conn.createStatement();
			st.addBatch("insert into student values(5,'ManishaR','New Delhi','India')");
			st.addBatch("insert into laptop values(5822,'HP',5)");
			st.addBatch("insert into student values(6,'ManishaRT','New Delhi','India')");
			
			st.executeBatch();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
