package psweb.hangman.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 *  Classe Responsável pelo acesso ao dado das entidades de modo generico
 * 
 * @author Giovanni Duarte
 *
 * @since 1.0
 */

public class GenericDAO<T> {
	
	private EntityManager manager;
	private Class<T> t;
	
	/**
	 * Construtor de GenericDAO
	 * 
	 */
	GenericDAO(Class<T> t, EntityManager manager){
		this.t = t;
		this.manager = manager;
	}
	
	
	/**
	 * Busca todos objetos da entidade desejada
	 * 
	 * @return Lista de todos objetos de certa entidade
	 */
	public List<T> buscarTodos(){
		@SuppressWarnings("unchecked")
		List<T> lista = manager.createQuery("from " + t.getName()).getResultList();
				
		return lista;
	}
	
	/**
	 * Busca um objeto por ID
	 * 
	 * @return objeto buscado por ID
	 */
	public T buscar(Long id){
		return manager.find(t, id);
	}
	
	/**
	 * Inclui um objeto por entidade
	 * 
	 */
	public void incluir(T entidade){
		manager.persist(entidade);
	}
	
	/**
	 * Exclui um objeto por entidade
	 * 
	 */
	public void excluir(T entidade){
		manager.remove(entidade);
	}
	
	/**
	 * Altera um objeto por entidade
	 * 
	 */
	public void alterar(T entidade){
		manager.merge(entidade);
	}
	
	/**
	 * Busca a entidade manager
	 * 
	 * @return EntityManager
	 */
	public EntityManager getManager(){
		return manager;
	}
	
}
