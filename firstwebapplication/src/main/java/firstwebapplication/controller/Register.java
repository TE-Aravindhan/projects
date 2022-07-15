package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.RegisterUser;
import firstwebapplication.utility.EmpNoAutoGenerate;

@WebServlet("/reg")
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RegisterUser.toRegister(req);
		
		if (RegisterUser.result.equals("success")) {
			req.setAttribute("empno", EmpNoAutoGenerate.getEmpno());
			req.getRequestDispatcher("./successful").include(req, resp);;

		} else if (RegisterUser.result.equals("error")) {
			resp.sendRedirect("./wronginsert.html");

		} else if (RegisterUser.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");
		}
	}
	
}
