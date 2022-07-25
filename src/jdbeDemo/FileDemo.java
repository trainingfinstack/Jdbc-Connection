package jdbeDemo;

import java.sql.*;
import java.io.*;

public class FileDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/learn";
			String username="root";
			String password="root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			String q="update person set fileid=? where id=1";
			
			PreparedStatement psmt= conn.prepareStatement(q);
			
			FileInputStream fin = new FileInputStream("C:\\Users\\User\\eclipse2021-03-workspace\\manisha\\src\\jdbeDemo\\file1.txt");
			psmt.setBlob(1, fin, fin.available());
			
		    int i= psmt.executeUpdate();
		    System.out.println(i);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
