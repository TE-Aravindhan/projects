package firstwebapplication.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import firstwebapplication.beans.EmpInfo;

public class UpdateUserDeptno {

	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static EntityTransaction transaction = null;
	public static String result;

	public static void toUpdateDeptno(Integer empno, HttpServletRequest req) {
		
		try {
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();
			transaction =em.getTransaction();
			transaction.begin();
			EmpInfo info = em.getReference(EmpInfo.class, empno);
			info.setDeptno(Integer.parseInt(req.getParameter("deptno")));
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
