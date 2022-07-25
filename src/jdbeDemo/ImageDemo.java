package jdbeDemo;

import java.sql.*;
import java.io.*;

public class ImageDemo {

	public static void main(String[] args) {

     try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 
    	 String url="jdbc:mysql://localhost:3306/learn";
		 String username ="root";
		 String password ="root";
    	 Connection conn = DriverManager.getConnection(url, username, password);
    	 
    	 String q="select image from person where id=1";
    	 PreparedStatement pmst= conn.prepareStatement(q);
    	 ResultSet rst= pmst.executeQuery();
    	 
    	 if(rst.next()) {
    	 Blob b=rst.getBlob("image");
    	 byte bs[]=b.getBytes(1, (int)b.length());
    	  
    	 FileOutputStream f= new FileOutputStream("new.jpg");
    	 f.write(bs);
    	 f.close();
    	 }
     }
     catch(Exception e){
    	 e.printStackTrace();
     }

	}

}
