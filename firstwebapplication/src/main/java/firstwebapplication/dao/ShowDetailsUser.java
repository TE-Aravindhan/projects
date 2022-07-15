package firstwebapplication.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import firstwebapplication.beans.EmpInfo;

public class ShowDetailsUser {
	
	private ShowDetailsUser() {
		
	}

	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	public static String result;
	
	

	public static void toShowDetails(Integer empno, HttpServletRequest req) throws IOException {

		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		
		try {
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();

			EmpInfo info = em.getReference(EmpInfo.class, empno);

			if (info != null) {
				req.setAttribute("empno", info.getEmpno());
				req.setAttribute("ename", info.getEname());
				String date =new SimpleDateFormat("dd/MM/yyyy").format(info.getHiredate());  
				req.setAttribute("doj", date);
				req.setAttribute("role", info.getRole());
				req.setAttribute("salary", info.getSalary());
				req.setAttribute("deptno", info.getDeptno());
			}
		}

		finally {
			try {
				if (em != null) {

					em.close();
				}
				if (emf != null) {

					emf.close();
				}

			} catch (Exception e) {
				result ="fail";
			}
		}
	}

}
