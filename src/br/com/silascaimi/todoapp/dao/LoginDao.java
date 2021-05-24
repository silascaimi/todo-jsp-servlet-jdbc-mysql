package br.com.silascaimi.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.silascaimi.todoapp.model.LoginBean;
import br.com.silascaimi.todoapp.utils.JDBCUtils;

public class LoginDao {

	public boolean validate(LoginBean loginBean) {

		boolean status = false;
		String CONSULTA_USER_PASSWORD_SQL = "select * from users where username = ? and password = ?";

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CONSULTA_USER_PASSWORD_SQL);) {

			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}

		return status;
	}
}
