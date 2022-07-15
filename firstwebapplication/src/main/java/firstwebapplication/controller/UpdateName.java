package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.UpdateUserName;

@WebServlet("/upname")
public class UpdateName extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UpdateUserName.toUpdateName(LoginUser.getEmpno(), req);
		
		if (UpdateUserName.result.equals("success")) {
			resp.sendRedirect("./updatesuccessful.html");

		} 
	}
	

}
