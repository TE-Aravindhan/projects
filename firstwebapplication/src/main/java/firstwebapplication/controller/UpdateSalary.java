package firstwebapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.UpdateUserSalary;

@WebServlet("/upsal")
public class UpdateSalary extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UpdateUserSalary.toUpdateSalary(LoginUser.getEmpno(), req);

		if (UpdateUserSalary.result.equals("success")) {
			resp.sendRedirect("./update success");

		} else if (UpdateUserSalary.result.equals("error")) {
			resp.sendRedirect("./updatesalary.html");

		} else if (UpdateUserSalary.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}

	}

}
