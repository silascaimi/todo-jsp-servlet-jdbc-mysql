package br.com.silascaimi.todoapp.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException{
		
		Connection connection = JDBCUtils.getConnection();
		System.out.println("Conexão TODO aberta");
		connection.close();

	}

}
