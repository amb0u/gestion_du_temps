package login;

import java.sql.DriverManager;


import javax.swing.JOptionPane;
import java.sql.Connection;

public class MysqlConnect {
	 Connection conn = null;
	    public static Connection ConnectDb(){
	    
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ugesm","root","");
	            JOptionPane.showMessageDialog(null, "Connection Established");
	            return conn;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	   }
	}

}
