package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.UpdateUserRole;

@WebServlet("/uprole")
public class UpdateRole extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UpdateUserRole.toUpdateRole(LoginUser.getEmpno(), req);
		
		if (UpdateUserRole.result.equals("success")) {
			resp.sendRedirect("./update success");

		} else if (UpdateUserRole.result.equals("error")) {
			resp.sendRedirect("./updaterole.html");

		} else if (UpdateUserRole.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}

	}

}
