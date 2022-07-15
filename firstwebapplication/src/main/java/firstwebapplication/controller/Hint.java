package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.HintUser;
import firstwebapplication.dao.LoginUser;
@WebServlet("/hint")
public class Hint extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HintUser.toEnsureHint(LoginUser.getEmpno(),req);
		
		if(HintUser.result.equals("success")) {
			resp.sendRedirect("./updatepassword.html");
		}else if (HintUser.result.equals("error")) {
			resp.sendRedirect("./hint.html");

		} else if (HintUser.result.equals("fail")) {
			resp.sendRedirect("./serverdown.html");

		}
	}

}
