package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.DeleteUser;
import firstwebapplication.dao.LoginUser;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DeleteUser.toDelete(LoginUser.getEmpno());
		
		if (DeleteUser.result.equals("success")) {
			resp.sendRedirect("./welcome.html");

		} else if (DeleteUser.result.equals("error")) {
			resp.sendRedirect("./function.html");

		} else if (DeleteUser.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}
	}

}
