 package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstwebapplication.dao.LoginUser;
import firstwebapplication.dao.ShowDetailsUser;

@WebServlet("/details")
public class Showdetails extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			ShowDetailsUser.toShowDetails(LoginUser.getEmpno(), req);

			req.getRequestDispatcher("/your details").include(req, resp);

			
	}

}
