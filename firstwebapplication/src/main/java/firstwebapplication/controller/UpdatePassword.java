package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.UpdateUserPassword;

@WebServlet("/uppass")
public class UpdatePassword extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UpdateUserPassword.toUpdatePassword(LoginUser.getEmpno(), req);

		if (UpdateUserPassword.result.equals("success")) {
			resp.sendRedirect("./update success");

		} else if (UpdateUserPassword.result.equals("error")) {
			resp.sendRedirect("./update password");

		} else if (UpdateUserPassword.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}
	}

}
