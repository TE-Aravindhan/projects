package firstwebapplication.dao;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import firstwebapplication.beans.EmpInfo;
import firstwebapplication.utility.EmpNoAutoGenerate;

public class RegisterUser {
	
	private RegisterUser() {
		
	}

	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static EntityTransaction transaction = null;
	public static String result;

	public static void toRegister(HttpServletRequest req) {
		
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		try {
			EmpInfo info = new EmpInfo();

			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();

			transaction = em.getTransaction();
			transaction.begin();

			info.setEname(req.getParameter("name"));
			info.setHiredate(Date.valueOf(req.getParameter("doj")));
			info.setSalary(Double.parseDouble(req.getParameter("salary")));
			info.setRole(req.getParameter("role"));
			info.setDeptno(Integer.parseInt(req.getParameter("deptno")));
			info.setPassword(req.getParameter("password"));
			info.setHint(req.getParameter("hint"));
		
			EmpNoAutoGenerate.empNoGenerator();
			info.setEmpno(EmpNoAutoGenerate.getEmpno());

			em.persist(info);

			transaction.commit();
			
			result = "success";

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
