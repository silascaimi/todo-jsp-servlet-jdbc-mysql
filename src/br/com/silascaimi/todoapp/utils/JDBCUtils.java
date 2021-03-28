package br.com.silascaimi.todoapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

public class JDBCUtils {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/todoapp?serverTimezone=UTC";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "admin";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
				}
			}
		}
	}

	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}
}
