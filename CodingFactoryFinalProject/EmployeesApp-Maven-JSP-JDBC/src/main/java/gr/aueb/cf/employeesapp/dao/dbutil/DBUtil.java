package gr.aueb.cf.employeesapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// CODES ARE PRESENTED HERE FOR EDUCATIONAL PURPOSES ONLY
			String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME?serverTimezone=UTC";
			String username = "YOUR_DATABASE_USERNAME";
			String password = "YOUR_DATABASE_PASSWORD";

			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}

