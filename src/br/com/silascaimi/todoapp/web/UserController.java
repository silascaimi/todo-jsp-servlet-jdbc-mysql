package br.com.silascaimi.todoapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.silascaimi.todoapp.dao.UserDao;
import br.com.silascaimi.todoapp.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lasName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		User employee = new User();
		employee.setFirstName(firstName);
		employee.setLastName(lasName);
		employee.setUsername(userName);
		employee.setPassword(password);

		try {
			int result = userDao.registerEmployee(employee);
			if (result == 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
	}

}
