package firstwebapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateDetails extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			switch (req.getParameter("field")) {
			case "Name": {
				resp.sendRedirect("./update name");
				break;
			}
			case "Salary": {
				resp.sendRedirect("./update salary");
				break;
			}

			case "Role": {
				resp.sendRedirect("./update role");
				break;
			}
			case "Deptno": {
				resp.sendRedirect("./update deptno");
				break;
			}
			case "Pass": {
				resp.sendRedirect("./hint");
				break;
			}
			case "0": {
				resp.sendRedirect("./update page");
				break;
			}
			default:
				resp.sendRedirect("./update page");
				break;
			}
			
		} catch (Exception e) {
			resp.sendRedirect("./serverdown.html");
		}
		
		
	}

}
