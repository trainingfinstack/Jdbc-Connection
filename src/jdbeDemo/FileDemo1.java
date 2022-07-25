package jdbeDemo;

import java.sql.*;
import java.io.*;

public class FileDemo1 {

	public static void main(String[] args) {
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url="jdbc:mysql://localhost:3306/learn";
				String username="root";
				String password="root";
				Connection conn = DriverManager.getConnection(url, username, password);
			    
				String q= "Select fileid from person where id=1";
				
				PreparedStatement psmt = conn.prepareStatement(q);
				ResultSet r= psmt.executeQuery();
				
				if (r.next()) {
					Blob b = r.getBlob("fileid");
					byte bs[] = b.getBytes(1, (int)b.length());
					
					FileOutputStream f = new FileOutputStream("file2.txt");
					f.write(bs);
					f.close();
				}
				
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }

	}

}
