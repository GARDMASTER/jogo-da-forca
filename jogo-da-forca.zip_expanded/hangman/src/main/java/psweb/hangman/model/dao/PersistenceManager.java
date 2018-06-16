package psweb.hangman.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe Respons�vel pela cria��o da entidade manager, que poder� realizar acessos e modifica�oes no banco
 * 
 * @author Daniel Guinin, Giovanni Duarte
 * @since 1.0
 */
public class PersistenceManager {
	
	private static EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("PSWEBHangmanPU");
	private static EntityManager manager = factory.createEntityManager();
	
	static EntityManager getEntityManager(){
		return manager;
	}
	
	public static <T> GenericDAO<T> createGenericDAO(Class<T> t) {
		return new GenericDAO<T>(t, manager);
	}
	
	public static EntityTransaction getTransaction(){
		return manager.getTransaction();
	}
	
}
