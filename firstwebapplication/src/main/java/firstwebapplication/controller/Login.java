package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.beans.EmpInfo;
import firstwebapplication.dao.LoginUser;

@WebServlet("/log")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LoginUser.ensureLogin(new EmpInfo(), req);

			switch (getResult()) {
			case "success":
				resp.sendRedirect("./mainmenu");
				break;
			case "wrong credential":
				resp.sendRedirect("./wrongcredential");
				break;
			case "user not found":
				resp.sendRedirect("./userdoesnotexist");
				break;

			default:
				resp.sendRedirect("./login");
				break;
			}
	}	

	public static String getResult() {
		return result;
	}

	public static void setResult(String result) {
		Login.result = result;
	}

}
