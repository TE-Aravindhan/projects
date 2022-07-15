package firstwebapplication.dao;

import java.util.logging.Level;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import firstwebapplication.beans.EmpInfo;

public class HintUser {
	
	private HintUser() {
		
	}
	
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static EntityTransaction transaction = null;
	public static String result;

	public static void toEnsureHint(Integer empno, HttpServletRequest req) {

		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		try {
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();

			EmpInfo info = em.getReference(EmpInfo.class, empno);

			if (info != null) {
				if (req.getParameter("hint").equals(info.getHint())) {
					result = "success";
				}
			}
		} catch (Exception e) {

			transaction.rollback();
			
			result = "error";
			
		} finally {
			try {
				if (em != null) {

					em.close();
				}
				if (emf != null) {

					emf.close();
				}

			} catch (Exception e) {
				result = "fail";
			}
		}

	}
}
