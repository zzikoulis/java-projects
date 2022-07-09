package gr.aueb.cf.schoolapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available - Helper-Utility Class
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
	
}
