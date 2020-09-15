package banco;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Bairro;

public class BairroBd implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("configDB");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void adicionar(Bairro bairro) {
		
		EntityManager em = getEntityManager();
		
		
		try {	
					
			em.getTransaction().begin();
			
			em.persist(bairro);
		
			em.getTransaction().commit();
			
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.toString());
			System.exit(0);
		}
		em.close();
		emf.close();
	}

	public Bairro buscaPeloBairro(String nomeBairro) {
		String jpql = "select u from Bairro u where u.nome = :nome";
		EntityManager em = getEntityManager();
		TypedQuery<Bairro> query = em.createQuery(jpql, Bairro.class);
		query.setParameter("nome", nomeBairro);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
