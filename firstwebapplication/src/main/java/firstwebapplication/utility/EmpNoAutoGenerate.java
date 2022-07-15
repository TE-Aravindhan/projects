package firstwebapplication.utility;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

public class EmpNoAutoGenerate {

	private EmpNoAutoGenerate() {
	}

	private static Integer empno;
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static HttpServletResponse resp;

	public static void empNoGenerator() throws IOException {

		try {
			//Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
			//LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();

			String fetch = "select max(empno) from EmpInfo";

			Query query = em.createQuery(fetch);

			Integer maxEmpno = (Integer) query.getSingleResult();

			if (maxEmpno == null) {
				setEmpno(1000);
			} else {
				setEmpno(maxEmpno+1);
			}

		} catch (Exception e) {
			resp.sendRedirect("./serverdown.html");

		} finally {

			try {
				if (em != null) {

					em.close();
				}
				if (emf != null) {

					emf.close();
				}

			} catch (Exception e) {
				resp.sendRedirect("./serverdown.html");

			}

		}
	}

	public static Integer getEmpno() {
		return empno;
	}

	public static void setEmpno(Integer empno) {
		EmpNoAutoGenerate.empno = empno;
	}
}
