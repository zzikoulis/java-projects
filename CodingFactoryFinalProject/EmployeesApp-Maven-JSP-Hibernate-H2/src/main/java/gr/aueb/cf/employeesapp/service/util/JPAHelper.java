package gr.aueb.cf.employeesapp.service.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAHelper {

	private static EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	
	private JPAHelper() {}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if ( (emf == null) || (!emf.isOpen())) {
			emf = Persistence.createEntityManagerFactory("employeePU");
		}
		
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = threadLocal.get();
		
		if ( (em == null) || (!em.isOpen())) {
			em = getEntityManagerFactory().createEntityManager();
			threadLocal.set(em);
		}
		
		return em;
	}
	
	public static void closeEntityManager() {
		getEntityManager().close();
	}
	
	
	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	public static void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		getEntityManager().getTransaction().rollback();
	}
	
	public static void closeEMF() {
		emf.close();
	}
}
