package firstwebapplication.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import firstwebapplication.beans.EmpInfo;

public class DeleteUser {
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static EntityTransaction transaction = null;
	static Scanner scanner = new Scanner(System.in);
	public static Object result;

	public static void toDelete(Integer empno) {

		try {
			emf = Persistence.createEntityManagerFactory("emp");
			em = emf.createEntityManager();
			transaction = em.getTransaction();

			transaction.begin();

			EmpInfo info = em.getReference(EmpInfo.class, empno);

			em.remove(info);

			transaction.commit();

			result="success";

		} catch (Exception e) {

			transaction.rollback();
			result="error";

		} finally {
			try {
				if (em != null) {

					em.close();
				}
				if (emf != null) {

					emf.close();
				}

			} catch (Exception e) {
				result="fail";
			}
		}
	}

}
