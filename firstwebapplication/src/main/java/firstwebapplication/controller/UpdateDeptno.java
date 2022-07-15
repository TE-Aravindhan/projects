package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.UpdateUserDeptno;

@WebServlet("/updeptno")
public class UpdateDeptno extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UpdateUserDeptno.toUpdateDeptno(LoginUser.getEmpno(), req);

		if (UpdateUserDeptno.result.equals("success")) {
			resp.sendRedirect("./update success");

		} else if (UpdateUserDeptno.result.equals("error")) {
			resp.sendRedirect("./updatedeptno.html");

		} else if (UpdateUserDeptno.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}
	}

}
