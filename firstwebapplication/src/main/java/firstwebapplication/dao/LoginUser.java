package firstwebapplication.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import firstwebapplication.beans.EmpInfo;
import firstwebapplication.controller.Login;

public class LoginUser {
	
	private LoginUser() {
		
	}

	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	private static Integer empno;
	public static String status;

	public static void ensureLogin(EmpInfo emp, HttpServletRequest req) {

		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		try {
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();

			empno = Integer.parseInt(req.getParameter("id"));
			emp.setEmpno(empno);
			String fetch = "select empno,password from EmpInfo where empno = :user";

			Query query = em.createQuery(fetch);
			query.setParameter("user", emp.getEmpno());

			@SuppressWarnings("unchecked")
			List<Object[]> list = query.getResultList();

			if (!list.isEmpty()) {

				for (Object[] info : list) {

					emp.setPassword(req.getParameter("pass"));

					if (info[1].equals(emp.getPassword())) {

						Login.setResult("success");

					} else {

						Login.setResult("wrong credential");
					}
				}

			} else {

				Login.setResult("user not found");
			}

		} finally {
			try {
				if (em != null) {

					em.close();
				}
				if (emf != null) {

					emf.close();
				}

			} catch (Exception e) {
				status = "fail";
			}
		}

	}

	public static Integer getEmpno() {
		return empno;
	}

	public static void setEmpno(Integer empno) {
		LoginUser.empno = empno;
	}
}
